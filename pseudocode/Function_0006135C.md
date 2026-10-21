# Function_0006135C

**ROM:** `0x0006135C`

```c

void Function_0006135C(char *param_1)

{
  byte *pbVar1;
  byte *extraout_A1;
  
  DAT_0000464a = *param_1;
  DAT_0000464b = param_1[1];
  pbVar1 = (byte *)&DAT_0000464c;
  DAT_0000464c = param_1[2];
  DAT_0000464d = param_1[3];
  DAT_0000464e = param_1[4];
  DAT_0000464f = param_1[5];
  DAT_00004650 = param_1[6];
  DAT_00004651 = param_1[7];
  DAT_00004652 = param_1[8];
  DAT_00004653 = param_1[9];
  DAT_00004654 = param_1[10];
  if (((DAT_000038c4 & 4) != 0) && ((DAT_000038c5 & 0x40) == 0)) {
    DAT_000038c4 = DAT_000038c4 & 0xfb;
    Function_00058026();
    pbVar1 = extraout_A1;
  }
  if (DAT_0000464a == 'O') {
    RAM_Samp_pek[0xc] = RAM_Samp_pek[0xc] | 4;
    if (*pbVar1 == 1) {
      Function_0005F574();
    }
    else if (*pbVar1 == 2) {
      Function_0005FEC4();
    }
    else if (*pbVar1 == 3) {
      Function_00060138();
    }
    else if (*pbVar1 == 4) {
      Function_000601B6();
    }
    else if (*pbVar1 == 5) {
      Function_00060260();
    }
    else if (*pbVar1 == 6) {
      Function_0005FAE6();
    }
    else if (*pbVar1 == 7) {
      Function_000600BA();
    }
    else {
      Function_00060AAA();
    }
  }
  else if (DAT_0000464a == 'W') {
    RAM_Samp_pek[0xc] = RAM_Samp_pek[0xc] & 0xfb;
    if (((*pbVar1 & 0x3f) < 0x20) || (0x29 < (*pbVar1 & 0x3f))) {
      if ((*pbVar1 & 0x3f) == 0x2d) {
        Function_0005A0CC();
      }
      else if ((*pbVar1 & 0x3f) == 0x2e) {
        Function_00058D16();
      }
      else if ((*pbVar1 & 0x3f) == 0x2f) {
        Function_00059314();
      }
      else if ((*pbVar1 & 0x3f) == 0x30) {
        Function_00059AD4();
      }
      else if ((*pbVar1 & 0x3f) == 0x31) {
        Function_0005970C();
      }
      else if ((*pbVar1 & 0x3f) == 0x3f) {
        Function_00057FEE();
      }
      else {
        Function_000596DC();
      }
    }
    else if ((*pbVar1 & 0x3f) == 0x20) {
      Function_00059994();
    }
    else if ((*pbVar1 & 0x3f) == 0x21) {
      Function_00057836();
    }
    else if ((*pbVar1 & 0x3f) == 0x29) {
      Function_000592B8();
    }
    else {
      Function_000596DC();
    }
  }
  else {
    Function_000596DC();
  }
  Function_00045AAA(&DAT_0000463e);
  return;
}

```
