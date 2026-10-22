
# Apc_knock_back

Calibration byte (flash)  ·  ROM 0x42EAA

**Value in factory 4780656:** Raw **5** (1 B) at ROM `0x42EAA`.

**Function:** Boost-derate recovery rate, % per period: after knock clears, the APC derate is walked back toward full boost at this rate. (Tune diff: MCS differs — see T5 MCS Tune Changes.)

**Code path:** Recovery branch of F_00072DC2.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
