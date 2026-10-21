# Function_0005D2DC

**ROM:** `0x0005D2DC`

```c

void Function_0005D2DC(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[6] & 2) == 0) {
    RAM_OBD2_frame[0x1e] = RAM_OBD2_frame[0x1e] & 0xbf;
    if (((DAT_0000103d & 1) == 0) || ((char)RAM_OBD2_frame[0x12] < '\0')) {
      RAM_I_front_time = DAT_00001a58;
      DAT_000040b4 = DAT_00001a58;
    }
    else if (DAT_00003e2a < 500) {
      RAM_OBD2_frame[0x1e] = RAM_OBD2_frame[0x1e] | 0x40;
    }
    else if ((DAT_00003e2a < 0x8fd) || ((uint)DAT_00001a58 <= (int)DAT_000040b4 + 0x3cU)) {
      RAM_I_front_time = DAT_00001a58;
      if ((int)DAT_000040b4 + 0x3cU < (uint)DAT_00001a58) {
        RAM_Samp_pek[9] = RAM_Samp_pek[9] | 0x20;
      }
    }
    else {
      RAM_OBD2_frame[0x1e] = RAM_OBD2_frame[0x1e] | 0x40;
    }
    RAM_Diag_I_front = DAT_00003e2a;
    if (DAT_0000405a < 0x4e2) {
      RAM_Sond_tid_end = DAT_00001a58;
    }
    else {
      RAM_OBD2_frame[0x1e] = RAM_OBD2_frame[0x1e] | 0x40;
    }
    if ((((((RAM_Samp_pek[4] & 2) != 0) && ('F' < DAT_0000102e)) && ((DAT_0000103c & 2) != 0)) &&
        ((DAT_0000101c != '\0' && ((DAT_0000103d & 1) != 0)))) &&
       (((RAM_Samp_pek[8] & 0x10) == 0 &&
        (((RAM_Samp_pek[0xb] & 0x10) == 0 && (400 < DAT_0000405a)))))) {
      RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] | 0x10;
    }
    if (((((RAM_Samp_pek[4] & 2) == 0) || (DAT_0000102e < 'G')) || ((DAT_0000103c & 2) == 0)) ||
       (((DAT_0000101c == '\0' || ((DAT_0000103d & 1) == 0)) || ((RAM_Samp_pek[8] & 0x10) != 0)))) {
      DAT_000034da = RAM_U_lambda_eng;
    }
    else {
      if (DAT_00001a58 != DAT_000034dc) {
        RAM_Ox2_change = RAM_Ox2_change + 1;
        DAT_000034dc = DAT_00001a58;
        if (RAM_U_lambda_eng < DAT_000034da) {
          sVar1 = DAT_000034da - RAM_U_lambda_eng;
        }
        else {
          sVar1 = RAM_U_lambda_eng - DAT_000034da;
        }
        RAM_MisCountMap4 = sVar1 + RAM_MisCountMap4;
        DAT_000034da = RAM_U_lambda_eng;
        if (DAT_00003870 < RAM_U_lambda_eng) {
          DAT_00003870 = RAM_U_lambda_eng;
        }
        else if (RAM_U_lambda_eng < DAT_00003872) {
          DAT_00003872 = RAM_U_lambda_eng;
        }
      }
      if ((DAT_000074c2 <= RAM_Ox2_change) ||
         ((RAM_Ox2_activity_time_lim_ < RAM_MisCountMap4 && ((RAM_Samp_pek[0xb] & 0x10) != 0)))) {
        if ((RAM_Ox2_activity_time_lim_ < RAM_MisCountMap4) && ((RAM_Samp_pek[0xb] & 0x10) != 0)) {
          RAM_Samp_pek[8] = RAM_Samp_pek[8] | 0x30;
        }
        else {
          RAM_Samp_pek[8] = RAM_Samp_pek[8] | 0x10;
        }
      }
    }
    pbVar3 = &RAM_Sync_error;
    if ((((int)RAM_I_front_time + 5U < (uint)DAT_00001a58) ||
        ((int)RAM_Sond_tid_end + 5U < (uint)DAT_00001a58)) ||
       (((RAM_Samp_pek[8] & 0x10) != 0 && ((RAM_Samp_pek[8] & 0x20) == 0)))) {
      RAM_Samp_pek[6] = RAM_Samp_pek[6] | 2;
      if ((int)RAM_I_front_time + 5U < (uint)DAT_00001a58) {
        DAT_00004036 = 8;
        if (DAT_00003e2a < 0x8fd) {
          if (DAT_00003e2a < 500) {
            DAT_00004036 = 10;
          }
        }
        else {
          DAT_00004036 = 0xc;
        }
        RAM_Samp_pek[9] = RAM_Samp_pek[9] | 0x20;
      }
      else if ((int)RAM_Sond_tid_end + 5U < (uint)DAT_00001a58) {
        DAT_00004036 = 0x40;
      }
      else {
        DAT_00004036 = 0x10;
      }
      Function_0005F0B8(&RAM_Sync_error);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_000029f6;
      do {
        *puVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        puVar4 = puVar4 + 1;
      } while (sVar1 != -1);
      RAM_OBD2_frame[0x1e] = RAM_OBD2_frame[0x1e] | 0x40;
      pbVar3 = extraout_A1;
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        DAT_000040e4 = DAT_000040e4 | 1;
        *extraout_A1 = 0x2c;
      }
    }
    else if (((RAM_Samp_pek[6] & 1) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
      if (RAM_Sync_error < 0x28) {
        bVar2 = DAT_00003fe8 >> 6 & 1;
      }
      else if (((DAT_00003fe8 & 0x20) == 0) || ((RAM_Samp_pek[8] & 0x10) == 0)) {
        bVar2 = 0;
      }
      else {
        bVar2 = 1;
      }
      if ((bVar2 != 0) && (RAM_Sync_error != 0)) {
        RAM_Sync_error = RAM_Sync_error - 1;
        RAM_Samp_pek[6] = RAM_Samp_pek[6] | 1;
      }
    }
    if ((RAM_OBD2_frame[0x1e] & 0x40) == 0) {
      if (5 < (uint)((int)DAT_00001a58 - RAM_OBD2_frame._32_4_)) {
        RAM_OBD2_frame[0x1e] = RAM_OBD2_frame[0x1e] & 0x7f;
      }
    }
    else {
      RAM_OBD2_frame[0x20] = DAT_00001a58[0];
      RAM_OBD2_frame[0x21] = DAT_00001a58[1];
      RAM_OBD2_frame[0x22] = DAT_00001a58[2];
      RAM_OBD2_frame[0x23] = DAT_00001a58[3];
      RAM_OBD2_frame[0x1e] = RAM_OBD2_frame[0x1e] | 0x80;
    }
    if (*pbVar3 == 0) {
      DAT_00004036 = 0;
      DAT_000040e4 = DAT_000040e4 & 0xfe;
    }
  }
  return;
}

```
