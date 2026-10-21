---
tags: [saab, trionic5, symbol, knock]
type: "Calibration axis, 18 words (raw MAP count)"
address: "ROM 0x42100 (RAM [Detect_map_x_axis](Detect_map_x_axis.md))"
---

# Detect_map_x_axis

**Value in factory 4780656:** 18 words, MAP counts 32–212 (full table below).

MAP axis of [Detect_map](Detect_map.md) (read directly at 0x6193C in the knock evaluation path).

**Units (user-supplied scaling rule):** raw value = 8-bit MAP sensor reading; with the default 2.5-bar sensor the 0–255 count range spans −1 to +1.5 bar gauge, i.e. the count ≈ manifold absolute pressure in kPa. Boost ≈ raw − 100 kPa (`212` ≈ +1.12 bar; `32` ≈ 0.68 bar vacuum — typical idle).

| # | Raw (MAP count) | ≈ kPa abs | ≈ boost (bar) |
|---|---|---|---|
| 0 | 32 | ≈32 | -0.68 |
| 1 | 36 | ≈36 | -0.64 |
| 2 | 40 | ≈40 | -0.60 |
| 3 | 44 | ≈44 | -0.56 |
| 4 | 56 | ≈56 | -0.44 |
| 5 | 68 | ≈68 | -0.32 |
| 6 | 80 | ≈80 | -0.20 |
| 7 | 92 | ≈92 | -0.08 |
| 8 | 104 | ≈104 | +0.04 |
| 9 | 116 | ≈116 | +0.16 |
| 10 | 128 | ≈128 | +0.28 |
| 11 | 140 | ≈140 | +0.40 |
| 12 | 152 | ≈152 | +0.52 |
| 13 | 164 | ≈164 | +0.64 |
| 14 | 176 | ≈176 | +0.76 |
| 15 | 188 | ≈188 | +0.88 |
| 16 | 200 | ≈200 | +1.00 |
| 17 | 212 | ≈212 | +1.12 |

> [!warning] Sensor assumption
> This conversion assumes the **default 2.5-bar MAP sensor**. With a **3-bar sensor** the same raw load values stand in these tables, but each count maps onto that sensor's coarser span (≈1.18 vs ≈0.98 kPa/count) — the physical pressure the count means is rescaled, and in practice the lower and upper limits of the table range are lost.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
