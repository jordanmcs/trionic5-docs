# Function_00071F30

**ROM:** `0x00071F30`

```c

void Function_00071F30(void)

{
  char cVar1;
  byte *extraout_A1;
  undefined2 *puVar2;
  undefined2 *extraout_A1_00;
  undefined2 *extraout_A1_01;
  
  if ((RAM_Ramp_steg_[3] & 2) == 0) {
    if (DAT_00003a76 != '\x02') {
      if (DAT_00003a76 != '\x01') {
        if (DAT_00003b02 <= DAT_0000386c + 3000U) {
          if ((DAT_000038c2 & 1) == 0) {
            Function_00044D28();
          }
          DAT_00003a76 = 3;
          return;
        }
        if ((DAT_000038c2 & 1) == 0) {
          Function_00044D28();
        }
      }
      if (DAT_0000102e <= DAT_00007642) {
        DAT_00003a76 = 1;
        return;
      }
    }
    if ((((RAM_PWM_ut10 == 4) || (RAM_PWM_ut10 == 3)) || (RAM_PWM_ut10 == 2)) || (RAM_PWM_ut10 == 1)
       ) {
      cVar1 = Function_00044D28();
      if (cVar1 == '\0') {
        DAT_0000359a = DAT_00007652 + RAM_Shift_up_temp_;
        DAT_0000359c = DAT_00007652 + *(short *)(RAM_Shift_max_rpm_ + (short)(*extraout_A1 - 1) * 2)
        ;
        DAT_0000359e = RAM_Shift_rpm_[(short)(*extraout_A1 - 1)] - RAM_Shift_up_rpm_hyst_;
      }
      else {
        if (DAT_00007652 < RAM_Shift_up_temp_) {
          DAT_0000359a = RAM_Shift_up_temp_ - DAT_00007652;
          DAT_0000359c = *(short *)(RAM_Shift_max_rpm_ + (short)(*extraout_A1 - 1) * 2) -
                         DAT_00007652;
        }
        else {
          DAT_0000359a = 0;
          DAT_0000359c = 0;
        }
        DAT_0000359e = RAM_Shift_up_rpm_hyst_ + RAM_Shift_rpm_[(short)(*extraout_A1 - 1)];
      }
      puVar2 = &DAT_00003a72;
      if (DAT_0000359a < DAT_00003c32) {
        if ((DAT_000038c2 & 1) == 0) {
          Function_00044D28();
          puVar2 = extraout_A1_00;
        }
        DAT_00003a74 = 0;
        *puVar2 = 0;
      }
      else if (DAT_0000359c < DAT_00003c32) {
        if (DAT_00001032 < DAT_0000359e) {
          if ((DAT_0000103a & 4) == 0) {
            if (RAM_Shift_up_off_time_ < DAT_00003a74) {
              if ((DAT_000038c2 & 1) == 0) {
                Function_00044D28();
                puVar2 = extraout_A1_01;
              }
              *puVar2 = 0;
            }
            else {
              if ((DAT_000038c2 & 1) == 0) {
                Function_00044D28();
              }
              DAT_00003a74 = DAT_00003a74 + 1;
            }
          }
          else {
            if ((DAT_000038c2 & 1) == 0) {
              Function_00044D28();
            }
            DAT_00003a74 = 0;
          }
        }
        else if (DAT_00007656 < DAT_00003a72) {
          if ((DAT_000038c2 & 1) == 0) {
            Function_00044D28();
          }
          DAT_00003a74 = 0;
        }
        else {
          DAT_00003a72 = DAT_00003a72 + 1;
        }
      }
      else if (DAT_00007656 < DAT_00003a72) {
        if ((DAT_000038c2 & 1) == 0) {
          Function_00044D28();
        }
        DAT_00003a74 = 0;
      }
      else {
        DAT_00003a72 = DAT_00003a72 + 1;
      }
    }
    else {
      if ((DAT_000038c2 & 1) == 0) {
        Function_00044D28();
      }
      DAT_00003a74 = 0;
    }
    DAT_00003a76 = '\x02';
  }
  else if ((DAT_000038c2 & 1) == 0) {
    Function_00044D28();
  }
  return;
}

```
