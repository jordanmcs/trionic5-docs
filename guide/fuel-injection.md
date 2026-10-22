# T5 Fuel Injection

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

> **Summary:** Base pulse = **injector constant × air charge**, then a fixed multiplier chain: global adaptation → one of {main VE map [Insp_mat](../reference/symbols/Insp_mat.md) + per-cell adaptation | idle map | knock map} → warm-up blend → transient max/min → WOT enrichment → lambda integrator (±25 %) → post-cut/hot-start ramps → cylinder balance trims → additive trims + purge, then ÷10, **battery-voltage open-time add**, minimum-duration floor [Min_tid](../reference/symbols/Min_tid.md) (250 = 1.000 ms), cap 130 ms. Injection is **fully sequential, firing order 1-3-4-2**, one pulse per port per 720° cycle, at a fixed crank angle ([Vinkel_konst](../reference/symbols/Vinkel_konst.md) = 53°) — with grouped/halved fallback whenever cycle sync is lost.

Time base: **1 tick = 4 µs** (anchor: [Min_tid](../reference/symbols/Min_tid.md) = 250 = 1 ms per the book). Working evidence: `source/fuel_system.md`, raw bytes `source/fuel_tables.txt`, decompiles in `t5-re/evidence/fuel/`. Driver: `Function_0006D2BC` per injection cycle.

## Air charge and load

8-sample rolling window of rpm × raw MAP, divided by rpm → averaged load; density-corrected by intake-air-temp factor (`Lufttemp_faktor`, 0x80 = 1.000) into the air-charge word (`0x355A`). `Medellast` byte = kPa absolute. [Grund_last](../reference/symbols/Grund_last.md) (init 37, max 50 kPa) is a learned **idle-load floor** that creeps up only above 55 °C — it keeps idle recognition honest as the engine ages.

## Duration chain (code order)

1. `Grund_tid = Inj_konst × aircharge` — the mass term; [Inj_konst](../reference/symbols/Inj_konst.md) factory 20. Because this term is linear in air mass, a fuel that needs proportionally more mass per unit of air (E85: stoichiometric mixture ~1.5× richer) is tuned by scaling [Inj_konst](../reference/symbols/Inj_konst.md) up by the same factor — the method the T5Suite book prescribes; **there is no E85 bit** in [Pgm_mod](../reference/symbols/Pgm_mod.md).
2. × global adaptation ([Adapt_injfaktor](../reference/symbols/Adapt_injfaktor.md) + 384)/512
3. one load branch:
 - **idle map** [Idle_fuel_korr](../reference/symbols/Idle_fuel_korr.md) (book formula (v+128)/256) + idle global adaptation [Adapt_inj_imat](../reference/symbols/Adapt_inj_imat.md), engaged at closed throttle below idle rpm/load limits once the idle counter passes [Com_on_idle](../reference/symbols/Com_on_idle.md);
 - **normal**: [Insp_mat](../reference/symbols/Insp_mat.md) × per-cell pointed adaptation [Adapt_korr](../reference/symbols/Adapt_korr.md);
 - **knock**: while knock status bit 0 and load exceeds the knock map's first column, [Fuel_knock_mat](../reference/symbols/Fuel_knock_mat.md) *replaces* both VE factors for the cycle (book: enrichment regime above ~140 kPa).
4. × warm-up after-start blend ([Temp_fak](../reference/symbols/Temp_fak.md) family — see [T5 Warmup Cycle and Temperature Inputs](warmup-cycle-and-temperature-inputs.md))
5. transient: acceleration `max(load-deriv, throttle-deriv)` enrichment, deceleration `min(...)` lean-out (`Lacc/Acc/Ret/Lret` demand quantities, ceilings `Max_*_dec`)
6. × WOT catalyst enrichment ([Fload_tab](../reference/symbols/Fload_tab.md) +6…10 %, throttle-AD gated, 550–2400 rpm only)
7. × lambda integrator ([Lambdaint](../reference/symbols/Lambdaint.md) + 384)/512 — closed loop ±25 %
8. × post-cut re-enrichment ([Ret_fuel_fak](../reference/symbols/Ret_fuel_fak.md)), hot-start, after-fuel-cut ramps; × per-cylinder [Cyl_komp](../reference/symbols/Cyl_komp.md) only below [Last_cyl_komp](../reference/symbols/Last_cyl_komp.md) = 40 kPa
9. \+ `Br_plus − Br_minus`, + purge compensation
10. ÷ 10, + `Batt_korr_tab[14 − V]` (injector open-time compensation, 0.59–3.7 ms, added *after* all scaling), air-pump trim
11. overrides: fixed idle time [Tid_konst](../reference/symbols/Tid_konst.md), external/dyno `Extern_tid`; floor [Min_tid](../reference/symbols/Min_tid.md); cap 32500 ticks
→ [Insp_tid](../reference/symbols/Insp_tid.md) (halved in group fallback) → TPU.

## Injection timing

`Function_00069808` selects [Insp_vinkel](../reference/symbols/Insp_vinkel.md): cranking → [Start_v_vinkel](../reference/symbols/Start_v_vinkel.md) (0°); running default → constant [Vinkel_konst](../reference/symbols/Vinkel_konst.md) 53°; `Pgm_mod[0]` bit 2 → interpolated delay map [Del_mat](../reference/symbols/Del_mat.md) × 3. The scheduler writes TPU angle word = `Insp_vinkel + 0/180/360/540°` per cylinder (cyl 1/3/4/2 — firing order 1-3-4-2): **one injector fires per crank revolution**, one port pulse each per cycle. Lost sync or skipped cylinder → grouped mode (`0x103B` bit 0): no per-cylinder offsets and each pulse halved so the pair delivers one charge. Peak/hold dwell is a TPU link-list property, not a duration variable.

## Lambda feedback and adaptation

- Closed loop (`Function_0006A884`): integrator byte 0x80 = 1.000, ±128 → ±25 %; asymmetric lean/rich step rates [Lean_step_map](../reference/symbols/Lean_step_map.md)/[Rich_step_map](../reference/symbols/Rich_step_map.md) per rpm/load; gated by coolant/sensor temp ([Lamb_temp](../reference/symbols/Lamb_temp.md)), minimum switch count, load floors [Lam_minlast](../reference/symbols/Lam_minlast.md), per-rpm open-loop ceilings [Open_loop](../reference/symbols/Open_loop.md)/[Open_loop_adapt](../reference/symbols/Open_loop_adapt.md)/[Open_loop_knock](../reference/symbols/Open_loop_knock.md). Any gate dropping resets the integrator to 0x80.
- Pointed adaptation: cells in [Adapt_korr](../reference/symbols/Adapt_korr.md) ±1/event outside the λ dead band at closed throttle; bounds 0x4D…0xB3 (≈ ±20 %/cell) — exceeding them sets CEL.
- Global adaptation: mean [Lambdaint](../reference/symbols/Lambdaint.md) accumulated in the window 40–104 kPa × 1740–2970 rpm every [Adaption_time](../reference/symbols/Adaption_time.md) (5) min → [Adapt_injfaktor](../reference/symbols/Adapt_injfaktor.md) clamped 0x1A…0xE6 (−20/+20 %). Book's "60–120 kPa / 2000–3000 rpm, ±25 %, every fifth minute" — same mechanism, code-window numbers.
- Idle branch has its own global factor [Adapt_inj_imat](../reference/symbols/Adapt_inj_imat.md).

## Fuel cuts

All cuts clear injector channel enable bytes; after-reaction ramps ([After_fcut_tab](../reference/symbols/After_fcut_tab.md), [Ret_fuel_fak](../reference/symbols/Ret_fuel_fak.md)) climb back.

- **Overboost** — see [T5 Boost Control](boost-control.md) ([Tryck_vakt_tab](../reference/symbols/Tryck_vakt_tab.md)).
- **Rev limit** — `Rpm > Rpm_max` (factory 6400), re-cut window [Rpm_dif](../reference/symbols/Rpm_dif.md) produces burst cutting.
- **Deceleration / fuel save** — closed throttle above ~1900 rpm in gear: [Delay_cut](../reference/symbols/Delay_cut.md) timer, per-cylinder cut pattern, re-enable at [Open_varv](../reference/symbols/Open_varv.md) (1400 rpm), forced re-enable below [Open_all_varv](../reference/symbols/Open_all_varv.md) (1000 rpm).
- **Per-cylinder torque cut** for shift requests; **[KillInjection](../reference/symbols/KillInjection.md)** (immobilizer/limp) emits the no-pulse code at the TPU writers regardless of everything else.

## Factory-side notes

Index: [T5 Symbols](../reference/symbol-index.md)
