#!/bin/bash
# Regenerate pseudocode/ from the factory BIN using a stock Ghidra 12.x install.
# Run from WSL/Linux: needs analyzeHeadless on PATH or GHIDRA env var set.
#   GHIDRA=/opt/ghidra_12.1.4_PUBLIC ./run_dump.sh
# Inputs: tools/symbols.txt, tools/func_labels.txt (TAB-separated ADDR<TAB>NAME).
# Output: pseudocode/*.md + pseudocode/index.md, relative to THIS repo root.
set -e
GHIDRA=${GHIDRA:?set GHIDRA to your Ghidra install dir}
REPO="$(cd "$(dirname "$0")/../.." && pwd)"
PROJ=$(mktemp -d)
export GHIDRA_T5_IN="$(cd "$(dirname "$0")" && pwd)/"
export GHIDRA_T5_OUT="$REPO/pseudocode/"
"$GHIDRA/support/analyzeHeadless" "$PROJ" T5FACTORY \
  -import "$REPO/firmware/4780656_factory.BIN" \
  -processor 68000:BE:32:default -loader BinaryLoader -loader-Base-Address 0x40000 \
  -scriptPath "$(dirname "$0")" \
  -preScript T5Seed.java -postScript T5Dump.java \
  -deleteProject
# Paths are passed via GHIDRA_T5_IN / GHIDRA_T5_OUT, so no constants need editing.
