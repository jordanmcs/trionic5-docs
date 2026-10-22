# Trionic 5.5 — Torque Intervention & Drivability

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

> **Summary:** Trionic 5.5 has no central "torque arbitration" module and no torque request bus. Torque interventions are produced by small strategy blocks that each write one shared ignition-retard word, **0x390E** (ignition-offset domain), plus discrete fuel/boost limiters. The final ignition combiner (`Function_00061F30`, exit at `0x62840`) subtracts 0x390E from the summed advance every cycle. The automatic-transmission strategies — **API_dt** ("Drive and Throttle", N→D engagement) and **API_ku** ("Kickdown and Upshift") — are internal ECU estimators: they infer what the gearbox is doing from engine sensors (gearbox gear-characteristic discrete, engine-speed trace, throttle delta). There is no serial torque path to the transmission.

**Platform:** NG900 Saab 900/9-3, B204RM, OBD2 (factory footer `B204RM-900 C2 OBD2`). No Trionic 5 9-5 exists; the ZF 4HP22 EHS gearbox shifts autonomously — the ECU never commands shift elements.

**Factory reference:** everything below is factory `4780656`.> **Correction notice:** an earlier draft of this document described a "central torque request hub" with priority arbitration and a transmission ECU feeding request flags. That draft was wrong and has been replaced with the decompiled reality below; no arbitration hub exists in the image.

---

## 1. Architecture — how an intervention reaches the engine

```
strategy blocks (main task) combiner output
──────────────────────────── ──────────── ──────
API_dt / API_ku governor ──► 0x3910 latch ──► 0x390E retard word ─┐
MT shift blip (F_00071F30) ──► scheduler │ ├─► Function_00061F30
rev-limit / fuel-save (fuel doc) │ │ Σ per-cyl offsets
 0x3896 global offset ─► per-cyl timing ─► TPU
```

- **0x390E** (word) — the intervention retard actually applied. **0x3910** — latched request value used to build the linear ramp. **0x390C** — status byte: bit 7 = dt active, bit 6 = ku active.
- **Application point** (`0x62824`–`0x62836`, inside `Function_00061F30`): `timing = Σ(Ign_offset_cyl1..4) − 0x390E + 0x3896`. There is exactly one consumer of 0x390E in the whole image; every retard strategy ends up in this subtraction.
- All strategy blocks are called from one periodic main task region (`0x6D2BC`–`0x6F4xx`): API governor `F_0006185E` (JSR at `0x6CFCE`), MT shift task `F_00071F30` (JSR at `0x6D636`), AC/idle/Mainrly logic in the same task.
- Timers compare against the millisecond system counter (word 0x3B02).
- **`RAM_API` is not a bus.** The byte labelled `RAM_API` has zero producers anywhere in the 256 KB image — it is a handshake/flag byte the governor sets and clears on itself. "API" is the internal torque-strategy namespace, not a communication link. The only gearbox-related hardware inputs are the Drive gear-characteristic discrete (read via `F_00044B86`, ECU pin 14) and the torque-limit request discrete (pin 13, asserted by the EHS mechatronic unit); the 615 Kbit/s figure belongs to the CAN/SFI diagnostic link only. (Full evidence trail: API-communication investigation, 2026-10-20.)
- **APC note (verbatim from project glossary):** "no APC is still used in this binary to reference the Automatic Performance Control system (boost control). It shouldn't be confused with early saab APC systems which were completely different."

## 2. API_dt — "Drive and Throttle" (engagement torque assist)

Code: `Function_0006185E` at `0x61CB2`–`0x61DE0`. Gated by the AT configuration bit (`0x76E5 & 0x02`) and "engine running" (`0x1039 & 0x08`; when not running, the gate clears 0x390C bits 7/6 and zeroes 0x390E).

1. Gear character: `F_00044B86()` returns 'N' or 'D' (gearbox characteristic discrete). Working copy at 0x3912, previous value at 0x3913.
2. Throttle delta word **0x3918** = max(0, current throttle AD (0x1015) − stored reference (0x197B)).
3. **On the N→D edge** (3912=='D', 3913!='D'): set dt-active (0x390C bit 7); bin 0x3918 against the 5-point axis [API_throttle_tab](../reference/symbols/API_throttle_tab.md) (factory 10/20/30/40/50, thresholds at adjacent-cell midpoints); retard request = `API_dt_offset_tab[bin]` (5 words); latch to 0x3910, copy to 0x390E, timestamp 0x3914 = now.
4. While active and *before* [API_dt_delay](../reference/symbols/API_dt_delay.md) (factory 1000 ms) elapses, a new throttle step re-bins and re-arms the request.
5. After the delay, linear ramp-out: `0x390E = 0x3910 · (1 − (t − t₀ − delay) / API_dt_ramp)` (factory [API_dt_ramp](../reference/symbols/API_dt_ramp.md) = 500 ms); cleared when it reaches 0.

**Factory calibration: [API_dt_offset_tab](../reference/symbols/API_dt_offset_tab.md) = all zeros — the dt retard is disabled at factory.** The machinery (trigger, delay, ramp) runs; the retard magnitude is zero.

## 3. API_ku — "Kickdown and Upshift" (upshift shock cut)

Same function, `0x61E3A`–`0x61F0A`. Detects the momentary engine-speed *drop* of an automatic upshift during a hard acceleration and applies a short fixed retard:

1. Rate detection from consecutive raw engine-speed samples (word 0x3C32; previous-tick snapshot 0x391A): sign word 0x3919 ← '+' if speed rose by ≥10 rpm, '−' if it fell by more than [API_ku_derivata](../reference/symbols/API_ku_derivata.md) (10), else '0'. Last non-zero sign kept at 0x391C.
2. Trigger (all required): [API_rpm_limit](../reference/symbols/API_rpm_limit.md) (4000 rpm) < speed **and** [API_throttle_limit](../reference/symbols/API_throttle_limit.md) (100 AD counts) < 0x3918 **and** sign == '−' **and** previous recorded sign ≠ '−' (edge) **and** 3000 ms cooldown since the last retard event.
3. On trigger: retard = [API_ku_offset](../reference/symbols/API_ku_offset.md) (single word), latched to 0x3910/0x390E, timestamp 0x3914; hold [API_ku_delay](../reference/symbols/API_ku_delay.md) (200 ms), linear ramp-out over [API_ku_ramp](../reference/symbols/API_ku_ramp.md) (200 ms).

**Factory calibration: [API_ku_offset](../reference/symbols/API_ku_offset.md) = 0 — also disabled at factory.** On factory 4780656 both API retard paths execute their state machines but contribute zero retard; the calibration points exist for variants that need them.

Since [API_ku_offset](../reference/symbols/API_ku_offset.md) is 0 at factory, the intervention produces no retard unless the offset is also tuned.

## 4. MT manual-transmission upshift blip — `Function_00071F30`

For manual cars (AT bit clear). Requests a **full ignition cut** (via the scheduler channel path, not 0x390E) during lever moves:

- Inputs: engine temp vs [Shift_up_temp](../reference/symbols/Shift_up_temp.md) (40 °C), [Shift_max_rpm](../reference/symbols/Shift_max_rpm.md) guard (5500), gear-indexed shift-window centre `Shift_rpm[gear]` (2000/1900/1800/1700 rpm) ± [Shift_up_rpm_hyst](../reference/symbols/Shift_up_rpm_hyst.md) (50 rpm), gear-change detection from [Gear_st](../reference/symbols/Gear_st.md) / [Gear_ratio_delta](../reference/symbols/Gear_ratio_delta.md) (gear ratios ×10 and ratio steps ×10 per the book glossary).
- When a shift is inferred inside the window: cut timing for [Shift_up_time](../reference/symbols/Shift_up_time.md) (3), release after [Shift_up_off_time](../reference/symbols/Shift_up_off_time.md) (3) — timed by the tick engine `F_0006162A`.
./reference/symbols/Gear_st.md) / [Gear_ratio_delta](../reference/symbols/Gear_ratio_delta.[Shift_up_temp](../reference/symbols/Shift_up_temp.md) is identical.

## 5. Retard sources other than API

- **Rev limit / fuel-save cut:** see fuel doc ([Rpm_max](../reference/symbols/Rpm_max.md) → [Pgm_status](../reference/symbols/Pgm_status.md) bit 7 → scheduler clears injector channels).
- **Knock retard:** separate per-cylinder path (`Knock_offset1234`, combined in the APC/knock block `Function_00062842`) — see knock docs. It does not use 0x390E.
- **Misfire cylinder cut:** see misfire doc (per-cylinder flags + scheduler, not 0x390E).
- **AC engagement:** compressor load is handled mainly on the idle-speed side: [AC_const](../reference/symbols/AC_const.md) (12) / [AC_slope](../reference/symbols/AC_slope.md) (4) raise the idle-speed target with [AC_delay](../reference/symbols/AC_delay.md) (64 ms); engagement/release delay tables indexed by rpm row: [AC_wait_on](../reference/symbols/AC_wait_on.md) (8×0x0E), [AC_wait_off](../reference/symbols/AC_wait_off.md) (0x12→0x04 decreasing); plus [AC_Control](../reference/symbols/AC_Control.md) (05 3A 03 E8) and a compensation map (axes `AC_start_tid` 14, `AC_klick` 8, `AC_fak` 30) interpolated at `0x72700`. Governor code checks AC status words (e.g. `0x6D1E2`, `0x6D22E`) when coordinating retard permission during AC engagement.
- **Main relay gate:** [Mainrly_off](../reference/symbols/Mainrly_off.md) (24) is compared by the time engine at `0x6D3B2` — part of the torque/idle region stays inhibited until the main relay has been on past this threshold (anti-stall at start). There is no "limp interface via main relay" — the main relay is a power output, not a torque arbitration path.

## 6. Fuel-side and boost-side companions

- **Temp_reduce** (`F_00069FEC`): during interventions the fuel temperature compensation is *reduced*: 8×8 matrices [Temp_reduce_mat](../reference/symbols/Temp_reduce_mat.md) (RAM 0x6136) / [Temp_reduce_mat_2](../reference/symbols/Temp_reduce_mat_2.md) (0x6176, branch selected by status bit 0x103A bit2), x-axis [Temp_reduce_x_st](../reference/symbols/Temp_reduce_x_st.md) = coolant 30→192 °C, y-axis [Temp_reduce_y_st](../reference/symbols/Temp_reduce_y_st.md) (0x61BE); output byte 0x46D4 consumed by the fuel task at `0x6E11E`/`0x6E148`. Factory matrices contain 0xFF clamp cells (no reduction) in the upper-left region.
- **Br (brake-vacuum) trim:** the idle task computes a brake-servo compensation (`0x707CC`: pointers to `RAM_Br_plus`/`RAM_Br_minus`; tables [Br_plus_tab](../reference/symbols/Br_plus_tab.md)/[Br_minus_tab](../reference/symbols/Br_minus_tab.md), factory all-zero); consumed by the fuel task at `0x6E43C`–`0x6E444`. Not a "fuel production" map — a trim word for idle stability under brake-load steps.
- **Boost limit during intervention:** the AT-region limiter (`0x7285C`) enforces per-gear boost ceilings from the [Regl_tryck_sgm](../reference/symbols/Regl_tryck_sgm.md)/[Regl_tryck_fgm](../reference/symbols/Regl_tryck_fgm.md) family (book glossary: "Boost limiter 2nd gear manual", values kPa absolute; factory soft limits 0xC2→0x9F) — a ceiling imposed by the torque/idle region, distinct from the main [Tryck_mat](../reference/symbols/Tryck_mat.md) load-regulation loop (boost doc).

## 7. Calibration table reference

All raw bytes and ROM/RAM addresses: **`torque_tables.txt`** (generated from the byte-verified init-copy inventory).

| Table | Factory value(s) | Role |
|---|---|---|
| [API_throttle_tab](../reference/symbols/API_throttle_tab.md) | 10 20 30 40 50 | dt throttle-delta axis |
| [API_dt_offset_tab](../reference/symbols/API_dt_offset_tab.md) | 0 0 0 0 0 | dt retard per bin — **disabled at factory** |
| [API_dt_delay](../reference/symbols/API_dt_delay.md) / [API_dt_ramp](../reference/symbols/API_dt_ramp.md) | 1000 / 500 ms | dt hold / ramp-out |
| [API_ku_offset](../reference/symbols/API_ku_offset.md) | 0 | ku retard — **disabled at factory** |
| [API_ku_delay](../reference/symbols/API_ku_delay.md) / [API_ku_ramp](../reference/symbols/API_ku_ramp.md) | 200 / 200 ms | ku hold / ramp-out |
| [API_ku_derivata](../reference/symbols/API_ku_derivata.md) | 10 rpm | upshift-drop sign hysteresis |
| [API_rpm_limit](../reference/symbols/API_rpm_limit.md) / [API_throttle_limit](../reference/symbols/API_throttle_limit.md) | 4000 rpm / 100 | ku gates |
| [Shift_up_temp](../reference/symbols/Shift_up_temp.md) | 40 °C | MT blip enable temp |
| `Shift_rpm[gear]` | 2000/1900/1800/1700 | MT shift windows (rpm) |
| [Shift_up_time](../reference/symbols/Shift_up_time.md) / [Shift_up_off_time](../reference/symbols/Shift_up_off_time.md) | 3 / 3 | MT cut duration / release |
| [Gear_st](../reference/symbols/Gear_st.md) / [Gear_ratio_delta](../reference/symbols/Gear_ratio_delta.md) | ratios ×10 / steps ×10 | MT shift detection |
| [Mainrly_off](../reference/symbols/Mainrly_off.md) | 24 | main-relay on-time gate |
| [Regl_tryck_sgm](../reference/symbols/Regl_tryck_sgm.md) | 194→159 kPa | intervention boost ceiling (per gear) | → flat 200 |
| [Br_plus_tab](../reference/symbols/Br_plus_tab.md) / [Br_minus_tab](../reference/symbols/Br_minus_tab.md) | all 0 | brake-vacuum fuel trim | = |
| [Temp_reduce_mat](../reference/symbols/Temp_reduce_mat.md) / `_mat_2` | 8×8 grids, 0xFF clamps | Temp-compensation reduction during intervention | = |

## 8. Open items

- Exact unit scale of [API_dt_offset_tab](../reference/symbols/API_dt_offset_tab.md)/[API_ku_offset](../reference/symbols/API_ku_offset.md) cells in the 0x390E combiner domain (0.1° vs 0.2° crank) not yet pinned; book describes API retard qualitatively only.
- [Gear_st](../reference/symbols/Gear_st.md) unit (words 137 71 48 36 27) unknown; MT-only path on this AT-capable binary, low priority.
- The exact ASIC input-index bit for the pin-13 torque-limit request discrete was not traced this pass.
- `0x39BD` 'D'/'U' road-gradient state byte computed beside the API governor (from coast-down of speed word 0x3B72 every 6 evaluations) — consumer not traced.

*Evidence: `evidence/torque_mine/` (REA pseudocode for 0x6185E, 0x71F30, 0x71D12, 0x69FEC, 0x6D2BC, 0x63B1E, 0x61F30), `firmware/4780656.asm` cross-references, `data/init_copy_inventory.factory.json` (factory byte authority), `docs/trionic5_book.txt`.*
