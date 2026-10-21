# Function_0004CD7A

**ROM:** `0x0004CD7A`

```c

void Function_0004CD7A(void)

{
  int iVar1;
  
  if (-1 < (char)DAT_00003ee6) {
    if ((DAT_00003ee6 & 0x40) == 0) {
      DAT_000037a0 = 0;
      DAT_000034c2 = 0xf63c;
      DAT_000034c4 = 0x9c4;
      RAM_PMProt_IdlePos = 0;
    }
    else {
      DAT_00003794 = RAM_LLS_lage;
      iVar1 = (int)DAT_00003790 + (uint)DAT_00007508 * ((uint)RAM_LLS_lage - (uint)DAT_00003792);
      DAT_00003790 = (short)(iVar1 % 1000);
      DAT_00003792 = (short)(iVar1 / 1000) + DAT_00003792;
      RAM_PMProt_IdlePos = RAM_LLS_lage - DAT_00003792;
      if ((short)RAM_PMProt_IdlePos < 0) {
        RAM_PMProt_IdlePos = -RAM_PMProt_IdlePos;
      }
      if (((((DAT_00003ee6 & 0x10) != 0) || ((DAT_00003ee6 & 2) != 0)) || ((DAT_00003ee6 & 1) != 0))
         && (DAT_0000750a < RAM_PMProt_IdlePos)) {
        DAT_00003ee7 = DAT_00003ee7 | 4;
      }
      RAM_PMProt_PWM = (short)((int)((uint)DAT_00001031 * 10000) >> 9) - 0x9c4;
      if ((short)DAT_000034ca < (short)RAM_PMProt_PWM) {
        DAT_000034c8 = '+';
        DAT_000034ca = RAM_PMProt_PWM;
      }
      if ((short)RAM_PMProt_PWM < (short)DAT_000034ca) {
        DAT_000034c8 = '-';
        DAT_000034ca = RAM_PMProt_PWM;
      }
      if ((DAT_000034c8 == '+') && ((short)DAT_000034c2 < (short)RAM_PMProt_PWM)) {
        DAT_000034c2 = RAM_PMProt_PWM;
      }
      if ((DAT_000034c8 == '-') && ((short)RAM_PMProt_PWM < (short)DAT_000034c4)) {
        DAT_000034c4 = RAM_PMProt_PWM;
      }
      if (((DAT_000034c6 == '+') && (DAT_000034c8 == '-')) || (0x9c3 < (short)RAM_PMProt_PWM)) {
        DAT_000034c4 = 0x9c4;
      }
      if (((DAT_000034c6 == '-') && (DAT_000034c8 == '+')) || ((short)RAM_PMProt_PWM < -0x9c3)) {
        RAM_PMProt_LambdaInt = (short)(DAT_000034c4 + DAT_000034c2) >> 1;
        DAT_000034c2 = 0xf63c;
        if (((DAT_00003ee6 & 0x10) != 0) && (DAT_0000379e < RAM_PMCal_StartRamp_)) {
          DAT_000037a0 = (short)RAM_PMProt_LambdaInt + DAT_000037a0;
          DAT_0000379e = DAT_0000379e + 1;
        }
      }
      DAT_000034c6 = DAT_000034c8;
    }
  }
  return;
}

```
