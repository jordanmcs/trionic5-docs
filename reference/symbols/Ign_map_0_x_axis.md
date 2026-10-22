


# Ign_map_0_x_axis

Calibration axis, 18 words (raw MAP count) · ROM 0x41826 (RAM [Ign_map_0_x_axis](Ign_map_0_x_axis.md))



**Value in factory 4780656:** 18 words, MAP counts 0–240 (full table below). Factory upper points 208/224/240.MAP axis of the main ignition map, passed as the x-axis for the [Knock_ref_matrix](Knock_ref_matrix.md) interpolation (0x61B46).



**Units (user-supplied scaling rule):** raw value = 8-bit MAP sensor reading; with the default 2.5-bar sensor the 0–255 count range spans −1 to +1.5 bar gauge, i.e. the count ≈ manifold absolute pressure in kPa. Boost ≈ raw − 100 kPa (`212` ≈ +1.12 bar; `32` ≈ 0.68 bar vacuum — typical idle).



| # | Raw (MAP count) | ≈ kPa abs | ≈ boost (bar) |
|---|---|---|---|
| 0 | 0 | ≈0 | -1.00 |
| 1 | 16 | ≈16 | -0.84 |
| 2 | 24 | ≈24 | -0.76 |
| 3 | 32 | ≈32 | -0.68 |
| 4 | 40 | ≈40 | -0.60 |
| 5 | 48 | ≈48 | -0.52 |
| 6 | 64 | ≈64 | -0.36 |
| 7 | 80 | ≈80 | -0.20 |
| 8 | 96 | ≈96 | -0.04 |
| 9 | 112 | ≈112 | +0.12 |
| 10 | 128 | ≈128 | +0.28 |
| 11 | 144 | ≈144 | +0.44 |
| 12 | 160 | ≈160 | +0.60 |
| 13 | 176 | ≈176 | +0.76 |
| 14 | 192 | ≈192 | +0.92 |
| 15 | 208 | ≈208 | +1.08 |
| 16 | 224 | ≈224 | +1.24 |
| 17 | 240 | ≈240 | +1.40 |



> [!warning] Sensor assumption

> This conversion assumes the **default 2.5-bar MAP sensor**. With a **3-bar sensor** the same raw load values stand in these tables, but each count maps onto that sensor's coarser span (≈1.18 vs ≈0.98 kPa/count) — the physical pressure the count means is rescaled, and in practice the lower and upper limits of the table range are lost.



Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)

