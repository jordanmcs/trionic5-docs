
# S_Lufttemp

State byte (RAM) · (RAM)

**Value in factory 4780656:**

Intake temperature (signed °C) snapshotted at start of trip.

**Function:** Same snapshot role as [S_Kyl_temp](S_Kyl_temp.md); start plausibility compares it ±10 °C around coolant temperature.

**Code path:** Written 0x5ABE4; read 0x4A6A0/0x4A6C0, 0x5DF24 (lambda-startup gate).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
