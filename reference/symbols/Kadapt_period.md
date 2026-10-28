
# Kadapt_period

Calibration word (flash→RAM 0x5ACA) · ROM 0x42872

**Value in factory 4780656:** 300 (ticks) — ROM 0x42872 word 0x012C (byte-verified; neighbour 0x42874 = [Knock_ang_dec](Knock_ang_dec.md) = 20)

**Function:** Timeout for an interrupted K-adapt sampling session: conditions lapsed and Diag_tid past start+300 resets the state machine (0x6133C).

**Code path:** Reset branch of the adaptation state machine.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
