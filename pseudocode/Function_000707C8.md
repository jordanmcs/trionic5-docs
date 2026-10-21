# Function_000707C8

**ROM:** `0x000707C8`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000707C8(void)

{
  ushort uVar1;
  ushort *extraout_A1;
  ushort *extraout_A1_00;
  
  if (((DAT_00001039 & 8) == 0) || ((RAM_Ramp_steg_[2] & 0x10) == 0)) {
    RAM_Rpm_idle_nom = 0;
    DAT_00001164 = 0;
  }
  else {
    if ((DAT_00001137 & 0x20) == 0) {
      RAM_Rpm_idle_nom = 0;
      DAT_00001164 = 0;
    }
    else if (DAT_00001160 < DAT_00001066) {
      DAT_0000356c = (char)DAT_00001066 - (char)DAT_00001160;
      if (8 < DAT_0000356c) {
        DAT_0000356c = 8;
      }
      DAT_00001164 = (&DAT_00006114)[DAT_0000356c];
      RAM_Rpm_idle_nom = 0;
    }
    else {
      if (DAT_00001066 < DAT_00001160) {
        DAT_0000356c = (char)DAT_00001160 - (char)DAT_00001066;
        if (8 < DAT_0000356c) {
          DAT_0000356c = 8;
        }
        RAM_Rpm_idle_nom = *(word *)(RAM_Derivata_br_tab_pos_ + (uint)DAT_0000356c * 2 + 0xe);
      }
      else {
        RAM_Rpm_idle_nom = 0;
      }
      DAT_00001164 = 0;
    }
    if (((DAT_00001066 < DAT_000060e4) && ((DAT_0000103a & 4) != 0)) &&
       (DAT_0000101c < DAT_0000609c)) {
      _DAT_00004766 = RAM_Rpm_idle_nom;
      _DAT_00004764 = DAT_00001164;
      if (DAT_0000356a < DAT_00003c32) {
        RAM_APC_status = DAT_00003c32 - DAT_0000356a;
        uVar1 = Function_0006A410(RAM_Derivata_br_tab_neg_,RAM_DI_cassette_U_limit_,8);
        *extraout_A1 = uVar1;
        if (DAT_00001164 == 0) {
          if (RAM_Rpm_idle_nom == 0) {
            DAT_00001164 = *extraout_A1;
          }
          else if (RAM_Rpm_idle_nom < *extraout_A1) {
            *extraout_A1 = *extraout_A1 - RAM_Rpm_idle_nom;
            DAT_00001164 = *extraout_A1;
            RAM_Rpm_idle_nom = 0;
          }
          else {
            RAM_Rpm_idle_nom = RAM_Rpm_idle_nom - *extraout_A1;
          }
        }
        else {
          DAT_00001164 = *extraout_A1 + DAT_00001164;
        }
      }
      else if (DAT_00003c32 < DAT_0000356a) {
        RAM_APC_status = DAT_0000356a - DAT_00003c32;
        uVar1 = Function_0006A410(RAM_Derivata_br_tab_neg_,RAM_Derivata_br_tab_pos_,8);
        *extraout_A1_00 = uVar1;
        if (RAM_Rpm_idle_nom == 0) {
          if (DAT_00001164 == 0) {
            RAM_Rpm_idle_nom = *extraout_A1_00;
          }
          else if (DAT_00001164 < *extraout_A1_00) {
            *extraout_A1_00 = *extraout_A1_00 - DAT_00001164;
            RAM_Rpm_idle_nom = *extraout_A1_00;
            DAT_00001164 = 0;
          }
          else {
            DAT_00001164 = DAT_00001164 - *extraout_A1_00;
          }
        }
        else {
          RAM_Rpm_idle_nom = *extraout_A1_00 + RAM_Rpm_idle_nom;
        }
      }
    }
  }
  DAT_0000356a = DAT_00003c32;
  return;
}

```
