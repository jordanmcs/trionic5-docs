
# Knock_lim_tab

Calibration table, 16 words × rpm · ROM 0x417DE

**Value in factory 4780656:**

Max per-cylinder knock retard, interpolated by rpm. **Byte-identical to factory 4780656.**

Axis: [Ign_map_0_y_axis](Ign_map_0_y_axis.md) (code-proven interpolation index, 0x61966–0x61B88).

| # | rpm | Raw | Retard cap (raw × 0.1°) |
| --- | ---- | --- | ----------------------- |
| 0 | 500 | 30 | 3.0° |
| 1 | 880 | 30 | 3.0° |
| 2 | 1260 | 80 | 8.0° |
| 3 | 1640 | 120 | 12.0° |
| 4 | 2020 | 130 | 13.0° |
| 5 | 2400 | 130 | 13.0° |
| 6 | 2780 | 130 | 13.0° |
| 7 | 3160 | 120 | 12.0° |
| 8 | 3540 | 120 | 12.0° |
| 9 | 3920 | 100 | 10.0° |
| 10 | 4300 | 90 | 9.0° |
| 11 | 4680 | 90 | 9.0° |
| 12 | 5060 | 90 | 9.0° |
| 13 | 5440 | 90 | 9.0° |
| 14 | 5820 | 90 | 9.0° |
| 15 | 6200 | 90 | 9.0° |

**Function:** Maximum per-cylinder knock retard at each rpm point: 3.0° idle, 13.0° at ~2500, 9.0° at redline. Byte-identical to factory 4780656.

**Code path:** Interpolated by F_0006185E; enforced by the offset engine.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
