
# Build_up_time_switch

Calibration scalar · ROM 0x040536

**Value in factory 4780656:**

Raw **246** (1 B) at ROM `0x040536`.

**Function:** Coolant-temperature threshold separating [Build_up_time](Build_up_time.md) from [Build_up_time_2](Build_up_time_2.md): −10 °C and colder get the 60-tick window.

**Code path:** Compared against [Kyl_temp](Kyl_temp.md) at 0x6EF28.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
