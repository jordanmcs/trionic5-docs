---
tags: [saab, trionic5, symbol, torque]
type: "Calibration word"
address: "ROM 0x42E64 -> RAM 0x5B38"
---
# API_ku_derivata

**Value in factory 4780656:** words: 10

**Function:** Engine-speed drop threshold (rpm between evaluations) marking the upshift-sign edge for ku; also hysteresis of the +/- sign word. Factory 10.

**Code path:** F_0006185E at 0x61CD4 (sign test), 0x61E3A

Part of [T5 Torque Intervention](../../guide/torque-intervention.md) · index: [T5 Symbols](../symbol-index.md)
