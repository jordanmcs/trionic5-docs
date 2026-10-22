
# Kyl_temp

State byte (RAM) · (derived from AD_kylv)

**Value in factory 4780656:** signed °C

**Function:** Coolant temperature used by the knock gates: detection enabled above 40 °C (0x60EB2, force-enabled if sensor diag bit 0x80), K-adapt learning above 60 °C (0x61134).

**Code path:** Read by knock evaluation and adaptation gates.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
