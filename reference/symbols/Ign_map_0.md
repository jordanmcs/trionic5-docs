# Ign_map_0

Calibration word (flash) · ROM 0x4186A

**Value in factory 4780656:** factory 0..360 (rows shown in ignition_tables.txt) — units: 0.1 crank degree (BTDC)

**Function:** warm-engine base ignition advance vs rpm x load

**Code path:** interpolated in CalculateIgnitionAngle F_00062102 0x62126, blend weight 0x3994

| | 0 | 16 | 24 | 32 | 40 | 48 | 64 | 80 | 96 | 112 | 128 | 144 | 160 | 176 | 192 | 208 | 224 | 240 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| [500](Ign_map_0_y_axis.md) | 0 | 0 | 0 | 80 | 0 | 80 | 0 | 80 | 0 | 80 | 0 | 80 | 0 | 80 | 0 | 80 | 0 | 60 |
| [880](Ign_map_0_y_axis.md) | 0 | 40 | 0 | 20 | 0 | 20 | 0 | 10 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| [1260](Ign_map_0_y_axis.md) | 0 | 100 | 0 | 100 | 0 | 100 | 0 | 100 | 0 | 100 | 0 | 100 | 0 | 100 | 0 | 100 | 0 | 58 |
| [1640](Ign_map_0_y_axis.md) | 0 | 40 | 0 | 30 | 0 | 30 | 0 | 20 | 0 | 10 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| [2020](Ign_map_0_y_axis.md) | 0 | 150 | 0 | 150 | 0 | 150 | 0 | 150 | 0 | 150 | 0 | 150 | 0 | 150 | 0 | 150 | 0 | 120 |
| [2400](Ign_map_0_y_axis.md) | 0 | 120 | 0 | 70 | 0 | 40 | 0 | 30 | 0 | 10 | 0 | 10 | 0 | 0 | 0 | 0 | 0 | 0 |
| [2780](Ign_map_0_y_axis.md) | 0 | 200 | 0 | 200 | 0 | 250 | 0 | 250 | 0 | 250 | 0 | 250 | 0 | 250 | 0 | 230 | 0 | 180 |
| [3160](Ign_map_0_y_axis.md) | 0 | 150 | 0 | 110 | 0 | 80 | 0 | 50 | 0 | 10 | 0 | 10 | 0 | 0 | 0 | 0 | 0 | 0 |
| [3540](Ign_map_0_y_axis.md) | 0 | 200 | 0 | 200 | 0 | 250 | 1 | 44 | 1 | 69 | 1 | 44 | 0 | 250 | 0 | 230 | 0 | 210 |
| [3920](Ign_map_0_y_axis.md) | 0 | 170 | 0 | 140 | 0 | 95 | 0 | 90 | 0 | 40 | 0 | 30 | 0 | 20 | 0 | 0 | 0 | 0 |
| [4300](Ign_map_0_y_axis.md) | 0 | 200 | 0 | 200 | 0 | 250 | 1 | 44 | 1 | 69 | 1 | 34 | 1 | 14 | 0 | 250 | 0 | 210 |
| [4680](Ign_map_0_y_axis.md) | 0 | 170 | 0 | 140 | 0 | 120 | 0 | 100 | 0 | 60 | 0 | 30 | 0 | 20 | 0 | 0 | 0 | 0 |
| [5060](Ign_map_0_y_axis.md) | 0 | 200 | 0 | 200 | 0 | 250 | 1 | 44 | 1 | 94 | 1 | 54 | 1 | 4 | 0 | 240 | 0 | 220 |
| [5440](Ign_map_0_y_axis.md) | 0 | 220 | 0 | 210 | 0 | 140 | 0 | 130 | 0 | 100 | 0 | 70 | 0 | 50 | 0 | 10 | 0 | 0 |
| [5820](Ign_map_0_y_axis.md) | 0 | 200 | 0 | 200 | 0 | 250 | 1 | 44 | 1 | 104 | 1 | 94 | 1 | 44 | 1 | 4 | 0 | 240 |
| [6200](Ign_map_0_y_axis.md) | 0 | 240 | 0 | 220 | 0 | 180 | 0 | 160 | 0 | 130 | 0 | 90 | 0 | 60 | 0 | 30 | 0 | 20 |

Raw words, 0.1 crank degrees (0..36.0). Rows = rpm ([Ign_map_0_y_axis](Ign_map_0_y_axis.md)), columns = MAP load counts ([Ign_map_0_x_axis](Ign_map_0_x_axis.md), kPa absolute).

Part of [T5 Ignition Timing](../../guide/ignition-timing.md) · index: [T5 Symbols](../symbol-index.md)
