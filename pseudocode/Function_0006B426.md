# Function_0006B426

**ROM:** `0x0006B426`

```c

void Function_0006B426(void)

{
  short sVar1;
  byte bVar2;
  ushort *extraout_A1;
  bool bVar3;
  
  if ((RAM_Ramp_steg_[3] & 0x40) == 0) {
    DAT_00003a19 = DAT_00003a19 & 0xfe | 6;
    DAT_00003a08 = 0;
  }
  else if (((DAT_0000103b & 0x20) == 0) && ((DAT_00003a19 & 4) != 0)) {
    DAT_00003a19 = DAT_00003a19 & 0xfe;
    DAT_00003a08 = 0;
  }
  else if ((DAT_00001032 < RAM_Min_load_gadapt_) &&
          ((((DAT_00001066 < DAT_00004b7c && (RAM_Ret_tab_mul_ < DAT_00001032)) &&
            (RAM_Max_load_gadapt_ < DAT_00001066)) && (RAM_Start_detekt_nr_ == RAM_Rpm_byte)))) {
    if (DAT_00003a08 < 0xfa) {
      DAT_00003a08 = DAT_00003a08 + 1;
    }
    sVar1 = Function_000445AC();
    if (sVar1 == 1) {
      if ((DAT_00003a0a == '\0') && (200 < *extraout_A1)) {
        *extraout_A1 = 200;
      }
      DAT_00003a0a = '\x01';
    }
    else {
      DAT_00003a0a = '\0';
    }
    if ((DAT_00003a19 & 4) == 0) {
      DAT_00003a19 = DAT_00003a19 & 0xfd | 1;
    }
    else {
      DAT_00003a19 = DAT_00003a19 | 3;
    }
    if (*extraout_A1 == 0xfa) {
      if (DAT_00003a10 < DAT_00004b7e) {
        DAT_00003a10 = DAT_00003a10 + 1;
        DAT_00003a0c = DAT_00001031 + DAT_00003a0c;
      }
      else if (((DAT_00001a58 <= DAT_00001a84 + 3U) || (99 < RAM_Cat_ox1_duty_cycle)) ||
              (RAM_U_lambda_eng < 0x2ef)) {
        DAT_000046f4 = (byte)(DAT_00003a0c / DAT_00003a10);
        DAT_00003a10 = 0;
        DAT_00003a0c = 0;
        if (DAT_000046f4 < 0x81) {
          bVar2 = RAM_Rpm_byte - (-0x80 - DAT_000046f4);
          bVar3 = RAM_Rpm_byte < bVar2;
          RAM_Rpm_byte = bVar2;
          if (bVar3) {
            RAM_Rpm_byte = 0;
          }
        }
        else {
          bVar2 = DAT_000046f4 + RAM_Rpm_byte + 0x80;
          bVar3 = bVar2 < RAM_Rpm_byte;
          RAM_Rpm_byte = bVar2;
          if (bVar3) {
            RAM_Rpm_byte = 0xff;
          }
        }
        DAT_00003a19 = DAT_00003a19 | 4;
        RAM_Samp_pek[0xc] = RAM_Samp_pek[0xc] | 8;
      }
    }
  }
  else {
    DAT_00003a19 = DAT_00003a19 & 0xfe;
    DAT_00003a08 = 0;
  }
  return;
}

```
