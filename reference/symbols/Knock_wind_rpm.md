
# Knock_wind_rpm

Calibration axis, 16 words · ROM 0x42B7A

**Value in factory 4780656:**

Dedicated rpm axis (raw rpm ÷ 10) for the two detection-window edge tables only — interpolation search at 0x60AF4. The other 16-word knock tables interpolate on [Ign_map_0_y_axis](Ign_map_0_y_axis.md) instead.

| # | rpm | Raw (rpm ÷ 10) |
|---|---|---|
| 0 | 1000 | 100 |
| 1 | 1500 | 150 |
| 2 | 1750 | 175 |
| 3 | 2000 | 200 |
| 4 | 2250 | 225 |
| 5 | 2500 | 250 |
| 6 | 3000 | 300 |
| 7 | 3500 | 350 |
| 8 | 4000 | 400 |
| 9 | 4500 | 450 |
| 10 | 5000 | 500 |
| 11 | 5250 | 525 |
| 12 | 5500 | 550 |
| 13 | 5750 | 575 |
| 14 | 6000 | 600 |
| 15 | 6250 | 625 |

**Function:** Dedicated rpm axis (raw ÷ 10) for the two detection-window edge tables; the other 16-word knock tables interpolate on [Ign_map_0_y_axis](Ign_map_0_y_axis.md) instead.

**Code path:** Read by F_00060B78 interpolation.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
