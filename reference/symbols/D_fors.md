# D_fors

8-bit table (7x4, flash)  ·  ROM 0x414CA, RAM 0x5DAC

**Value in factory 4780656:** 0-255 — units: dimensionless

**Function:** derivative gain Kd manual

**Code path:** interp 0x72CC2 -> 0x47C0

| rpm \ \|err\| | 5 | 15 | 30 | 50 |
|---|---|---|---|---|
| 200 | 0 | 0 | 0 | 0 |
| 225 | 0 | 0 | 0 | 0 |
| 250 | 0 | 0 | 0 | 0 |
| 300 | 0 | 150 | 100 | 0 |
| 400 | 0 | 150 | 150 | 90 |
| 450 | 0 | 50 | 100 | 255 |
| 550 | 0 | 150 | 150 | 90 |

Rows rpm×10 ([Reg_varv](Reg_varv.md)), columns boost-error kPa ([Reg_last](Reg_last.md)).
Part of [T5 Boost Control](../../guide/boost-control.md) · index: [T5 Symbols](../symbol-index.md)
