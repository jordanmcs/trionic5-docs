
# Start_kylv

State byte (RAM)  ·  (RAM)

**Value in factory 4780656:**

Coolant temperature (signed °C) latched at the start transient.

**Function:** Cold-start classification: the lambda-startup delay compares it against 10 °C, keeping the cold-start verdict stable while the engine warms.

**Code path:** Written 0x5A5B0; read 0x5DF18 (CMPI #$0A).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
