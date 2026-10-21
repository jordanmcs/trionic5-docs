# Function_000446EC

**ROM:** `0x000446EC`

```c

void Function_000446EC(undefined4 param_1)

{
  if (param_1._1_1_ == '\x01') {
    DAT_00fffa13 = DAT_00fffa13 | 2;
  }
  else if (param_1._1_1_ == '\0') {
    DAT_00fffa13 = DAT_00fffa13 & 0xfd;
  }
  return;
}

```
