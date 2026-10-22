
# Eft_dec_fak2

Calibration table, 15 B (coolant-AD-indexed) · ROM 0x4089A

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | × 1/128 |
|---|---|---|---|
| 0 | 40 | 2 | 0.02 |
| 1 | 41 | 2 | 0.02 |
| 2 | 51 | 2 | 0.02 |
| 3 | 66 | 2 | 0.02 |
| 4 | 83 | 3 | 0.02 |
| 5 | 102 | 4 | 0.03 |
| 6 | 123 | 6 | 0.05 |
| 7 | 142 | 8 | 0.06 |
| 8 | 156 | 8 | 0.06 |
| 9 | 173 | 8 | 0.06 |
| 10 | 192 | 8 | 0.06 |
| 11 | 210 | 9 | 0.07 |
| 12 | 228 | 10 | 0.08 |
| 13 | 240 | 10 | 0.08 |
| 14 | 241 | 6 | 0.05 |

**Function:** Decay rate for the second coefficient set ([Eft_fak2](Eft_fak2.md)).

**Code path:** Second decay path (Function_0006F314 region).

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
