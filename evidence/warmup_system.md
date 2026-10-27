# Trionic 5.5 warmup cycle and temperature inputs

Working notes on a commercial reflash (not distributed) vs factory `firmware/4780656_factory.BIN`. Assembly evidence: `firmware/4780656.asm`. Companion: `knock_system.md` (knock), wiki pages under `Wiki/T5-Tuning/`.

> **Summary:** Coolant and intake-air temperature enter the ECU as 8-bit AD counts, are converted to signed °C through lookup tables, and drive every warmup stage: cranking enrichment ([Startvev_fak](../reference/symbols/Startvev_fak.md)), after-start enrichment ([Eftersta_fak](../reference/symbols/Eftersta_fak.md)/[Eft_dec_fak](../reference/symbols/Eft_dec_fak.md)), the running temperature coefficient ([Tempkomp_konst](../reference/symbols/Tempkomp_konst.md)), ignition retard ([Retard_temp](../reference/symbols/Retard_temp.md)), idle speed ([Idle_rpm_tab](../reference/symbols/Idle_rpm_tab.md)), secondary-air and lambda startup gates.## 1. Sensor inputs and raw conversion

- Coolant sensor: NTC resistor on the sensor supply, read through the TPU ADC. The raw 8-bit count lands in the AD buffer at RAM `0x4054` and is copied to [AD_kylv](../reference/symbols/AD_kylv.md) (RAM) at `0x69FB2`. If the AD conversion fails, the code substitutes the fixed count `0x6E` = 110 (`0x69F9C`), which is ≈ 66 °C on the conversion table — a plausible-value limp substitute, not a rail value.
- Intake-air sensor: same path from AD buffer `0x4052` to [AD_lufttemp](../reference/symbols/AD_lufttemp.md); failure substitute is `0x96` = 150 (`0x69FCA`).
- Because the sensor is NTC, **low AD count = hot, high AD count = cold**. All coolant-AD-indexed calibration tables in this subsystem therefore run "warm on the left" — the axis [Temp_steg](../reference/symbols/Temp_steg.md) (ROM `0x40B24`, 15 points 40…241) ascends in AD, i.e. descends in temperature.

### 1.1 AD → °C conversion

[Kyl_temp](../reference/symbols/Kyl_temp.md) (signed °C) is produced from [AD_kylv](../reference/symbols/AD_kylv.md) by linear interpolation of [Kyltemp_tab](../reference/symbols/Kyltemp_tab.md) (ROM `0x40B58`, 19 B) on axis [Kyltemp_steg](../reference/symbols/Kyltemp_steg.md) (ROM `0x40B45`, 19 B), via the shared interpolation routine `Function_0006A4E4`:

| AD ([Kyltemp_steg](../reference/symbols/Kyltemp_steg.md)) | 8 | 9 | 11 | 15 | 19 | 26 | 34 | 45 | 58 | 74 | 96 | 124 | 150 | 174 | 201 | 220 | 234 | 243 | 255 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| °C ([Kyltemp_tab](../reference/symbols/Kyltemp_tab.md)) | 167 | 166 | 160 | 147 | 137 | 125 | 114 | 104 | 94 | 84 | 72 | 59 | 49 | 40 | 29 | 18 | 8 | 0 | 0 |

Read-out behavior at the rails: AD below the first point (sensor shorted) pins the conversion at the hot end (167 °C region, outside the valid window), AD 243…255 (sensor open) pins at 0 °C. Both rails trip the sensor-plausibility checks (§1.3). The operating band is roughly AD 60–230 for 100 °C down to ≈ 12 °C.

Intake temperature uses the parallel axis [Lufttemp_steg](../reference/symbols/Lufttemp_steg.md) (ROM `0x40B6E`, 16 B, AD points `[11…255]` — same NTC AD spacing family as [Kyltemp_steg](../reference/symbols/Kyltemp_steg.md)) and its °C table (companion `Lufttemp_tab`, values not dumped here), producing `Luft_temp` in °C.

### 1.2 Start snapshots

On the start transient the ECU latches the ambient state:
- [Start_kylv](../reference/symbols/Start_kylv.md) ← [Kyl_temp](../reference/symbols/Kyl_temp.md) at `0x5A5B0` (inside the start-recognition block; the same block also writes [Start_tryck](../reference/symbols/Start_tryck.md) ← `P_Manifold`, or the constant `0x50` if the engine was already turning).
- [S_Kyl_temp](../reference/symbols/S_Kyl_temp.md) ← [Kyl_temp](../reference/symbols/Kyl_temp.md) and [S_Lufttemp](../reference/symbols/S_Lufttemp.md) ← `Luft_temp` at `0x5ABDA`/`0x5ABE4` — "start-of-trip" snapshots consumed by the secondary-air logic (§7.1) and the lambda-startup gate (§7.2), so those decisions use the temperature at start, not the live value.
- Plausibility: immediately after latching, the code compares [Kyl_temp](../reference/symbols/Kyl_temp.md) against `Luft_temp ± 10 °C` (`0x5A5D6`–`0x5A5F6`) — the **live** °C registers, not the snapshots. Agreement (|Δ| < 10 °C) sets `Diag_status` byte 3 bit 7 (`ORI.B #$80,(00001141)`; byte 3 of the 18-byte `Diag_status` block `0x113E`–`0x114F`). A ≥ 10 °C split branches (`LBL_0005A612`) and records the raw pair to unlabeled RAM `0x4028` (coolant) / `0x4026` (intake). Bit 7 is never read in ROM (cleared at `0x5E98E` with the other diag bytes); `0x4026`/`0x4028` are written exactly once, never read — a diagnostic recorder. No strategy consequence: the snapshots latch on both paths. *(Earlier text claimed the ≥10 °C split "flags the intake sensor path" — corrected 2026-10-27 against the asm: the ≥10 °C branch is the record-and-skip path; the bit set is the agreement fall-through.)*

### 1.3 Sensor validity

Range checks against signed-°C boundaries (the boundary immediates are the negative encodings — byte `0xD8` = −40 °C, `0xEC` = −20 °C):
- `CMPI.B #$D8, Kyl_temp` / `Luft_temp` at `0x58D6A`/`0x58DAE`,
- checks against `0xEC`/`0x5F` at `0x59114`/`0x59132` (−20 °C / +95 °C), matching the knock gate window recorded in `knock_system.md`.

A failed coolant sensor sets the diagnostic bit (`0x103B` bit 7 / `0x76E5` bit 7). Downstream consumers change behavior on that bit: the fuel temperature coefficient switches to a fixed re-interpolation path, the acceleration coefficient swaps [Accel_temp2](../reference/symbols/Accel_temp2.md) in for [Accel_temp](../reference/symbols/Accel_temp.md) (§6), and the enrichment ramp-down routine (§5.3) arms.

## 2. Cycle stages and the tables that own them

The warmup cycle runs through distinct fueling stages after each start; each stage has its own coolant-AD-indexed table, all interpolated on the common 15-point [Temp_steg](../reference/symbols/Temp_steg.md) axis by `Function_0006A4E4`:

| Stage | Table (ROM) | Scale |
|---|---|---|
| Before start (priming) | [Before_start](../reference/symbols/Before_start.md) (0x40F14) | time |
| Cranking | [Startvev_fak](../reference/symbols/Startvev_fak.md) (0x4085E) | ×128 → ×0.06…1.08 |
| Cranking→run blend | [Ramp_fak](../reference/symbols/Ramp_fak.md) (0x4063F) | ÷128 ≈ 1.00 |
| After-start enrichment | [Eftersta_fak](../reference/symbols/Eftersta_fak.md) (0x4086D) | ÷128 add |
| After-start enrichment 2 | [Eftersta_fak2](../reference/symbols/Eftersta_fak2.md) (0x4087C) | ÷128 add |
| After-start decay | [Eft_dec_fak](../reference/symbols/Eft_dec_fak.md) (0x4088B) / `_2` (0x4089A) | per-tick |
| Running temp coefficient | [Tempkomp_konst](../reference/symbols/Tempkomp_konst.md) (0x408AB) | ÷128 |
| Ignition retard | [Retard_temp](../reference/symbols/Retard_temp.md) (0x40B14) | ÷128 |
| Idle speed target | [Idle_rpm_tab](../reference/symbols/Idle_rpm_tab.md) (0x4111A) | ×10 rpm |

([Startvev_fak](../reference/symbols/Startvev_fak.md) = "start vev" = crank-shaft start factor; `Eftersta` = "after start", Swedish naming as with the knock tables.)

### 2.1 Cranking (`Function_0006EF58`, `Function_0006F1F2` neighbors)

While the starter turns the engine (rpm below running threshold), the per-cylinder injection time [Start_tid](../reference/symbols/Start_tid.md) is computed at `0x6EF86`–`0x6EFAA`:

```
interp = Interp(Startvev_fak!, Temp_steg!, AD_kylv)
Start_tid = interp × Start_insp ; MULU at 0x6EFAC, Start_insp = 2250 (word)
```

scaled through [Start_proc](../reference/symbols/Start_proc.md) (128) into the injection-time array (`0x6F090` → `0x4748+Cyl_nr`). Supporting scalars: [Start_insp](../reference/symbols/Start_insp.md) (base injection count word, `0x40BAC`), [Start_trottel](../reference/symbols/Start_trottel.md) = 150 — the throttle-AD threshold above which enrichment is suppressed (flood-clear, `0x6F0EC`), [Start_dead_tab](../reference/symbols/Start_dead_tab.md) — an all-zero 15 B dead-pulse table (feature disabled in both tunes), and the post-catch ramp: [Start_count](../reference/symbols/Start_count.md) compared against [Start_max](../reference/symbols/Start_max.md) (14) and [Start_ramp](../reference/symbols/Start_ramp.md) (34) at `0x6F14C`–`0x6F164` while [Ramp_fak](../reference/symbols/Ramp_fak.md) (÷128, ≈ 1.00 across the range) blends cranking fuel into running fuel. [Grund_tid](../reference/symbols/Grund_tid.md) holds the base running injection time that the blend targets.

### 2.2 Before-start / build-up (`Function_0006EE26` region)

Before the cranking tables take over, a "build-up" window primes enrichment: [Before_start](../reference/symbols/Before_start.md) interpolated on AD (`0x6EEF0`–`0x6EF04`) and a time-window select — [Build_up_time](../reference/symbols/Build_up_time.md) (30) vs [Build_up_time_2](../reference/symbols/Build_up_time_2.md) (60) chosen by comparing [Kyl_temp](../reference/symbols/Kyl_temp.md) against [Build_up_time_switch](../reference/symbols/Build_up_time_switch.md) (byte `246` = −10 °C signed, `0x6EF22`). Below −10 °C the longer 60-tick window applies. Exact tick duration depends on the task period; scaling is inference.

### 2.3 After start (`Function_0006F1F2`, `Function_0006F314`)

After firing, enrichment leaves the cranking tables and enters the after-start stage:

```
Eft_fak_bas = Interp(Eftersta_fak!, Temp_steg!, AD_kylv) ; 0x6F220
Eft_fak_bas2 = Interp(Eftersta_fak2!, Temp_steg!, AD_kylv) ; 0x6F342
Eft_dec = Interp(Eft_dec_fak!, Temp_steg!, AD_kylv) ; 0x6F284, −1 at 0x6F298
```

Two coefficient sets ([Eft_fak](../reference/symbols/Eft_fak.md) / [Eft_fak2](../reference/symbols/Eft_fak2.md)) are maintained as per-cylinder arrays (indexed by `Cyl_nr` at `0x6F2A0`–`0x6F2C2`), selected by the stage byte checked against `#1`/`#2` at `0x6F1FA`. While [Eft_dec](../reference/symbols/Eft_dec.md) is non-zero, [Eft_fak](../reference/symbols/Eft_fak.md) is decremented one point at a time (`SUBQ.B #1,(Eft_fak)`, `0x6F2E4`) — the warmup enrichment walk-down. `Restart_fak` is folded in when the restart path (§4) is armed. The coefficients are added to the injection-time build with the ÷128 house scaling (raw 99 ≈ +77 %); the scaling itself is inference — the ÷128 convention matches every neighboring table, but no fixed-point shift is visible in the slice.

### 2.4 Hot restart (`Function_0006EE26`)

When the engine stalls while running (rpm → 0 with [Pgm_status](../reference/symbols/Pgm_status.md) bit 0 set), the restart path arms ([Restart_status](../reference/symbols/Restart_status.md) bits). Coolant temperature above [BS_temp](../reference/symbols/BS_temp.md) (60 °C, `0x40B13`-family scalar) suppresses the restart enrichment (`0x6EE56`–`0x6EE62`: branch skipped only when the 0x20 status bit is set or `Kyl_temp > BS_temp`): a warm restart is fueled like a normal restart, a cold restart re-uses the enrichment. Restart also flushes the injection-time array (via [Insp_tid](../reference/symbols/Insp_tid.md), `0x6EED4`+) and sets the post-restart blend counters.

## 3. Running temperature coefficient (`Function_00069B20`)

Once running, the base fuel temperature correction is [Temp_fak](../reference/symbols/Temp_fak.md):

- Normal path: `Temp_fak = Interp(Tempkomp_konst!, Temp_steg!, AD_kylv)` — gated by [Pgm_mod](../reference/symbols/Pgm_mod.md) bit 3 (active program) at `0x69B32`.
- With the coolant-sensor diagnostic bit set, the same interpolation is forced each cycle and [Pgm_status](../reference/symbols/Pgm_status.md) bit 6 is set (`0x69BA6`–`0x69BBC`).
- Recovery ramp: when the sensor comes back (bit 6 was set, diagnostic bit now clear), [Temp_fak](../reference/symbols/Temp_fak.md) is **walked down one point per [Temp_ramp_value](../reference/symbols/Temp_ramp_value.md) (20) ticks** (`0x69BE2`–`0x69C12`) until it reaches 0, then bit 6 clears. This prevents a fuel step when a flaky sensor's substitute values disappear.

## 4. Ignition side

Computed in the same housekeeping block (`Function_0006D384`):

- Mode flags: `Kyl_temp < 60 °C` sets [Pgm_status](../reference/symbols/Pgm_status.md) bit 4 (`0x6D388`), i.e. "still warming"; otherwise with intake ≥ 18 °C, a status byte (`0x103A`) bit 3 is set (`0x6D3AE`).
- Acceleration enrichment coefficient: `Acc_temp = Interp(Accel_temp!, Temp_steg!, AD_kylv)` (values 51…223, ÷128 = 0.40…1.74); on coolant-sensor failure the fallback table [Accel_temp2](../reference/symbols/Accel_temp2.md) (stock-identical) is used instead (`0x6D3E6` vs `0x6D404`).
- Warmup ignition retard: `Ret_temp = Interp(Retard_temp!, Temp_steg!, AD_kylv)` at `0x6D41E`. Raw values 179…255 (÷128 = 1.40…2.00) — the multiplier never reaches unity inside the table body (points 12–13 hold the raw 128 = 1.00 encoding). Applied in the ignition-time computation (`0x6C2DC`, `0x6EC0C`). (Same table flagged in `knock_system.md` as *not* knock.)
- Idle: see §5.

## 5. Idle speed warmup

The nominal-idle block (`0x6F5EE`–`0x6F730`) computes the nominal idle speed target [Rpm_idle_nom](../reference/symbols/Rpm_idle_nom.md):

```
Rpm_idle_nom = InterpW(Idle_rpm_tab!, I_kyl_st!, Kyl_temp) ; 0x6F63E–0x6F64A
if starting: Rpm_idle_nom += Iv_start_rpm_offset (20 → +200 rpm)
Rpm_idle_nom += Idle_rpm_off (0 in both tunes) ; A/C-style offset, unused here
```

Axis [I_kyl_st](../reference/symbols/I_kyl_st.md) (8 B, signed °C, descending): `[65, 50, 35, 20, 5, −5, −20, −40]`. Values are words in units of 10 rpm:

| ≥65 °C | ≥50 | ≥35 | ≥20 | ≥5 | ≥−5 | ≥−20 | ≤−40 |
|---|---|---|---|---|---|---|---|
| factory | 900 | 950 | 1000 | 1100 | 1100 | 1100 | 1100 | 1100 |

[Idle_temp_off](../reference/symbols/Idle_temp_off.md) (ROM `0x40FE6`, 8 words `[0, 30, 50, 80, 100, 140, 200, 324]`, interpolated at `0x6FACE`) feeds the idle enrichment cut-out; exact role inference.

The stepper/ignition interaction ([Ign_idle_angle](../reference/symbols/Ign_idle_angle.md), [Ign_idle_angle_start](../reference/symbols/Ign_idle_angle_start.md) at `0x6F76A`) switches to a dedicated idle advance map during the start/idle window.

## 6. Intake-air correction

[I_luft_st](../reference/symbols/I_luft_st.md) (ROM `0x4115A`, 8 B signed °C `[65,55,45,35,25,15,10,−40]`) indexes the intake-air correction table (adjacent ROM `0x41132` region, 8 words `[25,20,20,20,20,15,0,0]` — fuel correction against intake air state; direction/scaling inference). The [Lufttemp_steg](../reference/symbols/Lufttemp_steg.md) axis (§1.1) covers the same sensor for the °C conversion path.

## 7. Emissions warmup gates

### 7.1 Secondary air (air pump) — `Function_0004A63E`

Secondary-air operation is a warmup-only function and is gated entirely on the start snapshots: [S_Kyl_temp](../reference/symbols/S_Kyl_temp.md)/[S_Lufttemp](../reference/symbols/S_Lufttemp.md) against `Ap_min_watertemp`, `Ap_min_airtemp`, `Ap_max_start_airtemp`, `Ap_max_start_watertemp`, `Ap_max_on_watertemp` (`0x4A6A0`–`0x4A7F6`), plus time delays (`Ap_start_delay`, `Ap_max_on_time`) and staged flow windows keyed to temperature bands via the immediates 10/20/30/40/50 °C (`CMPI.B #$0A/#$14/#$1E/#$28/#$32`, `0x4A742`–`0x4A890`). Above `Ap_max_on_watertemp` the pump is disabled; `Ap_inj_factor_delay` and `Ap_lambda_delay` hold off enrichment correction and closed-loop while air is flowing.

### 7.2 Lambda startup — `Function_0005DEE4`

First closed-loop entry is delayed on cold engines: with [Lamstart_time](../reference/symbols/Lamstart_time.md) = 0 (never been closed-loop this key-on), the gate at `0x5DF18` requires `Start_kylv ≤ 10 °C` **or** `S_Lufttemp ≤ 10 °C` to proceed with the startup enrichment/lambda timer logic; timers (`Engine_start_time`, `Cl_timer1/3`) stage the closed-loop entry. The scalar [Lamb_temp](../reference/symbols/Lamb_temp.md) (60 °C) is the lambda-enable coolant threshold (RAM copy consumed by the lambda control block); [Misf_kyltemp](../reference/symbols/Misf_kyltemp.md) (18 °C) additionally gates misfire-monitoring activity (9 call sites `0x641FC`–`0x65C66`, RPM thresholds per temperature band in [Mis_kyltemp_tab](../reference/symbols/Mis_kyltemp_tab.### 7.3 Adaptation temperature windows

Ignition- and K-adaptation fade windows reference the same sensor: [Temp_limit_low](../reference/symbols/Temp_limit_low.md)/[Temp_limit_high](../reference/symbols/Temp_limit_high.md) (bytes 216/217 = −40/−39 °C signed) bracket a window that is never entered in practice — effectively disabling adaptation fade by temperature (recorded in `knock_system.md`).

## 8. Cycle counters

- [Start_time](../reference/symbols/Start_time.md) — cranking duration counter: incremented while rpm < [Start_time_rpm_lim](../reference/symbols/Start_time_rpm_lim.md) (0x028A = 650 rpm) at `0x6D00C`–`0x6D022`; also mirrored into the diagnostic frame array (`0x1D18`).
- [Start_time_tot](../reference/symbols/Start_time_tot.md) — total start count, max-tracked in `Start_time_tot_max` (`0x6D03C`), service/service-indicator basis.
- [Motortid](../reference/symbols/Motortid.md) — engine-running tick counter, incremented per running-cycle at `0x6D2CA`.
- `Engine_start_time`, [Lamstart_time](../reference/symbols/Lamstart_time.md), `Diag_tid` — running timers consumed by the lambda-startup gate (§7.2).

## 9../reference/symbols/Kyltemp_steg.md)/[Kyltemp_tab](../reference/symbols/Kyltemp_tab.md)), [Temp_steg](../reference/symbols/Temp_steg.md), [Startvev_fak](../reference/symbols/Startvev_fak.md), [Ramp_fak](../reference/symbols/Ramp_fak.md), [Retard_temp](../reference/symbols/Retard_temp.md), [Accel_temp](../reference/symbols/Accel_temp.md)/[Accel_temp2](../reference/symbols/Accel_temp2.md), [Before_start](../reference/symbols/Before_start.md), build-up scalars, [BS_temp](../reference/symbols/BS_temp.md)/[Lamb_temp](../reference/symbols/Lamb_temp.md)/[Misf_kyltemp](../reference/symbols/Misf_kyltemp.md) scalars, [Start_insp](../reference/symbols/Start_insp.md)/[Start_max](../reference/symbols/Start_max.md)/[Start_ramp](../reference/symbols/Start_ramp.md)/[Start_proc](../reference/symbols/Start_proc.md)/[Start_trottel](../reference/symbols/Start_trottel.md); only fuelling amounts and the idle target are re-tuned, the warmup structure is untouched.
## 10. Open items

1. Exact fixed-point scaling of [Eft_fak](../reference/symbols/Eft_fak.md)/`Eftersta_*` and [Start_insp](../reference/symbols/Start_insp.md) (÷128 assumed from house convention; no shift visible in the slice).
2. [Idle_temp_off](../reference/symbols/Idle_temp_off.md) consumer semantics (idle enrichment cut-out vs temperature band).
3. [Before_start](../reference/symbols/Before_start.md)/[Build_up_time](../reference/symbols/Build_up_time.md) tick duration (task period not yet identified).
4. Whether [Eft_fak](../reference/symbols/Eft_fak.md) decrement ticks are time-based or injection-count-based ([Eft_dec](../reference/symbols/Eft_dec.md) re-loads per `Cyl_nr` pass).
5. [Restart_status](../reference/symbols/Restart_status.md) bit map (0x10/0x04/0x20/0x80 observed at `0x6EE26`–`0x6EED4`, not fully resolved).
