# T5.5 ignition timing calculation subsystem (factory 4780656 disassembly and values)

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

Scope: how the ECU computes the final ignition angle every crank-sync ignition event — base map
arbitration ([Ign_map_0](../reference/symbols/Ign_map_0.md)..8, [Ign_idle_angle](../reference/symbols/Ign_idle_angle.md)), every correction term, knock/idle/warm-up/transient
links, and the output path. Raw table bytes: `ignition_tables.txt`. Decompiles (REA/Ghidra
evidence): `evidence/ignition/func_0x62102.json` (core) and siblings. Ground-truth prose:
`docs/trionic5_book.txt` pp 36-47 (ignition regulation, maps), knock appendix pp 145-148.

Units convention used throughout: every ignition angle word is signed, 0.1 crank degrees per count.
Evidence: final clamp window at 0x63AE6-0x63AFE is -100..+400 (= -10.0..+40.0 deg, matching a real
ignition range); factory [Ign_map_0](../reference/symbols/Ign_map_0.md) values 0..360 (= 0..36 deg, MBT-plausible); book idle point
"6-8 deg BTDC" vs [Ign_idle_angle](../reference/symbols/Ign_idle_angle.md)! factory = 70; log byte [Ign_angle_byte](../reference/symbols/Ign_angle_byte.md) = ([Ign_angle](../reference/symbols/Ign_angle.md)+100)/10 gives
the book's 0..50 deg display scale (book p ~2038 logs [Ign_angle](../reference/symbols/Ign_angle.md)).

## 1. Inputs and sensors
- Engine speed: RAM word `RAM_Rpm` 0x1066, units rpm x10 (gates compare 0x190=400 -> 4000 rpm at
 0x6C0BC; [Ret_up_rpm](../reference/symbols/Ret_up_rpm.md) 150 = 1500 rpm). Filtered copy 0x3B72 used for the multi-spark rpm window.
- Load: 8-bit MAP sensor count (2.5-bar sensor, count ~= kPa absolute). Interpolation uses a
 "Last"/Medellast byte 0x1032 and per-channel load/rpm coordinate pairs precomputed per event
 (0x4664-0x468A, written by the event handler 0x638BE from rpm and MAP/rpm-interpolation indices
 like Knock_wind code: 0x4688/0x468A for map0).
- Coolant NTC -> [AD_kylv](../reference/symbols/AD_kylv.md) -> [Kyl_temp](../reference/symbols/Kyl_temp.md) degC (0x102E); intake NTC -> Lufttemp AD byte (0x1035).
 Lufttemp selects the warm-up map crossfade (with [Temp_limit_low](../reference/symbols/Temp_limit_low.md)!/high! 0x42896/0x42897).
- TPS/idle switch, coast, gear: status bytes 0x76E5 (idle bits, e.g. bit $02 idle-map select),
 0x76E6 (bit $02 = idle branch active with weight, bit $08 = AIR pump on, bit $10 = idle-weight
 active), RAM_Gear (0x3356), RAM_Bil_hast (vehicle speed, vs Hast_grans!).
- Knock subsystem outputs: [Ret_mangd](../reference/symbols/Ret_mangd.md)[4] bytes (0x3A40.., per-cyl retard event counters),
 [Knock_level](../reference/symbols/Knock_level.md) 0x112C, Knock_map_offset/lim runtime words, adaptive offset work word 0x3896.
- Idle controller output: idle torque angle word 0x4770 (seeded from RAM_Ign_idle_angle!).
- API idle-governor (adaptive idle) outputs [API_dt_offset_tab](../reference/symbols/API_dt_offset_tab.md) index -> work word 0x390E.
- Crank sync angle word 0x3BEC -> copy 0x4690 (values 0 / 0xB4 / 0x168 / 0x21C = 0/180/360/540 deg)
 selects the per-cylinder ignition offset at the final sum.
- Trans/comfort inputs for torque requests: flags 0x39A0 (upshift request), 0x39A2 (downshift),
 set by the transmission/comfort arbitration elsewhere.

## 2. Function map (ROM addresses)
- `0x48896` ISR chain: ignition crank-sync interrupt service routine; calls 0x43B74 after the
 angle pass. `0x488A8` companion handler: multi-spark pulse scheduling (RAM_Multispark,
 RAM_Mult_time -> TPU), reads RAM_Ign_angle for the pulse window.
- `Function_00063712` (0x63712): ignition event preparation. Multi-spark decision:
 [Kyl_temp](../reference/symbols/Kyl_temp.md) < 0 degC AND rpm < 425 -> [Mult_time](../reference/symbols/Mult_time.md)=5000; rpm <= 850 -> [Mult_time](../reference/symbols/Mult_time.md)=3000; else off.
 (Book: multi-spark below 0 degC coolant up to ~900 rpm, 210/s.)
- `Function_000638BE` (0x638BE, evidence func_0x638be.json): per-event orchestrator. Precomputes
 all map interpolation coordinate pairs (0x4664..0x468A), increments Ign_counter/Ign_counter2/
 Ign_counter3 (0x1086/0x108A) against [Ign_counter_mis_lim](../reference/symbols/Ign_counter_mis_lim.md)!/Sync_rpm!, calls knock offset engine
 Function_00062842 (0x63ABA), then calls CalculateIgnitionAngle (0x63ADE) unless bypassed
 (0x3B78 set -> force 10 deg, or 0x76E6 bit $40), clamps and stores result.
- `CalculateIgnitionAngle` = `Function_00062102` (0x62102-0x62840, labeled in listing;
 evidence func_0x62102.json): the main angle calculation. Described in section 4.
- `Function_00061F30` (evidence func_0x61f30.json): generic 2-D map interpolation
 (map, x_frac, x_int, y_axis, x_axis, y_idx_pair). Same engine used by knock maps.
- `Function_00061600` (evidence func_0x61600.json): generic weight-ramp engine for the map blend.
 Channel index in stack arg; shared target word 0x3B02; per-channel up/down rates from
 RAM_Ramp_up_ram!/Ramp_down_ram! (0x42876/0x42886, 8 words each); produces RAM_Weight[ch]
 (= 0x3994, 8 words, 0..1000 scale).
- `Function_00062842` (0x62842, evidence func_0x62842.json): knock offset engine (see knock
 subsystem notes) — consumes Knock_map_offset/Knock_map_lim at 0x63444, produces [Ret_mangd](../reference/symbols/Ret_mangd.md)
 demands; runs immediately before the angle calculation.
- `Function_0006BFA4` (evidence func_0x6bfa4.json): per-cylinder load transient detector.
 NOT the spark scheduler: builds Lacc_mangd/Lret_mangd fuel demand via Lacc_konst!/Lret_konst!
 maps scaled by [Acc_temp](../reference/symbols/Acc_temp.md) / [Ret_temp](../reference/symbols/Ret_temp.md) ([Ret_temp](../reference/symbols/Ret_temp.md) at 0x6C2DC). This is the fuel-side sibling of
 the ignition path; [Ret_temp](../reference/symbols/Ret_temp.md) (warm-up multiplier, [Retard_temp](../reference/symbols/Retard_temp.md)! table 1.40..2.00x) acts HERE,
 not on the angle sum.
- `Function_0006E722` (evidence func_0x6e722.json): per-cylinder knock-retard demand handler.
 Increments [Ret_mangd](../reference/symbols/Ret_mangd.md)[cyl] by ([Retard_konst](../reference/symbols/Retard_konst.md)! interp x [Ret_temp](../reference/symbols/Ret_temp.md))/256, decays by
 ([Max_ret_dec](../reference/symbols/Max_ret_dec.md)! x prev)/256 per event, clamps via [Ret_tab_mul](../reference/symbols/Ret_tab_mul.md)!/255, mirrors history into 0x3A40,
 sets per-cyl active bits in RAM_Ret_ind (0x10,0x20,0x40,0x80).
- `Function_0006C402` (evidence func_0x6c402.json): start/restart handler. Seeds
 0x4770 := RAM_Ign_idle_angle! at 0x6C456; forces RAM_Ign_angle := 100 (=10.0 deg) and
 [Mult_time](../reference/symbols/Mult_time.md) := 5000 at 0x6C58E-0x6C596 (book: start angle 10 deg BTDC).
- `Function_0006F450` (evidence func_0x6f450.json): idle speed controller; writes
 [Rpm_idle_nom](../reference/symbols/Rpm_idle_nom.md) (0x1160) and manages the idle angle work word 0x4770 — normally
 0x4770 := RAM_Ign_idle_angle! (0x6F752), but if idle has been outside band for Diag_tid it
 substitutes RAM_Ign_idle_angle_start! (18.0 deg, 0x6F76A). Idle-torque modulation of 0x4770
 happens in the same controller region; the anti-stall/hold behavior (flag set at 0x622DE
 bit $04 @0x1139, cleared at 0x62354) holds the idle angle when vehicle speed exceeds
 Hast_grans! (book: advance up to 20 deg to prevent stall).
- `Function_0004AAC6` (evidence func_0x4aac6.json): AIR-pump ignition advance ramp. Steps
 current offset by [Ap_ign_step](../reference/symbols/Ap_ign_step.md)! (0.5 deg) up to [Airpump_ign_offset](../reference/symbols/Airpump_ign_offset.md)! cap and subtracts it from
 the angle sum input when active (0x76E6 bit $08). Factory target offset = 0 (feature off;
 book p6010 [Airpump_ign_offset](../reference/symbols/Airpump_ign_offset.md)!).
- `Function_000610D2` (K-adapt sampler): initializes the adaptive ignition offset work word
 0x3896 from [Ign_offset_adapt](../reference/symbols/Ign_offset_adapt.md)! (0x611AA) / clears it when a learning run completes.
- `Function_000694B2`: all-cyl knock fuel enrichment gate — inside rpm window
 [Ret_down_rpm](../reference/symbols/Ret_down_rpm.md)!..[Ret_up_rpm](../reference/symbols/Ret_up_rpm.md)! (900..1500 rpm) with knock status and rpm deficit >= [Ret_delta_rpm](../reference/symbols/Ret_delta_rpm.md)!,
 loads [Ret_fuel_fak](../reference/symbols/Ret_fuel_fak.md) := [Ret_fuel_tab](../reference/symbols/Ret_fuel_tab.md)! (102). This is the book's "adds a small amount of fuel
 when all four cylinders knock" response; the ignition counterpart is the map2 overlay.

## 3. Base map selection — simultaneous weighted blend, not a switch
CalculateIgnitionAngle evaluates ALL relevant maps every event and blends them by weights:

 angle_blend = sum(map_value[i] * weight[i]) / sum(weight[i])

Sources and their weight words (weight scale 0..1000, RAM_Weight base 0x3994):

| value word | source | weight word | enabled by |
|---|---|---|---|
| [Ign_map_value](../reference/symbols/Ign_map_value.md) 0x3984 | Ign_map0 (warm base) | 0x3994 ([Weight](../reference/symbols/Weight.md)[0]) | RAM_Weight[0]!=0 block at 0x62122; always computed |
| 0x398C | Ign_map4 (warm-up) | 0x399C ([Weight](../reference/symbols/Weight.md)[4]) | crossfade by Lufttemp between [Temp_limit_low](../reference/symbols/Temp_limit_low.md)! and [Temp_limit_high](../reference/symbols/Temp_limit_high.md)! AD counts (linear ramp 0x624FE-0x6256E) |
| 0x3986 | idle angle = 0x4770 (+ Ign_map1 or Ign_map8 correction per rpm-error axis) | 0x3996 ([Weight](../reference/symbols/Weight.md)[1]) | 0x76E6 bit $10 set (idle governor active); sub-branch on 0x76E5 bit $02 (idle map on/off) and Gear==1/2 (0x62452: in gear 1 or 2 use bare [Ign_idle_angle](../reference/symbols/Ign_idle_angle.md), else bare value + map1 correction) |
| 0x398E | Ign_map5 (flat +2.0 deg) | 0x399E ([Weight](../reference/symbols/Weight.md)[5]) | channel-5 condition flag (setter not traced; constant +2.0 deg overlay) |
| 0x3990 | Ign_map6 (upshift torque reduction) | 0x39A0 ([Weight](../reference/symbols/Weight.md)[6]) | 0x39A0 nonzero (TC upshift request); value from map6 5x5 rpm/load |
| 0x3992 | Ign_map7 (downshift) | 0x39A2 ([Weight](../reference/symbols/Weight.md)[7]) | 0x39A2 nonzero |
Weights ramp per event through Function_00061600 at rates from [Ramp_up_ram](../reference/symbols/Ramp_up_ram.md)!/Ramp_down_ram!:
factory up-rates [1000,1000,0,0,0,0,20,100], down-rates [1000,1000,1000,250,0,0,0,0] — base and
idle engage instantly, upshift engages slowly (20/ch event), decays slowly, knock overlay decays
fast (1000), transient overlay decays at 250. Map8 (coast idle) is added to the idle blend value
0x3986 directly (0x623E0), all-zero in factory.

Additional cap: when 0x39A6 == 0 (flag owned by knock engine), the blended result D2 is replaced
by the idle-excluded blend D4 if larger (0x6265C-0x6266C) — i.e. while knock retard is active the
idle-torque branch may not push the angle above what the base/warm-up/gearshift blend gives
(inference on direction from CMP/BLE at 0x62666; consistent with knock priority).

Book prose agrees: map0 = normal (warm), map4 = warm-up, map1 = idle torque control, map2 =
knock retard overlay when MAP > 140 kPa, map3 = transient, map6 = upshift torque reduction,
map7 = downshift, map8 = idle during coast. Map5 is undocumented in the book (16 rpm-row curve,
factory constant 20 = +2.0 deg).

## 4. Correction terms applied after the blend (in code order, 0x6266E-0x62838)
1. Knock retard overlay: Ign_map2 (16 rpm x 8 load starting at 128 = above ~atmospheric)
 interpolated at 0x62684/0x626BE (either always-on or weight-gated path by 0x3998). Result
 word 0x3988. Also produces runtime diagnostics: RAM_Knock_map_offset (0x10BA) = weight0x3998 x
 map2 value / 1000, RAM_Knock_map_lim (0x10B8) = map2 value + [Knock_ang_dec](../reference/symbols/Knock_ang_dec.md)! (2.0 deg), both
 consumed by knock engine F_00062842.
2. Global knock subtract: D2 -= [Knock_offset](../reference/symbols/Knock_offset.md)! (0x41822; factory 0) at 0x62776.
3. API idle governor subtract: D2 -= word 0x390E at 0x62824. 0x390E/0x3910 hold the API
 (adaptive idle) retard/advance offset selected from [API_dt_offset_tab](../reference/symbols/API_dt_offset_tab.md)! with [API_dt_delay](../reference/symbols/API_dt_delay.md)!/
 [API_dt_ramp](../reference/symbols/API_dt_ramp.md)! ramping (0x61D0E-0x61E62). This is idle-stability spark dither.
4. Transient overlay add: D2 += (weight0x399A x map3 value)/1000 (0x626F4-0x627A4), also stored
 to RAM word [Trans_offset](../reference/symbols/Trans_offset.md) (0x3D... runtime copy; constant in flash is 0x41824=0). Factory
 Ign_map3 is all zeros — transient ignition advance exists but is disabled in factory tune.
5. Global fixed offset: D2 += [Ign_offset](../reference/symbols/Ign_offset.md)! (0x4284A, factory 0).
6. Per-cylinder offset: D2 += Ign_offset_cylN! (0x4284C-0x52) selected by crank sync angle word
 0x4690: 0xB4 -> cyl4, 0x168 -> cyl2, 0x21C -> cyl1, else cyl3. Factory all 0 (per-cyl trim).
7. AIR pump advance: if 0x76E6 bit $08, D2 = F_0004AAC6(D2) — subtracts the ramped airpump
 offset (factory cap 0).
8. Adaptive knock ignition offset: D2 += work word 0x3896 (0x6282E), the live copy of
 [Ign_offset_adapt](../reference/symbols/Ign_offset_adapt.md)! (factory -100 = -10.0 deg as init; maintained by the K-adapt routine).
9. Clamp: -100..+400 counts (-10.0..+40.0 deg) at 0x63AE6/0x63AF2; store RAM_Ign_angle 0x10B4.
10. Log byte: [Ign_angle_byte](../reference/symbols/Ign_angle_byte.md) (0x3902) = ([Ign_angle](../reference/symbols/Ign_angle.md) + 100)/10 (0x63B0E), 1 deg steps, -10..+40
 window — the scale T5Suite logs as [Ign_angle](../reference/symbols/Ign_angle.md).

Knock per-cylinder retard ([Ret_mangd](../reference/symbols/Ret_mangd.md)) is NOT summed into this global angle here; it is applied
per cylinder downstream (see section 6). [Knock_reduce](../reference/symbols/Knock_reduce.md) 1.5 deg/event and [Knock_back](../reference/symbols/Knock_back.md) recovery
mechanics are documented in notes/knock_system.md; [Ret_mangd](../reference/symbols/Ret_mangd.md)[cyl] counts events of 1.5 deg
(15 counts) with cap [Knock_lim_tab](../reference/symbols/Knock_lim_tab.md)[rpm] (3..13 deg), handled by F_00062842 and F_0006E722.

Warm-up note: [Ret_temp](../reference/symbols/Ret_temp.md) (RAM 0x1043-region byte, from [Retard_temp](../reference/symbols/Retard_temp.md)! 0x40B14, /128 = 1.40..2.00)
is named "retard" but multiplies deceleration-enrichment demand (F_0006BFA4 0x6C2DC, F_0006E722
0x6EC0C) — it scales fuel, not crank angle. The genuine warm-up ignition function is the
Ign_map4 crossfade. Keep this separation in docs (naming trap, matches warmup notes).

## 5. Starting / multi-spark
- At start (F_0006C402): [Ign_angle](../reference/symbols/Ign_angle.md) forced to 100 (10.0 deg, book exact) and [Mult_time](../reference/symbols/Mult_time.md)=5000.
- F_00063712 arms RAM_Multispark when [Kyl_temp](../reference/symbols/Kyl_temp.md) < 0 degC and rpm (0x3B72) < 850 (5000 ticks
 below 425 rpm, 3000 ticks 425-850). Multi-spark pulses are emitted by the 0x488A8 handler:
 it schedules pulses between the primary spark point ([Ign_angle](../reference/symbols/Ign_angle.md) + 300 counts) using
 [Mult_time](../reference/symbols/Mult_time.md) as the tick period (0x488DE-0x48906), i.e. repeated sparks from ~10 BTDC to ATDC,
 matching the book's 210/s description. Disabled during knock evaluation (ion window).

## 6. Output path
RAM_Ign_angle (0x10B4, 0.1 deg BTDC) is the single angular output of this subsystem. It is
consumed by:
- the ignition event ISR chain at 0x488xx (sync event -> next spark scheduling, cassette
 trigger lines pins 9-12 per book; per-cylinder offsets come from the 0x4690 sync word and the
 [Ret_mangd](../reference/symbols/Ret_mangd.md) demand bytes),
- the multi-spark pulse scheduler (0x488A8),
- the diagnostic analog logger (0x593E8: Ign_angle/5 + 80 for the serial stream),
- knock window placement (knock subsystem reads [Ign_angle](../reference/symbols/Ign_angle.md) at 0x60BA6/0x60BE6 to open the ion
 window after spark).
No coil-dwell (charge-time) table exists in this subsystem: the T5 ignition cassette holds the
400 V charge rail and the ECU only grounds the trigger lines (book p36); "[Overs_tab](../reference/symbols/Overs_tab.md)!/Overstid_tab!
/Overs_komp_tab!/Overs_angle!" are APC boost-monitoring tables (naming trap, used at 0x725B8 with
[Tryck_mat](../reference/symbols/Tryck_mat.md)), NOT dwell. Dwell is therefore effectively fixed/cassette-side; the ECU-side angle
output above is the full authority.

## 7. State variables (RAM)
0x10B4 [Ign_angle](../reference/symbols/Ign_angle.md) (final, 0.1 deg), 0x3902 [Ign_angle_byte](../reference/symbols/Ign_angle_byte.md) (log), 0x3984 [Ign_map_value](../reference/symbols/Ign_map_value.md) (map0),
0x3986 idle blend value, 0x3988 map2 value, 0x398A map3 value, 0x398C map4 value, 0x398E map5
value, 0x3990 map6 value, 0x3992 map7 value, 0x3994-0x39A2 [Weight](../reference/symbols/Weight.md)[0..7], 0x399C warm-up weight,
0x39A6 knock-priority cap flag, 0x3896 adaptive offset work word, 0x390E/0x3910 API idle offset
work words, 0x3A40-0x3A43 [Ret_mangd](../reference/symbols/Ret_mangd.md)[4] (knock retard event counters; history mirror 0x3A50),
0x1043 [Ret_ind](../reference/symbols/Ret_ind.md) (per-cyl retard active bitmask; symbol-table name collision with [Ret_temp](../reference/symbols/Ret_temp.md) noted),
0x10BA [Knock_map_offset](../reference/symbols/Knock_map_offset.md), 0x10B8 [Knock_map_lim](../reference/symbols/Knock_map_lim.md), 0x1108 [Mult_time](../reference/symbols/Mult_time.md), 0x1118 [Multispark](../reference/symbols/Multispark.md),
0x4770 idle angle work word, 0x4664-0x468A per-channel interpolation coordinate pairs,
0x4690 crank sync angle word, 0x3B02 weight ramp target, 0x3B72 filtered rpm, 0x1D0A
Knock_count_cyl1, Ign_counter(Ign_counter_mis) + Ign_counter2 0x1086 + Ign_counter3 0x108A
(ignition-event counters for misfire/O2 windows), 0x1151 [Ret_fuel_fak](../reference/symbols/Ret_fuel_fak.md).

## Factory-side notes

IDENTICAL to factory: every correction mechanism in code, Ign_map_1/3/5/6/7/8, all axes except
map0/map2 x-axes, [Ign_offset](../reference/symbols/Ign_offset.md)* (all 0), [Ign_offset_adapt](../reference/symbols/Ign_offset_adapt.md) (-10.0), Ramp_up/down_ram, [Knock_offset](../reference/symbols/Knock_offset.md),
[Trans_offset](../reference/symbols/Trans_offset.md), Airpump set, Ret_* scalars, [Retard_temp](../reference/symbols/Retard_temp.md)!, multi-spark gates.
## Open questions
- Exact sum point of per-cylinder [Ret_mangd](../reference/symbols/Ret_mangd.md) x 1.5 deg into the commanded spark instant
 (downstream of RAM_Ign_angle, in the 0x48xxx event scheduling / TPU compare write).
- Setter of the channel-5 gate (0x399E, Ign_map5 +2 deg condition) and flag 0x39A6 owner
 semantics beyond knock-priority inference.
- [Ign_map_1](../reference/symbols/Ign_map_1.md) y-axis (0x41AAC) decodes to [-460,-196,-166,-146,-86,0,30,250,400,1650,2000] —
 plausibly rpm error vs [Rpm_idle_nom](../reference/symbols/Rpm_idle_nom.md); exact reference unconfirmed. Map8 axis is a clean
 +/-100 rpm-error axis supporting that reading.
- [Ret_ind](../reference/symbols/Ret_ind.md) (0x1043) vs symbol-table [Ret_temp](../reference/symbols/Ret_temp.md) same-address collision — one table entry is wrong.
- [Ign_offset_adapt](../reference/symbols/Ign_offset_adapt.md) factory -10.0 deg: initial value vs learned-range center not established.

## PROPOSED SYMBOL PAGES
[Ign_map_0](../reference/symbols/Ign_map_0.md) | Calibration word (flash) | ROM 0x4186A | factory 0..360 (rows shown in ignition_tables.txt) | warm-engine base ignition advance vs rpm x load | interpolated in CalculateIgnitionAngle F_00062102 0x62126, blend weight 0x3994 | 0.1 crank degree (BTDC)
[Ign_map_0_x_axis](../reference/symbols/Ign_map_0_x_axis.md) | 8/16-bit table (flash) | ROM 0x41826 | 0,16,24,...,240 (18 words) | load axis for Ign_map_0/4 | read by F_00061F30 via coord pair 0x4688/0x468A | raw MAP count (2.5-bar: ~kPa abs)
[Ign_map_0_y_axis](../reference/symbols/Ign_map_0_y_axis.md) | 8/16-bit table (flash) | ROM 0x4184A | 500..6200 in 380 steps (16 words) | rpm axis for map0/4/2 knock family | F_00061F30 coordinate 0x468A | rpm
[Ign_map_4](../reference/symbols/Ign_map_4.md) | Calibration word (flash) | ROM 0x41DC0 | 0..360 | warm-up ignition map (more advance at low rpm/load for cat light-off) | F_00062102 0x62158 -> 0x398C, weight 0x399C crossfade by Lufttemp | 0.1 crank degree
[Ign_map_2](../reference/symbols/Ign_map_2.md) | Calibration word (flash) | ROM 0x41B08 | 0..90 (16x8) | knock retard overlay above ~atmospheric load (book: MAP>140 kPa regime) | F_00062102 0x62684/0x626BE -> 0x3988; [Knock_map_offset](../reference/symbols/Knock_map_offset.md) 0x10BA; cap 0x10B8 for knock engine | 0.1 crank degree (retard)
[Ign_map_2_x_axis](../reference/symbols/Ign_map_2_x_axis.md) | 8/16-bit table (flash) | ROM 0x41AD8 | 128,144,160,176,192,208,224,240 | high-load axis for knock overlay map2 | coord pair 0x4680/0x4682 | raw MAP count
[Ign_map_2_y_axis](../reference/symbols/Ign_map_2_y_axis.md) | 8/16-bit table (flash) | ROM 0x41AE8 | 500..6200 (16 words) | rpm axis for map2 | F_00061F30 | rpm
[Ign_map_1](../reference/symbols/Ign_map_1.md) | Calibration word (flash) | ROM 0x41AC2 | 0,100,100,80,40,0,-40,-40,-40,50,50 | idle torque correction added to idle angle vs rpm-error axis | F_00062102 idle branch 0x622FE/0x6237A/0x62406/0x62478, base 0x4770 | 0.1 crank degree (signed)
[Ign_map_1_y_axis](../reference/symbols/Ign_map_1_y_axis.md) | 8/16-bit table (flash) | ROM 0x41AAC | -460,-196,-166,-146,-86,0,30,250,400,1650,2000 | rpm-error axis for idle correction (reference unconfirmed) | F_00061F30 | rpm (inference)
[Ign_map_3](../reference/symbols/Ign_map_3.md) | Calibration word (flash) | ROM 0x41C40 | all 0 | transient ignition overlay — present, disabled in factory tune | F_00062102 0x6270A -> 0x398A, weight 0x399A, /1000 to RAM [Trans_offset](../reference/symbols/Trans_offset.md) runtime word | 0.1 crank degree (signed)
[Ign_map_3_x_axis](../reference/symbols/Ign_map_3_x_axis.md) | 8/16-bit table (flash) | ROM 0x41C08 | 30,37,50,65,82,102,122,149,174,200,224,248 | load axis for transient map | coord 0x467C/0x467E | raw MAP count
[Ign_map_5](../reference/symbols/Ign_map_5.md) | Calibration word (flash) | ROM 0x42022 | 20 x16 (constant +2.0) | fixed advance overlay while channel-5 condition active (undocumented in book) | F_00062102 0x624C8 -> 0x398E, weight 0x399E | 0.1 crank degree
[Ign_map_6](../reference/symbols/Ign_map_6.md) | Calibration word (flash) | ROM 0x42056 | signed -100..+170 (5x5) | torque reduction during upshift (TC request) | F_00062102 0x621A4 -> 0x3990, weight 0x39A0 | 0.1 crank degree (signed)
[Ign_map_7](../reference/symbols/Ign_map_7.md) | Calibration word (flash) | ROM 0x4209C | signed -100..+180 (5x5) | torque control during downshift | F_00062102 0x621F2 -> 0x3992, weight 0x39A2 | 0.1 crank degree (signed)
[Ign_map_8](../reference/symbols/Ign_map_8.md) | Calibration word (flash) | ROM 0x420EA | all 0 (11 words) | coast-idle torque correction vs rpm error — present, zeroed in factory | F_00062102 0x623B4, added to idle value 0x3986 | 0.1 crank degree (signed)
[Ign_map_8_y_axis](../reference/symbols/Ign_map_8_y_axis.md) | 8/16-bit table (flash) | ROM 0x420D4 | -100,-80,...,+80,+100 (11 words) | rpm-error axis (clean +/-100 rpm) | F_00061F30 | rpm
[Ign_idle_angle](../reference/symbols/Ign_idle_angle.md) | Calibration word (flash->RAM) | ROM 0x4181E | 70 (=7.0 deg) | idle base ignition angle seed for work word 0x4770 | copied 0x6C456/0x6F752, base of idle blend 0x3986 | 0.1 crank degree
[Ign_idle_angle_start](../reference/symbols/Ign_idle_angle_start.md) | Calibration word (flash) | ROM 0x41820 | 180 (=18.0 deg) | idle angle substitute when idle out-of-band exceeds Diag_tid (anti-stall recovery) | F_0006F450 0x6F76A | 0.1 crank degree
[Knock_offset](../reference/symbols/Knock_offset.md) | Calibration word (flash) | ROM 0x41822 | 0 | global constant knock-retard subtract | subtracted in F_00062102 at 0x62776 | 0.1 crank degree
[Trans_offset](../reference/symbols/Trans_offset.md) | Calibration word (flash) | ROM 0x41824 | 0 | transient offset init; runtime RAM word 0x3984-region reused for map3 output | computed 0x6279E, added 0x627A4 | 0.1 crank degree
[Ign_offset](../reference/symbols/Ign_offset.md) | Calibration word (flash) | ROM 0x4284A | 0 | global fixed ignition trim added to every event | F_00062102 0x627AE | 0.1 crank degree
[Ign_offset_cyl1](../reference/symbols/Ign_offset_cyl1.md) | Calibration word (flash) | ROM 0x4284C | 0 | cylinder-1 spark trim (selected at sync angle 0x21C) | F_00062102 0x627F2 | 0.1 crank degree
[Ign_offset_cyl2](../reference/symbols/Ign_offset_cyl2.md) | Calibration word (flash) | ROM 0x4284E | 0 | cylinder-2 spark trim (sync 0x168) | F_00062102 0x627DC | 0.1 crank degree
[Ign_offset_cyl3](../reference/symbols/Ign_offset_cyl3.md) | Calibration word (flash) | ROM 0x42850 | 0 | cylinder-3 spark trim (default sync branch) | F_00062102 0x62800 | 0.1 crank degree
[Ign_offset_cyl4](../reference/symbols/Ign_offset_cyl4.md) | Calibration word (flash) | ROM 0x42852 | 0 | cylinder-4 spark trim (sync 0xB4) | F_00062102 0x627C6 | 0.1 crank degree
[Ign_offset_adapt](../reference/symbols/Ign_offset_adapt.md) | Calibration word (flash->RAM) | ROM 0x42854 | -100 (= -10.0) | knock-adaptive ignition offset init; live value in work word 0x3896 | loaded by F_000610D2 0x611AA, added in F_00062102 0x6282E | 0.1 crank degree
[Ramp_up_ram](../reference/symbols/Ramp_up_ram.md) | 8/16-bit table (flash) | ROM 0x42876 | 1000,1000,0,0,0,0,20,100 | per-blend-channel weight ramp-up rates | Function_00061600 0x61610 | weight counts per event (0..1000 scale)
[Ramp_down_ram](../reference/symbols/Ramp_down_ram.md) | 8/16-bit table (flash) | ROM 0x42886 | 1000,1000,1000,250,0,0,0,0 | per-blend-channel weight ramp-down rates | Function_00061600 | weight counts per event
[Knock_ang_dec](../reference/symbols/Knock_ang_dec.md) | Calibration word (flash) | ROM 0x42874 | 20 (=2.0 deg) | headroom added to map2 value to form [Knock_map_lim](../reference/symbols/Knock_map_lim.md) | F_00062102 0x6276A -> 0x10B8 | 0.1 crank degree
[Ret_tab_mul](../reference/symbols/Ret_tab_mul.md) | Calibration byte (flash) | ROM 0x4097D | 10 | [Ret_mangd](../reference/symbols/Ret_mangd.md) increment scaling (x10/255 clamp at 255) | F_0006E722 0x6EC9E | per-mille/10 scale
[Ret_clear_tab_low](../reference/symbols/Ret_clear_tab_low.md) | Calibration byte (flash) | ROM 0x40986 | 3 | [Ret_mangd](../reference/symbols/Ret_mangd.md) demand count below which knock counter clears | F_0006E722 0x6EBAA | events
[Max_ret_dec](../reference/symbols/Max_ret_dec.md) | Calibration byte (flash) | ROM 0x40989 | 150 (150/256) | per-event decay fraction of knock retard demand [Ret_mangd](../reference/symbols/Ret_mangd.md) | F_0006E722 0x6EC26 | /256 fraction
[Max_lret_dec](../reference/symbols/Max_lret_dec.md) | Calibration byte (flash) | ROM 0x4098B | 180 (180/256) | per-event decay fraction of decel-enrichment demand [Lret_mangd](../reference/symbols/Lret_mangd.md) | F_0006BFA4 0x6C2F2 | /256 fraction
[Ret_up_rpm](../reference/symbols/Ret_up_rpm.md) | Calibration word (flash) | ROM 0x41762 | 150 (=1500 rpm) | upper rpm bound for all-cyl-knock fuel enrichment window | F_000694B2 0x694C2 | rpm x10
[Ret_down_rpm](../reference/symbols/Ret_down_rpm.md) | Calibration word (flash) | ROM 0x41764 | 90 (=900 rpm) | lower rpm bound for knock enrichment window | F_000694B2 0x694CE | rpm x10
[Ret_delta_rpm](../reference/symbols/Ret_delta_rpm.md) | Calibration word (flash) | ROM 0x41766 | 5 | rpm deficit triggering knock enrichment in that window | F_000694B2 0x69502 | rpm x10
[Ret_fuel_tab](../reference/symbols/Ret_fuel_tab.md) | Calibration byte (flash) | ROM 0x4176A | 102 | enrichment factor loaded into [Ret_fuel_fak](../reference/symbols/Ret_fuel_fak.md) when all-cyl knock enrichment fires | F_000694B2 0x6950C -> 0x1151 | fuel multiplier x/128
[Retard_temp](../reference/symbols/Retard_temp.md) | Calibration byte table (flash) | ROM 0x40B14 | 179..255 (/128 = 1.40..2.00), coolant-AD axis [Temp_steg](../reference/symbols/Temp_steg.md) | warm-up multiplier for deceleration-enrichment demand and knock step scaling (NOT crank angle) | interpolated F_0006D384-family -> RAM [Ret_temp](../reference/symbols/Ret_temp.md); used F_0006BFA4 0x6C2DC, F_0006E722 0x6EC0C | x/128 multiplier
[Lret_konst](../reference/symbols/Lret_konst.md) | Calibration word (flash) | ROM 0x4093C | 8x8 grid 0..102 | deceleration load-spike enrichment konst map | F_0006BFA4 0x6C2BC via F_00072972 (axes Trans_x_st/Trans_y_st) | dimensionless
[Airpump_ign_offset](../reference/symbols/Airpump_ign_offset.md) | Calibration word (flash) | ROM 0x42BEA | 0 | AIR-pump ignition advance target (feature off in factory) | ramp cap in F_0004AAC6 0x4AB14 | 0.1 crank degree
[Ap_ign_step](../reference/symbols/Ap_ign_step.md) | Calibration word (flash) | ROM 0x42BFC | 5 (=0.5 deg) | ramp step of AIR-pump advance per event | F_0004AAC6 0x4AB04 | 0.1 crank degree
[Sond_ign_limit](../reference/symbols/Sond_ign_limit.md) | Calibration word (flash) | ROM 0x428A4 | 500 (=5000 rpm) | ignition-event counter ceiling for O2-sensor monitoring counters | F_000638BE 0x63AA4 | rpm x10
[Ign_counter_mis_lim](../reference/symbols/Ign_counter_mis_lim.md) | Calibration word (flash) | ROM 0x42EBE | 2400 events | ignition-event window for misfire counters (book: 2400 rpm anchor) | compared in misfire eval family; counters incremented F_000638BE 0x63A7A | ignition events
[Misf_ign_lim](../reference/symbols/Misf_ign_lim.md) | Calibration word (flash) | ROM 0x42EC2 | 0 | misfire evaluation ignition limit set | misfire gates (Ign_counter3 path) | ignition events
[Retard_konst](../reference/symbols/Retard_konst.md) | Calibration word (flash) | ROM 0x428xx (init PEA; see evidence) | 8x8 grid via F_00072972 | knock retard demand step map (per-cyl increment into [Ret_mangd](../reference/symbols/Ret_mangd.md)) | F_0006E722 0x6EBEC | x/256 after [Ret_temp](../reference/symbols/Ret_temp.md) multiply
RAM_Ign_angle | State word (RAM 0x10B4) | RAM 0x10B4 | runtime | final ignition angle, clamped -10.0..+40.0, written every sync event | F_000638BE 0x63AE4; consumed by ISR 0x488A8, knock window, logger | 0.1 crank degree BTDC (signed)
RAM_Ign_angle_byte | State byte (RAM 0x3902) | RAM 0x3902 | runtime | [Ign_angle](../reference/symbols/Ign_angle.md) in 1-deg offset-10 units for logging | F_000638BE 0x63B12 | 1 crank degree, +10 offset
RAM_Ign_map_value | State word (RAM 0x3984) | RAM 0x3984 | runtime | interpolated [Ign_map_0](../reference/symbols/Ign_map_0.md) value feeding the blend | F_00062102 0x62152 | 0.1 crank degree
RAM_Weight | State word (RAM 0x3994) | RAM 0x3994..0x39A6 | runtime | 8 blend weight words (base, idle, knock, transient, map4-xfade, map5, upshift, downshift) + 0x39A6 cap flag | F_00061600 writers, F_00062102 reads | weight 0..1000
RAM_Knock_map_offset | State word (RAM 0x10BA) | RAM 0x10BA | runtime | weight-scaled map2 retard output for knock engine | F_00062102 0x6275E | 0.1 crank degree (scaled)
RAM_Knock_map_lim | State word (RAM 0x10B8) | RAM 0x10B8 | runtime | map2 value + [Knock_ang_dec](../reference/symbols/Knock_ang_dec.md) limit used by knock retard cap | F_00062102 0x62770, consumed F_00062842 0x63444 | 0.1 crank degree
RAM_Ret_mangd | State byte (RAM 0x3A40) | RAM 0x3A40..0x3A43 | runtime | per-cylinder knock retard demand counters | F_0006E722 0x6EC54/0x6EC76, F_00062842 | knock events x 1.5 deg
RAM_Ret_ind | State byte (RAM 0x1043) | RAM 0x1043 | runtime | bitmask of cylinders currently holding knock retard (0x10/20/40/80) | F_0006E722 0x6ECE6..0x6ED1A | bitmask (symbol-table name collides with [Ret_temp](../reference/symbols/Ret_temp.md) — verify)
RAM_Multispark | State byte (RAM 0x1118) | RAM 0x1118 | runtime | multi-spark arming flag during cold low-rpm starting | set F_00063712 0x63794/0x637B4 | 0/1
RAM_Mult_time | State word (RAM 0x1108) | RAM 0x1108 | runtime | multi-spark pulse period (5000/3000 TPU ticks) | F_00063712 0x6378C, scheduler 0x488A8 | TPU ticks
[Ret_fuel_fak](../reference/symbols/Ret_fuel_fak.md) | State byte (RAM 0x1151) | RAM 0x1151 | runtime | active all-cyl-knock enrichment factor | F_000694B2 0x6950C | fuel x/128
