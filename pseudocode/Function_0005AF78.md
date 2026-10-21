# Function_0005AF78

**ROM:** `0x0005AF78`

```c

void Function_0005AF78(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[8] & 8) == 0) {
    if (((RAM_Samp_pek[10] & 0x80) == 0) || ((RAM_Samp_pek[0] & 0x20) != 0)) {
      if ((((RAM_Samp_pek[8] & 4) == 0) &&
          ((((RAM_Samp_pek[0xb] & 0x40) == 0 && (DAT_00001013 < 100)) &&
           ((RAM_Samp_pek[0xc] & 0x40) != 0)))) && ((RAM_Samp_pek[0xc] & 0x10) == 0)) {
        if (DAT_0000332a < 0x28) {
          bVar2 = DAT_00003fe8 >> 6;
        }
        else {
          bVar2 = DAT_00003fe8 >> 5;
        }
        if ((bVar2 & 1) != 0) {
          if (DAT_0000332a != 0) {
            DAT_0000332a = DAT_0000332a - 1;
            RAM_Samp_pek[8] = RAM_Samp_pek[8] | 4;
          }
          DAT_00004074 = DAT_00001a58;
          return;
        }
      }
      DAT_00004074 = DAT_00001a58;
      if (DAT_0000332a == 0) {
        DAT_000040e5 = DAT_000040e5 & 0xfb;
      }
      if (0x78 < DAT_00001013) {
        RAM_Samp_pek[0xc] = RAM_Samp_pek[0xc] | 0x40;
      }
    }
    else if (DAT_00004074 + 0x1e < DAT_00001a58) {
      RAM_Samp_pek[8] = RAM_Samp_pek[8] | 8;
      Function_0005F0B8(&DAT_0000332a);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_00001efe;
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
        DAT_000040e5 = DAT_000040e5 | 4;
      }
    }
  }
  return;
}

```
