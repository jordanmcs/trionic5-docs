
# Start_dead_tab

Calibration table, 15 B (coolant-AD-indexed) · ROM 0x40702

**Value in factory 4780656:**

All zeros at every [Temp_steg](Temp_steg.md) point.

**Function:** Cranking dead-pulse table — the feature is disabled by calibration.

**Code path:** 0x6F0D6 (interpolation) → [Start_dead](Start_dead.md).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
