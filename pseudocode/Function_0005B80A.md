# Function_0005B80A

**ROM:** `0x0005B80A`

```c

void Function_0005B80A(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  byte *pbVar4;
  
  if ((RAM_Samp_pek[0] & 8) == 0) {
    RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] & 0xbf;
    if (((DAT_0000103d & 2) == 0) || ((char)RAM_OBD2_frame[0x12] < '\0')) {
      RAM_Luft_tid_konst = DAT_00001a58;
      DAT_000040b8 = DAT_00001a58;
    }
    else if (DAT_00003e2c < 500) {
      RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] | 0x40;
    }
    else if ((DAT_00003e2c < 0x8fd) || ((uint)DAT_00001a58 <= (int)DAT_000040b8 + 0x3cU)) {
      RAM_Luft_tid_konst = DAT_00001a58;
      if ((int)DAT_000040b8 + 0x3cU < (uint)DAT_00001a58) {
        RAM_Samp_pek[9] = RAM_Samp_pek[9] | 0x40;
      }
    }
    else {
      RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] | 0x40;
    }
    DAT_00001110 = DAT_00003e2c;
    if ((((RAM_Samp_pek[8] & 2) == 0) && ((RAM_Samp_pek[0xe] & 1) != 0)) &&
       ((DAT_00006bd4 <= DAT_00001999 || (DAT_00006bd4 <= DAT_00001998)))) {
      RAM_Samp_pek[10] = RAM_Samp_pek[10] | 0x10;
    }
    if (DAT_0000405c < 0x4e2) {
      RAM_Hast_tid_grans = DAT_00001a58;
    }
    else {
      RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] | 0x40;
    }
    pbVar3 = &DAT_00003323;
    if ((((int)RAM_Luft_tid_konst + 5U < (uint)DAT_00001a58) ||
        ((int)RAM_Hast_tid_grans + 5U < (uint)DAT_00001a58)) || ((RAM_Samp_pek[10] & 0x10) != 0)) {
      DAT_00004038 = 0;
      RAM_Samp_pek[0] = RAM_Samp_pek[0] | 8;
      if ((int)RAM_Luft_tid_konst + 5U < (uint)DAT_00001a58) {
        DAT_00004038 = 8;
        if (DAT_00003e2c < 0x8fd) {
          if (DAT_00003e2c < 500) {
            DAT_00004038 = 10;
          }
        }
        else {
          DAT_00004038 = 0xc;
        }
        RAM_Samp_pek[9] = RAM_Samp_pek[9] | 0x40;
      }
      else if ((int)RAM_Hast_tid_grans + 5U < (uint)DAT_00001a58) {
        DAT_00004038 = 0x40;
      }
      else if ((RAM_Samp_pek[10] & 0x10) != 0) {
        DAT_00004038 = 1;
      }
      Function_0005F0B8(&DAT_00003323);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      pbVar4 = RAM_Tank_frame;
      do {
        *(undefined4 *)pbVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        pbVar4 = pbVar4 + 4;
      } while (sVar1 != -1);
      RAM_Samp_pek[5] = RAM_Samp_pek[5] | 1;
      RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] | 0x40;
      pbVar3 = extraout_A1;
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e5 = DAT_000040e5 | 0x20;
      }
    }
    else if (((RAM_Samp_pek[3] & 4) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
      if (DAT_00003323 < 0x28) {
        bVar2 = DAT_00003fe8 >> 6 & 1;
      }
      else if (((DAT_00003fe8 & 0x20) == 0) || ((RAM_Samp_pek[8] & 0x40) == 0)) {
        bVar2 = 0;
      }
      else {
        bVar2 = 1;
      }
      if ((bVar2 != 0) && (DAT_00003323 != 0)) {
        DAT_00003323 = DAT_00003323 - 1;
        RAM_Samp_pek[3] = RAM_Samp_pek[3] | 4;
      }
    }
    if ((RAM_OBD2_frame[0x18] & 0x40) == 0) {
      if (5 < (uint)((int)DAT_00001a58 - RAM_OBD2_frame._26_4_)) {
        RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] & 0x7f;
      }
    }
    else {
      RAM_OBD2_frame[0x1a] = DAT_00001a58[0];
      RAM_OBD2_frame[0x1b] = DAT_00001a58[1];
      RAM_OBD2_frame[0x1c] = DAT_00001a58[2];
      RAM_OBD2_frame[0x1d] = DAT_00001a58[3];
      RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] | 0x80;
    }
    if ((*pbVar3 == 0) && (DAT_00001d21 == '\0')) {
      DAT_00004038 = 0;
      DAT_000040e5 = DAT_000040e5 & 0xdf;
    }
  }
  return;
}

```
