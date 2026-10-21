---
tags: [saab, trionic5, symbol, misfire]
type: "Calibration matrix, 576 bytes"
address: "ROM 0x4260A -> RAM 0x7062"
---
# Mis1000_map

**Value in factory 4780656:** 576 bytes — full hex in `source/misfire_tables.txt`

**Function:** Maximum allowed misfires per 2000 combustions (1000 rev) before emission-level degradation (book glossary).

**Code path:** Interpolated -> Mis1000_limit; window machinery 0x63D0E-0x64F00

Part of [T5 Misfire Detection](../../guide/misfire-detection.md) · index: [T5 Symbols](../symbol-index.md)
