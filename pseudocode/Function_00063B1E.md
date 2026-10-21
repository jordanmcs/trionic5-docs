# Function_00063B1E

**ROM:** `0x00063B1E`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00063B1E(undefined4 param_1,undefined4 param_2)

{
  ushort uVar1;
  short sVar2;
  byte bVar3;
  char *pcVar4;
  char *local_10;
  char *local_c;
  char *local_8;
  
  if ((param_2._0_2_ == 0xb4) || (param_2._0_2_ == 0x168)) {
    DAT_00003fc4 = (undefined1)((uint)param_1 >> 0x10);
  }
  else {
    DAT_00003fc2 = (undefined1)param_1;
  }
  if (((((((DAT_0000103c & 0x80) == 0x80) && (DAT_00003b78 == '\0')) && (DAT_00001118 == '\0')) &&
       (((DAT_000072a2 <= RAM_Bil_hast && ((RAM_OBD2_frame[0x12] & 0x80) == 0)) &&
        (((RAM_OBD2_frame[0] & 0x80) == 0 &&
         (((RAM_OBD2_frame[0xc] & 0x80) == 0 && ((DAT_0000400e & 0x80) == 0)))))))) &&
      ((RAM_P_man_korr_axis_ <= RAM_Purge_adapt_cthr ||
       ((RAM_Cyl_nr == 0 || ((DAT_0000103a & 4) != 0)))))) &&
     ((RAM_Pur_misadapt_othr_ <= RAM_Purge_duty || ((RAM_Cyl_nr == 0 || ((DAT_0000103a & 4) == 0))))
     )) {
    if (DAT_00001a58 < DAT_000038fe + DAT_00005af8) {
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
      RAM_Mis200_max = 0;
      DAT_000010e6 = 0;
      DAT_000038c6 = 0;
      RAM_Sond_ign_counter[0] = 0;
      RAM_Sond_ign_counter[1] = 0;
      RAM_Sond_ign_counter[2] = 0;
      RAM_Sond_ign_counter[3] = 0;
      RAM_Misfcut_ign_filt[0] = 0;
      RAM_Misfcut_ign_filt[1] = 0;
      RAM_Misfcut_ign_filt[2] = 0;
      RAM_Misfcut_ign_filt[3] = 0;
      _DAT_00001096 = 0;
      RAM_Misfrpm_ign_filt[0] = 0;
      RAM_Misfrpm_ign_filt[1] = 0;
      RAM_Misfrpm_ign_filt[2] = 0;
      RAM_Misfrpm_ign_filt[3] = 0;
      _DAT_0000109e = 0;
      RAM_Misfpur_ign_filt[0] = 0;
      RAM_Misfpur_ign_filt[1] = 0;
      RAM_Misfpur_ign_filt[2] = 0;
      RAM_Misfpur_ign_filt[3] = 0;
      RAM_Misftakeoff_ign_filt[0] = 0;
      RAM_Misftakeoff_ign_filt[1] = 0;
      RAM_Misftakeoff_ign_filt[2] = 0;
      RAM_Misftakeoff_ign_filt[3] = 0;
      DAT_00004656 = DAT_00001013;
      DAT_000038da = 0;
      DAT_000038f2 = 0;
      DAT_000038ee = 0;
      DAT_000038ea = 0;
      DAT_000038de = 0;
      DAT_000038fc = 0;
      DAT_000038e6 = 0;
      DAT_000038e2 = 0;
    }
    else {
      if (((((DAT_0000103a & 0x80) != 0) || ((DAT_0000103a & 0x40) != 0)) ||
          ((DAT_0000103a & 0x20) != 0)) || ((DAT_0000103a & 0x10) != 0)) {
        DAT_000038f2 = DAT_0000107e;
      }
      if ((DAT_00001039 & 0x20) != 0) {
        DAT_000038ee = DAT_0000107e;
      }
      if ((DAT_00001039 & 0x80) != 0) {
        DAT_000038ea = DAT_0000107e;
      }
      if (((DAT_00001137 & 4) != 0) || ((DAT_00001137 & 2) != 0)) {
        DAT_000038e6 = DAT_0000107e;
      }
      if ((-1 < (char)DAT_00003ee6) && ((DAT_00003ee6 & 0x40) != 0)) {
        DAT_000038e2 = DAT_0000107e;
      }
      if (((DAT_0000103a & 4) == 0) && (DAT_000038fc != '\0')) {
        DAT_000038fc = 0;
        DAT_000038de = DAT_0000107e;
        bVar3 = 0;
        pcVar4 = &DAT_0000753e;
        while( true ) {
          uVar1 = (short)*pcVar4 + (short)(char)(&DAT_0000753e)[(short)(bVar3 + 1)];
          if (SCARRY2((short)*pcVar4,(short)(char)(&DAT_0000753e)[(short)(bVar3 + 1)]) !=
              (int)((uint)uVar1 << 0x10) < 0) {
            uVar1 = uVar1 + 1;
          }
          if (((short)(char)DAT_0000102e <= (short)uVar1 >> 1) || (bVar3 == 0xe)) break;
          bVar3 = bVar3 + 1;
          pcVar4 = pcVar4 + 1;
        }
        RAM_Knock_status = RAM_Mis_kyltemp_tab_[bVar3];
      }
      else if (((DAT_0000103a & 4) == 0) || (DAT_0000101c != 0)) {
        DAT_000038fc = 0;
        bVar3 = 0;
        pcVar4 = &DAT_0000753e;
        while( true ) {
          uVar1 = (short)*pcVar4 + (short)(char)(&DAT_0000753e)[(short)(bVar3 + 1)];
          if (SCARRY2((short)*pcVar4,(short)(char)(&DAT_0000753e)[(short)(bVar3 + 1)]) !=
              (int)((uint)uVar1 << 0x10) < 0) {
            uVar1 = uVar1 + 1;
          }
          if (((short)(char)DAT_0000102e <= (short)uVar1 >> 1) || (bVar3 == 0xe)) break;
          bVar3 = bVar3 + 1;
          pcVar4 = pcVar4 + 1;
        }
        RAM_Knock_status = RAM_Mis_kyltemp_tab_[bVar3];
      }
      else {
        bVar3 = 0;
        local_8 = &DAT_0000753e;
        while( true ) {
          uVar1 = (short)*local_8 + (short)(char)(&DAT_0000753e)[(short)(bVar3 + 1)];
          if (SCARRY2((short)*local_8,(short)(char)(&DAT_0000753e)[(short)(bVar3 + 1)]) !=
              (int)((uint)uVar1 << 0x10) < 0) {
            uVar1 = uVar1 + 1;
          }
          if (((short)(char)DAT_0000102e <= (short)uVar1 >> 1) || (bVar3 == 0xe)) break;
          bVar3 = bVar3 + 1;
          local_8 = local_8 + 1;
        }
        RAM_Knock_status = RAM_Mis_kyltemp_tab_[bVar3];
        DAT_000038fc = 1;
      }
      if (((ushort)((ushort)DAT_00004656 + (ushort)DAT_0000753a) < (ushort)DAT_00001013) ||
         ((short)(ushort)DAT_00001013 < (short)((ushort)DAT_00004656 - (ushort)DAT_0000753c))) {
        DAT_000038da = DAT_0000107e;
        bVar3 = 0;
        local_c = &DAT_0000753e;
        while( true ) {
          sVar2 = (short)*local_c + (short)(char)(&DAT_0000753e)[(short)(bVar3 + 1)];
          if (sVar2 < 0) {
            sVar2 = sVar2 + 1;
          }
          if (((short)(char)DAT_0000102e <= sVar2 >> 1) || (bVar3 == 0xe)) break;
          bVar3 = bVar3 + 1;
          local_c = local_c + 1;
        }
        DAT_0000111b = RAM_Misftakeoff_ign_tab_[bVar3];
      }
      else {
        bVar3 = 0;
        local_10 = &DAT_0000753e;
        while( true ) {
          uVar1 = (short)*local_10 + (short)(char)(&DAT_0000753e)[(short)(bVar3 + 1)];
          if (SCARRY2((short)*local_10,(short)(char)(&DAT_0000753e)[(short)(bVar3 + 1)]) !=
              (int)((uint)uVar1 << 0x10) < 0) {
            uVar1 = uVar1 + 1;
          }
          if (((short)(char)DAT_0000102e <= (short)uVar1 >> 1) || (bVar3 == 0xe)) break;
          bVar3 = bVar3 + 1;
          local_10 = local_10 + 1;
        }
        DAT_0000111b = RAM_Misftakeoff_ign_tab_[bVar3];
      }
      DAT_00004656 = DAT_00001013;
      if (((RAM_Ramp_steg_[3] & 2) != 0) && (RAM_Misfgear_counter != (DAT_00001137 & 0x80))) {
        DAT_000038c6 = DAT_0000107e;
        RAM_Misfgear_counter = DAT_00001137 & 0x80;
      }
      if ((((RAM_Multispark == 0) || (DAT_0000107e <= DAT_000038f2 + DAT_0000752e)) ||
          (DAT_0000107e <= DAT_000038ee + RAM_Misfcut_ign_lim_)) ||
         ((((DAT_0000107e <= DAT_000038ea + DAT_00007532 ||
            (DAT_0000107e <= DAT_000038e6 + DAT_00007532)) ||
           ((DAT_0000107e <= DAT_000038e2 + DAT_00007536 ||
            ((DAT_0000107e <= DAT_000038da + DAT_0000111b ||
             (DAT_0000107e <= DAT_000038de + RAM_Knock_status)))))) ||
          (DAT_0000107e <= DAT_000038c6 + RAM_Misfpur_ign_lim_)))) {
        if (DAT_0000107e < DAT_000038f2 + DAT_0000752e) {
          RAM_Sond_ign_counter = (byte  [4])((DAT_000038f2 + DAT_0000752e) - DAT_0000107e);
        }
        else {
          RAM_Sond_ign_counter[0] = 0;
          RAM_Sond_ign_counter[1] = 0;
          RAM_Sond_ign_counter[2] = 0;
          RAM_Sond_ign_counter[3] = 0;
        }
        if (DAT_0000107e < DAT_000038ee + RAM_Misfcut_ign_lim_) {
          RAM_Misfcut_ign_filt = (byte  [4])((DAT_000038ee + RAM_Misfcut_ign_lim_) - DAT_0000107e);
        }
        else {
          RAM_Misfcut_ign_filt[0] = 0;
          RAM_Misfcut_ign_filt[1] = 0;
          RAM_Misfcut_ign_filt[2] = 0;
          RAM_Misfcut_ign_filt[3] = 0;
        }
        if (DAT_0000107e < DAT_000038ea + DAT_00007532) {
          _DAT_00001096 = (DAT_000038ea + DAT_00007532) - DAT_0000107e;
        }
        else {
          _DAT_00001096 = 0;
        }
        if (DAT_0000107e < DAT_000038e6 + RAM_Misfrpm_ign_lim_) {
          RAM_Misfrpm_ign_filt = (byte  [4])((DAT_000038e6 + RAM_Misfrpm_ign_lim_) - DAT_0000107e);
        }
        else {
          RAM_Misfrpm_ign_filt[0] = 0;
          RAM_Misfrpm_ign_filt[1] = 0;
          RAM_Misfrpm_ign_filt[2] = 0;
          RAM_Misfrpm_ign_filt[3] = 0;
        }
        if (DAT_0000107e < DAT_000038e2 + DAT_00007536) {
          _DAT_0000109e = (DAT_000038e2 + DAT_00007536) - DAT_0000107e;
        }
        else {
          _DAT_0000109e = 0;
        }
        if (DAT_0000107e < DAT_000038de + RAM_Knock_status) {
          RAM_Misfpur_ign_filt = (byte  [4])((DAT_000038de + RAM_Knock_status) - DAT_0000107e);
        }
        else {
          RAM_Misfpur_ign_filt[0] = 0;
          RAM_Misfpur_ign_filt[1] = 0;
          RAM_Misfpur_ign_filt[2] = 0;
          RAM_Misfpur_ign_filt[3] = 0;
        }
        if (DAT_0000107e < DAT_000038da + DAT_0000111b) {
          RAM_Misftakeoff_ign_filt = (byte  [4])((DAT_000038da + DAT_0000111b) - DAT_0000107e);
        }
        else {
          RAM_Misftakeoff_ign_filt[0] = 0;
          RAM_Misftakeoff_ign_filt[1] = 0;
          RAM_Misftakeoff_ign_filt[2] = 0;
          RAM_Misftakeoff_ign_filt[3] = 0;
        }
        if (DAT_0000107e < DAT_000038c6 + RAM_Misfpur_ign_lim_) {
          RAM_Misftrans_ign_filt = (byte  [4])((DAT_000038c6 + RAM_Misfpur_ign_lim_) - DAT_0000107e)
          ;
        }
        else {
          RAM_Misftrans_ign_filt[0] = 0;
          RAM_Misftrans_ign_filt[1] = 0;
          RAM_Misftrans_ign_filt[2] = 0;
          RAM_Misftrans_ign_filt[3] = 0;
        }
      }
      else {
        if (param_2._0_2_ == 0xb4) {
          if ((param_1._2_2_ < RAM_Multispark) && ((DAT_0000103a & 0x20) == 0)) {
            DAT_000038ce = DAT_0000107e;
            if (((DAT_0000103a & 4) == 0) &&
               ((DAT_000074bc <= DAT_0000107e ||
                ((char)RAM_Misf_rpm_diff_start_ <= (char)DAT_0000102e)))) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_2 = RAM_Mis200_2 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_2) {
                RAM_Mis200_2 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e0 = DAT_000010e0 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e0) {
                DAT_000010e0 = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (RAM_MisCountMap2[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] !=
                  0xff) {
                RAM_MisCountMap2[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MisCountMap2[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] +
                     1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038ce = 0;
            }
          }
          else {
            DAT_000010e6 = DAT_000010e6 + 1;
            if (2000 < DAT_000010e6) {
              DAT_000010e6 = 1;
              DAT_000010e4 = 0;
              RAM_C200_max = 0;
              DAT_000010de = 0;
              DAT_000010e0 = 0;
              DAT_000010e2 = 0;
            }
            RAM_Mis200_max = RAM_Mis200_max + 1;
            if (400 < RAM_Mis200_max) {
              RAM_Mis200_max = 1;
              RAM_Mis200_4 = 0;
              DAT_000010d0 = 0;
              RAM_Mis200_1 = 0;
              RAM_Mis200_2 = 0;
              RAM_Mis200_3 = 0;
            }
            RAM_Sond_ign_counter[0] = 0;
            RAM_Sond_ign_counter[1] = 0;
            RAM_Sond_ign_counter[2] = 0;
            RAM_Sond_ign_counter[3] = 0;
            RAM_Misfcut_ign_filt[0] = 0;
            RAM_Misfcut_ign_filt[1] = 0;
            RAM_Misfcut_ign_filt[2] = 0;
            RAM_Misfcut_ign_filt[3] = 0;
            _DAT_00001096 = 0;
            RAM_Misfrpm_ign_filt[0] = 0;
            RAM_Misfrpm_ign_filt[1] = 0;
            RAM_Misfrpm_ign_filt[2] = 0;
            RAM_Misfrpm_ign_filt[3] = 0;
            _DAT_0000109e = 0;
            RAM_Misfpur_ign_filt[0] = 0;
            RAM_Misfpur_ign_filt[1] = 0;
            RAM_Misfpur_ign_filt[2] = 0;
            RAM_Misfpur_ign_filt[3] = 0;
            RAM_Misftakeoff_ign_filt[0] = 0;
            RAM_Misftakeoff_ign_filt[1] = 0;
            RAM_Misftakeoff_ign_filt[2] = 0;
            RAM_Misftakeoff_ign_filt[3] = 0;
            DAT_000038ce = 0;
          }
        }
        else if (param_2._0_2_ == 0x168) {
          if ((param_1._2_2_ < RAM_Multispark) && ((DAT_0000103a & 0x10) == 0)) {
            DAT_000038ca = DAT_0000107e;
            if (((DAT_0000103a & 4) == 0) &&
               ((DAT_000074bc <= DAT_0000107e ||
                ((char)RAM_Misf_rpm_diff_start_ <= (char)DAT_0000102e)))) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_3 = RAM_Mis200_3 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_3) {
                RAM_Mis200_3 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e2 = DAT_000010e2 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e2) {
                DAT_000010e2 = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (RAM_MisCountMap3[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] !=
                  0xff) {
                RAM_MisCountMap3[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MisCountMap3[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] +
                     1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038ca = 0;
            }
          }
          else {
            DAT_000010e6 = DAT_000010e6 + 1;
            if (2000 < DAT_000010e6) {
              DAT_000010e6 = 1;
              DAT_000010e4 = 0;
              RAM_C200_max = 0;
              DAT_000010de = 0;
              DAT_000010e0 = 0;
              DAT_000010e2 = 0;
            }
            RAM_Mis200_max = RAM_Mis200_max + 1;
            if (400 < RAM_Mis200_max) {
              RAM_Mis200_max = 1;
              RAM_Mis200_4 = 0;
              DAT_000010d0 = 0;
              RAM_Mis200_1 = 0;
              RAM_Mis200_2 = 0;
              RAM_Mis200_3 = 0;
            }
            RAM_Sond_ign_counter[0] = 0;
            RAM_Sond_ign_counter[1] = 0;
            RAM_Sond_ign_counter[2] = 0;
            RAM_Sond_ign_counter[3] = 0;
            RAM_Misfcut_ign_filt[0] = 0;
            RAM_Misfcut_ign_filt[1] = 0;
            RAM_Misfcut_ign_filt[2] = 0;
            RAM_Misfcut_ign_filt[3] = 0;
            _DAT_00001096 = 0;
            RAM_Misfrpm_ign_filt[0] = 0;
            RAM_Misfrpm_ign_filt[1] = 0;
            RAM_Misfrpm_ign_filt[2] = 0;
            RAM_Misfrpm_ign_filt[3] = 0;
            _DAT_0000109e = 0;
            RAM_Misfpur_ign_filt[0] = 0;
            RAM_Misfpur_ign_filt[1] = 0;
            RAM_Misfpur_ign_filt[2] = 0;
            RAM_Misfpur_ign_filt[3] = 0;
            RAM_Misftakeoff_ign_filt[0] = 0;
            RAM_Misftakeoff_ign_filt[1] = 0;
            RAM_Misftakeoff_ign_filt[2] = 0;
            RAM_Misftakeoff_ign_filt[3] = 0;
            DAT_000038ca = 0;
          }
        }
        else if (param_2._0_2_ == 0x21c) {
          if ((param_1._0_2_ < RAM_Multispark) && ((DAT_0000103a & 0x40) == 0)) {
            DAT_000038d2 = DAT_0000107e;
            if (((DAT_0000103a & 4) == 0) &&
               ((DAT_000074bc <= DAT_0000107e ||
                ((char)RAM_Misf_rpm_diff_start_ <= (char)DAT_0000102e)))) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_1 = RAM_Mis200_1 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_1) {
                RAM_Mis200_1 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010de = DAT_000010de + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010de) {
                DAT_000010de = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (RAM_MisCountMap1[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] !=
                  0xff) {
                RAM_MisCountMap1[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MisCountMap1[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] +
                     1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038d2 = 0;
            }
          }
          else {
            DAT_000010e6 = DAT_000010e6 + 1;
            if (2000 < DAT_000010e6) {
              DAT_000010e6 = 1;
              DAT_000010e4 = 0;
              RAM_C200_max = 0;
              DAT_000010de = 0;
              DAT_000010e0 = 0;
              DAT_000010e2 = 0;
            }
            RAM_Mis200_max = RAM_Mis200_max + 1;
            if (400 < RAM_Mis200_max) {
              RAM_Mis200_max = 1;
              RAM_Mis200_4 = 0;
              DAT_000010d0 = 0;
              RAM_Mis200_1 = 0;
              RAM_Mis200_2 = 0;
              RAM_Mis200_3 = 0;
            }
            RAM_Sond_ign_counter[0] = 0;
            RAM_Sond_ign_counter[1] = 0;
            RAM_Sond_ign_counter[2] = 0;
            RAM_Sond_ign_counter[3] = 0;
            RAM_Misfcut_ign_filt[0] = 0;
            RAM_Misfcut_ign_filt[1] = 0;
            RAM_Misfcut_ign_filt[2] = 0;
            RAM_Misfcut_ign_filt[3] = 0;
            _DAT_00001096 = 0;
            RAM_Misfrpm_ign_filt[0] = 0;
            RAM_Misfrpm_ign_filt[1] = 0;
            RAM_Misfrpm_ign_filt[2] = 0;
            RAM_Misfrpm_ign_filt[3] = 0;
            _DAT_0000109e = 0;
            RAM_Misfpur_ign_filt[0] = 0;
            RAM_Misfpur_ign_filt[1] = 0;
            RAM_Misfpur_ign_filt[2] = 0;
            RAM_Misfpur_ign_filt[3] = 0;
            RAM_Misftakeoff_ign_filt[0] = 0;
            RAM_Misftakeoff_ign_filt[1] = 0;
            RAM_Misftakeoff_ign_filt[2] = 0;
            RAM_Misftakeoff_ign_filt[3] = 0;
            DAT_000038d2 = 0;
          }
        }
        else if ((param_1._0_2_ < RAM_Multispark) && ((DAT_0000103a & 0x80) == 0)) {
          DAT_000038d6 = DAT_0000107e;
          if (((DAT_0000103a & 4) == 0) &&
             ((DAT_000074bc <= DAT_0000107e ||
              ((char)RAM_Misf_rpm_diff_start_ <= (char)DAT_0000102e)))) {
            DAT_000010e6 = DAT_000010e6 + 1;
            if (2000 < DAT_000010e6) {
              DAT_000010e6 = 1;
              DAT_000010e4 = 0;
              RAM_C200_max = 0;
              DAT_000010de = 0;
              DAT_000010e0 = 0;
              DAT_000010e2 = 0;
            }
            RAM_Mis200_max = RAM_Mis200_max + 1;
            if (400 < RAM_Mis200_max) {
              RAM_Mis200_max = 1;
              RAM_Mis200_4 = 0;
              DAT_000010d0 = 0;
              RAM_Mis200_1 = 0;
              RAM_Mis200_2 = 0;
              RAM_Mis200_3 = 0;
            }
            if (RAM_Detect_limit == 0) {
              RAM_Detect_limit = 1;
            }
            DAT_000010d0 = DAT_000010d0 + (short)(400 / RAM_Detect_limit);
            if (800 < DAT_000010d0) {
              DAT_000010d0 = 800;
            }
            if (RAM_Mis200_limit == 0) {
              RAM_Mis200_limit = 1;
            }
            RAM_C200_max = RAM_C200_max + (short)(2000 / RAM_Mis200_limit);
            if (4000 < RAM_C200_max) {
              RAM_C200_max = 4000;
            }
            if (RAM_Detect_limit == 0) {
              RAM_Detect_limit = 1;
            }
            RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
            if (800 < RAM_Mis200_4) {
              RAM_Mis200_4 = 800;
            }
            if (RAM_Mis200_tot < RAM_Mis200_4) {
              RAM_Mis200_tot = RAM_Mis200_4;
              RAM_Mis200_count = DAT_00003b72;
              RAM_RPM200_max = DAT_00001013;
              RAM_P200_max = DAT_0000101c;
              RAM_V200_max = DAT_0000102e;
            }
            if (RAM_Mis200_limit == 0) {
              RAM_Mis200_limit = 1;
            }
            DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
            if (4000 < DAT_000010e4) {
              DAT_000010e4 = 4000;
            }
            if (DAT_00001ac0 < DAT_000010e4) {
              DAT_00001ac0 = DAT_000010e4;
              _DAT_00001ac2 = DAT_00003b72;
              DAT_00001d1d = DAT_00001013;
              DAT_00001d1e = DAT_0000101c;
              DAT_00001d1f = DAT_0000102e;
            }
            if (((DAT_00006e20 & 0x40) == 0) &&
               (RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] != 0xff)) {
              RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                   RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] + 1;
            }
            RAM_Sond_ign_counter[0] = 0;
            RAM_Sond_ign_counter[1] = 0;
            RAM_Sond_ign_counter[2] = 0;
            RAM_Sond_ign_counter[3] = 0;
            RAM_Misfcut_ign_filt[0] = 0;
            RAM_Misfcut_ign_filt[1] = 0;
            RAM_Misfcut_ign_filt[2] = 0;
            RAM_Misfcut_ign_filt[3] = 0;
            _DAT_00001096 = 0;
            RAM_Misfrpm_ign_filt[0] = 0;
            RAM_Misfrpm_ign_filt[1] = 0;
            RAM_Misfrpm_ign_filt[2] = 0;
            RAM_Misfrpm_ign_filt[3] = 0;
            _DAT_0000109e = 0;
            RAM_Misfpur_ign_filt[0] = 0;
            RAM_Misfpur_ign_filt[1] = 0;
            RAM_Misfpur_ign_filt[2] = 0;
            RAM_Misfpur_ign_filt[3] = 0;
            RAM_Misftakeoff_ign_filt[0] = 0;
            RAM_Misftakeoff_ign_filt[1] = 0;
            RAM_Misftakeoff_ign_filt[2] = 0;
            RAM_Misftakeoff_ign_filt[3] = 0;
            DAT_000038d6 = 0;
          }
        }
        else {
          DAT_000010e6 = DAT_000010e6 + 1;
          if (2000 < DAT_000010e6) {
            DAT_000010e6 = 1;
            DAT_000010e4 = 0;
            RAM_C200_max = 0;
            DAT_000010de = 0;
            DAT_000010e0 = 0;
            DAT_000010e2 = 0;
          }
          RAM_Mis200_max = RAM_Mis200_max + 1;
          if (400 < RAM_Mis200_max) {
            RAM_Mis200_max = 1;
            RAM_Mis200_4 = 0;
            DAT_000010d0 = 0;
            RAM_Mis200_1 = 0;
            RAM_Mis200_2 = 0;
            RAM_Mis200_3 = 0;
          }
          RAM_Sond_ign_counter[0] = 0;
          RAM_Sond_ign_counter[1] = 0;
          RAM_Sond_ign_counter[2] = 0;
          RAM_Sond_ign_counter[3] = 0;
          RAM_Misfcut_ign_filt[0] = 0;
          RAM_Misfcut_ign_filt[1] = 0;
          RAM_Misfcut_ign_filt[2] = 0;
          RAM_Misfcut_ign_filt[3] = 0;
          _DAT_00001096 = 0;
          RAM_Misfrpm_ign_filt[0] = 0;
          RAM_Misfrpm_ign_filt[1] = 0;
          RAM_Misfrpm_ign_filt[2] = 0;
          RAM_Misfrpm_ign_filt[3] = 0;
          _DAT_0000109e = 0;
          RAM_Misfpur_ign_filt[0] = 0;
          RAM_Misfpur_ign_filt[1] = 0;
          RAM_Misfpur_ign_filt[2] = 0;
          RAM_Misfpur_ign_filt[3] = 0;
          RAM_Misftakeoff_ign_filt[0] = 0;
          RAM_Misftakeoff_ign_filt[1] = 0;
          RAM_Misftakeoff_ign_filt[2] = 0;
          RAM_Misftakeoff_ign_filt[3] = 0;
          DAT_000038d6 = 0;
        }
        if (((DAT_0000103a & 4) != 0) ||
           ((DAT_0000107e < DAT_000074bc && ((char)DAT_0000102e < (char)RAM_Misf_rpm_diff_start_))))
        {
          if (DAT_0000107e - DAT_000038ce < 4) {
            if ((((char)DAT_0000102e < (char)RAM_Misf_rpm_diff_start_) &&
                (DAT_0000107e < DAT_000074bc)) && (DAT_00003904 < (short)RAM_Misf_rpm_diff_)) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_2 = RAM_Mis200_2 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_2) {
                RAM_Mis200_2 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e0 = DAT_000010e0 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e0) {
                DAT_000010e0 = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (RAM_MisCountMap2[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] !=
                  0xff) {
                RAM_MisCountMap2[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MisCountMap2[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] +
                     1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038ce = 0;
            }
            else if (((DAT_0000103a & 4) != 0) && (DAT_00003904 < (short)RAM_Cl_timer2_lim_)) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_2 = RAM_Mis200_2 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_2) {
                RAM_Mis200_2 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e0 = DAT_000010e0 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e0) {
                DAT_000010e0 = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (RAM_MisCountMap2[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] !=
                  0xff) {
                RAM_MisCountMap2[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MisCountMap2[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] +
                     1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038ce = 0;
            }
          }
          else if (DAT_0000107e - DAT_000038ca < 4) {
            if ((((char)DAT_0000102e < (char)RAM_Misf_rpm_diff_start_) &&
                (DAT_0000107e < DAT_000074bc)) && (DAT_00003904 < (short)RAM_Misf_rpm_diff_)) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_3 = RAM_Mis200_3 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_3) {
                RAM_Mis200_3 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e2 = DAT_000010e2 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e2) {
                DAT_000010e2 = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (RAM_MisCountMap3[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] !=
                  0xff) {
                RAM_MisCountMap3[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MisCountMap3[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] +
                     1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038ca = 0;
            }
            else if (((DAT_0000103a & 4) != 0) && (DAT_00003904 < (short)RAM_Cl_timer2_lim_)) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_3 = RAM_Mis200_3 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_3) {
                RAM_Mis200_3 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e2 = DAT_000010e2 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e2) {
                DAT_000010e2 = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (RAM_MisCountMap3[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] !=
                  0xff) {
                RAM_MisCountMap3[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MisCountMap3[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] +
                     1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038ca = 0;
            }
          }
          else if (DAT_0000107e - DAT_000038d2 < 4) {
            if ((((char)DAT_0000102e < (char)RAM_Misf_rpm_diff_start_) &&
                (DAT_0000107e < DAT_000074bc)) && (DAT_00003904 < (short)RAM_Misf_rpm_diff_)) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_1 = RAM_Mis200_1 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_1) {
                RAM_Mis200_1 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010de = DAT_000010de + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010de) {
                DAT_000010de = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (RAM_MisCountMap1[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] !=
                  0xff) {
                RAM_MisCountMap1[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MisCountMap1[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] +
                     1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038d2 = 0;
            }
            else if (((DAT_0000103a & 4) != 0) && (DAT_00003904 < (short)RAM_Cl_timer2_lim_)) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_1 = RAM_Mis200_1 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_1) {
                RAM_Mis200_1 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010de = DAT_000010de + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010de) {
                DAT_000010de = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (RAM_MisCountMap1[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] !=
                  0xff) {
                RAM_MisCountMap1[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MisCountMap1[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] +
                     1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038d2 = 0;
            }
          }
          else if (DAT_0000107e - DAT_000038d6 < 4) {
            if ((((char)DAT_0000102e < (char)RAM_Misf_rpm_diff_start_) &&
                (DAT_0000107e < DAT_000074bc)) && (DAT_00003904 < (short)RAM_Misf_rpm_diff_)) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              DAT_000010d0 = DAT_000010d0 + (short)(400 / RAM_Detect_limit);
              if (800 < DAT_000010d0) {
                DAT_000010d0 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              RAM_C200_max = RAM_C200_max + (short)(2000 / RAM_Mis200_limit);
              if (4000 < RAM_C200_max) {
                RAM_C200_max = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (((DAT_00006e20 & 0x40) == 0) &&
                 (RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] != 0xff))
              {
                RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] + 1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038d6 = 0;
            }
            else if (((DAT_0000103a & 4) != 0) && (DAT_00003904 < (short)RAM_Cl_timer2_lim_)) {
              DAT_000010e6 = DAT_000010e6 + 1;
              if (2000 < DAT_000010e6) {
                DAT_000010e6 = 1;
                DAT_000010e4 = 0;
                RAM_C200_max = 0;
                DAT_000010de = 0;
                DAT_000010e0 = 0;
                DAT_000010e2 = 0;
              }
              RAM_Mis200_max = RAM_Mis200_max + 1;
              if (400 < RAM_Mis200_max) {
                RAM_Mis200_max = 1;
                RAM_Mis200_4 = 0;
                DAT_000010d0 = 0;
                RAM_Mis200_1 = 0;
                RAM_Mis200_2 = 0;
                RAM_Mis200_3 = 0;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              DAT_000010d0 = DAT_000010d0 + (short)(400 / RAM_Detect_limit);
              if (800 < DAT_000010d0) {
                DAT_000010d0 = 800;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              RAM_C200_max = RAM_C200_max + (short)(2000 / RAM_Mis200_limit);
              if (4000 < RAM_C200_max) {
                RAM_C200_max = 4000;
              }
              if (RAM_Detect_limit == 0) {
                RAM_Detect_limit = 1;
              }
              RAM_Mis200_4 = RAM_Mis200_4 + (short)(400 / RAM_Detect_limit);
              if (800 < RAM_Mis200_4) {
                RAM_Mis200_4 = 800;
              }
              if (RAM_Mis200_tot < RAM_Mis200_4) {
                RAM_Mis200_tot = RAM_Mis200_4;
                RAM_Mis200_count = DAT_00003b72;
                RAM_RPM200_max = DAT_00001013;
                RAM_P200_max = DAT_0000101c;
                RAM_V200_max = DAT_0000102e;
              }
              if (RAM_Mis200_limit == 0) {
                RAM_Mis200_limit = 1;
              }
              DAT_000010e4 = DAT_000010e4 + (short)(2000 / RAM_Mis200_limit);
              if (4000 < DAT_000010e4) {
                DAT_000010e4 = 4000;
              }
              if (DAT_00001ac0 < DAT_000010e4) {
                DAT_00001ac0 = DAT_000010e4;
                _DAT_00001ac2 = DAT_00003b72;
                DAT_00001d1d = DAT_00001013;
                DAT_00001d1e = DAT_0000101c;
                DAT_00001d1f = DAT_0000102e;
              }
              if (((DAT_00006e20 & 0x40) == 0) &&
                 (RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] != 0xff))
              {
                RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] =
                     RAM_MError[(short)((ushort)DAT_00003908 * 0x12 + (ushort)DAT_0000390a)] + 1;
              }
              RAM_Sond_ign_counter[0] = 0;
              RAM_Sond_ign_counter[1] = 0;
              RAM_Sond_ign_counter[2] = 0;
              RAM_Sond_ign_counter[3] = 0;
              RAM_Misfcut_ign_filt[0] = 0;
              RAM_Misfcut_ign_filt[1] = 0;
              RAM_Misfcut_ign_filt[2] = 0;
              RAM_Misfcut_ign_filt[3] = 0;
              _DAT_00001096 = 0;
              RAM_Misfrpm_ign_filt[0] = 0;
              RAM_Misfrpm_ign_filt[1] = 0;
              RAM_Misfrpm_ign_filt[2] = 0;
              RAM_Misfrpm_ign_filt[3] = 0;
              _DAT_0000109e = 0;
              RAM_Misfpur_ign_filt[0] = 0;
              RAM_Misfpur_ign_filt[1] = 0;
              RAM_Misfpur_ign_filt[2] = 0;
              RAM_Misfpur_ign_filt[3] = 0;
              RAM_Misftakeoff_ign_filt[0] = 0;
              RAM_Misftakeoff_ign_filt[1] = 0;
              RAM_Misftakeoff_ign_filt[2] = 0;
              RAM_Misftakeoff_ign_filt[3] = 0;
              DAT_000038d6 = 0;
            }
          }
        }
      }
    }
  }
  else {
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
    RAM_Mis200_max = 0;
    DAT_000010e6 = 0;
    DAT_000038c6 = 0;
    RAM_Sond_ign_counter[0] = 0;
    RAM_Sond_ign_counter[1] = 0;
    RAM_Sond_ign_counter[2] = 0;
    RAM_Sond_ign_counter[3] = 0;
    RAM_Misfcut_ign_filt[0] = 0;
    RAM_Misfcut_ign_filt[1] = 0;
    RAM_Misfcut_ign_filt[2] = 0;
    RAM_Misfcut_ign_filt[3] = 0;
    _DAT_00001096 = 0;
    RAM_Misfrpm_ign_filt[0] = 0;
    RAM_Misfrpm_ign_filt[1] = 0;
    RAM_Misfrpm_ign_filt[2] = 0;
    RAM_Misfrpm_ign_filt[3] = 0;
    _DAT_0000109e = 0;
    RAM_Misfpur_ign_filt[0] = 0;
    RAM_Misfpur_ign_filt[1] = 0;
    RAM_Misfpur_ign_filt[2] = 0;
    RAM_Misfpur_ign_filt[3] = 0;
    RAM_Misftakeoff_ign_filt[0] = 0;
    RAM_Misftakeoff_ign_filt[1] = 0;
    RAM_Misftakeoff_ign_filt[2] = 0;
    RAM_Misftakeoff_ign_filt[3] = 0;
    DAT_00004656 = DAT_00001013;
    DAT_000038da = 0;
    DAT_000038f2 = 0;
    DAT_000038ee = 0;
    DAT_000038ea = 0;
    DAT_000038de = 0;
    DAT_000038fc = 0;
    DAT_000038e6 = 0;
    DAT_000038e2 = 0;
    DAT_000038fe = DAT_00001a58;
  }
  return;
}

```
