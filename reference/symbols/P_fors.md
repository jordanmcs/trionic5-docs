# P_fors

8-bit table (7x4 bytes, flash) · ROM 0x41492, RAM 0x5D74

**Value in factory 4780656:** rows 255/120/0-110 — units: dimensionless (x/10 in P_fak)

**Function:** proportional gain Kp manual

**Code path:** interp 0x72C5A -> 0x47C4

| rpm \ \|err\| | 5 | 15 | 30 | 50 |
|---|---|---|---|---|
| 200 | 255 | 255 | 255 | 255 |
| 225 | 120 | 120 | 120 | 120 |
| 250 | 0 | 40 | 80 | 110 |
| 300 | 0 | 40 | 80 | 110 |
| 400 | 0 | 40 | 80 | 80 |
| 450 | 0 | 10 | 80 | 80 |
| 550 | 0 | 15 | 80 | 40 |

Rows rpm×10 ([Reg_varv](Reg_varv.md)), columns boost-error kPa ([Reg_last](Reg_last.md)).
Part of [T5 Boost Control](../../guide/boost-control.md) · index: [T5 Symbols](../symbol-index.md)
