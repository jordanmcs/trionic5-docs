
# BS_temp

Calibration scalar · ROM 0x040F23

**Value in factory 4780656:**

Raw **60** (1 B) at ROM `0x040F23`.

**Function:** Hot-restart threshold: a restart with coolant above 60 °C skips the restart enrichment — warm restarts are fueled like normal running.

**Code path:** 0x6EE5C (compare against [Kyl_temp](Kyl_temp.md)); second use near the [Eft_dec](Eft_dec.md) gate 0x6F2D8.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
