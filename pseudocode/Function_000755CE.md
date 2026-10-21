# Function_000755CE

**ROM:** `0x000755CE`

```c

uint Function_000755CE(void)

{
  uint in_D0;
  uint uVar1;
  
  if (DAT_00003a96 == 7) {
    uVar1 = 1;
  }
  else {
    if (DAT_00003a96 != 9) {
      uVar1 = Function_000755B8();
      return uVar1;
    }
    uVar1 = in_D0 & 0xffff0000;
  }
  return uVar1;
}

```
