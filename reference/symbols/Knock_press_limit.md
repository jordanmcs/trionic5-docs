---
tags: [saab, trionic5, symbol, knock]
type: "Runtime word (RAM)"
address: "derived from Knock_press_tab"
---

# Knock_press_limit

**Value in factory 4780656:** 60–70 (MAN pressure units)

**Function:** Live interpolated threshold: evaluation skipped while P_Manifold is at or below it — suppresses knock judgement at part throttle.

**Code path:** Computed per pass; compared against P_Manifold at 0x60EA8.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
