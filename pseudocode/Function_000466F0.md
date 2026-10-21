# Function_000466F0

**ROM:** `0x000466F0`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000466F0(uint param_1)

{
  uint uVar1;
  
  uVar1 = 0x50036 / (param_1 & 0xffff);
  _DAT_00ffffd6 = (short)uVar1;
  _DAT_00ffffd4 = _DAT_00ffffd6 - (short)(((uVar1 & 0xffff) * (param_1 >> 0x10)) / 1000);
  return;
}

```
