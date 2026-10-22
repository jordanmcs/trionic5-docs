# Trionic 5.5 — Idle Air Control (Idle Control Valve)

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

> **Summary:** Idle speed on the NG900 T5.5 is held by a **separate idle control valve** (Swedish *regulerdon*; symbol namespace `Iv_*` = Idle Valve) driven by a linear PWM output — **not** by the throttle plate and **not** by the throttle-actuator misnomer that an early symbol name suggests. The command chain is: base position table [Iv_min_tab](../reference/symbols/Iv_min_tab.md) indexed by rpm → plus learned offset `Iv_min_offset` (a minimum-load integrator) → clamped 225…624 → written to PWM reload register `0xFFFFC4` scaled ×655/1000. In parallel, an rpm-governor path (nominal-speed tables + P/I corrections) adjusts the same actuator and the ignition idle angle. AC engagement raises both the speed target and the base position.

**Platform:** NG900 Saab 900/9-3, B204RM, OBD2. **Factory reference:** factory `4780656`.

**Terminology (user correction, 2026-10-20, verbatim):** "For clarification, it is not a throttle actuator, it is a seperate idle control valve." The symbol `Throttle_pwm_out` is a **misnomer** for the idle-valve PWM duty/period word; treat it as `Iv_pwm`. AD_trot is the throttle-position signal; nothing in this document implies ECU control of the throttle plate (cable-driven).

> **Correction notice:** an earlier draft of this document was produced by a research subagent and mixed verified chains with invented scales. This version is rebuilt from the decompiled blocks `F_0006F450`/`0x70044` (governor), `F_000709D4` (position block), `F_000691E6` (valve output stage) and the init-copy byte inventory.

---

## 1. The actuator and its command word

- **`Iv_position` (RAM 0x4762, word)** — commanded idle-valve position, range **225…624** ([LLS_min](../reference/symbols/LLS_min.md) = 0xE1 lower clamp; 0x270 = 624 upper clamp asserted at `0x709D4` tail, also checked at `0x59454`/`0x5C1CE`). The unit is an internal PWM-count-domain position; via the output scaling below it maps to valve duty.
- Mirrored to `PMProt_IdlePos` at `0x4CDB0` — this is what the OBD monitor-limit family `PMProt_IdlePos*` watches.
- Diagnostic override: when status byte 0x1137 bit 5 is set, the command word 0x1158 is forced to the caller-supplied setpoint (test-mode direct control, `0x709D4` entry branch).
- **Position → hardware:** `F_00046782` computes `reload = x·655/1000` (LSL/ADD sequence + `DIVU #271`) and writes peripheral register **`0xFFFFC4`** (MC68332 PWM). For the legal range that is 147…408 counts. This closes the previously open "Iv_position → duty conversion" question: the mapping is **linear**, no table.
- **Output stage `F_000691E6`** (idle-valve PWM state machine, mode word 0x39F2): in init/limp/diag modes it stages the valve duty by coolant temperature (20/30/40/50/60/70 %, diag fixed 80 % when `Diag_status` bit 7) through `F_000469FC(duty, reg)`, which programs the PWM period/duty pair (reload 0x0CCD−·; register block 0xFFFF94/0xFFFFC4). `Throttle_pwm_out` (misnomer, see above) holds the stage value; written at `0x69226`–`0x6929A`.

## 2. Position command block — `F_000709D4`

Decompiled logic (pseudocode `evidence/idleair_mine/func_0x709d4.pc.txt`):

1. **Base position:** `step = rpm_raw / 125` (raw rpm word 0x3C32); `base = (step)*2 + table`, table = **[Iv_min_tab](../reference/symbols/Iv_min_tab.md)** (54 words) or **[Iv_min_tab_ac](../reference/symbols/Iv_min_tab_ac.md)** (AC variant) selected by status bits (`0x1137` bit 6 / idle-fuel-branch bit `0x103A` bit 2). Factory: both tables start at 0x00DC (220) — the whole table's raw bytes are in `idle_tables.txt`.
2. **Minimum-load adaptation (`Iv_min_offset`, RAM 0x3460, clamp ±100):** an integrator that learns the extra position needed so that manifold load at the idle boundary stays at [Iv_min_load](../reference/symbols/Iv_min_load.md) (0x16 = 22 counts):
 - Conditions: idle-branch/temperature window (coolant byte between 0xC9 and 0xF9), vehicle-motion helper `F_000445AC` non-zero, stable-run counter 0x3A6A reaching [Iv_min_count](../reference/symbols/Iv_min_count.md) (5 confirmations).
 - If `P_Manifold > Iv_min_load` (load below target → valve needs to open): `Iv_min_offset += Iv_min_change` (3).
 - If load is above target and position exceeds the floor: `Iv_min_offset −= Iv_min_change`.
 - This is the compensation for carbon buildup at the idle bypass — "Idle valve min table" in the book glossary.
3. **Sum and clamps:** `Iv_position 0x4762 = base + Iv_min_offset`; command word 0x1158 = max(sum, caller floor), then `≤ 624`, `≥ LLS_min (225)`; finally `F_00046782` writes the PWM register (§1).
4. Start-up extras ([Iv_start_pos_offset](../reference/symbols/Iv_start_pos_offset.md) 50, [Iv_start_rpm_offset](../reference/symbols/Iv_start_rpm_offset.md) 20, [Iv_start_time_tab](../reference/symbols/Iv_start_time_tab.md)) are applied by the warmup path — see warmup doc.

## 3. Speed governor — nominal target + P/I correction

Region `F_0006F450`/`0x70044`–`0x703xx` (main task; verified in the independent-check pass):

- **Nominal idle speed 0x1156:** interpolated [Idle_rpm_tab](../reference/symbols/Idle_rpm_tab.md) (rpm/10 on coolant axis, warmup doc) **+** [Idle_start_extra](../reference/symbols/Idle_start_extra.md) ramp **+** AC terms ([Idle_ac_tab](../reference/symbols/Idle_ac_tab.md), [Idle_ac_extra_tab](../reference/symbols/Idle_ac_extra_tab.md)/`_sp`) **−** [Idle_temp_off](../reference/symbols/Idle_temp_off.md); limited by [Idle_ej_off](../reference/symbols/Idle_ej_off.md)-related gating (0x6FF00–0x6FF5C exclusion reads).
- **Dead band + update rate:** corrections only outside `Min_dead`/`Max_dead` around nominal; run rate divided by [Idle_update](../reference/symbols/Idle_update.md) (factory 0 = every pass), first correction delayed by `Delay`.
- **P path:** when rpm > nominal, decrement the correction words by `Idle_p_tab[|err| bin]`; **I path:** asymmetric [Idle_step_ioka](../reference/symbols/Idle_step_ioka.md)/[Idle_step_imns](../reference/symbols/Idle_step_imns.md) steps (factory 1); error-proportional sub-step `max(1, |nominal − rpm| / 4)` at `0x7026A`.
- Two correction stores exist: 0x4772/0x4776 — one feeds the **air** path (Iv), one the **ignition idle angle** (the ignition doc's idle dither word 0x4770; [Idle_drift_tab](../reference/symbols/Idle_drift_tab.md) swap at `0x6F9E0`/`0x6FA7A` selects the drift table vs the 280-word constant when load-based idle control is off). The fuel-idle vs air-idle split between 0x4772 and 0x4776 remains an open item.
- `Idle_medel_rpm` (averaged rpm) decides correction direction; [Idle_der_tab](../reference/symbols/Idle_der_tab.md) bounds the rpm-rate reaction.
- **Load-side interaction:** the idle *load* regulation constants `Last_reg_k` (fuel doc) plus [Idle_tryck](../reference/symbols/Idle_tryck.md) give the fuel-cut-load boundary; [Reg_last](../reference/symbols/Reg_last.md) thresholds (05 0F 1E 32) shape when load-based idle control takes over — documented under fuel.

## 4. Interactions

- **AC:** idle speed target and valve base position both step on compressor engagement (`Idle_ac_*` tables; [AC_const](../reference/symbols/AC_const.md)/[AC_slope](../reference/symbols/AC_slope.md)/[AC_delay](../reference/symbols/AC_delay.md) from torque doc; "Extra step for idle valve position when AC is turned on" — book glossary).
- **Brake-vacuum trim:** the same task computes the Br± trim (`0x707CC`) consumed by the fuel task — idle stability under brake pumping is shared air/fuel.
- **Misfire:** idle-quality misfires are counted, not acted on (misfire doc). The idle governor can't distinguish a misfiring idle; no enrichment/cut coupling exists.
- **AT configuration:** idle tables per transmission variant exist ([Idle_st_rpm](../reference/symbols/Idle_st_rpm.md)/[Idle_st_last](../reference/symbols/Idle_st_last.md) fuel-idle map pair already documented under fuel; AT flag selects map families per the [Pgm_mod](../reference/symbols/Pgm_mod.md) analysis).

## 5. Calibration table reference

Full raw bytes in **`idle_tables.txt`** (27 entries). Highlights:

| Table | Factory | Role |
|---|---|---|
| [Iv_min_tab](../reference/symbols/Iv_min_tab.md) / [Iv_min_tab_ac](../reference/symbols/Iv_min_tab_ac.md) | 54×word, base 220 | base valve position vs rpm/125 |
| [LLS_min](../reference/symbols/LLS_min.md) | 225 | minimum command |
| [Iv_min_count](../reference/symbols/Iv_min_count.md) / [Iv_min_load](../reference/symbols/Iv_min_load.md) / [Iv_min_change](../reference/symbols/Iv_min_change.md) | 5 / 22 / 3 | min-load integrator tuning |
| [Idle_rpm_tab](../reference/symbols/Idle_rpm_tab.md) | 8 words rpm/10, 90→… | idle speed target vs coolant |
| [Idle_drift_tab](../reference/symbols/Idle_drift_tab.md) | 310/280 | idle angle drift correction |
| [Idle_p_tab](../reference/symbols/Idle_p_tab.md), `Idle_step_imns/ioka`, [Idle_update](../reference/symbols/Idle_update.md), [Idle_start](../reference/symbols/Idle_start.md) | 00..04, 1, 1, 0, 5 | governor tuning |
| [Idle_ej_off](../reference/symbols/Idle_ej_off.md) | 0x00 | idle-engagement exclusion byte |
| [Idle_ac_tab](../reference/symbols/Idle_ac_tab.md), `Idle_ac_extra_tab/_sp` | 0x014a…, words | AC idle bumps |
| [Iv_start_pos_offset](../reference/symbols/Iv_start_pos_offset.md) / `_rpm_offset` / `_time_tab` | 50 / 20 / 8 words | start-up valve extra |


## 6. Open items

- Exact split of the two governor correction words (0x4772 vs 0x4776: which one lands on Iv vs idle ignition angle).
- [Idle_ej_off](../reference/symbols/Idle_ej_off.md) semantics ("idle not off") only partially mapped from the 0x6FF00 block reads.
- PWM register polarity/direction at 0xFFFFC4 (reload vs duty) — the ×655/1000 mapping is proven; whether larger count = more or less air follows from the 68332 PWM channel config at init (F_000467A6 block) and was not re-derived.

*Evidence: `evidence/idleair_mine/func_0x709d4.pc.txt` (position block), `idleair_independent_check.md` (governor pass), ASM (`0x709D4`, `0x691E6`–`0x69432`, `0x46782`, `0x4CDB0`, `0x59454`), `data/init_copy_inventory.factory.json`, book glossary (Idle valve family).*
