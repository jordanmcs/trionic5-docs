---
tags: [saab, trionic5, symbol, warmup]
type: "State word (RAM, per cylinder)"
address: "(RAM)"
---

# Start_tid

**Value in factory 4780656:**

Cranking injection time, scaled through Start_proc (÷128) into the injection array.

**Function:** Interp([Startvev_fak](Startvev_fak.md)) × Start_insp while cranking; replaced by the run blend as Start_count passes Start_ramp/Start_max.

**Code path:** 0x6EFAA–0x6F172.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
