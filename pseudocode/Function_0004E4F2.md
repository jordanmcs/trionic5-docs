# Function_0004E4F2

**ROM:** `0x0004E4F2`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0004E4F2(void)

{
  short sVar1;
  int iVar2;
  byte bVar3;
  byte bVar4;
  byte *pbVar5;
  short *psVar6;
  
  pbVar5 = RAM_Cat_rpm_tab_;
  for (bVar4 = 0;
      ((ushort)(*(short *)(RAM_Cat_rpm_tab_ + (short)(bVar4 + 1) * 2) + *(short *)pbVar5) >> 1 <
       (ushort)DAT_00001032 && (bVar4 != 7)); bVar4 = bVar4 + 1) {
    pbVar5 = pbVar5 + 2;
  }
  psVar6 = &DAT_000073cc;
  for (bVar3 = 0;
      ((ushort)((&DAT_000073cc)[(short)(bVar3 + 1)] + *psVar6) >> 1 < DAT_00003c32 && (bVar3 != 7));
      bVar3 = bVar3 + 1) {
    psVar6 = psVar6 + 1;
  }
  sVar1 = (ushort)bVar4 + (ushort)bVar3 * 8;
  DAT_00003f02 = *(ushort *)(&DAT_000072b6 + sVar1 * 2);
  iVar2 = (int)DAT_000037da +
          (uint)*(ushort *)(&DAT_000072b6 + sVar1 * 2) *
          ((uint)RAM_Cat_ox1_duty_cycle - (uint)DAT_00003f00);
  DAT_000037da = (short)(iVar2 % 1000);
  DAT_00003f00 = (short)(iVar2 / 1000) + DAT_00003f00;
  RAM_Cat_ox1_filt = DAT_00003f00 - RAM_Cat_ox1_filt_coef_map_;
  DAT_000037d6 = RAM_Cat_ox1_filt;
  if ((short)RAM_Cat_ox1_filt < 0) {
    DAT_000037d6 = -RAM_Cat_ox1_filt;
  }
  DAT_00003efc = *(ushort *)(RAM_Cat_ox1_err_lim_ + sVar1 * 2);
  iVar2 = (int)DAT_000037d2 +
          (uint)*(ushort *)(RAM_Cat_ox1_err_lim_ + sVar1 * 2) *
          ((uint)RAM_U_lambda_eng - (uint)DAT_00003efa);
  DAT_000037d2 = (short)(iVar2 % 1000);
  DAT_00003efa = (short)(iVar2 / 1000) + DAT_00003efa;
  DAT_00003ef6 = RAM_U_lambda_eng - DAT_00003efa;
  DAT_00003ef8 = DAT_00003ef6;
  if ((short)DAT_00003ef6 < 0) {
    DAT_00003ef6 = -DAT_00003ef6;
  }
  iVar2 = (int)DAT_000037d0 +
          (uint)RAM_Cat_ox2_filt_coef_map_ * ((uint)DAT_00003ef6 - (int)(short)RAM_Cat_ox2_filt);
  DAT_000037d0 = (short)(iVar2 % 1000);
  RAM_Cat_ox2_filt = (short)(iVar2 / 1000) + RAM_Cat_ox2_filt;
  if (((short)RAM_Cat_ox1_filt < 0) || (-1 < _DAT_000037d8)) {
    if ((-1 < (short)RAM_Cat_ox1_filt) && (DAT_000037cc < 0xffdc)) {
      DAT_000037cc = DAT_000037cc + 10;
    }
    if (((short)RAM_Cat_ox1_filt < 0) && (RAM_Cat_ox1_per_hi < 0xffdc)) {
      RAM_Cat_ox1_per_hi = RAM_Cat_ox1_per_hi + 10;
    }
    if ((short)DAT_000037d4 < (short)RAM_Cat_ox1_filt) {
      DAT_000037d4 = RAM_Cat_ox1_filt;
    }
    if ((short)DAT_000037ce < (short)RAM_Cat_ox2_filt) {
      DAT_000037ce = RAM_Cat_ox2_filt;
    }
    if (DAT_00007338 < DAT_000037d6) {
      RAM_n_Engine_delta_180[0] = RAM_n_Engine_delta_180[0] | 2;
    }
  }
  else {
    pbVar5 = RAM_Cat_ox2_filt_coef_2_;
    for (bVar4 = 0;
        ((ushort)(*(short *)(RAM_Cat_ox2_filt_coef_2_ + (short)(bVar4 + 1) * 2) + *(short *)pbVar5)
         >> 1 < RAM_Cat_delta_load && (bVar4 != 7)); bVar4 = bVar4 + 1) {
      pbVar5 = pbVar5 + 2;
    }
    RAM_Cat_ox1_per_lo = *(word *)(&DAT_000073ec + (uint)bVar4 * 2);
    bVar3 = RAM_n_Engine_delta_180[0] | 1;
    if (RAM_Cat_ox1_per_lo < DAT_000037cc) {
      bVar3 = RAM_n_Engine_delta_180[0] & 0xfe;
    }
    RAM_n_Engine_delta_180[0] = bVar3;
    RAM_Cat_ox1_per_hi_lim = *(word *)(&DAT_000073fc + (uint)bVar4 * 2);
    if (RAM_Cat_ox1_per_hi_lim < RAM_Cat_ox1_per_hi) {
      RAM_n_Engine_delta_180[0] = RAM_n_Engine_delta_180[0] & 0xfe;
    }
    RAM_Cat_ox1_per_lo_lim =
         (byte)(((uint)DAT_000037cc * 100) / (uint)(ushort)(RAM_Cat_ox1_per_hi + DAT_000037cc + 1));
    bVar4 = RAM_n_Engine_delta_180[1] | 0x80;
    if (DAT_0000740c < RAM_Cat_ox1_per_lo_lim) {
      bVar4 = RAM_n_Engine_delta_180[1] & 0x7f;
    }
    RAM_n_Engine_delta_180[1] = bVar4;
    if (RAM_Cat_ox1_per_lo_lim < RAM_Cat_ox1_duty_hi_lim_) {
      RAM_n_Engine_delta_180[1] = RAM_n_Engine_delta_180[1] & 0x7f;
    }
    if (((((RAM_n_Engine_delta_180[0] & 1) != 0) && ((RAM_n_Engine_delta_180[1] & 0x80) != 0)) &&
        ((RAM_n_Engine_delta_180[0] & 4) != 0)) && ((RAM_n_Engine_delta_180[0] >> 1 & 1) == 0)) {
      RAM_n_Engine_delta_180[1] = RAM_n_Engine_delta_180[1] | 0x40;
    }
  }
  return;
}

```
