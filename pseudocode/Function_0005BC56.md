# Function_0005BC56

**ROM:** `0x0005BC56`

```c

void Function_0005BC56(void)

{
  short sVar1;
  byte *pbVar2;
  byte *extraout_A1;
  undefined4 *puVar3;
  
  if ((RAM_Samp_pek[0xc] & 2) == 0) {
    if ((((DAT_00003c32 < (ushort)(DAT_00003fdc + 0x177)) &&
         ((ushort)(DAT_00003fdc - 0x177) < DAT_00003c32)) &&
        ((ushort)DAT_00001037 < (ushort)(DAT_00003fda + 0x11))) &&
       (((short)(DAT_00003fda - 0x11) < (short)(ushort)DAT_00001037 &&
        ('F' < DAT_0000102e == 'F' < DAT_00003fd8)))) {
      RAM_Samp_pek[10] = RAM_Samp_pek[10] | 1;
    }
    if ((((RAM_Samp_pek[10] & 1) == 0) && ((DAT_00003fe8 & 0x20) != 0)) &&
       (((RAM_Samp_pek[0xb] & 0x80) == 0 &&
        (RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] | 0x80, DAT_00003330 != '\0')))) {
      DAT_00003330 = DAT_00003330 + -1;
    }
    if (((RAM_Samp_pek[0xc] & 8) != 0) && (RAM_Start_detekt_nr_ == RAM_Rpm_byte)) {
      if (RAM_Adapt_korr_high_ < RAM_Start_detekt_nr_) {
        if (DAT_00005b18 <= RAM_Start_detekt_nr_) {
          RAM_Samp_pek[4] = RAM_Samp_pek[4] | 0x80;
          DAT_00004048 = 0x40;
        }
      }
      else {
        RAM_Samp_pek[4] = RAM_Samp_pek[4] | 0x80;
        DAT_00004048 = 0x80;
      }
    }
    pbVar2 = &DAT_0000332f;
    if ((((RAM_Samp_pek[0xc] & 8) == 0) || (RAM_Start_detekt_nr_ != RAM_Rpm_byte)) ||
       ((RAM_Samp_pek[4] & 0x80) == 0)) {
      if ((((((RAM_Samp_pek[0xc] & 8) != 0) && ((RAM_Samp_pek[3] & 8) == 0)) &&
           ((RAM_Start_detekt_nr_ == RAM_Rpm_byte && ((RAM_Samp_pek[0xb] & 0x40) == 0)))) &&
          ((((0x28 < DAT_0000332f && ((DAT_00003fe8 & 0x20) != 0)) && ((RAM_Samp_pek[10] & 1) != 0))
           || ((((DAT_0000332f < 0x28 && ((DAT_00003fe8 & 0x40) != 0)) ||
                ((DAT_0000332f == 0x28 &&
                 ((-1 < (char)DAT_000040e7 && ((RAM_Samp_pek[10] & 1) != 0)))))) ||
               ((DAT_0000332f == 0x28 &&
                (((DAT_000040e7 & 0x80) != 0 && ((DAT_00003fe8 & 0x40) != 0)))))))))) &&
         (DAT_0000332f != 0)) {
        DAT_0000332f = DAT_0000332f - 1;
        RAM_Samp_pek[3] = RAM_Samp_pek[3] | 8;
      }
    }
    else {
      DAT_00003330 = 'P';
      DAT_0000409e = DAT_0000334f != '\0';
      Function_0005F0B8(&DAT_0000332f);
      sVar1 = 0x24;
      pbVar2 = RAM_Crankshaft_frame;
      puVar3 = &DAT_00001d2a;
      do {
        *puVar3 = *(undefined4 *)pbVar2;
        sVar1 = sVar1 + -1;
        pbVar2 = pbVar2 + 4;
        puVar3 = puVar3 + 1;
      } while (sVar1 != -1);
      if (*extraout_A1 < 0x28) {
        DAT_00003fda = DAT_00001037;
        DAT_00003fdc = DAT_00003c32;
        DAT_00003fd8 = DAT_0000102e;
      }
      RAM_Samp_pek[0xc] = RAM_Samp_pek[0xc] | 2;
      pbVar2 = extraout_A1;
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e7 = DAT_000040e7 | 0x80;
      }
    }
    if (*pbVar2 == 0) {
      DAT_00004048 = 0;
      DAT_000040e7 = DAT_000040e7 & 0x7f;
    }
    if (((-1 < (char)DAT_000040e7) && (*pbVar2 == 0x28)) && (DAT_00003330 == '\0')) {
      *pbVar2 = 0;
    }
  }
  return;
}

```
