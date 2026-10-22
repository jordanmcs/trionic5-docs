# Misfire_map_x_axis

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

Calibration axis, 18 words · ROM 0x42384 -> RAM 0x69E2

**Value in factory 4780656:** words: 32, 36, 40, 44, 56, 68, 80, 92, 104, 116, 128, 140, 152, 164, 176, 188, 200, 212

**Function:** Load (boost/MAP) axis of the two misfire limit maps (book: 'Boost pressure in x axis'). Factory 32..188 counts (kPa absolute).

**Code path:** Interpolation calls 0x6185C/0x61884

Part of [T5 Misfire Detection](../../guide/misfire-detection.md) · index: [T5 Symbols](../symbol-index.md)
