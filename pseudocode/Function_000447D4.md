# Function_000447D4

**ROM:** `0x000447D4`

```c

void Function_000447D4(undefined4 param_1)

{
  if (param_1._1_1_ == '\x01') {
    DAT_0000372c = 1;
    DAT_00fffa13 = DAT_00fffa13 | 0x40;
    DAT_00003868 = 1;
  }
  else if (param_1._1_1_ == '\0') {
    DAT_0000372c = 1;
    DAT_00fffa13 = DAT_00fffa13 & 0xbf;
    DAT_00003868 = 1;
  }
  return;
}

```
