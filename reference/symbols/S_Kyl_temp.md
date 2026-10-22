
# S_Kyl_temp

State byte (RAM)  ·  (RAM)

**Value in factory 4780656:**

Coolant temperature (signed °C) snapshotted at start of trip.

**Function:** Secondary-air and lambda-startup gates read the start-time snapshot instead of the live value so decisions use ambient start conditions.

**Code path:** Written 0x5ABDA; read 0x4A6B0/0x4A6D0 (air-pump temperature gates).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
