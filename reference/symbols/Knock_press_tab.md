---
tags: [saab, trionic5, symbol, knock]
type: "Calibration table, 16 words × rpm"
address: "ROM 0x42B1A"
---

# Knock_press_tab

**Value in factory 4780656:**

Minimum manifold-pressure gate: knock evaluation skipped below the interpolated value (RAM copy [Knock_press_limit](Knock_press_limit.md)).

Axis: [Ign_map_0_y_axis](Ign_map_0_y_axis.md) (code-proven interpolation index, 0x61966–0x61B88).

| # | rpm | Raw | Gate (raw MAP count ≈ kPa abs) |
|---|---|---|---|
| 0 | 500 | 70 | 70 |
| 1 | 880 | 70 | 70 |
| 2 | 1260 | 70 | 70 |
| 3 | 1640 | 70 | 70 |
| 4 | 2020 | 70 | 70 |
| 5 | 2400 | 70 | 70 |
| 6 | 2780 | 70 | 70 |
| 7 | 3160 | 65 | 65 |
| 8 | 3540 | 60 | 60 |
| 9 | 3920 | 60 | 60 |
| 10 | 4300 | 60 | 60 |
| 11 | 4680 | 60 | 60 |
| 12 | 5060 | 60 | 60 |
| 13 | 5440 | 60 | 60 |
| 14 | 5820 | 60 | 60 |
| 15 | 6200 | 60 | 60 |

Gate values are raw MAP counts ≈ kPa absolute: 60–70 kPa abs ≈ 0.3–0.4 bar below atmospheric — evaluation enables only once the manifold is near/above that (part-throttle and up), per the default 2.5-bar sensor scaling.

**Function:** Base table for the minimum manifold-pressure gate: knock evaluation only above the interpolated value.

**Code path:** Interpolated to [Knock_press_limit](Knock_press_limit.md); compared at 0x60EA8.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
