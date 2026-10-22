
# Knock_status

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

State byte (RAM 0x1D10) · RAM 0x1D10

**Value in factory 4780656:** bit flags

**Function:** Knock status bits incl. the documented "Knock_average > Knock_average_limit" escalation flag.

**Code path:** Set by evaluation/offset engines; visible via T5Suite flag tables (book pp 102-104).

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
