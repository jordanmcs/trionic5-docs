# Function_000755E0

**ROM:** `0x000755E0`

```c

void Function_000755E0(void)

{
  undefined1 uVar1;
  char cVar2;
  
  switch(DAT_00003ac4) {
  case 0:
    if ((RAM_Ramp_steg_[5] & 0x80) == 0) {
      DAT_00003a9c = 0;
      DAT_00003ac4 = 9;
    }
    else {
      if (DAT_00004868 == '\0') {
        DAT_00004870 = '\x01';
        DAT_0000486e = (ushort)(byte)(DAT_00003b5a & 3 |
                                     (DAT_00003b4e & 3 | (DAT_00003b62 & 3 | DAT_00003b66 << 2) << 2
                                     ) << 2) << 8 | DAT_0000486e & 0xff;
        RAM_TWFSSR = 2;
        DAT_00003ac6 = 0xff;
        DAT_00004868 = -1;
      }
      else if (RAM_TWFSSR == 0) {
        DAT_00003ac6 = 0;
      }
      else if (RAM_TWFSSR == 1) {
        if ((ushort)(DAT_0000486c - DAT_0000486e) < 0x8001) {
          DAT_00003ac6 = 0;
        }
        else {
          RAM_TWFSSR = 2;
          DAT_00003ac6 = 0xff;
        }
      }
      else if (RAM_TWFSSR == 2) {
        DAT_00003ac6 = 0xff;
      }
      if ((DAT_00001066 < 0x1e) && (DAT_00004864 < 0x1e)) {
        DAT_00004870 = '\x01';
      }
      Function_00075098();
      DAT_00003ac4 = 1;
    }
    break;
  case 1:
    uVar1 = Function_0007520C();
    switch(uVar1) {
    case 0:
      DAT_00004870 = '\0';
      break;
    case 1:
      if (DAT_00004870 == '\0') {
        return;
      }
      if (DAT_00001066 < 0x1f) {
        return;
      }
      if (RAM_TWFSSR != 0) {
        return;
      }
      RAM_TWFSSR = 1;
      DAT_0000486c = DAT_0000486e + DAT_00003acc * 100;
      return;
    default:
      if ((DAT_00004870 != '\0') || (DAT_00004866 < 10)) {
        Function_00075260();
        DAT_00003ac4 = 5;
        goto switchD_0007596e_caseD_5;
      }
    }
    DAT_00003ac6 = 0;
    RAM_TWFSSR = 0;
    DAT_00004874 = DAT_0000486e + DAT_00003aca * 100;
    Function_00075260();
    DAT_00003ac4 = 2;
  case 2:
    cVar2 = Function_0004A4D2();
    if (cVar2 == '\0') {
      DAT_00003ac4 = 6;
    }
    else {
      if (0x8000 < (ushort)(DAT_00004874 - DAT_0000486e)) {
        DAT_00004870 = '\x01';
      }
      if (0x1d < DAT_00001066) {
        if (DAT_00004870 == '\0') {
          DAT_00003ac4 = 3;
switchD_0007596e_caseD_3:
          DAT_00004866 = DAT_0000101c;
          DAT_00004864 = DAT_00001066;
          if (DAT_00001066 < 0x1e) {
            DAT_00003ac4 = 0;
          }
          else {
            cVar2 = Function_0004A4D2();
            if (cVar2 == '\0') {
              DAT_00003ac4 = 6;
            }
          }
        }
        else {
          DAT_00003ac4 = 0;
        }
      }
    }
    break;
  case 3:
    goto switchD_0007596e_caseD_3;
  default:
    DAT_00003ac4 = 0;
    break;
  case 5:
switchD_0007596e_caseD_5:
    DAT_00003ac6 = 0xff;
    DAT_00004870 = 1;
    cVar2 = Function_0004A4D2();
    if (cVar2 != '\0') {
      if (RAM_TWFSSR != 1) {
        return;
      }
      if ((ushort)(DAT_0000486c - DAT_0000486e) < 0x8001) {
        return;
      }
      RAM_TWFSSR = 2;
      return;
    }
    goto LAB_0007591e;
  case 6:
    DAT_00004872 = DAT_0000486e + RAM_TWFSVNNX * 100;
    DAT_00003ac4 = 7;
  case 7:
    if ((ushort)(DAT_00004872 - DAT_0000486e) < 0x8001) {
      cVar2 = Function_0004A4D2();
      if (cVar2 != '\0') {
        DAT_00003ac4 = 0;
      }
    }
    else {
LAB_0007591e:
      DAT_00004866 = 0;
      DAT_00004864 = 0;
      DAT_00004870 = '\x01';
      DAT_00003ac4 = 8;
switchD_0007596e_caseD_8:
      cVar2 = Function_0004A4D2();
      if (cVar2 != '\0') {
        DAT_00003ac4 = 0;
      }
    }
    break;
  case 8:
    goto switchD_0007596e_caseD_8;
  case 9:
    break;
  }
  return;
}

```
