---
tags: [saab, trionic5, symbol, warmup]
type: "Calibration table, 8 B (°C axis)"
address: "ROM 0x4112A"
---

# I_kyl_st

**Value in factory 4780656:**

Signed °C breakpoints (descending): 65, 50, 35, 20, 5, −5 (raw 251), −20 (raw 236), −40 (raw 216).

This is one of the few coolant-indexed tables calibrated in **°C** (via [Kyl_temp](Kyl_temp.md)) instead of raw AD — note the different indexing convention from the [Temp_steg](Temp_steg.md) family.

**Function:** Axis of [Idle_rpm_tab](Idle_rpm_tab.md) (and adjacent idle/air tables).

**Code path:** 0x6F60A (band search), 0x6F644 (interpolation).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
