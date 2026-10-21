---
tags: [saab, trionic5, symbol, calibration, warmup]
type: "Calibration scalar"
address: "ROM 0x040BAC"
---

# Start_insp

**Value in factory 4780656:**

Raw **2250** (2 B) at ROM `0x040BAC`.

**Function:** Base cranking injection count multiplied with the interpolated [Startvev_fak](Startvev_fak.md) (0x6EFAC). Scaling inference: timer counts.

**Code path:** 0x6EFAC/0x6F068 (MULU).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
