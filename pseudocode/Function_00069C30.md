# Function_00069C30

**ROM:** `0x00069C30`

```c

void Function_00069C30(void)

{
  RAM_AD_EGR = (byte)(RAM_Cat_ox1_duty_cycle / 0x14);
  DAT_0000405c = RAM_Cat_ox1_duty_cycle;
  RAM_LmpThr = (byte)(RAM_U_lambda_eng / 0x14);
  DAT_0000405a = RAM_U_lambda_eng;
  DAT_00004056 = DAT_00001013;
  DAT_00004050 = DAT_00003b52;
  RAM_AD_bat = DAT_00003b52;
  DAT_000046de = (ushort)((ushort)DAT_00001015 * 0x10 + DAT_000046de * 4) / 5;
  RAM_P_Manifold10 = (byte)(DAT_000046de >> 4);
  if ((RAM_Ramp_steg_[3] & 8) == 0) {
    if (((ushort)DAT_00001015 < (ushort)(RAM_Trot_delta + 5)) && ((RAM_Samp_pek[0] & 0x10) == 0)) {
      if ((ushort)DAT_00001015 <= (ushort)(RAM_Trot_delta + 3)) {
        DAT_0000103a = DAT_0000103a | 4;
      }
    }
    else {
      DAT_0000103a = DAT_0000103a & 0xfb;
    }
  }
  else if ((DAT_00003b9e < 0x93) && ((RAM_Samp_pek[0] & 0x10) == 0)) {
    if (DAT_00003b9e < 0x8e) {
      DAT_0000103a = DAT_0000103a | 4;
    }
  }
  else {
    DAT_0000103a = DAT_0000103a & 0xfb;
  }
  if ((DAT_00001026 & 1) == 0) {
    if ((DAT_00001013 == -1) || (DAT_00001013 == '\0')) {
      DAT_0000104e = DAT_0000104e + 1;
      if (2 < DAT_0000104e) {
        DAT_00001026 = DAT_00001026 | 1;
        DAT_0000103b = DAT_0000103b | 0x40;
      }
    }
    else {
      DAT_0000104e = 0;
    }
  }
  if (DAT_000046e0 < (ushort)(-(ushort)DAT_00001032 - 1)) {
    DAT_000046e0 = DAT_00001032 + DAT_000046e0;
    DAT_000046e2 = DAT_000046e2 + 1;
  }
  DAT_00004734 = DAT_00004734 & 0x7f;
  return;
}

```
