# Function_000469FC

**ROM:** `0x000469FC`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000469FC(uint param_1)

{
  if (param_1._1_1_ == 'S') {
    Function_000468F8();
  }
  else {
    _DAT_00ffff94 = 0xccd - (short)(((param_1 & 0xffff) * 0xccd) / 1000);
  }
  return;
}

```
