# Function_0006EE26

**ROM:** `0x0006EE26`

```c

void Function_0006EE26(void)

{
  short sVar1;
  byte *pbVar2;
  byte *extraout_A1;
  byte *extraout_A1_00;
  
  pbVar2 = &DAT_00004734;
  if ((((DAT_00001066 == 0) && ((DAT_00001039 & 1) != 0)) &&
      (((RAM_Purge_status & 0x20) != 0 || (DAT_00004e2c < DAT_0000102e)))) &&
     (((RAM_Purge_status & 0x80) != 0 && ((RAM_Purge_status & 0x10) == 0)))) {
    if ((DAT_000038c4 & 0x40) == 0) {
      Function_00044664();
      pbVar2 = extraout_A1;
    }
    if ((DAT_000038c4 & 0x80) == 0) {
      Function_0004461C();
      pbVar2 = extraout_A1_00;
    }
    DAT_00004735 = DAT_00004735 & 0x7f;
    *pbVar2 = *pbVar2 & 0xfe;
    *pbVar2 = *pbVar2 & 0xfd;
    *pbVar2 = *pbVar2 & 0xfb;
    DAT_00003a3e = 0;
    if ((RAM_Purge_status & 0x80) == 0) {
      RAM_Insptid_ms10 = 0;
      RAM_Purge_status = RAM_Purge_status | 0x14;
    }
    else {
      RAM_Purge_status = RAM_Purge_status | 0x14;
      sVar1 = Function_0006A4E4(0x75be,0x4e16);
      RAM_Insptid_ms10 = sVar1 << 8;
    }
    if (DAT_0000102e < (char)RAM_Build_up_time_2_) {
      DAT_00004738 = RAM_Build_up_time_;
    }
    else {
      DAT_00004738 = RAM_Batt_korr_tab_;
    }
    Function_00046184(DAT_00004738);
  }
  return;
}

```
