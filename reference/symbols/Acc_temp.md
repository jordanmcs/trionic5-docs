
# Acc_temp

State byte (RAM)  ·  (RAM)

**Value in factory 4780656:**

Acceleration enrichment coefficient, ×1/128 (0.40…1.74), interpolated from [Accel_temp](Accel_temp.md) ([Accel_temp2](Accel_temp2.md) on sensor failure).

**Function:** Scales acceleration enrichment while warm.

**Code path:** Written 0x6D3F0/0x6D40E; read 0x6C1FA/0x6E990.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
