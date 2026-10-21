---
tags: [saab, trionic5, symbol, calibration, warmup]
type: "Calibration scalar"
address: "ROM 0x0408BA"
---

# Temp_ramp_value

**Value in factory 4780656:**

Raw **20** (2 B) at ROM `0x0408BA`.

**Function:** Tick count between single-point steps of the [Temp_fak](Temp_fak.md) recovery ramp after a coolant-sensor fault clears — anti-fuel-step glide back.

**Code path:** 0x69BEE (ramp compare).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
