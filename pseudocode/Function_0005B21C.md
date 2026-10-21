# Function_0005B21C

**ROM:** `0x0005B21C`

```c

void Function_0005B21C(void)

{
  short sVar1;
  byte *pbVar2;
  byte *extraout_A1;
  byte *pbVar3;
  
  if ((RAM_Samp_pek[0xb] & 8) == 0) {
    DAT_00004020 = DAT_00004020 & 0xbf;
    if ((((DAT_00003c32 < (ushort)(DAT_00003fe0 + 0x177)) &&
         ((ushort)(DAT_00003fe0 - 0x177) < DAT_00003c32)) &&
        ((ushort)DAT_00001037 < (ushort)(DAT_00003fe2 + 0x11))) &&
       (((short)(DAT_00003fe2 - 0x11) < (short)(ushort)DAT_00001037 &&
        ('F' < DAT_0000102e == 'F' < DAT_00003fde)))) {
      RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] | 2;
    }
    if ((((RAM_Samp_pek[0xb] & 2) == 0) && ((DAT_00003fe8 & 0x20) != 0)) &&
       (((RAM_Samp_pek[0xb] & 1) == 0 &&
        (RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] | 1, DAT_00003331 != '\0')))) {
      DAT_00003331 = DAT_00003331 + -1;
    }
    if ((((DAT_00001031 == -1) || (DAT_00001031 == '\0')) && ((DAT_00001039 & 0x10) != 0)) &&
       ((((DAT_0000103c & 2) != 0 && (-1 < (char)RAM_OBD2_frame[0xc])) &&
        ((RAM_Samp_pek[0xc] & 8) != 0)))) {
      if ((DAT_00001031 == '\0') && (DAT_00001a84 + 0xf < DAT_00001a58)) {
        RAM_Samp_pek[5] = RAM_Samp_pek[5] | 1;
      }
      DAT_00004020 = DAT_00004020 | 0x40;
    }
    else {
      DAT_00001a84 = DAT_00001a58;
      RAM_Samp_pek[5] = RAM_Samp_pek[5] & 0xfe;
    }
    pbVar2 = &RAM_Sond_error;
    if (((RAM_Samp_pek[0xb] & 4) == 0) && (DAT_00001a84 + 0x14 < DAT_00001a58)) {
      if (RAM_Sond_error < 0x28) {
        DAT_00003fe2 = DAT_00001037;
        DAT_00003fe0 = DAT_00003c32;
        DAT_00003fde = DAT_0000102e;
      }
      DAT_00003331 = 'P';
      DAT_00004034 = 0;
      RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] | 8;
      if ((DAT_00001a84 + 0x14 < DAT_00001a58) && (DAT_00001031 == '\0')) {
        DAT_00004034 = 0x40;
      }
      else if ((DAT_00001a84 + 0x14 < DAT_00001a58) && (DAT_00001031 == -1)) {
        DAT_00004034 = 0x80;
      }
      RAM_Samp_pek[5] = RAM_Samp_pek[5] | 1;
      DAT_00004020 = DAT_00004020 | 0x40;
      Function_0005F0B8(&RAM_Sond_error);
      sVar1 = 0x24;
      pbVar2 = RAM_Crankshaft_frame;
      pbVar3 = RAM_Sond_frame;
      do {
        *(undefined4 *)pbVar3 = *(undefined4 *)pbVar2;
        sVar1 = sVar1 + -1;
        pbVar2 = pbVar2 + 4;
        pbVar3 = pbVar3 + 4;
      } while (sVar1 != -1);
      DAT_0000409c = DAT_0000334f != '\0';
      pbVar2 = extraout_A1;
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e7 = DAT_000040e7 | 0x40;
      }
    }
    else if (((DAT_00001a60 + 800U < DAT_00001a58) &&
             ((((DAT_0000103c & 2) != 0 && ((RAM_Samp_pek[0xb] & 0x20) == 0)) &&
              ((RAM_Samp_pek[0xb] & 0x40) == 0)))) &&
            ((((((0x28 < RAM_Sond_error && ((DAT_00003fe8 & 0x20) != 0)) &&
                ((RAM_Samp_pek[0xb] & 2) != 0)) ||
               ((RAM_Sond_error < 0x28 && ((DAT_00003fe8 & 0x40) != 0)))) ||
              (((RAM_Sond_error == 0x28 &&
                (((DAT_000040e7 >> 6 & 1) == 0 && ((RAM_Samp_pek[0xb] & 2) != 0)))) ||
               ((RAM_Sond_error == 0x28 &&
                (((DAT_000040e7 & 0x40) != 0 && ((DAT_00003fe8 & 0x40) != 0)))))))) &&
             (RAM_Sond_error != 0)))) {
      RAM_Sond_error = RAM_Sond_error - 1;
      RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] | 0x20;
    }
    if ((DAT_00004020 & 0x40) == 0) {
      if (5 < DAT_00001a58 - DAT_00004022) {
        DAT_00004020 = DAT_00004020 & 0x7f;
      }
    }
    else {
      DAT_00004022 = DAT_00001a58;
      DAT_00004020 = DAT_00004020 | 0x80;
    }
    if (*pbVar2 == 0) {
      DAT_00004034 = 0;
      DAT_000040e7 = DAT_000040e7 & 0xbf;
    }
    if ((((DAT_000040e7 >> 6 & 1) == 0) && (*pbVar2 == 0x28)) && (DAT_00003331 == '\0')) {
      *pbVar2 = 0;
    }
  }
  return;
}

```
