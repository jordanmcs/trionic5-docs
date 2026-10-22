# Ign_angle

State word (RAM 0x10B4) · RAM 0x10B4

**Value in factory 4780656:** runtime — units: 0.1 crank degree BTDC (signed)

**Function:** final ignition angle, clamped -10.0..+40.0, written every sync event

**Code path:** F_000638BE 0x63AE4; consumed by ISR 0x488A8, knock window, logger

Part of [T5 Ignition Timing](../../guide/ignition-timing.md) · index: [T5 Symbols](../symbol-index.md)
