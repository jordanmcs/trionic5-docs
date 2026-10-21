# Function_000722E0

**ROM:** `0x000722E0`

```c

void Function_000722E0(void)

{
  short sVar1;
  byte *extraout_A1;
  byte *extraout_A1_00;
  
  if ((DAT_00001039 & 8) == 0) {
    DAT_00003a70 = '\0';
  }
  else if ((RAM_Ramp_steg_[3] & 2) == 0) {
    sVar1 = Function_00044B86();
    if (sVar1 == 0x4e) {
      if (DAT_00003a70 < 4) {
        DAT_00003a70 = DAT_00003a70 + 1;
      }
      else {
        *extraout_A1_00 = *extraout_A1_00 | 2;
        DAT_00003a70 = '\0';
      }
    }
    else {
      DAT_00003a70 = '\0';
    }
  }
  else {
    sVar1 = Function_00044B86();
    if (((sVar1 == 0x44) && (0x5a < DAT_00001037)) && (0x50 < DAT_0000101c)) {
      if (DAT_00003a70 < 4) {
        DAT_00003a70 = DAT_00003a70 + 1;
      }
      else {
        *extraout_A1 = *extraout_A1 & 0xfd;
        DAT_00003a70 = '\0';
      }
    }
    else {
      DAT_00003a70 = '\0';
    }
  }
  return;
}

```
