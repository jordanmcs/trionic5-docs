---
tags: [saab, trionic5, symbol, calibration, warmup]
type: "Calibration scalar"
address: "ROM 0x04074A"
---

# Lamb_temp

**Value in factory 4780656:**

Raw **60** (1 B) at ROM `0x04074A`.

**Function:** Coolant-temperature threshold for lambda (closed-loop) activity during warm-up; part of the cold-start lambda gating together with [Start_kylv](Start_kylv.md).

**Code path:** RAM copy consumed by the lambda control block; gate block 0x5DEE4+.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
