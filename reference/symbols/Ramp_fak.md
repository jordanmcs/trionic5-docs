
# Ramp_fak

Calibration table, 15 B (coolant-AD-indexed) · ROM 0x4063F

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | × 1/128 |
|---|---|---|---|
| 0 | 40 | 128 | 1.00 |
| 1 | 41 | 128 | 1.00 |
| 2 | 51 | 128 | 1.00 |
| 3 | 66 | 128 | 1.00 |
| 4 | 83 | 128 | 1.00 |
| 5 | 102 | 128 | 1.00 |
| 6 | 123 | 127 | 0.99 |
| 7 | 142 | 125 | 0.98 |
| 8 | 156 | 125 | 0.98 |
| 9 | 173 | 125 | 0.98 |
| 10 | 192 | 124 | 0.97 |
| 11 | 210 | 124 | 0.97 |
| 12 | 228 | 124 | 0.97 |
| 13 | 240 | 124 | 0.97 |
| 14 | 241 | 127 | 0.99 |

**Function:** Cranking→run blend factor, ≈1.00 (raw 124–128) across the whole temperature range — effectively a constant full blend, kept as a table for tuning.

**Code path:** 0x6F19E (interpolation during post-catch ramp).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
