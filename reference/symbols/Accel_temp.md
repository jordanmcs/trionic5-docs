---
tags: [saab, trionic5, symbol, calibration, warmup]
type: "Calibration table, 15 B (coolant-AD-indexed)"
address: "ROM 0x409AC"
---

# Accel_temp

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | × 1/128 |
|---|---|---|---|
| 0 | 40 | 51 | 0.40 |
| 1 | 41 | 56 | 0.44 |
| 2 | 51 | 67 | 0.52 |
| 3 | 66 | 72 | 0.56 |
| 4 | 83 | 76 | 0.59 |
| 5 | 102 | 79 | 0.62 |
| 6 | 123 | 79 | 0.62 |
| 7 | 142 | 79 | 0.62 |
| 8 | 156 | 89 | 0.70 |
| 9 | 173 | 94 | 0.73 |
| 10 | 192 | 140 | 1.09 |
| 11 | 210 | 156 | 1.22 |
| 12 | 228 | 182 | 1.42 |
| 13 | 240 | 208 | 1.62 |
| 14 | 241 | 223 | 1.74 |

**Function:** Temperature-dependent acceleration-enrichment coefficient (×1/128 = 0.40…1.74).

**Code path:** 0x6D3EE (interpolation) → [Acc_temp](Acc_temp.md).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
