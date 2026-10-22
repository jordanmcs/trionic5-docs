
# Startvev_fak

Calibration table, 15 B (coolant-AD-indexed) · ROM 0x4085E

**Value in factory 4780656:**

| # | AD ([Temp_steg](Temp_steg.md)) | Raw | × 1/128 |
|---|---|---|---|
| 0 | 40 | 8 | 0.06 |
| 1 | 41 | 8 | 0.06 |
| 2 | 51 | 9 | 0.07 |
| 3 | 66 | 10 | 0.08 |
| 4 | 83 | 12 | 0.09 |
| 5 | 102 | 15 | 0.12 |
| 6 | 123 | 21 | 0.16 |
| 7 | 142 | 24 | 0.19 |
| 8 | 156 | 29 | 0.23 |
| 9 | 173 | 33 | 0.26 |
| 10 | 192 | 40 | 0.31 |
| 11 | 210 | 61 | 0.48 |
| 12 | 228 | 101 | 0.79 |
| 13 | 240 | 138 | 1.08 |
| 14 | 241 | 21 | 0.16 |

(×0.06 at the hot end to ×1.08 at the cold end; last slot is the AD-wrap duplicate.)

**Function:** Cranking enrichment factor ('start vev' = crank start): cranking injection time = Interp(Startvev_fak) × Start_insp, scaled through Start_proc.

**Code path:** 0x6EF9A/0x6F052 (interpolation), 0x6EFAA (multiply).

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
