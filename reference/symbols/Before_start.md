
# Before_start

Calibration table, 15 B (coolant-AD-indexed) · ROM 0x40F14

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | raw |
|---|---|---|---|
| 0 | 40 | 9 | 9 |
| 1 | 41 | 9 | 9 |
| 2 | 51 | 13 | 13 |
| 3 | 66 | 31 | 31 |
| 4 | 83 | 42 | 42 |
| 5 | 102 | 58 | 58 |
| 6 | 123 | 72 | 72 |
| 7 | 142 | 85 | 85 |
| 8 | 156 | 96 | 96 |
| 9 | 173 | 105 | 105 |
| 10 | 192 | 116 | 116 |
| 11 | 210 | 126 | 126 |
| 12 | 228 | 146 | 146 |
| 13 | 240 | 151 | 151 |
| 14 | 241 | 72 | 72 |

**Function:** Before-start (priming) enrichment/time table, 9…151 raw units across the AD axis; feeds the pre-cranking stage.

**Code path:** 0x6EF04 (interpolation on AD).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
