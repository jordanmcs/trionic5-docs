# Function_00044C58

**ROM:** `0x00044C58`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00044C58(undefined4 param_1)

{
  if (param_1._1_1_ == '\x01') {
    DAT_00003b84 = DAT_00003b84 & 0xfffffeff;
    _DAT_00f007fe = DAT_00003b84;
  }
  else if (param_1._1_1_ == '\0') {
    DAT_00003b84 = DAT_00003b84 | 0x100;
    _DAT_00f007fe = DAT_00003b84;
  }
  else if (param_1._1_1_ == 'R') {
    Function_000493C2();
  }
  return;
}

```
