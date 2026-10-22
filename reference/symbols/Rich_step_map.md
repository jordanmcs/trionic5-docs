# Rich_step_map

8-bit table 16x4 (flash)  ·  0x40BF8 -> 0x6A80

**Value in factory 4780656:** 6..25 — units: steps per lambda event

**Function:** lambda integrator step-up rates

**Code path:** 0x6A884

| rpm row | 0 | 1 | 2 | 3 |
|---|---|---|---|---|
| 0 | 10 | 10 | 10 | 9 |
| 1 | 7 | 7 | 12 | 12 |
| 2 | 16 | 11 | 9 | 10 |
| 3 | 8 | 7 | 10 | 25 |
| 4 | 16 | 13 | 11 | 10 |
| 5 | 9 | 10 | 9 | 20 |
| 6 | 13 | 11 | 9 | 8 |
| 7 | 8 | 10 | 9 | 9 |
| 8 | 10 | 9 | 7 | 9 |
| 9 | 8 | 8 | 9 | 7 |
| 10 | 12 | 11 | 9 | 10 |
| 11 | 9 | 8 | 7 | 6 |
| 12 | 12 | 12 | 10 | 10 |
| 13 | 10 | 10 | 11 | 6 |
| 14 | 11 | 11 | 11 | 10 |
| 15 | 9 | 10 | 11 | 6 |

Steps per lambda switch; rows rpm row (`Lam_rpmsteg` axes as used by F_0006A884), columns load slot.
Part of [T5 Fuel Injection](../../guide/fuel-injection.md) · index: [T5 Symbols](../symbol-index.md)
