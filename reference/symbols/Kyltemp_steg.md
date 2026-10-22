
# Kyltemp_steg

Calibration table, 19 B (AD axis) · ROM 0x40B45

**Value in factory 4780656:**

AD breakpoints (8-bit coolant-sensor AD counts), ascending:

| AD | 8 | 9 | 11 | 15 | 19 | 26 | 34 | 45 | 58 | 74 | 96 | 124 | 150 | 174 | 201 | 220 | 234 | 243 | 255 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| °C ([Kyltemp_tab](Kyltemp_tab.md)) | 167 | 166 | 160 | 147 | 137 | 125 | 114 | 104 | 94 | 84 | 72 | 59 | 49 | 40 | 29 | 18 | 8 | 0 | 0 |

**Function:** Axis of the coolant-sensor AD → °C conversion. NTC sensor: low AD = hot, high AD = cold. Values below 8 (sensor short) or above 243 (open) pin the conversion at the rails and feed the sensor-plausibility checks.

**Code path:** Interpolated by Function_0006A4E4 with [Kyltemp_tab](Kyltemp_tab.md); conversion call site 0x6C520 / 0x6D366.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
