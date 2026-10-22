
# Lknock_oref_tab

Calibration table, 16 words × rpm · ROM 0x42AFA

**Value in factory 4780656:**

Percentage trim applied to [Knock_ref_matrix](Knock_ref_matrix.md) before the per-window comparison.

Axis: [Ign_map_0_y_axis](Ign_map_0_y_axis.md) (code-proven interpolation index, 0x61966–0x61B88).

| # | rpm | Raw | Reference scale |
|---|---|---|---|
| 0 | 500 | 200 | 2.00× |
| 1 | 880 | 200 | 2.00× |
| 2 | 1260 | 130 | 1.30× |
| 3 | 1640 | 130 | 1.30× |
| 4 | 2020 | 130 | 1.30× |
| 5 | 2400 | 130 | 1.30× |
| 6 | 2780 | 125 | 1.25× |
| 7 | 3160 | 125 | 1.25× |
| 8 | 3540 | 125 | 1.25× |
| 9 | 3920 | 125 | 1.25× |
| 10 | 4300 | 125 | 1.25× |
| 11 | 4680 | 120 | 1.20× |
| 12 | 5060 | 120 | 1.20× |
| 13 | 5440 | 120 | 1.20× |
| 14 | 5820 | 120 | 1.20× |
| 15 | 6200 | 120 | 1.20× |

**Function:** Percentage trim scaling [Knock_ref_matrix](Knock_ref_matrix.md) before comparison.

**Code path:** Applied in F_00060BFE evaluation.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
