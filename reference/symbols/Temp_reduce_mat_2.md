---
tags: [saab, trionic5, symbol, torque]
type: "Calibration matrix, 8x8 bytes"
address: "ROM 0x4121A -> RAM 0x6176"
---
# Temp_reduce_mat_2

**Value in factory 4780656:** 8x8 byte grid; rows: see `source/torque_tables.txt`

**Function:** Same function, branch selected when status bit 0x103A bit2 is set.

**Code path:** F_00069FEC; output 0x46D4

Part of [T5 Torque Intervention](../../guide/torque-intervention.md) · index: [T5 Symbols](../symbol-index.md)
