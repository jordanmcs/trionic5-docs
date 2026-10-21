# Function_000610D2

**ROM:** `0x000610D2`

```c

void Function_000610D2(void)

{
  if ((DAT_00003886 & 0x40) == 0) {
    if (((((DAT_00001066 < DAT_00005ac2) && (RAM_Kadapt_rpm_high_ < DAT_00001066)) &&
         (DAT_00001032 < DAT_00005ac6)) &&
        (((DAT_00005ac8 < DAT_00001032 && ('<' < DAT_0000102e)) &&
         ((RAM_Ret_temp[0] == 0 && ((RAM_Ret_temp[1] == 0 && (RAM_Ret_temp[2] == 0)))))))) &&
       ((RAM_Ret_temp[3] == 0 &&
        ((((RAM_Acc_temp[0] == 0 && (RAM_Acc_temp[1] == 0)) && (RAM_Acc_temp[2] == 0)) &&
         (RAM_Acc_temp[3] == 0)))))) {
      if (RAM_Kadapt_ref_value < 100) {
        DAT_00003896 = RAM_Ign_offset_cyl4_;
        if (9 < DAT_0000388c) {
          (&DAT_0000423a)[(short)RAM_Kadapt_ref_value] = DAT_0000112c;
          RAM_Kadapt_ref_value = RAM_Kadapt_ref_value + 1;
        }
      }
      else {
        DAT_00003886 = DAT_00003886 | 0x40;
        RAM_Kadapt_ref_value = 0;
        DAT_00003896 = 0;
        DAT_0000388c = 0;
      }
      if (DAT_0000388c < 10) {
        DAT_0000388c = DAT_0000388c + 1;
      }
    }
    else {
      DAT_00003896 = 0;
      DAT_0000388c = 0;
    }
  }
  else {
    DAT_00003896 = 0;
    DAT_0000388c = 0;
  }
  return;
}

```
