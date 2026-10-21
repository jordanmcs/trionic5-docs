# Function_0004362A

**ROM:** `0x0004362A`

```c

void Function_0004362A(void)

{
  char cVar1;
  
  if ((RAM_Ramp_steg_[3] & 2) == 0) {
    if (((ushort)(DAT_00005eb8 - (ushort)RAM_Gear_st_[0]) < DAT_00003608) &&
       (DAT_00003608 < (ushort)(DAT_00005eb8 + (ushort)RAM_Gear_st_[0]))) {
      cVar1 = Function_00044550();
      if (((cVar1 == '\x01') && ((RAM_Ramp_steg_[1] & 0x40) == 0)) &&
         ((RAM_Ramp_steg_[4] & 0x10) == 0)) {
        RAM_PWM_ut10 = 0x52;
      }
      else {
        RAM_PWM_ut10 = 1;
      }
    }
    else if (((ushort)(DAT_00005eba - (ushort)RAM_Gear_st_[1]) < DAT_00003608) &&
            (DAT_00003608 < (ushort)(DAT_00005eba + (ushort)RAM_Gear_st_[1]))) {
      RAM_PWM_ut10 = 2;
    }
    else if (((ushort)(DAT_00005ebc - (ushort)RAM_Gear_st_[2]) < DAT_00003608) &&
            (DAT_00003608 < (ushort)(DAT_00005ebc + (ushort)RAM_Gear_st_[2]))) {
      RAM_PWM_ut10 = 3;
    }
    else if (((ushort)(DAT_00005ebe - (ushort)RAM_Gear_st_[3]) < DAT_00003608) &&
            (DAT_00003608 < (ushort)(DAT_00005ebe + (ushort)RAM_Gear_st_[3]))) {
      RAM_PWM_ut10 = 4;
    }
    else if (((ushort)(DAT_00005ec0 - (ushort)RAM_Gear_st_[4]) < DAT_00003608) &&
            (DAT_00003608 < (ushort)(DAT_00005ec0 + (ushort)RAM_Gear_st_[4]))) {
      RAM_PWM_ut10 = 5;
    }
    else {
      RAM_PWM_ut10 = 0x55;
    }
  }
  else {
    cVar1 = Function_00044550();
    if (((cVar1 == '\x01') && ((RAM_Ramp_steg_[1] & 0x40) == 0)) &&
       ((RAM_Ramp_steg_[4] & 0x10) == 0)) {
      RAM_PWM_ut10 = 0x52;
    }
    else {
      RAM_PWM_ut10 = 0x55;
    }
  }
  return;
}

```
