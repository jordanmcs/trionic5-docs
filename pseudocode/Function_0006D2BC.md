# Function_0006D2BC

**ROM:** `0x0006D2BC`

```c

void Function_0006D2BC(void)

{
  char cVar2;
  short sVar1;
  undefined4 extraout_A1;
  undefined4 extraout_A1_00;
  undefined4 extraout_A1_01;
  undefined4 extraout_A1_02;
  undefined4 uVar3;
  code *extraout_A1_03;
  byte *pbVar4;
  byte *extraout_A1_04;
  byte *extraout_A1_05;
  byte *extraout_A1_06;
  
  DAT_00003a32 = DAT_00003a32 + 1;
  if (DAT_00003a32 == 0) {
    DAT_00001988 = DAT_00001988 + 1;
  }
  DAT_00003a2e = DAT_00003a2e + 1;
  cVar2 = Function_0006A4E4(&DAT_0000760e,0x761e);
  RAM_Last = cVar2 - 0x28;
  cVar2 = Function_0006A4E4(extraout_A1,0x761e);
  DAT_000046e6 = cVar2 + -0x28;
  RAM_Lufttemp = Function_0006A4E4(extraout_A1_00,0x762e);
  if ((RAM_Samp_pek[0] & 0x80) == 0) {
    cVar2 = Function_0006A4E4(RAM_Restart_corr_hp_,0x75f8);
    DAT_0000102e = cVar2 - 0x28;
    DAT_00004736 = DAT_0000102e;
  }
  else {
    DAT_0000102e = RAM_Kyl_temp;
  }
  if ((char)DAT_0000102e < '=') {
    if (((DAT_00001039 & 8) == 0) && ('\x11' < (char)RAM_Last)) {
      DAT_0000103a = DAT_0000103a | 8;
    }
  }
  else {
    DAT_00001039 = DAT_00001039 | 0x10;
  }
  if (((DAT_0000103b & 0x80) == 0) && ((RAM_Ramp_steg_[3] & 0x80) == 0)) {
    DAT_00001001 = Function_0006A4E4(RAM_Retard_detekt_,0x4bc4);
    uVar3 = extraout_A1_02;
  }
  else {
    DAT_00001001 = Function_0006A4E4(RAM_Retard_detekt_,0x4bb4);
    uVar3 = extraout_A1_01;
  }
  DAT_00001042 = Function_0006A4E4(uVar3,0x4abc);
  Function_00061764();
  sVar1 = Function_0004A4D2();
  if (sVar1 == 1) {
    sVar1 = Function_0004461C();
    if (sVar1 == 1) {
      if ((byte)((char)DAT_00003a2e - (char)DAT_00003a2c) < 7) {
        if ((DAT_000038c4 & 0x80) == 0) {
          Function_0004461C();
        }
        if ((DAT_00001039 & 8) != 0) {
          DAT_000039fc = DAT_000039fc | 0x80;
        }
        DAT_000046da = 0;
      }
      else if ((RAM_Purge_status & 0x10) == 0) {
        if ((DAT_000038c4 & 0x80) == 0) {
          Function_0004461C();
        }
        DAT_00001039 = DAT_00001039 & 0xf7 | 4;
      }
    }
    else if (RAM_Shut_off_time_ <= (ushort)(DAT_00003a2e - DAT_00003a2c)) {
      RAM_Cyl_nr = 0;
      if ((DAT_000038c2 & 0x20) == 0) {
        Function_00044270();
      }
      if ((DAT_000038c4 & 0x40) == 0) {
        Function_00044664();
      }
    }
  }
  else {
    RAM_Cyl_nr = 0;
    if ((DAT_000038c2 & 0x20) == 0) {
      Function_00044270();
    }
    if ((DAT_000038c4 & 0x80) == 0) {
      Function_0004461C();
    }
    DAT_00003a2e = 0;
    DAT_00003a2c = 0;
    DAT_00001039 = DAT_00001039 & 0xf7 | 4;
    Function_00069DD0();
    DAT_00003a1e = 0;
    Function_0005E8A6();
    Function_00049E30();
    Function_00069C30();
    if (DAT_00003c32 == 0) {
      DAT_00001136 = DAT_00001013;
    }
    else {
      DAT_00001136 = 0x50;
    }
    if ((ushort)(DAT_00003a32 - DAT_00003a30) < RAM_Rpm_max_) {
      if (RAM_Shut_off_time_ <= (ushort)(DAT_00003a32 - DAT_00003a30)) {
        RAM_Cyl_nr = 0;
        if ((DAT_000038c2 & 0x20) == 0) {
          (*extraout_A1_03)();
        }
        if ((DAT_000038c4 & 0x40) == 0) {
          Function_00044664();
        }
      }
    }
    else {
      DAT_000032d3 = DAT_0000102e;
      RAM_Cyl_nr = 0;
      if ((DAT_000038c2 & 0x20) == 0) {
        (*extraout_A1_03)();
      }
      DAT_00003a28 = 1;
    }
  }
  Function_00071E38();
  Function_00071F30();
  Function_0006944C();
  if ((DAT_00001039 & 8) != 0) {
    RAM_Purge_status = RAM_Purge_status | 0x80;
  }
  DAT_0000353c = 0x15e;
  pbVar4 = &DAT_0000353a;
  for (DAT_0000353a = 0; (DAT_0000353c <= DAT_00001066 && (DAT_0000353a != 5));
      DAT_0000353a = DAT_0000353a + 1) {
    DAT_0000353c = DAT_0000353c + 0x32;
  }
  if ((RAM_Fload_tab_[(short)(ushort)DAT_0000353a] < DAT_00001037) ||
     (sVar1 = Function_0004461C(), pbVar4 = extraout_A1_04, sVar1 == 0)) {
    if ((DAT_000038c2 & 8) == 0) {
      Function_00044A26();
      pbVar4 = extraout_A1_05;
    }
    DAT_0000103d = DAT_0000103d & 0xfd;
  }
  else {
    if ((DAT_000038c2 & 8) == 0) {
      Function_00044A26();
      pbVar4 = extraout_A1_06;
    }
    DAT_0000103d = DAT_0000103d | 2;
  }
  if ((RAM_Fload_tab_[(short)(ushort)*pbVar4] < DAT_00001037) ||
     (sVar1 = Function_0004461C(), sVar1 == 0)) {
    if ((DAT_000038c2 & 4) == 0) {
      Function_00044A90();
    }
    DAT_0000103d = DAT_0000103d & 0xfe;
  }
  else if ((char)DAT_0000102e < '2') {
    if ((DAT_000038c2 & 4) == 0) {
      Function_00044A90();
    }
    DAT_0000103d = DAT_0000103d & 0xfe;
  }
  else {
    if ((DAT_000038c2 & 4) == 0) {
      Function_00044A90();
    }
    DAT_0000103d = DAT_0000103d | 1;
  }
  if ((DAT_00001039 & 8) != 0) {
    Function_0006A2D2();
  }
  Function_000722E0();
  Function_00072906();
  if (((DAT_00001039 & 8) == 0) || ((RAM_Ramp_steg_[3] & 1) == 0)) {
    Function_00044C58();
  }
  else if ((char)DAT_0000102e < 'V') {
    if ((char)DAT_0000102e < '8') {
      Function_00044C58();
      DAT_00003a1e = DAT_00003a1e + 1;
      DAT_00003a1c = DAT_00003a1c + 1;
    }
    else if (DAT_00003a1e < 0x3c0) {
      Function_00044C58();
      DAT_00003a1e = DAT_00003a1e + 1;
      DAT_00003a1c = DAT_00003a1c + 1;
    }
    else {
      Function_00044C58();
    }
  }
  else {
    Function_00044C58();
    DAT_00003a1e = 0x3c0;
    DAT_00003a1c = 0x3c0;
  }
  if (DAT_0000101c < 0x14) {
    sVar1 = Function_00044C00();
    if (sVar1 == 1) {
      DAT_0000103e = DAT_0000103e & 0x7f;
    }
    else {
      DAT_0000103e = DAT_0000103e | 0x80;
    }
  }
  Function_00070B6A();
  Function_0006BC48();
  if (RAM_Rpm_byte < RAM_Start_detekt_nr_) {
    RAM_Start_detekt_nr_ = RAM_Start_detekt_nr_ - 1;
  }
  else if (RAM_Start_detekt_nr_ < RAM_Rpm_byte) {
    RAM_Start_detekt_nr_ = RAM_Start_detekt_nr_ + 1;
  }
  Function_0006BC7E();
  return;
}

```
