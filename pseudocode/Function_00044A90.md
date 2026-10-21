# Function_00044A90

**ROM:** `0x00044A90`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00044A90(undefined4 param_1)

{
  if (param_1._1_1_ == '\x01') {
    DAT_00003b80 = DAT_00003b80 | 0x200;
    _DAT_00f007fe = DAT_00003b80;
  }
  else if (param_1._1_1_ == '\0') {
    DAT_00003b80 = DAT_00003b80 & 0xfffffdff;
    _DAT_00f007fe = DAT_00003b80;
  }
  else if (param_1._1_1_ == 'R') {
    Function_000493C2();
  }
  return;
}

```
