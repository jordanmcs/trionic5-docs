---
tags: [saab, trionic5, symbol, knock]
type: "State word (RAM)"
address: "RAM"
---

# Apc_decrese

**Value in factory 4780656:** 0–100 (%)

**Function:** Global knock boost derate: +8 % per knock event (Apc_knock_tab), recovered at Apc_knock_back per period; applied as subtraction on Regl_tryck.

**Code path:** Step controller F_00072DC2; applied 0x72782 (floor 0x78).

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
