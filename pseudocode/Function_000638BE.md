# Function_000638BE

**ROM:** `0x000638BE`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000638BE(void)

{
  byte bVar1;
  char cVar3;
  byte bVar4;
  short sVar2;
  short *psVar5;
  short *extraout_A1;
  
  cVar3 = Function_00044550();
  bVar4 = cVar3 << 7;
  bVar1 = bVar4 | DAT_000039b4 & 0x7f;
  if (((DAT_000039b4 & 0x40) == 0x40) && (bVar4 == 0)) {
    DAT_000039b6 = DAT_00003b02;
    DAT_000039ba = DAT_00003b72;
    DAT_000039bc = DAT_000039bd;
  }
  DAT_000039b4 = bVar1;
  if ((bVar4 == 0) && (DAT_000039b6 + 0x9f6 < DAT_00003b02)) {
    DAT_000039b4 = bVar1 | 0x20;
    RAM_Samp_pek[8] = RAM_Samp_pek[8] | 0x80;
  }
  if (((DAT_000039b4 >> 6 & 1) == 0) && ((char)DAT_000039b4 < '\0')) {
    if (DAT_00005b1a < (short)(DAT_00003b72 - DAT_000039ba)) {
      DAT_000039be = 0x4c;
    }
    else {
      DAT_000039be = 0x53;
    }
  }
  DAT_000039b4 = (DAT_000039b4 >> 7) << 6 | DAT_000039b4 & 0xbf;
  DAT_0000468a = (ushort)DAT_00001013;
  DAT_00004688 = DAT_00003b72;
  DAT_00004686 = 0;
  DAT_00004684 = DAT_00003b72 + DAT_00001160 * -10;
  DAT_00004682 = (ushort)DAT_00001013;
  DAT_00004680 = DAT_00003b72;
  DAT_0000467e = (ushort)RAM_AD_knock;
  DAT_0000467c = DAT_00003b72;
  DAT_0000467a = 0;
  DAT_00004678 = DAT_00003b72;
  DAT_00004676 = (ushort)DAT_00001013;
  DAT_00004674 = DAT_00003b72;
  DAT_00004672 = (ushort)DAT_00001013;
  DAT_00004670 = DAT_00003b72;
  DAT_0000466e = 0;
  DAT_00003904 = DAT_00003c32 - DAT_00003906;
  DAT_00003906 = DAT_00003c32;
  DAT_0000466a = (ushort)DAT_00001013;
  DAT_00004668 = DAT_00003b72;
  DAT_00004666 = (ushort)DAT_00001013;
  DAT_00004664 = DAT_00003b72;
  if (DAT_00003b72 < 0x2ef) {
    RAM_Crankshaft_error[0] = 0;
    RAM_Crankshaft_error[1] = 0;
    RAM_Crankshaft_error[2] = 0;
    RAM_Crankshaft_error[3] = 0;
    DAT_00001082 = 0;
    _DAT_000010ae = 0;
    RAM_Ign_counter3[0] = 0;
    RAM_Ign_counter3[1] = 0;
    RAM_Ign_counter3[2] = 0;
    RAM_Ign_counter3[3] = 0;
  }
  else {
    RAM_Crankshaft_error = (byte  [4])((int)RAM_Crankshaft_error + 1);
    DAT_0000107e = DAT_0000107e + 1;
  }
  if (DAT_00005b02 < DAT_00003b72) {
    DAT_00001082 = DAT_00001082 + 1;
  }
  RAM_Ign_counter2 = (byte  [4])((int)RAM_Ign_counter2 + 1);
  DAT_0000466c = DAT_00003904;
  Function_00062842();
  psVar5 = &DAT_000010b4;
  if (DAT_00003b78 == '\0') {
    if ((RAM_Ramp_steg_[4] & 0x40) == 0) {
      sVar2 = Function_00062102();
      *extraout_A1 = sVar2;
      if (400 < *extraout_A1) {
        *extraout_A1 = 400;
      }
      psVar5 = extraout_A1;
      if (*extraout_A1 < -100) {
        *extraout_A1 = -100;
      }
    }
  }
  else {
    DAT_000010b4 = 100;
  }
  DAT_00003902 = (char)((int)(short)(*psVar5 + 100) / 10);
  return;
}

```
