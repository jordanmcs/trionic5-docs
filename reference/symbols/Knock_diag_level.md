
# Knock_diag_level

State byte (SRAM 0x1100) · SRAM 0x1100

**Value in factory 4780656:** raw window count

**Function:** Raw pulse count of the last evaluated window, written unconditionally every window. The ion-line watchdog's witness: >50 = signal present; ≤50 for 10 s (battery/rpm permitting) → fault 0x28/0x2C + Knock_frame. Also snapshotted in error frames.

**Code path:** Written 0x60E64; read by F_0005C34A and error-frame collector 0x5F138.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
