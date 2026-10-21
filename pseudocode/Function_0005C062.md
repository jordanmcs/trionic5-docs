# Function_0005C062

**ROM:** `0x0005C062`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0005C062(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  byte *pbVar4;
  
  if (((RAM_Samp_pek[0] & 1) == 0) && ((int)RAM_Diag_tid + 10U < DAT_00001a58)) {
    if (((DAT_0000103a & 4) == 0) || ((RAM_PWM_ut10 < 0x55 || ((DAT_00001137 & 0x80) == 0)))) {
      DAT_0000402e = '\0';
      _DAT_00004070 = RAM_Crankshaft_error;
      DAT_0000406c = RAM_Crankshaft_error;
      DAT_00004058 = DAT_00001066;
    }
    if (DAT_00001066 < DAT_00004058) {
      DAT_00004058 = DAT_00001066;
      DAT_0000406c = RAM_Crankshaft_error;
      RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] | 1;
    }
    else if (((ushort)(DAT_00004058 + 0x28) < DAT_00001066) && ((RAM_Samp_pek[0xd] & 1) != 0)) {
      if ((uint)RAM_Crankshaft_error < (int)DAT_0000406c + 200U) {
        DAT_0000402e = DAT_0000402e + '\x01';
        RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0xfe;
        DAT_00004058 = DAT_00001066;
        DAT_0000406c = RAM_Crankshaft_error;
      }
      else {
        DAT_0000402e = '\0';
        _DAT_00004070 = RAM_Crankshaft_error;
        DAT_0000406c = RAM_Crankshaft_error;
        DAT_00004058 = DAT_00001066;
      }
    }
    if (((((RAM_Samp_pek[4] & 2) == 0) || ((DAT_00001039 & 0x10) == 0)) || ((DAT_00001138 & 8) == 0)
        ) || (DAT_0000101c != '\0')) {
      DAT_00004060 = DAT_00001a58;
    }
    else if ((((RAM_Trot_limit_ac_ < RAM_LLS_lage) ||
              (DAT_00001066 <= (ushort)(DAT_00001160 + 0x14U))) &&
             ((RAM_Trot_limit_ac_ < DAT_00001156 || (DAT_00001066 <= (ushort)(DAT_00001160 + 0x14U))
              ))) && (((RAM_LLS_lage < 0x270 || ((ushort)(DAT_00001160 - 10U) <= DAT_00001066)) ||
                      (DAT_00001037 < 0x15)))) {
      DAT_00004060 = DAT_00001a58;
    }
    if (DAT_00004060 + 5 < DAT_00001a58) {
      RAM_Samp_pek[0] = RAM_Samp_pek[0] | 1;
      if (DAT_00001066 < 0x65) {
        DAT_00004030 = 0x40;
      }
      else {
        DAT_00004030 = 0x80;
      }
      Function_0005F0B8(&RAM_Hast_error);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      pbVar4 = RAM_Hast_frame;
      do {
        *(undefined4 *)pbVar4 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        pbVar4 = pbVar4 + 4;
      } while (sVar1 != -1);
      if ((*extraout_A1 < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        *extraout_A1 = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        *extraout_A1 = 0x2c;
        DAT_000040e4 = DAT_000040e4 | 0x40;
      }
    }
    else if (((((RAM_Samp_pek[4] & 2) != 0) && ((DAT_00001039 & 0x10) != 0)) &&
             ((DAT_00001138 & 8) != 0)) &&
            (((DAT_0000101c == '\0' && ((RAM_Samp_pek[4] & 4) == 0)) &&
             (((RAM_Samp_pek[0xb] & 0x40) == 0 && ((RAM_Samp_pek[8] & 0x40) != 0)))))) {
      if (RAM_Hast_error < 0x28) {
        bVar2 = DAT_00003fe8 >> 6;
      }
      else {
        bVar2 = DAT_00003fe8 >> 5;
      }
      if ((bVar2 & 1) != 0) {
        if (RAM_Hast_error != 0) {
          RAM_Hast_error = RAM_Hast_error - 1;
          RAM_Samp_pek[4] = RAM_Samp_pek[4] | 4;
        }
        DAT_00004060 = DAT_00001a58;
      }
    }
  }
  if (RAM_Hast_error == 0) {
    DAT_00004030 = 0;
    DAT_000040e4 = DAT_000040e4 & 0xbf;
  }
  return;
}

```
