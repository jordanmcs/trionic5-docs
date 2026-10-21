---
tags: [saab, trionic5, symbol, warmup]
type: "State byte (RAM)"
address: "(RAM)"
---

# AD_kylv

**Value in factory 4780656:**

Raw 8-bit AD count of the coolant NTC sensor. Failure substitute: fixed count 110 (0x6E) ≈ 66 °C.

**Function:** Copied from AD buffer 0x4054 each measurement cycle; substituted on AD-converter failure. Consumed raw on the [Temp_steg](Temp_steg.md) axis by every warm-up table interpolation, since all coolant-indexed tables are calibrated against AD, not °C.

**Code path:** 0x69FB2 (copy), 0x69F9C (failure substitute), 0x69B50/0x6EF86/0x6F220 (table interpolations).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
