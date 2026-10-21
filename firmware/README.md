# Firmware artifacts

- `4780656_factory.BIN` — 256 KiB (262,144 B) flash dump of a factory Saab Trionic 5.5
  ECU, part number **4780656**. ROM base `0x40000`, reset vector entry `0x76904`.
  This dump is the byte authority for every calibration value cited in the docs.
- `4780656.asm` — full m68k disassembly of that dump (same addresses as the BIN:
  `0x00040000`–`0x0007FFFF`), produced with REA/Ghidra and annotated with the symbol
  names used throughout this repository (`RAM_Apc_knock_back!`, `ROM_Knock_reduce!`,
  `Function_00042F5A:` …).

Both files describe copyrighted GM-era firmware; they are published here strictly for
interoperability research on the vehicle's own ECU.
