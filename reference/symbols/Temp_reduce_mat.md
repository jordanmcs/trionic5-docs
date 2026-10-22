# Temp_reduce_mat

Calibration matrix, 8x8 bytes · ROM 0x411DA -> RAM 0x6136

**Value in factory 4780656:** 8x8 byte grid; rows: see `source/torque_tables.txt`

**Function:** Reduces the fuel temperature compensation during interventions; branch selected when status bit 0x103A bit2 is clear. 0xFF cells clamp (no reduction).

**Code path:** F_00069FEC (axes Temp_reduce_x_st / Temp_reduce_y_st); output 0x46D4 consumed by fuel task 0x6E11E

Part of [T5 Torque Intervention](../../guide/torque-intervention.md) · index: [T5 Symbols](../symbol-index.md)
