
# Knock_diag

Correction note (no such symbol) · —

**Not a symbol in the factory image.** An earlier version of this page documented a "`Knock_diag` accumulator (RAM 0x1D14, code path F_00047CE0)". Verification against `4780656_factory.BIN` (2026-10-21, REA/Ghidra) disproved it:

- The embedded symbol table contains **no** `Knock_diag` entry; RAM `0x1D14` is `Start_time_tot`. The old address came from the same mis-paired symbol-table dump documented in [Knock_status](Knock_status.md).
- `Function_00047CE0` writes only TPU/I/O registers (`$FFFE0A–$FFFE20` ANDI/ORI sequences plus an IPR write) — knock-capture channel **configuration**, not a per-window RAM accumulator update.

The per-window raw ion-pulse witness is [Knock_diag_level](Knock_diag_level.md); latched ion-line faults come from the watchdog `Function_0005C34A` (codes 0x28/0x2C) and are snapshotted into [Knock_frame](Knock_frame.md).

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
