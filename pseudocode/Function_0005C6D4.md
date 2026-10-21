# Function_0005C6D4

**ROM:** `0x0005C6D4`

```c

void Function_0005C6D4(void)

{
  short sVar1;
  byte *pbVar2;
  byte *extraout_A1;
  undefined4 *puVar3;
  
  if ((RAM_Samp_pek[7] & 0x20) == 0) {
    if ((((DAT_00003c32 < (ushort)(DAT_00003fce + 0x177)) &&
         ((ushort)(DAT_00003fce - 0x177) < DAT_00003c32)) &&
        ((ushort)DAT_00001037 < (ushort)(DAT_00003fcc + 0x11))) &&
       ((((short)(DAT_00003fcc - 0x11) < (short)(ushort)DAT_00001037 &&
         ('F' < DAT_0000102e == 'F' < DAT_00003fca)) && (DAT_000010e4 == 0)))) {
      RAM_Samp_pek[10] = RAM_Samp_pek[10] | 4;
    }
    if ((((RAM_Samp_pek[10] & 4) == 0) && ((DAT_00003fe8 & 0x20) != 0)) &&
       (((RAM_Samp_pek[10] & 2) == 0 &&
        (RAM_Samp_pek[10] = RAM_Samp_pek[10] | 2, DAT_00003332 != '\0')))) {
      DAT_00003332 = DAT_00003332 + -1;
    }
    pbVar2 = &DAT_00001d23;
    if (DAT_000010e4 < 2000) {
      if (((((((RAM_Samp_pek[7] & 0x10) == 0) && (DAT_000010e4 == 0)) && (300 < DAT_00001a58)) &&
           ((RAM_Samp_pek[0xb] & 0x40) == 0)) &&
          ((((0x28 < DAT_00001d23 && ((DAT_00003fe8 & 0x20) != 0)) &&
            ((0x9c4 < DAT_0000107e && ((RAM_Samp_pek[10] & 4) != 0)))) ||
           ((((DAT_00001d23 < 0x28 && ((DAT_00003fe8 & 0x40) != 0)) ||
             ((DAT_00001d23 == 0x28 && (((DAT_000040e5 & 1) == 0 && ((RAM_Samp_pek[10] & 4) != 0))))
             )) || ((DAT_00001d23 == 0x28 &&
                    (((DAT_000040e5 & 1) != 0 && ((DAT_00003fe8 & 0x40) != 0)))))))))) &&
         (DAT_00001d23 != 0)) {
        DAT_00001d23 = DAT_00001d23 - 1;
        RAM_Samp_pek[7] = RAM_Samp_pek[7] | 0x10;
      }
    }
    else {
      DAT_00004032 = 0;
      RAM_Samp_pek[7] = RAM_Samp_pek[7] | 0x20;
      if (99 < RAM_C200_max) {
        DAT_00004032 = 0x80;
      }
      if (99 < DAT_000010de) {
        DAT_00004032 = DAT_00004032 | 0x40;
      }
      if (99 < DAT_000010e0) {
        DAT_00004032 = DAT_00004032 | 0x20;
      }
      if (99 < DAT_000010e2) {
        DAT_00004032 = DAT_00004032 | 0x10;
      }
      Function_0005F0B8(&DAT_00001d23);
      sVar1 = 0x24;
      pbVar2 = RAM_Crankshaft_frame;
      puVar3 = &DAT_00002786;
      do {
        *puVar3 = *(undefined4 *)pbVar2;
        sVar1 = sVar1 + -1;
        pbVar2 = pbVar2 + 4;
        puVar3 = puVar3 + 1;
      } while (sVar1 != -1);
      if (*extraout_A1 < 0x28) {
        DAT_00003fcc = DAT_00001037;
        DAT_00003fce = DAT_00003c32;
        DAT_00003fca = DAT_0000102e;
      }
      DAT_00003332 = 'P';
      DAT_000040a0 = DAT_0000334f != '\0';
      pbVar2 = extraout_A1;
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e5 = DAT_000040e5 | 1;
      }
    }
    if ((*pbVar2 == 0) && (DAT_00001d22 == '\0')) {
      DAT_00004032 = 0;
      DAT_000040e5 = DAT_000040e5 & 0xfe;
    }
    if ((((DAT_000040e5 & 1) == 0) && (*pbVar2 == 0x28)) && (DAT_00003332 == '\0')) {
      *pbVar2 = 0;
    }
  }
  return;
}

```
