
# T5 Symbols

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

Every symbol named in the subsystem explainers ([T5 Knock Detection and Adaptation](../guide/knock-detection-and-adaptation.md), [T5 Warmup Cycle and Temperature Inputs](../guide/warmup-cycle-and-temperature-inputs.md), [T5 Ignition Timing](../guide/ignition-timing.md), [T5 Boost Control](../guide/boost-control.md), [T5 Fuel Injection](../guide/fuel-injection.md), [T5 Torque Intervention](../guide/torque-intervention.md), [T5 Misfire Detection](../guide/misfire-detection.md), [T5 Idle Air Control](../guide/idle-air-control.md)) has a page here. 

**Current count: 361 symbol pages** (count the `Symbols/` folder to verify; regenerated 2026-10-21). ROM addresses are flash sources; `!`-suffix disassembly names denote RAM copies. Evidence tree: the t5-re research workspace.

### Calibration — detection & retard

| Symbol | Type | Address | Function |
| ----------------------- | ---------------------------------- | --------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| [Knock_reduce](symbols/Knock_reduce.md) | Calibration word | ROM 0x417DA | Retard increment added to a cylinder's ignition offset on each confirmed knock event. |
| [Knock_back](symbols/Knock_back.md) | Calibration word | ROM 0x417DC | Recovery rate: spark advance returned to a cylinder each knock-free control period. |
| [Knock_lim_tab](symbols/Knock_lim_tab.md) | Calibration table, 16 words × rpm | ROM 0x417DE | Maximum per-cylinder knock retard at each rpm point: 3.0° idle, 13.0° at ~2500, 9.0° at redline |
| [Knock_matrix_time](symbols/Knock_matrix_time.md) | Calibration word | ROM 0x428B8 | Hold/refresh period for knock reference matrix bookkeeping (matrix re-interpolated and offset decay windows advance on t |
| [Knock_ref_matrix](symbols/Knock_ref_matrix.md) | Calibration map, 288 words | ROM 0x428BA | Expected window pulse count per rpm/load cell — the per-window knock threshold grid |
| [Lknock_oref_tab](symbols/Lknock_oref_tab.md) | Calibration table, 16 words × rpm | ROM 0x42AFA | Percentage trim scaling [Knock_ref_matrix](symbols/Knock_ref_matrix.md) before comparison. |
| [Knock_press_tab](symbols/Knock_press_tab.md) | Calibration table, 16 words × rpm | ROM 0x42B1A | Base table for the minimum manifold-pressure gate: knock evaluation only above the interpolated value. |
| [Knock_press_limit](symbols/Knock_press_limit.md) | Runtime word | derived from [Knock_press_tab](symbols/Knock_press_tab.md) | Live interpolated threshold: evaluation skipped while P_Manifold is at or below it — suppresses knock judgement at part |
| [Turbo_knock_tab](symbols/Turbo_knock_tab.md) | Calibration table, 16 words × rpm | ROM 0x42B3A | Interpolated by rpm in the knock-scaling path near boost control; magnitude suggests ~1.1–1.2× scaling under boost |
| [Knock_average_tab](symbols/Knock_average_tab.md) | Calibration table, 16 words × rpm | ROM 0x42B5A | Escalation limits: rpm-scheduled ceiling for [Knock_average](symbols/Knock_average.md) before the sustained-knock status flag sets. |
| [Knock_average_limit](symbols/Knock_average_limit.md) | Runtime word | derived from [Knock_average_tab](symbols/Knock_average_tab.md) | Live comparison threshold for the four-cylinder average offset; exceeding it sets the documented [Knock_status](symbols/Knock_status.md) "average > |
| [Knock_wind_rpm](symbols/Knock_wind_rpm.md) | Calibration axis, 16 words | ROM 0x42B7A | rpm axis shared by the detection-window edge tables. |
| [Knock_wind_on_tab](symbols/Knock_wind_on_tab.md) | Calibration table, 16 words × rpm | ROM 0x42B9A | Detection-window opening, in 0.1° after the spark reference (30.0°–45.0° advanced by rpm). |
| [Knock_wind_off_tab](symbols/Knock_wind_off_tab.md) | Calibration table, 16 words × rpm | ROM 0x42BBA | Detection-window closing (60.0°–75.0° after spark) — brackets the ion/combustion phase. |
| [Detect_map](symbols/Detect_map.md) | Calibration mask, 18 load × 16 rpm | ROM 0x42144 (x-axis 0x42100 load 32–212; y-axis 0x42124 rpm 880–6010) | Where knock evaluation is permitted at all |
| [Knock_start](symbols/Knock_start.md) | Calibration word | ROM 0x40512 | Monitor-start engine speed for knock supervision bookkeeping. |
| [Knock_ang_dec](symbols/Knock_ang_dec.md) | Calibration word | ROM 0x42874 | Step size for angle-based retard reduction paths. |

### Calibration — boost interface & adaptation

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Fuel_knock_mat](symbols/Fuel_knock_mat.md) | Calibration map, 192 B | ROM 0x409F4 | Fuel enrichment applied while knock control is active ([Pgm_status](symbols/Pgm_status.md) "Knock fuel map activated") |
| [Apc_knock_tab](symbols/Apc_knock_tab.md) | Calibration table, 8 bytes | ROM 0x40AC0 | Boost-derate increment per knock event, percentage points, into [Apc_decrese](symbols/Apc_decrese.md). |
| [Apc_knock_back](symbols/Apc_knock_back.md) | Calibration byte | ROM 0x42EAA | Boost-derate recovery rate, % per period |
| [Apc_frek](symbols/Apc_frek.md) | Calibration byte | ROM 0x4153E | Optional knock-signal frequency threshold for a boost-module monitoring branch |
| [Apc_decrese_asp](symbols/Apc_decrese_asp.md) | Calibration byte | per init map | Derate variant applied during ASP/torque-intervention states (speed/gear gated). |
| [Kadapt_max_ref](symbols/Kadapt_max_ref.md) | Calibration table, 11 words | ROM 0x42856 | Ceiling for the window-count / reference ratio used in evaluation, indexed (rpm−150)/32+1 (rpm/10): 3.15× low-rpm → 1.66 |
| [Kadapt_period](symbols/Kadapt_period.md) | Calibration word | ROM 0x42872 | Timeout for an interrupted K-adapt sampling session: conditions lapsed and Diag_tid past start+320 resets the state mach |
| [Kadapt_rpm_low](symbols/Kadapt_rpm_low.md) | Calibration word | ROM 0x4286E | Lower rpm bound of the K-adapt learning window. |
| [Kadapt_rpm_high](symbols/Kadapt_rpm_high.md) | Calibration word | ROM 0x4286C | Upper rpm bound of the K-adapt learning window. |
| [Kadapt_load_low](symbols/Kadapt_load_low.md) | Calibration byte | ROM 0x42871 | Lower load bound of the K-adapt learning window. |
| [Kadapt_load_high](symbols/Kadapt_load_high.md) | Calibration byte | ROM 0x42870 | Upper load bound of the K-adapt learning window. |

### Temperature tables (context: not knock)

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Tempkomp_konst](symbols/Tempkomp_konst.md) | Calibration table, 15 B | ROM 0x408AB | Warm-up enrichment ramp coefficient — NOT a knock table despite appearing in knock research |
| [Eftersta_fak](symbols/Eftersta_fak.md) | Calibration table, 15 B | ROM 0x4086D | Post-cranking warm-up enrichment factor |
| [Eftersta_fak2](symbols/Eftersta_fak2.md) | Calibration table, 15 B | ROM 0x4087C | Secondary post-cranking enrichment factor |
| [Eft_dec_fak](symbols/Eft_dec_fak.md) | Calibration table, 15 B | ROM 0x4088B | Cold-deceleration enrichment factor |
| [Eft_dec_fak2](symbols/Eft_dec_fak2.md) | Calibration table, 15 B | ROM 0x4089A | Secondary cold-decel factor |
| [Retard_temp](symbols/Retard_temp.md) | Calibration table, 15 B | ROM 0x40B14 | Warm-up/idle ignition-retard multiplier indexed by coolant — NOT knock retard, despite the name |
| [Startvev_fak](symbols/Startvev_fak.md) | Calibration table, 15 B | ROM 0x4085E | Cranking enrichment factor vs coolant |
| [Kyl_temp](symbols/Kyl_temp.md) | State byte | (derived from [AD_kylv](symbols/AD_kylv.md)) | Coolant temperature used by the knock gates: detection enabled above 40 °C (0x60EB2, force-enabled if sensor diag bit 0x |
| [DI_cassette_U_limit](symbols/DI_cassette_U_limit.md) | Calibration byte | per init map | Battery-voltage floor for ion-path fault judgement: the no-signal watchdog abstains while system voltage is below it, si |

### Calibration axes

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Ign_map_0_y_axis](symbols/Ign_map_0_y_axis.md) | Axis, 16 w | ROM 0x4184A | rpm axis proven for the 16-word knock tables (lim/turbo/average/press/oref) and ref_matrix rows |
| [Ign_map_0_x_axis](symbols/Ign_map_0_x_axis.md) | Axis, 18 w | ROM 0x41826 | load axis of [Knock_ref_matrix](symbols/Knock_ref_matrix.md) interpolation |
| [Detect_map_x_axis](symbols/Detect_map_x_axis.md) | Axis, 18 w | ROM 0x42100 | load axis of [Detect_map](symbols/Detect_map.md) |
| [Detect_map_y_axis](symbols/Detect_map_y_axis.md) | Axis, 16 w | ROM 0x42124 | rpm axis of [Detect_map](symbols/Detect_map.md) |
| [Temp_steg](symbols/Temp_steg.md) | Axis, 15 B | ROM 0x40B24 | raw coolant-AD axis of the warm-up/fuel table family (not knock) |

### Runtime state

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Knock_level](symbols/Knock_level.md) | State word | RAM 0x1D0C | Current per-window pulse count |
| [Knock_count](symbols/Knock_count.md) | State word | RAM 0x1D0E | Knock event counter in the knock state block. |
| [Knock_status](symbols/Knock_status.md) | State byte | RAM 0x1D10 | Knock status bits incl |
| [Knock_diag](symbols/Knock_diag.md) | State word | RAM 0x1D14 | Knock diagnostics accumulator updated per window alongside [Knock_diag_level](symbols/Knock_diag_level.md). |
| [Knock_retard](symbols/Knock_retard.md) | State word | RAM 0x1D16 | Currently applied knock retard (reported value). |
| [Knock_diag_level](symbols/Knock_diag_level.md) | State byte | SRAM 0x1100 | Raw pulse count of the last evaluated window, written unconditionally every window |
| [Knock_error](symbols/Knock_error.md) | State word | RAM 0x2116 | Knock error code storage in the diagnostics block. |
| [Knock_time_low](symbols/Knock_time_low.md) | State word | RAM 0x2108/0x210A | No-signal duration timer for the ion-path watchdog; latches fault past the 10 s threshold |
| [Knock_frame](symbols/Knock_frame.md) | State block | RAM 0x293A | Error-frame snapshot (25 longs) captured when the ion-path fault latches — the knock-line diagnostic black box. |
| [Knock_average](symbols/Knock_average.md) | State word | RAM, computed 0x62A28 | Mean of the four cylinder retard offsets; compared against [Knock_average_limit](symbols/Knock_average_limit.md) for sustained-knock escalation. |
| [Spik_count](symbols/Spik_count.md) | State word | per cylinder | The per-window knock verdict from evaluation; feeds the 5-slot ring buffer the offset engine consumes. |
| [Ret_mangd](symbols/Ret_mangd.md) | State byte | per cylinder | Retard demand output of the offset engine, consumed by the ignition scheduler and applied to dwell/spark timing |
| [Lret_mangd](symbols/Lret_mangd.md) | State byte | per cylinder | Companion to [Ret_mangd](symbols/Ret_mangd.md) in the retard-demand pair handled by the same scheduler queue. |
| [Apc_decrese](symbols/Apc_decrese.md) | State word | RAM | Global knock boost derate: +8 % per knock event ([Apc_knock_tab](symbols/Apc_knock_tab.md)), recovered at [Apc_knock_back](symbols/Apc_knock_back.md) per period; applied as subt |
| [Regl_tryck](symbols/Regl_tryck.md) | State word | RAM | The boost PID's target charge pressure |
| [Knock_ref_level](symbols/Knock_ref_level.md) | State long | RAM 0x4622 | Denominator of the per-window count/reference ratio: 0x3892 factor × [Kadapt_ref_value_actual](symbols/Kadapt_ref_value_actual.md), computed at init (0x4EC12- |
| [Kadapt_ref_value_actual](symbols/Kadapt_ref_value_actual.md) | State word | RAM | The live knock-reference baseline the ECU self-calibrates: creeps ±1/±2/±10 per completed learning session toward the sa |
| [Kadapt_ref_value](symbols/Kadapt_ref_value.md) | State word | RAM | Fresh learning-session target computed from the 100 stored samples; the value [Kadapt_ref_value_actual](symbols/Kadapt_ref_value_actual.md) creeps toward. |
| [Kadapt_counter](symbols/Kadapt_counter.md) | State word | RAM | Samples collected in the current K-adapt learning session; 100 completes a run (lockout bit 0x3886:0x40). |

## Warmup cycle and temperature inputs

Entry: [T5 Warmup Cycle and Temperature Inputs](../guide/warmup-cycle-and-temperature-inputs.md) · evidence: [warmup_system](../evidence/warmup_system.md) · raw: `source/warmup_tables.txt`. The [Temp_steg](symbols/Temp_steg.md) axis page (above) belongs to this family too. Values on these pages reference the factory 4780656 image.

### Warmup sensors and inputs

| Symbol | Type | Address | Function |
|---|---|---|---|
| [AD_kylv](symbols/AD_kylv.md) | State byte (RAM) | (RAM) | Copied from AD buffer 0x4054 each measurement cycle; substituted on AD-converter failure |
| [AD_lufttemp](symbols/AD_lufttemp.md) | State byte (RAM) | (RAM) | Copied from AD buffer 0x4052; substituted on failure |
| [Kyl_temp](symbols/Kyl_temp.md) | State byte (RAM) | (derived from [AD_kylv](symbols/AD_kylv.md)) | Coolant temperature used by the knock gates: detection enabled above 40 °C (0x60EB2, force-enabled if senso… |
| [S_Kyl_temp](symbols/S_Kyl_temp.md) | State byte (RAM) | (RAM) | Secondary-air and lambda-startup gates read the start-time snapshot instead of the live value so decisions … |
| [S_Lufttemp](symbols/S_Lufttemp.md) | State byte (RAM) | (RAM) | Same snapshot role as [S_Kyl_temp](symbols/S_Kyl_temp.md); start plausibility compares it ±10 °C around coolant temperature |
| [Start_kylv](symbols/Start_kylv.md) | State byte (RAM) | (RAM) | Cold-start classification: the lambda-startup delay compares it against 10 °C, keeping the cold-start verdi… |
| [Start_tryck](symbols/Start_tryck.md) | State byte (RAM) | (RAM) | Reference load for the start enrichment in the start-recognition snapshot |
| [Kyltemp_steg](symbols/Kyltemp_steg.md) | Calibration table, 19 B (AD axis) | ROM 0x40B45 | Axis of the coolant-sensor AD → °C conversion |
| [Kyltemp_tab](symbols/Kyltemp_tab.md) | Calibration table, 19 B (°C values) | ROM 0x40B58 | Coolant AD → °C lookup |
| [Lufttemp_steg](symbols/Lufttemp_steg.md) | Calibration table, 16 B (AD axis) | ROM 0x40B6E | Axis of the intake-air-sensor AD → °C conversion; same NTC AD spacing family as [Kyltemp_steg](symbols/Kyltemp_steg.md) |

### Warmup fuel tables

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Before_start](symbols/Before_start.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x40F14 | Before-start (priming) enrichment/time table, 9…151 raw units across the AD axis; feeds the pre-cranking stage |
| [Build_up_time](symbols/Build_up_time.md) | Calibration scalar | ROM 0x040534 | Build-up window (ticks) for the before-start priming stage in normal conditions |
| [Build_up_time_2](symbols/Build_up_time_2.md) | Calibration scalar | ROM 0x040535 | Build-up window (ticks) used below the switch temperature (double the normal window) |
| [Build_up_time_switch](symbols/Build_up_time_switch.md) | Calibration scalar | ROM 0x040536 | Coolant-temperature threshold separating [Build_up_time](symbols/Build_up_time.md) from [Build_up_time_2](symbols/Build_up_time_2.md): −10 °C and colder get the 60-t… |
| [Startvev_fak](symbols/Startvev_fak.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x4085E | Cranking enrichment factor ('start vev' = crank start): cranking injection time = Interp([Startvev_fak](symbols/Startvev_fak.md)) × St… |
| [Start_insp](symbols/Start_insp.md) | Calibration scalar | ROM 0x040BAC | Base cranking injection count multiplied with the interpolated [Startvev_fak](symbols/Startvev_fak.md) (0x6EFAC) |
| [Start_max](symbols/Start_max.md) | Calibration scalar | ROM 0x040712 | Post-catch injection count at which blended cranking fuel is fully replaced by running fuel |
| [Start_ramp](symbols/Start_ramp.md) | Calibration scalar | ROM 0x040714 | Ramp-out window for the cranking→run blend together with [Start_max](symbols/Start_max.md) |
| [Start_proc](symbols/Start_proc.md) | Calibration scalar | ROM 0x040F10 | Scaling divisor (128) applied when the cranking pulse is written into the injection-time array |
| [Start_trottel](symbols/Start_trottel.md) | Calibration scalar | ROM 0x040716 | Throttle-AD threshold above which cranking enrichment is suppressed (flood-clear behavior) |
| [Start_dead_tab](symbols/Start_dead_tab.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x40702 | Cranking dead-pulse table — the feature is disabled by calibration |
| [Ramp_fak](symbols/Ramp_fak.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x4063F | Cranking→run blend factor, ≈1.00 (raw 124–128) across the whole temperature range — effectively a constant … |
| [Eftersta_fak](symbols/Eftersta_fak.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x4086D | After-start warm-up enrichment coefficient ('efter start' = after start), ×1/128 add to base fuel while the… |
| [Eftersta_fak2](symbols/Eftersta_fak2.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x4087C | Second after-start coefficient set for the alternate stage (stage byte #2) |
| [Eft_dec_fak](symbols/Eft_dec_fak.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x4088B | After-start enrichment decay rate |
| [Eft_dec_fak2](symbols/Eft_dec_fak2.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x4089A | Decay rate for the second coefficient set ([Eft_fak2](symbols/Eft_fak2.md)) |
| [Tempkomp_konst](symbols/Tempkomp_konst.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x408AB | Warm-up enrichment ramp coefficient for the running stage — NOT a knock table despite appearing in knock re… |
| [Temp_ramp_value](symbols/Temp_ramp_value.md) | Calibration scalar | ROM 0x0408BA | Tick count between single-point steps of the [Temp_fak](symbols/Temp_fak.md) recovery ramp after a coolant-sensor fault clears — a… |
| [BS_temp](symbols/BS_temp.md) | Calibration scalar | ROM 0x040F23 | Hot-restart threshold: a restart with coolant above 60 °C skips the restart enrichment — warm restarts are … |

### Warmup ignition and idle

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Retard_temp](symbols/Retard_temp.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x40B14 | Warm-up ignition retard multiplier ('retard temperature'): 1.40× hot rising to 2.00× cold, applied in the i… |
| [Accel_temp](symbols/Accel_temp.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x409AC | Temperature-dependent acceleration-enrichment coefficient (×1/128 = 0.40…1.74) |
| [Accel_temp2](symbols/Accel_temp2.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x409BB | Fallback acceleration coefficient used when the coolant sensor is flagged failed (flattens the hot end vs A… |
| [Idle_rpm_tab](symbols/Idle_rpm_tab.md) | Calibration table, 8 words (coolant-temp-indexed) | ROM 0x4111A | Warm-up idle speed target: 1100 rpm cold down to 900 rpm above 65 °C |
| [I_kyl_st](symbols/I_kyl_st.md) | Calibration table, 8 B (°C axis) | ROM 0x4112A | Axis of [Idle_rpm_tab](symbols/Idle_rpm_tab.md) (and adjacent idle/air tables) |
| [I_luft_st](symbols/I_luft_st.md) | Calibration table, 8 B (°C axis) | ROM 0x4115A | Intake-air-temperature axis for the air-density fuel correction table (adjacent ROM 0x41132, 8 words 25, 20… |
| [Idle_temp_off](symbols/Idle_temp_off.md) | Calibration table, 8 words | ROM 0x40FE6 | Idle enrichment cut-out values interpolated at 0x6FACE — scales the idle fuel enrichment away as the engine… |
| [Iv_start_rpm_offset](symbols/Iv_start_rpm_offset.md) | Calibration scalar | ROM 0x0410F9 | Idle-speed target offset while starting (+200 rpm), a quick-catch aid |
| [Start_time_rpm_lim](symbols/Start_time_rpm_lim.md) | Calibration scalar | ROM 0x042E6A | Below 650 rpm the engine counts as cranking: [Start_time](symbols/Start_time.md) accumulates and cranking fuel logic stays active |

### Emissions warmup gates

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Lamb_temp](symbols/Lamb_temp.md) | Calibration scalar | ROM 0x04074A | Coolant-temperature threshold for lambda (closed-loop) activity during warm-up; part of the cold-start lamb… |
| [Misf_kyltemp](symbols/Misf_kyltemp.md) | Calibration scalar | ROM 0x042E46 | Coolant-temperature gate for misfire-monitoring activity: below 18 °C the monitors are held off (spark-rela… |
| [Mis_kyltemp_tab](symbols/Mis_kyltemp_tab.md) | Calibration table, 15 B (coolant-AD-indexed) | ROM 0x42ECE | Per-temperature-band misfire-detection RPM/window thresholds indexed by coolant AD; works with [Misf_kyltemp](symbols/Misf_kyltemp.md) |
| [Temp_limit_low](symbols/Temp_limit_low.md) | Calibration scalar | ROM 0x042896 | Lower bound of the adaptation temperature window; with −40 °C as the boundary the window is never entered i… |
| [Temp_limit_high](symbols/Temp_limit_high.md) | Calibration scalar | ROM 0x042897 | Upper bound of the adaptation temperature window (see [Temp_limit_low](symbols/Temp_limit_low.md)) |

### Warmup runtime state

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Temp_fak](symbols/Temp_fak.md) | State byte (RAM) | (RAM) | Base warm-up fuel correction while running |
| [Acc_temp](symbols/Acc_temp.md) | State byte (RAM) | (RAM) | Scales acceleration enrichment while warm |
| [Ret_temp](symbols/Ret_temp.md) | State byte (RAM) | (RAM) | Applied in the ignition-time computation during warm-up |
| [Eft_fak](symbols/Eft_fak.md) | State byte array (RAM, per cylinder) | (RAM) | The live warm-up enrichment: one entry per cylinder (indexed by Cyl_nr); decremented one point per decay ti… |
| [Eft_fak_bas](symbols/Eft_fak_bas.md) | State byte (RAM) | (RAM) | Interpolation staging value |
| [Eft_fak2](symbols/Eft_fak2.md) | State byte array (RAM, per cylinder) | (RAM) | Applied alongside [Eft_fak](symbols/Eft_fak.md) in Function_0006F314 |
| [Eft_fak_bas2](symbols/Eft_fak_bas2.md) | State byte (RAM) | (RAM) | Interpolation staging value for set 2 |
| [Eft_dec](symbols/Eft_dec.md) | State byte (RAM) | (RAM) | While non-zero, drives per-tick subtraction from [Eft_fak](symbols/Eft_fak.md) — the enrichment walk-down |
| [Start_tid](symbols/Start_tid.md) | State word (RAM, per cylinder) | (RAM) | Interp([Startvev_fak](symbols/Startvev_fak.md)) × [Start_insp](symbols/Start_insp.md) while cranking; replaced by the run blend as [Start_count](symbols/Start_count.md) passes Start_ram… |
| [Grund_tid](symbols/Grund_tid.md) | State word (RAM) | (RAM) | Blend target at start; base pulse during after-start |
| [Start_count](symbols/Start_count.md) | State word (RAM) | (RAM) | Compared against [Start_max](symbols/Start_max.md) (14) and [Start_ramp](symbols/Start_ramp.md) (34) |
| [Start_dead](symbols/Start_dead.md) | State byte (RAM) | (RAM) | Gate for dead pulses during cranking |
| [Restart_status](symbols/Restart_status.md) | State byte (RAM) | (RAM) | Above [BS_temp](symbols/BS_temp.md) coolant the enrichment path is skipped on restart; status drives the restart blend and inject… |
| [Rpm_idle_nom](symbols/Rpm_idle_nom.md) | State word (RAM) | (RAM) | Plus [Iv_start_rpm_offset](symbols/Iv_start_rpm_offset.md) (+200 rpm) while starting, plus Idle_rpm_off (0 = unused) |
| [Start_time](symbols/Start_time.md) | State word (RAM) | (RAM) | Mirrored into the diagnostic frame array (0x1D18) |
| [Start_time_tot](symbols/Start_time_tot.md) | State word (RAM) | (RAM) | Service counter |
| [Motortid](symbols/Motortid.md) | State byte (RAM) | (RAM) | Total-run-time service totalizer |
| [Lamstart_time](symbols/Lamstart_time.md) | State word (RAM) | (RAM) | The lambda-startup gate runs its cold-timer logic only while this is 0 |


### Ignition — maps & axes

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Ign_map_0](symbols/Ign_map_0.md) | Calibration word (flash) | ROM 0x4186A | warm-engine base ignition advance vs rpm x load |
| [Ign_map_4](symbols/Ign_map_4.md) | Calibration word (flash) | ROM 0x41DC0 | warm-up ignition map (more advance at low rpm/load for cat light-off) |
| [Ign_map_2](symbols/Ign_map_2.md) | Calibration word (flash) | ROM 0x41B08 | knock retard overlay above ~atmospheric load (book: MAP>140 kPa regime) |
| [Ign_map_2_x_axis](symbols/Ign_map_2_x_axis.md) | 8/16-bit table (flash) | ROM 0x41AD8 | high-load axis for knock overlay map2 |
| [Ign_map_2_y_axis](symbols/Ign_map_2_y_axis.md) | 8/16-bit table (flash) | ROM 0x41AE8 | rpm axis for map2 |
| [Ign_map_1](symbols/Ign_map_1.md) | Calibration word (flash) | ROM 0x41AC2 | idle torque correction added to idle angle vs rpm-error axis |
| [Ign_map_1_y_axis](symbols/Ign_map_1_y_axis.md) | 8/16-bit table (flash) | ROM 0x41AAC | rpm-error axis for idle correction (reference unconfirmed) |
| [Ign_map_3](symbols/Ign_map_3.md) | Calibration word (flash) | ROM 0x41C40 | transient ignition overlay — present, disabled in factory tune |
| [Ign_map_3_x_axis](symbols/Ign_map_3_x_axis.md) | 8/16-bit table (flash) | ROM 0x41C08 | load axis for transient map |
| [Ign_map_5](symbols/Ign_map_5.md) | Calibration word (flash) | ROM 0x42022 | fixed advance overlay while channel-5 condition active (undocumented in book) |
| [Ign_map_6](symbols/Ign_map_6.md) | Calibration word (flash) | ROM 0x42056 | torque reduction during upshift (TC request) |
| [Ign_map_7](symbols/Ign_map_7.md) | Calibration word (flash) | ROM 0x4209C | torque control during downshift |
| [Ign_map_8](symbols/Ign_map_8.md) | Calibration word (flash) | ROM 0x420EA | coast-idle torque correction vs rpm error — present, zeroed in factory |
| [Ign_map_8_y_axis](symbols/Ign_map_8_y_axis.md) | 8/16-bit table (flash) | ROM 0x420D4 | rpm-error axis (clean +/-100 rpm) |

### Ignition — correction & scalars

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Ign_idle_angle](symbols/Ign_idle_angle.md) | Calibration word (flash->RAM) | ROM 0x4181E | idle base ignition angle seed for work word 0x4770 |
| [Ign_idle_angle_start](symbols/Ign_idle_angle_start.md) | Calibration word (flash) | ROM 0x41820 | idle angle substitute when idle out-of-band exceeds Diag_tid (anti-stall recovery) |
| [Knock_offset](symbols/Knock_offset.md) | Calibration word (flash) | ROM 0x41822 | global constant knock-retard subtract |
| [Trans_offset](symbols/Trans_offset.md) | Calibration word (flash) | ROM 0x41824 | transient offset init; runtime RAM word 0x3984-region reused for map3 output |
| [Ign_offset](symbols/Ign_offset.md) | Calibration word (flash) | ROM 0x4284A | global fixed ignition trim added to every event |
| [Ign_offset_cyl1](symbols/Ign_offset_cyl1.md) | Calibration word (flash) | ROM 0x4284C | cylinder-1 spark trim (selected at sync angle 0x21C) |
| [Ign_offset_cyl2](symbols/Ign_offset_cyl2.md) | Calibration word (flash) | ROM 0x4284E | cylinder-2 spark trim (sync 0x168) |
| [Ign_offset_cyl3](symbols/Ign_offset_cyl3.md) | Calibration word (flash) | ROM 0x42850 | cylinder-3 spark trim (default sync branch) |
| [Ign_offset_cyl4](symbols/Ign_offset_cyl4.md) | Calibration word (flash) | ROM 0x42852 | cylinder-4 spark trim (sync 0xB4) |
| [Ign_offset_adapt](symbols/Ign_offset_adapt.md) | Calibration word (flash->RAM) | ROM 0x42854 | knock-adaptive ignition offset init; live value in work word 0x3896 |
| [Ramp_up_ram](symbols/Ramp_up_ram.md) | 8/16-bit table (flash) | ROM 0x42876 | per-blend-channel weight ramp-up rates |
| [Ramp_down_ram](symbols/Ramp_down_ram.md) | 8/16-bit table (flash) | ROM 0x42886 | per-blend-channel weight ramp-down rates |
| [Ret_tab_mul](symbols/Ret_tab_mul.md) | Calibration byte (flash) | ROM 0x4097D | [Ret_mangd](symbols/Ret_mangd.md) increment scaling (x10/255 clamp at 255) |
| [Ret_clear_tab_low](symbols/Ret_clear_tab_low.md) | Calibration byte (flash) | ROM 0x40986 | [Ret_mangd](symbols/Ret_mangd.md) demand count below which knock counter clears |
| [Max_ret_dec](symbols/Max_ret_dec.md) | Calibration byte (flash) | ROM 0x40989 | per-event decay fraction of knock retard demand [Ret_mangd](symbols/Ret_mangd.md) |
| [Max_lret_dec](symbols/Max_lret_dec.md) | Calibration byte (flash) | ROM 0x4098B | per-event decay fraction of decel-enrichment demand [Lret_mangd](symbols/Lret_mangd.md) |
| [Ret_up_rpm](symbols/Ret_up_rpm.md) | Calibration word (flash) | ROM 0x41762 | upper rpm bound for all-cyl-knock fuel enrichment window |
| [Ret_down_rpm](symbols/Ret_down_rpm.md) | Calibration word (flash) | ROM 0x41764 | lower rpm bound for knock enrichment window |
| [Ret_delta_rpm](symbols/Ret_delta_rpm.md) | Calibration word (flash) | ROM 0x41766 | rpm deficit triggering knock enrichment in that window |
| [Ret_fuel_tab](symbols/Ret_fuel_tab.md) | Calibration byte (flash) | ROM 0x4176A | enrichment factor loaded into [Ret_fuel_fak](symbols/Ret_fuel_fak.md) when all-cyl knock enrichment fires |
| [Lret_konst](symbols/Lret_konst.md) | Calibration word (flash) | ROM 0x4093C | deceleration load-spike enrichment konst map |
| [Airpump_ign_offset](symbols/Airpump_ign_offset.md) | Calibration word (flash) | ROM 0x42BEA | AIR-pump ignition advance target (feature off in factory) |
| [Ap_ign_step](symbols/Ap_ign_step.md) | Calibration word (flash) | ROM 0x42BFC | ramp step of AIR-pump advance per event |
| [Sond_ign_limit](symbols/Sond_ign_limit.md) | Calibration word (flash) | ROM 0x428A4 | ignition-event counter ceiling for O2-sensor monitoring counters |
| [Ign_counter_mis_lim](symbols/Ign_counter_mis_lim.md) | Calibration word (flash) | ROM 0x42EBE | ignition-event window for misfire counters (book: 2400 rpm anchor) |
| [Misf_ign_lim](symbols/Misf_ign_lim.md) | Calibration word (flash) | ROM 0x42EC2 | misfire evaluation ignition limit set |
| [Retard_konst](symbols/Retard_konst.md) | Calibration word (flash) | ROM 0x428xx (init PEA; see evidence) | knock retard demand step map (per-cyl increment into [Ret_mangd](symbols/Ret_mangd.md)) |

### Ignition — runtime state

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Ign_angle](symbols/Ign_angle.md) | State word (RAM 0x10B4) | RAM 0x10B4 | final ignition angle, clamped -10.0..+40.0, written every sync event |
| [Ign_angle_byte](symbols/Ign_angle_byte.md) | State byte (RAM 0x3902) | RAM 0x3902 | [Ign_angle](symbols/Ign_angle.md) in 1-deg offset-10 units for logging |
| [Ign_map_value](symbols/Ign_map_value.md) | State word (RAM 0x3984) | RAM 0x3984 | interpolated [Ign_map_0](symbols/Ign_map_0.md) value feeding the blend |
| [Weight](symbols/Weight.md) | State word (RAM 0x3994) | RAM 0x3994..0x39A6 | 8 blend weight words (base, idle, knock, transient, map4-xfade, map5, upshift, downshift) + 0x39A6 cap flag |
| [Knock_map_offset](symbols/Knock_map_offset.md) | State word (RAM 0x10BA) | RAM 0x10BA | weight-scaled map2 retard output for knock engine |
| [Knock_map_lim](symbols/Knock_map_lim.md) | State word (RAM 0x10B8) | RAM 0x10B8 | map2 value + [Knock_ang_dec](symbols/Knock_ang_dec.md) limit used by knock retard cap |
| [Ret_ind](symbols/Ret_ind.md) | State byte (RAM 0x1043) | RAM 0x1043 | bitmask of cylinders currently holding knock retard (0x10/20/40/80) |
| [Multispark](symbols/Multispark.md) | State byte (RAM 0x1118) | RAM 0x1118 | multi-spark arming flag during cold low-rpm starting |
| [Mult_time](symbols/Mult_time.md) | State word (RAM 0x1108) | RAM 0x1108 | multi-spark pulse period (5000/3000 TPU ticks) |
| [Ret_fuel_fak](symbols/Ret_fuel_fak.md) | State byte (RAM 0x1151) | RAM 0x1151 | active all-cyl-knock enrichment factor |

### Boost — request & limiters

| Symbol | Type | Address | Function |
| -------------------------- | ------------------------------------ | ----------------------------------------------------- | -------------------------------------------------------------------------------------- |
| [Tryck_mat](symbols/Tryck_mat.md) | 8-bit table (16x8 bytes, flash) | ROM 0x412E0, RAM 0x5BC6 | main boost request map (rpm x throttle) |
| [Tryck_mat_a](symbols/Tryck_mat_a.md) | 8-bit table (16x8 bytes, flash) | ROM 0x41360, RAM 0x5C46 | boost request, automatic transmission |
| [Pwm_ind_rpm](symbols/Pwm_ind_rpm.md) | 16-bit table (16 words, flash) | ROM 0x41288, RAM 0x5B6E | shared regulation rpm axis (misnomer name) |
| [Pwm_ind_trot](symbols/Pwm_ind_trot.md) | 8-bit table (5x8 bytes, flash) | ROM 0x412A8, RAM 0x5B8E | throttle row axis, bank per gear |
| [Tryck_vakt_tab](symbols/Tryck_vakt_tab.md) | 8-bit table (16, flash) | ROM 0x412D0, RAM 0x5BB6 | overboost fuel-cut limit per rpm |
| [Regl_tryck_fgm](symbols/Regl_tryck_fgm.md) | 8-bit table (16, flash) | ROM 0x415C6, RAM 0x5F42 | 1st-gear max boost limiter (manual) |
| [Regl_tryck_sgm](symbols/Regl_tryck_sgm.md) | 8-bit table (16, flash) | ROM 0x415D6, RAM 0x5F52 | 2nd-gear max boost limiter (manual) |
| [Regl_tryck_fgaut](symbols/Regl_tryck_fgaut.md) | 8-bit table (16, flash) | ROM 0x41554, RAM 0x5ED0 | automatic-stage/transmission limiter |
| [Max_regl_sp](symbols/Max_regl_sp.md) | 16-bit table (16 words, flash) | ROM 0x415A6, RAM 0x5F22 | rpm axis for air-temp limiter curves |
| [Max_regl_temp_1](symbols/Max_regl_temp_1.md) | 16-bit tables (16 words each, flash) | ROM 0x41566/0x41586, RAM 0x5EE2/0x5F02 | max charge pressure at warm / cold interp point (automatics only) |
| [Max_regl_temp_2](symbols/Max_regl_temp_2.md) | 16-bit tables (16 words each, flash) | ROM 0x41566/0x41586, RAM 0x5EE2/0x5F02 | max charge pressure at warm / cold interp point (automatics only) |
| [Temp_max_regl](symbols/Temp_max_regl.md) | Calibration words (flash, 2) | ROM 0x41564, RAM 0x5EE0 | intake-air temp interpolation points for the two limiter curves |
| [Overstid_tab](symbols/Overstid_tab.md) | 8-bit table (16, flash) | ROM 0x41470, RAM 0x5D56 | tip-in overshoot-comp duration per rpm |
| [Overs_tab](symbols/Overs_tab.md) | 8-bit tables (flash) | ROM 0x413E8/0x41468/0x413E0, RAM 0x5CCE/0x5D4E/0x5CC6 | overshoot boost add-on (16 rpm x 8 shortfall), its kPa axis, intake-temp scaling /255 |
| [Overs_tab_xaxis](symbols/Overs_tab_xaxis.md) | 8-bit tables (flash) | ROM 0x413E8/0x41468/0x413E0, RAM 0x5CCE/0x5D4E/0x5CC6 | overshoot boost add-on (16 rpm x 8 shortfall), its kPa axis, intake-temp scaling /255 |
| [Overs_komp_tab](symbols/Overs_komp_tab.md) | 8-bit tables (flash) | ROM 0x413E8/0x41468/0x413E0, RAM 0x5CCE/0x5D4E/0x5CC6 | overshoot boost add-on (16 rpm x 8 shortfall), its kPa axis, intake-temp scaling /255 |
| [Overs_angle](symbols/Overs_angle.md) | Calibration word (flash) | ROM 0x4153D, RAM 0x5EB4 | throttle threshold to arm tip-in overshoot comp |
| [Apc_fullgas](symbols/Apc_fullgas.md) | Calibration word (flash) | ROM 0x4153C, RAM 0x5EB2 | full-load APC threshold; gates I-term + Reg_kon derate + full-gas flag |
| [Apc_konst_tid](symbols/Apc_konst_tid.md) | Calibration words (flash) | ROM 0x4153A/0x4153B/0x4153E, RAM 0x5EAE/0x5EB0/0x5EB6 | const-light-load flag timer / limiter-confirm timer / optional loop prescaler (unused) |
| [Apc_cert_tid](symbols/Apc_cert_tid.md) | Calibration words (flash) | ROM 0x4153A/0x4153B/0x4153E, RAM 0x5EAE/0x5EB0/0x5EB6 | const-light-load flag timer / limiter-confirm timer / optional loop prescaler (unused) |
| [Max_vehicle_speed](symbols/Max_vehicle_speed.md) | Calibration word (flash) | ROM 0x42BDC, RAM 0x5B6C | threshold feeding the derate counter |
| [Gear_st](symbols/Gear_st.md) | 16-bit + 8-bit tables (flash) | ROM 0x41540/0x4154A, RAM 0x5EB8/0x5EC2 | overall gear ratios and detection windows for gear identification from speed vs rpm |
| [Gear_ratio_delta](symbols/Gear_ratio_delta.md) | 16-bit + 8-bit tables (flash) | ROM 0x41540/0x4154A, RAM 0x5EB8/0x5EC2 | overall gear ratios and detection windows for gear identification from speed vs rpm |
| [Boost_valve_pwm_driver](symbols/Boost_valve_pwm_driver.md) | Function | 0x466F0 | programs TPU period/duty for boost solenoid |
| [Max_um_time](symbols/Max_um_time.md) | Calibration words (flash, UNUSED) | ROM 0x41668/6A/6C/6E, 0x4166F | no code references in this revision (legacy derivative-limit scalars) |
| [Max_pos_der](symbols/Max_pos_der.md) | Calibration words (flash, UNUSED) | ROM 0x41668/6A/6C/6E, 0x4166F | no code references in this revision (legacy derivative-limit scalars) |
| [Max_neg_der](symbols/Max_neg_der.md) | Calibration words (flash, UNUSED) | ROM 0x41668/6A/6C/6E, 0x4166F | no code references in this revision (legacy derivative-limit scalars) |
| [Um_thr_lim](symbols/Um_thr_lim.md) | Calibration words (flash, UNUSED) | ROM 0x41668/6A/6C/6E, 0x4166F | no code references in this revision (legacy derivative-limit scalars) |
| [Um_min_limit](symbols/Um_min_limit.md) | Calibration words (flash, UNUSED) | ROM 0x41668/6A/6C/6E, 0x4166F | no code references in this revision (legacy derivative-limit scalars) |

### Boost — PID & output

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Reg_varv](symbols/Reg_varv.md) | 16-bit table (7 words, flash) | ROM 0x41480, RAM 0x5D66 | PID gain rpm axis |
| [Reg_last](symbols/Reg_last.md) | 8-bit table (4, flash) | ROM 0x4148E, RAM 0x5EAA | PID gain boost-error axis |
| [P_fors](symbols/P_fors.md) | 8-bit table (7x4 bytes, flash) | ROM 0x41492, RAM 0x5D74 | proportional gain Kp manual |
| [I_fors](symbols/I_fors.md) | 8-bit table (7x4, flash) | ROM 0x414AE, RAM 0x5D90 | integral gain Ki manual |
| [D_fors](symbols/D_fors.md) | 8-bit table (7x4, flash) | ROM 0x414CA, RAM 0x5DAC | derivative gain Kd manual |
| [P_fors_a](symbols/P_fors_a.md) | 8-bit tables (7x4, flash) | ROM 0x414E6/0x41502/0x4151E, RAM 0x5DC8/0x5DE4/0x5E00 | automatic PID gains |
| [I_fors_a](symbols/I_fors_a.md) | 8-bit tables (7x4, flash) | ROM 0x414E6/0x41502/0x4151E, RAM 0x5DC8/0x5DE4/0x5E00 | automatic PID gains |
| [D_fors_a](symbols/D_fors_a.md) | 8-bit tables (7x4, flash) | ROM 0x414E6/0x41502/0x4151E, RAM 0x5DC8/0x5DE4/0x5E00 | automatic PID gains |
| [Reg_kon_mat](symbols/Reg_kon_mat.md) | 16-bit table (31 words, flash) | ROM 0x415E8, RAM 0x5E1C | PID feed-forward duty offset vs rpm (manual) |
| [Reg_kon_mat_a](symbols/Reg_kon_mat_a.md) | 16-bit table (31 words, flash) | ROM 0x41626, RAM 0x5E5A | PID offset, automatic |
| [Reg_kon_fga](symbols/Reg_kon_fga.md) | Calibration word (flash) | ROM 0x41550, RAM 0x5ECA | Reg_kon cap automatic full-gas (x10) |
| [Reg_kon_fgm](symbols/Reg_kon_fgm.md) | Calibration word (flash) | ROM 0x41551, RAM 0x5ECC | Reg_kon cap 1st gear manual (x10) |
| [Reg_kon_sgm](symbols/Reg_kon_sgm.md) | Calibration word (flash) | ROM 0x41552, RAM 0x5ECE | Reg_kon cap 2nd gear manual (x10) |
| [I_fak_max](symbols/I_fak_max.md) | Calibration word (flash, 16-bit) | ROM 0x41666, RAM 0x5E9A | anti-windup clamp of [I_fak](symbols/I_fak.md) |
| [Adaption_time](symbols/Adaption_time.md) | Calibration word (flash) | ROM 0x41664, RAM 0x5E98 | settle time before [Apc_adapt](symbols/Apc_adapt.md) update |
| [Frek_230](symbols/Frek_230.md) | Calibration word (flash, 16-bit) | ROM 0x41670, RAM 0x5EA6 | valve PWM frequency below 2300 rpm |
| [Frek_250](symbols/Frek_250.md) | Calibration word (flash, 16-bit) | ROM 0x41672, RAM 0x5EA8 | valve PWM frequency above 2500 rpm |

### Boost — runtime state

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Reg_kon_apc](symbols/Reg_kon_apc.md) | State word (RAM 0x1154) | 0x1154 | active feed-forward duty offset (gear+knock+temp corrected) |
| [PWM_ut](symbols/PWM_ut.md) | State words (RAM 0x3476 W / 0x3359 B) | 0x3476/0x3359 | valve duty output (0.1% counts) and percent copy |
| [PWM_ut10](symbols/PWM_ut10.md) | State words (RAM 0x3476 W / 0x3359 B) | 0x3476/0x3359 | valve duty output (0.1% counts) and percent copy |
| [P_fak](symbols/P_fak.md) | State words (RAM 0x347C/0x347A/0x3478) | dynamic | 0x7325A / 0x7326x anti-windup / 0x732FA |
| [I_fak](symbols/I_fak.md) | State words (RAM 0x347C/0x347A/0x3478) | dynamic | 0x7325A / 0x7326x anti-windup / 0x732FA |
| [D_fak](symbols/D_fak.md) | State words (RAM 0x347C/0x347A/0x3478) | dynamic | 0x7325A / 0x7326x anti-windup / 0x732FA |
| [Apc_adapt](symbols/Apc_adapt.md) | State word (RAM 0x345A) | 0x345A | learned duty adaption +-250 |
| [P_medel](symbols/P_medel.md) | State word (RAM 0x3356) | 0x3356 | averaged actual manifold pressure (loop feedback) |
| [Reg_freq](symbols/Reg_freq.md) | State word (RAM 0x3A88) | 0x3A88 | valve PWM frequency word |
| [APC_status](symbols/APC_status.md) | State words (RAM 0x334B / 0x334C) | 0x334B/0x334C | loop flags (bit1 knock derate, bit4 tip-in, bit6 load-limit) / bit6 gear limiter active, bit7 auto-stage request |
| [Regl_status2](symbols/Regl_status2.md) | State words (RAM 0x334B / 0x334C) | 0x334B/0x334C | loop flags (bit1 knock derate, bit4 tip-in, bit6 load-limit) / bit6 gear limiter active, bit7 auto-stage request |
| [Limiter_cause](symbols/Limiter_cause.md) | State word (RAM 0x3FA2) | 0x3FA2 | reason duty was forced to 2%/98% (0x10 reverse, 8 speed/batt, ...) |
| [Regl_temp_max](symbols/Regl_temp_max.md) | State word (RAM, F_725B8 A2) | ([Regl_temp_max](symbols/Regl_temp_max.md) label) | air-temp limiter cap result |
| [Fault_derate](symbols/Fault_derate.md) | State word (RAM 0x47A6) | 0x47A6 | slow fault/overspeed derate of request |

### Fuel — duration chain

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Insp_mat](symbols/Insp_mat.md) | 8-bit table 16x16 (flash) | 0x40E10 -> 0x4976 | main VE correction matrix MAPxRPM on base time |
| [Fuel_map_xaxis](symbols/Fuel_map_xaxis.md) | Calibration table (flash) | 0x41674 -> 0x4E62 | load axis for Insp_mat/Adapt_korr/Fload/knock scans |
| [Fuel_map_yaxis](symbols/Fuel_map_yaxis.md) | Calibration table (flash) | 0x41684 -> 0x4E72 | rpm axis for the fuel maps |
| [Inj_konst](symbols/Inj_konst.md) | Calibration word (flash) | 0x40BA6 -> 0x4BF4 | injector constant, base mass term |
| [Start_v_vinkel](symbols/Start_v_vinkel.md) | Calibration word (flash) | 0x40F12 -> 0x4E14 | injection angle during cranking |
| [Batt_korr_tab](symbols/Batt_korr_tab.md) | 16-bit table x11 (flash) | 0x4051E -> 0x4E4A | battery-voltage injector open-time compensation |
| [Last_reg_kon](symbols/Last_reg_kon.md) | 16-bit table x4 (flash) | 0x417CC -> 0x51BE | idle load-regulation constants |
| [Idle_fuel_korr](symbols/Idle_fuel_korr.md) | 8-bit table 8x12 (flash) | 0x40DB0 -> 0x5F6A | idle fuel map, closed throttle |
| [Idle_st_rpm](symbols/Idle_st_rpm.md) | Calibration table (flash) | 0x416E0 -> 0x4EC2 | idle-map rpm axis |
| [Idle_st_last](symbols/Idle_st_last.md) | Calibration table (flash) | 0x416D4 -> 0x61E2 | idle-map load axis |
| [Fload_tab](symbols/Fload_tab.md) | Calibration table (flash) | 0x409DA -> 0x4BE4 | WOT enrichment amount (catalyst warmup 550-2400 rpm) |
| [Fload_throt_tab](symbols/Fload_throt_tab.md) | Calibration table (flash) | 0x409CA -> 0x4BD4 | throttle-AD WOT threshold per rpm row (FF = disabled >= 2400 rpm) |
| [Fuel_knock_xaxis](symbols/Fuel_knock_xaxis.md) | Calibration table (flash) | 0x40AB4 -> 0x6412 | knock fuel-map load axis; [0] compared to Medellast |

### Fuel — lambda & adaptation

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Adapt_korr](symbols/Adapt_korr.md) | 8-bit table 16x16 (flash+RAM state) | 0x4040A -> 0x4876 | pointed per-cell lambda adaptation |
| [Adapt_injfaktor](symbols/Adapt_injfaktor.md) | Calibration word (RAM state, init flash) | 0x4075A -> 0x4A76 | global-adaptation injection factor |
| [Adapt_inj_imat](symbols/Adapt_inj_imat.md) | Calibration word (RAM state, init flash) | 0x4075B -> 0x4A78 | global adaptation for idle-map branch |
| [Adapt_korr_low](symbols/Adapt_korr_low.md) | Calibration word (flash) | 0x428B3 -> 0x5B10 | min legal [Adapt_korr](symbols/Adapt_korr.md) cell (CEL on exceed) |
| [Adapt_korr_high](symbols/Adapt_korr_high.md) | Calibration word (flash) | 0x428B4 -> 0x5B12 | max legal [Adapt_korr](symbols/Adapt_korr.md) cell |
| [Adapt_injfaktor_low](symbols/Adapt_injfaktor_low.md) | Calibration word (flash) | 0x428B5 -> 0x5B14 | min global factor (x0.80) |
| [Adapt_injfaktor_high](symbols/Adapt_injfaktor_high.md) | Calibration word (flash) | 0x428B7 -> 0x5B18 | max global factor (x1.20) |
| [Nr_adapt_idle_mat](symbols/Nr_adapt_idle_mat.md) | Calibration word (flash) | 0x4075C -> 0x4A7A | idle-map adaptation target/counter |
| [Com_on_idle](symbols/Com_on_idle.md) | Calibration word (flash) | 0x4074B -> 0x4E10 | idle counter value required before idle map replaces main map |
| [Global_adapt_nr](symbols/Global_adapt_nr.md) | Calibration word (flash) | 0x40984 -> 0x4B7E | global-adaptation accumulation target (mean [Lambdaint](symbols/Lambdaint.md) applied at 250) |
| [Min_load_gadapt](symbols/Min_load_gadapt.md) | Calibration word (flash) | 0x4097E -> 0x4B76 | global-adapt load window min |
| [Max_load_gadapt](symbols/Max_load_gadapt.md) | Calibration word (flash) | 0x4097F -> 0x4B78 | global-adapt load window max |
| [Min_rpm_gadapt](symbols/Min_rpm_gadapt.md) | Calibration word (flash) | 0x40980 -> 0x4B7A | global-adapt rpm window min |
| [Max_rpm_gadapt](symbols/Max_rpm_gadapt.md) | Calibration word (flash) | 0x40982 -> 0x4B7C | global-adapt rpm window max |
| [Adaption_time](symbols/Adaption_time.md) | Calibration word (flash) | 0x41664 -> 0x5E98 | adaption period ("every fifth minute", book) |
| [Load_adapt_time](symbols/Load_adapt_time.md) | Calibration word (flash) | 0x417AB -> 0x4F92 | adaptation window length |
| [Grund_last](symbols/Grund_last.md) | Calibration word (RAM state, init flash) | 0x417D8 -> 0x51C6 | learned baseline (minimum) load floor |
| [Grund_last_max](symbols/Grund_last_max.md) | Calibration word (flash) | 0x417D9 -> 0x51C8 | ceiling of [Grund_last](symbols/Grund_last.md) ramp, warm engine only |
| [Open_loop](symbols/Open_loop.md) | Calibration table (flash) | 0x40718 -> 0x4CFE | per-rpm open-loop load ceiling |
| [Open_loop_adapt](symbols/Open_loop_adapt.md) | Calibration table (flash) | 0x40728 -> 0x4D0E | open-loop ceiling for adaptation |
| [Open_loop_knock](symbols/Open_loop_knock.md) | Calibration table (flash) | 0x40738 -> 0x4D1E | open-loop ceiling while knock map active |
| [Lam_minlast](symbols/Lam_minlast.md) | Calibration table (flash) | 0x40F8A -> 0x6C62 | minimum load for lambda control per row |
| [Lean_step_map](symbols/Lean_step_map.md) | 8-bit table 16x4 (flash) | 0x40BB8 -> 0x6A40 | lambda integrator step-down rates by rpm/load cell |
| [Rich_step_map](symbols/Rich_step_map.md) | 8-bit table 16x4 (flash) | 0x40BF8 -> 0x6A80 | lambda integrator step-up rates |
| [Lambdamatris_diag](symbols/Lambdamatris_diag.md) | 8-bit table 6x16 (flash) | 0x40D50 -> 0x6BD6 | lambda-control monitoring thresholds per rpm row |

### Fuel — cut, timing & config

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Min_tid](symbols/Min_tid.md) | Calibration word (flash) | 0x40BA8 -> 0x4BF6 | minimum injection duration floor (book 250 = 1 ms) |
| [Min_tid_acink](symbols/Min_tid_acink.md) | Calibration word (flash) | 0x41282 -> 0x61DE | minimum-duration step with AC compressor on |
| [Tid_konst](symbols/Tid_konst.md) | Calibration word (flash) | 0x40BA2 -> 0x4BF2 | fixed idle injection time override |
| [Vinkel_konst](symbols/Vinkel_konst.md) | Calibration word (flash) | 0x40BA4 -> 0x4E3C | injection angle constant |
| [Del_mat](symbols/Del_mat.md) | 8-bit table 16x16 (flash) | 0x4075E -> 0x4BFC | injection delay map (interpolated angle) when [Pgm_mod](symbols/Pgm_mod.md)[0].2 |
| [Tryck_vakt_tab](symbols/Tryck_vakt_tab.md) | 8-bit table x16 (flash) | 0x412D0 -> 0x5BB6 | overboost fuel-cut MAP limit per rpm row |
| [Open_varv](symbols/Open_varv.md) | Calibration word (flash) | 0x40BB0 -> 0x4E40 | fuel-save reactivation rpm (book 1400 rpm) |
| [Open_all_varv](symbols/Open_all_varv.md) | Calibration word (flash) | 0x40F26 -> 0x4E32 | fuel-save disable floor |
| [Delay_cut](symbols/Delay_cut.md) | Calibration word (flash) | 0x40F25 -> 0x4E30 | deceleration fuel-cut engage delay |
| [Rpm_max](symbols/Rpm_max.md) | Calibration word (flash) | 0x40F2C -> 0x7640 | rev-limit speed -> [Pgm_status](symbols/Pgm_status.md) bit7 |
| [Rpm_dif](symbols/Rpm_dif.md) | Calibration word (flash) | 0x40F28 -> 0x7664 | re-cut window after rev cut |
| [Pgm_mod](symbols/Pgm_mod.md) | Calibration table 6 B (flash) | 0x4074E -> 0x76E2 | feature bitfield (WOT enrich, delay map, fuel cut, idle map, adaptivity); E85 is tuned via [Inj_konst](symbols/Inj_konst.md), not a bit |
| [Ret_fuel_tab](symbols/Ret_fuel_tab.md) | Calibration word (flash) | 0x4176A -> 0x4F50 | post-fuel-cut re-enrichment target |
| [Ret_fuel_step](symbols/Ret_fuel_step.md) | Calibration word (flash) | 0x41768 -> 0x4F4E | re-enrichment ramp step |
| [Ret_fuel_time](symbols/Ret_fuel_time.md) | Calibration word (flash) | 0x41769 -> 0x4F4C | re-enrichment ramp period |
| [After_fcut_tab](symbols/After_fcut_tab.md) | Calibration table 10 B (flash) | 0x416F0 -> 0x4ED2 | after-fuel-cut enrichment ramp |
| [Last_cyl_komp](symbols/Last_cyl_komp.md) | Calibration word (flash) | 0x40BAA -> 0x4BF8 | load ceiling for per-cylinder fuel trims |
| [Cyl_komp](symbols/Cyl_komp.md) | Calibration table 4 B (flash/RAM state) | 0x40538 -> 0x4E0C | per-cylinder fuel balance trim |
| [Airpump_inj_factor](symbols/Airpump_inj_factor.md) | Calibration word (flash) | 0x42BEC -> 0x5B50 | air-pump injection trim |
| [Overstid_tab](symbols/Overstid_tab.md) | Calibration table x16 (flash) | 0x41470 -> 0x5D56 | injection over-time margin per rpm row (TPU arming slack) |

### Fuel — runtime state

| Symbol | Type | Address | Function |
|---|---|---|---|
| [Insp_vinkel](symbols/Insp_vinkel.md) | State word (RAM) | RAM alias; scheduled copy 0x1072 | injection angle for next TPU event (+0/180/360/540 per cylinder, firing 1-3-4-2) |
| [Insp_tid](symbols/Insp_tid.md) | State word (RAM) | RAM alias (word written 0x6E684; halved in group mode 0x103B bit0) | final injection pulse width to TPU |
| [Insptid_ms10](symbols/Insptid_ms10.md) | State word (RAM) | 0x1064 (symbol table) | pulse-width copy for cluster consumption |
| [Lambdaint](symbols/Lambdaint.md) | State byte (RAM) | 0x102E area (Ghidra DAT_0000102e; disassembly alias RAM_Lambdaint) | closed-loop lambda integrator |
| [Pgm_status](symbols/Pgm_status.md) | State byte (RAM) | 0x1041 (symbol table) | engine flags: bit3 running, bit5 overboost, bit7 rev-limit |
| [KillInjection](symbols/KillInjection.md) | State byte (RAM, disassembly alias) | runtime | immobilizer/limp hard injection kill |
| [Br_plus](symbols/Br_plus.md) | State word (RAM) | 0x1150 (symbol table) | additive fuel trim (plus) |
| [Br_minus](symbols/Br_minus.md) | State word (RAM) | 0x1152 (symbol table) | additive fuel trim (minus) |
