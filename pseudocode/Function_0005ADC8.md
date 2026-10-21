# Function_0005ADC8

**ROM:** `0x0005ADC8`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0005ADC8(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[0] & 0x40) == 0) {
    DAT_00004014 = DAT_00004014 & 0xbf;
    if ((((short)(ushort)DAT_00004084 < (short)(DAT_00004052 - 1)) ||
        ((ushort)(DAT_00004052 + 1) < (ushort)DAT_00004084)) || ((RAM_Samp_pek[4] & 2) == 0)) {
      DAT_00004084 = DAT_00004052;
      _DAT_00001a90 = DAT_00001a58;
    }
    if ((DAT_00004052 < 3) || (0xfc < DAT_00004052)) {
      DAT_00004014 = DAT_00004014 | 0x40;
    }
    else {
      DAT_00001a78 = DAT_00001a58;
    }
    pbVar3 = &DAT_00003320;
    if (DAT_00001a78 + 5 < DAT_00001a58) {
      DAT_0000404a = 0;
      RAM_Samp_pek[0] = RAM_Samp_pek[0] | 0x40;
      if (DAT_00004084 < 3) {
        DAT_0000404a = 0x40;
      }
      else if (0xfc < DAT_00004084) {
        DAT_0000404a = 0x80;
      }
      Function_0005F0B8(&DAT_00003320);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_0000264e;
      do {
        *puVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        puVar4 = puVar4 + 1;
      } while (sVar1 != -1);
      DAT_00004014 = DAT_00004014 | 0x40;
      pbVar3 = extraout_A1;
      if (*extraout_A1 < 0x28) {
        *extraout_A1 = 0x28;
      }
      else {
        *extraout_A1 = 0x2c;
        DAT_000040e5 = DAT_000040e5 | 0x40;
      }
    }
    else if ((RAM_Samp_pek[4] & 0x10) == 0) {
      if (DAT_00003320 < 0x28) {
        bVar2 = DAT_00003fe8 >> 6 & 1;
      }
      else if (((DAT_00003fe8 & 0x20) == 0) || (DAT_00001a58 < 0xb)) {
        bVar2 = 0;
      }
      else {
        bVar2 = 1;
      }
      if ((bVar2 != 0) && (DAT_00003320 != 0)) {
        DAT_00003320 = DAT_00003320 - 1;
        RAM_Samp_pek[4] = RAM_Samp_pek[4] | 0x10;
      }
    }
    if ((DAT_00004014 & 0x40) == 0) {
      if (5 < DAT_00001a58 - DAT_00004016) {
        DAT_00004014 = DAT_00004014 & 0x7f;
      }
    }
    else {
      DAT_00004016 = DAT_00001a58;
      DAT_00004014 = DAT_00004014 | 0x80;
    }
    if (*pbVar3 == 0) {
      DAT_0000404a = 0;
      DAT_000040e5 = DAT_000040e5 & 0xbf;
    }
  }
  return;
}

```
