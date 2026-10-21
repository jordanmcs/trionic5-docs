---
tags: [saab, trionic5, symbol, fuel]
type: "Calibration table (flash)"
address: "0x409CA -> 0x4BD4"
---
# Fload_throt_tab

**Value in factory 4780656:** AA x5, B4 x3, BE, FF x6 — units: AD counts

**Function:** throttle-AD WOT threshold per rpm row (FF = disabled >= 2400 rpm)

**Code path:** 0x6E2EC cmp AD_trot

Part of [T5 Fuel Injection](../../guide/fuel-injection.md) · index: [T5 Symbols](../symbol-index.md)
