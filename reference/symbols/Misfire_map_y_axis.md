---
tags: [saab, trionic5, symbol, misfire]
type: "Calibration axis, 16 words"
address: "ROM 0x423A8 -> RAM 0x6A06"
---
# Misfire_map_y_axis

**Value in factory 4780656:** words: 880, 1260, 1640, 2020, 2400, 2780, 3160, 3540, 3920, 4300, 4680, 5060, 5440, 5820, 6000, 6010

**Function:** Engine-speed axis of the misfire limit maps. Factory 880..6350 rpm.

**Code path:** Interpolation calls 0x6185C/0x61884

Part of [T5 Misfire Detection](../../guide/misfire-detection.md) · index: [T5 Symbols](../symbol-index.md)
