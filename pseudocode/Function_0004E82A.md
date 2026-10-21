# Function_0004E82A

**ROM:** `0x0004E82A`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0004E82A(void)

{
  byte bVar1;
  byte bVar2;
  byte *pbVar3;
  short *psVar4;
  
  if ((RAM_n_Engine_delta_180[1] & 0x40) != 0) {
    if (((DAT_00006e20 & 0x40) != 0) &&
       (RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] != 0xff)) {
      RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
           RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] + 1;
    }
    pbVar3 = RAM_Cat_rpm_tab_;
    for (bVar1 = 0;
        ((ushort)(*(short *)(RAM_Cat_rpm_tab_ + (short)(bVar1 + 1) * 2) + *(short *)pbVar3) >> 1 <
         (ushort)DAT_00001032 && (bVar1 != 7)); bVar1 = bVar1 + 1) {
      pbVar3 = pbVar3 + 2;
    }
    psVar4 = &DAT_000073cc;
    for (bVar2 = 0;
        ((ushort)((&DAT_000073cc)[(short)(bVar2 + 1)] + *psVar4) >> 1 < DAT_00003c32 && (bVar2 != 7)
        ); bVar2 = bVar2 + 1) {
      psVar4 = psVar4 + 1;
    }
    RAM_U_lambda_cat =
         *(word *)(RAM_Cat_ox1_err_max_tab_ + (short)((ushort)bVar1 + (ushort)bVar2 * 8) * 2);
    RAM_Cat_avg_dev_diff = DAT_000037ce - RAM_U_lambda_cat;
    if ((short)RAM_Cat_avg_dev_diff < 0) {
      RAM_Cat_avg_dev_diff = 0;
    }
    if (0xff < (short)RAM_Cat_avg_dev_diff) {
      RAM_Cat_avg_dev_diff = 0xff;
    }
    RAM_Cat_dev_diff = RAM_Cat_avg_dev_diff + RAM_Cat_dev_diff;
    if (DAT_000037c6 < RAM_Cat_ox2_dev_max_map_) {
      DAT_000037c6 = DAT_000037c6 + 1;
    }
    else {
      RAM_Cat_ox2_dev_samp = (short)RAM_Cat_dev_diff / (short)(ushort)DAT_000037c6;
      RAM_n_Engine_delta_180[1] = RAM_n_Engine_delta_180[1] | 0x20;
      DAT_00003eec = RAM_Cat_ox2_dev_samp;
    }
    RAM_n_Engine_delta_180[1] = RAM_n_Engine_delta_180[1] & 0xbf;
  }
  if (((RAM_n_Engine_delta_180[1] & 0x20) != 0) && ((RAM_n_Engine_delta_180[1] >> 4 & 1) == 0)) {
    if (RAM_Cat_ox2_dev_samp < DAT_000074a2) {
      RAM_n_Engine_delta_180[1] = RAM_n_Engine_delta_180[1] & 0xcf | 8;
    }
    else {
      RAM_n_Engine_delta_180[1] = RAM_n_Engine_delta_180[1] & 0xdf | 0x18;
    }
  }
  if ((-1 < (short)RAM_Cat_ox1_filt) && (_DAT_000037d8 < 0)) {
    DAT_000037cc = 0;
    RAM_Cat_ox1_per_hi = 0;
    DAT_000037d4 = 0;
    DAT_000037ce = 0;
    RAM_n_Engine_delta_180[0] = RAM_n_Engine_delta_180[0] & 0xfd;
  }
  return;
}

```
