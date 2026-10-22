
# Knock_status

> **Source note:** “the book” below means Dilemma & J.K. Nilsson,
> *Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
> documentation shipped with the T5SuiteII tuning suite.

State byte (RAM 0x1119) · RAM 0x1119

**Value in factory 4780656:** bit flags — byte-packed with [Multispark](Multispark.md) (`0x1118`) in the same word.

**Function:** Knock status bits. Bit0 arms the knock fuel branch (while set and load exceeds the knock map's first column, [Fuel_knock_mat](Fuel_knock_mat.md) replaces both VE factors); bit3 is consumed by the APC-chain function `Function_00072DC2`. Includes the documented "[Knock_average](Knock_average.md) > [Knock_average_limit](Knock_average_limit.md)" escalation flag (book pp 102-104).

**Code path — all three references, operands verified against `4780656_factory.BIN` (sha256 4a7934aa…):**

| Site | Instruction | Role |
|---|---|---|
| `0x62890` | `MOVEA.L #$1119,A0` | error-frame/flag collector pointer |
| `0x6DFA4` | `MOVE.B $1119.l,D1` + `ANDI.B #$01` | knock-fuel-branch test (`BEQ` skips) |
| `0x72DCA` | `MOVEA.L #$1119,A4` | knock→boost coupling in `Function_00072DC2` |

**Address resolution (2026-10-21, REA/Ghidra on the factory image):** the embedded symbol-table record at ROM `0x53748` is `11 19 00 01` + `Knock_status\r\n` (record format `[addr:2BE][len:2BE][name]\r\n`) = **RAM 0x1119, len 1**, agreeing with all three code operands. The `0x111A` in `t5_symbols.csv`/`tools/symbols.txt` is an extraction artifact — that dump paired each name with the *next* table record's address (0x111A actually belongs to `Misftakeoff_ign_lim`). The `0x1D10` carried by earlier symbol pages is `Knock_count_cyl4`. See [T5 Firmware Flags](../../guide/firmware-flags.md).

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
