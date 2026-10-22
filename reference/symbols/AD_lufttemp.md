
# AD_lufttemp

State byte (RAM)  ·  (RAM)

**Value in factory 4780656:**

Raw 8-bit AD count of the intake-air NTC sensor. Failure substitute: fixed count 150 (0x96).

**Function:** Copied from AD buffer 0x4052; substituted on failure. Feeds the intake °C conversion via [Lufttemp_steg](Lufttemp_steg.md).

**Code path:** 0x69FE0 (copy), 0x69FCA (substitute).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
