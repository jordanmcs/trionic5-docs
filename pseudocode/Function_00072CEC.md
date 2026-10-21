# Function_00072CEC

**ROM:** `0x00072CEC`

```c

void Function_00072CEC(void)

{
  short sVar1;
  code *extraout_A1;
  
  if ((DAT_00001039 & 8) == 0) {
    Function_0004492E();
    DAT_00003a86 = 0;
  }
  else {
    DAT_000047a2 = (ushort)DAT_00001015 - (ushort)DAT_000047a0;
    sVar1 = Function_0004492E();
    if (sVar1 == 1) {
      if (DAT_00003a86 < RAM_I_fak_max_) {
        if (DAT_000047a2 < (short)RAM_Max_um_time_) {
          DAT_00003a86 = DAT_00003a86 + 1;
        }
        else {
          (*extraout_A1)();
        }
      }
      else {
        (*extraout_A1)();
      }
    }
    else if (DAT_00001015 < RAM_Max_neg_der_) {
      if ((short)RAM_Max_pos_der_ < DAT_000047a2) {
        if (DAT_00001015 < DAT_00005ea4) {
          (*extraout_A1)();
          DAT_00003a86 = 0;
        }
      }
      else {
        (*extraout_A1)();
        DAT_00003a86 = 0;
      }
    }
    DAT_000047a0 = DAT_00001015;
  }
  return;
}

```
