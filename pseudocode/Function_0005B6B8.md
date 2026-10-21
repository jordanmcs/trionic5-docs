# Function_0005B6B8

**ROM:** `0x0005B6B8`

```c

void Function_0005B6B8(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[6] & 0x40) == 0) {
    if (((((RAM_Samp_pek[6] & 0x80) == 0) || (RAM_Bil_hast < 0x78)) || (DAT_00001066 < 0x97)) ||
       (((RAM_Spik_count._0_1_ & 8) != 0 || (DAT_0000101c < 0xb)))) {
      if (((RAM_Samp_pek[6] & 0x20) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        if (RAM_Tank_error < 0x28) {
          bVar2 = DAT_00003fe8 >> 6 & 1;
        }
        else if ((((DAT_00003fe8 & 0x20) == 0) || (DAT_00001a58 < 0x3e9)) ||
                ((DAT_0000101c < 0x1f || ((DAT_00001066 < 0x97 || ((RAM_Samp_pek[6] & 0x80) != 0))))
                )) {
          bVar2 = 0;
        }
        else {
          bVar2 = 1;
        }
        if (bVar2 != 0) {
          if (RAM_Tank_error == 0) {
            return;
          }
          RAM_Samp_pek[6] = RAM_Samp_pek[6] | 0x20;
          RAM_Tank_error = RAM_Tank_error - 1;
          return;
        }
      }
      RAM_Samp_pek[6] = RAM_Samp_pek[6] & 0x7f;
      if (RAM_Tank_error == 0) {
        DAT_000040e4 = DAT_000040e4 & 0xfb;
      }
    }
    else {
      RAM_Samp_pek[6] = RAM_Samp_pek[6] | 0x40;
      Function_0005F0B8(&RAM_Tank_error);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_0000220a;
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
        DAT_000040e4 = DAT_000040e4 | 4;
      }
    }
  }
  else {
    RAM_Samp_pek[6] = RAM_Samp_pek[6] & 0x7f;
  }
  return;
}

```
