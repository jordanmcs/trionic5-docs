
# T5 Warmup Cycle and Temperature Inputs

How the Trionic 5.5 turns two NTC thermistors into a staged warm-up: cranking enrichment, after-start enrichment, the running temperature coefficient, ignition retard, idle speed, and the emissions gates that all key off coolant and intake temperature. Reverse-engineered from the factory 4780656 image with REA/Ghidra; companion evidence in [warmup_system](../evidence/warmup_system.md) (full working notes) and `source/warmup_tables.txt` (raw dumps).

> **Summary:** Coolant and intake temperatures enter as raw 8-bit AD counts, convert to signed °C through lookup tables, and drive every warm-up stage. All coolant-indexed calibration tables interpolate against the **raw AD count** on the shared [Temp_steg](../reference/symbols/Temp_steg.md) axis — not against °C. The cycle runs through fueling stages (priming → cranking → after-start → running), each with its own temperature-indexed coefficient table, while separate gates hold secondary air, lambda control, and misfire monitoring to their temperature windows.

## Sensor chain

- The coolant NTC is read by the TPU ADC into [AD_kylv](../reference/symbols/AD_kylv.md); intake air into [AD_lufttemp](../reference/symbols/AD_lufttemp.md). Because the sensors are NTC, **low AD count = hot** — the entire table family runs "warm on the left".
- [Kyl_temp](../reference/symbols/Kyl_temp.md) (signed °C) is produced by linear interpolation of [Kyltemp_tab](../reference/symbols/Kyltemp_tab.md) on the [Kyltemp_steg](../reference/symbols/Kyltemp_steg.md) AD axis: 19 points from AD 8 (≈167 °C, sensor short) to AD 243–255 (0 °C, sensor open). The rails double as fault markers; range checks against signed boundaries (−40 °C, −20 °C, +95 °C) set the sensor diagnostic bit.
- On AD-converter failure the ECU substitutes plausible fixed counts ([AD_kylv](../reference/symbols/AD_kylv.md) → 110 ≈ 66 °C; intake → 150) instead of a rail value — the engine is driven on a substitute temperature, and recovery is ramped ([Temp_fak](../reference/symbols/Temp_fak.md), below) so no fuel step appears when the sensor returns.
- At every start the ECU latches snapshots: [Start_kylv](../reference/symbols/Start_kylv.md) (coolant at start), [Start_tryck](../reference/symbols/Start_tryck.md) (manifold pressure at start), [S_Kyl_temp](../reference/symbols/S_Kyl_temp.md)/[S_Lufttemp](../reference/symbols/S_Lufttemp.md). Emissions decisions (secondary air, lambda startup) deliberately use these snapshots. The same start block (`Function_0005A4F4`) runs a plausibility comparison of **live** `Kyl_temp` vs `Luft_temp` (`0x5A5D6`–`0x5A5F6`): agreement within 10 °C sets `Diag_status` byte 3 bit 7 (`ORI.B #$80` at `0x5A5FA`); a ≥ 10 °C split branches and records the raw pair to unlabeled RAM `0x4028` (coolant) / `0x4026` (intake). Neither is read anywhere in ROM (`Diag_status` is cleared with the other diag bytes at `0x5E98E`; `0x4026`/`0x4028` are written exactly once) — status/diagnostic surface only, and the snapshots latch either way.
    - **In plain terms.** Each time the engine starts, the ECU records coolant temperature, intake-air temperature, and manifold pressure, then freezes those values for the rest of the drive. They refresh only while the engine is stopped, and they stop updating the moment it runs. The emissions functions read this record, never the live sensors, because the question they are answering is "how cold was the car when this drive began?" and not "how cold is it now?". Manifold pressure is the exception: it is stored only while the engine is stationary, and a fixed standstill value is written if the engine is already turning. The sensor cross-check exists because after a soak the two should read close together. If they are within 10 °C the ECU notes that they agree; if they are further apart it files the pair away. Nothing in the engine control reacts either way, and neither outcome is kept as a fault code. So a sensor that drifts is not caught, worked around, or remembered — its value is recorded at start and then trusted by the secondary-air and lambda-startup decisions for the whole drive.

## The warm-up stages

After each start the fueling passes through stages, each with its own [Temp_steg](../reference/symbols/Temp_steg.md)-indexed table interpolated on raw [AD_kylv](../reference/symbols/AD_kylv.md):

| Stage | Tables |
|---|---|
| Before start (priming) | [Before_start](../reference/symbols/Before_start.md), [Build_up_time](../reference/symbols/Build_up_time.md)/[Build_up_time_2](../reference/symbols/Build_up_time_2.md) (60-tick window below −10 °C) |
| Cranking | [Startvev_fak](../reference/symbols/Startvev_fak.md) × [Start_insp](../reference/symbols/Start_insp.md) → [Start_tid](../reference/symbols/Start_tid.md); flood-clear above [Start_trottel](../reference/symbols/Start_trottel.md); blend [Ramp_fak](../reference/symbols/Ramp_fak.md)/[Start_max](../reference/symbols/Start_max.md)/[Start_ramp](../reference/symbols/Start_ramp.md) |
| After start | [Eftersta_fak](../reference/symbols/Eftersta_fak.md) (→ [Eft_fak](../reference/symbols/Eft_fak.md)), set 2 [Eftersta_fak2](../reference/symbols/Eftersta_fak2.md); decay [Eft_dec_fak](../reference/symbols/Eft_dec_fak.md) → [Eft_dec](../reference/symbols/Eft_dec.md) |
| Running warm-up | [Tempkomp_konst](../reference/symbols/Tempkomp_konst.md) → [Temp_fak](../reference/symbols/Temp_fak.md) (recovery ramp via [Temp_ramp_value](../reference/symbols/Temp_ramp_value.md)) |
| Hot restart | [BS_temp](../reference/symbols/BS_temp.md) = 60 °C suppresses restart enrichment ([Restart_status](../reference/symbols/Restart_status.md)) |

Cranking enrichment runs ×0.06 (hot) to ×1.08 (−40 °C). The after-start stage holds one coefficient per cylinder — up to +89 % at the coldest point — and while the [Eft_dec](../reference/symbols/Eft_dec.md) counter is active, [Eft_fak](../reference/symbols/Eft_fak.md) is walked down one point per tick: that walk-down is the visible warm-up enrichment fade. The running coefficient adds up to +0.70× while cold and ramps out as the engine reaches temperature.

## Ignition and idle during warm-up

- [Ret_temp](../reference/symbols/Ret_temp.md) = interpolated [Retard_temp](../reference/symbols/Retard_temp.md): a ×1.40–2.00 retard multiplier applied in the ignition-time computation while cold. Despite adjacent research history it is **not** a knock table.
- [Acc_temp](../reference/symbols/Acc_temp.md) = interpolated [Accel_temp](../reference/symbols/Accel_temp.md) scales acceleration enrichment; the sensor-fault branch swaps in the flatter [Accel_temp2](../reference/symbols/Accel_temp2.md).
- Idle: [Rpm_idle_nom](../reference/symbols/Rpm_idle_nom.md) = interpolated [Idle_rpm_tab](../reference/symbols/Idle_rpm_tab.md) on the [I_kyl_st](../reference/symbols/I_kyl_st.md) °C axis (one of the few tables indexed in °C, not AD): 1100 rpm when cold, 900 rpm above 65 °C, plus [Iv_start_rpm_offset](../reference/symbols/Iv_start_rpm_offset.md) (+200 rpm) while starting.

## Emissions warm-up gates

- **Secondary air (air pump)** runs only during warm-up: [S_Kyl_temp](../reference/symbols/S_Kyl_temp.md)/[S_Lufttemp](../reference/symbols/S_Lufttemp.md) against the `Ap_min/max_*` calibration set, staged flow windows at 10/20/30/40/50 °C, disabled above `Ap_max_on_watertemp`.
- **Lambda startup**: first closed-loop entry is delayed on cold engines — the gate keys on [Start_kylv](../reference/symbols/Start_kylv.md) ≤ 10 °C / [S_Lufttemp](../reference/symbols/S_Lufttemp.md) ≤ 10 °C and [Lamb_temp](../reference/symbols/Lamb_temp.md) = 60 °C, with timers [Lamstart_time](../reference/symbols/Lamstart_time.md) and `Engine_start_time`.
- **Misfire monitoring** is held off below [Misf_kyltemp](../reference/symbols/Misf_kyltemp.md) = 18 °C, with band RPM thresholds from [Mis_kyltemp_tab](../reference/symbols/Mis_kyltemp_tab.md).
- Adaptation temperature fade is bounded by [Temp_limit_low](../reference/symbols/Temp_limit_low.md)/[Temp_limit_high](../reference/symbols/Temp_limit_high.md) at −40…−39 °C — a window never entered in practice.

## Counters

[Start_time](../reference/symbols/Start_time.md) (cranking duration, rpm < [Start_time_rpm_lim](../reference/symbols/Start_time_rpm_lim.md) = 650), [Start_time_tot](../reference/symbols/Start_time_tot.md) (start count), [Motortid](../reference/symbols/Motortid.md) (run-time ticks), plus lambda/ignition timers feeding the gates above.

---

Symbol reference: [T5 Symbols](../reference/symbol-index.md) · full working notes: [warmup_system](../evidence/warmup_system.md) · knock subsystem (sibling entry): [T5 Knock Detection and Adaptation](knock-detection-and-adaptation.md)
