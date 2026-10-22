# Max_regl_temp_2

16-bit tables (16 words each, flash)  ·  ROM 0x41566/0x41586, RAM 0x5EE2/0x5F02

**Value in factory 4780656:** 145-180 / 135-170 — units: kPa absolute

**Function:** max charge pressure at warm / cold interp point (automatics only)

**Code path:** 0x72878->0x47EE / 0x72898->0x47F0, F_0006A314 on Lufttemp

| rpm×10 | 650 | 600 | 575 | 550 | 500 | 450 | 400 | 350 | 325 | 300 | 275 | 250 | 225 | 200 | 175 | 150 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| kPa ABS | 135 | 140 | 150 | 148 | 148 | 144 | 143 | 146 | 147 | 150 | 151 | 152 | 153 | 160 | 170 | 170 |

cold curve; axis = descending rpm ([Max_regl_sp](Max_regl_sp.md)).
Part of [T5 Boost Control](../../guide/boost-control.md) · index: [T5 Symbols](../symbol-index.md)
