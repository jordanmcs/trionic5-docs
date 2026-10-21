# Function_0006D8A0

**ROM:** `0x0006D8A0`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0006D8A0(void)

{
  uint uVar1;
  undefined4 uVar2;
  uint uVar3;
  byte *extraout_A1;
  byte *extraout_A1_00;
  byte *extraout_A1_01;
  byte *extraout_A1_02;
  byte *extraout_A1_03;
  byte *extraout_A1_04;
  byte *extraout_A1_05;
  byte *extraout_A1_06;
  byte *extraout_A1_07;
  byte *pbVar4;
  
  if ((DAT_00003a48 == '\x03') ||
     ((((DAT_00003a48 != '\x02' && (DAT_00003a48 != '\x01')) && ((RAM_Ramp_steg_[0] & 0x80) == 0))
      || ((DAT_00001039 & 8) != 0)))) {
    DAT_00001060 = Function_0004A566();
    uVar1 = DAT_00003a52;
    if ((RAM_Ramp_steg_[4] & 1) != 0) {
      if ((((DAT_0000103c & 0x40) == 0) || ((DAT_00001039 & 8) == 0)) || ((DAT_0000103a & 4) == 0))
      {
        DAT_00003a4c = 0;
      }
      else {
        DAT_00003a4e = DAT_00003a52;
        DAT_00003a52 = DAT_00003a56;
        DAT_00003a56 = DAT_00003a5a;
        DAT_00003a5a = DAT_00003a5e;
        DAT_00003a5e = DAT_00003a62;
        DAT_00003a62 = DAT_00003a66;
        DAT_00003a66 = (uint)DAT_00001066 * (uint)DAT_00001060;
        if (DAT_00003a4c < 7) {
          DAT_00003a4c = DAT_00003a4c + 1;
        }
        else if (DAT_00001066 < DAT_0000475c) {
          DAT_00001060 = (ushort)(uVar1 / DAT_00001066);
        }
      }
      DAT_0000475c = DAT_00001066;
    }
    DAT_0000355a = (RAM_Lufttemp + 0x180) * (uint)DAT_00001060 >> 9;
    DAT_00004758 = (undefined1)(DAT_00001060 / 10);
    DAT_00003560 = (RAM_Lufttemp + 0x180) * (DAT_00001060 / 10 & 0xff) >> 9;
    if (DAT_00003560 < 0x100) {
      DAT_00001032 = (byte)DAT_00003560;
    }
    else {
      DAT_00001032 = 0xff;
    }
    DAT_00001037 = DAT_00001032;
    if ((DAT_00001066 < 500) || (1 < DAT_0000475a)) {
      DAT_0000475a = 0;
      RAM_Extern_tid = (byte  [4])(DAT_0000355a * DAT_00004bf4);
      *(byte (*) [4])(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) = RAM_Extern_tid;
      if (((DAT_00003a18 & 0x80) == 0) || (0x7f < RAM_Start_detekt_nr_)) {
        *(uint *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) =
             *(int *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) *
             (RAM_Start_detekt_nr_ + 0x180) >> 9;
      }
      if ((((RAM_Ramp_steg_[2] & 2) == 0) || (RAM_Purge_map_yaxis_[0xb] <= DAT_00001037)) ||
         (DAT_00004ed0 <= DAT_00001066)) {
        if (((DAT_00001119 & 1) == 0) || (DAT_00001037 <= DAT_00006412)) {
          DAT_0000103a = DAT_0000103a & 0xfd;
          DAT_0000103c = DAT_0000103c & 0xbf;
          DAT_000035c6 = 0;
          DAT_0000102c = Function_00072972(&DAT_00004e62,&DAT_00004e72,&DAT_00004976,0x100010,
                                           (uint)CONCAT12(DAT_00001037,DAT_00001066));
          *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_03 * 4) =
               *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_03 * 4) * (DAT_0000102c + 0x80)
               >> 8;
          if ((DAT_00003a18 & 0x80) == 0) {
            DAT_0000102c = Function_00072972(&DAT_00004e62,&DAT_00004e72,&DAT_00004876,0x100010,
                                             (uint)CONCAT12(DAT_00001037,DAT_00001066));
            *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_04 * 4) =
                 *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_04 * 4) *
                 (DAT_0000102c + 0x80) >> 8;
          }
        }
        else {
          DAT_0000102c = Function_00072972(&DAT_00006412,&DAT_00004e72,&DAT_00006352,0xc0010,
                                           (uint)CONCAT12(DAT_00001037,DAT_00001066));
          *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_02 * 4) =
               *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_02 * 4) * (DAT_0000102c + 0x80)
               >> 8;
          DAT_0000103a = DAT_0000103a | 2;
          DAT_0000103c = DAT_0000103c & 0xbf;
          DAT_000035c6 = 0;
        }
      }
      else if (DAT_000035c6 < RAM_Lamb_temp_) {
        DAT_0000103a = DAT_0000103a & 0xfd;
        DAT_0000103c = DAT_0000103c & 0xbf;
        DAT_000035c6 = DAT_000035c6 + 1;
        DAT_0000102c = Function_00072972(&DAT_00004e62,&DAT_00004e72,&DAT_00004976,0x100010,
                                         (uint)CONCAT12(DAT_00001037,DAT_00001066));
        *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_00 * 4) =
             *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_00 * 4) * (DAT_0000102c + 0x80) >>
             8;
        if ((DAT_00003a18 & 0x80) == 0) {
          DAT_0000102c = Function_00072972(&DAT_00004e62,&DAT_00004e72,&DAT_00004876,0x100010,
                                           (uint)CONCAT12(DAT_00001037,DAT_00001066));
          *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_01 * 4) =
               *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_01 * 4) * (DAT_0000102c + 0x80)
               >> 8;
        }
      }
      else {
        DAT_0000102c = Function_00072972(RAM_Purge_map_yaxis_,&DAT_00004ec2,RAM_Lambdamatris_diag_,
                                         0xc0008,(uint)CONCAT12(DAT_00001037,DAT_00001066));
        *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4) =
             *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4) * (DAT_0000102c + 0x80) >> 8;
        DAT_0000103c = DAT_0000103c | 0x40;
        *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4) =
             *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4) *
             (RAM_Adapt_injfaktor_ + 0x180) >> 9;
      }
      Function_0006F1F2();
      Function_0006F314();
      Function_00069FEC();
      if ((RAM_Ramp_steg_[3] & 0x80) == 0) {
        if ((DAT_0000103c & 2) == 0) {
          DAT_00004746 = (ushort)((uint)((int)(short)(ushort)RAM_Temp_fak *
                                        (int)(short)(ushort)DAT_000046d4) / 0xff);
        }
        else {
          DAT_00004746 = (ushort)RAM_Temp_fak;
        }
      }
      else {
        DAT_00004746 = (ushort)((uint)((int)(short)(ushort)RAM_Temp_fak *
                                      (int)(short)(ushort)DAT_000046d4) / 0xff);
      }
      DAT_0000104a = (byte)DAT_00004746;
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_05 * 4) =
           *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_05 * 4) *
           ((byte)DAT_00004746 + 0x80) >> 7;
      Function_0006E722();
      Function_0006BFA4();
      uVar3 = *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) *
              (RAM_Last_delta[(short)(ushort)*extraout_A1_06] + 0x100) >> 8;
      uVar1 = *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) *
              ((uint)RAM_Acc_temp[(short)(ushort)*extraout_A1_06] * 4 + 0x80) >> 7;
      if (uVar3 < uVar1) {
        *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) = uVar1;
      }
      else {
        *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) = uVar3;
      }
      DAT_000035d8 = *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) *
                     (0x100 - (uint)RAM_Lacc_mangd[(short)(ushort)*extraout_A1_06]) >> 8;
      DAT_000035d0 = *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) *
                     (0x80 - (uint)(RAM_Ret_temp[(short)(ushort)*extraout_A1_06] >> 1)) >> 7;
      if (DAT_000035d0 < DAT_000035d8) {
        *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) = DAT_000035d0;
      }
      else {
        *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) = DAT_000035d8;
      }
      if ((RAM_Ramp_steg_[0] & 2) == 0) {
        DAT_0000103d = DAT_0000103d & 0xbf;
      }
      else {
        for (DAT_00003556 = 0;
            ((ushort)(&DAT_00004e72)[(short)(ushort)DAT_00003556] < DAT_00001066 &&
            (DAT_00003556 != 0xf)); DAT_00003556 = DAT_00003556 + 1) {
        }
        if (RAM_Accel_temp2_[(short)(ushort)DAT_00003556] < DAT_00001015) {
          RAM_AD_cat = RAM_Fload_throt_tab_[(short)(ushort)DAT_00003556];
          *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) =
               *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) * (RAM_AD_cat + 0x200)
               >> 9;
          DAT_0000103d = DAT_0000103d | 0x40;
        }
        else {
          DAT_0000103d = DAT_0000103d & 0xbf;
        }
      }
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) =
           *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) * (DAT_00001031 + 0x180) >>
           9;
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) =
           *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) * (DAT_00001151 + 0x400) >>
           10;
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) =
           *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) * (RAM_After_fcut + 0x400)
           >> 10;
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) =
           *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) * (DAT_000032d2 + 0x400) >>
           10;
      if (DAT_00001037 < RAM_Min_tid_) {
        *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) =
             *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) *
             ((byte)(&DAT_00004e0c)[(short)(ushort)*extraout_A1_06] + 0x180) >> 9;
      }
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) =
           (*(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) + (uint)RAM_Rpm_idle_nom) -
           (uint)DAT_00001164;
      if (((DAT_0000103c & 0x20) != 0) && (RAM_Cyl_nr != 0)) {
        *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) =
             *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) +
             (((int)RAM_Extern_tid * (RAM_Purge_adapt_othr + 0x180) >> 9) - (int)RAM_Extern_tid);
      }
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) =
           *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) / 10;
      DAT_000035e6 = RAM_Bil_hast / 10;
      if (0xe < DAT_000035e6) {
        DAT_000035e6 = 0xe;
      }
      if (DAT_000035e6 < 5) {
        DAT_000035e6 = 4;
      }
      DAT_0000198c = *(ushort *)(RAM_Data_namn_ + (short)(0xe - (ushort)DAT_000035e6) * 2);
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) =
           *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4) + (uint)DAT_0000198c;
      pbVar4 = extraout_A1_06;
      if (((RAM_Ramp_steg_[4] & 8) != 0) && ((DAT_00003736 & 0x80) != 0)) {
        uVar2 = Function_0004AA8C(*(undefined4 *)
                                   (&DAT_00004748 + (short)(ushort)*extraout_A1_06 * 4));
        *(undefined4 *)(&DAT_00004748 + (short)(ushort)*extraout_A1_07 * 4) = uVar2;
        pbVar4 = extraout_A1_07;
      }
      if (((RAM_Ramp_steg_[1] & 8) == 0) || ((DAT_00001137 & 0x20) == 0)) {
        if ((RAM_Ramp_steg_[1] & 1) != 0) {
          *(uint *)(&DAT_00004748 + (short)(ushort)*pbVar4 * 4) = (uint)RAM_Eft_fak_bas2;
        }
      }
      else {
        *(uint *)(&DAT_00004748 + (short)(ushort)*pbVar4 * 4) = (uint)RAM_Lupp_detekt_;
      }
      if (*(uint *)(&DAT_00004748 + (short)(ushort)*pbVar4 * 4) < (uint)RAM_Inj_konst_) {
        *(uint *)(&DAT_00004748 + (short)(ushort)*pbVar4 * 4) = (uint)RAM_Inj_konst_;
      }
      if ((uint)DAT_00003b70 * 0x2d0 <
          (uint)(*(int *)(&DAT_00004748 + (short)(ushort)*pbVar4 * 4) << 2)) {
        *(uint *)(&DAT_00004748 + (short)(ushort)*pbVar4 * 4) = (uint)DAT_00003b70 * 0xb4;
      }
      if (((DAT_0000103c & 0x80) == 0) && ((DAT_0000103b & 1) != 0)) {
        RAM_Insptid_ms10 = (word)(*(uint *)(&DAT_00004748 + (short)(ushort)*pbVar4 * 4) >> 1);
      }
      else {
        RAM_Insptid_ms10 = *(word *)(&DAT_0000474a + (short)(ushort)*pbVar4 * 4);
      }
      if (0x7ef4 < RAM_Insptid_ms10) {
        RAM_Insptid_ms10 = 0x7ef4;
      }
      _DAT_00001062 = RAM_Insptid_ms10 / 0x19;
    }
    else {
      DAT_0000475a = DAT_0000475a + 1;
      if (RAM_Trot_delta < DAT_00001015) {
        DAT_000035e0 = DAT_00001015 - RAM_Trot_delta;
      }
      else {
        DAT_000035e0 = '\0';
      }
      (&DAT_0000475e)[(short)(ushort)DAT_0000101d] = DAT_000035e0;
      RAM_Ret_temp[(short)(ushort)DAT_0000101d] = 0;
      RAM_Acc_temp[(short)(ushort)DAT_0000101d] = 0;
    }
    DAT_00003a48 = 3;
  }
  else {
    DAT_00001060 = Function_0004A566();
    uVar1 = DAT_00003a52;
    if ((RAM_Ramp_steg_[4] & 1) != 0) {
      if ((((DAT_0000103c & 0x40) == 0) || ((DAT_00001039 & 8) == 0)) || ((DAT_0000103a & 4) == 0))
      {
        DAT_00003a4c = 0;
      }
      else {
        DAT_00003a4e = DAT_00003a52;
        DAT_00003a52 = DAT_00003a56;
        DAT_00003a56 = DAT_00003a5a;
        DAT_00003a5a = DAT_00003a5e;
        DAT_00003a5e = DAT_00003a62;
        DAT_00003a62 = DAT_00003a66;
        DAT_00003a66 = (uint)DAT_00001066 * (uint)DAT_00001060;
        if (DAT_00003a4c < 7) {
          DAT_00003a4c = DAT_00003a4c + 1;
        }
        else if (DAT_00001066 < DAT_0000475c) {
          DAT_00001060 = (ushort)(uVar1 / DAT_00001066);
        }
      }
      DAT_0000475c = DAT_00001066;
    }
    DAT_0000355a = (RAM_Lufttemp + 0x180) * (uint)DAT_00001060 >> 9;
    DAT_00004758 = (undefined1)(DAT_00001060 / 10);
    DAT_00003560 = (RAM_Lufttemp + 0x180) * (DAT_00001060 / 10 & 0xff) >> 9;
    if (DAT_00003560 < 0x100) {
      DAT_00001032 = (byte)DAT_00003560;
    }
    else {
      DAT_00001032 = 0xff;
    }
    DAT_00001037 = DAT_00001032;
    DAT_00003a1a = 0;
    DAT_00003a4a = 0;
    if ((RAM_Ramp_steg_[1] & 1) == 0) {
      Function_0006EF58();
      DAT_000035e6 = RAM_Bil_hast / 10;
      if (0xe < DAT_000035e6) {
        DAT_000035e6 = 0xe;
      }
      if (DAT_000035e6 < 5) {
        DAT_000035e6 = 4;
      }
      DAT_0000198c = *(ushort *)(RAM_Data_namn_ + (short)(0xe - (ushort)DAT_000035e6) * 2);
      *(uint *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) =
           *(int *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) + (uint)DAT_0000198c;
      if ((uint)DAT_00003b70 * 0x2d0 <
          (uint)(*(int *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) << 2)) {
        *(uint *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) = (uint)DAT_00003b70 * 0xb4;
      }
      if (((DAT_0000103c & 0x80) == 0) && ((DAT_0000103b & 1) != 0)) {
        RAM_Insptid_ms10 = (word)(*(uint *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) >> 1);
      }
      else {
        RAM_Insptid_ms10 = *(word *)(&DAT_0000474a + (short)(ushort)DAT_0000101d * 4);
      }
      if (0x7ef4 < RAM_Insptid_ms10) {
        RAM_Insptid_ms10 = 0x7ef4;
      }
      _DAT_00001062 = RAM_Insptid_ms10 / 0x19;
      DAT_00003a48 = 2;
    }
    else {
      *(uint *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) = (uint)RAM_Eft_fak_bas2;
      if ((uint)DAT_00003b70 * 0x2d0 <
          (uint)(*(int *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) << 2)) {
        *(uint *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) = (uint)DAT_00003b70 * 0xb4;
      }
      if (((DAT_0000103c & 0x80) == 0) && ((DAT_0000103b & 1) != 0)) {
        RAM_Insptid_ms10 = (word)(*(uint *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) >> 1);
      }
      else {
        RAM_Insptid_ms10 = *(word *)(&DAT_0000474a + (short)(ushort)DAT_0000101d * 4);
      }
      _DAT_00001062 = RAM_Insptid_ms10 / 0x19;
      DAT_00003a48 = 1;
    }
  }
  return;
}

```
