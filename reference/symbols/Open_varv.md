# Open_varv

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

Calibration word (flash) · 0x40BB0 -> 0x4E40

**Value in factory 4780656:** 0x8C (140) — units: rpm/10

**Function:** fuel-save reactivation rpm (book 1400 rpm)

**Code path:** 0x71A04 cmp Rpm

Part of [T5 Fuel Injection](../../guide/fuel-injection.md) · index: [T5 Symbols](../symbol-index.md)
