
# Lufttemp_steg

Calibration table, 16 B (AD axis) · ROM 0x40B6E

**Value in factory 4780656:**

AD breakpoints: 11, 15, 19, 26, 34, 45, 58, 74, 96, 124, 150, 174, 201, 220, 234, 255.

**Function:** Axis of the intake-air-sensor AD → °C conversion; same NTC AD spacing family as [Kyltemp_steg](Kyltemp_steg.md). Its °C companion table was not dumped (see open items).

**Code path:** Interpolated for `Luft_temp`; consumed near the air-correction path.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
