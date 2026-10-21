---
tags: [saab, trionic5, symbol, warmup]
type: "State byte array (RAM, per cylinder)"
address: "(RAM)"
---

# Eft_fak

**Value in factory 4780656:**

Active after-start enrichment coefficient (×1/128 add to base fuel), fed from [Eftersta_fak](Eftersta_fak.md), decayed by [Eft_dec](Eft_dec.md).

**Function:** The live warm-up enrichment: one entry per cylinder (indexed by Cyl_nr); decremented one point per decay tick while [Eft_dec](Eft_dec.md) is active.

**Code path:** Base 0x6F226; per-cylinder 0x6F2A0–0x6F2C2; decay 0x6F2E4.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
