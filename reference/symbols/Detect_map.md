---
tags: [saab, trionic5, symbol, knock]
type: "Calibration mask, 18 load × 16 rpm"
address: "ROM 0x42144 (x-axis 0x42100 raw MAP 32–212 ≈ −0.68…+1.12 bar; y-axis 0x42124 rpm 880–6010)"
---

# Detect_map

**Value in factory 4780656:**

Where knock evaluation is permitted at all.

Axes: rpm = [Detect_map_y_axis](Detect_map_y_axis.md), MAP = [Detect_map_x_axis](Detect_map_x_axis.md) (read directly in the evaluation path, 0x6193C/0x61966). Column headers are raw MAP counts ≈ kPa absolute on the default 2.5-bar sensor: `32` ≈ idle vacuum, `100` ≈ atmospheric, `212` ≈ +1.12 bar boost.

| rpm ↓ / load → | 32  | 36  | 40  | 44  | 56  | 68  | 80  | 92  | 104 | 116 | 128 | 140 | 152 | 164 | 176 | 188 | 200 | 212 |
| -------------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| **880**        | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   |
| **1260**       | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   |
| **1640**       | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   |
| **2020**       | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   |
| **2400**       | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   |
| **2780**       | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   |
| **3160**       | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ·   | ✓   | ✓   | ✓   | ✓   | ·   |
| **3540**       | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ·   |
| **3920**       | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ·   | ✓   | ✓   | ✓   | ·   |
| **4300**       | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ·   |
| **4680**       | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ·   | ✓   | ✓   | ·   |
| **5060**       | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ·   |
| **5440**       | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ·   | ✓   | ·   |
| **5820**       | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ·   | ✓   | ·   |
| **6000**       | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ·   | ·   |
| **6010**       | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ✓   | ·   | ·   | ·   |

1 = knock evaluation permitted. Note the min-load column, max-load column, and the diagonal exemption band migrating with rpm. Byte-identical to factory.

**Function:** Where knock evaluation is permitted at all. Zero at min-load column, max-load column, and a diagonal band migrating with rpm. Byte-identical to factory — Saab's design: masked where the fixed post-spark window loses or saturates on the ion event (waveform verification pending).

**Code path:** Read per window in F_00060BFE.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
