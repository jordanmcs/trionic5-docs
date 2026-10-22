
# I_luft_st

Calibration table, 8 B (°C axis) · ROM 0x4115A

**Value in factory 4780656:**

Signed °C breakpoints: 65, 55, 45, 35, 25, 15, 10, −40 (raw 216).

**Function:** Intake-air-temperature axis for the air-density fuel correction table (adjacent ROM 0x41132, 8 words 25, 20, 20, 20, 20, 15, 0, 0; direction/scaling inference).

**Code path:** Indexed at 0x6F9A2 (byte read at axis index).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
