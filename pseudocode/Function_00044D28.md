# Function_00044D28

**ROM:** `0x00044D28`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00044D28(undefined4 param_1)

{
  if (param_1._1_1_ == '\x01') {
    DAT_00003b84 = DAT_00003b84 & 0xfffffbff;
    _DAT_00f007fe = DAT_00003b84;
  }
  else if (param_1._1_1_ == '\0') {
    DAT_00003b84 = DAT_00003b84 | 0x400;
    _DAT_00f007fe = DAT_00003b84;
  }
  else if (param_1._1_1_ == 'R') {
    Function_000493C2();
  }
  return;
}

```
