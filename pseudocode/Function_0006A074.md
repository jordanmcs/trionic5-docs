# Function_0006A074

**ROM:** `0x0006A074`

```c

void Function_0006A074(undefined4 param_1)

{
  if (((DAT_00006e20 & 2) != 0) || ((DAT_00006e20 & 0x80) != 0)) {
    if (((((param_1._0_2_ == 1) &&
          (((((RAM_Dash_act_value & 2) == 0 && ((RAM_Dash_act_value & 8) == 0)) &&
            (DAT_00001d20 == '\0')) && ((DAT_00001d22 == '\0' && (DAT_00001d23 == '\0')))))) &&
         ((DAT_00001d26 == '\0' &&
          (((RAM_Tank_error == 0 && (DAT_0000331f == '\0')) &&
           ((DAT_00003320 == '\0' &&
            (((RAM_Luft_error == 0 && (DAT_00003322 == '\0')) && (DAT_00003323 == '\0')))))))))) &&
        (((DAT_00003325 == '\0' && (RAM_Hast_error == 0)) && (DAT_00003329 == '\0')))) &&
       (((RAM_Sond_error == 0 && (DAT_0000332b != '\0')) && (DAT_0000332f == '\0')))) {
      RAM_Samp_delay = (byte  [4])&RAM_AD_EGR;
      RAM_Samp_adr_1 = (byte  [4])&RAM_Kadapt_counter;
      RAM_Samp_adr_2 = (byte  [4])&DAT_00001015;
      RAM_Samp_adr_3 = (byte  [4])&DAT_00001013;
      RAM_Dash_act_value = 0;
      DAT_000039fe = DAT_000039fe | 1;
    }
    else if ((((param_1._0_2_ == 2) && ((DAT_000039fe & 1) != 0)) &&
             ((RAM_Dash_act_value & 0x10) == 0)) &&
            ((((DAT_00001d20 != '\0' || (DAT_00001d22 != '\0')) ||
              ((((DAT_00001d23 != '\0' || ((DAT_00001d26 != '\0' || (RAM_Tank_error != 0)))) ||
                (DAT_0000331f != '\0')) ||
               ((((((DAT_00003320 != '\0' || (RAM_Luft_error != 0)) || (DAT_00003322 != '\0')) ||
                  ((DAT_00003323 != '\0' || (DAT_00003325 != '\0')))) ||
                 ((RAM_Hast_error != 0 || ((DAT_00003329 != '\0' || (RAM_Sond_error != 0)))))) ||
                (DAT_0000332b != '\0')))))) || (DAT_0000332f != '\0')))) {
      RAM_Dash_act_value = RAM_Dash_act_value | 0x10;
    }
  }
  return;
}

```
