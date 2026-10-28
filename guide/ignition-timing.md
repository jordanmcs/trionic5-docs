
# T5 Ignition Timing

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.



> **Summary:** Every crank-sync event, `CalculateIgnitionAngle` (ROM `0x62102`) builds the commanded spark angle from a **weighted blend of up to seven simultaneous ignition maps** (not a mode switch), then applies a fixed chain of corrections: knock overlay, global and adaptive knock offsets, idle-governor dither, transient overlay, fixed and per-cylinder trims, AIR-pump advance. Result: [Ign_angle](../reference/symbols/Ign_angle.md) (RAM `0x10B4`), signed **0.1 crank degrees**, clamped −10.0…+40.0°.



Working evidence: `source/ignition_system.md`, raw bytes `source/ignition_tables.txt`, Ghidra decompiles in `t5-re/evidence/ignition/`.



## Units and outputs



Every ignition angle word is 0.1 crank degrees per count (proven by the final clamp window −100…+400 at `0x63AE6`, the book's 6–8° idle point vs [Ign_idle_angle](../reference/symbols/Ign_idle_angle.md) = 70, and the log-byte formula `Ign_angle_byte = (Ign_angle+100)/10`). There is **no dwell table**: the ignition cassette holds the 400 V charge; the ECU only grounds the trigger lines. ([Overs_tab](../reference/symbols/Overs_tab.md)/[Overstid_tab](../reference/symbols/Overstid_tab.md)/[Overs_angle](../reference/symbols/Overs_angle.md) are APC boost tables — naming trap.)



## Base map selection — weighted blend



All relevant maps are interpolated every event (engine `Function_00061F30`) and averaged by 0…1000 weights (`RAM_Weight[0..7]`, RAM `0x3994`) ramped by `Function_00061600` at rates from [Ramp_up_ram](../reference/symbols/Ramp_up_ram.md)/[Ramp_down_ram](../reference/symbols/Ramp_down_ram.md):



| Map | Role | Engagement |
|---|---|---|
| [Ign_map_0](../reference/symbols/Ign_map_0.md) | warm base advance (rpm × load) | always computed, weight instant |
| [Ign_map_4](../reference/symbols/Ign_map_4.md) | warm-up map (cat light-off advance) | crossfade by intake temp between [Temp_limit_low](../reference/symbols/Temp_limit_low.md)/`high` |
| idle branch: [Ign_idle_angle](../reference/symbols/Ign_idle_angle.md) + [Ign_map_1](../reference/symbols/Ign_map_1.md) (or [Ign_map_8](../reference/symbols/Ign_map_8.md) in coast) | idle torque control | idle governor active; bare angle in gears 1–2 |
| [Ign_map_5](../reference/symbols/Ign_map_5.md) | flat +2.0° overlay | channel-5 condition (setter untraced) |
| [Ign_map_6](../reference/symbols/Ign_map_6.md) / [Ign_map_7](../reference/symbols/Ign_map_7.md) | upshift / downshift torque control | transmission request flags |
| [Ign_map_3](../reference/symbols/Ign_map_3.md) | transient advance | present, **all zero in factory** |



## Correction chain (code order, 0x6266E–0x62838)



1. [Ign_map_2](../reference/symbols/Ign_map_2.md) knock map (load axis starts at 128 ≈ atmospheric; book regime MAP > 140 kPa) — *not* part of the additive blend: it exports [Knock_map_offset](../reference/symbols/Knock_map_offset.md)/[Knock_map_lim](../reference/symbols/Knock_map_lim.md) to the knock engine.

2. − [Knock_offset](../reference/symbols/Knock_offset.md) (factory 0)

3. − API idle-governor offset word (idle stability dither from `API_dt_offset_tab`)

4. \+ transient overlay ([Ign_map_3](../reference/symbols/Ign_map_3.md) × weight / 1000)

5. \+ [Ign_offset](../reference/symbols/Ign_offset.md), + per-cylinder `Ign_offset_cyl1..4` (selected by crank-sync angle word; all factory 0)

6. AIR-pump advance ramp ([Airpump_ign_offset](../reference/symbols/Airpump_ign_offset.md) = 0 in factory — feature off)

7. \+ adaptive knock offset work word (init [Ign_offset_adapt](../reference/symbols/Ign_offset_adapt.md) = −10.0°, maintained by the K-adapt routine)

8. Clamp −10.0…+40.0° → [Ign_angle](../reference/symbols/Ign_angle.md); log byte at 1° steps.



While knock retard is active a cap flag (owned by the knock engine) prevents the idle-torque branch from pushing the angle above the base/warm-up blend.



**Naming trap (repeat):** [Ret_temp](../reference/symbols/Ret_temp.md) (from [Retard_temp](../reference/symbols/Retard_temp.md) table, 1.40–2.00×) does **not** touch crank angle — it scales deceleration-enrichment and knock-retard *demand steps*. The real warm-up ignition function is the [Ign_map_4](../reference/symbols/Ign_map_4.md) crossfade. See [T5 Warmup Cycle and Temperature Inputs](warmup-cycle-and-temperature-inputs.md).



## Per-cylinder knock retard



`Ret_mangd[4]` (RAM `0x3A40`) counts retard events of 1.5° (15 counts), incremented by [Retard_konst](../reference/symbols/Retard_konst.md) × [Ret_temp](../reference/symbols/Ret_temp.md)/256 per knock event and decayed per event by [Max_ret_dec](../reference/symbols/Max_ret_dec.md)/256; capped by [Knock_map_lim](../reference/symbols/Knock_map_lim.md) inside the knock engine. Applied per cylinder downstream of [Ign_angle](../reference/symbols/Ign_angle.md) in the 0x48xxx event scheduler. All-cylinder knock additionally enriches fuel in the 900–1500 rpm window ([Ret_fuel_tab](../reference/symbols/Ret_fuel_tab.md) = 102 → factor (1024+102)/1024 ≈ +10 %) — the book's "adds fuel when all four cylinders knock". Details: [T5 Knock Detection and Adaptation](knock-detection-and-adaptation.md).



## Start and multi-spark



At start, [Ign_angle](../reference/symbols/Ign_angle.md) is forced to 10.0° ([Mult_time](../reference/symbols/Mult_time.md) = 5000). Below 0 °C coolant and rpm < 850, [Multispark](../reference/symbols/Multispark.md) arms repeated sparks (period 5000/3000 ticks) scheduled between primary spark +300 counts and ATDC — the book's ~210 sparks/s cold start. Disabled during knock evaluation (ion window).



## Outputs and state



[Ign_angle](../reference/symbols/Ign_angle.md) feeds the ignition ISR chain (0x488xx), the multi-spark scheduler, the diagnostic logger (÷5 + 80), and knock ion-window placement. Event counters `Ign_counter*` gate misfire and O2-sensor monitoring windows ([Ign_counter_mis_lim](../reference/symbols/Ign_counter_mis_lim.md) = 2400, [Sond_ign_limit](../reference/symbols/Sond_ign_limit.md) = 5000 rpm).



## Factory-side notes

All correction *mechanisms* identical. Index: [T5 Symbols](../reference/symbol-index.md)
