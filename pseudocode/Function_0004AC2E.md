# Function_0004AC2E

**ROM:** `0x0004AC2E`

```c

void Function_0004AC2E(undefined4 param_1)

{
  undefined1 uVar2;
  ushort uVar1;
  byte *extraout_A1;
  code *extraout_A1_00;
  code *extraout_A1_01;
  code *extraout_A1_02;
  code *extraout_A1_03;
  code *extraout_A1_04;
  code *extraout_A1_05;
  code *extraout_A1_06;
  code *extraout_A1_07;
  code *extraout_A1_08;
  code *extraout_A1_09;
  code *extraout_A1_10;
  code *extraout_A1_11;
  code *extraout_A1_12;
  code *extraout_A1_13;
  code *extraout_A1_14;
  undefined2 uVar3;
  
  DAT_000034aa = (char)param_1;
  if (param_1._1_1_ == 'O') goto LAB_0004b2d0;
  if (param_1._1_1_ == 'T') {
    if (DAT_0000373a == '\x01') {
      uVar2 = Function_0004ABEA();
      Function_00049AB6(uVar2);
    }
    if (4 < DAT_0000373c) goto LAB_0004b2d0;
  }
  else {
    if ((char)param_1 == '\x13') {
      if ((DAT_0000373e & 1) == 0) {
        DAT_000034a8 = DAT_00003762;
        DAT_00003762 = 0;
        DAT_0000373e = DAT_0000373e | 1;
      }
      goto LAB_0004b2d0;
    }
    if ((char)param_1 != '\x11') {
      Function_00049AB6(0x3e);
      if (*extraout_A1 == 0xd) {
        DAT_00003762 = 0;
        if (DAT_00003e52 == 'A') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e9c = (uint)uVar1;
          DAT_0000375e = (*extraout_A1_00)(0x3e57);
        }
        else if (DAT_00003e52 == 'B') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e98 = (uint)uVar1;
          DAT_0000375c = (*extraout_A1_01)(0x3e57);
        }
        else if (DAT_00003e52 == 'C') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e94 = (uint)uVar1;
          DAT_0000375a = (*extraout_A1_02)(0x3e57);
        }
        else if (DAT_00003e52 == 'D') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e90 = (uint)uVar1;
          DAT_00003758 = (*extraout_A1_03)(0x3e57);
        }
        else if (DAT_00003e52 == 'E') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e8c = (uint)uVar1;
          DAT_00003756 = (*extraout_A1_04)(0x3e57);
        }
        else if (DAT_00003e52 == 'F') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e88 = (uint)uVar1;
          DAT_00003754 = (*extraout_A1_05)(0x3e57);
        }
        else if (DAT_00003e52 == 'G') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e84 = (uint)uVar1;
          DAT_00003752 = (*extraout_A1_06)(0x3e57);
        }
        else if (DAT_00003e52 == 'H') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e80 = (uint)uVar1;
          DAT_00003750 = (*extraout_A1_07)(0x3e57);
        }
        else if (DAT_00003e52 == 'I') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e7c = (uint)uVar1;
          DAT_0000374e = (*extraout_A1_08)(0x3e57);
        }
        else if (DAT_00003e52 == 'J') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e78 = (uint)uVar1;
          DAT_0000374c = (*extraout_A1_09)(0x3e57);
        }
        else if (DAT_00003e52 == 'K') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e74 = (uint)uVar1;
          DAT_0000374a = (*extraout_A1_10)(0x3e57);
        }
        else if (DAT_00003e52 == 'L') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e70 = (uint)uVar1;
          DAT_00003748 = (*extraout_A1_11)(0x3e57);
        }
        else if (DAT_00003e52 == 'M') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e6c = (uint)uVar1;
          DAT_00003746 = (*extraout_A1_12)(0x3e57);
        }
        else if (DAT_00003e52 == 'N') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e68 = (uint)uVar1;
          DAT_00003744 = (*extraout_A1_13)(0x3e57);
        }
        else if (DAT_00003e52 == 'O') {
          uVar1 = Function_0004B86A(0x3e53);
          DAT_00003e64 = (uint)uVar1;
          DAT_00003742 = (*extraout_A1_14)(0x3e57);
        }
        else if (DAT_00003e52 == 'R') {
          DAT_000034b0 = (byte *)&DAT_00003e53;
          DAT_000034ae = DAT_00003e53;
          if (DAT_00003e53 == 'A') {
            Function_0004B32A();
            DAT_00003762 = DAT_00003762 | 1;
          }
          else if (DAT_00003e53 == 'B') {
            Function_0004B388();
            DAT_00003762 = DAT_00003762 | 2;
          }
          else if (DAT_00003e53 == 'C') {
            Function_0004B3E6();
            DAT_00003762 = DAT_00003762 | 4;
          }
          else if (DAT_00003e53 == 'D') {
            Function_0004B444();
            DAT_00003762 = DAT_00003762 | 8;
          }
          else {
            DAT_00003e53 = 'R';
            Function_0004B4A2();
            DAT_00003762 = DAT_00003762 | 0x10;
          }
        }
        else if (DAT_00003e52 == 'W') {
          uVar3 = 0;
          uVar1 = Function_0004B86A(0x3e53);
          DAT_000034b0 = (byte *)(uint)uVar1;
          uVar1 = (ushort)DAT_00003e57;
          DAT_000034ae = Function_0006A730(uVar3);
          DAT_000034ac = Function_0006A730(uVar1);
          if ((DAT_000034b0 < &DAT_00001000) || ((byte *)0x7fff < DAT_000034b0)) {
            DAT_0000373c = 0;
            DAT_0000373a = '\0';
            DAT_00003762 = 0;
          }
          else if ((((DAT_00042f59 == '\0') ||
                    ((RAM_Start_time_tot + 3 < DAT_000034b0 &&
                     (DAT_000034b0 < (byte *)((int)&DAT_00001d2a + 1))))) ||
                   (((byte *)0x3319 < DAT_000034b0 && (DAT_000034b0 < &DAT_00003334)))) ||
                  (((RAM_MisCountMap3 + 0x11f < DAT_000034b0 && (DAT_000034b0 < &RAM_After_fcut)) ||
                   (((byte *)((int)&DAT_000019a2 + 3) < DAT_000034b0 &&
                    (DAT_000034b0 < (byte *)((int)&DAT_00001a58 + 1))))))) {
            *DAT_000034b0 = DAT_000034ac + DAT_000034ae * '\x10';
          }
        }
        else if (DAT_00003e52 == 'S') {
          Function_0004B696();
          DAT_00003762 = DAT_00003762 | 0x20;
        }
        else if (DAT_00003e52 == 's') {
          Function_0004B7EC();
          DAT_00003762 = DAT_00003762 | 0x40;
        }
        else if (DAT_00003e52 == '#') {
          DAT_0000373e = DAT_0000373e & 0xbf;
        }
        DAT_00003760 = 0;
      }
      else {
        DAT_000034b0 = (byte *)(&DAT_00003e52 + (short)(ushort)DAT_00003760);
        *DAT_000034b0 = *extraout_A1;
        if (DAT_00003760 < 0xe) {
          DAT_00003760 = DAT_00003760 + 1;
        }
        else {
          DAT_00003760 = 0;
        }
      }
      goto LAB_0004b2d0;
    }
    if ((DAT_0000373e & 1) != 0) {
      DAT_0000373e = DAT_0000373e & 0xfe;
      DAT_00003762 = DAT_000034a8;
    }
  }
  if ((DAT_00003762 & 1) == 0) {
    if ((DAT_00003762 & 2) == 0) {
      if ((DAT_00003762 & 4) == 0) {
        if ((DAT_00003762 & 8) == 0) {
          if ((DAT_00003762 & 0x10) == 0) {
            if ((DAT_00003762 & 0x20) == 0) {
              if ((DAT_00003762 & 0x40) != 0) {
                Function_0004B7EC();
              }
            }
            else {
              Function_0004B696();
            }
          }
          else {
            Function_0004B4A2();
          }
        }
        else {
          Function_0004B444();
        }
      }
      else {
        Function_0004B3E6();
      }
    }
    else {
      Function_0004B388();
    }
  }
  else {
    Function_0004B32A();
  }
LAB_0004b2d0:
  if ((DAT_00003762 == 0) && (DAT_0000373a == '\0')) {
    Function_00049AB6(0x44);
    Function_00049AB6(0x45);
  }
  else {
    Function_00049AB6(0x45);
    Function_00049AB6(0x45);
  }
  return;
}

```
