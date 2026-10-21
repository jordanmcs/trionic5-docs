# Function_0004D0FA

**ROM:** `0x0004D0FA`

```c

void Function_0004D0FA(void)

{
  ushort uVar1;
  
  if (RAM_PMProt == 0) {
    DAT_00003ee6 = DAT_00003ee6 & 0xfb | 0x10;
  }
  else {
    uVar1 = DAT_000074c6;
    if (RAM_PMProt < DAT_000074c6) {
      uVar1 = RAM_PMProt;
    }
    RAM_PMProt = RAM_PMProt - uVar1;
  }
  return;
}

```
