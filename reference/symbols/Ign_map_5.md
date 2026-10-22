# Ign_map_5

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

Calibration word (flash) · ROM 0x42022

**Value in factory 4780656:** 20 x16 (constant +2.0) — units: 0.1 crank degree

**Function:** fixed advance overlay while channel-5 condition active (undocumented in book)

**Code path:** F_00062102 0x624C8 -> 0x398E, weight 0x399E

Part of [T5 Ignition Timing](../../guide/ignition-timing.md) · index: [T5 Symbols](../symbol-index.md)
