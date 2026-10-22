# Ign_map_2

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

Calibration word (flash) · ROM 0x41B08

**Value in factory 4780656:** 0..90 (16x8) — units: 0.1 crank degree (retard)

**Function:** knock retard overlay above ~atmospheric load (book: MAP>140 kPa regime)

**Code path:** F_00062102 0x62684/0x626BE -> 0x3988; Knock_map_offset 0x10BA; cap 0x10B8 for knock engine

| | 128 | 144 | 160 | 176 | 192 | 208 | 224 | 240 |
|---|---|---|---|---|---|---|---|---|
| [500](Ign_map_2_y_axis.md) | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| [880](Ign_map_2_y_axis.md) | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| [1260](Ign_map_2_y_axis.md) | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 10 |
| [1640](Ign_map_2_y_axis.md) | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| [2020](Ign_map_2_y_axis.md) | 0 | 40 | 0 | 10 | 0 | 10 | 0 | 10 |
| [2400](Ign_map_2_y_axis.md) | 0 | 10 | 0 | 0 | 0 | 0 | 0 | 0 |
| [2780](Ign_map_2_y_axis.md) | 0 | 70 | 0 | 60 | 0 | 30 | 0 | 10 |
| [3160](Ign_map_2_y_axis.md) | 0 | 10 | 0 | 0 | 0 | 0 | 0 | 0 |
| [3540](Ign_map_2_y_axis.md) | 0 | 60 | 0 | 80 | 0 | 85 | 0 | 40 |
| [3920](Ign_map_2_y_axis.md) | 0 | 30 | 0 | 20 | 0 | 0 | 0 | 0 |
| [4300](Ign_map_2_y_axis.md) | 0 | 60 | 0 | 90 | 0 | 85 | 0 | 60 |
| [4680](Ign_map_2_y_axis.md) | 0 | 20 | 0 | 20 | 0 | 0 | 0 | 0 |
| [5060](Ign_map_2_y_axis.md) | 0 | 70 | 0 | 85 | 0 | 85 | 0 | 70 |
| [5440](Ign_map_2_y_axis.md) | 0 | 35 | 0 | 30 | 0 | 10 | 0 | 0 |
| [5820](Ign_map_2_y_axis.md) | 0 | 45 | 0 | 80 | 0 | 70 | 0 | 50 |
| [6200](Ign_map_2_y_axis.md) | 0 | 25 | 0 | 20 | 0 | 10 | 0 | 10 |

Raw words, 0.1 crank degrees of retard overlay. Rows rpm ([Ign_map_2_y_axis](Ign_map_2_y_axis.md)), columns high-load MAP ([Ign_map_2_x_axis](Ign_map_2_x_axis.md)).

Part of [T5 Ignition Timing](../../guide/ignition-timing.md) · index: [T5 Symbols](../symbol-index.md)
