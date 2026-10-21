# Function_0005D7E0

**ROM:** `0x0005D7E0`

```c

void Function_0005D7E0(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[7] & 4) == 0) {
    if (((((uint)RAM_Crankshaft_error < 0x2711) || ((DAT_0000103c & 0x80) != 0)) ||
        (DAT_00005afa <= DAT_00001077)) &&
       (((DAT_00001082 <= DAT_00005b04 || ((DAT_0000103c & 0x80) != 0)) ||
        ((DAT_00001077 < DAT_00005afa || ((RAM_Tank_error & RAM_Samp_pek[6]) != 0)))))) {
      DAT_000040b0 = DAT_00001a58;
    }
    pbVar3 = &DAT_00001d26;
    if (DAT_000040b0 + 10 < DAT_00001a58) {
      RAM_Samp_pek[7] = RAM_Samp_pek[7] | 4;
      Function_0005F0B8(&DAT_00001d26);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_00002c66;
      do {
        *puVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        puVar4 = puVar4 + 1;
      } while (sVar1 != -1);
      pbVar3 = extraout_A1;
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e6 = DAT_000040e6 | 0x80;
      }
    }
    if ((((DAT_0000103c & 0x80) != 0) && ((RAM_Samp_pek[7] & 2) == 0)) &&
       ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
      if (*pbVar3 < 0x28) {
        bVar2 = DAT_00003fe8 >> 6 & 1;
      }
      else if (((DAT_00003fe8 & 0x20) == 0) || (DAT_00001a58 < 0x3e9)) {
        bVar2 = 0;
      }
      else {
        bVar2 = 1;
      }
      if (bVar2 != 0) {
        if (*pbVar3 == 0) {
          return;
        }
        *pbVar3 = *pbVar3 - 1;
        RAM_Samp_pek[7] = RAM_Samp_pek[7] | 2;
        return;
      }
    }
    if (*pbVar3 == 0) {
      DAT_000040e6 = DAT_000040e6 & 0x7f;
    }
  }
  return;
}

```
