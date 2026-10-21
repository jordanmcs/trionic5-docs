# Function_00070CAE

**ROM:** `0x00070CAE`

```c

void Function_00070CAE(void)

{
  if ((RAM_Ramp_steg_[3] & 8) == 0) {
    if ((DAT_00001039 & 8) != 0) {
      if (RAM_P_Manifold10 < RAM_Trot_delta) {
        RAM_Trot_delta = RAM_Trot_delta - 1;
      }
      else if ((DAT_0000101c == '\0') && (DAT_00001066 < 0x96)) {
        if (((RAM_Trot_delta < RAM_P_Manifold10) && ((RAM_Samp_pek[0xf] & 0x40) == 0)) &&
           (DAT_00003a84 = DAT_00003a84 + 1, DAT_00003a84 == 0x50)) {
          if (RAM_Trot_delta < 0x32) {
            RAM_Trot_delta = RAM_Trot_delta + 1;
          }
          DAT_00003a84 = 0;
          RAM_Samp_pek[0xf] = RAM_Samp_pek[0xf] | 0x40;
        }
      }
      else {
        RAM_Samp_pek[0xf] = RAM_Samp_pek[0xf] & 0xbf;
      }
    }
  }
  else {
    RAM_Trot_delta = 0x25;
  }
  return;
}

```
