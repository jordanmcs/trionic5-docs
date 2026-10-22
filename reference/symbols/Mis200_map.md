# Mis200_map

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

Calibration matrix, 576 bytes · ROM 0x423CA -> RAM 0x6E22

**Value in factory 4780656:** 576 bytes — full hex in `source/misfire_tables.txt`

**Function:** Maximum allowed misfires per 400 combustions (200 rev) without catalyst overheating (book glossary). Interpolated grid, 16 rpm x 18 load word cells; axes Misfire_map_y_axis / Misfire_map_x_axis.

**Code path:** Interpolated at F_0006185C-0x6189C -> Mis200_limit; window machinery 0x63D0E-0x64F00

Part of [T5 Misfire Detection](../../guide/misfire-detection.md) · index: [T5 Symbols](../symbol-index.md)
