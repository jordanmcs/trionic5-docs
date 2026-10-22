# Instructions for AI agents answering questions about this repository

This repository contains reverse-engineering documentation **plus the full ground-truth
artifacts** for the Saab Trionic 5 ECU (factory image 4780656). It is designed so that
questions about ECU behavior can be answered from the repository alone — no decompiler
or RE toolchain required.

## How to verify a claim before repeating it

Every documentation claim is address-anchored. Resolve the chain:

1. **Symbol name** → `data/t5_symbols.csv` (RAM state words) or
   `data/init_copy_inventory.factory.json` (513 calibration tables: name, ROM source,
   RAM copy, length).
2. **ROM address** → pseudocode: `pseudocode/<Function_XXXXXXXX>.md` (Ghidra
   decompiler output, `Function_<entry>` naming; full table in `pseudocode/index.md`).
3. **Exact instructions** → `firmware/4780656.asm` (ground truth; grep for
   `0x00<address>` line prefixes, e.g. `0x00072DC2`). The pseudocode is a derived view:
   where it disagrees with the asm listing, the asm wins.
4. **Calibration values** → the raw bytes in `evidence/*_tables.txt` (factory dump) or
   read `firmware/4780656_factory.BIN` directly at `addr - 0x40000`.

## Conventions

- Addresses are absolute ROM addresses, `0x40000`–`0x7FFFF` in the 256 KiB image.
  File offset = `addr - 0x40000`.
- Symbols appear as `ROM_<Name>` (flash calibration source) and `RAM_<Name>` (runtime
  copy); operand style `(RAM_Pgm_status)`. Functions are `Function_00042F5A` in
  pseudocode/asm and `F_00042F5A` in prose — same thing.
- Units: ignition/injection angles are 0.1 crank-degree words; temperature-indexed
  multipliers are ×1/128; pressure tables store kPa absolute (boost ≈ raw − 100);
  rpm words are usually rpm×10.
- The documentation describes the **factory** calibration only. Differences
  introduced by commercial reflashes are out of scope and not distributed here;
  questions about tuned values cannot be answered from these files.

## Answer style

Cite what you used: function address, symbol page, or table dump the answer came from.
If a question concerns behavior not documented in `guide/`, answer from
`pseudocode/` + `firmware/4780656.asm` and say so — the docs are thorough for eight
subsystem families (knock, ignition, fueling, boost, idle air, misfire, torque
intervention, warm-up) but the image holds more than the docs cover.
