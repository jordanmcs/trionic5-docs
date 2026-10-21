# Function_000738D4

**ROM:** `0x000738D4`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000738D4(void)

{
  short sVar1;
  undefined1 *puVar2;
  uint *extraout_A1;
  uint *extraout_A1_00;
  char *pcVar3;
  char *extraout_A1_01;
  char *extraout_A1_02;
  char *extraout_A1_03;
  char *extraout_A1_04;
  char *extraout_A1_05;
  char *extraout_A1_06;
  char *extraout_A1_07;
  char *extraout_A1_08;
  char *extraout_A1_09;
  char *extraout_A1_10;
  char *extraout_A1_11;
  char *extraout_A1_12;
  char *extraout_A1_13;
  char *extraout_A1_14;
  undefined1 *puVar4;
  undefined2 uVar5;
  undefined2 uVar6;
  undefined2 uVar7;
  ushort uVar8;
  undefined2 uVar9;
  word wVar10;
  ushort uVar11;
  
  Function_00074EA6();
  if (((DAT_00003c74 & 1) == 1) && ((DAT_00003c74 & 0x80) == 0x80)) {
    DAT_0000482e = 0xc;
  }
  else if (((DAT_00003c74 & 2) == 2) && ((DAT_00003c74 & 0x80) == 0x80)) {
    DAT_0000482e = 0xd;
  }
  else if (((DAT_00003c74 & 3) == 3) && ((DAT_00003c74 & 0x80) == 0x80)) {
    DAT_0000482e = 0xf;
  }
  else if (((DAT_00003c74 & 4) == 4) && ((DAT_00003c74 & 0x80) == 0x80)) {
    DAT_0000482e = 0x17;
  }
  else if (((DAT_00003c74 & 8) == 8) && ((DAT_00003c74 & 0x80) == 0x80)) {
    DAT_0000482e = 0x18;
  }
  else if (((DAT_00003c74 & 0x10) == 0x10) && ((DAT_00003c74 & 0x80) == 0x80)) {
    DAT_0000482e = 0x19;
  }
  else if (((DAT_00003c74 & 1) == 1) && ((DAT_00003c74 & 2) == 2)) {
    DAT_0000482e = 0x1a;
  }
  else if (((DAT_00003c74 & 1) == 1) && ((DAT_00003c74 & 4) == 4)) {
    DAT_0000482e = 0x1b;
  }
  else if (((DAT_00003c74 & 0x40) == 0x40) && ((DAT_00003c74 & 0x80) == 0x80)) {
    DAT_0000482e = 0x1e;
  }
  else if (((DAT_00003c74 & 0x20) == 0x20) && ((DAT_00003c74 & 0x80) == 0x80)) {
    DAT_0000482e = 0x1f;
  }
  else if ((DAT_00003c74 & 1) == 1) {
    DAT_0000482e = 1;
  }
  else if ((DAT_00003c74 & 2) == 2) {
    DAT_0000482e = 2;
  }
  else if ((DAT_00003c74 & 4) == 4) {
    DAT_0000482e = 3;
  }
  else if ((DAT_00003c74 & 8) == 8) {
    DAT_0000482e = 4;
  }
  else if ((DAT_00003c74 & 0x10) == 0x10) {
    DAT_0000482e = 5;
  }
  else if ((DAT_00003c74 & 0x20) == 0x20) {
    DAT_0000482e = 6;
  }
  if ((DAT_00003c74 & 0x80) == 0x80) {
    if (DAT_0000482c == '\0') {
      DAT_00003a94 = DAT_00003a94 == '\0';
    }
    DAT_0000482c = 1;
  }
  else {
    DAT_0000482c = 0;
  }
  if (((DAT_00003c74 & 0x40) == 0x40) && ((DAT_00003c74 & 0x80) != 0x80)) {
    if (DAT_0000482a == '\0') {
      DAT_0000103c = DAT_0000103c & 0x7f;
      DAT_0000363e = 0;
      DAT_0000363c = 0;
      DAT_0000363a = 0;
      DAT_00003638 = 0;
      RAM_Crankshaft_error[0] = 0;
      RAM_Crankshaft_error[1] = 0;
      RAM_Crankshaft_error[2] = 0;
      RAM_Crankshaft_error[3] = 0;
      DAT_00001082 = 0;
      RAM_Ign_counter3[0] = 0;
      RAM_Ign_counter3[1] = 0;
      RAM_Ign_counter3[2] = 0;
      RAM_Ign_counter3[3] = 0;
      _DAT_000010ae = 0;
      DAT_0000407c = 0;
      DAT_00004078 = 0;
    }
    DAT_0000482a = 1;
  }
  else {
    DAT_0000482a = 0;
  }
  if ((((DAT_00003c74 & 1) == 1) && ((DAT_00003c74 & 2) == 2)) && ((DAT_00003c74 & 4) == 4)) {
    DAT_00004804 = 0;
    DAT_00004802 = 1000;
    DAT_00004800 = 0;
    DAT_000047fe = 0;
    DAT_000047fc = 0;
  }
  DAT_00001970 = DAT_00003c6c;
  RAM_Ad_0 = DAT_00003c6d;
  RAM_Ad_1 = DAT_00003c6e;
  RAM_Ad_2 = DAT_00003c6f;
  RAM_Ad_3 = DAT_00003c70;
  RAM_Ad_4 = DAT_00003c71;
  RAM_Ad_5 = DAT_00003c72;
  RAM_Ad_6 = DAT_00003c73;
  DAT_00004838 = 0;
  if (DAT_00003a94 == '\x01') {
    if ((RAM_Ramp_steg_[3] & 2) == 0) {
      DAT_00004839 = DAT_00004839 & 0xf7;
    }
    else {
      DAT_00004839 = DAT_00004839 | 8;
    }
    sVar1 = Function_00044664();
    if (sVar1 == 0) {
      DAT_00004839 = DAT_00004839 & 0xfe;
    }
    else {
      DAT_00004839 = DAT_00004839 | 1;
    }
    sVar1 = Function_00044664();
    if (sVar1 == 0) {
      DAT_00004839 = DAT_00004839 & 0xfd;
    }
    else {
      DAT_00004839 = DAT_00004839 | 2;
    }
    if ((DAT_0000103c & 0x80) == 0x80) {
      DAT_00004839 = DAT_00004839 | 0x80;
    }
    else {
      DAT_00004839 = DAT_00004839 & 0x7f;
    }
    sVar1 = Function_000445AC();
    if (sVar1 == 0) {
      DAT_00004839 = DAT_00004839 & 0xef;
    }
    else {
      DAT_00004839 = DAT_00004839 | 0x10;
    }
  }
  else {
    DAT_00004839 = 0;
  }
  if (DAT_0000482e == 1) {
    DAT_00004824 = &DAT_0000483a;
    DAT_0000483a = 0x20;
    DAT_0000483b = 0x20;
    DAT_0000483c = 0x20;
    DAT_0000483d = 0x20;
    DAT_0000483e = 0x20;
    DAT_0000483f = 0x20;
    DAT_00004840 = 0x20;
    DAT_00004841 = 0x20;
    DAT_00004842 = 0x20;
    DAT_00004843 = 0x20;
    DAT_00004844 = 0x20;
    DAT_00004845 = 0x20;
    DAT_00004846 = 0x20;
    DAT_00004847 = 0x20;
    DAT_00004848 = 0x20;
    DAT_00004849 = 0x20;
    for (DAT_00004820 = &DAT_00042f4c; *DAT_00004820 != '$'; DAT_00004820 = DAT_00004820 + 1) {
      *DAT_00004824 = *DAT_00004820;
      DAT_00004824 = DAT_00004824 + 1;
    }
    DAT_00004824 = &DAT_0000484a;
    DAT_0000484a = 0x20;
    DAT_0000484b = 0x20;
    DAT_0000484c = 0x20;
    DAT_0000484d = 0x20;
    DAT_0000484e = 0x20;
    DAT_0000484f = 0x20;
    DAT_00004850 = 0x20;
    DAT_00004851 = 0x20;
    DAT_00004852 = 0x20;
    DAT_00004853 = 0x20;
    DAT_00004854 = 0x20;
    DAT_00004855 = 0x20;
    DAT_00004856 = 0x20;
    DAT_00004857 = 0x20;
    DAT_00004858 = 0x20;
    DAT_00004859 = 0x20;
    for (DAT_00004820 = &DAT_0000766e; *DAT_00004820 != '\0'; DAT_00004820 = DAT_00004820 + 1) {
      *DAT_00004824 = *DAT_00004820;
      DAT_00004824 = DAT_00004824 + 1;
    }
  }
  else if (DAT_0000482e == 0xc) {
    DAT_0000483a = 0x20;
    DAT_0000483b = 0x6c;
    DAT_0000483c = 0x61;
    DAT_0000483d = 0x73;
    DAT_0000483e = 0x74;
    DAT_0000483f = 0x20;
    DAT_00004840 = 0x20;
    DAT_00004841 = 0x6d;
    DAT_00004842 = 0x61;
    DAT_00004843 = 0x78;
    DAT_00004844 = 0x20;
    DAT_00004845 = 0x20;
    DAT_00004846 = 0x6d;
    DAT_00004847 = 0x69;
    DAT_00004848 = 0x6e;
    DAT_00004849 = 0x20;
    DAT_00004859 = 0x20;
    DAT_00004828 = DAT_00004800;
    DAT_00004824 = &DAT_0000484a;
    uVar9 = 0;
    uVar7 = DAT_00004800;
    Function_00073778(0x484a);
    DAT_00004828 = DAT_00004804;
    DAT_00004824 = &DAT_0000484f;
    uVar5 = 0;
    uVar6 = DAT_00004804;
    Function_00073778(0x484f,uVar9,uVar7);
    DAT_00004828 = DAT_00004802;
    DAT_00004824 = &DAT_00004854;
    Function_00073778(0x4854,uVar5,uVar6);
  }
  else if (DAT_0000482e == 0xd) {
    DAT_0000483a = 0x20;
    DAT_0000483b = 0x6c;
    DAT_0000483c = 0x61;
    DAT_0000483d = 0x73;
    DAT_0000483e = 0x74;
    DAT_0000483f = 0x20;
    DAT_00004840 = 0x61;
    DAT_00004841 = 0x76;
    DAT_00004842 = 0x65;
    DAT_00004843 = 0x72;
    DAT_00004844 = 0x20;
    DAT_00004845 = 0x6e;
    DAT_00004846 = 0x75;
    DAT_00004847 = 0x6d;
    DAT_00004848 = 0x62;
    DAT_00004849 = 0x20;
    DAT_00004859 = 0x20;
    DAT_00004828 = DAT_00004800;
    DAT_00004824 = &DAT_0000484a;
    uVar9 = 0;
    uVar7 = DAT_00004800;
    Function_00073778(0x484a);
    DAT_00004828 = DAT_000047fe;
    DAT_00004824 = &DAT_0000484f;
    uVar5 = 0;
    uVar6 = DAT_000047fe;
    Function_00073778(0x484f,uVar9,uVar7);
    DAT_00004828 = DAT_000047fc;
    DAT_00004824 = &DAT_00004854;
    Function_00073778(0x4854,uVar5,uVar6);
  }
  else if (DAT_0000482e == 0xf) {
    DAT_0000483a = 0x20;
    DAT_0000483b = 0x4e;
    DAT_0000483c = 0x6f;
    DAT_0000483d = 0x6d;
    DAT_0000483e = 0x4c;
    DAT_0000483f = 0x20;
    DAT_00004840 = 0x52;
    DAT_00004841 = 0x65;
    DAT_00004842 = 0x67;
    DAT_00004843 = 0x4c;
    DAT_00004844 = 0x20;
    DAT_00004845 = 0x4c;
    DAT_00004846 = 0x4c;
    DAT_00004847 = 0x53;
    DAT_00004848 = 0x5f;
    DAT_00004849 = 0x61;
    DAT_00004854 = 0x20;
    DAT_00004828 = (ushort)RAM_Ret_fuel_fak;
    DAT_00004824 = &DAT_0000484a;
    uVar7 = 0;
    uVar11 = DAT_00004828;
    Function_00073778(0x484a);
    DAT_00004828 = (ushort)DAT_00005eaa;
    DAT_00004824 = &DAT_0000484f;
    uVar6 = 0;
    uVar8 = DAT_00004828;
    Function_00073778(0x484f,uVar7,uVar11);
    DAT_00004828 = (ushort)DAT_0000113b;
    DAT_00004824 = &DAT_00004855;
    Function_00073778(0x4855,uVar6,uVar8);
  }
  else if (DAT_0000482e == 0x17) {
    DAT_0000483a = 0x50;
    DAT_0000483b = 0x57;
    DAT_0000483c = 0x4d;
    DAT_0000483d = 0x75;
    DAT_0000483e = 0x74;
    DAT_0000483f = 0x20;
    DAT_00004840 = 0x52;
    DAT_00004841 = 0x65;
    DAT_00004842 = 0x67;
    DAT_00004843 = 0x6c;
    DAT_00004844 = 0x20;
    DAT_00004845 = 0x49;
    DAT_00004846 = 0x5f;
    DAT_00004847 = 0x66;
    DAT_00004848 = 0x61;
    DAT_00004849 = 0x6b;
    DAT_00004854 = 0x20;
    DAT_00004828 = DAT_00003476;
    DAT_00004824 = &DAT_0000484a;
    uVar5 = 0;
    uVar6 = DAT_00003476;
    Function_00073778(0x484a);
    DAT_00004828 = (ushort)DAT_00003353;
    DAT_00004824 = &DAT_0000484f;
    uVar7 = 0;
    uVar8 = DAT_00004828;
    Function_00073778(0x484f,uVar5,uVar6);
    DAT_00004828 = DAT_0000347a;
    DAT_00004824 = &DAT_00004855;
    Function_00073778(0x4855,uVar7,uVar8);
  }
  else if (DAT_0000482e == 0x18) {
    DAT_0000483a = 0x52;
    DAT_0000483b = 0x73;
    DAT_0000483c = 0x74;
    DAT_0000483d = 0x5f;
    DAT_0000483e = 0x69;
    DAT_0000483f = 0x20;
    DAT_00004840 = 0x49;
    DAT_00004841 = 0x6e;
    DAT_00004842 = 0x74;
    DAT_00004843 = 0x5f;
    DAT_00004844 = 0x61;
    DAT_00004845 = 100;
    DAT_00004846 = 0x72;
    DAT_00004847 = 0x65;
    DAT_00004848 = 0x73;
    DAT_00004849 = 0x73;
    DAT_0000484a = 0x20;
    DAT_0000484b = 0x20;
    DAT_0000484c = 0x20;
    DAT_0000484d = 0x20;
    DAT_0000484e = 0x20;
    DAT_0000484f = 0x20;
    DAT_00004828 = (ushort)RAM_Int_adress;
    DAT_00004824 = &DAT_0000484a;
    Function_00073778(0x484a);
    for (DAT_000035ec = 0; DAT_000035ec < 8; DAT_000035ec = DAT_000035ec + 1) {
      DAT_000035f2 = (byte)((uint)RAM_Int_indent >> ((DAT_000035ec & 0xf) << 2)) & 0xf;
      if (DAT_000035f2 < 10) {
        (&DAT_0000483a)[(short)(0x1d - (ushort)DAT_000035ec)] = DAT_000035f2 + 0x30;
      }
      else {
        (&DAT_0000483a)[(short)(0x1d - (ushort)DAT_000035ec)] = DAT_000035f2 + 0x37;
      }
    }
    DAT_00004858 = 0x48;
    DAT_00004859 = 0x20;
  }
  else if (DAT_0000482e == 0x19) {
    DAT_0000483a = 0x41;
    DAT_0000483b = 0x50;
    DAT_0000483c = 0x43;
    DAT_0000483d = 0x61;
    DAT_0000483e = 100;
    DAT_0000483f = 0x20;
    DAT_00004840 = 0x41;
    DAT_00004841 = 0x44;
    DAT_00004842 = 0x5f;
    DAT_00004843 = 0x74;
    DAT_00004844 = 0x20;
    DAT_00004845 = 0x54;
    DAT_00004846 = 0x5f;
    DAT_00004847 = 0x45;
    DAT_00004848 = 0x54;
    DAT_00004849 = 0x53;
    DAT_00004854 = 0x20;
    DAT_00004828 = RAM_Derivata_rpm;
    DAT_00004824 = &DAT_0000484a;
    uVar7 = 0;
    wVar10 = RAM_Derivata_rpm;
    Function_00073778(0x484a);
    DAT_00004828 = (ushort)DAT_00001015;
    DAT_00004824 = &DAT_0000484f;
    uVar6 = 0;
    uVar8 = DAT_00004828;
    Function_00073778(0x484f,uVar7,wVar10);
    DAT_00004828 = DAT_00003b9e;
    DAT_00004824 = &DAT_00004855;
    Function_00073778(0x4855,uVar6,uVar8);
  }
  else if (DAT_0000482e == 0x1a) {
    DAT_0000483a = 0x20;
    DAT_0000483b = 0x41;
    DAT_0000483c = 0x44;
    DAT_0000483d = 0x5f;
    DAT_0000483e = 0x74;
    DAT_0000483f = 0x20;
    DAT_00004840 = 0x41;
    DAT_00004841 = 99;
    DAT_00004842 = 99;
    DAT_00004843 = 0x5f;
    DAT_00004844 = 0x20;
    DAT_00004845 = 0x52;
    DAT_00004846 = 0x65;
    DAT_00004847 = 0x74;
    DAT_00004848 = 0x5f;
    DAT_00004849 = 0x20;
    DAT_00004854 = 0x20;
    DAT_00004828 = (ushort)DAT_00001015;
    DAT_00004824 = &DAT_0000484a;
    uVar7 = 0;
    uVar11 = DAT_00004828;
    Function_00073778(0x484a);
    DAT_00004828 = (ushort)RAM_Acc_temp[0];
    DAT_00004824 = &DAT_0000484f;
    uVar6 = 0;
    uVar8 = DAT_00004828;
    Function_00073778(0x484f,uVar7,uVar11);
    DAT_00004828 = (ushort)RAM_Ret_temp[0];
    DAT_00004824 = &DAT_00004855;
    Function_00073778(0x4855,uVar6,uVar8);
  }
  else if (DAT_0000482e == 0x1b) {
    DAT_0000483a = 0x20;
    DAT_0000483b = 0x4c;
    DAT_0000483c = 0x5f;
    DAT_0000483d = 100;
    DAT_0000483e = 0x65;
    DAT_0000483f = 0x20;
    DAT_00004840 = 0x4c;
    DAT_00004841 = 0x61;
    DAT_00004842 = 99;
    DAT_00004843 = 99;
    DAT_00004844 = 0x20;
    DAT_00004845 = 0x4c;
    DAT_00004846 = 0x72;
    DAT_00004847 = 0x65;
    DAT_00004848 = 0x74;
    DAT_00004849 = 0x20;
    DAT_00004854 = 0x20;
    DAT_00004828 = (ushort)DAT_0000100e;
    DAT_00004824 = &DAT_0000484a;
    uVar7 = 0;
    uVar11 = DAT_00004828;
    Function_00073778(0x484a);
    DAT_00004828 = (ushort)RAM_Last_delta[0];
    DAT_00004824 = &DAT_0000484f;
    uVar6 = 0;
    uVar8 = DAT_00004828;
    Function_00073778(0x484f,uVar7,uVar11);
    DAT_00004828 = (ushort)RAM_Lacc_mangd[0];
    DAT_00004824 = &DAT_00004855;
    Function_00073778(0x4855,uVar6,uVar8);
  }
  else if ((DAT_0000482e < 2) || (6 < DAT_0000482e)) {
    pcVar3 = (char *)&DAT_00003a92;
    if (DAT_0000482e == 0x1e) {
      if ((DAT_0000331a == 0) || (DAT_00003a92 != 0)) {
        if ((DAT_0000331e == 0) || (2 < DAT_00003a92)) {
          if ((DAT_0000331f == 0) || (3 < DAT_00003a92)) {
            if ((DAT_00003320 == 0) || (4 < DAT_00003a92)) {
              if ((RAM_Luft_error == 0) || (5 < DAT_00003a92)) {
                if ((DAT_00003322 == 0) || (6 < DAT_00003a92)) {
                  if ((DAT_00003323 == 0) || (7 < DAT_00003a92)) {
                    if ((DAT_00003325 == 0) || (8 < DAT_00003a92)) {
                      if ((RAM_Hast_error == 0) || (9 < DAT_00003a92)) {
                        if ((RAM_Idle_error == 0) || (10 < DAT_00003a92)) {
                          if ((DAT_00003329 == 0) || (0xb < DAT_00003a92)) {
                            if ((DAT_0000332f == 0) || (0xc < DAT_00003a92)) {
                              if ((RAM_Sond_error == 0) || (0xd < DAT_00003a92)) {
                                if ((DAT_0000332b == 0) || (0xe < DAT_00003a92)) {
                                  DAT_00003a92 = 0;
                                }
                                else {
                                  Function_00074F70(0x480a,0x6858);
                                  DAT_00004806 = DAT_0000332b;
                                  *extraout_A1_14 = '\x0f';
                                  pcVar3 = extraout_A1_14;
                                }
                              }
                              else {
                                Function_00074F70(0x480a,0x6849);
                                DAT_00004806 = RAM_Sond_error;
                                *extraout_A1_13 = '\x0e';
                                pcVar3 = extraout_A1_13;
                              }
                            }
                            else {
                              Function_00074F70(0x480a,0x6816);
                              DAT_00004806 = DAT_0000332f;
                              *extraout_A1_12 = '\r';
                              pcVar3 = extraout_A1_12;
                            }
                          }
                          else {
                            Function_00074F70(0x480a,0x686b);
                            DAT_00004806 = DAT_00003329;
                            *extraout_A1_11 = '\f';
                            pcVar3 = extraout_A1_11;
                          }
                        }
                        else {
                          Function_00074F70(0x480a,0x688d);
                          DAT_00004806 = RAM_Idle_error;
                          *extraout_A1_10 = '\v';
                          pcVar3 = extraout_A1_10;
                        }
                      }
                      else {
                        Function_00074F70(0x480a,0x687c);
                        DAT_00004806 = RAM_Hast_error;
                        *extraout_A1_09 = '\n';
                        pcVar3 = extraout_A1_09;
                      }
                    }
                    else {
                      Function_00074F70(0x480a,0x68d1);
                      DAT_00004806 = DAT_00003325;
                      *extraout_A1_08 = '\t';
                      pcVar3 = extraout_A1_08;
                    }
                  }
                  else {
                    Function_00074F70(0x480a,0x689e);
                    DAT_00004806 = DAT_00003323;
                    *extraout_A1_07 = '\b';
                    pcVar3 = extraout_A1_07;
                  }
                }
                else {
                  Function_00074F70(0x480a,0x68e2);
                  DAT_00004806 = DAT_00003322;
                  *extraout_A1_06 = '\a';
                  pcVar3 = extraout_A1_06;
                }
              }
              else {
                Function_00074F70(0x480a,0x68af);
                DAT_00004806 = RAM_Luft_error;
                *extraout_A1_05 = '\x06';
                pcVar3 = extraout_A1_05;
              }
            }
            else {
              Function_00074F70(0x480a,0x6827);
              DAT_00004806 = DAT_00003320;
              *extraout_A1_04 = '\x05';
              pcVar3 = extraout_A1_04;
            }
          }
          else {
            Function_00074F70(0x480a,0x6838);
            DAT_00004806 = DAT_0000331f;
            *extraout_A1_03 = '\x04';
            pcVar3 = extraout_A1_03;
          }
        }
        else {
          Function_00074F70(0x480a,0x68c0);
          DAT_00004806 = DAT_0000331e;
          *extraout_A1_02 = '\x03';
          pcVar3 = extraout_A1_02;
        }
      }
      else {
        Function_00074F70(0x480a,0x68f3);
        DAT_00004806 = DAT_0000331a;
        *extraout_A1_01 = '\x01';
        pcVar3 = extraout_A1_01;
      }
      if (*pcVar3 != '\0') {
        for (DAT_00004808 = 0; DAT_00004808 < 0x10; DAT_00004808 = DAT_00004808 + 1) {
          (&DAT_0000483a)[DAT_00004808] = (&DAT_0000480a)[(short)(ushort)DAT_00004808];
          (&DAT_0000483a)[(short)(DAT_00004808 + 0x10)] = 0x20;
        }
        DAT_00004828 = (ushort)DAT_00004806;
        DAT_00004824 = &DAT_0000484b;
        Function_00073778(0x484b);
        DAT_0000482e = 0;
      }
    }
    else if (DAT_0000482e == 0x1f) {
      if (DAT_00003a92 == 1) {
        DAT_0000331a = 0;
      }
      else if (DAT_00003a92 == 2) {
        RAM_VSS2_error = 0;
      }
      else if (DAT_00003a92 == 3) {
        DAT_0000331e = 0;
      }
      else if (DAT_00003a92 == 4) {
        DAT_0000331f = 0;
      }
      else if (DAT_00003a92 == 5) {
        DAT_00003320 = 0;
      }
      else if (DAT_00003a92 == 6) {
        RAM_Luft_error = 0;
      }
      else if (DAT_00003a92 == 7) {
        DAT_00003322 = 0;
      }
      else if (DAT_00003a92 == 8) {
        DAT_00003323 = 0;
      }
      else if (DAT_00003a92 == 9) {
        DAT_00003325 = 0;
      }
      else if (DAT_00003a92 == 10) {
        RAM_Hast_error = 0;
      }
      else if (DAT_00003a92 == 0xb) {
        RAM_Idle_error = 0;
      }
      else if (DAT_00003a92 == 0xc) {
        DAT_00003329 = 0;
      }
      else if (DAT_00003a92 == 0xd) {
        DAT_0000332f = 0;
      }
      else if (DAT_00003a92 == 0xe) {
        RAM_Sond_error = 0;
      }
      else if (DAT_00003a92 == 0xf) {
        DAT_0000332b = 0;
      }
    }
  }
  else {
    for (DAT_0000481e = 0; DAT_0000481e < 0x10; DAT_0000481e = DAT_0000481e + 1) {
      (&DAT_0000483a)[DAT_0000481e] =
           (&DAT_00001a02)[(short)(DAT_0000481e + (DAT_0000482e - 2) * 0x10)];
    }
    DAT_00004854 = 0x20;
    if (((&DAT_00001a52)[(short)(DAT_0000482e - 2)] & 1) == 1) {
      DAT_0000481a = (uint)(short)((ushort)**(byte **)((int)&DAT_000019c6 +
                                                      (int)(short)((DAT_0000482e - 2) * 0xc)) *
                                   0x100 + (ushort)*(byte *)(*(int *)((int)&DAT_000019c6 +
                                                                     (int)(short)((DAT_0000482e - 2)
                                                                                 * 0xc)) + 1));
    }
    else {
      DAT_0000481a = (uint)**(byte **)((int)&DAT_000019c6 + (int)(short)((DAT_0000482e - 2) * 0xc));
    }
    if (((&DAT_00001a52)[(short)(DAT_0000482e - 2)] & 8) == 8) {
      if (((&DAT_00001a52)[(short)(DAT_0000482e - 2)] & 1) == 1) {
        if (0x7fff < (int)DAT_0000481a) {
          DAT_0000481a = DAT_0000481a - 0x10000;
        }
      }
      else if (0x7f < (int)DAT_0000481a) {
        DAT_0000481a = DAT_0000481a - 0x100;
      }
    }
    DAT_00004828 = DAT_0000481a._2_2_;
    DAT_00004824 = &DAT_0000484a;
    Function_00073778(0x484a);
    if (((&DAT_00001a52)[(short)(DAT_0000482e - 2)] & 2) == 2) {
      *extraout_A1 = (int)(short)((ushort)**(byte **)((int)&DAT_000019ca +
                                                     (int)(short)((DAT_0000482e - 2) * 0xc)) * 0x100
                                 + (ushort)*(byte *)(*(int *)((int)&DAT_000019ca +
                                                             (int)(short)((DAT_0000482e - 2) * 0xc))
                                                    + 1));
    }
    else {
      *extraout_A1 = (uint)**(byte **)((int)&DAT_000019ca + (int)(short)((DAT_0000482e - 2) * 0xc));
    }
    if (((&DAT_00001a52)[(short)(DAT_0000482e - 2)] & 0x10) == 0x10) {
      if (((&DAT_00001a52)[(short)(DAT_0000482e - 2)] & 2) == 2) {
        if (0x7fff < (int)*extraout_A1) {
          *extraout_A1 = *extraout_A1 - 0x10000;
        }
      }
      else if (0x7f < (int)*extraout_A1) {
        *extraout_A1 = *extraout_A1 - 0x100;
      }
    }
    DAT_00004828 = (ushort)*extraout_A1;
    DAT_00004824 = &DAT_0000484f;
    Function_00073778(0x484f);
    if (((&DAT_00001a52)[(short)(DAT_0000482e - 2)] & 4) == 4) {
      *extraout_A1_00 =
           (int)(short)((ushort)**(byte **)((int)&DAT_000019ce +
                                           (int)(short)((DAT_0000482e - 2) * 0xc)) * 0x100 +
                       (ushort)*(byte *)(*(int *)((int)&DAT_000019ce +
                                                 (int)(short)((DAT_0000482e - 2) * 0xc)) + 1));
    }
    else {
      *extraout_A1_00 =
           (uint)**(byte **)((int)&DAT_000019ce + (int)(short)((DAT_0000482e - 2) * 0xc));
    }
    if (((&DAT_00001a52)[(short)(DAT_0000482e - 2)] & 0x20) == 0x20) {
      if (((&DAT_00001a52)[(short)(DAT_0000482e - 2)] & 4) == 4) {
        if (0x7fff < (int)*extraout_A1_00) {
          *extraout_A1_00 = *extraout_A1_00 - 0x10000;
        }
      }
      else if (0x7f < (int)*extraout_A1_00) {
        *extraout_A1_00 = *extraout_A1_00 - 0x100;
      }
    }
    DAT_00004828 = (ushort)*extraout_A1_00;
    DAT_00004824 = &DAT_00004855;
    Function_00073778(0x4855);
  }
  RAM_AMOS_var = DAT_0000482e;
  if ((DAT_00001039 & 4) != 0) {
    DAT_00003c4a = DAT_00003c4a & 0xfc;
  }
  DAT_00004838 = DAT_00003c4a & 0xfd;
  Function_00074F8C();
  sVar1 = 0x29;
  puVar2 = &DAT_00004830;
  puVar4 = &DAT_00003c42;
  do {
    *puVar4 = *puVar2;
    sVar1 = sVar1 + -1;
    puVar2 = puVar2 + 1;
    puVar4 = puVar4 + 1;
  } while (sVar1 != -1);
  return;
}

```
