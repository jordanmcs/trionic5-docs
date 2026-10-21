# Function_0005C34A

**ROM:** `0x0005C34A`

```c

void Function_0005C34A(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  byte *pbVar4;
  
  if ((RAM_Samp_pek[5] & 8) == 0) {
    DAT_0000401a = DAT_0000401a & 0xbf;
    if ((((DAT_000010fe < 0x33) && ((RAM_Samp_pek[4] & 2) != 0)) && (DAT_000072a2 <= RAM_Bil_hast))
       && (799 < DAT_00003c32)) {
      DAT_0000401a = DAT_0000401a | 0x40;
    }
    else {
      DAT_00001a9c = DAT_00001a58;
    }
    pbVar3 = &DAT_00001d20;
    if (DAT_00001a9c + 10 < DAT_00001a58) {
      RAM_Samp_pek[5] = RAM_Samp_pek[5] | 8;
      Function_0005F0B8(&DAT_00001d20);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      pbVar4 = RAM_Idle_frame;
      do {
        *(undefined4 *)pbVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        pbVar4 = pbVar4 + 4;
      } while (sVar1 != -1);
      DAT_0000401a = DAT_0000401a | 0x40;
      pbVar3 = extraout_A1;
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e4 = DAT_000040e4 | 2;
      }
    }
    else if (((0x5dc < (uint)RAM_Crankshaft_error) && ((RAM_Samp_pek[5] & 4) == 0)) &&
            ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
      if (DAT_00001d20 < 0x28) {
        bVar2 = DAT_00003fe8 >> 6;
      }
      else {
        bVar2 = DAT_00003fe8 >> 5;
      }
      if (((bVar2 & 1) != 0) && (DAT_00001d20 != 0)) {
        DAT_00001d20 = DAT_00001d20 - 1;
        RAM_Samp_pek[5] = RAM_Samp_pek[5] | 4;
      }
    }
    if ((DAT_0000401a & 0x40) == 0) {
      if (5 < DAT_00001a58 - DAT_0000401c) {
        DAT_0000401a = DAT_0000401a & 0x7f;
      }
    }
    else {
      DAT_0000401c = DAT_00001a58;
      DAT_0000401a = DAT_0000401a | 0x80;
    }
    if (*pbVar3 == 0) {
      DAT_000040e4 = DAT_000040e4 & 0xfd;
    }
  }
  return;
}

```
