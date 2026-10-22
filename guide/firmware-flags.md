# T5 Firmware Flags

> **Summary:** The flag surface of Trionic 5 splits in two layers. **Configurable flags** are one 6-byte calibration bitfield, [Pgm_mod](../reference/symbols/Pgm_mod.md) (ROM `0x4074E` → RAM `0x76E2`), which switches whole strategy branches on or off at flash time — there is no other programmable flag set in the image. **Runtime status flags** are RAM state words written by the strategy and read by everything downstream: [Pgm_status](../reference/symbols/Pgm_status.md) (engine state / cut requests), the knock status byte, the boost-loop status pair, cause-code and restart words. This page catalogs every flag documented for factory 4780656, what each one actually changes, and which subsystems react to it. Configured (factory) values verified byte-for-byte against `firmware/4780656_factory.BIN`; consuming code paths cited per row.

## Programmable feature flags — [Pgm_mod](../reference/symbols/Pgm_mod.md)

6 bytes at ROM `0x4074E`, copied to RAM `0x76E2` at init (`init_copy_inventory.factory.json` entry `{0x04074E, 0x76E2, 6}`); factory bytes `FB F6 EA D4 86 10` (verified at file offset `0x74E`). Every bit is read per-cycle by the branch owners below. There is **no E85 bit** — a fuel needing proportionally more mass (E85 stoichiometry ≈ 1.5× richer) is tuned by scaling [Inj_konst](../reference/symbols/Inj_konst.md), not by a flag.

### byte0 @ RAM `0x76E2` — factory `0xFB`

| Bit | Name | What it does | Interacts with | Factory |
| --- | --------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ------- |
| b0 | (unnamed) | Read by two fuel-path tests (`ANDI.B #$01` at `0x6F254`, `0x6F376`); no documented name | fuel duration chain | 1 |
| b1 | WOT enrichment | Gates the wide-open-throttle enrichment branch of the duration chain | [Fload_tab](../reference/symbols/Fload_tab.md) catalyst-enrichment map (+6…10 %, throttle-AD gated, 550–2400 rpm) | 1 |
| b2 | Injection delay-map interpolation | Selects an interpolated injection **angle** instead of the fixed constant: [Insp_vinkel](../reference/symbols/Insp_vinkel.md) = [Del_mat](../reference/symbols/Del_mat.md) × 3 instead of [Vinkel_konst](../reference/symbols/Vinkel_konst.md) = 53° | `Function_00069808` angle select (`0x69952`/`0x69962`); changes where in the intake stroke each pulse lands | **0** |
| b3 | (unnamed) | Tested `ANDI.B #$08` at `0x69B38` | injection scheduler area | 1 |
| b4 | (unnamed) | Tested `ANDI.B #$10` at `0x6AADE`, `0x70FB4` | — | 1 |
| b5 | Adaptation enable | Gates the lambda-driven learning machinery | [Adapt_korr](../reference/symbols/Adapt_korr.md) per-cell adaptation, [Adapt_injfaktor](../reference/symbols/Adapt_injfaktor.md) global adaptation | 1 |
| b6 | (unnamed) | Tested `ANDI.B #$40` at `0x6D2A6` | — | 1 |
| b7 | (unnamed) | Tested `ANDI.B #$80` at `0x6D8C8` | — | 1 |

*Bits 0, 3, 4, 6, 7 are consumed by the code but unnamed in the reference literature; do not flip them blind.*

### byte1 @ RAM `0x76E3` — factory `0xF6`

| Bit | Name | What it does | Interacts with | Factory |
|---|---|---|---|---|
| b0 | Constant injection time | Overrides the computed pulse with a fixed time | [Tid_konst](../reference/symbols/Tid_konst.md) override slot (duration-chain step 11) | 0 |
| b2 | Fuel cut | Enables the deceleration / fuel-save cut strategy | [Delay_cut](../reference/symbols/Delay_cut.md) entry timer, re-enable at [Open_varv](../reference/symbols/Open_varv.md) (1400 rpm), force-off below [Open_all_varv](../reference/symbols/Open_all_varv.md) (1000 rpm), [After_fcut_tab](../reference/symbols/After_fcut_tab.md) re-enrichment | 1 |
| b3 | Constant idle injection time | Forces the idle pulse to `0x2EE` = 750 × 4 µs = **3.0 ms** while the idle-status gate holds (`0x6E598`) | idle branch of the duration chain — a diagnostic/limp convenience, off at factory | 0 |
| b7 | Adaptation at closed throttle | Lets cell adaptation run on the closed-throttle (idle) cells | [Adapt_korr](../reference/symbols/Adapt_korr.md) bounds, idle global factor [Adapt_inj_imat](../reference/symbols/Adapt_inj_imat.md) | 1 |

### byte2 @ RAM `0x76E4` — factory `0xEA`

| Bit | Name | What it does | Interacts with | Factory |
|---|---|---|---|---|
| b1 | Separate idle fuel map | Selects the dedicated idle fuel map instead of the main VE map at idle | [Idle_fuel_korr](../reference/symbols/Idle_fuel_korr.md) (8 rpm × 12 load, applied as (v+128)/256), engagement counter [Com_on_idle](../reference/symbols/Com_on_idle.md) | **1** |

### byte3 @ RAM `0x76E5` — factory `0xD4`

| Bit | Name | What it does | Interacts with | Factory |
|---|---|---|---|---|
| b1 | Automatic transmission | Gates the whole `API_dt` (N→D engagement) + `API_ku` (kickdown shock cut) torque-intervention block (`0x76E5 & 2`) | retard word `0x390E` via `Function_00061F30`; with b1 clear (MT) the car instead gets the shift blip (`Function_00071F30`, [Shift_rpm](../reference/symbols/Shift_rpm.md) window). The automatic-only boost curves ([Tryck_mat_a](../reference/symbols/Tryck_mat_a.md), intake-temp cap) belong to the same transmission config but their read site is not separately documented | **0** = MT |

### byte4 / byte5 @ `0x76E6` / `0x76E7` — factory `0x86` / `0x10`

No documented bit meanings; no consumers traced. Treat as reserved.

## Runtime status flag words

### [Pgm_status](../reference/symbols/Pgm_status.md) — byte @ RAM `0x1041`
The engine-state word every cut path checks first.

| Bit | Meaning | Set when | Consumers / interactions |
|---|---|---|---|
| b0 | (tested in scheduler) | — | read `ANDI.B #$01` at `0x42FA8` (vector-path timing accounting) |
| b3 | **Engine running** | first combustion confirmed | cranking-vs-running branches: injection angle [Start_v_vinkel](../reference/symbols/Start_v_vinkel.md) 0° vs [Vinkel_konst](../reference/symbols/Vinkel_konst.md) 53°, warm-up stage transitions; gates fuel-cut paths `0x6C7F8`, `0x6CC00` |
| b5 | **Overboost** | averaged MAP [P_medel](../reference/symbols/P_medel.md) > [Tryck_vakt_tab](../reference/symbols/Tryck_vakt_tab.md) (factory 230 = 1.30 bar abs) | requests the overboost fuel cut, zeroes the boost PID integral, and penalizes [Apc_adapt](../reference/symbols/Apc_adapt.md) by −50 — a safety net on *actual* pressure, independent of the request chain |
| b7 | **Rev limit** | rpm > [Rpm_max](../reference/symbols/Rpm_max.md) (factory `0x0280` = 6400) | `Function_00071CEC`: scheduler clears the injector channel enables; [Rpm_dif](../reference/symbols/Rpm_dif.md) re-cut window produces the burst-cut pattern; misfire counting is inhibited while any cut is active |

### Injection group mode — `0x103B` bit 0
Set on lost crank-sync or a skipped cylinder. Downstream: [Insp_tid](../reference/symbols/Insp_tid.md) is halved and per-cylinder angle offsets are dropped (paired injectors fire together, each pulse half-width). Knock cylinder attribution (by ignition timing) degrades in this mode.

### [Knock_status](../reference/symbols/Knock_status.md) — byte @ RAM `0x1119`
**Resolved 2026-10-21 against the factory BIN (REA/Ghidra):** the embedded symbol-table record at ROM `0x53748` (format `[addr:2BE][len:2BE][name]\r\n`) reads `11 19 00 01 Knock_status`, and all three code references use operand `$1119` (`MOVEA.L #$1119,A0` at `0x62890`; `MOVE.B $1119,D1`/`ANDI.B #1` at `0x6DFA4`; `MOVEA.L #$1119,A4` at `0x72DCA`). `t5_symbols.csv`'s `0x111A` is an extraction artifact — the dump paired each name with the *next* table record's address (`0x111A` really is `Misftakeoff_ign_lim`); the older pages' `0x1D10` is `Knock_count_cyl4`. Byte-packed with [Multispark](../reference/symbols/Multispark.md) `0x1118`.

| Bit / flag | Meaning | Consumers / interactions |
|---|---|---|
| bit0 | Knock control active (per-window verdict over [Knock_ref_matrix](../reference/symbols/Knock_ref_matrix.md)) | Fuel: while set and load exceeds the knock-map first column, [Fuel_knock_mat](../reference/symbols/Fuel_knock_mat.md) *replaces* both VE factors for the cycle (factory peak ≈1.61×). Boost: the derate path runs off the same verdict through [Apc_decrese](../reference/symbols/Apc_decrese.md) |
| bit3 | Tested by the boost-chain function `Function_00072DC2` (`ANDI.B #$08`) | knock→boost coupling |
| escalation flag | [Knock_average](../reference/symbols/Knock_average.md) > [Knock_average_limit](../reference/symbols/Knock_average_limit.md) (rpm-scheduled ceiling [Knock_average_tab](../reference/symbols/Knock_average_tab.md)) | "sustained knock" — drives toward basic charge pressure; the logged cause is fuel quality or a weak DI cassette, not a tuning problem |

### [APC_status](../reference/symbols/APC_status.md) / [Regl_status2](../reference/symbols/Regl_status2.md) — word pair @ RAM `0x334B` / `0x334C`
Per-cycle flags of the boost control loop; both names resolve to the same pair in the symbol tables.

| Word.bit | Meaning | Interactions |
|---|---|---|
| 0x334B bit1 | Knock derate active | [Apc_decrese](../reference/symbols/Apc_decrese.md) > 0; feed-forward scaled by (100 − [Apc_decrese](../reference/symbols/Apc_decrese.md))/100; recovery −1 % per [Apc_knock_back](../reference/symbols/Apc_knock_back.md) ticks |
| 0x334B bit4 | Tip-in event | request-overshoot compensation path ([Overs_angle](../reference/symbols/Overs_angle.md) / [Overstid_tab](../reference/symbols/Overstid_tab.md) — factory disabled) |
| 0x334B bit6 | Load limit applied | gear ceilings [Regl_tryck_fgm](../reference/symbols/Regl_tryck_fgm.md) / [Regl_tryck_sgm](../reference/symbols/Regl_tryck_sgm.md) clamp [Regl_tryck](../reference/symbols/Regl_tryck.md) |
| 0x334B bit7 | Constant light-load flag | steady-window timer preset [Apc_konst_tid](../reference/symbols/Apc_konst_tid.md) (factory 255) — the window in which [Apc_adapt](../reference/symbols/Apc_adapt.md) learns |
| 0x334C bit6 | Gear limiter active | confirm-timer preset [Apc_cert_tid](../reference/symbols/Apc_cert_tid.md) (factory 0 = immediate) |
| 0x334C bit7 | Auto-stage request | automatic staging variant [Regl_tryck_fgaut](../reference/symbols/Regl_tryck_fgaut.md) (factory 255 = off) |

### [Limiter_cause](../reference/symbols/Limiter_cause.md) — word @ RAM `0x3FA2`
Records *why* the boost duty was clamped to its 2 % / 98 % bounds (clamp chain `0x73330`–`0x73470`). Known cause codes: `0x10` = reverse gear (forces 2 % duty directly), `8` = low speed / low battery ([DI_cassette_U_limit](../reference/symbols/DI_cassette_U_limit.md)). Below 1000 rpm and on sensor faults the clamp runs without a recorded code variant. Read by diagnostics — this is the word that answers "why am I at basic boost."

### [Restart_status](../reference/symbols/Restart_status.md) — byte @ RAM `0x1050`
Stall-while-running (restart) state, written `0x6EE48`–`0x6EED4`.

| Mask | Meaning | Interaction |
|---|---|---|
| `0x04` | Restart detected | switches to the restart fueling path |
| `0x10` | Armed | preconditions met for restart blend |
| `0x20` | Skip enrichment | set above [BS_temp](../reference/symbols/BS_temp.md) = 60 °C — a warm hot-restart gets **no** after-start enrichment |
| `0x80` | Restart seen | latched for the cycle |

Drives the `Restart_fak` blend (`0x6F23A`/`0x6F2C8`) and the injection-array flush; interacts with the whole warm-up stage machine.

### Single-byte flags

| Flag | RAM | What it does | Interactions |
|---|---|---|---|
| [Multispark](../reference/symbols/Multispark.md) | `0x1118` | Arms repeated sparks (~210/s) during cold low-rpm cranking: coolant < 0 °C and rpm < 850; set `0x63794`/`0x637B4` in `Function_00063712` | Ignition scheduler (spark trains between +300 counts and ATDC, [Mult_time](../reference/symbols/Mult_time.md)); **disables knock evaluation** while armed — spark ringing pollutes the ion band |
| [KillInjection](../reference/symbols/KillInjection.md) | (alias, disasm) | Immobilizer / limp **hard injection kill** — emits the no-pulse code at the TPU writers (`0x46EA6`, `0x4729C`) regardless of every other computation | overrides all fueling, cuts included; factory value 0 |
| Cap flag @ `0x39A6` | `0x39A6` | Set while knock retard is active | blocks the idle-torque ignition branch from advancing above the base/warm-up blend (end of the [Weight](../reference/symbols/Weight.md) map-blend word block) |
| [Start_dead](../reference/symbols/Start_dead.md) | (RAM) | Dead-pulse counter gate during cranking | **factory disabled** — [Start_dead_tab](../reference/symbols/Start_dead_tab.md) all zero |

### Diagnostic witnesses (flag-like state)

- [Knock_diag_level](../reference/symbols/Knock_diag_level.md) (SRAM `0x10FE`; earlier exports said `0x1100` = `Knock_wind_on`): raw ion-pulse count of the last window, the ion-line watchdog's witness. >50 pulses = line alive; ≤50 for 10 s with healthy battery and rpm ≥ 800 → latched fault `0x28`/`0x2C` + [Knock_frame](../reference/symbols/Knock_frame.md) error frame; clears after 1500 clean ignitions (`Function_0005C34A`). Watchdog sensitivity couples to battery voltage ([DI_cassette_U_limit](../reference/symbols/DI_cassette_U_limit.md) — ion amplitude sags with supply).
- Coolant sensor: the [Kyltemp_tab](../reference/symbols/Kyltemp_tab.md) AD rails double as fault markers; range checks at −40 / −20 / +95 °C set the diagnostic bit. On ADC failure the ECU substitutes fixed AD counts instead of a rail, and recovery is ramped so no fuel step appears.
- Intake-air sensor plausibility: differs from coolant by >10 °C **at start** (snapshot comparison [S_Lufttemp](../reference/symbols/S_Lufttemp.md) vs [Start_kylv](../reference/symbols/Start_kylv.md)) → flagged; emissions decisions deliberately consume the start snapshots, not live values.

### Present in the symbol table but not documented in the guide tree
`VSS_status`, `Purge_status`, `Cat_status`, `Airpump_status`, `TWFSSRstatus` — discrete/I-O status bytes with no bit-level documentation in the repo; treat as unpinned.

## Reading the flags together

- **Boost questions** start at [Limiter_cause](../reference/symbols/Limiter_cause.md) (was the duty clamped?) → `0x334B`/`0x334C` (which limiter/derate was active?) → [Pgm_status](../reference/symbols/Pgm_status.md) bit5 (did actual pressure breach?).
- **Knock questions**: [Knock_status](../reference/symbols/Knock_status.md) bit0 says the loop is active; the escalation flag says it is *sustained*; [Knock_diag_level](../reference/symbols/Knock_diag_level.md) says whether the sensor line is even alive before believing any of it.
- **Fueling that changes with a reflash**: compare the [Pgm_mod](../reference/symbols/Pgm_mod.md) bytes first — a branch that "does nothing" at factory (idle-time override, delay map, tip-in comp) becomes live when its bit is set.
- Flag meanings describe the **factory** image 4780656; differences introduced by commercial reflashes are out of scope here.

Related: [T5 Symbols](../reference/symbol-index.md) index · [T5 Boost Control](boost-control.md) · [T5 Fuel Injection](fuel-injection.md) · [T5 Knock Detection and Adaptation](knock-detection-and-adaptation.md) · [T5 Torque Intervention](torque-intervention.md) · [T5 Warmup Cycle and Temperature Inputs](warmup-cycle-and-temperature-inputs.md)
