# Function_0005B5AE

**ROM:** `0x0005B5AE`

```c

void Function_0005B5AE(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[2] & 2) == 0) {
    if (((RAM_n_Engine_delta_180[1] & 8) == 0) || ((RAM_n_Engine_delta_180[1] & 0x10) == 0)) {
      if (((RAM_Samp_pek[3] & 0x20) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        if (DAT_00003329 < 0x28) {
          bVar2 = DAT_00003fe8 >> 6 & 1;
        }
        else if (((DAT_00003fe8 & 0x20) == 0) || ((RAM_n_Engine_delta_180[1] & 8) == 0)) {
          bVar2 = 0;
        }
        else {
          bVar2 = 1;
        }
        if (bVar2 != 0) {
          if (DAT_00003329 == 0) {
            return;
          }
          RAM_Samp_pek[3] = RAM_Samp_pek[3] | 0x20;
          DAT_00003329 = DAT_00003329 - 1;
          return;
        }
      }
      if (DAT_00003329 == 0) {
        DAT_000040e4 = DAT_000040e4 & 0x7f;
      }
    }
    else {
      RAM_Samp_pek[2] = RAM_Samp_pek[2] | 2;
      Function_0005F0B8(&DAT_00003329);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_00001e62;
      do {
        *puVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        puVar4 = puVar4 + 1;
      } while (sVar1 != -1);
      if ((DAT_00003329 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        DAT_00003329 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        DAT_00003329 = 0x2c;
        DAT_000040e4 = DAT_000040e4 | 0x80;
      }
    }
  }
  return;
}

```
