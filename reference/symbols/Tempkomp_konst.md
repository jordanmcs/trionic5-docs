---
tags: [saab, trionic5, symbol, calibration, warmup]
type: "Calibration table, 15 B (coolant-AD-indexed)"
address: "ROM 0x408AB"
---

# Tempkomp_konst

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | × 1/128 |
|---|---|---|---|
| 0 | 40 | 0 | 0.00 |
| 1 | 41 | 0 | 0.00 |
| 2 | 51 | 4 | 0.03 |
| 3 | 66 | 8 | 0.06 |
| 4 | 83 | 10 | 0.08 |
| 5 | 102 | 13 | 0.10 |
| 6 | 123 | 15 | 0.12 |
| 7 | 142 | 21 | 0.16 |
| 8 | 156 | 27 | 0.21 |
| 9 | 173 | 34 | 0.27 |
| 10 | 192 | 43 | 0.34 |
| 11 | 210 | 54 | 0.42 |
| 12 | 228 | 70 | 0.55 |
| 13 | 240 | 82 | 0.64 |
| 14 | 241 | 90 | 0.70 |

**Function:** Warm-up enrichment ramp coefficient for the running stage — NOT a knock table despite appearing in knock research.

**Code path:** Interpolated against raw [AD_kylv](AD_kylv.md) on the [Temp_steg](Temp_steg.md) axis at 0x69B58/0x69BA8; ramped by [Temp_ramp_value](Temp_ramp_value.md). → [Temp_fak](Temp_fak.md).

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
