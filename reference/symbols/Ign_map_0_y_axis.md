
# Ign_map_0_y_axis

Calibration axis, 16 words (rpm) · ROM 0x4184A (RAM [Ign_map_0_y_axis](Ign_map_0_y_axis.md))

**Value in factory 4780656:** 16 words, rpm 500–6200 (full table below).

rpm interpolation axis of the main ignition map — and the **proven axis of the 16-word knock tables**: the shared index search at 0x61966–0x61A30 feeds [Knock_lim_tab](Knock_lim_tab.md) (0x61A3E), [Turbo_knock_tab](Turbo_knock_tab.md) (0x61AA2), [Knock_average_tab](Knock_average_tab.md) (0x61AD4), [Knock_press_tab](Knock_press_tab.md) (0x61B06), [Lknock_oref_tab](Lknock_oref_tab.md) (0x61B6E); [Knock_ref_matrix](Knock_ref_matrix.md) passes it to the generic 2-D interpolation `F_00061F30` (0x61B40).

| # | rpm | Raw |
|---|---|---|
| 0 | 500 | 500 |
| 1 | 880 | 880 |
| 2 | 1260 | 1260 |
| 3 | 1640 | 1640 |
| 4 | 2020 | 2020 |
| 5 | 2400 | 2400 |
| 6 | 2780 | 2780 |
| 7 | 3160 | 3160 |
| 8 | 3540 | 3540 |
| 9 | 3920 | 3920 |
| 10 | 4300 | 4300 |
| 11 | 4680 | 4680 |
| 12 | 5060 | 5060 |
| 13 | 5440 | 5440 |
| 14 | 5820 | 5820 |
| 15 | 6200 | 6200 |

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
