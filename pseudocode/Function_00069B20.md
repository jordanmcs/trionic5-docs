# Function_00069B20

**ROM:** `0x00069B20`

```c

void Function_00069B20(void)

{
  undefined2 *extraout_A1;
  
  if ((RAM_Ramp_steg_[0] & 8) == 0) {
    DAT_0000103c = DAT_0000103c | 0x10;
    RAM_Temp_fak = 0;
  }
  else if ((RAM_Ramp_steg_[3] & 0x80) == 0) {
    if ((DAT_0000103b & 0x80) == 0) {
      if ((DAT_00001039 & 0x40) == 0) {
        DAT_0000103c = DAT_0000103c | 0x10;
        RAM_Temp_fak = 0;
      }
      else {
        if ((DAT_000035f4 < DAT_00004b30) || (RAM_Temp_fak == 0)) {
          DAT_000035f4 = DAT_000035f4 + 1;
        }
        else {
          RAM_Temp_fak = RAM_Temp_fak - 1;
          DAT_000035f4 = 0;
        }
        if (RAM_Temp_fak == 0) {
          DAT_00001039 = DAT_00001039 & 0xbf;
        }
      }
    }
    else {
      RAM_Temp_fak = Function_0006A4E4(RAM_Retard_detekt_,&DAT_00004b20);
      DAT_00001039 = DAT_00001039 | 0x40;
      *extraout_A1 = 0;
      if (RAM_Temp_fak == 0) {
        DAT_0000103c = DAT_0000103c | 0x10;
      }
      else {
        DAT_0000103c = DAT_0000103c & 0xef;
      }
    }
  }
  else {
    RAM_Temp_fak = Function_0006A4E4(RAM_Retard_detekt_,&DAT_00004b20);
    if (RAM_Temp_fak == 0) {
      DAT_0000103c = DAT_0000103c | 0x10;
    }
    else {
      DAT_0000103c = DAT_0000103c & 0xef;
    }
  }
  return;
}

```
