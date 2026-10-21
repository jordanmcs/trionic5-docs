# Function_0005D95E

**ROM:** `0x0005D95E`

```c

void Function_0005D95E(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  byte *pbVar4;
  
  if ((RAM_Samp_pek[0] & 0x10) == 0) {
    RAM_OBD2_frame[0] = RAM_OBD2_frame[0] & 0xbf;
    if (((DAT_0000405e < 10) || (0xfc < DAT_0000405e)) && ((RAM_Samp_pek[4] & 2) != 0)) {
      RAM_OBD2_frame[0] = RAM_OBD2_frame[0] | 0x40;
    }
    else {
      DAT_00001a70 = DAT_00001a58;
    }
    if (((RAM_Trot_delta < 0xd) || (0x31 < RAM_Trot_delta)) && ((RAM_Samp_pek[4] & 2) != 0)) {
      RAM_OBD2_frame[0] = RAM_OBD2_frame[0] | 0x40;
    }
    else {
      RAM_Sond_tid_konst = DAT_00001a58;
    }
    if (0xfc < DAT_0000405e) {
      RAM_Samp_pek[5] = RAM_Samp_pek[5] | 0x20;
    }
    pbVar3 = &DAT_00003322;
    if ((((int)DAT_00001a70 + 5U < (uint)DAT_00001a58) ||
        ((int)RAM_Sond_tid_konst + 5U < (uint)DAT_00001a58)) || ((RAM_Samp_pek[0xf] & 8) != 0)) {
      DAT_0000403c = 0;
      RAM_Samp_pek[0] = RAM_Samp_pek[0] | 0x10;
      if ((int)DAT_00001a70 + 5U < (uint)DAT_00001a58) {
        if (DAT_0000405e < 3) {
          DAT_0000403c = 0x40;
        }
        else if (0xfc < DAT_0000405e) {
          DAT_0000403c = 0x80;
        }
      }
      else if (((0x31 < RAM_Trot_delta) || (RAM_Trot_delta < 0xd)) || ((RAM_Samp_pek[0xf] & 8) != 0)
              ) {
        DAT_0000403c = 0x20;
      }
      Function_0005F0B8(&DAT_00003322);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      pbVar4 = RAM_Sync_frame;
      do {
        *(undefined4 *)pbVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        pbVar4 = pbVar4 + 4;
      } while (sVar1 != -1);
      RAM_OBD2_frame[0] = RAM_OBD2_frame[0] | 0x40;
      pbVar3 = extraout_A1;
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e6 = DAT_000040e6 | 4;
      }
    }
    else if (((2000 < (uint)RAM_Crankshaft_error) && ((RAM_Samp_pek[4] & 0x40) == 0)) &&
            (((RAM_Samp_pek[0xb] & 0x40) == 0 && ((RAM_Samp_pek[0xf] & 2) != 0)))) {
      if (DAT_00003322 < 0x28) {
        bVar2 = DAT_00003fe8 >> 6;
      }
      else {
        bVar2 = DAT_00003fe8 >> 5;
      }
      if (((bVar2 & 1) != 0) && (DAT_00003322 != 0)) {
        DAT_00003322 = DAT_00003322 - 1;
        RAM_Samp_pek[4] = RAM_Samp_pek[4] | 0x40;
      }
    }
    if ((RAM_OBD2_frame[0] & 0x40) == 0) {
      if (5 < (uint)((int)DAT_00001a58 - RAM_OBD2_frame._2_4_)) {
        RAM_OBD2_frame[0] = RAM_OBD2_frame[0] & 0x7f;
      }
    }
    else {
      RAM_OBD2_frame[2] = DAT_00001a58[0];
      RAM_OBD2_frame[3] = DAT_00001a58[1];
      RAM_OBD2_frame[4] = DAT_00001a58[2];
      RAM_OBD2_frame[5] = DAT_00001a58[3];
      RAM_OBD2_frame[0] = RAM_OBD2_frame[0] | 0x80;
    }
    if (*pbVar3 == 0) {
      DAT_0000403c = 0;
      DAT_000040e6 = DAT_000040e6 & 0xfb;
    }
  }
  return;
}

```
