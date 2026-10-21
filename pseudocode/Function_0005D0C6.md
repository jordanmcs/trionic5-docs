# Function_0005D0C6

**ROM:** `0x0005D0C6`

```c

void Function_0005D0C6(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  undefined4 *puVar4;
  
  if ((RAM_Samp_pek[0xb] & 4) == 0) {
    DAT_00001116 = Function_0004A4FC();
    if (((((DAT_00006e20 & 0x80) != 0) ||
         ((((DAT_00001116 != 'H' && (DAT_00001116 != 'L')) && (DAT_00001116 != 'U')) ||
          (((DAT_00001039 & 1) == 0 || ((RAM_Samp_pek[4] & 2) == 0)))))) || ((uint)DAT_00001a58 < 3)
        ) || (RAM_Bil_hast < DAT_000072a2)) {
      RAM_Battery_time[0] = DAT_00001a58[0];
      RAM_Battery_time[1] = DAT_00001a58[1];
      RAM_Battery_time[2] = DAT_00001a58[2];
      RAM_Battery_time[3] = DAT_00001a58[3];
    }
    pbVar3 = &RAM_Idle_error;
    if ((((int)RAM_Battery_time + 2U < (uint)DAT_00001a58) && (DAT_00003866 == '\x03')) ||
       (((DAT_00006e20 & 0x20) == 0 &&
        ((((DAT_00003ee6 & 0x80) != 0 && ((DAT_00003ee6 & 0x20) != 0)) &&
         ((RAM_Samp_pek[8] & 2) == 0)))))) {
      DAT_00004044 = 0;
      RAM_Samp_pek[0xb] = RAM_Samp_pek[0xb] | 4;
      RAM_Purge_freq = RAM_Purge_freq | 1;
      if (DAT_00001116 == 'H') {
        DAT_00004044 = 0x80;
      }
      else if (DAT_00001116 == 'L') {
        DAT_00004044 = 0x40;
      }
      else if (DAT_00001116 == 'U') {
        DAT_00004044 = 0x20;
      }
      else if (((DAT_00003ee6 & 0x20) != 0) && ((DAT_00006e20 & 0x20) == 0)) {
        DAT_00004044 = 0x10;
      }
      Function_0005F0B8(&RAM_Idle_error);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      puVar4 = &DAT_00002822;
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
        DAT_000040e4 = DAT_000040e4 | 0x20;
      }
    }
    else if (((RAM_Samp_pek[3] & 0x10) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
      if (RAM_Idle_error < 0x28) {
        bVar2 = DAT_00003fe8 >> 6 & 1;
      }
      else if (((DAT_00003fe8 & 0x20) == 0) || ((DAT_00003ee6 & 0x80) == 0)) {
        bVar2 = 0;
      }
      else {
        bVar2 = 1;
      }
      if ((bVar2 != 0) && (RAM_Idle_error != 0)) {
        RAM_Idle_error = RAM_Idle_error - 1;
        RAM_Samp_pek[3] = RAM_Samp_pek[3] | 0x10;
      }
    }
    if (*pbVar3 == 0) {
      DAT_00004044 = 0;
      DAT_000040e4 = DAT_000040e4 & 0xdf;
    }
  }
  return;
}

```
