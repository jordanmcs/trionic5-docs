---
tags: [saab, trionic5, symbol, boost]
type: "16-bit table (31 words, flash)"
address: "ROM 0x415E8, RAM 0x5E1C"
---
# Reg_kon_mat

**Value in factory 4780656:** 424->335->448 — units: PWM counts (0-980 scale)

**Function:** PID feed-forward duty offset vs rpm (manual)

**Code path:** F_0007300C 0x73132 -> Reg_kon_apc

| rpm | 2500 | 2600 | 2700 | 2800 | 2900 | 3000 | 3100 | 3200 | 3300 | 3400 | 3500 | 3600 | 3700 | 3800 | 3900 | 4000 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| duty | 424 | 421 | 418 | 415 | 412 | 409 | 394 | 379 | 364 | 349 | 335 | 335 | 335 | 335 | 335 |
| rpm | 4100 | 4200 | 4300 | 4400 | 4500 | 4600 | 4700 | 4800 | 4900 | 5000 | 5100 | 5200 | 5300 | 5400 | 5500 |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| duty | 335 | 340 | 345 | 350 | 354 | 358 | 360 | 363 | 365 | 368 | 371 | 376 | 381 | 386 | 390 | 394 |

Direct-indexed feed-forward duty offset (0-980 scale), 100-rpm grid 2500→5500 rpm (no interpolation).
Part of [T5 Boost Control](../../guide/boost-control.md) · index: [T5 Symbols](../symbol-index.md)
