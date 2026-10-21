# Function_00060ADA

**ROM:** `0x00060ADA`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00060ADA(void)

{
  for (DAT_0000350c = 0;
      (*(ushort *)(RAM_Knock_average_tab_ + DAT_0000350c * 2) < DAT_00001066 &&
      (DAT_0000350c != 0xf)); DAT_0000350c = DAT_0000350c + 1) {
  }
  if ((ushort)RAM_Knock_average_tab_._0_2_ < DAT_00001066) {
    if (DAT_00001066 < (ushort)RAM_Knock_average_tab_._30_2_) {
      DAT_000034f6 = *(short *)(RAM_Knock_average_tab_ + DAT_0000350c * 2) -
                     *(short *)(RAM_Knock_average_tab_ + (short)(DAT_0000350c + -1) * 2);
      DAT_000034e0 = DAT_00001066 -
                     *(short *)(RAM_Knock_average_tab_ + (short)(DAT_0000350c + -1) * 2);
    }
    else {
      DAT_000034e0 = 1;
      DAT_000034f6 = 1;
    }
  }
  else {
    DAT_000034e0 = 0;
    DAT_0000350c = 1;
    DAT_000034f6 = 1;
  }
  RAM_Knock_diag_level =
       (&DAT_00006714)[(short)(DAT_0000350c + -1)] +
       (short)(((&DAT_00006714)[DAT_0000350c] - (&DAT_00006714)[(short)(DAT_0000350c + -1)]) *
              DAT_000034e0) / DAT_000034f6;
  _DAT_00001102 = DAT_000010b4 - RAM_Knock_diag_level;
  DAT_00001104 = *(short *)(RAM_Knock_wind_on_tab_ + (short)(DAT_0000350c + -1) * 2) +
                 (short)((*(short *)(RAM_Knock_wind_on_tab_ + DAT_0000350c * 2) -
                         *(short *)(RAM_Knock_wind_on_tab_ + (short)(DAT_0000350c + -1) * 2)) *
                        DAT_000034e0) / DAT_000034f6;
  RAM_Knock_wind_off = DAT_000010b4 - DAT_00001104;
  return;
}

```
