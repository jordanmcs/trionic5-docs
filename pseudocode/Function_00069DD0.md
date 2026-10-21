# Function_00069DD0

**ROM:** `0x00069DD0`

```c

void Function_00069DD0(void)

{
  byte *extraout_A1;
  byte *extraout_A1_00;
  
  if ((DAT_000039fc & 0x80) == 0) {
    DAT_000046da = 0;
  }
  else {
    DAT_000046da = DAT_000046da + 1;
  }
  if (((char)RAM_Restart_tab_ < DAT_0000102e) || (DAT_000046da < 4)) {
    RAM_Nom_last = 100;
  }
  else if (DAT_000046da < 0x3c) {
    RAM_Nom_last = DAT_00004fb4;
  }
  else if (DAT_000046da < 0x78) {
    RAM_Nom_last = DAT_00004fb5;
  }
  else if (DAT_000046da < 0xb4) {
    RAM_Nom_last = DAT_00004fb6;
  }
  else {
    RAM_Nom_last = 100;
    DAT_00003a1c = 0;
  }
  if (((RAM_Ramp_steg_[3] & 1) != 0) && (RAM_Nom_last != 100)) {
    DAT_000046d8 = Function_0006A4E4(RAM_Temp_steg_,0x75d8);
    DAT_000046d6 = *extraout_A1;
    *extraout_A1 = (byte)((uint)((int)(short)(ushort)*extraout_A1 * (int)(short)(ushort)DAT_000046d8
                                ) / 100);
  }
  if (0x77 < DAT_000046da) {
    DAT_00003886 = 0;
  }
  if ((0xb3 < DAT_000046da) && ((RAM_Purge_status & 0x80) != 0)) {
    RAM_Purge_status = RAM_Purge_status | 0x20;
  }
  if (0x4af < DAT_000046da) {
    Function_0006A252();
    RAM_Purge_status = RAM_Purge_status | 0x48;
  }
  DAT_00003a7e = 0;
  DAT_00003a7c = 0;
  DAT_00003a76 = 0;
  DAT_00003a48 = 0;
  RAM_Start_dead = 0;
  DAT_00003a1a = 0;
  DAT_00003a4a = 0;
  DAT_00003a3c = 0;
  DAT_00001026 = 0;
  DAT_00003a19 = DAT_00003a19 & 0xbf;
  Function_00070D4C();
  DAT_0000103c = DAT_0000103c & 0xfb;
  RAM_Eft_dec2 = 0;
  RAM_Duty_C = 0;
  Function_0006F1F2();
  *extraout_A1_00 = *extraout_A1_00 & 0xf7;
  *extraout_A1_00 = *extraout_A1_00 | 1;
  return;
}

```
