# Function_0004AAC6

**ROM:** `0x0004AAC6`

```c

int Function_0004AAC6(int param_1)

{
  if ((DAT_00003730 <= DAT_00003b02) || (DAT_00003738 != 0)) {
    if (DAT_00003b02 < DAT_00003730) {
      if (DAT_00005b60 < DAT_00003738) {
        DAT_00003738 = DAT_00003738 - DAT_00005b60;
      }
      else {
        DAT_00003738 = 0;
      }
    }
    else {
      DAT_00003738 = DAT_00005b60 + DAT_00003738;
      if (RAM_Ap_lambda_delay_ < DAT_00003738) {
        DAT_00003738 = RAM_Ap_lambda_delay_;
      }
    }
    param_1 = param_1 - (uint)DAT_00003738;
  }
  return param_1;
}

```
