---
tags: [saab, trionic5, symbol, knock]
type: "State word (RAM)"
address: "RAM"
---

# Regl_tryck

**Value in factory 4780656:** charge-pressure setpoint

**Function:** The boost PID's target charge pressure. Knock derate subtracts Apc_decrese from it (0x72782).

**Code path:** Boost PID; per book p72: PWM_ut = reg_kon·(…)·APC_knock.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
