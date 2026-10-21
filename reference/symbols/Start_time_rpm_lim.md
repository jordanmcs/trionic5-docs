---
tags: [saab, trionic5, symbol, calibration, warmup]
type: "Calibration scalar"
address: "ROM 0x042E6A"
---

# Start_time_rpm_lim

**Value in factory 4780656:**

Raw **650** (2 B) at ROM `0x042E6A`.

**Function:** Below 650 rpm the engine counts as cranking: [Start_time](Start_time.md) accumulates and cranking fuel logic stays active.

**Code path:** 0x6D00C.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
