# T5 Boost Control

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

> **Summary:** Charge-pressure control is a per-cycle chain: **request** from [Tryck_mat](../reference/symbols/Tryck_mat.md) (rpm × throttle) → overshoot compensation → **knock derate** → **gear / transmission limiters** → **intake-air-temperature cap** (automatics) → fault derate; the result [Regl_tryck](../reference/symbols/Regl_tryck.md) (kPa absolute) is compared against averaged actual MAP ([P_medel](../reference/symbols/P_medel.md)) and closed by a **PID with feed-forward** (`P/I/D_fors` gains, [Reg_kon_mat](../reference/symbols/Reg_kon_mat.md) duty offset, [Apc_adapt](../reference/symbols/Apc_adapt.md) learned term) whose output [PWM_ut](../reference/symbols/PWM_ut.md) (0–98.0 %) drives the boost-control solenoid that bleeds boost pressure to the wastegate actuator.


Working evidence: `source/boost_system.md`, raw bytes `source/boost_tables.txt`, decompiles in `t5-re/evidence/boost/`. Chain root: `Function_00072380` (main compute pass).

## Request path

- [Tryck_mat](../reference/symbols/Tryck_mat.md) (manual) / [Tryck_mat_a](../reference/symbols/Tryck_mat_a.md) (automatic): 16 rpm columns × 8 throttle rows, byte = **kPa absolute** (boost ≈ raw − 100). rpm axis [Pwm_ind_rpm](../reference/symbols/Pwm_ind_rpm.md) (1500–6500), throttle axis [Pwm_ind_trot](../reference/symbols/Pwm_ind_trot.md) (bank = gear−1). Factory WOT ≈ 194–199 (0.94–0.99 bar), tapering above ~4500 rpm.
- Tip-in overshoot compensation: near-WOT steps ([Overs_angle](../reference/symbols/Overs_angle.md) threshold) extend the request by an interpolated shortfall comp while under [Overstid_tab](../reference/symbols/Overstid_tab.md) duration, scaled by [Overs_komp_tab](../reference/symbols/Overs_komp_tab.md) × intake temp. **Factory tables are zero — feature disabled.**
- Knock derate: each knock event adds [Apc_knock_tab](../reference/symbols/Apc_knock_tab.md) (+8 % factory) to [Apc_decrese](../reference/symbols/Apc_decrese.md); the request is reduced by it with a floor at 120 kPa ≈ basic boost. Recovery −1 % per [Apc_knock_back](../reference/symbols/Apc_knock_back.md) ticks (factory 5). Knock also scales the feed-forward offset by (100 − [Apc_decrese](../reference/symbols/Apc_decrese.md))/100 — the book's APC formula, confirmed at `0x731E6`.
- Gear limiters (manual): 1st gear caps to [Regl_tryck_fgm](../reference/symbols/Regl_tryck_fgm.md) (0.58–0.63 bar), 2nd to [Regl_tryck_sgm](../reference/symbols/Regl_tryck_sgm.md) (0.94–0.99 bar); automatic stage variant [Regl_tryck_fgaut](../reference/symbols/Regl_tryck_fgaut.md) (factory 255 = off). A limiter above the main map is effectively off (book rule). Reverse forces 2 % duty directly at the output stage.
- Intake-air-temperature cap (automatics only): warm/cold charge-pressure curves [Max_regl_temp_1](../reference/symbols/Max_regl_temp_1.md)/[Max_regl_temp_2](../reference/symbols/Max_regl_temp_2.md) on the descending rpm axis [Max_regl_sp](../reference/symbols/Max_regl_sp.md), interpolated between [Temp_max_regl](../reference/symbols/Temp_max_regl.md) points [60, 20] °C by intake temp.
- Sensor/fault derate: slow counter (≤ 60 kPa) while a fault byte exceeds [Max_vehicle_speed](../reference/symbols/Max_vehicle_speed.md). **No altitude/air-mass limiter exists** in this chain.
- Overboost fuel cut: [P_medel](../reference/symbols/P_medel.md) > [Tryck_vakt_tab](../reference/symbols/Tryck_vakt_tab.md) (factory 230 = 1.30 bar absolute, all rpm) sets the boost fuel-cut flag, zeroes the integral, and penalizes [Apc_adapt](../reference/symbols/Apc_adapt.md) by −50. Independent safety net on *actual* pressure.

## Closed loop

Error = `Regl_tryck − P_medel`. Gains bilinear from [P_fors](../reference/symbols/P_fors.md)/[I_fors](../reference/symbols/I_fors.md)/[D_fors](../reference/symbols/D_fors.md) on axes [Reg_varv](../reference/symbols/Reg_varv.md) (rpm ×10, 2000–5500) × [Reg_last](../reference/symbols/Reg_last.md) (**boost-error kPa — an error axis despite the "load" name**):

- `P_fak = Kp × err / 10`
- Integral gated to throttle ≥ [Apc_fullgas](../reference/symbols/Apc_fullgas.md) (85); accumulator |·| ≥ 100 feeds [I_fak](../reference/symbols/I_fak.md), anti-windup clamp [I_fak_max](../reference/symbols/I_fak_max.md) = ±400 (book-confirmed).
- [D_fak](../reference/symbols/D_fak.md) = derivative of *measured* pressure × `Kd`.
- Feed-forward [Reg_kon_mat](../reference/symbols/Reg_kon_mat.md): 31-entry duty offset direct-indexed at 100-rpm steps 2500–5500 rpm (factory ~34–45 % duty), gear-capped (`Reg_kon_fgm/sgm/fga`), knock-scaled, plus an intake-temp trim (+2 %/°C above 40 °C, cap +80).
- Learned [Apc_adapt](../reference/symbols/Apc_adapt.md) (±250): in a steady window (throttle ≥ [Apc_fullgas](../reference/symbols/Apc_fullgas.md), load rpm band, error ≤ 4, no limiter/knock) compares feed-forward share of actual duty against a 73–78 % band and trims ±5 — the book's "[Apc_adapt](../reference/symbols/Apc_adapt.md) should not sit at 250" guardrail.

Sum → [PWM_ut](../reference/symbols/PWM_ut.md) (0–980 = 0.1 % counts, max exactly 98 %), → TPU via `F_000466F0` with period `0x50036/Hz`. Valve frequency: [Frek_230](../reference/symbols/Frek_230.md) = 90 Hz below 2300 rpm, [Frek_250](../reference/symbols/Frek_250.md) = 70 Hz above 2500 rpm, hold in between (hysteresis) — anti-resonance measure per the book.

Below 1000 rpm, in reverse, at low battery ([DI_cassette_U_limit](../reference/symbols/DI_cassette_U_limit.md)) or low speed: forced 2 % duty (basic boost). Cause code recorded in [Limiter_cause](../reference/symbols/Limiter_cause.md).

## Factory-side notes

Factory-side finding worth recording: five dead calibration scalars ([Max_um_time](../reference/symbols/Max_um_time.md) …) are copied to RAM but never referenced in either image. Index: [T5 Symbols](../reference/symbol-index.md)
