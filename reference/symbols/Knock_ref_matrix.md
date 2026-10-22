
# Knock_ref_matrix

Calibration map, 288 words (18 load × 16 rpm) · ROM 0x428BA

**Value in factory 4780656:**

Expected window pulse count per rpm/load cell — the per-window knock threshold grid.

Axes (code-proven, passed to `F_00061F30` at 0x61B40–0x61B46): rpm = [Ign_map_0_y_axis](Ign_map_0_y_axis.md), MAP = [Ign_map_0_x_axis](Ign_map_0_x_axis.md). Column headers are raw MAP counts ≈ kPa abs on the default 2.5-bar sensor (+1.40 bar at 240).

| rpm ↓ / load → | 0 | 16 | 24 | 32 | 40 | 48 | 64 | 80 | 96 | 112 | 128 | 144 | 160 | 176 | 192 | 208 | 224 | 240 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| **500** | 19 | 19 | 19 | 53 | 74 | 80 | 32 | 19 | 19 | 19 | 78 | 70 | 70 | 69 | 67 | 40 | 19 | 19 |
| **880** | 19 | 19 | 19 | 53 | 64 | 80 | 68 | 19 | 19 | 19 | 78 | 70 | 70 | 69 | 67 | 53 | 19 | 19 |
| **1260** | 19 | 19 | 19 | 53 | 53 | 80 | 87 | 32 | 19 | 19 | 19 | 70 | 70 | 69 | 67 | 60 | 40 | 19 |
| **1640** | 19 | 19 | 19 | 53 | 53 | 72 | 87 | 68 | 19 | 19 | 19 | 70 | 70 | 69 | 67 | 60 | 53 | 19 |
| **2020** | 19 | 19 | 19 | 53 | 53 | 53 | 87 | 83 | 32 | 19 | 19 | 19 | 70 | 69 | 67 | 60 | 57 | 40 |
| **2400** | 19 | 19 | 19 | 53 | 53 | 53 | 70 | 83 | 68 | 19 | 19 | 19 | 70 | 69 | 67 | 60 | 57 | 53 |
| **2780** | 19 | 19 | 19 | 19 | 53 | 53 | 53 | 83 | 78 | 32 | 19 | 19 | 19 | 69 | 67 | 60 | 57 | 57 |
| **3160** | 19 | 19 | 19 | 19 | 53 | 53 | 53 | 68 | 78 | 60 | 19 | 19 | 19 | 69 | 67 | 60 | 57 | 57 |
| **3540** | 19 | 19 | 19 | 19 | 19 | 53 | 53 | 53 | 78 | 78 | 32 | 19 | 19 | 19 | 67 | 60 | 57 | 57 |
| **3920** | 19 | 19 | 19 | 19 | 19 | 53 | 53 | 53 | 69 | 78 | 60 | 19 | 19 | 19 | 67 | 60 | 57 | 57 |
| **4300** | 19 | 19 | 19 | 19 | 19 | 19 | 53 | 53 | 60 | 78 | 75 | 32 | 19 | 19 | 19 | 60 | 57 | 57 |
| **4680** | 19 | 19 | 19 | 32 | 19 | 19 | 53 | 53 | 60 | 78 | 75 | 60 | 19 | 19 | 19 | 60 | 57 | 57 |
| **5060** | 19 | 19 | 68 | 32 | 19 | 19 | 19 | 53 | 60 | 78 | 75 | 72 | 32 | 19 | 19 | 19 | 57 | 57 |
| **5440** | 19 | 19 | 68 | 68 | 19 | 19 | 19 | 53 | 60 | 78 | 72 | 72 | 60 | 19 | 19 | 19 | 57 | 57 |
| **5820** | 19 | 19 | 68 | 74 | 32 | 19 | 19 | 19 | 60 | 78 | 70 | 72 | 69 | 40 | 19 | 19 | 19 | 57 |
| **6200** | 19 | 19 | 61 | 74 | 68 | 19 | 19 | 19 | 60 | 78 | 70 | 72 | 69 | 53 | 19 | 19 | 19 | 57 |

Raw values = expected window pulse count; 19 = floor, 87 = ridge. Byte-identical to factory.

**Function:** Expected window pulse count per rpm/load cell — the per-window knock threshold grid. Its diagonal ridge is Saab's own compensator to the [Detect_map](Detect_map.md) mask; byte-identical to factory.

**Code path:** Evaluated in F_00060BFE at each detection window.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
