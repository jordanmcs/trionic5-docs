# Function_000611E6

**ROM:** `0x000611E6`

```c

void Function_000611E6(void)

{
  int iVar1;
  
  if ((DAT_00003886 & 0x80) == 0) {
    if ((DAT_00003886 & 0x40) != 0) {
      for (DAT_000034e6 = 0; DAT_000034e6 < 0x96; DAT_000034e6 = DAT_000034e6 + 1) {
        (&DAT_0000410e)[(short)DAT_000034e6] = 0;
      }
      for (DAT_000034e6 = 0; DAT_000034e6 < 100; DAT_000034e6 = DAT_000034e6 + 1) {
        if ((ushort)(&DAT_0000423a)[(short)DAT_000034e6] < 0x96) {
          (&DAT_0000410e)[(short)(&DAT_0000423a)[(short)DAT_000034e6]] =
               (&DAT_0000410e)[(short)(&DAT_0000423a)[(short)DAT_000034e6]] + 1;
        }
        else {
          DAT_00004238 = DAT_00004238 + 1;
        }
      }
      DAT_000034e6 = 0;
      for (DAT_0000388e = 0; (DAT_000034e6 < 0x96 && (DAT_0000388e < 0x32));
          DAT_0000388e = (ushort)(&DAT_0000410e)[iVar1] + DAT_0000388e) {
        iVar1 = (int)(short)DAT_000034e6;
        DAT_000034e6 = DAT_000034e6 + 1;
      }
      DAT_0000463c = DAT_000034e6 * 2;
      if (RAM_Last_reg_fak < DAT_0000463c) {
        DAT_0000462c = DAT_0000463c - RAM_Last_reg_fak;
        if (DAT_0000462c < 0x15) {
          if (DAT_0000462c < 0xb) {
            if (2 < DAT_0000462c) {
              RAM_Last_reg_fak = RAM_Last_reg_fak + 1;
            }
          }
          else {
            RAM_Last_reg_fak = RAM_Last_reg_fak + 2;
          }
        }
        else {
          RAM_Last_reg_fak = RAM_Last_reg_fak + 10;
        }
      }
      else if (DAT_0000463c < RAM_Last_reg_fak) {
        DAT_0000462c = RAM_Last_reg_fak + DAT_000034e6 * -2;
        if (DAT_0000462c < 0x15) {
          if (DAT_0000462c < 0xb) {
            if (2 < DAT_0000462c) {
              RAM_Last_reg_fak = RAM_Last_reg_fak - 1;
            }
          }
          else {
            RAM_Last_reg_fak = RAM_Last_reg_fak - 2;
          }
        }
        else {
          RAM_Last_reg_fak = RAM_Last_reg_fak - 10;
        }
      }
      DAT_00004622 = (uint)DAT_00003892 * (uint)RAM_Last_reg_fak;
      DAT_00003886 = DAT_00003886 | 0x80;
      DAT_0000410a = DAT_00001a58;
    }
  }
  else if (DAT_0000410a + RAM_Kadapt_load_low_ < DAT_00001a58) {
    DAT_00003886 = 0;
  }
  return;
}

```
