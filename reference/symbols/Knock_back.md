---
tags: [saab, trionic5, symbol, knock]
type: "Calibration word (flash)"
address: "ROM 0x417DC"
---

# Knock_back

**Value in factory 4780656:** 2 = 0.2° per control period

**Function:** Recovery rate: spark advance returned to a cylinder each knock-free control period.

**Code path:** Read by the offset engine; gated by the decay conditions in explainer §4.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
