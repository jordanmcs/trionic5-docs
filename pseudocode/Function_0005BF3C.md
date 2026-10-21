# Function_0005BF3C

**ROM:** `0x0005BF3C`

```c

void Function_0005BF3C(void)

{
  RAM_STSWFS = Function_000755A8();
  if ((RAM_Samp_pek[0x10] & 0x20) == 0) {
    if ((RAM_STSWFS != 0) && (RAM_STSWFS != 2)) {
      DAT_0000385c = DAT_00001a58 + 2;
    }
    if (((RAM_STSWFS == 0) && (2 < DAT_00001a58)) && (DAT_0000385c < DAT_00001a58)) {
      RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] | 0x20;
      if (DAT_0000331b < 0x28) {
        DAT_0000331b = 0x28;
        RAM_VSS_status = RAM_STSWFS;
      }
      else {
        DAT_0000331b = 0x2c;
        RAM_VSS_status = RAM_STSWFS;
      }
    }
    else if (((RAM_STSWFS == 2) && (2 < DAT_00001a58)) && (DAT_0000385c < DAT_00001a58)) {
      RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] | 0x20;
      if (DAT_0000331c < 0x28) {
        DAT_0000331c = 0x28;
        RAM_VSS_status = RAM_STSWFS;
      }
      else {
        DAT_0000331c = 0x2c;
        RAM_VSS_status = RAM_STSWFS;
      }
    }
    else if (((RAM_STSWFS == 1) && ((RAM_Samp_pek[4] & 2) != 0)) &&
            (((RAM_Samp_pek[0x10] & 0x40) == 0 && (5 < DAT_00001a58)))) {
      if (DAT_0000331b != 0) {
        DAT_0000331b = DAT_0000331b - 1;
        RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] | 0x40;
      }
      if (DAT_0000331c != 0) {
        DAT_0000331c = DAT_0000331c - 1;
        RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] | 0x40;
      }
    }
  }
  return;
}

```
