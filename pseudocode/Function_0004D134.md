# Function_0004D134

**ROM:** `0x0004D134`

```c

void Function_0004D134(void)

{
  if (RAM_PMCal_StartRamp_ <= DAT_0000379e) {
    RAM_PMProt_LambdaAvg = (word)(DAT_000037a0 / (int)(uint)RAM_PMCal_StartRamp_);
    if ((short)RAM_PMCal_CloseRamp_ < (short)RAM_PMProt_LambdaAvg) {
      DAT_00003ee7 = DAT_00003ee7 | 4;
    }
    if ((short)RAM_PMProt_LambdaAvg < (short)-RAM_PMCal_CloseRamp_) {
      DAT_00003ee7 = DAT_00003ee7 | 4;
    }
    DAT_0000379a = DAT_00003794;
    DAT_00003788 = DAT_00001156;
    if ((DAT_00003794 < DAT_000074f2) || (DAT_00001156 < DAT_000074f2)) {
      DAT_00003ee7 = DAT_00003ee7 | 4;
    }
    RAM_PMProt_TestCounter = RAM_PMProt_RpmIdleNomRef;
    DAT_00003ee6 = DAT_00003ee6 & 0xef | 2;
  }
  return;
}

```
