# T5 Idle Air Control

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

> **Summary:** Idle speed is held by a **separate idle control valve** (`Iv_*` namespace, Swedish *regulerdon*) on a linear PWM output — not the throttle plate (cable-driven) and not any "throttle actuator": the symbol `Throttle_pwm_out` is a confirmed misnomer for the idle-valve PWM word. Command chain: base position from [Iv_min_tab](../reference/symbols/Iv_min_tab.md) indexed by rpm/125, plus a learned minimum-load offset `Iv_min_offset` (±100), clamped [LLS_min](../reference/symbols/LLS_min.md)…624, then written linearly (×655/1000) to PWM reload register `0xFFFFC4`. A parallel rpm governor (nominal from [Idle_rpm_tab](../reference/symbols/Idle_rpm_tab.md) + AC and start-idle extras) trims with [Idle_p_tab](../reference/symbols/Idle_p_tab.md) proportional steps and ±1 integrator steps.

Working evidence: `source/idleair_system.md`, raw bytes `source/idle_tables.txt`, decompiles `t5-re/evidence/idleair_mine/`.

## Key facts

- **Position block `F_000709D4`:** `Iv_position (0x4762) = table[rpm/125] + Iv_min_offset`; table [Iv_min_tab](../reference/symbols/Iv_min_tab.md) or AC variant [Iv_min_tab_ac](../reference/symbols/Iv_min_tab_ac.md); clamps 225 ([LLS_min](../reference/symbols/LLS_min.md)) to 624; output scaling `F_00046782` = ×655/1000 → `0xFFFFC4`. Linear — no position→duty table.
- **Minimum-load adaptation:** integrator `Iv_min_offset` steps ±[Iv_min_change](../reference/symbols/Iv_min_change.md) after [Iv_min_count](../reference/symbols/Iv_min_count.md) confirmations so manifold load stays at [Iv_min_load](../reference/symbols/Iv_min_load.md) (22 counts) — carbon buildup compensation ("Idle valve min table", book glossary).
- **Governor:** nominal = [Idle_rpm_tab](../reference/symbols/Idle_rpm_tab.md) (warmup doc) + start-idle extras ([Idle_start_extra](../reference/symbols/Idle_start_extra.md) family) + AC bumps ([Idle_ac_tab](../reference/symbols/Idle_ac_tab.md), [Idle_ac_extra_tab](../reference/symbols/Idle_ac_extra_tab.md)) − [Idle_temp_off](../reference/symbols/Idle_temp_off.md); dead-band + [Idle_update](../reference/symbols/Idle_update.md) divider; asymmetric steps [Idle_step_ioka](../reference/symbols/Idle_step_ioka.md)/[Idle_step_imns](../reference/symbols/Idle_step_imns.md); drift correction [Idle_drift_tab](../reference/symbols/Idle_drift_tab.md).
- **Output stage `F_000691E6`:** mode machine on 0x39F2; init/limp/diag duties staged by coolant 20…70 %, diag fixed 80 %.
- **Interactions:** AC steps both target and base position; brake-vacuum trim shared with fuel task; start-up extras [Iv_start_pos_offset](../reference/symbols/Iv_start_pos_offset.md) family; `Iv_position` mirrored to `PMProt_IdlePos` for OBD monitors.

Related: [T5 Warmup Cycle and Temperature Inputs](warmup-cycle-and-temperature-inputs.md) (idle speed vs coolant) · [T5 Fuel Injection](fuel-injection.md) (idle load regulation, `Idle_fuel_korr`) · [T5 Symbols](../reference/symbol-index.md)
