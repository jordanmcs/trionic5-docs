---
tags: [saab, trionic5, symbol, idle]
type: "Calibration table, 54 words"
address: "ROM 0x40FFC -> RAM 0x61FC"
---
# Iv_min_tab

**Value in factory 4780656:** 108 bytes — full hex in `source/idle_tables.txt`

**Function:** Idle-valve base position table indexed by raw rpm/125. Book: 'Idle valve min table'. Base of Iv_position.

**Code path:** F_000709D4 at 0x70A44 (word table, offset 0x61FC)

Part of [T5 Idle Air Control](../../guide/idle-air-control.md) · index: [T5 Symbols](../symbol-index.md)
