# Trionic 5.5 boost (charge-pressure) control subsystem — working doc

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

Code paths traced on a commercial reflash (not distributed); listing: `firmware/4780656.asm` (factory image, same code layout, ROM base 0x40000).
Value authority: factory `firmware/4780656_factory.BIN` (raw bytes in `boost_tables.txt`).
Decompiles: `evidence/boost/func_*.json` (REA/Ghidra). Batch script `tools/boost_funcs.sh`.
Book grounding: `docs/trionic5_book.txt` — "Maps: Boost" chapter (~p42-58), PID chapter (~p64-73), APC/pinging p1331-1333, wastegate bleed prose p531/1910, limiter prose 1976-1980, fuel-cut prose 2000-2001.

Terminology: "APC" here = the T5's integrated charge-pressure control (boost solenoid, historically "Automatic Performance Control" valve), NOT the 1980s standalone Saab APC ignition box.

## 0. Architecture in one paragraph

Every regulation cycle (task at `Function_00072380`, called from the main compute pass at 0x6D148) executes a fixed chain:
request generation `F_00072F56` (state timers) → `F_000725B8` ([Tryck_mat](../reference/symbols/Tryck_mat.md) interpolation + overshoot comp + knock derate + gear/temperature limiters) → `F_000734C6` (overboost fuel-cut check) → `F_00072B5A` (PID gain lookup P/I/D_fors) → `F_00073550` (adaption learner + loop-state machine). The PID output sum itself is computed in the caller region ending at 0x734C2 (shown as part of `F_0007300C` decompile): [P_fak](../reference/symbols/P_fak.md)+[I_fak](../reference/symbols/I_fak.md)+[D_fak](../reference/symbols/D_fak.md)+[Reg_kon_apc](../reference/symbols/Reg_kon_apc.md)+[Apc_adapt](../reference/symbols/Apc_adapt.md) → [PWM_ut](../reference/symbols/PWM_ut.md) → hardware.
The physical final element is the boost-control solenoid ("APC valve") that bleeds boost pressure to the wastegate actuator (book p531, 1910). The ECU writes only its PWM: period word `RAM 0x3A88` (Hz) and duty [PWM_ut](../reference/symbols/PWM_ut.md) (0-980 = 0.0-98.0 %), programmed into the TPU by `F_000466F0`.

## 1. Boost request path

### 1.1 Tryck_mat / Tryck_mat_a (main request)
`Function_000725B8` 0x725BC-0x725F4:
- Manual (status byte 0x76E5 bit 1 clear): bilinear interpolation `F_00072972(Tryck_mat! 0x5BC6, throttle-axis bank, rpm axis, dims)`.
- Automatic (bit 1 set): same over `Tryck_mat_a! 0x5C46` with fixed axis bank at 0x5BAE.
- Axes: rpm axis `Pwm_ind_rpm! 0x5B6E` (16 words rpm×10, 1500-6500; legacy misnomer name) and throttle row axis `Pwm_ind_trot! 0x5B8E` (5 identical 8-byte banks [10,29,47,66,86,108,130,155]; bank = gear−1, gear code byte RAM 0x47F2; automatics use the bank at 0x5BAE).
- x-input = 0x47E8 = throttle opening = AD_trot (0x1015) minus idle floor 0x197B (0x72380 0x723AE-0x723BA). y-input = `RAM_Rpm` word 0x1066 (rpm×10).
- Layout: `Tryck_mat[rpm_col*8 + trot_row]`, values = kPa ABSOLUTE (book anchor "MAP over 140 kPa (0.4 bar)"; boost = raw−100). Factory: WOT column 1500 rpm = 194 (0.94 bar), peak 199; falls to 150-184 above ~4500 rpm (T25 limits, book).
- Request result byte → RAM 0x3352; final request → 0x3353 (see limiters).
- Diagnostic/display re-reads of the map at 0x5F4AC/0x5F76E (`F_0005F0B8`/`F_0005F574`) only format a "request %" field (MAP/request×255) for the T5 display frame; not in the control path.

### 1.2 Overshoot compensation (tip-in), 0x72600-0x72688
Active window: when AD_trot (0x1015) < [Overs_angle](../reference/symbols/Overs_angle.md) (0x5EB4, factory 160) the tip-in state clears (334B bit 4 off, counter 0x47D2 reset). At ≥160 (near-WOT step) the state sets; while counter < `Overstid_tab! 0x5D56[rpm_idx]` (16×40 factory) the request is extended:
`0x47CE = max(0, request − P_medel)` then `comp = interp(Overs_tab! 0x5CCE; error axis Overs_tab_xaxis 0x5D4E [0,5,16,32,48,64,80,96] kPa; rpm axis)` scaled by `Overs_komp_tab! /255` indexed `Lufttemp/10` (0..7).
`0x47B2 = request + comp` (saturate 255). Factory [Overs_tab](../reference/symbols/Overs_tab.md) all zero → inactive; this is the "pressure build-up speed vs transmission durability" knob the book ties to regulation-table tuning (p49-50).

### 1.3 Gear-based limiters, 0x72772-0x72858 (`Regl_tryck_fgm/sgm/fgaut`)
Applied to the byte at 0x3353 ([Regl_tryck](../reference/symbols/Regl_tryck.md)), indexed by rpm column 0x47D8 (search over rpm axis, first index whose next point passes rpm):
- Automatic-stage: if status 0x334C bit 7 set (set in 0x72380 when 0x7668 < 0x3608 ≠ 0xFFFF — a transmission-stage flag) → request = `Regl_tryck_fgaut![rpm_idx]`, flag 0x334C bit 6 set. Factory table = 255 (off).
- Manual: gear code 0x47F2 == 1 → cap to `Regl_tryck_fgm![rpm_idx]` (factory 158-163 ≈ 0.58-0.63 bar); gear 2 → cap [Regl_tryck_sgm](../reference/symbols/Regl_tryck_sgm.md) (194-199 ≈ 0.94-0.99 bar); both set 0x334C bit 6 ("limiter active").- Reverse: no table — in the output clamp chain (0x733E0 area, decompile 0x7300C): gear 'R' (and 0x76E3 bit 6 clear) forces duty to 2 % with cause byte 0x3FA2 = 0x10 (book: reverse limiter exists, reduces to basic boost).
- Gear code 0x47F2 is the transmission gear byte (characters 'R','D','U' for automatics mirrored at 0x72380 0x72496-0x724A6; 1..5 manual). Gear detection itself (book: "calculates which gear ... by comparing the speed of the automobile and the engine's RPM") consumes [Gear_st](../reference/symbols/Gear_st.md) (word ratios ×10: 13.7/7.1/4.8/3.6/2.7) + [Gear_ratio_delta](../reference/symbols/Gear_ratio_delta.md) — detection routine not traced further here (open item).

### 1.4 Intake-air-temperature charge-pressure cap (automatics), 0x7285C-0x728E0
Guard: 0x76E5 bit 1 set (automatic) only.
`cap_hot = F_0006A410(Max_regl_sp! 0x5F22 rpm-axis, Max_regl_temp_1! 0x5EE2, rpm) → 0x47EE`
`cap_cold = F_0006A410(Max_regl_sp!, Max_regl_temp_2! 0x5F02, rpm) → 0x47F0`
`cap = F_0006A314(Temp_max_regl! 0x5EE0 = [60,20] °C, [0x47EE,0x47F0], Lufttemp byte 0x1033)` — two-point linear interpolation/extrapolation on intake air temperature, word cap → `RAM_Regl_temp_max`; if request > cap, request = cap low byte.
Factory: 145-180 kPa ABS warm curve / 135-170 cold curve on descending rpm axis 6500→1500 — a real torque-management cap on automatics. [Max_regl_sp](../reference/symbols/Max_regl_sp.md) is the rpm axis (words 650→150 ×10), NOT a pressure table — the naming is misleading.
No altitude or air-mass-flow-based boost limiter was found in this chain (open item; the Lufttemp cap above is the only density-related correction).

### 1.5 Sensor-fault / overspeed derate, `F_00072906`
A byte derate counter 0x47A6 ramps +1/tick (cap 60) while RAM 0x101C > [Max_vehicle_speed](../reference/symbols/Max_vehicle_speed.md) (0x5B6C, factory 0xF0=240) and 0x76E3 bit 6 clear, else −1/tick to 0. At the end of 0x725B8 (0x728E4): request −= 0x47A6 (floor 0). Semantics of 0x101C unconfirmed (candidate: limp-home/fault byte; the book lists fault codes as boost-to-basic initiators). Flag: inference.

### 1.6 Knock derate of the request (APC), `F_00072DC2`, 0x72772-0x72796
(Deep dive in `knock_system.md`; summarized for the boost path.)
On each knock event (flag byte 0x1119 bit 4 set, 0x334B bit 1 clear): `Apc_decrese (0x334E) += Apc_knock_tab![event counter 0x47E4]` (factory +8 % per event, 8 entries, counter caps at 7), clamp 100, and set derate state (0x334B bit 1). Derate applied to request: `if 0x47B2 < 121 → 0x3353 = 0x47B2; else 0x3353 = max(0x47B2 − Apc_decrese, 0x78)` — floor 120 kPa ABS ≈ basic boost (book: "lowering ... to basic boost pressure").
Recovery: while derate active and P_Manifold (0x1013) has fallen below `0x47E2 = 0x47B2 − Apc_decrese` (with actual > 0x8B), a tick counter 0x47B8 runs; each [Apc_knock_back](../reference/symbols/Apc_knock_back.md) (0x5F62, factory 5) ticks it decrements [Apc_decrese](../reference/symbols/Apc_decrese.md) −1 %.
[Apc_decrese_asp](../reference/symbols/Apc_decrese_asp.md) (0x5EC8 = 0): floor override for [Apc_decrese](../reference/symbols/Apc_decrese.md) under a MAP-correction-table condition (0x1013 < 0x10FA and 0x10BE/C0/C2/C4 nonzero); factory 0 → unused.
Knock derate also scales the PID offset (below, §2.4) — book p72 formula (100−[Apc_decrese](../reference/symbols/Apc_decrese.md))/100 confirmed at 0x731E6-0x731F8.

### 1.7 Overboost fuel cut, `F_000734C6`
Per cycle: if `P_medel (0x3356, actual averaged MAP) > Tryck_vakt_tab![rpm_idx 0x47D8]` AND engine-run status 0x1039 bit 8 AND cut not already flagged (0x113E bit 5): set fuel-cut flags (0x1039 bit 5 "boost pressure fuel cut", 0x114A bit 4), zero [I_fak](../reference/symbols/I_fak.md) and integral accumulator, `Apc_adapt (0x345A) −= 50` (clamp −250; 0x1148 bit 7 when clamped). Factory table 230 = 1.30 bar absolute on all 16 rpm columns (book's 0xEB=1.35 example is a different stock file). 0xFF disables (book).

## 2. Closed loop (PID)

### 2.1 What the loop is
- Error input: `Regl_tryck (0x3353, requested kPa ABS) − P_medel (0x3356, actual)` — actual = running average of P_Manifold maintained at 0x6C696-0x6C6CC (sample buffer at 0x47B4). Signed error clamped to ≤ +0x80 → 0x47C8. |error| byte → 0x47B0 (`F_00072B5A`).
- Output applied to: [PWM_ut](../reference/symbols/PWM_ut.md) word 0x3476 (duty 0.0-98.0 %, i.e. ‰ counts) → [PWM_ut10](../reference/symbols/PWM_ut10.md) byte 0x3359 = PWM_ut/10 (%) → TPU PWM channel programmed by `F_000466F0(freq, duty)`: period counts = 0x50036/frequency, compare = period − period×duty/1000, written to TPU registers at 0xFFFFFFD4/0xFFFFFFD6 (auto-increment window). The solenoid bleeds boost pressure to the wastegate actuator (book).
- Book log list "[P_fak](../reference/symbols/P_fak.md), [I_fak](../reference/symbols/I_fak.md), [D_fak](../reference/symbols/D_fak.md), [Reg_kon_apc](../reference/symbols/Reg_kon_apc.md), [PWM_ut10](../reference/symbols/PWM_ut10.md), P_Manifold10, [Apc_decrese](../reference/symbols/Apc_decrese.md)" maps 1:1 to the RAM words below.

### 2.2 Gains — P_fors / I_fors / D_fors (`F_00072B5A`)
Three bilinear lookups (`F_00072972`) of the 7 rpm × 4 error byte tables:
rows = [Reg_varv](../reference/symbols/Reg_varv.md) rpm axis [2000,2250,2500,3000,4000,4500,5500] (×10), columns = [Reg_last](../reference/symbols/Reg_last.md) |error| axis [5,15,30,50] kPa. Manual tables P/I/D_fors, automatic `_a` variants (0x76E5 bit 1). Results: Kp → word 0x47C4, Ki → 0x47C2, Kd → 0x47C0. Book "Kp from [P_fors](../reference/symbols/P_fors.md) depends on RPM and boost error" confirmed ([Reg_last](../reference/symbols/Reg_last.md) is the error axis, not a load axis despite the name: "Reg last" = regulation load/error).

### 2.3 Controller terms (region 0x73250-0x73310, inside the 0x7300C decompile)
- `P_fak (0x347C) = Kp × err / 10`.
- Integral: accumulator 0x47C6 += err × Ki each cycle. Only while throttle-opening 0x47E8 ≥ [Apc_fullgas](../reference/symbols/Apc_fullgas.md) (85); otherwise [I_fak](../reference/symbols/I_fak.md) and the accumulator are forced 0. When |accumulator| ≥ 100 (book "cumulative pressure error > 100"): `I_fak (0x347A) += accumulator/100`, accumulator reset; negative side: accumulator < −100 → [I_fak](../reference/symbols/I_fak.md) −1/tick. Anti-windup clamp |[I_fak](../reference/symbols/I_fak.md)| ≤ [I_fak_max](../reference/symbols/I_fak_max.md) (0x5E9A = 400) (book default 400 confirmed).
- Derivative: `D_fak (0x3478) = ((P_medel_prev − P_medel) × Kd [+1 if negative]) >> 1` — derivative of measured pressure (previous cycle value snapshot 0x47D0). This is the [PWM_ut10](../reference/symbols/PWM_ut10.md)-error-rate term the book describes as Kd on the error slope.
- Sum: `0x47DC = P_fak + I_fak + D_fak + Reg_kon_apc + Apc_adapt` → duty.
- `Reg_kon_mat / Reg_kon_mat_a` (`F_0007300C` 0x73060-0x731B2): word offset table (31 entries) fetched DIRECT-indexed (no interpolation) by `0x47D6`: rpm<2510→0; rpm<5500→(rpm−250)/10; else 30 (2500-5500 rpm, 100-rpm grid). Gear caps: manual gear1 → min(table, [Reg_kon_fgm](../reference/symbols/Reg_kon_fgm.md)×10), gear≥2 limiter path → min(table, [Reg_kon_sgm](../reference/symbols/Reg_kon_sgm.md)×10); automatic → table vs [Reg_kon_fga](../reference/symbols/Reg_kon_fga.md)×10 (0x730B2-0x731AE). Then knock derate multiplier: if (throttle < 85 or Ki ≠ 0) and [Apc_decrese](../reference/symbols/Apc_decrese.md) ≠ 0: `Reg_kon_apc ×= (100 − Apc_decrese)/100`. Then intake-temp trim: Lufttemp(0x1033) ≤40 → +0; 41-80 → +(T−40)×2; ≥81 → +80. Result → [Reg_kon_apc](../reference/symbols/Reg_kon_apc.md) word 0x1154. Book: "[Reg_kon_mat](../reference/symbols/Reg_kon_mat.md) is an offset table that determines what offset to add to the PID controller's output" — exactly the feed-forward bias (factory manual ramp 424 counts @2500 → 335 @3500-3800 → 448 @5500; i.e. ~34-45 % base duty).
- [Apc_adapt](../reference/symbols/Apc_adapt.md) (word 0x345A, signed ±250): learned correction. `F_00073550` learner: window = throttle ≥ 0x6C, rpm 113-400 (×10; manual upper 400/auto 450), |[P_medel](../reference/symbols/P_medel.md) − request| ≤ 4, limiter flag 0x334C bit 6 clear, no knock derate; after [Adaption_time](../reference/symbols/Adaption_time.md) (5) settle ticks compares the feed-forward part against actual total duty: if (adapt+[Reg_kon_apc](../reference/symbols/Reg_kon_apc.md))×100/duty < 73 and adapt > −246 → adapt += 5; if ≥ 78 → adapt −= 5. Book guardrail "[Apc_adapt](../reference/symbols/Apc_adapt.md) should not equal 250" matches the learning authority. Reset: `CLR.W` at 0x5A056 (init/ignition).

### 2.4 Output clamp chain (0x73330-0x734C2)
min 2 (2 %) unless limiter forces it; max 0x3D4 = 980 = 98.0 % exactly (book: [PWM_ut10](../reference/symbols/PWM_ut10.md) max 98). Limiter causes write 0x3FA2 cause byte and clear I-term:
0x20/0x40/0x80/4/0x21-group ← status flags 0x1143 bit3, 0x1146 bit3, 0x334B bit3/bit2/bit4, 0x113E bit5 (fuel cut active);
0x10 ← reverse gear; 8 ← vehicle speed below minimum word 0x72A2 (gear detection assist) or battery below [DI_cassette_U_limit](../reference/symbols/DI_cassette_U_limit.md) (0x7341E-0x73432; book "low battery voltage" → basic boost).
rpm×10 < 100 (1000 rpm) → duty forced 2 (basic boost at startup/idle, book "basic charge pressure").
Diagnostic bypass: if 0x38C2 bit 6 set (diag mode) the TPU write is skipped (0x7349E-0x734A6).

### 2.5 Control frequency `Frek_230` / `Frek_250`
0x72516-0x72552 (and mirror in the engine-stopped branch 0x723C8 sets 90 Hz default):
`rpm×10 < 0xE6 (2300) → 0x3A88 = Frek_230!; rpm×10 > 0xFA (2500) → 0x3A88 = Frek_250!; between → hold (hysteresis).`
Factory 90 Hz / 70 Hz = the book's T5-valve values (switch ≈2500 rpm to avoid boost-hose resonance; 230/250 in the names = the rpm×10 thresholds). Word 0x3A88 is the frequency input to F_000466F0 alongside duty.

## 3. Derate/limit path summary (priority as coded, all applied to the request byte unless noted)
1. [Tryck_mat](../reference/symbols/Tryck_mat.md)(_a) request (0x3352).
2. \+ overshoot comp (0x47B2).
3. − knock derate [Apc_decrese](../reference/symbols/Apc_decrese.md) (floor 120 kPa) — 0x72776-0x72786.
4. = [Regl_tryck_fgaut](../reference/symbols/Regl_tryck_fgaut.md) if auto-stage flag; else cap by [Regl_tryck_fgm](../reference/symbols/Regl_tryck_fgm.md) (1st) / _sgm (2nd) — 0x727B0-0x72858.
5. = intake-air-temp cap Max_regl_temp_1/2 (automatics only) — 0x7285C-0x728E0.
6. − fault derate 0x47A6 — 0x728E4.
7. Output stage: forced 2 % (reverse, low speed, low battery, fuel cut, rpm<1000), max 98 %, knock scales [Reg_kon_apc](../reference/symbols/Reg_kon_apc.md) (not the request) and clears nothing by itself.
Overboost fuel cut (§1.7) is an independent safety net on actual pressure, not on the request.

## 4. State variables (RAM; addresses from decompiled operands — the embedded symbol table's sram_addr values for this family are off/swapped, e.g. its `Regl_tryck 0x345E`, `Tryck_mat_a! 0x5CC6`, `PWM_ut 0x3359` entries are wrong; ASM labels + decompile numbers are authoritative)

| word | RAM | meaning |
|---|---|---|
| [Regl_tryck](../reference/symbols/Regl_tryck.md) | 0x3353 B | final boost request, kPa ABS |
| (raw request) | 0x3352 B | [Tryck_mat](../reference/symbols/Tryck_mat.md) before limiters |
| (pre-knock) | 0x47B2 B | request + overshoot comp, before knock derate |
| P_Manifold | 0x1013 B | instantaneous MAP, kPa ABS |
| [P_medel](../reference/symbols/P_medel.md) | 0x3356 B | averaged actual pressure (loop feedback) |
| (prev actual) | 0x47D0 B | previous-cycle actual for D term |
| error / \|err\| | 0x47C8 W / 0x47B0 B | signed clamped error, abs error |
| [P_fak](../reference/symbols/P_fak.md) / [I_fak](../reference/symbols/I_fak.md) / [D_fak](../reference/symbols/D_fak.md) | 0x347C / 0x347A / 0x3478 W | PID terms |
| (int acc) | 0x47C6 W | integral accumulator (÷100 gate) |
| [Reg_kon_apc](../reference/symbols/Reg_kon_apc.md) | 0x1154 W | PID feed-forward offset incl. gear cap+knock scale+temp trim |
| [Apc_adapt](../reference/symbols/Apc_adapt.md) | 0x345A W | learned duty offset, ±250 |
| [PWM_ut](../reference/symbols/PWM_ut.md) | 0x3476 W | valve duty 0-980 (0.1 % counts) |
| [PWM_ut10](../reference/symbols/PWM_ut10.md) | 0x3359 B | duty in % (÷10) |
| freq word | 0x3A88 W | valve PWM frequency Hz |
| [Apc_decrese](../reference/symbols/Apc_decrese.md) | 0x334E B | knock boost derate, % |
| APC status 1 | 0x334B B | bit0 reg-active, bit1 knock derate, bit2 derate-pending, bit3 ?, bit4 tip-in, bit5 full-gas APC (throttle ≥ [Apc_fullgas](../reference/symbols/Apc_fullgas.md)), bit6 load-limit confirmed, bit7 const-load timer |
| APC status 2 | 0x334C B | bit6 gear limiter active, bit7 auto-stage limiter request |
| fuel cut flag | 0x1039 B bit5 | boost-pressure fuel cut (T5 status byte) |
| limiter cause | 0x3FA2 B | why duty was forced (0 = normal, 0x10 reverse, 8 speed/battery, 0x20/0x40/0x80/4 flag causes) |
| gear code | 0x47F2 B | gear ('R'/'D'/1..5); source byte 0x3355 |
| throttle opening | 0x47E8 B | AD_trot − idle floor; compared to [Apc_fullgas](../reference/symbols/Apc_fullgas.md) |
| rpm col idx | 0x47D8 B | index into 16-col rpm axis tables |
| Reg_kon idx | 0x47D6 B | (rpm−250)/10, 0..30 |
| knock derate state | 0x47E4 B event ctr, 0x47EC W rec-time, 0x47B8 W rec-tick, 0x47E2 W rec-target |
| fault derate | 0x47A6 B | ≤60 kPa slow derate |
| loop state | 0x479E B | F_73550 machine (0 ok,1-7 gate reasons, 0x6F adapted) |
| adapt timer | 0x47E6 B | settle counter vs [Adaption_time](../reference/symbols/Adaption_time.md) |

## 5. Verification / confidence
- Table enumeration, ROM/RAM addrs, factory bytes: verified programmatically from init copy instructions + both binaries (byte-exact).
- Chain order, limiters, PID terms, frequency switching, fuel cut, derate arithmetic: read directly from the disassembly listing (ASM label lines quoted by address) and REA decompiles (`evidence/boost/func_*.json`); unit interpretations use the book and the established MAP-kPa rule.
- Flagged inferences: 0x101C semantics (§1.5); 0x334B bit meanings beyond bit1/4/6 (bit names partly from book context); tick time bases (Overstid, [Apc_konst_tid](../reference/symbols/Apc_konst_tid.md), [Apc_cert_tid](../reference/symbols/Apc_cert_tid.md), [Apc_knock_back](../reference/symbols/Apc_knock_back.md), [Adaption_time](../reference/symbols/Adaption_time.md) counters — driven by the compute-pass tick, period not derived); exact caller set of 0x334B bit 7; gear detection internals (consumes Gear_st/Gear_ratio_delta); 0x72A2 writer.
- Dead calibration: [Max_um_time](../reference/symbols/Max_um_time.md), [Max_pos_der](../reference/symbols/Max_pos_der.md), [Max_neg_der](../reference/symbols/Max_neg_der.md), [Um_thr_lim](../reference/symbols/Um_thr_lim.md), [Um_min_limit](../reference/symbols/Um_min_limit.md) — copied flash→RAM but no references found anywhere in the listing (likely inherited derivative-limit scalars from an earlier revision). Documented in boost_tables.txt.

## PROPOSED SYMBOL PAGES
(name | type | address | factory value | function | code path | units)
- [Tryck_mat](../reference/symbols/Tryck_mat.md) | 8-bit table (16x8 bytes, flash) | ROM 0x412E0, RAM 0x5BC6 | peak 199 | main boost request map (rpm x throttle) | interpolated F_00072972 @0x725E2/0x7261E | kPa absolute (boost = raw-100)
- [Tryck_mat_a](../reference/symbols/Tryck_mat_a.md) | 8-bit table (16x8 bytes, flash) | ROM 0x41360, RAM 0x5C46 | peak 180 | boost request, automatic transmission | F_000725B8 0x725BC | kPa absolute
- [Pwm_ind_rpm](../reference/symbols/Pwm_ind_rpm.md) | 16-bit table (16 words, flash) | ROM 0x41288, RAM 0x5B6E | 1500-6500 rpm | shared regulation rpm axis (misnomer name) | axis for Tryck_mat/Tryck_vakt/Regl_tryck/Overs | rpm x10
- [Pwm_ind_trot](../reference/symbols/Pwm_ind_trot.md) | 8-bit table (5x8 bytes, flash) | ROM 0x412A8, RAM 0x5B8E | [10,29,47,66,86,108,130,155] x5 | throttle row axis, bank per gear | F_000725B8 bank=gear-1 | throttle AD counts
- [Tryck_vakt_tab](../reference/symbols/Tryck_vakt_tab.md) | 8-bit table (16, flash) | ROM 0x412D0, RAM 0x5BB6 | 230 all cols | overboost fuel-cut limit per rpm | F_000734C6 0x734D4 | kPa absolute (255=off)
- [Regl_tryck](../reference/symbols/Regl_tryck.md) | State word (RAM 0x3353) | 0x3353 | dynamic | final boost request after all limiters | written F_000725B8 tail; read F_00072B5A/0x7300C | kPa absolute
- [Regl_tryck_fgm](../reference/symbols/Regl_tryck_fgm.md) | 8-bit table (16, flash) | ROM 0x415C6, RAM 0x5F42 | 158-163 | 1st-gear max boost limiter (manual) | cap @0x72802-0x72816 | kPa absolute
- [Regl_tryck_sgm](../reference/symbols/Regl_tryck_sgm.md) | 8-bit table (16, flash) | ROM 0x415D6, RAM 0x5F52 | 177-199 | 2nd-gear max boost limiter (manual) | cap @0x7283C-0x72850 | kPa absolute
- [Regl_tryck_fgaut](../reference/symbols/Regl_tryck_fgaut.md) | 8-bit table (16, flash) | ROM 0x41554, RAM 0x5ED0 | 255 (off) | automatic-stage/transmission limiter | override @0x727BA-0x727CE | kPa absolute
- [Max_regl_sp](../reference/symbols/Max_regl_sp.md) | 16-bit table (16 words, flash) | ROM 0x415A6, RAM 0x5F22 | 6500->1500 desc | rpm axis for air-temp limiter curves | F_0006A410 calls 0x7287E/0x7289E | rpm x10
- [Max_regl_temp_1](../reference/symbols/Max_regl_temp_1.md) / [Max_regl_temp_2](../reference/symbols/Max_regl_temp_2.md) | 16-bit tables (16 words each, flash) | ROM 0x41566/0x41586, RAM 0x5EE2/0x5F02 | 145-180 / 135-170 | max charge pressure at warm / cold interp point (automatics only) | 0x72878->0x47EE / 0x72898->0x47F0, F_0006A314 on Lufttemp | kPa absolute
- [Temp_max_regl](../reference/symbols/Temp_max_regl.md) | Calibration words (flash, 2) | ROM 0x41564, RAM 0x5EE0 | [60, 20] | intake-air temp interpolation points for the two limiter curves | F_0006A314 0x728C4 | degC
- [Overstid_tab](../reference/symbols/Overstid_tab.md) | 8-bit table (16, flash) | ROM 0x41470, RAM 0x5D56 | 40 all | tip-in overshoot-comp duration per rpm | F_000725B8 0x72604 | ticks
- [Overs_tab](../reference/symbols/Overs_tab.md) / [Overs_tab_xaxis](../reference/symbols/Overs_tab_xaxis.md) / [Overs_komp_tab](../reference/symbols/Overs_komp_tab.md) | 8-bit tables (flash) | ROM 0x413E8/0x41468/0x413E0, RAM 0x5CCE/0x5D4E/0x5CC6 | all 0 / [0..96] / 255 | overshoot boost add-on (16 rpm x 8 shortfall), its kPa axis, intake-temp scaling /255 | interp @0x72630-0x72668 | kPa, kPa, /255
- [Overs_angle](../reference/symbols/Overs_angle.md) | Calibration word (flash) | ROM 0x4153D, RAM 0x5EB4 | 160 | throttle threshold to arm tip-in overshoot comp | 0x72608 | throttle AD counts
- [Reg_varv](../reference/symbols/Reg_varv.md) | 16-bit table (7 words, flash) | ROM 0x41480, RAM 0x5D66 | 2000-5500 | PID gain rpm axis | F_00072B5A lookups | rpm x10
- [Reg_last](../reference/symbols/Reg_last.md) | 8-bit table (4, flash) | ROM 0x4148E, RAM 0x5EAA | [5,15,30,50] | PID gain boost-error axis | F_00072B5A lookups | kPa error
- [P_fors](../reference/symbols/P_fors.md) | 8-bit table (7x4 bytes, flash) | ROM 0x41492, RAM 0x5D74 | rows 255/120/0-110 | proportional gain Kp manual | interp 0x72C5A -> 0x47C4 | dimensionless (x/10 in [P_fak](../reference/symbols/P_fak.md))
- [I_fors](../reference/symbols/I_fors.md) | 8-bit table (7x4, flash) | ROM 0x414AE, RAM 0x5D90 | 0-30 | integral gain Ki manual | interp 0x72C8E -> 0x47C2 | dimensionless
- [D_fors](../reference/symbols/D_fors.md) | 8-bit table (7x4, flash) | ROM 0x414CA, RAM 0x5DAC | 0-255 | derivative gain Kd manual | interp 0x72CC2 -> 0x47C0 | dimensionless
- [P_fors_a](../reference/symbols/P_fors_a.md) / [I_fors_a](../reference/symbols/I_fors_a.md) / [D_fors_a](../reference/symbols/D_fors_a.md) | 8-bit tables (7x4, flash) | ROM 0x414E6/0x41502/0x4151E, RAM 0x5DC8/0x5DE4/0x5E00 | (see tables file) | automatic PID gains | interp 0x72BB6-0x72C30 | dimensionless
- [Reg_kon_mat](../reference/symbols/Reg_kon_mat.md) | 16-bit table (31 words, flash) | ROM 0x415E8, RAM 0x5E1C | 424->335->448 | PID feed-forward duty offset vs rpm (manual) | F_0007300C 0x73132 -> [Reg_kon_apc](../reference/symbols/Reg_kon_apc.md) | PWM counts (0-980 scale)
- [Reg_kon_mat_a](../reference/symbols/Reg_kon_mat_a.md) | 16-bit table (31 words, flash) | ROM 0x41626, RAM 0x5E5A | 140->248->337 | PID offset, automatic | 0x730F2 | PWM counts
- [Reg_kon_fga](../reference/symbols/Reg_kon_fga.md) | Calibration word (flash) | ROM 0x41550, RAM 0x5ECA | 14 | Reg_kon cap automatic full-gas (x10) | 0x731A6-0x731AE | PWM counts /10
- [Reg_kon_fgm](../reference/symbols/Reg_kon_fgm.md) | Calibration word (flash) | ROM 0x41551, RAM 0x5ECC | 8 | Reg_kon cap 1st gear manual (x10) | 0x73120-0x73144 | PWM counts /10
- [Reg_kon_sgm](../reference/symbols/Reg_kon_sgm.md) | Calibration word (flash) | ROM 0x41552, RAM 0x5ECE | 255 (-1) | Reg_kon cap 2nd gear manual (x10) | 0x7315A-0x7316C | PWM counts /10
- [I_fak_max](../reference/symbols/I_fak_max.md) | Calibration word (flash, 16-bit) | ROM 0x41666, RAM 0x5E9A | 400 | anti-windup clamp of [I_fak](../reference/symbols/I_fak.md) | 0x732A0/0x732C8, 0x73720 | duty counts
- [Adaption_time](../reference/symbols/Adaption_time.md) | Calibration word (flash) | ROM 0x41664, RAM 0x5E98 | 5 | settle time before [Apc_adapt](../reference/symbols/Apc_adapt.md) update | F_00073550 | ticks
- [Frek_230](../reference/symbols/Frek_230.md) | Calibration word (flash, 16-bit) | ROM 0x41670, RAM 0x5EA6 | 90 | valve PWM frequency below 2300 rpm | 0x72530/0x7258A -> 0x3A88 | Hz
- [Frek_250](../reference/symbols/Frek_250.md) | Calibration word (flash, 16-bit) | ROM 0x41672, RAM 0x5EA8 | 70 | valve PWM frequency above 2500 rpm | 0x72546/0x7259C -> 0x3A88 | Hz
- [Apc_fullgas](../reference/symbols/Apc_fullgas.md) | Calibration word (flash) | ROM 0x4153C, RAM 0x5EB2 | 85 | full-load APC threshold; gates I-term + Reg_kon derate + full-gas flag | 0x72512, 0x73236, 0x7306E | throttle opening counts
- [Apc_konst_tid](../reference/symbols/Apc_konst_tid.md) / [Apc_cert_tid](../reference/symbols/Apc_cert_tid.md) / [Apc_frek](../reference/symbols/Apc_frek.md) | Calibration words (flash) | ROM 0x4153A/0x4153B/0x4153E, RAM 0x5EAE/0x5EB0/0x5EB6 | 255/0/0 | const-light-load flag timer / limiter-confirm timer / optional loop prescaler (unused) | F_00072F56, 0x723F4 | ticks / cycles
- [Apc_knock_tab](../reference/symbols/Apc_knock_tab.md) | 8-bit table (8, flash) | ROM 0x40AC0, RAM 0x641E | 8 x8 | APC boost derate step per knock event | F_00072DC2 0x72DFC | % derate
- [Apc_knock_back](../reference/symbols/Apc_knock_back.md) | Calibration word (flash) | ROM 0x42EAA, RAM 0x5F62 | 5 | derate recovery: -1% every N ticks | F_00072DC2 | ticks
- [Apc_decrese](../reference/symbols/Apc_decrese.md) | State word (RAM 0x334E) | 0x334E | dynamic | current knock boost derate, max 100 | F_00072DC2; applied 0x72782 | %
- [Apc_decrese_asp](../reference/symbols/Apc_decrese_asp.md) | Calibration word (flash) | ROM 0x4154F, RAM 0x5EC8 | 0 (unused) | alternative floor for [Apc_decrese](../reference/symbols/Apc_decrese.md) | 0x72E54 | %
- [Reg_kon_apc](../reference/symbols/Reg_kon_apc.md) | State word (RAM 0x1154) | 0x1154 | dynamic | active feed-forward duty offset (gear+knock+temp corrected) | F_0007300C; summed 0x7330x | PWM counts
- [PWM_ut](../reference/symbols/PWM_ut.md) / [PWM_ut10](../reference/symbols/PWM_ut10.md) | State words (RAM 0x3476 W / 0x3359 B) | 0x3476/0x3359 | 2-980 / 0-98 | valve duty output (0.1% counts) and percent copy | summed @0x73484-0x73498; -> F_000466F0 | 0.1% counts / %
- [P_fak](../reference/symbols/P_fak.md) / [I_fak](../reference/symbols/I_fak.md) / [D_fak](../reference/symbols/D_fak.md) | State words (RAM 0x347C/0x347A/0x3478) | dynamic | proportional Kp*err/10, integral (clamp +-[I_fak_max](../reference/symbols/I_fak_max.md)=400, full-gas gate), derivative on d([P_medel](../reference/symbols/P_medel.md))/cycle | 0x7325A / 0x7326x anti-windup / 0x732FA | PWM counts
- [Apc_adapt](../reference/symbols/Apc_adapt.md) | State word (RAM 0x345A) | 0x345A | dynamic | learned duty adaption +-250 | F_00073550 learner, fuel-cut penalty | PWM counts
- [P_medel](../reference/symbols/P_medel.md) | State word (RAM 0x3356) | 0x3356 | dynamic | averaged actual manifold pressure (loop feedback) | 0x6C6CC; error @0x72B70 | kPa absolute
- [Reg_freq](../reference/symbols/Reg_freq.md) | State word (RAM 0x3A88) | 0x3A88 | 90 | valve PWM frequency word | 0x72530/0x7258A; consumed F_000466F0 | Hz
- [APC_status](../reference/symbols/APC_status.md) / [Regl_status2](../reference/symbols/Regl_status2.md) | State words (RAM 0x334B / 0x334C) | 0x334B/0x334C | bitfields | loop flags (bit1 knock derate, bit4 tip-in, bit6 load-limit) / bit6 gear limiter active, bit7 auto-stage request | all chain functions | flags
- [Limiter_cause](../reference/symbols/Limiter_cause.md) | State word (RAM 0x3FA2) | 0x3FA2 | bitfield | reason duty was forced to 2%/98% (0x10 reverse, 8 speed/batt, ...) | clamp chain 0x73330-0x73470 | cause code
- [Regl_temp_max](../reference/symbols/Regl_temp_max.md) | State word (RAM, F_725B8 A2) | ([Regl_temp_max](../reference/symbols/Regl_temp_max.md) label) | dynamic | air-temp limiter cap result | 0x728D0 | kPa absolute
- [Fault_derate](../reference/symbols/Fault_derate.md) | State word (RAM 0x47A6) | 0x47A6 | 0-60 | slow fault/overspeed derate of request | F_00072906; applied 0x728E4 | kPa
- [Max_vehicle_speed](../reference/symbols/Max_vehicle_speed.md) | Calibration word (flash) | ROM 0x42BDC, RAM 0x5B6C | 240 | threshold feeding the derate counter | F_00072906 | 0x101C units (uncertain)
- [Gear_st](../reference/symbols/Gear_st.md) / [Gear_ratio_delta](../reference/symbols/Gear_ratio_delta.md) | 16-bit + 8-bit tables (flash) | ROM 0x41540/0x4154A, RAM 0x5EB8/0x5EC2 | 13.7/7.1/4.8/3.6/2.7; [15,9,4,3,3] | overall gear ratios and detection windows for gear identification from speed vs rpm | gear detection (untraced) | ratio x10 / ratio x10
- [Boost_valve_pwm_driver](../reference/symbols/Boost_valve_pwm_driver.md) | Function | 0x466F0 | — | programs TPU period/duty for boost solenoid | F_000466F0(period=0x50036/Hz) | counts
- [Max_um_time](../reference/symbols/Max_um_time.md) / [Max_pos_der](../reference/symbols/Max_pos_der.md) / [Max_neg_der](../reference/symbols/Max_neg_der.md) / [Um_thr_lim](../reference/symbols/Um_thr_lim.md) / [Um_min_limit](../reference/symbols/Um_min_limit.md) | Calibration words (flash, UNUSED) | ROM 0x41668/6A/6C/6E, 0x4166F | 32/5/-10/96/50 | no code references in this revision (legacy derivative-limit scalars) | init copy only | mixed
