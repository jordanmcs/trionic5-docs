# Fuel_knock_xaxis

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

Calibration table (flash) · 0x40AB4 -> 0x6412

**Value in factory 4780656:** 12 bytes; [0] = engage load — units: kPa abs (book: active above ~140 kPa)

**Function:** knock fuel-map load axis; [0] compared to Medellast

**Code path:** 0x6DFB6 gate, 0x6DFE2 axis

Part of [T5 Fuel Injection](../../guide/fuel-injection.md) · index: [T5 Symbols](../symbol-index.md)
