# Function_0004DFE2

**ROM:** `0x0004DFE2`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0004DFE2(undefined4 param_1)

{
  if (param_1._0_2_ == 0) {
    RAM_n_Engine_delta_180[1] = RAM_n_Engine_delta_180[1] & 199;
    DAT_00003ee8 = 0;
    DAT_000037bc = 0;
    RAM_Cat_ox2_dev_samp = 0;
    RAM_Cat_ox2_filt = 0;
  }
  else if ((param_1._0_2_ == 1) || (DAT_000074ac != '\0')) {
    RAM_n_Engine_delta_180[1] = RAM_n_Engine_delta_180[1] & 199;
    RAM_Cat_dev_diff = 0;
    DAT_000037c6 = 0;
    RAM_Cat_air_flow = 0;
    DAT_00003ee8 = 0;
    DAT_000037bc = 0;
    DAT_000074ac = '\0';
  }
  else if (param_1._0_2_ == 2) {
    Function_0004E0B2();
    if ((RAM_n_Engine_delta_180[1] >> 3 & 1) == 0) {
      if (RAM_Cat_air_flow != 0) {
        Function_0004E4F2();
      }
      if (RAM_Cat_air_flow != 0) {
        Function_0004E82A();
      }
      _DAT_000037d8 = RAM_Cat_ox1_filt;
    }
  }
  return;
}

```
