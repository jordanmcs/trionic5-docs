# Function_0005AC54

**ROM:** `0x0005AC54`

```c

void Function_0005AC54(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  undefined4 *puVar4;
  
  DAT_00001117 = Function_0004AB46();
  if (((((DAT_00001117 != 'H') && (DAT_00001117 != 'L')) || ((DAT_00001039 & 1) == 0)) ||
      (((RAM_Samp_pek[4] & 2) == 0 || ((uint)DAT_00001a58 < 3)))) || (RAM_Bil_hast < DAT_000072a2))
  {
    RAM_Purge_time[0] = DAT_00001a58[0];
    RAM_Purge_time[1] = DAT_00001a58[1];
    RAM_Purge_time[2] = DAT_00001a58[2];
    RAM_Purge_time[3] = DAT_00001a58[3];
  }
  if ((DAT_00003736 & 0x40) == 0) {
    if ((int)RAM_Purge_time + 5U < (uint)DAT_00001a58) {
      if ((DAT_00003328 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        DAT_00003328 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        DAT_00003328 = 0x2c;
        DAT_000040e4 = DAT_000040e4 | 8;
      }
      DAT_00004040 = 0;
      DAT_00003736 = DAT_00003736 | 0x40;
      if (DAT_00001117 == 'H') {
        DAT_00004040 = 0x80;
      }
      else if (DAT_00001117 == 'L') {
        DAT_00004040 = 0x40;
      }
      Function_0005F0B8(&DAT_00003328);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_000028be;
      do {
        *puVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        puVar4 = puVar4 + 1;
      } while (sVar1 != -1);
    }
    else if (((RAM_Samp_pek[5] & 0x40) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
      if (DAT_00003328 < 0x28) {
        bVar2 = DAT_00003fe8 >> 6;
      }
      else {
        bVar2 = DAT_00003fe8 >> 7;
      }
      if (((bVar2 & 1) != 0) && (DAT_00003328 != 0)) {
        DAT_00003328 = DAT_00003328 - 1;
        RAM_Samp_pek[5] = RAM_Samp_pek[5] | 0x40;
      }
    }
  }
  if (DAT_00003328 == 0) {
    DAT_00004040 = 0;
    DAT_000040e4 = DAT_000040e4 & 0xef;
  }
  return;
}

```
