# Function_0005E360

**ROM:** `0x0005E360`

```c

void Function_0005E360(void)

{
  ushort uVar1;
  byte bVar2;
  short sVar3;
  byte *pbVar4;
  undefined4 extraout_A1;
  byte *extraout_A1_00;
  undefined4 *puVar5;
  
  if ((RAM_Samp_pek[8] & 1) == 0) {
    if (-1 < (char)RAM_BrakeCnt._0_1_) {
      if (0x23 < DAT_0000101c) {
        DAT_00003854 = DAT_00003b02;
        RAM_BrakeCnt._0_1_ = RAM_BrakeCnt._0_1_ | 0x40;
      }
      if ((DAT_0000101c == 0) && ((RAM_BrakeCnt._0_1_ >> 6 & 1) == 1)) {
        if (DAT_00003b02 < DAT_00003854 + 10000) {
          RAM_PMProt_IdlePosIntABS = RAM_PMProt_IdlePosIntABS + 1;
        }
        RAM_BrakeCnt._0_1_ = RAM_BrakeCnt._0_1_ & 0xbf;
      }
      uVar1 = Function_00044BA4();
      if (uVar1 != DAT_00003850) {
        RAM_BrakeCnt._0_1_ = RAM_BrakeCnt._0_1_ | 0x20;
      }
      if (((RAM_BrakeCnt._0_1_ >> 5 & 1) == 1) || (5 < RAM_PMProt_IdlePosIntABS)) {
        RAM_BrakeCnt._0_1_ = RAM_BrakeCnt._0_1_ | 0x80;
      }
    }
    pbVar4 = &DAT_0000332e;
    if (((char)RAM_BrakeCnt._0_1_ < '\0') && ((RAM_BrakeCnt._0_1_ >> 5 & 1) == 0)) {
      RAM_BrakeCnt._0_1_ = RAM_BrakeCnt._0_1_ & 0xe7;
      RAM_Samp_pek[8] = RAM_Samp_pek[8] | 1;
      bVar2 = Function_00044BA4();
      RAM_BrakeCnt._0_1_ = ((bVar2 & 1) == 0) << 4 | (bVar2 & 1) << 3 | RAM_BrakeCnt._0_1_ & 0xe7;
      Function_0005F0B8(extraout_A1);
      sVar3 = 0x24;
      pbVar4 = RAM_Crankshaft_frame;
      puVar5 = &DAT_0000216e;
      do {
        *puVar5 = *(undefined4 *)pbVar4;
        sVar3 = sVar3 + -1;
        pbVar4 = pbVar4 + 4;
        puVar5 = puVar5 + 1;
      } while (sVar3 != -1);
      pbVar4 = extraout_A1_00;
      if ((*extraout_A1_00 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1_00 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1_00 = 0x2c;
        DAT_000040e6 = DAT_000040e6 | 2;
      }
    }
    else if (((RAM_Samp_pek[9] & 0x80) == 0) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
      if (DAT_0000332e < 0x28) {
        bVar2 = DAT_00003fe8 >> 6 & 1;
      }
      else if ((((DAT_00003fe8 & 0x20) == 0) || (-1 < (char)RAM_BrakeCnt._0_1_)) ||
              ((RAM_BrakeCnt._0_1_ >> 5 & 1) != 1)) {
        bVar2 = 0;
      }
      else {
        bVar2 = 1;
      }
      if ((bVar2 != 0) && (DAT_0000332e != 0)) {
        DAT_0000332e = DAT_0000332e - 1;
        RAM_Samp_pek[9] = RAM_Samp_pek[9] | 0x80;
      }
    }
    if (*pbVar4 == 0) {
      RAM_BrakeCnt._0_1_ = RAM_BrakeCnt._0_1_ & 0xe7;
      DAT_000040e6 = DAT_000040e6 & 0xfd;
    }
  }
  return;
}

```
