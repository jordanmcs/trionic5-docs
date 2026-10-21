# Function_000734C6

**ROM:** `0x000734C6`

```c

byte Function_000734C6(void)

{
  byte bVar1;
  
  bVar1 = RAM_Gear;
  if ((((byte)(&DAT_00005bb6)[(short)(ushort)DAT_000047d8] < RAM_Gear) &&
      (bVar1 = 0, (DAT_00001039 & 8) != 0)) && (bVar1 = RAM_Samp_pek[0] & 0x20, bVar1 == 0)) {
    if ((short)RAM_Derivata_rpm < -0xf9) {
      RAM_Samp_pek[10] = RAM_Samp_pek[10] | 0x80;
    }
    DAT_00001039 = DAT_00001039 | 0x20;
    RAM_Samp_pek[0xc] = RAM_Samp_pek[0xc] | 0x10;
    DAT_0000347a = 0;
    DAT_000047c6 = 0;
    if ((short)RAM_Derivata_rpm < -199) {
      RAM_Derivata_rpm = 0xff06;
    }
    else {
      RAM_Derivata_rpm = RAM_Derivata_rpm - 0x32;
    }
  }
  else {
    DAT_00001039 = DAT_00001039 & 0xdf;
  }
  return bVar1;
}

```
