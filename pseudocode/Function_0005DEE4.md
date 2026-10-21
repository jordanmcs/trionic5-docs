# Function_0005DEE4

**ROM:** `0x0005DEE4`

```c

void Function_0005DEE4(void)

{
  byte bVar1;
  byte abVar2 [4];
  short sVar3;
  byte *pbVar4;
  byte *extraout_A1;
  undefined4 *puVar5;
  
  if ((RAM_Samp_pek[0] & 0x80) == 0) {
    if ((DAT_00001a60 == 0) && ((DAT_00006e20 & 0x80) != 0)) {
      if ((((char)RAM_S_Kyl_temp < '\v') || ((char)RAM_Start_kylv < '\v')) &&
         (((((DAT_0000103a & 0x80) == 0 && ((DAT_0000103a & 0x40) == 0)) &&
           ((DAT_0000103a & 0x20) == 0)) && ((DAT_0000103a & 0x10) == 0)))) {
        RAM_Airpump_time = (byte  [4])((int)DAT_00001a58 - (int)RAM_Diag_tid);
        if ((DAT_00001137 & 0x20) == 0) {
          if (DAT_00001ab4 == DAT_000040d8) {
            if (DAT_00001a58 != (byte  [4])0x0) {
              DAT_000040d0 = (int)DAT_00001a58 - 1;
            }
            DAT_00001ab4 = DAT_000040d8 + ((int)DAT_00001a58 - DAT_000040d0);
          }
          else {
            DAT_00001ab4 = DAT_000040d8 + ((int)DAT_00001a58 - DAT_000040d0);
          }
        }
        else {
          DAT_000040d8 = DAT_00001ab4;
        }
      }
      else if (('\n' < (char)RAM_S_Kyl_temp) ||
              ((('\n' < (char)RAM_Start_kylv && ((DAT_0000103a & 0x80) == 0)) &&
               (((DAT_0000103a & 0x40) == 0 &&
                (((DAT_0000103a & 0x20) == 0 && ((DAT_0000103a & 0x10) == 0)))))))) {
        DAT_00001ab0 = (int)DAT_00001a58 - (int)RAM_Diag_tid;
        if ((DAT_00001137 & 0x20) == 0) {
          if (DAT_00001ab8 == DAT_000040d4) {
            if (DAT_00001a58 != (byte  [4])0x0) {
              DAT_000040d0 = (int)DAT_00001a58 - 1;
            }
            DAT_00001ab8 = DAT_000040d4 + ((int)DAT_00001a58 - DAT_000040d0);
          }
          else {
            DAT_00001ab8 = DAT_000040d4 + ((int)DAT_00001a58 - DAT_000040d0);
          }
        }
        else {
          DAT_000040d4 = DAT_00001ab8;
        }
      }
      abVar2[0] = 0;
      abVar2[1] = 0;
      abVar2._2_2_ = RAM_Cat_hl_air_flow_min_;
      if (((((uint)abVar2 < (uint)RAM_Airpump_time) || (RAM_Cl_timer1_lim_ < DAT_00001ab0)) ||
          (300 < DAT_00001ab4)) || (0x78 < DAT_00001ab8)) {
        RAM_Samp_pek[0xf] = RAM_Samp_pek[0xf] | 1;
      }
    }
    if ((((RAM_Samp_pek[8] & 2) == 0) || ((DAT_00006e20 & 0x80) == 0)) &&
       (((RAM_Samp_pek[2] & 0x80) == 0 && ((RAM_Samp_pek[4] & 2) != 0)))) {
      if ((0x14 < DAT_0000101c) && (DAT_0000402a != DAT_00001a58)) {
        DAT_00001a80 = DAT_00001a80 + 1;
        DAT_0000402a = DAT_00001a58;
      }
      if ((400 < DAT_00001a80) || ('\'' < DAT_0000102e)) {
        if ((DAT_0000102e < '(') && ((short)(DAT_0000102e + -0x14) < (short)DAT_00001077)) {
          RAM_Samp_pek[2] = RAM_Samp_pek[2] | 0x40;
          RAM_OBD2_frame[0xc] = RAM_OBD2_frame[0xc] | 0x40;
        }
        RAM_Samp_pek[2] = RAM_Samp_pek[2] | 0x80;
      }
    }
    if ((DAT_00004054 < 4) ||
       (((0xef < DAT_00004054 && (-0x15 < (char)RAM_Last)) && ((RAM_Samp_pek[0] & 0x40) == 0)))) {
      RAM_OBD2_frame[0xc] = RAM_OBD2_frame[0xc] | 0x40;
    }
    else {
      RAM_Luft_tid_end = DAT_00001a58;
    }
    pbVar4 = &DAT_0000331f;
    if ((((int)RAM_Luft_tid_end + 5U < (uint)DAT_00001a58) || ((RAM_Samp_pek[2] & 0x40) != 0)) ||
       ((RAM_Samp_pek[0xf] & 1) != 0)) {
      DAT_0000403a = 0;
      RAM_Samp_pek[0] = RAM_Samp_pek[0] | 0x80;
      if (DAT_00004054 < 3) {
        DAT_0000403a = 0x40;
      }
      else if (DAT_00004054 < 0xf0) {
        if ((RAM_Samp_pek[2] & 0x40) == 0) {
          if ((RAM_Samp_pek[0xf] & 1) != 0) {
            DAT_0000403a = 0x10;
          }
        }
        else {
          DAT_0000403a = 0x20;
        }
      }
      else {
        DAT_0000403a = 0x80;
      }
      Function_0005F0B8(&DAT_0000331f);
      sVar3 = 0x24;
      pbVar4 = RAM_Crankshaft_frame;
      puVar5 = &DAT_000025b2;
      do {
        *puVar5 = *(undefined4 *)pbVar4;
        sVar3 = sVar3 + -1;
        pbVar4 = pbVar4 + 4;
        puVar5 = puVar5 + 1;
      } while (sVar3 != -1);
      RAM_OBD2_frame[0xc] = RAM_OBD2_frame[0xc] | 0x40;
      pbVar4 = extraout_A1;
      if (((RAM_Samp_pek[0xb] & 0x40) == 0) && (*extraout_A1 < 0x28)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e5 = DAT_000040e5 | 0x80;
      }
    }
    else if (((((RAM_Samp_pek[2] & 0x80) != 0) && ((RAM_Samp_pek[2] & 0x40) == 0)) &&
             ((RAM_Samp_pek[4] & 0x20) == 0)) &&
            ((2 < DAT_00001a60 && ((RAM_Samp_pek[0xb] & 0x40) == 0)))) {
      if (DAT_0000331f < 0x28) {
        bVar1 = DAT_00003fe8 >> 6 & 1;
      }
      else if (((DAT_00003fe8 & 0x20) == 0) || ((uint)DAT_00001a58 < 0xb)) {
        bVar1 = 0;
      }
      else {
        bVar1 = 1;
      }
      if ((bVar1 != 0) && (DAT_0000331f != 0)) {
        DAT_0000331f = DAT_0000331f - 1;
        RAM_Samp_pek[4] = RAM_Samp_pek[4] | 0x20;
      }
    }
    if ((RAM_OBD2_frame[0xc] & 0x40) == 0) {
      if (5 < (uint)((int)DAT_00001a58 - RAM_OBD2_frame._14_4_)) {
        RAM_OBD2_frame[0xc] = RAM_OBD2_frame[0xc] & 0x7f;
      }
    }
    else {
      RAM_OBD2_frame[0xe] = DAT_00001a58[0];
      RAM_OBD2_frame[0xf] = DAT_00001a58[1];
      RAM_OBD2_frame[0x10] = DAT_00001a58[2];
      RAM_OBD2_frame[0x11] = DAT_00001a58[3];
      RAM_OBD2_frame[0xc] = RAM_OBD2_frame[0xc] | 0x80;
    }
    if (*pbVar4 == 0) {
      DAT_0000403a = 0;
      DAT_000040e5 = DAT_000040e5 & 0x7f;
    }
  }
  return;
}

```
