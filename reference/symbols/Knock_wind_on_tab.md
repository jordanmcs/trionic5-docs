---
tags: [saab, trionic5, symbol, knock]
type: "Calibration table, 16 words × rpm"
address: "ROM 0x42B9A"
---

# Knock_wind_on_tab

**Value in factory 4780656:**

Detection-window opening, relative to the spark reference.

Axis: [Knock_wind_rpm](Knock_wind_rpm.md) (own dedicated axis, search at 0x60AF4 — not the shared rpm axis).

| # | rpm | Raw | Window open (raw × 0.1°) |
|---|---|---|---|
| 0 | 1000 | 300 | −30° before spark |
| 1 | 1500 | 300 | −30° before spark |
| 2 | 1750 | 300 | −30° before spark |
| 3 | 2000 | 350 | −35° before spark |
| 4 | 2250 | 350 | −35° before spark |
| 5 | 2500 | 350 | −35° before spark |
| 6 | 3000 | 350 | −35° before spark |
| 7 | 3500 | 400 | −40° before spark |
| 8 | 4000 | 450 | −45° before spark |
| 9 | 4500 | 450 | −45° before spark |
| 10 | 5000 | 450 | −45° before spark |
| 11 | 5250 | 450 | −45° before spark |
| 12 | 5500 | 450 | −45° before spark |
| 13 | 5750 | 450 | −45° before spark |
| 14 | 6000 | 450 | −45° before spark |
| 15 | 6250 | 450 | −45° before spark |

**Function:** Detection-window opening, in 0.1° after the spark reference (30.0°–45.0° advanced by rpm).

**Code path:** Interpolated (F_00060B78), converted to ticks and written to TPU PWM regs 0xFFFF28/2A by F_00043B74.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
