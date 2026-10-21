---
tags: [saab, trionic5, symbol, knock]
type: "Calibration table, 16 words × rpm"
address: "ROM 0x42BBA"
---

# Knock_wind_off_tab

**Value in factory 4780656:**

Detection-window closing, relative to the spark reference.

Axis: [Knock_wind_rpm](Knock_wind_rpm.md) (own dedicated axis, search at 0x60AF4 — not the shared rpm axis).

| # | rpm | Raw | Window close (raw × 0.1°) |
|---|---|---|---|
| 0 | 1000 | 600 | +60° after spark |
| 1 | 1500 | 600 | +60° after spark |
| 2 | 1750 | 600 | +60° after spark |
| 3 | 2000 | 650 | +65° after spark |
| 4 | 2250 | 650 | +65° after spark |
| 5 | 2500 | 650 | +65° after spark |
| 6 | 3000 | 650 | +65° after spark |
| 7 | 3500 | 700 | +70° after spark |
| 8 | 4000 | 750 | +75° after spark |
| 9 | 4500 | 750 | +75° after spark |
| 10 | 5000 | 750 | +75° after spark |
| 11 | 5250 | 750 | +75° after spark |
| 12 | 5500 | 750 | +75° after spark |
| 13 | 5750 | 750 | +75° after spark |
| 14 | 6000 | 750 | +75° after spark |
| 15 | 6250 | 750 | +75° after spark |

**Function:** Detection-window closing (60.0°–75.0° after spark) — brackets the ion/combustion phase.

**Code path:** Same path as [Knock_wind_on_tab](Knock_wind_on_tab.md).

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
