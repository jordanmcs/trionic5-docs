# Function_0004461C

**ROM:** `0x0004461C`

```c

void Function_0004461C(undefined4 param_1)

{
  if (param_1._1_1_ == '\x01') {
    DAT_00fffa1b = DAT_00fffa1b & 0xbf;
  }
  else if (param_1._1_1_ == '\0') {
    DAT_00fffa1b = DAT_00fffa1b | 0x40;
  }
  return;
}

```
