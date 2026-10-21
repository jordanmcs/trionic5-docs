# Function_0005C9AE

**ROM:** `0x0005C9AE`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0005C9AE(void)

{
  byte bVar1;
  short sVar2;
  short *psVar3;
  byte *pbVar4;
  byte *extraout_A1;
  undefined4 *puVar5;
  
  if ((RAM_Samp_pek[0] & 0x20) == 0) {
    RAM_OBD2_frame[0x12] = RAM_OBD2_frame[0x12] & 0xbf;
    if ((DAT_00001137 & 0x80) == 0) {
      RAM_P_man_korr = DAT_000061f8;
    }
    else {
      RAM_P_man_korr = DAT_000061fa;
    }
    psVar3 = &DAT_00007580;
    for (bVar1 = 0; ((ushort)(psVar3[1] + *psVar3) >> 1 < RAM_P_man_korr && (bVar1 != 0x11));
        bVar1 = bVar1 + 1) {
      psVar3 = psVar3 + 1;
    }
    DAT_0000111c = RAM_Misftrans_ign_tab_[(short)(ushort)bVar1];
    if ((DAT_00006e20 & 0x80) == 0) {
      RAM_Samp_pek[0xf] = RAM_Samp_pek[0xf] | 2;
    }
    else if (((((RAM_Samp_pek[0xf] & 2) == 0) && (DAT_00001a60 + 200U < DAT_00001a58)) &&
             (0x14 < DAT_0000101c)) && (((DAT_00001137 & 0x40) != 0 && ('F' < DAT_0000102e)))) {
      if (((((DAT_0000103c & 2) == 0) ||
           ((DAT_00001066 <= DAT_000075aa || (RAM_Pur_misadapt_cthr_ <= DAT_00001066)))) ||
          (DAT_00001052 < DAT_000075ae)) ||
         ((((DAT_000075ac < DAT_00001052 || ((ushort)(DAT_00003c32 + 10) < DAT_000040c2)) ||
           (DAT_000040c2 < (ushort)(DAT_00003c32 - 10))) ||
          (((ushort)(DAT_00001013 + 5) < (ushort)DAT_000040c6 ||
           ((short)(ushort)DAT_000040c6 < (short)(DAT_00001013 - 5))))))) {
        _DAT_000040c8 = DAT_00001a58;
        DAT_000040c2 = DAT_00003c32;
        DAT_000040c6 = DAT_00001013;
        DAT_000040cc = DAT_00003b02;
      }
      else if (DAT_000040cc + 1000 < DAT_00003b02) {
        RAM_P_tank_first =
             RAM_P_tank_first + (DAT_00001052 / 10 - (ushort)DAT_00001013) +
             (short)(char)DAT_0000111c;
        DAT_000040c4 = DAT_000040c4 + '\x01';
        DAT_000040c2 = DAT_00003c32;
        DAT_000040c6 = DAT_00001013;
        DAT_000040cc = DAT_00003b02;
      }
      if (DAT_000040c4 == '2') {
        RAM_Press_diff = (short)RAM_P_tank_first / 0x32;
        if ((((short)(char)RAM_Press_press_lim_ < (short)RAM_Press_diff) ||
            ((short)RAM_Press_diff < (short)-(short)(char)RAM_Press_press_lim_)) &&
           (((RAM_Samp_pek[0xc] & 2) == 0 && ((RAM_Samp_pek[0xb] & 8) == 0)))) {
          RAM_Samp_pek[0xf] = RAM_Samp_pek[0xf] | 8;
        }
        else if ((((short)RAM_Press_diff < (short)DAT_000075b0) ||
                 ((((RAM_Samp_pek[0xc] & 2) == 0 || ((DAT_00004048 & 0x40) == 0)) &&
                  (((RAM_Samp_pek[0xb] & 8) == 0 || ((DAT_00004034 & 0x80) == 0)))))) &&
                (((short)-(short)DAT_000075b0 < (short)RAM_Press_diff ||
                 ((((RAM_Samp_pek[0xc] & 2) == 0 || ((DAT_00004048 & 0x80) == 0)) &&
                  (((RAM_Samp_pek[0xb] & 8) == 0 || ((DAT_00004034 & 0x40) == 0)))))))) {
          RAM_Samp_pek[0xf] = RAM_Samp_pek[0xf] | 2;
        }
        else {
          RAM_Samp_pek[0xf] = RAM_Samp_pek[0xf] | 0x10;
        }
        DAT_000040c4 = '\0';
        RAM_P_tank_first = 0;
      }
    }
    if (((((short)(ushort)DAT_00004086 < (short)(DAT_00004056 - 1)) ||
         ((ushort)(DAT_00004056 + 1) < (ushort)DAT_00004086)) || ((RAM_Samp_pek[4] & 2) == 0)) ||
       ((char)RAM_OBD2_frame[0] < '\0')) {
      DAT_00004086 = DAT_00004056;
      DAT_00001a8c = DAT_00001a58;
      DAT_00004094 = DAT_0000405e;
      DAT_00004096 = DAT_0000405e;
      DAT_00004098 = 0;
    }
    else {
      if (DAT_00004094 < DAT_0000405e) {
        DAT_00004094 = DAT_0000405e;
      }
      else if (DAT_0000405e < DAT_00004096) {
        DAT_00004096 = DAT_0000405e;
      }
      DAT_00004098 = DAT_00004094 - DAT_00004096;
    }
    if ((DAT_00004098 < 0x10) || (100 < DAT_0000405e)) {
      DAT_00003858 = DAT_00001a58;
    }
    if (((DAT_00004056 < 0xb) && (99 < DAT_0000405e)) && (-1 < (char)RAM_OBD2_frame[0])) {
      RAM_OBD2_frame[0x12] = RAM_OBD2_frame[0x12] | 0x40;
    }
    else if (((DAT_00004056 < 0xf5) || (0x5a < DAT_0000405e)) || ((char)RAM_OBD2_frame[0] < '\0')) {
      DAT_00001a74 = DAT_00001a58;
    }
    else {
      RAM_OBD2_frame[0x12] = RAM_OBD2_frame[0x12] | 0x40;
    }
    if (((-1 < (char)RAM_OBD2_frame[6]) && (DAT_00001a58 == 2)) &&
       ((DAT_0000101c == 0 && ((DAT_00001136 < 0x32 || (0x8c < DAT_00001136)))))) {
      RAM_Samp_pek[4] = RAM_Samp_pek[4] | 1;
    }
    if ((((((DAT_0000102e < '=') || (DAT_00001066 <= DAT_00005b0c)) ||
          (DAT_0000101c <= RAM_Adapt_injfaktor_low_)) ||
         (((RAM_Samp_pek[4] & 2) == 0 || ((DAT_0000103a & 4) == 0)))) || (DAT_00001013 < 0x4f)) ||
       ((char)RAM_OBD2_frame[0] < '\0')) {
      DAT_000040a8 = DAT_00001a58;
    }
    else if (DAT_000040a8 + 2 < DAT_00001a58) {
      RAM_Samp_pek[0] = RAM_Samp_pek[0] | 2;
    }
    pbVar4 = &RAM_Luft_error;
    if ((((DAT_00001a74 + 2 < DAT_00001a58) ||
         ((DAT_00001a8c + 0x3c < DAT_00001a58 && (DAT_00003858 + 2 < DAT_00001a58)))) ||
        ((RAM_Samp_pek[4] & 1) != 0)) ||
       (((RAM_Samp_pek[0] & 2) != 0 || ((RAM_Samp_pek[0xf] & 0x10) != 0)))) {
      if (DAT_00001a74 + 2 < DAT_00001a58) {
        if (DAT_00004056 < 0xf5) {
          if (DAT_00004056 < 0xb) {
            DAT_00004046 = DAT_00004046 | 0x40;
          }
        }
        else {
          DAT_00004046 = DAT_00004046 | 0x80;
        }
      }
      else if ((((DAT_00001a8c + 0x3c < DAT_00001a58) && (0xf < DAT_00004098)) ||
               ((RAM_Samp_pek[4] & 1) != 0)) ||
              (((RAM_Samp_pek[0] & 2) != 0 || ((RAM_Samp_pek[0xf] & 0x10) != 0)))) {
        DAT_00004046 = DAT_00004046 | 0x20;
      }
      RAM_Samp_pek[0] = RAM_Samp_pek[0] | 0x20;
      Function_0005F0B8(&RAM_Luft_error);
      sVar2 = 0x24;
      pbVar4 = RAM_Crankshaft_frame;
      puVar5 = &DAT_00002d9e;
      do {
        *puVar5 = *(undefined4 *)pbVar4;
        sVar2 = sVar2 + -1;
        pbVar4 = pbVar4 + 4;
        puVar5 = puVar5 + 1;
      } while (sVar2 != -1);
      RAM_OBD2_frame[0x12] = RAM_OBD2_frame[0x12] | 0x40;
      pbVar4 = extraout_A1;
      if (*extraout_A1 < 0x28) {
        *extraout_A1 = 0x28;
      }
      else {
        *extraout_A1 = 0x2c;
        DAT_000040e6 = DAT_000040e6 | 8;
      }
    }
    else if ((((short)(ushort)DAT_00001013 < (short)(DAT_00001136 - 3)) &&
             ((RAM_Samp_pek[4] & 8) == 0)) &&
            (((RAM_Samp_pek[0xf] & 2) != 0 && ((RAM_Samp_pek[0xb] & 0x40) == 0)))) {
      if (RAM_Luft_error < 0x28) {
        bVar1 = DAT_00003fe8 >> 6 & 1;
      }
      else if (((DAT_00003fe8 & 0x20) == 0) || (DAT_00001a58 < 0x79)) {
        bVar1 = 0;
      }
      else {
        bVar1 = 1;
      }
      if ((bVar1 != 0) && (RAM_Luft_error != 0)) {
        RAM_Luft_error = RAM_Luft_error - 1;
        RAM_Samp_pek[4] = RAM_Samp_pek[4] | 8;
      }
    }
    if ((RAM_OBD2_frame[0x12] & 0x40) == 0) {
      if (5 < DAT_00001a58 - RAM_OBD2_frame._20_4_) {
        RAM_OBD2_frame[0x12] = RAM_OBD2_frame[0x12] & 0x7f;
      }
    }
    else {
      RAM_OBD2_frame[0x14] = DAT_00001a58._0_1_;
      RAM_OBD2_frame[0x15] = DAT_00001a58._1_1_;
      RAM_OBD2_frame[0x16] = DAT_00001a58._2_1_;
      RAM_OBD2_frame[0x17] = (undefined1)DAT_00001a58;
      RAM_OBD2_frame[0x12] = RAM_OBD2_frame[0x12] | 0x80;
    }
    if (*pbVar4 == 0) {
      DAT_00004046 = 0;
      DAT_000040e6 = DAT_000040e6 & 0xf7;
    }
  }
  return;
}

```
