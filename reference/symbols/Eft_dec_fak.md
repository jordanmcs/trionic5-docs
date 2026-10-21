---
tags: [saab, trionic5, symbol, calibration, warmup]
type: "Calibration table, 15 B (coolant-AD-indexed)"
address: "ROM 0x4088B"
---

# Eft_dec_fak

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | × 1/128 |
|---|---|---|---|
| 0 | 40 | 100 | 0.78 |
| 1 | 41 | 100 | 0.78 |
| 2 | 51 | 46 | 0.36 |
| 3 | 66 | 40 | 0.31 |
| 4 | 83 | 40 | 0.31 |
| 5 | 102 | 40 | 0.31 |
| 6 | 123 | 38 | 0.30 |
| 7 | 142 | 35 | 0.27 |
| 8 | 156 | 33 | 0.26 |
| 9 | 173 | 31 | 0.24 |
| 10 | 192 | 30 | 0.23 |
| 11 | 210 | 31 | 0.24 |
| 12 | 228 | 32 | 0.25 |
| 13 | 240 | 32 | 0.25 |
| 14 | 241 | 38 | 0.30 |

**Function:** After-start enrichment decay rate. While the loaded [Eft_dec](Eft_dec.md) counter is active, [Eft_fak](Eft_fak.md) loses one point per decay tick — larger table value = faster walk-down.

**Code path:** 0x6F284 (interpolation), 0x6F298 (−1), gate 0x6F2DC.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
