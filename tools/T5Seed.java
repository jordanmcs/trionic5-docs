// GhidraScript (12.x): preScript — seed ROM_/RAM_ labels + function entries.
// Inputs: out/headless/symbols.txt, func_labels.txt (TAB: ADDR\tNAME).
import ghidra.app.script.GhidraScript;
import ghidra.program.model.listing.*;
import ghidra.program.model.symbol.*;
import ghidra.program.model.address.*;
import ghidra.program.model.mem.*;
import ghidra.program.model.data.DataType;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class T5Seed extends GhidraScript {
    // resolved from the GHIDRA_T5_IN env var, falling back to this repo's tools/ dir
    static final String IN = System.getenv().getOrDefault("GHIDRA_T5_IN",
            "/mnt/c/Users/jorda/t5-re/out/headless/");
    static final String BIN = System.getenv().getOrDefault("GHIDRA_T5_BIN",
            "/mnt/c/Users/jorda/t5-re/bin/4780656_factory.BIN");
    static final long BASE = 0x40000L;

    List<String> readLines(String path) throws IOException {
        List<String> out = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String ln; while ((ln = br.readLine()) != null) if (!ln.isBlank()) out.add(ln);
        }
        return out;
    }

    @Override
    public void run() throws Exception {
        Program program = getCurrentProgram();
        SymbolTable st = program.getSymbolTable();
        FunctionManager fm = program.getFunctionManager();
        AddressSpace sp = program.getAddressFactory().getDefaultAddressSpace();

        // Some Ghidra 12.x builds ignore raw-binary loader base options; force the image
        // block to 0x40000 (the T5 ROM space the asm listing/docs use) ourselves.
        Memory mem = program.getMemory();
        int tx = program.startTransaction("relocate to 0x40000");
        try {
            byte[] buf = Files.readAllBytes(new File(BIN).toPath());
            Address base = sp.getAddress(BASE);
            MemoryBlock old = mem.getBlock(base);
            boolean already = old != null && old.getStart().equals(base) && old.getSize() == buf.length;
            if (!already) {
                for (MemoryBlock b : mem.getBlocks()) mem.removeBlock(b, monitor);
                MemoryBlock nb = mem.createInitializedBlock("rom", base,
                        new ByteArrayInputStream(buf), buf.length, monitor, false);
                nb.setExecute(true);
                // model the 16K SRAM so RAM_* references land in a block and bind
                Address ramBase = sp.getAddress(0x0L);
                if (mem.getBlock(ramBase) == null) {
                    MemoryBlock rb = mem.createUninitializedBlock("ram", ramBase, 0x8000, false);
                    rb.setRead(true); rb.setWrite(true);
                }
                println("SEED relocated image block to 0x" + Long.toHexString(BASE));
            }
        } finally {
            program.endTransaction(tx, true);
        }

        int nsyms = 0;
        // RAM operands resolve in the processor's data space; ROM in default/code space.
        ghidra.program.model.address.AddressFactory af = program.getAddressFactory();
        AddressSpace code = af.getDefaultAddressSpace();
        AddressSpace ram = null;
        for (AddressSpace cand : af.getAddressSpaces()) {
            if (cand != code && !cand.isExternalSpace() && !"OTHER".equals(cand.getName())) { ram = cand; break; }
        }
        for (String ln : readLines(IN + "symbols.txt")) {
            String[] p = ln.split("\t");
            try {
                long v = Long.parseUnsignedLong(p[0], 16);
                AddressSpace want = (v >= BASE || ram == null) ? code : ram;
                Address a = want.getAddress("0x" + p[0]);
                if (a == null) continue;
                st.createLabel(a, p[1], SourceType.USER_DEFINED);
                // give the label a real data type so the decompiler binds names instead of DAT_
                if (p.length >= 3) {
                    int len = Integer.parseInt(p[2]);
                    DataType dt;
                    if (len == 1) dt = new ghidra.program.model.data.ByteDataType();
                    else if (len == 2) dt = new ghidra.program.model.data.WordDataType();
                    else dt = new ghidra.program.model.data.ArrayDataType(
                            new ghidra.program.model.data.ByteDataType(), len, 1);
                    program.getListing().clearCodeUnits(a, a, false);
                    program.getListing().createData(a, dt);
                }
                nsyms++;
            } catch (Exception e) { }
        }
        println("SEED symbols applied: " + nsyms + " (data space: " + (ram == null ? "none" : ram.getName()) + ")");

        int nf = 0, nerr = 0, nskip = 0, nnull = 0;
        List<String> flines = readLines(IN + "func_labels.txt");
        println("SEED func_labels lines: " + flines.size() + " existing functions: " + fm.getFunctionCount());
        String firstErr = null;
        for (String ln : flines) {
            String[] p = ln.split("\t");
            try {
                Address a = sp.getAddress("0x" + p[0]);
                if (a == null) { nnull++; continue; }
                if (fm.getFunctionAt(a) != null || fm.getFunctionContaining(a) != null) { nskip++; continue; }
                Function f = fm.createFunction(p[1], a, new ghidra.program.model.address.AddressSet(a), SourceType.USER_DEFINED);
                if (f != null) nf++;
            } catch (Exception e) {
                nerr++;
                if (firstErr == null) firstErr = p[0] + ": " + e;
            }
        }
        if (firstErr != null) println("SEED first func error -> " + firstErr);
        println("SEED seeded=" + nf + " err=" + nerr + " nulladdr=" + nnull + " alreadyfunc=" + nskip);
    }
}
