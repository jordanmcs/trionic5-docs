
# MisCountMap4

State table, 288 B (RAM) · 0x319A

**Value in factory 4780656:** runtime — units: misfire events per cell

**Function:** Per-cylinder 4 operating-cell histogram of misfire events (16×18 rpm/boost grid) for live-data display; FF-empty scan/clear distinguishes visited cells.

**Code path:** Event add e.g. ADDQ.B #1,(RAM_MisCountMap2+D3) at 0x64A02; FF scan 0x4E86A

Part of [T5 Misfire Detection](../../guide/misfire-detection.md) · index: [T5 Symbols](../symbol-index.md)
