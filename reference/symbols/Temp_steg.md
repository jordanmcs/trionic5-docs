
# Temp_steg

Calibration axis, 15 bytes (raw AD counts)  ·  ROM 0x40B24 (RAM [Temp_steg](Temp_steg.md))

**Value in factory 4780656:** 15 raw coolant-AD points 40…241 (low AD = warm).

Coolant-sensor AD interpolation axis for the warm-up/fuel table family ([Startvev_fak](Startvev_fak.md), `Eftersta_fak(2)`, `Eft_dec_fak(2)`, [Tempkomp_konst](Tempkomp_konst.md)) — copied at 0x52A30 (15 bytes), used at 0x69B58/0x69BA8/0x6D41E. Raw `AD_kylv` values are located between these points; low AD = warm (NTC). Not knock.

| # | AD axis point |
|---|---|
| 0 | 40 |
| 1 | 41 |
| 2 | 51 |
| 3 | 66 |
| 4 | 83 |
| 5 | 102 |
| 6 | 123 |
| 7 | 142 |
| 8 | 156 |
| 9 | 173 |
| 10 | 192 |
| 11 | 210 |
| 12 | 228 |
| 13 | 240 |
| 14 | 241 |

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
