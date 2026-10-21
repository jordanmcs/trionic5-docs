---
tags: [saab, trionic5, symbol, warmup]
type: "State byte (RAM)"
address: "(RAM)"
---

# Restart_status

**Value in factory 4780656:**

Restart (stall-while-running) state bits: 0x04 set at restart, 0x10 armed, 0x20 skip-enrichment, 0x80 restart seen.

**Function:** Above [BS_temp](BS_temp.md) coolant the enrichment path is skipped on restart; status drives the restart blend and injection-array flush.

**Code path:** 0x6EE48–0x6EED4; Restart_fak applied 0x6F23A/0x6F2C8.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
