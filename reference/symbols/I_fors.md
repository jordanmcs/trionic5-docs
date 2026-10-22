# I_fors

8-bit table (7x4, flash)  ·  ROM 0x414AE, RAM 0x5D90

**Value in factory 4780656:** 0-30 — units: dimensionless

**Function:** integral gain Ki manual

**Code path:** interp 0x72C8E -> 0x47C2

| rpm \ \|err\| | 5 | 15 | 30 | 50 |
|---|---|---|---|---|
| 200 | 0 | 0 | 0 | 0 |
| 225 | 6 | 5 | 3 | 1 |
| 250 | 6 | 15 | 6 | 2 |
| 300 | 6 | 14 | 9 | 4 |
| 400 | 10 | 15 | 10 | 6 |
| 450 | 15 | 25 | 10 | 9 |
| 550 | 15 | 30 | 10 | 10 |

Rows rpm×10 ([Reg_varv](Reg_varv.md)), columns boost-error kPa ([Reg_last](Reg_last.md)).
Part of [T5 Boost Control](../../guide/boost-control.md) · index: [T5 Symbols](../symbol-index.md)
