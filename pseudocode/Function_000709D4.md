# Function_000709D4

**ROM:** `0x000709D4`

```c

void Function_000709D4(undefined4 param_1)

{
  short sVar1;
  uint uVar2;
  byte *pbVar3;
  byte *extraout_A1;
  
  if ((DAT_00001137 & 0x20) == 0) {
    pbVar3 = &DAT_00003a6a;
    if (((((DAT_0000103a & 4) == 0) || (DAT_00001066 < 0xc9)) || (0xf9 < DAT_00001066)) ||
       ((DAT_0000102e < 'B' || (sVar1 = Function_000445AC(), pbVar3 = extraout_A1, sVar1 != 0)))) {
      *pbVar3 = 0;
    }
    else if (*extraout_A1 < RAM_lIv_min_tab_ac_) {
      *extraout_A1 = *extraout_A1 + 1;
    }
    else if (((DAT_000062d6 < DAT_00001013) && (-100 < DAT_00003460)) &&
            (param_1._0_2_ < DAT_00004762)) {
      *extraout_A1 = 0;
      DAT_00003460 = DAT_00003460 - (ushort)RAM_Iv_min_load_;
    }
    else if ((DAT_00001013 < DAT_000062d6) && (DAT_00003460 < 100)) {
      *extraout_A1 = 0;
      DAT_00003460 = (ushort)RAM_Iv_min_load_ + DAT_00003460;
    }
    uVar2 = DAT_00003c32 / 0x7d;
    DAT_00003568 = (undefined1)uVar2;
    if (((DAT_00001137 & 0x40) == 0) && ((DAT_0000103a & 4) == 0)) {
      DAT_00004762 = *(ushort *)(&DAT_00006268 + (uVar2 & 0xff) * 2);
    }
    else {
      DAT_00004762 = *(ushort *)(&DAT_000061fc + (uVar2 & 0xff) * 2);
    }
    DAT_00003566 = DAT_00003460 + DAT_00004762;
    RAM_LLS_lage = DAT_00003566;
    DAT_00004762 = DAT_00003566;
    if (DAT_00003566 <= param_1._0_2_) {
      RAM_LLS_lage = param_1._0_2_;
    }
  }
  else {
    RAM_LLS_lage = param_1._0_2_;
  }
  if (RAM_LLS_lage < 0x271) {
    if (RAM_LLS_lage < RAM_Trot_limit_ac_) {
      RAM_LLS_lage = RAM_Trot_limit_ac_;
    }
  }
  else {
    RAM_LLS_lage = 0x270;
  }
  Function_00046782();
  return;
}

```
