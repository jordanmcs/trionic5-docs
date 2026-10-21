# Function_0004CB90

**ROM:** `0x0004CB90`

```c

void Function_0004CB90(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[10] & 0x40) == 0) {
    if ((DAT_00003ea0 & 0x10) == 0) {
      if ((((RAM_Samp_pek[10] & 0x20) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) &&
         (10 < DAT_00001a58)) {
        if (DAT_0000332b < 0x28) {
          bVar2 = DAT_00003fe8 >> 6;
        }
        else {
          bVar2 = DAT_00003fe8 >> 5;
        }
        if ((bVar2 & 1) != 0) {
          if (DAT_0000332b == 0) {
            return;
          }
          RAM_Samp_pek[10] = RAM_Samp_pek[10] | 0x20;
          DAT_0000332b = DAT_0000332b - 1;
          return;
        }
      }
      if (DAT_0000332b == 0) {
        DAT_000040e6 = DAT_000040e6 & 0xfe;
      }
    }
    else {
      RAM_Samp_pek[10] = RAM_Samp_pek[10] | 0x40;
      Function_0005F0B8(&DAT_0000332b);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_00001f9a;
      do {
        *puVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        puVar4 = puVar4 + 1;
      } while (sVar1 != -1);
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e6 = DAT_000040e6 | 1;
      }
    }
  }
  return;
}

```
