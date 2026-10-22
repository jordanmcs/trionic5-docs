# Lean_step_map

8-bit table 16x4 (flash)  ·  0x40BB8 -> 0x6A40

**Value in factory 4780656:** 4..15 — units: steps per lambda event

**Function:** lambda integrator step-down rates by rpm/load cell

**Code path:** 0x6A884

| rpm row | 0 | 1 | 2 | 3 |
|---|---|---|---|---|
| 0 | 7 | 7 | 8 | 9 |
| 1 | 10 | 13 | 15 | 15 |
| 2 | 8 | 9 | 8 | 9 |
| 3 | 10 | 12 | 12 | 4 |
| 4 | 4 | 9 | 7 | 8 |
| 5 | 9 | 8 | 7 | 5 |
| 6 | 5 | 7 | 10 | 9 |
| 7 | 9 | 8 | 8 | 8 |
| 8 | 9 | 12 | 10 | 12 |
| 9 | 10 | 9 | 9 | 9 |
| 10 | 6 | 7 | 9 | 10 |
| 11 | 8 | 6 | 8 | 7 |
| 12 | 9 | 9 | 8 | 6 |
| 13 | 7 | 6 | 6 | 6 |
| 14 | 9 | 9 | 9 | 7 |
| 15 | 5 | 4 | 6 | 5 |

Steps per lambda switch; rows rpm row (`Lam_rpmsteg` axes as used by F_0006A884), columns load slot.
Part of [T5 Fuel Injection](../../guide/fuel-injection.md) · index: [T5 Symbols](../symbol-index.md)
