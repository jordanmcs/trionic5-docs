# Function_0005C4CC

**ROM:** `0x0005C4CC`

```c

void Function_0005C4CC(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  byte *pbVar4;
  
  if ((RAM_Samp_pek[7] & 0x80) == 0) {
    if (((((DAT_00003c32 < (ushort)(DAT_00003fd4 + 0x177)) &&
          ((ushort)(DAT_00003fd4 - 0x177) < DAT_00003c32)) &&
         ((ushort)DAT_00001037 < (ushort)(DAT_00003fd2 + 0x11))) &&
        (((short)(DAT_00003fd2 - 0x11) < (short)(ushort)DAT_00001037 &&
         ('F' < DAT_0000102e == 'F' < DAT_00003fd0)))) && (RAM_Mis200_4 == 0)) {
      RAM_Samp_pek[0xc] = RAM_Samp_pek[0xc] | 0x80;
    }
    pbVar3 = &DAT_00001d22;
    if (RAM_Mis200_4 < 400) {
      if ((((RAM_Samp_pek[7] & 0x40) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) &&
         ((300 < DAT_00001a58 && (RAM_Mis200_4 == 0)))) {
        if (DAT_00001d22 < 0x29) {
          bVar2 = DAT_00003fe8 >> 6 & 1;
        }
        else if ((((DAT_00003fe8 & 0x20) == 0) || (DAT_0000107e < 0x353)) ||
                ((RAM_Samp_pek[0xc] & 0x80) == 0)) {
          bVar2 = 0;
        }
        else {
          bVar2 = 1;
        }
        if ((bVar2 != 0) && (DAT_00001d22 != 0)) {
          DAT_00001d22 = DAT_00001d22 - 1;
          RAM_Samp_pek[7] = RAM_Samp_pek[7] | 0x40;
        }
      }
    }
    else {
      DAT_00004032 = 0;
      RAM_Samp_pek[7] = RAM_Samp_pek[7] | 0x80;
      if (0x13 < DAT_000010d0) {
        DAT_00004032 = 0x80;
      }
      if (0x13 < RAM_Mis200_1) {
        DAT_00004032 = DAT_00004032 | 0x40;
      }
      if (0x13 < RAM_Mis200_2) {
        DAT_00004032 = DAT_00004032 | 0x20;
      }
      if (0x13 < RAM_Mis200_3) {
        DAT_00004032 = DAT_00004032 | 0x10;
      }
      Function_0005F0B8(&DAT_00001d22);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      pbVar4 = RAM_Luft_frame;
      do {
        *(undefined4 *)pbVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        pbVar4 = pbVar4 + 4;
      } while (sVar1 != -1);
      DAT_000040a2 = DAT_0000334f != '\0';
      if (*extraout_A1 < 0x28) {
        DAT_00003fd2 = DAT_00001037;
        DAT_00003fd4 = DAT_00003c32;
        DAT_00003fd0 = DAT_0000102e;
      }
      pbVar3 = extraout_A1;
      if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e5 = DAT_000040e5 | 0x10;
      }
    }
    if ((DAT_00001d23 == '\0') && (*pbVar3 == 0)) {
      DAT_00004032 = 0;
      DAT_000040e5 = DAT_000040e5 & 0xef;
    }
  }
  return;
}

```
