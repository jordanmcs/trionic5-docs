
# Eftersta_fak

Calibration table, 15 B (coolant-AD-indexed)  ·  ROM 0x4086D

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | × 1/128 |
|---|---|---|---|
| 0 | 40 | 13 | 0.10 |
| 1 | 41 | 17 | 0.13 |
| 2 | 51 | 24 | 0.19 |
| 3 | 66 | 31 | 0.24 |
| 4 | 83 | 36 | 0.28 |
| 5 | 102 | 41 | 0.32 |
| 6 | 123 | 46 | 0.36 |
| 7 | 142 | 52 | 0.41 |
| 8 | 156 | 57 | 0.45 |
| 9 | 173 | 63 | 0.49 |
| 10 | 192 | 70 | 0.55 |
| 11 | 210 | 82 | 0.64 |
| 12 | 228 | 101 | 0.79 |
| 13 | 240 | 114 | 0.89 |
| 14 | 241 | 46 | 0.36 |

**Function:** After-start warm-up enrichment coefficient ('efter start' = after start), ×1/128 add to base fuel while the after-start stage runs.

**Code path:** 0x6F220 (interpolation) → [Eft_fak](Eft_fak.md).

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
