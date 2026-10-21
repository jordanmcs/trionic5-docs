# Function_000446C4

**ROM:** `0x000446C4`

```c

void Function_000446C4(undefined4 param_1)

{
  if (param_1._1_1_ == '\x01') {
    DAT_00fffa13 = DAT_00fffa13 & 0xfe;
  }
  else if (param_1._1_1_ == '\0') {
    DAT_00fffa13 = DAT_00fffa13 | 1;
  }
  return;
}

```
