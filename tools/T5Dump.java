// GhidraScript (12.x) postScript: decompile every function to per-function markdown.
// Output: out/pseudocode/Function_XXXXXXXX.md + index.md. Seeding done by T5Seed preScript.
import ghidra.app.script.GhidraScript;
import ghidra.app.decompiler.*;
import ghidra.program.model.listing.*;
import java.io.*;
import java.util.*;

public class T5Dump extends GhidraScript {
    static final String OUT = System.getenv().getOrDefault("GHIDRA_T5_OUT",
            "/mnt/c/Users/jorda/t5-re/out/pseudocode/");

    @Override
    public void run() throws Exception {
        Program program = getCurrentProgram();
        FunctionManager fm = program.getFunctionManager();

        new File(OUT).mkdirs();
        DecompInterface dec = new DecompInterface();
        dec.openProgram(program);
        PrintStream index = new PrintStream(new FileOutputStream(OUT + "index.md"), false, "UTF-8");
        index.println("# Function index");
        index.println();
        index.println("| Address | Name | Pseudocode lines |");
        index.println("|---|---|---|");
        int done = 0, fail = 0;
        List<Function> funcs = new ArrayList<>();
        for (Function f : fm.getFunctions(true)) if (!f.isThunk()) funcs.add(f);
        for (Function f : funcs) {
            if (monitor.isCancelled()) break;
            String name = f.getName();
            String addr = f.getEntryPoint().toString().toUpperCase();
            while (addr.length() < 8) addr = "0" + addr;
            try {
                DecompileResults r = dec.decompileFunction(f, 60000, monitor);
                String c = (r != null && r.decompileCompleted() && r.getDecompiledFunction() != null)
                        ? r.getDecompiledFunction().getC() : null;
                if (c == null) { fail++; continue; }
                PrintStream o = new PrintStream(new FileOutputStream(OUT + name + ".md"), false, "UTF-8");
                o.println("# " + name);
                o.println();
                o.println("**ROM:** `0x" + addr + "`");
                o.println();
                o.println("```c");
                o.print(c);
                if (!c.endsWith("\n")) o.println();
                o.println("```");
                o.close();
                int nl = c.split("\n", -1).length;
                index.println("| 0x" + addr + " | [" + name + "](" + name + ".md) | " + nl + " |");
                done++;
            } catch (Exception e) { fail++; }
            monitor.setProgress(done + fail);
        }
        index.close();
        dec.dispose();
        println("DUMP DONE decompiled=" + done + " failed=" + fail);
    }
}
