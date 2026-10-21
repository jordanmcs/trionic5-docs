# Function_000445F4

**ROM:** `0x000445F4`

```c

void Function_000445F4(undefined4 param_1)

{
  if (param_1._1_1_ == '\x01') {
    DAT_00fffa1b = DAT_00fffa1b | 0x20;
  }
  else if (param_1._1_1_ == '\0') {
    DAT_00fffa1b = DAT_00fffa1b & 0xdf;
  }
  return;
}

```
