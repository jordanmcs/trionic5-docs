
# Turbo_knock_tab

Calibration table, 16 words × rpm  ·  ROM 0x42B3A

**Value in factory 4780656:**

Interpolated by rpm in the knock-scaling path near boost control. Exact consumption still open — flagged, not asserted.

Axis: [Ign_map_0_y_axis](Ign_map_0_y_axis.md) (code-proven interpolation index, 0x61966–0x61B88).

| # | rpm | Raw | If ×1/128 (inference) |
|---|---|---|---|
| 0 | 500 | 150 | 1.17× |
| 1 | 880 | 150 | 1.17× |
| 2 | 1260 | 150 | 1.17× |
| 3 | 1640 | 150 | 1.17× |
| 4 | 2020 | 150 | 1.17× |
| 5 | 2400 | 150 | 1.17× |
| 6 | 2780 | 145 | 1.13× |
| 7 | 3160 | 144 | 1.12× |
| 8 | 3540 | 145 | 1.13× |
| 9 | 3920 | 147 | 1.15× |
| 10 | 4300 | 150 | 1.17× |
| 11 | 4680 | 150 | 1.17× |
| 12 | 5060 | 150 | 1.17× |
| 13 | 5440 | 149 | 1.16× |
| 14 | 5820 | 144 | 1.12× |
| 15 | 6200 | 138 | 1.08× |

**Function:** Interpolated by rpm in the knock-scaling path near boost control; magnitude suggests ~1.1–1.2× scaling under boost. Exact consumption still open — flagged, not asserted.

**Code path:** Near F_0006185E interpolation area.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
