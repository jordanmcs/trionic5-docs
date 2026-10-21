# Function_0005DBAE

**ROM:** `0x0005DBAE`

```c

void Function_0005DBAE(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[0] & 4) == 0) {
    RAM_OBD2_frame[6] = RAM_OBD2_frame[6] & 0xbf;
    if (DAT_00001a58 != DAT_000040ac) {
      DAT_000040ac = DAT_00001a58;
      DAT_000040a6 = DAT_0000101c;
    }
    if ((((0x32 < DAT_000040a6) && (DAT_000040a6 < 0xcd)) && (2 < DAT_00001a58)) &&
       ((RAM_Samp_pek[0xc] & 0x20) == 0)) {
      if (((ushort)(DAT_000040a6 + 0x78) < (ushort)DAT_0000101c) ||
         (((short)(ushort)DAT_0000101c < (short)(DAT_000040a6 - 0x78) &&
          (sVar1 = Function_00044BA4(), sVar1 != 1)))) {
        RAM_Samp_pek[3] = RAM_Samp_pek[3] | 2;
        RAM_OBD2_frame[6] = RAM_OBD2_frame[6] | 0x40;
      }
      else if (DAT_0000101c != 0) {
        RAM_Samp_pek[0xc] = RAM_Samp_pek[0xc] | 0x20;
      }
    }
    if ((((DAT_00001013 < RAM_Press_rpm_lim_) || (DAT_0000101c != 0)) ||
        ((DAT_00001066 < RAM_Lambda_cat_rich_ ||
         (((DAT_0000102e < '<' || ((uint)RAM_Ign_counter2 < 5000)) ||
          (sVar1 = Function_00044BA4(), sVar1 == 1)))))) && ((RAM_Samp_pek[0xc] & 1) == 0)) {
      DAT_00001a64 = DAT_00001a58;
    }
    else if (DAT_00001a64 + 5 <= DAT_00001a58) {
      RAM_Samp_pek[0xc] = RAM_Samp_pek[0xc] | 1;
    }
    if (DAT_0000360a < 0x10f) {
      DAT_000040a4 = 0;
    }
    else {
      DAT_000040a4 = DAT_000040a4 + 1;
      RAM_OBD2_frame[6] = RAM_OBD2_frame[6] | 0x40;
    }
    if ((((RAM_Ramp_steg_[3] & 2) != 0) && ((DAT_00001137 & 0x80) != 0)) ||
       ((DAT_0000101c != 0 || (DAT_00001066 < 0x46)))) {
      RAM_Samp_pek[0xc] = RAM_Samp_pek[0xc] & 0xfe;
    }
    pbVar3 = &DAT_00003325;
    if (((((RAM_Samp_pek[3] & 2) == 0) && (DAT_000040a4 < 0x15)) &&
        (DAT_00001a58 <= DAT_00001a64 + RAM_Sond_omsl_limit_)) ||
       (DAT_00001a58 <= (int)RAM_Diag_tid + 2U)) {
      if (((RAM_Samp_pek[3] & 1) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        if (DAT_00003325 < 0x28) {
          bVar2 = DAT_00003fe8 >> 6 & 1;
        }
        else if (((DAT_00003fe8 & 0x20) == 0) || (DAT_0000101c == 0)) {
          bVar2 = 0;
        }
        else {
          bVar2 = 1;
        }
        if ((bVar2 != 0) && (DAT_00003325 != 0)) {
          DAT_00003325 = DAT_00003325 - 1;
          RAM_Samp_pek[3] = RAM_Samp_pek[3] | 1;
        }
      }
    }
    else {
      DAT_0000403e = 0;
      RAM_Samp_pek[0] = RAM_Samp_pek[0] | 4;
      if (DAT_000040a4 < 0x15) {
        if (DAT_00001a64 + 4 < DAT_00001a58) {
          DAT_0000403e = 0x40;
        }
        else if ((RAM_Samp_pek[3] & 2) != 0) {
          DAT_0000403e = 0x20;
        }
      }
      else {
        DAT_0000403e = 0x80;
      }
      Function_0005F0B8(&DAT_00003325);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_00002342;
      do {
        *puVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        puVar4 = puVar4 + 1;
      } while (sVar1 != -1);
      RAM_OBD2_frame[6] = RAM_OBD2_frame[6] | 0x40;
      pbVar3 = extraout_A1;
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e4 = DAT_000040e4 | 0x10;
      }
    }
    if ((RAM_OBD2_frame[6] & 0x40) == 0) {
      if (5 < DAT_00001a58 - RAM_OBD2_frame._8_4_) {
        RAM_OBD2_frame[6] = RAM_OBD2_frame[6] & 0x7f;
      }
    }
    else {
      RAM_OBD2_frame[8] = DAT_00001a58._0_1_;
      RAM_OBD2_frame[9] = DAT_00001a58._1_1_;
      RAM_OBD2_frame[10] = DAT_00001a58._2_1_;
      RAM_OBD2_frame[0xb] = (undefined1)DAT_00001a58;
      RAM_OBD2_frame[6] = RAM_OBD2_frame[6] | 0x80;
    }
    if (*pbVar3 == 0) {
      DAT_0000403e = 0;
      DAT_000040e4 = DAT_000040e4 & 0xef;
    }
  }
  return;
}

```
