# Trionic 5.5 — Fuel Injection Timing and Duration Subsystem

Reverse-engineering notes, T5.5 "m68k" (Motorola 68332) gasoline ECU, Saab 9-3 / 900 NG (NG900; footer `B204RM-900 C2 OBD2`).
Code paths traced on a commercial reflash (not distributed);
factory authority: `firmware/4780656_factory.BIN`. Disassembly: `firmware/4780656.asm`.
Method: init flash->RAM table-copy enumeration (513 tables, byte-compared to factory,
tools/fuel_tables.py), usage-site mining in the annotated ASM, REA/Ghidra m68k decompiles
in `evidence\fuel\func_*.json`, prose cross-check against `docs\trionic5_book.txt` (T5
service/technical book, fuel chapters). Raw calibration bytes: `notes\fuel_tables.txt`.

Conventions used below:
- All addresses are ROM addresses unless prefixed `RAM`. 1 tick of injection time = 4 µs
  (ground truth: `Min_tid = 250` and the book: "minimum injection duration normally 250
  = 1 ms").
- Map cell factors are written as the integer math the code does, e.g. `(v+128)/256`
  means MULU by (value+128) then LSR 8 — i.e. a signed ±50 % factor around 0x80 = 1.000.
- "VE" = volumetric efficiency cell value; the fuel maps are MAP(rpm)×MAP(load) VE
  corrections on top of the mass-based base time.
- Inferences that are not directly visible in code are marked [inference].

---

## 1. Scheduling frame

Everything fuel-related below runs once per injection-cycle from the master cycle
function `Function_0006C6DA` (called from the 7/8-ms main scheduler):

```
0x6C6FC  RAM_Rpm = TPU capture (0x3C32)/10        ; rpm/10 state word
0x6C71C  Cyl_i_tur = 1/3/4/2 from phase capture word, subtracting 0xB4 (180 deg) steps
         -> cylinder-cycle position, firing order 1-3-4-2
0x6C7D4  JSR Function_00069808   ; run/crank detect + injection ANGLE selection
0x6C7DA  JSR Function_0006A884   ; lambda closed-loop controller (Lambdaint)
0x6C7E0  JSR Function_00071CEC   ; rev-limit supervisor (Pgm_status bit 7)
0x6C7E6  JSR Function_00071868   ; fuel-stop / torque-cut state machine
0x6C7EC  JSR Function_0006959A   ; per-cycle duration calc driver (air charge + duration)
0x6C7F2+ per-injector channel words 0x4730-0x4735 built, TPU schedule word (0x1072)
```

[Pgm_status](../reference/symbols/Pgm_status.md) (RAM, symbol file 0x1041; flag bytes 0x103A-0x103D hold sub-mode bits)
gates the whole block — with bit 3 clear (engine not detected running) the scheduler
falls back to cranking/group injection (0x6C7F8).

## 2. Air charge and load

`Function_0006D2BC` head (per injection phase):

- 8-slot rolling product window (0x3A4E..0x3A66): each cycle stores
  `rpm_word × raw_load_byte`. After 8 samples, **raw air charge** = window_sum /
  rpm_word (0x6DCE0-0x6DCEE) — i.e. an averaged MAP-based load count.
- **Air charge word RAM 0x355A** = raw × `(Lufttemp_faktor + 384)/512` (0x6DD04-0x6DD18).
  `Lufttemp_faktor` is the intake-air-temperature density factor (0x80 = 1.000); this is
  the mass term that feeds the injector constant.
- Load byte: `raw/10` (0x4758) re-scaled by Lufttemp -> **`Last` / `Medellast`** bytes
  (0x6DD46-0x6DD6A), saturated 0xFF. `Medellast` is *kPa absolute* manifold pressure —
  the fuel map x-axes are in the same counts ([Fuel_map_xaxis](../reference/symbols/Fuel_map_xaxis.md) 16..224 = kPa abs).
- **[Grund_last](../reference/symbols/Grund_last.md)** (ROM 0x417D8 / RAM 0x51C6, factory 0x25=37, max [Grund_last_max](../reference/symbols/Grund_last_max.md)
  ROM 0x417D9 / RAM 0x51C8 = 0x32=50):
  learned baseline (minimum) load. `Function_00070514`/0x70344 ramp: [Grund_last](../reference/symbols/Grund_last.md) follows
  Medellast downward (−1 per cycle when it undershoots the learned floor) and creeps up
  (+1) toward [Grund_last_max](../reference/symbols/Grund_last_max.md) only when coolant > 55 °C, so the idle-load floor tracks
  carbon/oil-fume changes. Book: baseline load is used to recognise true idle load.
- **WOT enrichment 550-2400 rpm** (catalyst warm-up, book p30):
  `0x6E2B0`: if `Pgm_mod[0]` bit 1, find the rpm row in [Fuel_map_yaxis](../reference/symbols/Fuel_map_yaxis.md), and if
  `AD_trot > Fload_throt_tab[row]` (throttle-pot AD threshold: 170 low rpm, 190 mid,
  0xFF = disabled >= 2400 rpm) then multiply by `(Fload_tab[row] + 512)/512`
  (factory rows 0x1F=+6 %, 0x33=+10 %, 0x2E=+9 %, 0 above 2400 rpm) and set flag
  0x103D bit 6.
- **Open loop masks**: [Open_loop](../reference/symbols/Open_loop.md) (RAM 0x4CFE) / [Open_loop_adapt](../reference/symbols/Open_loop_adapt.md) / [Open_loop_knock](../reference/symbols/Open_loop_knock.md)
  are per-rpm-row load limits; `Function_0006A884` compares `Medellast` (byte 0x1037
  mirror) against `Open_loop_adapt![row]`+... (decompile: `*(0x4CFE+row) < DAT_00001037`)
  — above the limit lambda feedback/adaptation is masked (wide-open / high load = open
  loop). [Lam_minlast](../reference/symbols/Lam_minlast.md) is the per-row *minimum* load for lambda control.

## 3. Base injection duration chain

Driver: `Function_0006D2BC` (0x6D8A0..0x6E6C0 region; decompile
`evidence\fuel\func_0x6d2bc.json`). Per cylinder `i` (0..3), accumulator =
**`Ram 0x4748 + i*4`** (array `Grund_tid[4]`), all multipliers in order:

```
acc = Grund_tid = Inj_konst × aircharge(0x355A)            0x6DD9C-0x6DDAA
    × (Adapt_injfaktor + 384)/512      ; global adaptation, byte, 0x80=1.000
                                            0x6DDDC; applied when closed-throttle flag
                                              clears the >0x80 guard (0x6DDCC-0x6DE02)
    then ONE of the three load branches:
    A) idle-map branch (0x6DE0A: Medellast < idle-load limit RAM 0x61ED
       AND Rpm < idle-rpm limit RAM 0x4ED0 AND Pgm_mod[2] bit1,
       AND idle-adapt counter 0x35C6 >= Com_on_idle!):
       acc × (Idle_fuel_korr[rpm,load] + 128)/256           0x6DE48-0x6DE90
       acc × (Adapt_inj_imat + 384)/512  ; idle global adaption 0x6DEA6
       (book formula (Idle_fuel_korr+128)/256 exactly; axes
        Idle_st_rpm 500..1200 rpm/10 x Idle_st_last load 30..100)
       if the counter has not reached Com_on_idle, this branch is replaced by B)
       and the counter is incremented (0x6DE44, 0x6DEDE).
    B) normal branch: acc × (Insp_mat[rpm,load] + 128)/256  0x6DEE4/0x6E042
       acc × (Adapt_korr[cell] + 128)/256 ; pointed adaptation 0x6DF54/0x6E0B2
       (Insp_mat 16x16, axes Fuel_map_xaxis kPa x Fuel_map_yaxis rpm/10.
        Book: "correction factor from Insp_mat MAPxRPM"; cell range 0x0D..0xF1.)
    C) knock branch (0x6DFA2): if Knock_status bit0 AND Medellast >
       Fuel_knock_xaxis[0] (first column = knock-map min load; book: enrichment
       above ~140 kPa): acc × (Fuel_knock_mat[rpm,load] + 128)/256  0x6DFC0-0x6E006
       and Insp_mat/Adapt_korr are NOT applied this cycle — Fuel_knock_mat
       (ROM 0x409F4, 12 load x 16 rpm) REPLACES the normal VE pair while
       knocking, setting flag 0x103A bit1.
```

Continuation (all verified 0x6E0EE-0x6E5F4, decompile `func_0x6d2bc.json`):

```
    × (Temp_fak blend)                  0x6E100-0x6E18A  warm-up afterstart family,
                                         (Temp_fak_tab scaled by afterstart fade 0x46D4
                                          /255), (v+128)/128 — see notes\warmup_system.md
    transient: JSR 0x6E722 + 0x6BFA4 compute quantities, then
    acceleration: acc = max( acc × (256 + Lacc_mangd[i])/256 ,       0x6E1AA-0x6E208
                             acc × (128 + 4×Acc_mangd[i])/128 )
                  (Lacc = load-derivative demand, Acc = throttle-derivative demand;
                   quantities built from Lacc_konst!/Accel_konst! maps, ceilings
                   Max_lacc_dec=200 / Max_acc_dec=150, Knock-sourced Lacc in 0x6BFA4)
    deceleration: acc = min( acc × (256 − Lret_mangd[i])/256 ,       0x6E22A-0x6E2A0
                             acc × (128 − Ret_mangd[i]/2)/128 )
                  (Retard_konst!/Lret_konst!, Max_ret_dec/Max_lret_dec ceilings)
    × (Fload_tab WOT +512)/512          0x6E2B0-0x6E328  (section 2)
    × (Lambdaint + 384)/512             0x6E356  ; closed-loop lambda integrator,
                                         byte 0x80=1.000, integrator clamped ±128
                                         -> ±25 % band (book: lambda correction ±25 %)
    × (Ret_fuel_fak + 1024)/1024        0x6E37C  ; re-enrichment ramp after fuel cut
                                         (Ret_fuel_tab 0x66, step Ret_fuel_step!, /time)
    × (Hot_start_fak + 1024)/1024       0x6E3A8  ; hot restart (warm-up doc)
    × (After_fcut + 1024)/1024          0x6E3D4  ; after-cut table After_fcut_tab ramp
    × (Cyl_komp![i] + 384)/512          0x6E3FA  only while Medellast < Last_cyl_komp!
                                         (factory 0x28=40 kPa — cylinder balance trim
                                          acts at part load only)
    + Br_plus − Br_minus                0x6E43C  word additives (trim/brake test
                                         corrections; Br_plus_tab! calibration)
    + purge compensation                0x6E468  if purge active (0x103C bit2) and
                                         Purge_duty != 0: += Grund_tid×
                                         (Purge_adapt_fak+384)/512 − Grund_tid
    ÷ 10                                0x6E4C0
    + Batt_korr_tab[14 − clamp(Batt/10, 4..14)]   0x6E4D2-0x6E538
                                         11-word table (0x4051E): factory 148,193,196,
                                         234,321,376,463,580,932,932,932 ticks
                                         = 0.59 ms open-time at 14.0 V up to 3.7 ms at
                                         ≤6 V. Book: "battery voltage adjusts
                                         (minimum) injection duration" — this is the
                                         injector valve open-time compensation added
                                         AFTER scaling, so it is voltage-only.
    airpump trim                        0x6E540  if pump active: ×
                                         (Airpump_inj_factor+84)/170 (0x55 -> ×0.994)
    OVERRIDES (not multipliers):
      Pgm_mod[1] bit3 && Idle_status  -> acc = Tid_konst (750 = 3.0 ms fixed idle time)
                                         0x6E57A
      Pgm_mod[1] bit0 -> acc = Extern_tid (dyno/aftermarket override word) 0x6E5AE
      acc = max(acc, Min_tid)           0x6E5D2  (250 = 1.000 ms floor; AC-on step
                                         Min_tid_acink handled in climate path)
    clamp: cycle-proportional max (base word 0x3B70 ×180/×720 form) then cap 32500
      ticks = 130 ms (0x6E68C CMPI #7EF4)
    -> RAM word Insp_tid  (written 0x6E684; halved when 0x103B bit0 group mode)
    -> Insptid_ms10 = Insp_tid/25  (0x6E69C, 0.1 ms cluster/consumption copy)
```

Book cross-check (trionic5_book.txt fuel chapter): base time from load, [Insp_mat](../reference/symbols/Insp_mat.md)
correction, lambda ±25 %, [Min_tid](../reference/symbols/Min_tid.md) 250 = 1 ms with battery-voltage adjustment,
[Inj_konst](../reference/symbols/Inj_konst.md) ~20 stock (lower value for larger injectors — factory byte is exactly 0x14=20), idle formula (+128)/256 — all reproduced above. The chain order above is
code order; the book describes the same chain in prose.

`Function_0006D110` / `Function_0006D134`: cranking duration path —
[Start_insp](../reference/symbols/Start_insp.md) (0x08CA = 2250) × warm-up [Startvev_fak](../reference/symbols/Startvev_fak.md)/128 (see notes\warmup_system.md),
bypassing the load maps.

## 4. Injection TIMING (when injectors fire)

- `Function_00069808` (0x6C7D4) selects the **injection angle** `RAM_Insp_vinkel`:
  - Not running / cranking ([Pgm_status](../reference/symbols/Pgm_status.md) bit 3 clear, or rpm below `Start_detekt_rpm!`):
    `Insp_vinkel = Start_v_vinkel!` (factory 0) at 0x6990A — fire at sync reference.
  - Running, `Pgm_mod[0]` bit2 clear (default; "constant injection angle" mode):
    `Insp_vinkel = Vinkel_konst!` at 0x69962 — factory 0x35 = 53°.
  - `Pgm_mod[0]` bit2 set ("interpolation of delay map"):
    `Insp_vinkel = 3 × Del_mat[rpm,load]` at 0x69952 ([Del_mat](../reference/symbols/Del_mat.md) = 16×16 delay map,
    factory 0..0x4D=77 -> 0..231; the ×3 scaling is code-visible [inference: degrees]).
- **Grouped sequential injection, firing order 1-3-4-2.** In the scheduler, the
  per-injector TPU angle word `(0x1072)` = `Insp_vinkel + k×0xB4` where k = cycle
  position of the cylinder: cyl 1 +0°, cyl 3 +180°, cyl 4 +360°, cyl 2 +540°
  (0x6C726-0x6C758 mapping and the four `ADDI.W #00B4` variants). One injector fires
  per crank revolution (4 strokes apart per cylinder), so pulses are written every
  180°·2 = 720° cycle per cylinder; each event is one port injection — T5 on this car
  is **fully sequential port injection** (one pulse per intake port per cycle), not
  simultaneous, once running and synchronized [book: "dussyler injicering"/sequential
  chapter; code: per-cylinder angle offsets].
- **Fallback simultaneous/group mode**: flag byte **0x103B bit 0**. Set when cycle
  synchronization is lost or a cylinder is skipped (0x6C862, 0x6C87A, 0x6CBAC, 0x6CBE8,
  0x6CC5C) — then `0x1072 = Insp_vinkel` with no per-cylinder offset (or +0xB4 pair
  offset) and mode word 0x4730+i = 1 or 2 (grouped), and the per-cylinder duration is
  halved in the duration writer (0x6E670-0x6E684: value/2 when 0x103B bit0) so the two
  group injections deliver one cylinder's total. Cranking uses this grouped behaviour
  with [Start_v_vinkel](../reference/symbols/Start_v_vinkel.md).
- No cam-phased "injection timing map" exists: only the constant/[Del_mat](../reference/symbols/Del_mat.md) angle above.
  [Overstid_tab](../reference/symbols/Overstid_tab.md) (16 × 0x28 per rpm row) is an injection over-time margin used when
  loading the TPU compare unit (timing slack), not a fuel quantity.

## 5. Lambda feedback + adaptation

**Closed-loop integrator** `Function_0006A884` (decompile `func_0x6a884.json`):
- State: `RAM_Lambdaint` byte (alias at RAM 0x102E region; 0x80 = λ-trim 1.000) plus a
  second integrator/companion byte (Ghidra DAT_00001031) and per-sensor state words.
- Gates (decompile): `Pgm_mod[1]` bit1 ("lambda during transients"), `Pgm_mod[0]` bit4,
  coolant/λ-sensor temperature via [Lamb_temp](../reference/symbols/Lamb_temp.md), min switch count `Min_lam_omslag!` (=8),
  load > `Lam_minlast![row]`, [Open_loop](../reference/symbols/Open_loop.md) mask (section 2), `Ap_lambda_delay!` after
  airpump, `Lamb_tid!`/`Lamb_kyl!`/`Lamb_idle!`/`Lamb_ej!` timing/limit tables. Reset to
  0x80 whenever a gate drops (`DAT_0000102b = 0x80` cluster in decompile).
- Steps come from [Lean_step_map](../reference/symbols/Lean_step_map.md)/[Rich_step_map](../reference/symbols/Rich_step_map.md) (16×4, factory 4..15 / 6..25)
  indexed by rpm row (axes `Lam_rpmsteg!`, `Lam_laststeg!`) — asymmetric lean/rich step
  rates; `Konst_rich_map!`/`Konst_lean_map!` are the (zeroed) proportional terms.
  [Lambdamatris_diag](../reference/symbols/Lambdamatris_diag.md) (16 rows of 6 bytes) parameterises lambda-monitoring.
- The integrator enters the duration chain as `(Lambdaint+384)/512` — full-scale ±25 %
  (book).

**Pointed (per-cell) adaptation** — RAM tables live behind the same 16×16 grid as
[Insp_mat](../reference/symbols/Insp_mat.md):
- `RAM_Adapt_korr![cell]`, updated ±1 per adaptation event at 0x6BBD8/0x6BC0A (inside
  `Function_0006B612`, decompile `func_0x6b612.json`) when the lambda integrator leaves
  the 0x7F..0x81 dead band during closed-throttle running; per-cell hit counters in the
  `Adapt_ggr` array (0x6BBE6/0x6BBF2). Bounds [Adapt_korr_low](../reference/symbols/Adapt_korr_low.md) = 0x4D / [Adapt_korr_high](../reference/symbols/Adapt_korr_high.md)
  = 0xB3 (≈ ±20 % per cell); exceeding them raises CEL (book p19). Cell index = current
  interpolated cell (state word 0x46F0).
- Gated by `Pgm_mod[1]` bit7 ("adaptation when throttle closed") and
  `Pgm_mod[0]` bit5 (adaptivity master), masked by [Open_loop_adapt](../reference/symbols/Open_loop_adapt.md).
- [Nr_adapt_idle_mat](../reference/symbols/Nr_adapt_idle_mat.md) (word 0x0080) and idle counter 0x35C6/[Com_on_idle](../reference/symbols/Com_on_idle.md) control when
  the idle-map branch (3A) becomes authoritative.

**Global adaptation** `Function_0006B612` window logic at 0x6B460-0x6B5C0:
- Window: [Min_load_gadapt](../reference/symbols/Min_load_gadapt.md)(0x28=40) < Medellast < [Max_load_gadapt](../reference/symbols/Max_load_gadapt.md)(0x68=104 kPa) and
  [Min_rpm_gadapt](../reference/symbols/Min_rpm_gadapt.md)(0xAE=1740) ≤ Rpm < [Max_rpm_gadapt](../reference/symbols/Max_rpm_gadapt.md)(0x129=2970 rpm) — book: 60-120
  kPa / 2000-3000 rpm (same window, book numbers rounded/metric-shifted).
- Counter to [Global_adapt_nr](../reference/symbols/Global_adapt_nr.md) (0x320=800 ticks): sum [Lambdaint](../reference/symbols/Lambdaint.md) every tick, at 250
  ticks form the mean (0x46F4), then `Adapt_injfaktor += mean − 0x80` (0x6B598), clamped
  to [Adapt_injfaktor_low](../reference/symbols/Adapt_injfaktor_low.md)(0x1A → ×0.80) .. [Adapt_injfaktor_high](../reference/symbols/Adapt_injfaktor_high.md)(0xE6 → ×1.20).
- Period/scale from [Adaption_time](../reference/symbols/Adaption_time.md) (factory 5 — book: "every fifth minute") and
  [Load_adapt_time](../reference/symbols/Load_adapt_time.md) (2 — book: 30 s windows); `Max_adjust_load_adapt!` caps the load
  shift per event.
- Idle-load equivalent: [Adapt_inj_imat](../reference/symbols/Adapt_inj_imat.md) (RAM 0x4A78) via [Nr_adapt_idle_mat](../reference/symbols/Nr_adapt_idle_mat.md)
  (RAM 0x4A7A), applied in branch 3A of the duration chain.

**Alternative fuels / E85**: no dedicated E85 bit exists in [Pgm_mod](../reference/symbols/Pgm_mod.md) (book p33 prescribes
raising [Inj_konst](../reference/symbols/Inj_konst.md) for ethanol because the base mass term is linear in air). What is
visible: [Pgm_mod](../reference/symbols/Pgm_mod.md) factory FB F6 EA D4 86 10 (MCS differs — `T5 MCS Tune Changes.md`);
bit map
per book table (byte0: b1 WOT enrich, b2 delay-map interp, b5 adaptivity; byte1: b0 const
time, b2 fuelcut, b3 const idle time, b7 closed-throttle adapt; byte2: b1 separate idle
map).

## 6. Fuel cut paths

All cuts act on the injector channel command bytes `RAM 0x4730+i` / `0x4734+i` (bit0 =
channel enable; 0x4735 bit7 = fire request) and/or [Pgm_status](../reference/symbols/Pgm_status.md):

- **Overboost** `Function_000734C6` (decompile `func_0x734c6.json`): when
  `P_medel > Tryck_vakt_tab![rpm-row]` (RAM 0x5BB6, factory 16×0xE6 = 230 kPa abs
  ≈ 1.3 bar boost, book p47) set [Pgm_status](../reference/symbols/Pgm_status.md) bit5 and the
  APC/ignition-derate path; the scheduler's per-cylinder gate (0x6CC00:
  `Pgm_status & 0x20`) then clears the channel enable bits — fuel cut on boost overshoot.
- **Rev limit** `Function_00071CEC`: `Rpm > Rpm_max!` -> [Pgm_status](../reference/symbols/Pgm_status.md) bit7; same channel
  gate (`Pgm_status & D3`) kills injection on the over-speed flag; re-arm window via
  [Rpm_dif](../reference/symbols/Rpm_dif.md) (0x719C0) so cut repeats in bursts.
- **Deceleration / fuel save** state machine `Function_00071868` (region 0x718xx-0x71CD6):
  conditions per book (throttle closed below `Trot_min`, rpm above the ~1900 rpm
  threshold, gear 3/4/5 via `Gear`, speed): counts [Delay_cut](../reference/symbols/Delay_cut.md) (factory 0 on this tune)
  in 4-tick units (0x71C26), then latches request flags (0x103A bits 0/4, state byte
  0x3A7A) which the scheduler consumes (0x6C8CC/0x6CC00: `0x103A & 0x90` -> disable
  channels). Reactivation at [Open_varv](../reference/symbols/Open_varv.md) (0x8C = 1400 rpm, book fuel-save figure) and
  forced-off below [Open_all_varv](../reference/symbols/Open_all_varv.md) (0x64 = 1000 rpm) (0x719DC-0x71A18). After re-enable,
  `After_fcut`/[Ret_fuel_fak](../reference/symbols/Ret_fuel_fak.md) ramps (section 3) climb the mixture back.
- **Per-cylinder torque cut** (shift/trafo reduction): 0x71A1C-0x71A98 clears individual
  channel bits per `Cyl_i_tur` (1/2/3/4 pattern) — same channel mechanism, partial cut.
- **[KillInjection](../reference/symbols/KillInjection.md)** (immobilizer/limp): `TST.B (RAM_KillInjection)` in the TPU pulse
  handlers (0x46EA6, 0x4729C, ...) — when set, the pulse writer emits the no-pulse
  code instead of the loaded width, cutting regardless of scheduler state.

## 7. Output driver (duration word -> TPU)

- The finished width lives in **`RAM Insp_tid`** (word, 4 µs ticks; written 0x6E684 from
  array `0x4748+i*4`, halved in group mode) with [Insptid_ms10](../reference/symbols/Insptid_ms10.md) (0.1 ms) as the cluster
  consumption copy.
- The scheduler copies [Insp_tid](../reference/symbols/Insp_tid.md) plus the angle word `(0x1072)` into per-injector command
  blocks (0x4730.. channel bytes: enable/direction/fire bits + mode code) once per
  cylinder slot; [Overstid_tab](../reference/symbols/Overstid_tab.md) supplies the reload margin.
- **TPU interrupt handler `VECTOR_104` (0x46C30)** (decompile `func_0x46c30.json`) and
  the companion pulse functions (0x47024, 0x47228, 0x48B3C) service the Handshake
  Service (HSR0/HSRR0) links: they translate the tick count for the TPU counter clock,
  check it against the per-cycle maximum (0x3B6C/0x3B70), honour [KillInjection](../reference/symbols/KillInjection.md)
  (no-pulse code) and arm the TPU output compare channels; the TPU hardware then produces
  the actual injector gate pulse (assert on channel, clear on compare match). Peak-and-hold
  dwell is a TPU-link-list property, not a duration variable.

## 8. Calibration table inventory

Raw factory bytes for every table above, with ROM/RAM
addresses, row layouts and code paths: **`notes\fuel_tables.txt`** (generated by
`tools\gen_fuel_tables_txt.py` from `symbols\init_copy_inventory.json`, 513-table scan,
all 513 factory-matched uniquely). Decompiles: `evidence\fuel\func_*.json` (19 functions).

---

## PROPOSED SYMBOL PAGES

Format: name | type | address (ROM -> RAM copy) | factory value | function | code path | units.
All calibration addresses from the init-copy scan (symbols/init_copy_inventory.json);
factory values from firmware/4780656_factory.BIN.

[Insp_mat](../reference/symbols/Insp_mat.md) | 8-bit table 16x16 (flash) | 0x40E10 -> 0x4976 | cells 0x0D..0xF1 | main VE correction matrix MAPxRPM on base time | mult 0x6DEF8/0x6E056, axes Fuel_map_* | factor (v+128)/256, +/-50 %
[Fuel_map_xaxis](../reference/symbols/Fuel_map_xaxis.md) | Calibration table (flash) | 0x41674 -> 0x4E62 | 10 18 20 30 40 48 50 60 70 80 90 A0 B0 C0 D0 E0 | load axis for Insp_mat/Adapt_korr/Fload/knock scans | 0x6DEFE push, 0x6E2D0 rpm-row scan | kPa absolute
[Fuel_map_yaxis](../reference/symbols/Fuel_map_yaxis.md) | Calibration table (flash) | 0x41684 -> 0x4E72 | 16 words 0058..026C | rpm axis for the fuel maps | 0x6DE48 push, 0x6E2D0 | rpm/10 (880..6200 rpm)
[Adapt_korr](../reference/symbols/Adapt_korr.md) | 8-bit table 16x16 (flash+RAM state) | 0x4040A -> 0x4876 | all 0x80 | pointed per-cell lambda adaptation | mult 0x6DF54/0x6E0B2; update +-1 at 0x6BBD8/0x6BC0A | factor (v+128)/256; bounds 4D..B3
[Adapt_injfaktor](../reference/symbols/Adapt_injfaktor.md) | Calibration word (RAM state, init flash) | 0x4075A -> 0x4A76 | 0x80 | global-adaptation injection factor | mult 0x6DDDC; learned 0x6B598 | (v+384)/512; limits 1A..E6 (-20/+20 %)
[Adapt_inj_imat](../reference/symbols/Adapt_inj_imat.md) | Calibration word (RAM state, init flash) | 0x4075B -> 0x4A78 | 0x80 | global adaptation for idle-map branch | mult 0x6DEA6 | (v+384)/512
[Adapt_korr_low](../reference/symbols/Adapt_korr_low.md) | Calibration word (flash) | 0x428B3 -> 0x5B10 | 0x4D | min legal [Adapt_korr](../reference/symbols/Adapt_korr.md) cell (CEL on exceed) | 0x6BB94 check | factor byte
[Adapt_korr_high](../reference/symbols/Adapt_korr_high.md) | Calibration word (flash) | 0x428B4 -> 0x5B12 | 0xB3 | max legal [Adapt_korr](../reference/symbols/Adapt_korr.md) cell | 0x6BC0A check | factor byte
[Adapt_injfaktor_low](../reference/symbols/Adapt_injfaktor_low.md) | Calibration word (flash) | 0x428B5 -> 0x5B14 | 0x1A | min global factor (x0.80) | 0x6B5B0 clamp | (v+384)/512
[Adapt_injfaktor_high](../reference/symbols/Adapt_injfaktor_high.md) | Calibration word (flash) | 0x428B7 -> 0x5B18 | 0xE6 | max global factor (x1.20) | 0x6B5A6 clamp | (v+384)/512
[Nr_adapt_idle_mat](../reference/symbols/Nr_adapt_idle_mat.md) | Calibration word (flash) | 0x4075C -> 0x4A7A | 0x0080 | idle-map adaptation target/counter | idle adaptation logic | count
[Com_on_idle](../reference/symbols/Com_on_idle.md) | Calibration word (flash) | 0x4074B -> 0x4E10 | (fuel_tables.txt) | idle counter value required before idle map replaces main map | 0x6DE3E | count
[Global_adapt_nr](../reference/symbols/Global_adapt_nr.md) | Calibration word (flash) | 0x40984 -> 0x4B7E | 0x0320 | global-adaptation accumulation target (mean [Lambdaint](../reference/symbols/Lambdaint.md) applied at 250) | 0x6B460 window | ticks
[Min_load_gadapt](../reference/symbols/Min_load_gadapt.md) | Calibration word (flash) | 0x4097E -> 0x4B76 | 0x28 | global-adapt load window min | 0x6B468 cmp Medellast | kPa abs
[Max_load_gadapt](../reference/symbols/Max_load_gadapt.md) | Calibration word (flash) | 0x4097F -> 0x4B78 | 0x68 | global-adapt load window max | 0x6B474 | kPa abs
[Min_rpm_gadapt](../reference/symbols/Min_rpm_gadapt.md) | Calibration word (flash) | 0x40980 -> 0x4B7A | 0x00AE | global-adapt rpm window min | 0x6B484 cmp Rpm | rpm/10
[Max_rpm_gadapt](../reference/symbols/Max_rpm_gadapt.md) | Calibration word (flash) | 0x40982 -> 0x4B7C | 0x0129 | global-adapt rpm window max | 0x6B48E | rpm/10
[Adaption_time](../reference/symbols/Adaption_time.md) | Calibration word (flash) | 0x41664 -> 0x5E98 | 5 | adaption period ("every fifth minute", book) | 0x6B460 scaler | min
[Load_adapt_time](../reference/symbols/Load_adapt_time.md) | Calibration word (flash) | 0x417AB -> 0x4F92 | 2 | adaptation window length | 0x6B460 | window units (book: 30 s)
[Inj_konst](../reference/symbols/Inj_konst.md) | Calibration word (flash) | 0x40BA6 -> 0x4BF4 | 0x14 (20) | injector constant, base mass term | [Grund_tid](../reference/symbols/Grund_tid.md) = [Inj_konst](../reference/symbols/Inj_konst.md) x aircharge 0x6DDA2 | ticks per air-charge count
[Min_tid](../reference/symbols/Min_tid.md) | Calibration word (flash) | 0x40BA8 -> 0x4BF6 | 0x00FA | minimum injection duration floor (book 250 = 1 ms) | 0x6E5D2 max() | 4 us ticks
[Min_tid_acink](../reference/symbols/Min_tid_acink.md) | Calibration word (flash) | 0x41282 -> 0x61DE | 0x01 | minimum-duration step with AC compressor on | climate path | ticks
[Tid_konst](../reference/symbols/Tid_konst.md) | Calibration word (flash) | 0x40BA2 -> 0x4BF2 | 0x02EE | fixed idle injection time override | 0x6E598 when [Pgm_mod](../reference/symbols/Pgm_mod.md)[1].3 and idle | 4 us ticks (750 = 3.0 ms)
[Vinkel_konst](../reference/symbols/Vinkel_konst.md) | Calibration word (flash) | 0x40BA4 -> 0x4E3C | 0x35 (53) | injection angle constant | [Insp_vinkel](../reference/symbols/Insp_vinkel.md) = [Vinkel_konst](../reference/symbols/Vinkel_konst.md) 0x69962 | crank degrees
[Start_v_vinkel](../reference/symbols/Start_v_vinkel.md) | Calibration word (flash) | 0x40F12 -> 0x4E14 | 0x0000 | injection angle during cranking | 0x6990A | crank degrees
[Del_mat](../reference/symbols/Del_mat.md) | 8-bit table 16x16 (flash) | 0x4075E -> 0x4BFC | 0x00..0x4D | injection delay map (interpolated angle) when [Pgm_mod](../reference/symbols/Pgm_mod.md)[0].2 | 0x69952, value x3 | 3 x map = crank degrees
[Batt_korr_tab](../reference/symbols/Batt_korr_tab.md) | 16-bit table x11 (flash) | 0x4051E -> 0x4E4A | 148,193,196,234,321,376,463,580,932,932,932 | battery-voltage injector open-time compensation | index 14 - V(volt) at 0x6E516, added 0x6E52C | 4 us ticks
[Grund_last](../reference/symbols/Grund_last.md) | Calibration word (RAM state, init flash) | 0x417D8 -> 0x51C6 | 0x25 (37) | learned baseline (minimum) load floor | ramp 0x70344 vs Medellast | kPa abs
[Grund_last_max](../reference/symbols/Grund_last_max.md) | Calibration word (flash) | 0x417D9 -> 0x51C8 | 0x32 (50) | ceiling of [Grund_last](../reference/symbols/Grund_last.md) ramp, warm engine only | 0x70344 ramp | kPa abs
[Last_reg_kon](../reference/symbols/Last_reg_kon.md) | 16-bit table x4 (flash) | 0x417CC -> 0x51BE | 290,100,150,0 | idle load-regulation constants | Function_00070514 at 0x70536 | counts
[Idle_fuel_korr](../reference/symbols/Idle_fuel_korr.md) | 8-bit table 8x12 (flash) | 0x40DB0 -> 0x5F6A | signed rows (book idle map) | idle fuel map, closed throttle | 0x6DE60 branch A | (v+128)/256
[Idle_st_rpm](../reference/symbols/Idle_st_rpm.md) | Calibration table (flash) | 0x416E0 -> 0x4EC2 | 0032,003C,...,0078 (8 words) | idle-map rpm axis | 0x6DE66 | rpm/10 (500..1200)
[Idle_st_last](../reference/symbols/Idle_st_last.md) | Calibration table (flash) | 0x416D4 -> 0x61E2 | 1E,23,28,...,64 (12 B) | idle-map load axis | 0x6DE6C | kPa abs
[Fload_tab](../reference/symbols/Fload_tab.md) | Calibration table (flash) | 0x409DA -> 0x4BE4 | 1F 33 1F 2E 1F 00... per rpm row | WOT enrichment amount (catalyst warmup 550-2400 rpm) | 0x6E2FC select, factor 0x6E318 | (v+512)/512
[Fload_throt_tab](../reference/symbols/Fload_throt_tab.md) | Calibration table (flash) | 0x409CA -> 0x4BD4 | AA x5, B4 x3, BE, FF x6 | throttle-AD WOT threshold per rpm row (FF = disabled >= 2400 rpm) | 0x6E2EC cmp AD_trot | AD counts
[Fuel_knock_mat](../reference/symbols/Fuel_knock_mat.md) | 8-bit table 12x16 (flash) | 0x409F4 -> 0x6352 | rows in fuel_tables.txt | knock-map VE override while knocking | 0x6DFC0 replaces Insp_mat/Adapt_korr when [Knock_status](../reference/symbols/Knock_status.md).0 | (v+128)/256
[Fuel_knock_xaxis](../reference/symbols/Fuel_knock_xaxis.md) | Calibration table (flash) | 0x40AB4 -> 0x6412 | 12 bytes; [0] = engage load | knock fuel-map load axis; [0] compared to Medellast | 0x6DFB6 gate, 0x6DFE2 axis | kPa abs (book: active above ~140 kPa)
[Open_loop](../reference/symbols/Open_loop.md) | Calibration table (flash) | 0x40718 -> 0x4CFE | 50 C8 C8 C8 92...58 | per-rpm open-loop load ceiling | 0x6A884 lambda mask | kPa abs
[Open_loop_adapt](../reference/symbols/Open_loop_adapt.md) | Calibration table (flash) | 0x40728 -> 0x4D0E | per row | open-loop ceiling for adaptation | 0x6A884 gate | kPa abs
[Open_loop_knock](../reference/symbols/Open_loop_knock.md) | Calibration table (flash) | 0x40738 -> 0x4D1E | per row | open-loop ceiling while knock map active | 0x6A884 gate | kPa abs
[Lam_minlast](../reference/symbols/Lam_minlast.md) | Calibration table (flash) | 0x40F8A -> 0x6C62 | 16 bytes 12..18 | minimum load for lambda control per row | 0x6A884 gate | kPa abs
[Lean_step_map](../reference/symbols/Lean_step_map.md) | 8-bit table 16x4 (flash) | 0x40BB8 -> 0x6A40 | 4..15 | lambda integrator step-down rates by rpm/load cell | 0x6A884 | steps per lambda event
[Rich_step_map](../reference/symbols/Rich_step_map.md) | 8-bit table 16x4 (flash) | 0x40BF8 -> 0x6A80 | 6..25 | lambda integrator step-up rates | 0x6A884 | steps per lambda event
[Lambdamatris_diag](../reference/symbols/Lambdamatris_diag.md) | 8-bit table 6x16 (flash) | 0x40D50 -> 0x6BD6 | 0A 0A 19 02 00 00 x16 | lambda-control monitoring thresholds per rpm row | diag / 0x6A884 | mixed thresholds
[Tryck_vakt_tab](../reference/symbols/Tryck_vakt_tab.md) | 8-bit table x16 (flash) | 0x412D0 -> 0x5BB6 | E6 x16 (230) | overboost fuel-cut MAP limit per rpm row | Function_000734C6 -> [Pgm_status](../reference/symbols/Pgm_status.md) bit5 | kPa absolute
[Open_varv](../reference/symbols/Open_varv.md) | Calibration word (flash) | 0x40BB0 -> 0x4E40 | 0x8C (140) | fuel-save reactivation rpm (book 1400 rpm) | 0x71A04 cmp Rpm | rpm/10
[Open_all_varv](../reference/symbols/Open_all_varv.md) | Calibration word (flash) | 0x40F26 -> 0x4E32 | 0x64 (100) | fuel-save disable floor | 0x719E4 cmp Rpm | rpm/10
[Delay_cut](../reference/symbols/Delay_cut.md) | Calibration word (flash) | 0x40F25 -> 0x4E30 | 0x00 | deceleration fuel-cut engage delay | 0x71C26 timer x4 ticks | cycle ticks
[Rpm_max](../reference/symbols/Rpm_max.md) | Calibration word (flash) | 0x40F2C -> 0x7640 | (fuel_tables.txt) | rev-limit speed -> [Pgm_status](../reference/symbols/Pgm_status.md) bit7 | Function_00071CEC | rpm/10
[Rpm_dif](../reference/symbols/Rpm_dif.md) | Calibration word (flash) | 0x40F28 -> 0x7664 | (fuel_tables.txt) | re-cut window after rev cut | 0x719C0 | rpm/10
[Pgm_mod](../reference/symbols/Pgm_mod.md) | Calibration table 6 B (flash) | 0x4074E -> 0x76E2 | FB F6 EA D4 86 10 | feature bitfield (WOT enrich, delay map, fuel cut, idle map, adaptivity); E85 is tuned via [Inj_konst](../reference/symbols/Inj_konst.md), not a bit | global; bit table in fuel_tables.txt | bits
[Ret_fuel_tab](../reference/symbols/Ret_fuel_tab.md) | Calibration word (flash) | 0x4176A -> 0x4F50 | 0x66 | post-fuel-cut re-enrichment target | builds [Ret_fuel_fak](../reference/symbols/Ret_fuel_fak.md), mult 0x6E37C | (v+1024)/1024
[Ret_fuel_step](../reference/symbols/Ret_fuel_step.md) | Calibration word (flash) | 0x41768 -> 0x4F4E | 0x01 | re-enrichment ramp step | 0x6E37C ramp | factor units
[Ret_fuel_time](../reference/symbols/Ret_fuel_time.md) | Calibration word (flash) | 0x41769 -> 0x4F4C | 0x02 | re-enrichment ramp period | 0x6E37C ramp | ticks
[After_fcut_tab](../reference/symbols/After_fcut_tab.md) | Calibration table 10 B (flash) | 0x416F0 -> 0x4ED2 | CC B4 AC A4 96 8C 78 64 32 00 | after-fuel-cut enrichment ramp | After_fcut mult 0x6E3D4 | (v+1024)/1024
[Last_cyl_komp](../reference/symbols/Last_cyl_komp.md) | Calibration word (flash) | 0x40BAA -> 0x4BF8 | 0x28 (40) | load ceiling for per-cylinder fuel trims | 0x6E400 | kPa abs
[Cyl_komp](../reference/symbols/Cyl_komp.md) | Calibration table 4 B (flash/RAM state) | 0x40538 -> 0x4E0C | 80 80 80 80 | per-cylinder fuel balance trim | mult 0x6E416 | (v+384)/512
[Start_insp](../reference/symbols/Start_insp.md) | Calibration word (flash) | 0x40BAC -> 0x4BFA | 0x08CA (2250) | cranking base injection count | x Startvev_fak/128 (warmup doc) | 4 us ticks
[Airpump_inj_factor](../reference/symbols/Airpump_inj_factor.md) | Calibration word (flash) | 0x42BEC -> 0x5B50 | 0x55 | air-pump injection trim | Function_0004AA8C, x(v+84)/170 at 0x6E566 | factor
[Overstid_tab](../reference/symbols/Overstid_tab.md) | Calibration table x16 (flash) | 0x41470 -> 0x5D56 | 28 x16 | injection over-time margin per rpm row (TPU arming slack) | scheduler reload calc | 4 us ticks
[Insp_vinkel](../reference/symbols/Insp_vinkel.md) | State word (RAM) | RAM alias; scheduled copy 0x1072 | runtime | injection angle for next TPU event (+0/180/360/540 per cylinder, firing 1-3-4-2) | written 0x69962, read 0x6CB98/0x6CC4E | crank degrees
[Grund_tid](../reference/symbols/Grund_tid.md) | State word array (RAM) | 0x4748 + cyl x 4 | runtime | base time and duration accumulator per injection slot | 0x6DDAA ... 0x6E684 | 4 us ticks (pre-/10 domain)
[Insp_tid](../reference/symbols/Insp_tid.md) | State word (RAM) | RAM alias (word written 0x6E684; halved in group mode 0x103B bit0) | runtime | final injection pulse width to TPU | output driver sec. 7 | 4 us ticks
[Insptid_ms10](../reference/symbols/Insptid_ms10.md) | State word (RAM) | 0x1064 (symbol table) | runtime | pulse-width copy for cluster consumption | 0x6E6A0 = Insp_tid/25 | 0.1 ms
[Lambdaint](../reference/symbols/Lambdaint.md) | State byte (RAM) | 0x102E area (Ghidra DAT_0000102e; disassembly alias RAM_Lambdaint) | reset 0x80 | closed-loop lambda integrator | mult (v+384)/512 at 0x6E356; steps 0x6A884 | +-128 -> +/-25 %
[Pgm_status](../reference/symbols/Pgm_status.md) | State byte (RAM) | 0x1041 (symbol table) | runtime | engine flags: bit3 running, bit5 overboost, bit7 rev-limit | gates cut paths 0x6C7F8, 0x6CC00 | bits
[KillInjection](../reference/symbols/KillInjection.md) | State byte (RAM, disassembly alias) | runtime | 0 | immobilizer/limp hard injection kill | TPU pulse writers 0x46EA6, 0x4729C, ... | bool
[Br_plus](../reference/symbols/Br_plus.md) | State word (RAM) | 0x1150 (symbol table) | 0 | additive fuel trim (plus) | + at 0x6E450 | 4 us ticks (/10 domain)
[Br_minus](../reference/symbols/Br_minus.md) | State word (RAM) | 0x1152 (symbol table) | 0 | additive fuel trim (minus) | - at 0x6E45A | 4 us ticks (/10 domain)
[Knock_status](../reference/symbols/Knock_status.md) | State byte (RAM) | 0x111A (symbol table) | runtime | knock detect state; bit0 arms [Fuel_knock_mat](../reference/symbols/Fuel_knock_mat.md) | 0x6DFA2 | bits
