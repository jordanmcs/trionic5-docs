
# Knock_average_tab

Calibration table, 16 words × rpm · ROM 0x42B5A

**Value in factory 4780656:**

Rpm-scheduled ceiling for the four-cylinder average offset before the sustained-knock status flag sets.

Axis: [Ign_map_0_y_axis](Ign_map_0_y_axis.md) (code-proven interpolation index, 0x61966–0x61B88).

| # | rpm | Raw | Escalation limit (raw × 0.1°) |
|---|---|---|---|
| 0 | 500 | 80 | 8.0° |
| 1 | 880 | 80 | 8.0° |
| 2 | 1260 | 80 | 8.0° |
| 3 | 1640 | 80 | 8.0° |
| 4 | 2020 | 80 | 8.0° |
| 5 | 2400 | 80 | 8.0° |
| 6 | 2780 | 80 | 8.0° |
| 7 | 3160 | 70 | 7.0° |
| 8 | 3540 | 60 | 6.0° |
| 9 | 3920 | 50 | 5.0° |
| 10 | 4300 | 40 | 4.0° |
| 11 | 4680 | 30 | 3.0° |
| 12 | 5060 | 20 | 2.0° |
| 13 | 5440 | 20 | 2.0° |
| 14 | 5820 | 20 | 2.0° |
| 15 | 6200 | 20 | 2.0° |

**Function:** Escalation limits: rpm-scheduled ceiling for [Knock_average](Knock_average.md) before the sustained-knock status flag sets.

**Code path:** Interpolated to [Knock_average_limit](Knock_average_limit.md) at 0x61AD4.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
