# Trionic 5.5 — Misfire Detection & Counters

> **Summary:** Misfire detection is an ion-current (ionic conduction) function: the spark plug itself is the combustion sensor, and a spark that produces no flame is reported as a misfire event. The ECU accumulates those events per cylinder into two OBD-style windows — **Mis200** (per 400 combustions = 200 crank revolutions, catalyst-damage criterion) and **Mis1000** (per 2000 combustions = 1000 revolutions, emissions criterion) — and compares them against the **limit maps** [Mis200_map](../reference/symbols/Mis200_map.md) / [Mis1000_map](../reference/symbols/Mis1000_map.md) interpolated for the current boost/rpm operating point. Counting is inhibited during conditions where combustion is intentionally or transiently abnormal (fuel cut, rev limit, purge, AC kick, throttle transients, gear changes, low coolant). Exceedance sets MIL/DTC state and per-cylinder worst-cylinder selection. **There is no cylinder cut and no torque intervention on the misfire path** — this firmware reports misfires; it does not react to them by cutting fuel or spark on the affected cylinder.

**Platform:** NG900 Saab 900/9-3, B204RM, OBD2. **Factory reference:** factory `4780656` throughout.

> **Correction notice:** an earlier draft of this document described misfire detection as crank-interval deviation ("180-deg sync capture" analysis) with an immediate per-cylinder fuel-cut path. Both are wrong. Detection is ion-flame based (book Appendix VII), and no cut path exists: no per-cylinder cut actuator symbol exists anywhere in the image, and the `Misf*_ign_lim` family is a family of **count-inhibit windows**, not cut triggers.

---

## 1. Measurement principle

Trionic uses the spark plugs as ionic-conduction combustion sensors (verbatim project glossary: "Trionic does not use a Piezo sensor, it uses the sparkplugs as Ion detection combustion sensors."). Book Appendix VII: a DC bias on the plug gap makes combustion ions drift → ion current, measured on the **low-voltage side of the ignition coil** — no high-voltage protection needed. Three phases are seen per event (ignition, flame-front peaks, post-flame pressure-following level). A missing flame-front signature in the combustion window after a commanded spark = misfire event for that cylinder (cylinder identified by firing-order position, 1-3-4-2).

The same combustion signal path (cassette → ECU pins 17/18) supplies ignition/fuel sync; the book: "combustion signals are also used to detect misfires." Single-event evaluation runs in the combustion-capture path; the counting layer below is what the application code manipulates.

- `Ign_counter_mis` (long) — running combustion counter (incremented at `0x63A80`); the time base for every window and inhibit below.
- `Jd_lastvar` — combustion-counter snapshot at the last fuel-cut end; used to keep counting inhibited a while after injector cut-out resumes.

## 2. Two OBD windows, per cylinder

Code: evaluation task at `0x63B1E` region (window/limit machinery `0x63D0E`–`0x64F00`).

| Window | Counter | Length (factory constants at `0x64AD6`) | Criterion (book glossary, verbatim) |
|---|---|---|---|
| **Mis200** | `Mis200_count` | 400 combustions (`0x190`) | "Contains maximum allowed misfire over 400 cumbustions for not causing catalyst overheating. Resolution is 1." |
| **Mis1000** | `Mis1000_count` | 2000 combustions (`0x7D0`) | "Contains maximum allowed misfire over 2000 cumbustions for not causing emission level degradation. Resolution is 1." |

At each window rollover the per-cylinder counters `Mis200_1..4` / `Mis1000_1..4` are cleared (`0x64A70`–`0x64A9C`, `0x64B3C`–`0x64B9A`). Per window, each cylinder's raw event count is scaled and accumulated:

```
Mis200_cyl += window_events_cyl / Mis200_limit      (0x64BB2–0x64BC4, DIVU)
```

`Mis200_limit` / `Mis1000_limit` (RAM working words, min 1) are the interpolated map limits: [Mis200_map](../reference/symbols/Mis200_map.md) / [Mis1000_map](../reference/symbols/Mis1000_map.md) (576-byte grids) with axes [Misfire_map_x_axis](../reference/symbols/Misfire_map_x_axis.md) / [Misfire_map_y_axis](../reference/symbols/Misfire_map_y_axis.md) (book: "Boost pressure in x axis"), interpolated at `0x6185C`–`0x6189C`; related reference grid [Detect_map](../reference/symbols/Detect_map.md) ("Reference map for misfire detection") feeds the gate word `Detect_limit`. Factory values in `misfire_tables.txt`; both totals report through the OBD live-data block (`Mis200_tot` id 0x56, `Mis200_1..4` 0x58.., `Mis1000_tot` 0x60, `Mis1000_1..4` 0x62..).

Because accumulation is divided by the current limit, `Mis200_cyl`/`Mis1000_cyl` are **limit-normalized excess counters**: 1.0 unit = "a full window's allowance of misfires at the current operating point." `Mis200_tot`/`Mis1000_tot` are the totals across cylinders.

`MisCountMap1..4` (diagnostic grids) histogram events per operating cell (e.g. `ADDQ.B #1,(RAM_MisCountMap2+D3)` at `0x64A02`) for live-data display; `0x4E86A` shows the FF-empty scan/clear.

## 3. Count-inhibit gates (why `Misf*_ign_lim` are not cut limits)

Combustion is legitimately abnormal (or sensing unreliable) in a set of conditions. Each has a **filter** — 4-byte per-cylinder counters `Misf*_ign_filt` (cut/pres/rpm/ac/pur/takeoff/trans/gear) — that runs while the condition is active, and an **inhibit limit** (`Misf*_ign_lim`) expressed in combustion counts relative to `Ign_counter_mis` snapshots (`0x38DE`–`0x3920` block; e.g. `MOVE.L (RAM_Ign_counter_mis),(RAM_Misfgear_counter)` at `0x640D0`). While `Ign_counter_mis − snapshot < limit`, events in that cylinder are not counted; filters are cleared at window rollover (block at `0x64A0A`/`0x64AA2`).

| Inhibit family | Condition excluded | Factory calibration |
|---|---|---|
| [Misfcut_ign_lim](../reference/symbols/Misfcut_ign_lim.md) | after/around injector fuel-cut periods | 1 word, `misfire_tables.txt` |
| [Misfpres_ign_lim](../reference/symbols/Misfpres_ign_lim.md) | overboost/pressure excursions | 1 word |
| [Misfrpm_ign_lim](../reference/symbols/Misfrpm_ign_lim.md) | rev-limit activity | 1 word |
| [Misfac_ign_lim](../reference/symbols/Misfac_ign_lim.md) | AC compressor kick load step | 1 word |
| [Misfpur_ign_lim](../reference/symbols/Misfpur_ign_lim.md) | purge flow disturbances | 1 word |
| `Misftakeoff_ign_lim` / [Misftakeoff_ign_tab](../reference/symbols/Misftakeoff_ign_tab.md) | tip-in (load increase) — 14-row table selected by coolant ([Mis_kyltemp_tab](../reference/symbols/Mis_kyltemp_tab.md)) via loop at `0x63E62` | 14 bytes |
| `Misftrans_ign_lim` / [Misftrans_ign_tab](../reference/symbols/Misftrans_ign_tab.md), `Misftransa/r_limit` | accelerate/decelerate transients — same temp-row loop | 14 bytes |
| [Misfgear_lim](../reference/symbols/Misfgear_lim.md) / `Misfgear_filt` | gear changes (AT) | word |
| `Mis_thrott_ign_lim(_g)` | sudden throttle opening | word |
| [Mis_trans_limit](../reference/symbols/Mis_trans_limit.md) | "Disables misfire detection during throttle transients + 5 cumbustions. if (Trans_trott > [Mis_trans_limit](../reference/symbols/Mis_trans_limit.md)) Disable misfire detection" (book, verbatim) | table |

Global enable gates (code `0x64AE8`–`0x64B38` + book): `Detect_limit` must be above the current count; closed-throttle status bit `0x103A & 0x04` skips evaluation; coolant must be ≥ [Misf_kyltemp](../reference/symbols/Misf_kyltemp.md); after a fuel-cut resume, counting waits until `Ign_counter_mis` passes `Jd_lastvar`; [Mis_temp_limit](../reference/symbols/Mis_temp_limit.md) — "Below this cooling water temp limit no misfire are [counted]"; [Misf_rpm_diff](../reference/symbols/Misf_rpm_diff.md) / [Misf_rpm_diff_start](../reference/symbols/Misf_rpm_diff_start.md) (rpm-difference validity), [Misf_wait_time](../reference/symbols/Misf_wait_time.md) (settling wait), and idle snapshots `Misf_ignc1..4_idle`.

## 4. What exceedance does — reporting only

Diagnostic evaluation (`0x5C4xx`–`0x5CB6x`): with `Mis200_tot ≠ 0` and window conditions (`Ign_counter_mis` vs `0x352`/`0x9C4`), compare totals against the window constants (`CMPI.W #0190`/`#07D0`) and pick the **worst cylinder** (`CMP.W Mis200_1..4` at `0x5C590`–`0x5C5B6`) → per-cylinder misfire DTC state (P0301–P0304) / general (P0300); `Mis1000_*` paths drive the emissions (MIL-request) flag; all counters mirror into the live-data image at `0x5F2E6`+ (`0x22FA` block). Special modes `Mis_heating_error` / `Mis_CVS_error` (+ frame bytes) handle misfire logic during fuel heating / CVS purge test modes.

**No actuator reacts.** Grepping the full symbol namespace: no cut/derate label exists downstream of the misfire counters; the engine-protection cuts (rev limit, fuel save, overboost) come from their own strategies (fuel doc). Torque interventions (torque doc) likewise never fire because of misfire.

## 5. Calibration table reference

Full raw bytes: **`misfire_tables.txt`** (25 tables, factory-authoritative via init-copy inventory; MCS diffs: catalogued in `T5 MCS Tune Changes.md`). Key entries: [Mis200_map](../reference/symbols/Mis200_map.md), [Mis1000_map](../reference/symbols/Mis1000_map.md) (576-byte limit grids), [Misfire_map_x_axis](../reference/symbols/Misfire_map_x_axis.md)/`_y_axis`, `Detect_map(_x_axis/_y_axis)`, [Mis_kyltemp_tab](../reference/symbols/Mis_kyltemp_tab.md) (14 coolant rows), [Misftakeoff_ign_tab](../reference/symbols/Misftakeoff_ign_tab.md) / [Misftrans_ign_tab](../reference/symbols/Misftrans_ign_tab.md) (14 limit rows), the `Misf*_ign_lim` scalar set, `Misf_rpm_diff(_start)`, [Misf_kyltemp](../reference/symbols/Misf_kyltemp.md), [Misf_wait_time](../reference/symbols/Misf_wait_time.md), [Ign_counter_mis_lim](../reference/symbols/Ign_counter_mis_lim.md).

## 6. Open items

- The bit-level single-event decision (ion-pulse amplitude/width thresholds in the combustion-capture handler, and [Detect_map](../reference/symbols/Detect_map.md)'s exact role vs the two limit maps) sits in the capture/scheduler layer — not re-derived this pass; book Appendix VII is the mechanism reference.
- [Ign_counter_mis_lim](../reference/symbols/Ign_counter_mis_lim.md) table (4 words) exact window semantics (values `[0,0,9,96]` per init copy) not fully mapped.
- Whether misfire during the `Mis_heating_error`/`Mis_CVS_error` modes suppresses or doubles counting not traced.

*Evidence: `evidence/torque_mine/func_0x63b1e.*` (window machinery pseudocode), ASM cross-references (`0x63A80`, `0x64A0A`–`0x64F00`, `0x5C4xx`–`0x5CB6x`, `0x5F2E6`), `data/init_copy_inventory.factory.json`, book glossary (Mis* family) and Appendix VII pp 145–148, live-data byte map (appendix counters).*
