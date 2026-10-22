
# Knock_time_low

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

State word (RAM 0x2108/0x210A) · RAM 0x2108/0x210A

**Value in factory 4780656:** (timer ticks)

**Function:** No-signal duration timer for the ion-path watchdog; latches fault past the 10 s threshold. Listed in the Error_frame layout (book p104).

**Code path:** F_0005C34A.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
