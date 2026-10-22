
# Apc_knock_tab

Calibration table, 8 bytes · ROM 0x40AC0

**Value in factory 4780656:**

Boost-derate increment applied per knock event into `Apc_decrese`. All 8 entries identical; axis not documented in this binary's usage.

| idx | Raw | Derate per event |
|---|---|---|
| 0 | 8 | +8 % |
| 1 | 8 | +8 % |
| 2 | 8 | +8 % |
| 3 | 8 | +8 % |
| 4 | 8 | +8 % |
| 5 | 8 | +8 % |
| 6 | 8 | +8 % |
| 7 | 8 | +8 % |

**Function:** Boost-derate increment per knock event, percentage points, into [Apc_decrese](Apc_decrese.md).

**Code path:** Applied in F_00072DC2 step controller.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
