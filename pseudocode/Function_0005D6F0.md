# Function_0005D6F0

**ROM:** `0x0005D6F0`

```c

void Function_0005D6F0(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[1] & 1) == 0) {
    if ((DAT_0000103d & 4) == 0) {
      if (((RAM_Samp_pek[5] & 2) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        if (DAT_00001d24 < 0x28) {
          bVar2 = DAT_00003fe8 >> 6;
        }
        else {
          bVar2 = DAT_00003fe8 >> 5;
        }
        if ((bVar2 & 1) != 0) {
          if (DAT_00001d24 == 0) {
            return;
          }
          RAM_Samp_pek[5] = RAM_Samp_pek[5] | 2;
          DAT_00001d24 = DAT_00001d24 - 1;
          return;
        }
      }
      if (DAT_00001d24 == 0) {
        DAT_000040e5 = DAT_000040e5 & 0xf7;
      }
    }
    else {
      RAM_Samp_pek[1] = RAM_Samp_pek[1] | 1;
      Function_0005F0B8(&DAT_00001d24);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_0000295a;
      do {
        *puVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        puVar4 = puVar4 + 1;
      } while (sVar1 != -1);
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e5 = DAT_000040e5 | 8;
      }
    }
  }
  return;
}

```
