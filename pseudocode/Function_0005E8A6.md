# Function_0005E8A6

**ROM:** `0x0005E8A6`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

byte Function_0005E8A6(void)

{
  ushort uVar1;
  byte *pbVar2;
  undefined1 *puVar3;
  
  RAM_STSWFS = 0;
  DAT_00001a58 = 0;
  DAT_000038fe = 0;
  DAT_00003764 = 0;
  RAM_Airpump_time[0] = 0;
  RAM_Airpump_time[1] = 0;
  RAM_Airpump_time[2] = 0;
  RAM_Airpump_time[3] = 0;
  DAT_00001ab0 = 0;
  DAT_00001ab4 = 0;
  DAT_000040d8 = 0;
  DAT_00001ab8 = 0;
  DAT_000040d4 = 0;
  DAT_000040d0 = 0;
  DAT_000040b0 = 0;
  RAM_Diag_tid[0] = 0;
  RAM_Diag_tid[1] = 0;
  RAM_Diag_tid[2] = 0;
  RAM_Diag_tid[3] = 0;
  DAT_00001a60 = 0;
  DAT_00004074 = 0;
  DAT_0000402a = 0;
  _DAT_00001a90 = 0;
  DAT_00001a8c = 0;
  RAM_Sond_tid_konst[0] = 0;
  RAM_Sond_tid_konst[1] = 0;
  RAM_Sond_tid_konst[2] = 0;
  RAM_Sond_tid_konst[3] = 0;
  DAT_00001a84 = 0;
  RAM_Luft_tid_end[0] = 0;
  RAM_Luft_tid_end[1] = 0;
  RAM_Luft_tid_end[2] = 0;
  RAM_Luft_tid_end[3] = 0;
  DAT_00001a78 = 0;
  DAT_00001a74 = 0;
  DAT_00001a70 = 0;
  RAM_Hast_tid_grans[0] = 0;
  RAM_Hast_tid_grans[1] = 0;
  RAM_Hast_tid_grans[2] = 0;
  RAM_Hast_tid_grans[3] = 0;
  DAT_00001a9c = 0;
  RAM_Luft_tid_konst[0] = 0;
  RAM_Luft_tid_konst[1] = 0;
  RAM_Luft_tid_konst[2] = 0;
  RAM_Luft_tid_konst[3] = 0;
  RAM_I_front_time[0] = 0;
  RAM_I_front_time[1] = 0;
  RAM_I_front_time[2] = 0;
  RAM_I_front_time[3] = 0;
  DAT_000040b8 = 0;
  DAT_000040b4 = 0;
  DAT_00001a80 = 0;
  DAT_000040ac = 0;
  DAT_00001a64 = 0;
  DAT_000040a8 = 0;
  RAM_Knock_time_low[0] = 0;
  RAM_Knock_time_low[1] = 0;
  RAM_Knock_time_low[2] = 0;
  RAM_Knock_time_low[3] = 0;
  RAM_Samp_pek[0] = 0;
  RAM_Samp_pek[1] = 0;
  RAM_Samp_pek[2] = 0;
  RAM_Samp_pek[3] = 0;
  RAM_Samp_pek[4] = 0;
  RAM_Samp_pek[5] = 0;
  RAM_Samp_pek[6] = 0;
  RAM_Samp_pek[7] = 0;
  RAM_Samp_pek[8] = 0;
  RAM_Samp_pek[9] = 0;
  RAM_Samp_pek[10] = 0;
  RAM_Samp_pek[0xb] = 0;
  RAM_Samp_pek[0xc] = 0;
  RAM_Samp_pek[0xd] = 0;
  RAM_Samp_pek[0xe] = 0;
  RAM_Samp_pek[0xf] = 0;
  RAM_Samp_pek[0x10] = 0;
  RAM_Samp_pek[0x11] = 0;
  DAT_00003ea8 = 0;
  DAT_00003ea9 = 0;
  DAT_00003eaa = 0;
  DAT_0000386c = DAT_00003b02;
  DAT_00003768 = DAT_00003b02;
  DAT_000010d0 = 0;
  RAM_Mis200_1 = 0;
  RAM_Mis200_2 = 0;
  RAM_Mis200_3 = 0;
  RAM_Mis200_4 = 0;
  RAM_C200_max = 0;
  DAT_000010de = 0;
  DAT_000010e0 = 0;
  DAT_000010e2 = 0;
  DAT_000010e4 = 0;
  RAM_Crankshaft_error[0] = 0;
  RAM_Crankshaft_error[1] = 0;
  RAM_Crankshaft_error[2] = 0;
  RAM_Crankshaft_error[3] = 0;
  DAT_00001082 = 0;
  RAM_Ign_counter2[0] = 0;
  RAM_Ign_counter2[1] = 0;
  RAM_Ign_counter2[2] = 0;
  RAM_Ign_counter2[3] = 0;
  RAM_Ign_counter3[0] = 0;
  RAM_Ign_counter3[1] = 0;
  RAM_Ign_counter3[2] = 0;
  RAM_Ign_counter3[3] = 0;
  DAT_000010ae = 0;
  _DAT_000010b0 = 0;
  _DAT_000010b2 = 0;
  DAT_0000407c = 0;
  DAT_00004078 = 0;
  DAT_00003864 = 0;
  DAT_00003862 = 0;
  DAT_00003866 = 0;
  DAT_00003868 = 0;
  RAM_Battery_time[0] = 0;
  RAM_Battery_time[1] = 0;
  RAM_Battery_time[2] = 0;
  RAM_Battery_time[3] = 0;
  DAT_00003334 = 0;
  DAT_00003333 = 0;
  DAT_00003858 = 0;
  RAM_MisCountMap4 = 0;
  RAM_Ox2_change = 0;
  Function_0004DFE2();
  uVar1 = 0;
  pbVar2 = RAM_OBD2_frame;
  do {
    *pbVar2 = 0;
    uVar1 = uVar1 + 1;
    pbVar2 = pbVar2 + 1;
  } while (uVar1 < 0x3c);
  DAT_00003fe8 = 0;
  Function_0004CF6C();
  RAM_BrakeCnt._0_1_ = RAM_BrakeCnt._0_1_ & 0x1f;
  DAT_00003850 = Function_00044BA4();
  RAM_PMProt_IdlePosIntABS = 0;
  Function_0005EDB0();
  DAT_00003fbe = 0;
  DAT_00003fba = 0;
  DAT_0000107e = 0;
  _DAT_000038f6 = 0;
  uVar1 = 0;
  puVar3 = &DAT_00003ea0;
  do {
    *puVar3 = 0;
    uVar1 = uVar1 + 1;
    puVar3 = puVar3 + 1;
  } while (uVar1 < 8);
  RAM_P_tank_new = 0;
  DAT_00003ed2 = 0;
  DAT_00003ec2 = 0;
  _DAT_00003ebe = 0;
  DAT_00003eba = 0;
  DAT_00003ed6 = 0;
  DAT_0000402e = 0;
  _DAT_00004070 = 0;
  DAT_00004058 = 500;
  DAT_0000406c = 0;
  DAT_00003882 = 0;
  DAT_00003880 = 0;
  DAT_0000387e = 0;
  DAT_0000387c = 0;
  DAT_00003876 = 400;
  DAT_00003874 = 0x1b8;
  DAT_00003872 = 400;
  DAT_00003870 = 400;
  DAT_000040ec = 0;
  DAT_000040ea = 0;
  _DAT_0000386a = 0;
  RAM_P_tank_first = 0;
  RAM_Press_diff = 0;
  DAT_000040c4 = 0;
  DAT_000040cc = 0;
  _DAT_000040c8 = 0;
  RAM_Misfgear_counter = 1;
  if ((DAT_00006e20 & 0x80) == 0) {
    RAM_Samp_pek[8] = RAM_Samp_pek[8] | 2;
  }
  return DAT_00006e20 & 0x80;
}

```
