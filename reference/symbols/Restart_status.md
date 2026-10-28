# Restart_status

State byte (RAM) · 0x1983 (1 byte; ROM default block source 0x12F3C)

**Value in factory 4780656:** runtime — units: bits

**Function:** restart (stall-while-running) state bits: 0x04 restart detected, 0x10 armed, 0x20 skip-enrichment (set above [BS_temp](BS_temp.md) = 60 °C coolant — warm hot-restart gets no after-start enrichment), 0x80 restart seen. Drives the restart fuel blend and the injection-array flush.

**Code path:** 0x6EE48–0x6EED4; Restart_fak applied 0x6F23A/0x6F2C8; constant load `#$EF` at 0x4EC2A.

> Address note: older pages said `0x1050` — that is `Start_dead` (symbol-table off-by-one; corrected 2026-10-27: fixed CSV row `Restart_status,0x12F3C,0x1983,1` + asm operands).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
