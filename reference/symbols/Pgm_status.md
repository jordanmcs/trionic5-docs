# Pgm_status

State byte (RAM) · 0x1039 (6-byte block, 0x1039–0x103E; byte 1 at `0x103A` carries the extension flags)

**Value in factory 4780656:** runtime — units: bits

**Function:** engine state bits: bit3 running, bit4 fully-warm (coolant > 60 °C), bit5 overboost, bit7 rev limit. The `0x103A` extension byte carries the intake/warm-path flag (bit 3, set when intake ≥ 18 °C below the 60 °C branch) and the closed-throttle flag (bit 2) that the misfire evaluation gate skips on.

**Code path:** set: b4 `ORI.B #$10` `0x6D394` (gate `CMPI.B #$3C,(Kyl_temp)` at `0x6D388`); clear: b7 `ANDI.B #$7F` `0x71D08`, b5 `#$DF` `0x723E0`, b3 `#$F7` `0x6D4A8`/`0x6D570`, b0 `#$FE` `0x6CF84`. b4 tested (`ANDI.B #$10`) at `0x5B312`, `0x5C16E`, `0x5C2AA`, `0x6B650`. Gates cut paths `0x6C7F8`, `0x6CC00`.

> Address note: older pages said `0x1041` — that is [Ret_fak](Ret_fak.md) (symbol-table off-by-one; corrected 2026-10-27 against the fixed CSV and asm operands).

Part of [T5 Fuel Injection](../../guide/fuel-injection.md) · index: [T5 Symbols](../symbol-index.md)
