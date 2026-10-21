# Function_0005BAF8

**ROM:** `0x0005BAF8`

```c

void Function_0005BAF8(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[1] & 0x10) == 0) {
    if ((RAM_Samp_pek[6] & 4) == 0) {
      if (((RAM_Samp_pek[5] & 0x80) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        if (DAT_00001d21 < 0x28) {
          bVar2 = DAT_00003fe8 >> 6 & 1;
        }
        else if (((DAT_00003fe8 & 0x20) == 0) || ((RAM_Samp_pek[8] & 0x40) == 0)) {
          bVar2 = 0;
        }
        else {
          bVar2 = 1;
        }
        if ((bVar2 != 0) && (DAT_00001d21 != 0)) {
          DAT_00001d21 = DAT_00001d21 - 1;
          RAM_Samp_pek[5] = RAM_Samp_pek[5] | 0x80;
        }
      }
    }
    else {
      RAM_Samp_pek[1] = RAM_Samp_pek[1] | 0x10;
      DAT_00004038 = 0x20;
      Function_0005F0B8(&DAT_00001d21);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_00002516;
      do {
        *puVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        puVar4 = puVar4 + 1;
      } while (sVar1 != -1);
      RAM_Samp_pek[5] = RAM_Samp_pek[5] | 1;
      RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] | 0x40;
      if ((DAT_00001d21 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        DAT_00001d21 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        DAT_00001d21 = 0x2c;
        DAT_000040e5 = DAT_000040e5 | 2;
      }
    }
    if ((RAM_OBD2_frame[0x18] & 0x40) == 0) {
      if (5 < (uint)(DAT_00001a58 - RAM_OBD2_frame._26_4_)) {
        RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] & 0x7f;
      }
    }
    else {
      RAM_OBD2_frame[0x1a] = DAT_00001a58._0_1_;
      RAM_OBD2_frame[0x1b] = DAT_00001a58._1_1_;
      RAM_OBD2_frame[0x1c] = DAT_00001a58._2_1_;
      RAM_OBD2_frame[0x1d] = (undefined1)DAT_00001a58;
      RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] | 0x80;
    }
    if ((DAT_00001d21 == 0) && (DAT_00003323 == '\0')) {
      DAT_00004038 = 0;
      DAT_000040e5 = DAT_000040e5 & 0xfd;
    }
  }
  return;
}

```
