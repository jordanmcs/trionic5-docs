# Trionic 5 — reverse-engineered reference

Reverse-engineering documentation for the Saab **Trionic 5** engine-management ECU
(Motorola 68000 / MC68332 class), worked out from the factory **4780656** image with
REA + Ghidra (m68k). The analysis targets a T5.5 (NG900 era — Saab 900 / 9-3,
B204RM) 256 KiB flash with the ROM based at `0x40000`.

All calibration values in these pages are **factory 4780656** values. Differences
introduced by commercial reflashes are out of scope here and not distributed; the
detection and control *logic* is identical between the factory image and those tunes —
the differences are calibration-only.

Throughout the docs, **"the book"** means: Dilemma & J.K. Nilsson,
*Analysing/Analyzing Trionic 5 with T5Suite 2.0* (rev 1.23, 2010) — the T5 reference
documentation shipped with the T5SuiteII tuning suite.

## Where to start

**Looking up a symbol?** → **[`reference/symbol-index.md`](reference/symbol-index.md)** — every named
calibration and state symbol, grouped by subsystem, each linking to a page with ROM/RAM
address, factory value, units, and consuming code paths.

`guide/` holds one subsystem explainer per functional area:

| Page | Subsystem |
|---|---|
| [knock-detection-and-adaptation.md](guide/knock-detection-and-adaptation.md) | ion-current knock sensing, K-adapt, APC boost derate |
| [ignition-timing.md](guide/ignition-timing.md) | multi-map blend architecture, offsets, idle angle |
| [fuel-injection.md](guide/fuel-injection.md) | injection duration chain, injector angle, program-mode bits |
| [boost-control.md](guide/boost-control.md) | charge-pressure request chain + PID final element |
| [idle-air-control.md](guide/idle-air-control.md) | idle stepper governor |
| [misfire-detection.md](guide/misfire-detection.md) | ion-based misfire monitoring |
| [torque-intervention.md](guide/torque-intervention.md) | automatic-transmission shift-retard, MT blip |
| [warmup-cycle-and-temperature-inputs.md](guide/warmup-cycle-and-temperature-inputs.md) | temperature sensing, warm-up stages |

## Layout

- `guide/` — subsystem explainers (start here)
- `reference/symbol-index.md` — every named calibration/state symbol, grouped by subsystem
- `reference/symbols/` — one page per symbol: ROM/RAM address, factory value, units, function, consuming code paths
- `evidence/` — the working reference docs behind each guide, plus per-table raw byte dumps
- `pseudocode/` — full-image Ghidra decompile: one file per function (350 functions), `index.md` lists every entry point
- `firmware/` — the factory dump (`4780656_factory.BIN`, 256 KiB) and its annotated disassembly (`4780656.asm`, ROM addresses, `Function_` labels, symbol-named operands)
- `data/` — machine-readable maps: `t5_symbols.csv` (state words), `init_copy_inventory.factory.json` (all 513 calibration tables: ROM source → RAM copy → length)
- `interactive/` — [knock-explorer.html](interactive/knock-explorer.html): interactive walk-through of the knock signal chain (open in a browser)
- `AGENTS.md` — verification chain and conventions for AI agents answering questions from this repo

## Conventions

- Symbols are written by name with their ROM or RAM address, e.g. `Knock_reduce` @ ROM `0x417DA`.
- Addresses are absolute ROM addresses (`0x40000`–`0x7FFFF` in the 256 KiB image); RAM words are `0x0000–0x7FFF` plus extension RAM.
- Pressure tables store MAP-equivalent counts: kPa absolute (book anchor: "MAP over 140 kPa (0.4 bar)"); boost ≈ raw − 100.
- Angles are usually 0.1 crank-degree words; temperature-indexed multipliers are ×1/128.
- Every claim cites the disassembly (addresses in `firmware/4780656.asm`).

## Status

Eight subsystem families fully worked (knock, ignition, fueling, boost, idle air,
misfire, torque intervention, warm-up): 361 symbols documented. Open questions are
listed at the end of each evidence doc. Corrections and additions via issues/PRs are
welcome — please cite the ROM address range you are talking about.

## Provenance & license

Derived from a factory ECU image extracted from a donor unit; Saab / General Motors
holds the copyright on the original firmware, and this repository is an independent
research work. The documentation text is **all rights reserved** by the author until a
license is chosen — contact the repository owner before rehosting or republishing.
