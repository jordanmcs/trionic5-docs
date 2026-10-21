# Function_0004DF30

**ROM:** `0x0004DF30`

```c

void Function_0004DF30(void)

{
  ushort uVar1;
  
  if (RAM_PMProt == 0) {
    DAT_00003ee6 = DAT_00003ee6 & 0xfe;
    DAT_00003ee7 = DAT_00003ee7 | 0x80;
  }
  else {
    uVar1 = DAT_000074ee;
    if (RAM_PMProt < DAT_000074ee) {
      uVar1 = RAM_PMProt;
    }
    RAM_PMProt = RAM_PMProt - uVar1;
    if ((ushort)(RAM_PMCal_Numberccv_ + RAM_PMProt_TestCounter) < RAM_PMProt_RpmIdleNomRef) {
      DAT_00003ee7 = DAT_00003ee7 | 4;
    }
    if (RAM_PMProt_RpmIdleNomRef < (ushort)(RAM_PMProt_TestCounter - RAM_PMCal_Numberccv_)) {
      DAT_00003ee7 = DAT_00003ee7 | 4;
    }
  }
  return;
}

```
