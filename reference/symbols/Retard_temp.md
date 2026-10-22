
# Retard_temp

Calibration table, 15 B (coolant-AD-indexed) · ROM 0x40B14

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | × 1/128 |
|---|---|---|---|
| 0 | 40 | 179 | 1.40 |
| 1 | 41 | 181 | 1.41 |
| 2 | 51 | 202 | 1.58 |
| 3 | 66 | 224 | 1.75 |
| 4 | 83 | 238 | 1.86 |
| 5 | 102 | 249 | 1.95 |
| 6 | 123 | 255 | 1.99 |
| 7 | 142 | 255 | 1.99 |
| 8 | 156 | 255 | 1.99 |
| 9 | 173 | 255 | 1.99 |
| 10 | 192 | 255 | 1.99 |
| 11 | 210 | 255 | 1.99 |
| 12 | 228 | 128 | 1.00 |
| 13 | 240 | 128 | 1.00 |
| 14 | 241 | 255 | 1.99 |

Note the raw-128 (1.00) pair at points 12–13 and 255 at point 14 — an axis-wrap artifact.

**Function:** Warm-up ignition retard multiplier ('retard temperature'): 1.40× hot rising to 2.00× cold, applied in the ignition-time computation. NOT a knock table (flagged in knock research).

**Code path:** 0x6D41E (interpolation) → [Ret_temp](Ret_temp.md); applied 0x6C2DC/0x6EC0C.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
