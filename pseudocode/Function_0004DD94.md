# Function_0004DD94

**ROM:** `0x0004DD94`

```c

void Function_0004DD94(void)

{
  byte bVar1;
  short *psVar2;
  
  DAT_0000379c = DAT_0000379c + 1;
  psVar2 = &DAT_000074ca;
  for (bVar1 = 0;
      ((ushort)((&DAT_000074ca)[(short)(bVar1 + 1)] + *psVar2) >> 1 < DAT_0000379c && (bVar1 != 7));
      bVar1 = bVar1 + 1) {
    psVar2 = psVar2 + 1;
  }
  RAM_PMProt = *(word *)(RAM_PMCal_OpenTimeTab_ + (uint)bVar1 * 2);
  if ((short)(DAT_000074ea + RAM_PMProt_LambdaAvg) < (short)RAM_PMProt_PWM) {
    DAT_00003ee6 = DAT_00003ee6 & 0xdf;
  }
  if ((short)RAM_PMProt_PWM < (short)(RAM_PMProt_LambdaAvg - DAT_000074ea)) {
    DAT_00003ee6 = DAT_00003ee6 & 0xdf;
  }
  DAT_000037a6 = RAM_PMProt_LambdaInt - RAM_PMProt_LambdaAvg;
  if ((ushort)(DAT_0000379a + 5) < DAT_00003794) {
    DAT_00003ee7 = DAT_00003ee7 | 4;
  }
  if (DAT_00001136 < 0x65) {
    if (DAT_00001136 < 0x47) {
      DAT_00003ee6 = DAT_00003ee6 & 0xdf;
    }
    else {
      DAT_0000378a = (byte)(((uint)DAT_000074ec * (uint)(ushort)(DAT_00001136 - 0x46) & 0xffff) /
                           0x1e);
      if (DAT_00003794 < (ushort)(DAT_0000379a - DAT_0000378a)) {
        DAT_00003ee6 = DAT_00003ee6 & 0xdf;
      }
    }
  }
  else if (DAT_00003794 < (ushort)(DAT_0000379a - DAT_000074ec)) {
    DAT_00003ee6 = DAT_00003ee6 & 0xdf;
  }
  DAT_000037a4 = DAT_0000379a - DAT_00003794;
  if ((ushort)(RAM_PMCal_Numberccv_ + RAM_PMProt_TestCounter) < RAM_PMProt_RpmIdleNomRef) {
    DAT_00003ee7 = DAT_00003ee7 | 4;
  }
  if (RAM_PMProt_RpmIdleNomRef < (ushort)(RAM_PMProt_TestCounter - RAM_PMCal_Numberccv_)) {
    DAT_00003ee7 = DAT_00003ee7 | 4;
  }
  if ((DAT_000074d8 < DAT_0000379c) || ((DAT_00003ee6 >> 5 & 1) == 0)) {
    DAT_0000379a = DAT_00003794;
    DAT_00003ee6 = DAT_00003ee6 & 0xfd | 1;
    DAT_00003ee4 = DAT_0000379c;
  }
  return;
}

```
