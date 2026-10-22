# T5 Misfire Detection

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

> **Summary:** Misfires are detected by **ionic conduction** — the spark plug is the combustion sensor, and a commanded spark without a flame-front ion signature is one misfire event for that cylinder. Events accumulate per cylinder in two OBD windows: **Mis200** (400 combustions = 200 rev, catalyst criterion) and **Mis1000** (2000 combustions = 1000 rev, emissions criterion), normalized against limit maps [Mis200_map](../reference/symbols/Mis200_map.md) / [Mis1000_map](../reference/symbols/Mis1000_map.md) interpolated at the current rpm/load point. Counting is inhibited exactly when combustion is legitimately abnormal (fuel cut, rev limit, purge, AC kick, throttle/gear transients, cold engine). **The firmware reports misfires; it never cuts a cylinder on account of them.**

Working evidence: `source/misfire_system.md`, raw bytes `source/misfire_tables.txt`, window-machinery decompile `t5-re/evidence/torque_mine/func_0x63b1e.json`.

## Key facts

- Book glossary (verbatim): [Mis200_map](../reference/symbols/Mis200_map.md) "Contains maximum allowed misfire over 400 cumbustions for not causing catalyst overheating"; [Mis1000_map](../reference/symbols/Mis1000_map.md) "…over 2000 cumbustions for not causing emission level degradation".
- Window rollover clears `Mis200_1..4` / `Mis1000_1..4` (`0x64A70`–`0x64B9A`); per window `Mis200_cyl += events / `Mis200_limit`` — counters are limit-normalized excess.
- Axes [Misfire_map_x_axis](../reference/symbols/Misfire_map_x_axis.md) (boost/load) / [Misfire_map_y_axis](../reference/symbols/Misfire_map_y_axis.md) (rpm); reference grid [Detect_map](../reference/symbols/Detect_map.md) gates evaluation.
- Count-inhibit windows (not cut triggers): [Misfcut_ign_lim](../reference/symbols/Misfcut_ign_lim.md), [Misfpres_ign_lim](../reference/symbols/Misfpres_ign_lim.md), [Misfrpm_ign_lim](../reference/symbols/Misfrpm_ign_lim.md), [Misfac_ign_lim](../reference/symbols/Misfac_ign_lim.md), [Misfpur_ign_lim](../reference/symbols/Misfpur_ign_lim.md), [Misfgear_lim](../reference/symbols/Misfgear_lim.md), per-coolant-row tables [Mis_kyltemp_tab](../reference/symbols/Mis_kyltemp_tab.md) → [Misftakeoff_ign_tab](../reference/symbols/Misftakeoff_ign_tab.md) / [Misftrans_ign_tab](../reference/symbols/Misftrans_ign_tab.md), plus [Mis_trans_limit](../reference/symbols/Mis_trans_limit.md) ("Disables misfire detection during throttle transients + 5 cumbustions", book) and [Misf_kyltemp](../reference/symbols/Misf_kyltemp.md) / [Misf_rpm_diff](../reference/symbols/Misf_rpm_diff.md) gates.
- Exceedance paths: worst-cylinder selection at `0x5C590`, DTC/MIL state, live-data mirrors (`Mis200_tot` id 0x56, per-cyl 0x58..). Special modes `Mis_heating_error` / CVS.
- Hardware basis: DC bias on the plug gap, ion current read at the coil low-voltage side (book Appendix VII). "Trionic does not use a Piezo sensor, it uses the sparkplugs as Ion detection combustion sensors."

Related: [T5 Knock Detection and Adaptation](knock-detection-and-adaptation.md) (same sensing hardware) · [T5 Torque Intervention](torque-intervention.md) · [T5 Symbols](../reference/symbol-index.md)
