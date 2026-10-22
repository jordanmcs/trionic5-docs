# Idle_fuel_korr

8-bit table 8x12 (flash)  ·  0x40DB0 -> 0x5F6A

**Value in factory 4780656:** signed rows (book idle map) — units: (v+128)/256

**Function:** idle fuel map, closed throttle

**Code path:** 0x6DE60 branch A

| | 0 | 30 | 35 | 40 | 45 | 50 | 55 | 60 | 65 | 70 | 75 | 100 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|
| [50](Idle_st_rpm.md) | 38 | 38 | 38 | 39 | 38 | 43 | 50 | 56 | 63 | 73 | 84 | 92 |
| [60](Idle_st_rpm.md) | 13 | 13 | 13 | 31 | 35 | 43 | 48 | 56 | 61 | 68 | 81 | 89 |
| [70](Idle_st_rpm.md) | 13 | 13 | 13 | 26 | 32 | 40 | 45 | 49 | 59 | 68 | 79 | 86 |
| [80](Idle_st_rpm.md) | 13 | 13 | 13 | 27 | 35 | 40 | 41 | 49 | 56 | 64 | 73 | 86 |
| [90](Idle_st_rpm.md) | 13 | 13 | 20 | 27 | 35 | 40 | 42 | 49 | 56 | 62 | 68 | 86 |
| [100](Idle_st_rpm.md) | 13 | 13 | 26 | 30 | 37 | 43 | 43 | 49 | 56 | 61 | 68 | 86 |
| [110](Idle_st_rpm.md) | 13 | 17 | 27 | 36 | 38 | 44 | 46 | 51 | 56 | 62 | 69 | 86 |
| [120](Idle_st_rpm.md) | 18 | 28 | 36 | 38 | 38 | 43 | 48 | 51 | 56 | 62 | 68 | 86 |

Raw factor bytes, (v+128)/256. Rows = rpm/10 500..1200 ([Idle_st_rpm](Idle_st_rpm.md)), columns = load kPa ([Idle_st_last](Idle_st_last.md)).

Part of [T5 Fuel Injection](../../guide/fuel-injection.md) · index: [T5 Symbols](../symbol-index.md)
