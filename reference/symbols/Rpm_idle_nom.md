---
tags: [saab, trionic5, symbol, warmup]
type: "State word (RAM)"
address: "(RAM)"
---

# Rpm_idle_nom

**Value in factory 4780656:**

Nominal idle speed target (rpm), warm-up shaped by [Idle_rpm_tab](Idle_rpm_tab.md).

**Function:** Plus Iv_start_rpm_offset (+200 rpm) while starting, plus Idle_rpm_off (0 = unused).

**Code path:** Computed 0x6F650–0x6F6C8; read 0x5C19E/0x615C4 (idle control).

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
