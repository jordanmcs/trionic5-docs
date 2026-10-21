# Function_00044E12

**ROM:** `0x00044E12`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00044E12(undefined4 param_1)

{
  if (param_1._1_1_ == 'O') {
    DAT_00003b84 = DAT_00003b84 | 0x8000;
    _DAT_00f007fe = DAT_00003b84;
  }
  else if (param_1._1_1_ == 'I') {
    DAT_00003b84 = DAT_00003b84 & 0xffff7fff;
    _DAT_00f007fe = DAT_00003b84;
  }
  return;
}

```
