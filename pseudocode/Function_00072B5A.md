# Function_00072B5A

**ROM:** `0x00072B5A`

```c

void Function_00072B5A(void)

{
  byte bVar1;
  byte *extraout_A1;
  byte *extraout_A1_00;
  byte *extraout_A1_01;
  byte *extraout_A1_02;
  byte *extraout_A1_03;
  byte *extraout_A1_04;
  
  if (RAM_Gear < DAT_00003353) {
    DAT_000047b0 = DAT_00003353 - RAM_Gear;
  }
  else {
    DAT_000047b0 = RAM_Gear - DAT_00003353;
  }
  if ((RAM_Ramp_steg_[3] & 2) == 0) {
    bVar1 = Function_00072972(&DAT_00005eaa,&DAT_00005d66,&DAT_00005d74,7,DAT_00001066);
    *extraout_A1_02 = bVar1;
    DAT_000047c4 = (ushort)*extraout_A1_02;
    bVar1 = Function_00072972(&DAT_00005eaa,&DAT_00005d66,&DAT_00005d90,7,
                              (uint)CONCAT12(DAT_000047b0,DAT_00001066));
    *extraout_A1_03 = bVar1;
    DAT_000047c2 = (ushort)*extraout_A1_03;
    bVar1 = Function_00072972(&DAT_00005eaa,&DAT_00005d66,&DAT_00005dac,7,
                              (uint)CONCAT12(DAT_000047b0,DAT_00001066));
    *extraout_A1_04 = bVar1;
    bVar1 = *extraout_A1_04;
  }
  else {
    bVar1 = Function_00072972(&DAT_00005eaa,&DAT_00005d66,&DAT_00005dc8,7,DAT_00001066);
    *extraout_A1 = bVar1;
    DAT_000047c4 = (ushort)*extraout_A1;
    bVar1 = Function_00072972(&DAT_00005eaa,&DAT_00005d66,&DAT_00005de4,7,
                              (uint)CONCAT12(DAT_000047b0,DAT_00001066));
    *extraout_A1_00 = bVar1;
    DAT_000047c2 = (ushort)*extraout_A1_00;
    bVar1 = Function_00072972(&DAT_00005eaa,&DAT_00005d66,&DAT_00005e00,7,
                              (uint)CONCAT12(DAT_000047b0,DAT_00001066));
    *extraout_A1_01 = bVar1;
    bVar1 = *extraout_A1_01;
  }
  DAT_000047c0 = (ushort)bVar1;
  return;
}

```
