---
tags: [saab, trionic5, symbol, knock]
type: "Calibration table, 11 words"
address: "ROM 0x42856"
---

# Kadapt_max_ref

**Value in factory 4780656:**

Ratio ceiling for the window-count/reference comparison, indexed `(rpm/10 − 150)/32 + 1`. Caps detection sensitivity regardless of adaptation state.

| idx | rpm band | Raw | Max ratio |
|---|---|---|---|
| 0 | from 1500 rpm | 315 | 3.15× |
| 1 | from 1820 rpm | 315 | 3.15× |
| 2 | from 2140 rpm | 315 | 3.15× |
| 3 | from 2460 rpm | 270 | 2.70× |
| 4 | from 2780 rpm | 250 | 2.50× |
| 5 | from 3100 rpm | 229 | 2.29× |
| 6 | from 3420 rpm | 218 | 2.18× |
| 7 | from 3740 rpm | 200 | 2.00× |
| 8 | from 4060 rpm | 183 | 1.83× |
| 9 | from 4380 rpm | 166 | 1.66× |
| 10 | from 4700 rpm | 166 | 1.66× |

**Function:** Ceiling for the window-count / reference ratio used in evaluation, indexed (rpm−150)/32+1 (rpm/10): 3.15× low-rpm → 1.66× high-rpm. Caps detection sensitivity regardless of adaptation state.

**Code path:** Clamps ratio in F_00060BFE core.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
