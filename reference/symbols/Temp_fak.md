
# Temp_fak

State byte (RAM) · (RAM)

**Value in factory 4780656:**

Running coolant temperature fuel coefficient, ×1/128 (0…0.70), interpolated from [Tempkomp_konst](Tempkomp_konst.md) on [Temp_steg](Temp_steg.md).

**Function:** Base warm-up fuel correction while running. On coolant-sensor recovery it is walked down 1 point per [Temp_ramp_value](Temp_ramp_value.md) ticks to avoid a fuel step.

**Code path:** Written 0x69B6A/0x69BBA/0x69BFE; ramp 0x69BE2–0x69C12; read 0x6E164.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
