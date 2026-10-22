# Mis1000_map

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

Calibration matrix, 576 bytes · ROM 0x4260A -> RAM 0x7062

**Value in factory 4780656:** 576 bytes — full hex in `source/misfire_tables.txt`

**Function:** Maximum allowed misfires per 2000 combustions (1000 rev) before emission-level degradation (book glossary).

**Code path:** Interpolated -> Mis1000_limit; window machinery 0x63D0E-0x64F00

Part of [T5 Misfire Detection](../../guide/misfire-detection.md) · index: [T5 Symbols](../symbol-index.md)
