
# Eftersta_fak2

Calibration table, 15 B (coolant-AD-indexed)  ·  ROM 0x4087C

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | × 1/128 |
|---|---|---|---|
| 0 | 40 | 0 | 0.00 |
| 1 | 41 | 3 | 0.02 |
| 2 | 51 | 6 | 0.05 |
| 3 | 66 | 8 | 0.06 |
| 4 | 83 | 10 | 0.08 |
| 5 | 102 | 12 | 0.09 |
| 6 | 123 | 16 | 0.12 |
| 7 | 142 | 23 | 0.18 |
| 8 | 156 | 30 | 0.23 |
| 9 | 173 | 36 | 0.28 |
| 10 | 192 | 47 | 0.37 |
| 11 | 210 | 63 | 0.49 |
| 12 | 228 | 82 | 0.64 |
| 13 | 240 | 99 | 0.77 |
| 14 | 241 | 16 | 0.12 |

**Function:** Second after-start coefficient set for the alternate stage (stage byte #2).

**Code path:** 0x6F342 (interpolation) → [Eft_fak2](Eft_fak2.md).

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
