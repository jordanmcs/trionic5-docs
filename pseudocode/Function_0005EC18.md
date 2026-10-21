# Function_0005EC18

**ROM:** `0x0005EC18`

```c

void Function_0005EC18(void)

{
  if (RAM_U_lambda_eng < DAT_00005b06) {
    RAM_Samp_pek[2] = RAM_Samp_pek[2] | 4;
  }
  else if ((RAM_Lambda_cat_lean_ < RAM_U_lambda_eng) && ((RAM_Samp_pek[2] & 4) != 0)) {
    RAM_Samp_pek[2] = RAM_Samp_pek[2] & 0xfb;
    DAT_00004080 = DAT_00004080 + '\x01';
  }
  Function_0005E768();
  return;
}

```
