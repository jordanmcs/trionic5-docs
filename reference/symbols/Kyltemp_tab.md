
# Kyltemp_tab

Calibration table, 19 B (°C values)  ·  ROM 0x40B58

**Value in factory 4780656:**

°C values matching the [Kyltemp_steg](Kyltemp_steg.md) AD breakpoints: 167, 166, 160, 147, 137, 125, 114, 104, 94, 84, 72, 59, 49, 40, 29, 18, 8, 0, 0.

**Function:** Coolant AD → °C lookup. The 0 °C entries at AD ≥ 243 (open circuit) and the 167 °C entry at AD ≤ 8 (short) double as out-of-range markers. Operating band ≈ AD 60–230 for 100 °C down to ≈ 12 °C.

**Code path:** Linear interpolation between points (Function_0006A4E4); produces [Kyl_temp](Kyl_temp.md).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
