# Function_0005A4F4

**ROM:** `0x0005A4F4`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0005A4F4(void)

{
  char cVar2;
  short sVar1;
  byte *extraout_A1;
  byte *extraout_A1_00;
  byte *pbVar3;
  byte *extraout_A1_01;
  
  if ((DAT_00006e20 & 1) == 0) {
    if (DAT_00003884 != '\x01') {
      if ((RAM_Samp_pek[1] & 2) == 0) {
        DAT_00004084 = DAT_00004052;
        DAT_00004086 = DAT_00004056;
        DAT_0000409a = DAT_0000405e;
        DAT_0000197a = 0;
        Function_0005E8A6();
        pbVar3 = extraout_A1;
        if ((DAT_000038c4 & 8) == 0) {
          Function_00044CC2();
          pbVar3 = extraout_A1_00;
        }
        DAT_00003334 = 0;
        DAT_00003333 = 0;
        DAT_000040a6 = DAT_0000101c;
        RAM_S_Kyl_temp = DAT_0000102e;
        if (DAT_00003c32 == 0) {
          DAT_00001136 = DAT_00001013;
        }
        else {
          DAT_00001136 = 0x50;
        }
        if (((short)(char)DAT_0000102e < (short)((char)*pbVar3 + 10)) &&
           ((short)((char)*pbVar3 + -10) < (short)(char)DAT_0000102e)) {
          RAM_Samp_pek[3] = RAM_Samp_pek[3] | 0x80;
          RAM_Start_kylv = *pbVar3;
        }
        else {
          DAT_00004028 = DAT_0000102e;
          DAT_00004026 = *pbVar3;
          RAM_Start_kylv = *pbVar3;
        }
        DAT_00001077 = DAT_0000102e;
        if (DAT_0000331e != 0) {
          DAT_0000331e = DAT_0000331e - 1;
        }
        cVar2 = Function_0004F8F4();
        if (cVar2 == 'E') {
          RAM_VSS2_error = 0x2c;
        }
        if ((((DAT_00006e20 & 0x20) != 0) || ((char)DAT_0000102e < '\0')) ||
           ('(' < (char)DAT_0000102e)) {
          RAM_Purge_freq = RAM_Purge_freq | 0x84;
        }
        Function_0006A074();
      }
      else {
        RAM_Samp_pek[1] = RAM_Samp_pek[1] & 0xfd;
        if (DAT_0000331e < 0x32) {
          DAT_0000331e = 0x32;
        }
      }
    }
    DAT_0000334f = Function_00044D8E();
    if ((DAT_00001039 & 1) == 0) {
      DAT_00001077 = DAT_0000102e;
      RAM_Start_kylv = RAM_Last;
      if (DAT_00003c32 == 0) {
        DAT_00001136 = DAT_00001013;
      }
      else {
        DAT_00001136 = 0x50;
      }
      if ((DAT_000038c4 & 8) == 0) {
        Function_00044CC2();
      }
    }
    else {
      if (((DAT_00001039 & 8) == 0) || ((DAT_00001039 & 4) != 0)) {
        RAM_Samp_pek[4] = RAM_Samp_pek[4] & 0xfd;
        RAM_Diag_tid[0] = DAT_00001a58[0];
        RAM_Diag_tid[1] = DAT_00001a58[1];
        RAM_Diag_tid[2] = DAT_00001a58[2];
        RAM_Diag_tid[3] = DAT_00001a58[3];
        DAT_00003780 = 0;
        sVar1 = Function_00044BA4();
        DAT_00003782 = sVar1 != 1;
        DAT_0000377c = 0;
        DAT_0000377e = 0;
      }
      else {
        RAM_Samp_pek[4] = RAM_Samp_pek[4] | 2;
      }
      if ((DAT_00006e20 & 0x80) == 0) {
        if (((RAM_Samp_pek[4] & 2) != 0) && (5 < (uint)DAT_00001a58)) {
          DAT_00003fe8 = DAT_00003fe8 | 0xe0;
        }
      }
      else {
        if ((((RAM_Samp_pek[8] & 0x40) != 0) && ((RAM_Samp_pek[8] & 0x10) != 0)) &&
           (((RAM_n_Engine_delta_180[1] & 8) != 0 &&
            ((((((DAT_00003ee6 & 0x80) != 0 || ((RAM_Samp_pek[0xd] & 4) != 0)) &&
               ((RAM_BrakeCnt._0_1_ & 0x80) != 0)) &&
              (((RAM_Samp_pek[2] & 0x80) != 0 && ((RAM_Samp_pek[9] & 0x40) != 0)))) &&
             ((RAM_Samp_pek[9] & 0x20) != 0)))))) {
          DAT_00003fe8 = DAT_00003fe8 | 0x80;
        }
        if ((((RAM_Samp_pek[4] & 2) != 0) &&
            ((short)((char)DAT_00001077 + 0x16) <= (short)(char)DAT_0000102e)) &&
           ('F' < (char)DAT_0000102e)) {
          DAT_00003fe8 = DAT_00003fe8 | 0x40;
        }
        if ((((RAM_Samp_pek[4] & 2) != 0) && ((DAT_0000103c & 2) != 0)) &&
           ((DAT_00003fe8 >> 5 & 1) == 0)) {
          DAT_00003fe8 = DAT_00003fe8 | 0x20;
          DAT_000040c0 = DAT_000040c0 + '\x01';
        }
      }
      if ((DAT_000040e0 < 2) && (DAT_00003880 == '\0')) {
        if ((RAM_n_Engine_delta_180[1] & 8) != 0) {
          DAT_000040e0 = DAT_000040e0 + 1;
          DAT_00003880 = '\x01';
        }
      }
      else if ((1 < DAT_000040e0) && ((RAM_n_Engine_delta_180[1] & 8) != 0)) {
        DAT_00003fe6 = DAT_00003fe6 | 0x80;
      }
      if ((DAT_000040de < 2) && (DAT_0000387e == '\0')) {
        if ((DAT_00003ee6 & 0x80) != 0) {
          DAT_000040de = DAT_000040de + 1;
          DAT_0000387e = '\x01';
        }
      }
      else if ((1 < DAT_000040de) && ((DAT_00003ee6 & 0x80) != 0)) {
        DAT_00003fe6 = DAT_00003fe6 | 0x40;
      }
      if ((RAM_Samp_pek[0x10] & 4) != 0) {
        DAT_00003fe6 = DAT_00003fe6 | 0x40;
      }
      if ((DAT_000040e2 < 2) && (DAT_00003882 == '\0')) {
        if (((RAM_Samp_pek[8] & 0x40) != 0) && ((RAM_Samp_pek[8] & 0x10) != 0)) {
          DAT_000040e2 = DAT_000040e2 + 1;
          DAT_00003882 = '\x01';
        }
      }
      else if ((1 < DAT_000040e2) &&
              (((RAM_Samp_pek[8] & 0x40) != 0 && ((RAM_Samp_pek[8] & 0x10) != 0)))) {
        DAT_00003fe6 = DAT_00003fe6 | 0x20;
      }
      if ((DAT_000040dc < 2) && (DAT_0000387c == '\0')) {
        if (((RAM_Samp_pek[9] & 0x40) != 0) && ((RAM_Samp_pek[9] & 0x20) != 0)) {
          DAT_000040dc = DAT_000040dc + 1;
          RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] | 2;
          DAT_0000387c = '\x01';
        }
      }
      else if ((1 < DAT_000040dc) &&
              (((RAM_Samp_pek[9] & 0x40) != 0 && ((RAM_Samp_pek[9] & 0x20) != 0)))) {
        DAT_00003fe6 = DAT_00003fe6 | 0x10;
        RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] | 2;
      }
      Function_0005BC56();
      Function_0005DEE4();
      Function_0005ADC8();
      Function_0005C9AE();
      Function_0005D95E();
      Function_0005B21C();
      Function_0005B80A();
      Function_0005DBAE();
      if ((RAM_Ramp_steg_[3] & 8) == 0) {
        Function_0005C062();
      }
      if ((DAT_00006e20 & 0x20) == 0) {
        Function_0005D0C6();
      }
      else {
        DAT_00004044 = 0;
      }
      Function_0005C34A();
      if ((RAM_Ramp_steg_[3] & 8) != 0) {
        Function_0005D6F0();
      }
      Function_0005B6B8();
      Function_0005B0CA();
      if ((RAM_Ramp_steg_[4] & 8) != 0) {
        Function_0005AC54();
      }
      if ((RAM_Ramp_steg_[5] & 0x80) != 0) {
        Function_0005BF3C();
      }
      if ((RAM_Samp_pek[8] & 2) == 0) {
        if ((DAT_00006e20 & 0x20) != 0) {
          Function_0004D1E0();
        }
        Function_0004CB90();
        Function_0005E360();
        Function_0005C6D4();
        Function_0005C4CC();
        Function_0005D2DC();
        Function_0005D7E0();
        Function_0005BAF8();
        Function_0005B5AE();
        Function_0005AF78();
        Function_0005E55E();
        Function_00068F74();
      }
      Function_0004B97E();
      Function_0006A074();
      if (DAT_00001d22 == '\0') {
        DAT_000040a2 = 0;
      }
      if (DAT_00001d23 == '\0') {
        DAT_000040a0 = 0;
      }
      if (DAT_0000332f == '\0') {
        DAT_0000409e = 0;
      }
      if (RAM_Sond_error == 0) {
        DAT_0000409c = 0;
      }
      if ((DAT_00006e20 & 0x80) == 0) {
        *extraout_A1_01 = *extraout_A1_01 | 2;
        RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] & 0xbf;
      }
      else if ((DAT_00006e20 & 4) == 0) {
        *extraout_A1_01 = *extraout_A1_01 & 0xfd;
        RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] & 0xbf;
      }
      else if (((((char)RAM_Last < -7) || ((char)DAT_0000102e < -7)) || (DAT_00001136 < 0x4e)) &&
              ((*extraout_A1_01 & 2) == 0)) {
        RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] | 0x40;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] & 0xbf;
      }
      if ((DAT_00006e20 & 0x80) != 0) {
        if (DAT_00004068 < (char *)0x8000) {
          if ((*DAT_00004068 == '\0') && (DAT_00004068 != (char *)0x0)) {
            DAT_00004068 = (char *)0x0;
          }
        }
        else {
          DAT_00004068 = (char *)0x0;
        }
      }
    }
    DAT_00003884 = '\x01';
  }
  else if ((DAT_000038c4 & 8) == 0) {
    Function_00044CC2();
  }
  return;
}

```
