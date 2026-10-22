
# Regl_tryck

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

State word (RAM) · RAM

**Value in factory 4780656:** charge-pressure setpoint

**Function:** The boost PID's target charge pressure. Knock derate subtracts Apc_decrese from it (0x72782).

**Code path:** Boost PID; per book p72: PWM_ut = reg_kon·(…)·APC_knock.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
