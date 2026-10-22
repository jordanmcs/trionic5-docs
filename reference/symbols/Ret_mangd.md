
# Ret_mangd

State byte (per cylinder) · per cylinder

**Value in factory 4780656:** 0.1° demand

**Function:** Retard demand output of the offset engine, consumed by the ignition scheduler and applied to dwell/spark timing. "No retard pending" for K-adapt means all four are zero.

**Code path:** Queued by F_0006BFA4; read 0x6AC56, 0x6E226-0x6E286.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
