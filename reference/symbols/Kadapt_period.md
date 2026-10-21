---
tags: [saab, trionic5, symbol, knock]
type: "Calibration word (flash→RAM 0x5ACA)"
address: "ROM 0x42872"
---

# Kadapt_period

**Value in factory 4780656:** 320 (ticks)

**Function:** Timeout for an interrupted K-adapt sampling session: conditions lapsed and Diag_tid past start+320 resets the state machine (0x6133C).

**Code path:** Reset branch of the adaptation state machine.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
