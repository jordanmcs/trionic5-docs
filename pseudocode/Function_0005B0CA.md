# Function_0005B0CA

**ROM:** `0x0005B0CA`

```c

void Function_0005B0CA(void)

{
  byte bVar1;
  
  if ((RAM_Samp_pek[6] & 0x10) == 0) {
    DAT_0000400e = DAT_0000400e & 0xbf;
    if ((DAT_00003b72 < 2000) || ((DAT_000072a2 <= RAM_Bil_hast && (RAM_Bil_hast < 0xa1)))) {
      RAM_Knock_time_low = DAT_00001a58;
    }
    else {
      DAT_0000400e = DAT_0000400e | 0x40;
    }
    if ((int)RAM_Knock_time_low + 0x1eU < (uint)DAT_00001a58) {
      RAM_Samp_pek[6] = RAM_Samp_pek[6] | 0x10;
      DAT_0000400e = DAT_0000400e | 0x40;
    }
    else if (((RAM_Samp_pek[6] & 8) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
      if (DAT_00001d25 < 0x28) {
        bVar1 = DAT_00003fe8 >> 6 & 1;
      }
      else if ((((DAT_00003fe8 & 0x20) == 0) || (RAM_Bil_hast < DAT_000072a2)) ||
              (0x9f < RAM_Bil_hast)) {
        bVar1 = 0;
      }
      else {
        bVar1 = 1;
      }
      if ((bVar1 != 0) && (DAT_00001d25 != 0)) {
        DAT_00001d25 = DAT_00001d25 - 1;
        RAM_Samp_pek[6] = RAM_Samp_pek[6] | 8;
      }
    }
    if ((DAT_0000400e & 0x40) == 0) {
      if (5 < (uint)((int)DAT_00001a58 - (int)DAT_00004010)) {
        DAT_0000400e = DAT_0000400e & 0x7f;
      }
    }
    else {
      DAT_00004010 = DAT_00001a58;
      DAT_0000400e = DAT_0000400e | 0x80;
    }
    if (DAT_00001d25 == 0) {
      DAT_000040e6 = DAT_000040e6 & 0xef;
    }
  }
  return;
}

```
