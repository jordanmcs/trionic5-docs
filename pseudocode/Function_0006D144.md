# Function_0006D144

**ROM:** `0x0006D144`

```c

void Function_0006D144(void)

{
  char cVar2;
  short sVar1;
  char *extraout_A1;
  undefined1 *extraout_A1_00;
  
  Function_00072380();
  if ((DAT_000038c4 & 4) != 0) {
    Function_00058026();
  }
  Function_000694B2();
  if ((RAM_Ramp_steg_[4] & 8) == 0) {
    if ((DAT_000038c5 & 0x80) == 0) {
      if ((RAM_Ramp_steg_[5] & 0x20) == 0) {
        if ((RAM_Ramp_steg_[3] & 2) != 0) {
          sVar1 = Function_00044B86();
          if (sVar1 == 0x44) {
            Function_0004492E();
          }
          else {
            Function_0004492E();
          }
        }
      }
      else if ((DAT_00001039 & 8) == 0) {
        Function_0004492E();
      }
      else {
        cVar2 = Function_00044BA4();
        if ((((cVar2 == '\x01') &&
             ((short)((ushort)DAT_00001015 - (ushort)RAM_Trot_delta) < (short)(ushort)DAT_000061f4))
            && (DAT_000061f5 < DAT_00001013)) && (*extraout_A1 == '\0')) {
          *extraout_A1 = '\x01';
          DAT_00003a20 = DAT_00003b02;
          Function_0004492E();
        }
        else if (DAT_00003a20 + DAT_000061f6 < DAT_00003b02) {
          Function_0004492E();
        }
        cVar2 = Function_00044BA4();
        if (cVar2 != '\x01') {
          *extraout_A1_00 = 0;
        }
      }
    }
  }
  else {
    Function_0004A63E();
  }
  if ((DAT_00006e20 & 0x80) != 0) {
    Function_0004CC80();
  }
  return;
}

```
