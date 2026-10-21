# Function_0006CF66

**ROM:** `0x0006CF66`

```c

void Function_0006CF66(void)

{
  short sVar1;
  
  sVar1 = Function_0004A4D2();
  if (sVar1 == 1) {
    DAT_00001039 = DAT_00001039 | 1;
  }
  else {
    DAT_00001039 = DAT_00001039 & 0xfe;
  }
  Function_00069C30();
  Function_00069B20();
  Function_00069602();
  Function_00070686();
  Function_0005EC68();
  Function_0007300C();
  if ((RAM_Ramp_steg_[3] & 8) == 0) {
    Function_000691E6();
  }
  else {
    Function_00046A4C();
  }
  Function_0006185E();
  if ((DAT_00006e20 & 0x80) != 0) {
    Function_0004DFE2();
    Function_0004CD7A();
  }
  if ((DAT_00003c38 == '\0') && (DAT_000074c4 < DAT_00003c32)) {
    RAM_Knock_count_cyl4 = (short)DAT_00003b02 - (short)DAT_00003c3e;
    RAM_Start_time = (short)DAT_00003b02 - (short)DAT_00003c3a;
    DAT_00003c38 = '\x01';
    if ((ushort)RAM_Start_time_tot._0_2_ < RAM_Start_time) {
      RAM_Start_time_tot._0_2_ = RAM_Start_time;
      RAM_Start_time_tot._2_2_ = RAM_Knock_count_cyl4;
    }
  }
  else if ((DAT_00003c32 == 0) && (DAT_00003c38 != '\0')) {
    DAT_00003c38 = '\0';
    DAT_00003c3e = 0;
    DAT_00003c3a = 0;
  }
  Function_0004CAC8();
  if (RAM_Trot_delta < DAT_00001015) {
    RAM_LhomePmanifold = DAT_00001015 - RAM_Trot_delta;
  }
  else {
    RAM_LhomePmanifold = 0;
  }
  DAT_0000472e = Function_00072972(&DAT_00004d40,&DAT_00004d4c,&DAT_00004d64,0xc,DAT_00001066);
  DAT_00001052 = (ushort)DAT_0000472e * 10;
  return;
}

```
