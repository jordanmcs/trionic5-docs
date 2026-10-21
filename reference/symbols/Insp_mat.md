---
tags: [saab, trionic5, symbol, fuel]
type: "8-bit table 16x16 (flash)"
address: "0x40E10 -> 0x4976"
---
# Insp_mat

**Value in factory 4780656:** cells 0x0D..0xF1 — units: factor (v+128)/256, +/-50 %

**Function:** main VE correction matrix MAPxRPM on base time

**Code path:** mult 0x6DEF8/0x6E056, axes Fuel_map_*

| | 16 | 24 | 32 | 48 | 64 | 72 | 80 | 96 | 112 | 128 | 144 | 160 | 176 | 192 | 208 | 224 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| [88](Fuel_map_yaxis.md) | 17 | 20 | 25 | 40 | 57 | 62 | 67 | 72 | 78 | 86 | 102 | 102 | 102 | 103 | 103 | 103 |
| [126](Fuel_map_yaxis.md) | 17 | 21 | 36 | 52 | 62 | 66 | 69 | 76 | 79 | 81 | 99 | 100 | 102 | 102 | 102 | 103 |
| [164](Fuel_map_yaxis.md) | 18 | 25 | 37 | 54 | 67 | 73 | 75 | 82 | 87 | 88 | 89 | 101 | 102 | 103 | 103 | 103 |
| [183](Fuel_map_yaxis.md) | 18 | 20 | 35 | 57 | 71 | 75 | 76 | 83 | 90 | 91 | 91 | 93 | 102 | 102 | 103 | 103 |
| [202](Fuel_map_yaxis.md) | 17 | 19 | 32 | 51 | 65 | 72 | 75 | 82 | 86 | 86 | 89 | 90 | 93 | 106 | 129 | 129 |
| [240](Fuel_map_yaxis.md) | 27 | 27 | 39 | 60 | 73 | 80 | 84 | 90 | 94 | 97 | 107 | 108 | 99 | 105 | 118 | 127 |
| [278](Fuel_map_yaxis.md) | 13 | 16 | 30 | 52 | 68 | 73 | 77 | 83 | 86 | 99 | 105 | 109 | 107 | 108 | 125 | 129 |
| [316](Fuel_map_yaxis.md) | 31 | 29 | 46 | 65 | 80 | 83 | 86 | 91 | 96 | 100 | 102 | 107 | 114 | 135 | 150 | 151 |
| [354](Fuel_map_yaxis.md) | 26 | 26 | 41 | 69 | 83 | 89 | 93 | 99 | 107 | 109 | 120 | 130 | 137 | 154 | 166 | 166 |
| [392](Fuel_map_yaxis.md) | 21 | 21 | 34 | 64 | 81 | 85 | 92 | 99 | 107 | 112 | 114 | 126 | 140 | 148 | 162 | 166 |
| [430](Fuel_map_yaxis.md) | 21 | 17 | 30 | 60 | 78 | 84 | 92 | 103 | 109 | 114 | 116 | 141 | 144 | 193 | 192 | 166 |
| [468](Fuel_map_yaxis.md) | 22 | 16 | 29 | 61 | 76 | 88 | 94 | 102 | 111 | 118 | 132 | 151 | 168 | 191 | 191 | 193 |
| [506](Fuel_map_yaxis.md) | 21 | 23 | 43 | 68 | 89 | 96 | 104 | 115 | 119 | 122 | 143 | 174 | 185 | 184 | 192 | 191 |
| [544](Fuel_map_yaxis.md) | 29 | 31 | 49 | 76 | 100 | 106 | 111 | 120 | 126 | 142 | 179 | 213 | 215 | 214 | 179 | 179 |
| [582](Fuel_map_yaxis.md) | 45 | 31 | 49 | 76 | 103 | 110 | 116 | 126 | 139 | 167 | 188 | 230 | 238 | 238 | 166 | 167 |
| [620](Fuel_map_yaxis.md) | 42 | 43 | 51 | 83 | 104 | 113 | 118 | 127 | 141 | 169 | 190 | 232 | 240 | 241 | 192 | 192 |

Raw factor bytes, (v+128)/256 (0x80 = 1.000). Rows = rpm/10 ([Fuel_map_yaxis](Fuel_map_yaxis.md)), columns = load kPa abs ([Fuel_map_xaxis](Fuel_map_xaxis.md)) — orientation follows the shared interpolation engine convention.

Part of [T5 Fuel Injection](../../guide/fuel-injection.md) · index: [T5 Symbols](../symbol-index.md)
