
# Accel_temp2

Calibration table, 15 B (coolant-AD-indexed) · ROM 0x409BB

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | × 1/128 |
|---|---|---|---|
| 0 | 40 | 51 | 0.40 |
| 1 | 41 | 56 | 0.44 |
| 2 | 51 | 56 | 0.44 |
| 3 | 66 | 60 | 0.47 |
| 4 | 83 | 64 | 0.50 |
| 5 | 102 | 69 | 0.54 |
| 6 | 123 | 74 | 0.58 |
| 7 | 142 | 79 | 0.62 |
| 8 | 156 | 89 | 0.70 |
| 9 | 173 | 94 | 0.73 |
| 10 | 192 | 140 | 1.09 |
| 11 | 210 | 156 | 1.22 |
| 12 | 228 | 182 | 1.42 |
| 13 | 240 | 208 | 1.62 |
| 14 | 241 | 223 | 1.74 |

**Function:** Fallback acceleration coefficient used when the coolant sensor is flagged failed (flattens the hot end vs [Accel_temp](Accel_temp.md)).

**Code path:** 0x6D404 (interpolation on sensor-fault branch) → [Acc_temp](Acc_temp.md).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
