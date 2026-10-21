# Function_0005E768

**ROM:** `0x0005E768`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0005E768(void)

{
  if (((((DAT_0000103a & 0x80) == 0) || ((DAT_0000103a & 0x40) == 0)) ||
      ((DAT_0000103a & 0x20) == 0)) ||
     ((((DAT_0000103a & 0x10) == 0 || (0x5db < DAT_00003e2a)) ||
      ((DAT_0000102e < '=' || ((DAT_00001a58 < 0xb5 || ((DAT_0000103d & 1) == 0)))))))) {
    DAT_00004078 = RAM_Crankshaft_error;
    RAM_Samp_pek[1] = RAM_Samp_pek[1] & 0x7f;
  }
  else if (RAM_AD_EGR == 0) {
    if ((RAM_LmpThr < 10) && ((RAM_Samp_pek[1] & 0x80) == 0)) {
      RAM_Samp_pek[1] = RAM_Samp_pek[1] | 0x80;
      _DAT_000010b2 = RAM_Crankshaft_error._2_2_ - DAT_00004078._2_2_;
    }
  }
  else {
    DAT_00004078 = RAM_Crankshaft_error;
  }
  if (((DAT_00001015 < 0xb5) || (DAT_0000102e < '=')) || (DAT_00001a58 < 0xb5)) {
    DAT_0000407c = RAM_Crankshaft_error;
    RAM_Samp_pek[7] = RAM_Samp_pek[7] & 0xfe;
  }
  else if (RAM_AD_EGR < 0x26) {
    DAT_0000407c = RAM_Crankshaft_error;
  }
  else if ((0x1e < RAM_LmpThr) && ((RAM_Samp_pek[7] & 1) == 0)) {
    RAM_Samp_pek[7] = RAM_Samp_pek[7] | 1;
    _DAT_000010b0 = RAM_Crankshaft_error._2_2_ - DAT_0000407c._2_2_;
  }
  return;
}

```
