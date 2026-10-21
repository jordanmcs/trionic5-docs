# Function_0004CAC8

**ROM:** `0x0004CAC8`

```c

void Function_0004CAC8(void)

{
  byte bVar1;
  byte *extraout_A1;
  
  if ((DAT_00001039 & 1) != 0) {
    DAT_00003ea6 = DAT_00003ea6 * '\x02';
    bVar1 = Function_000448EE();
    *extraout_A1 = bVar1 | *extraout_A1;
    if ((*extraout_A1 & 7) == 7) {
      DAT_00003ea0 = DAT_00003ea0 | 0x40;
    }
    if ((*extraout_A1 & 7) == 0) {
      DAT_00003ea0 = DAT_00003ea0 & 0xbf;
    }
    if (((DAT_00003ea0 >> 5 & 1) == 1) && ((DAT_00003ea0 >> 6 & 1) == 0)) {
      DAT_00003ea2 = DAT_00003634;
      DAT_00003ea0 = DAT_00003ea0 | 0x80;
    }
    if (DAT_00003ea2 + 0x9c4 < DAT_00003634) {
      DAT_00003ea0 = DAT_00003ea0 & 0x7f;
    }
    if ((DAT_00003ea2 + 0x9c4 < DAT_00003634) && ((DAT_00003ea0 >> 6 & 1) == 0)) {
      DAT_00003ea0 = DAT_00003ea0 | 0x10;
    }
    DAT_00003ea0 = (DAT_00003ea0 >> 6 & 1) << 5 | DAT_00003ea0 & 0xdf;
  }
  return;
}

```
