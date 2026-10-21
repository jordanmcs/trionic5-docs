# Function_0004D1E0

**ROM:** `0x0004D1E0`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0004D1E0(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  byte *extraout_A1_00;
  undefined4 extraout_A1_01;
  char *extraout_A1_02;
  char *extraout_A1_03;
  undefined1 *puVar4;
  undefined1 *extraout_A1_04;
  byte *pbVar5;
  
  if ((DAT_0000376c == '\0') || ((DAT_00001039 & 1) == 0)) {
    DAT_000034b4 = DAT_00001077;
    DAT_0000376c = '\0';
  }
  else {
    DAT_000034b4 = RAM_PMCal_MaxNrTest_;
  }
  if (((DAT_00001039 & 8) == 0) || ((DAT_00001039 & 1) == 0)) {
    DAT_0000376e = 0;
  }
  else {
    if (DAT_0000376e == 0) {
      DAT_0000376e = 1;
    }
    if (DAT_0000376e == 1) {
      if ((RAM_Samp_pek[0xe] & 8) == 0) {
        if ((RAM_Samp_pek[0x10] & 0x10) == 0) {
          if ((char)RAM_PMCal_MaxNrTest_ < (char)DAT_000034b4) {
            DAT_0000376e = 3;
          }
          else if ((ushort)(RAM_PMCal_LambdaLim_ + 1) <= (ushort)DAT_0000377c) {
            DAT_0000376e = 4;
          }
        }
        else {
          DAT_0000376e = 2;
          DAT_000034b8 = 0;
          DAT_000034bc = DAT_00003b02;
          Function_000467F8();
          RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0x7f;
        }
      }
      else {
        DAT_0000376e = 4;
      }
    }
    if (DAT_0000376e == 2) {
      if ((DAT_000034b8 < DAT_00007504) && ((DAT_000038c5 & 0x40) == 0)) {
        if (DAT_000034bc + 0xfa <= DAT_00003b02) {
          if ((RAM_Samp_pek[0xd] & 0x80) == 0) {
            Function_000467F8();
            *extraout_A1 = *extraout_A1 | 0x80;
          }
          else {
            Function_000467F8();
            *extraout_A1_00 = *extraout_A1_00 & 0x7f;
            DAT_000034b8 = DAT_000034b8 + 1;
          }
          DAT_000034bc = DAT_00003b02;
        }
      }
      else {
        DAT_0000376e = 3;
      }
    }
    if (DAT_0000376e == 3) {
      RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] & 0xf7;
      if ((DAT_000038c5 & 0x40) == 0) {
        Function_000467F8();
        RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0x7f;
      }
      RAM_Ramp_steg_[2] = RAM_Ramp_steg_[2] | 0x20;
      RAM_P_tank_new = 0;
      DAT_00003ed2 = 0;
      DAT_00003ece = 0;
      DAT_00003eca = 0;
      DAT_00003ec6 = 0;
      DAT_0000377e = '\0';
      RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] & 0xcf;
      RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0x81;
      RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] & 0x7b;
      DAT_0000376e = 4;
    }
  }
  if (((RAM_Samp_pek[0xd] & 4) == 0) || (DAT_0000376e < 4)) {
    if (DAT_0000101c == '\0') {
      sVar1 = Function_00044BA4();
      if ((sVar1 == 1) && (*extraout_A1_02 == '\x01')) {
        *extraout_A1_02 = '\0';
        if (DAT_00003780 != 0xff) {
          DAT_00003780 = DAT_00003780 + 1;
        }
      }
      else {
        sVar1 = Function_00044BA4();
        if ((sVar1 == 0) &&
           ((*extraout_A1_03 == '\0' && (*extraout_A1_03 = '\x01', DAT_00003780 != 0xff)))) {
          DAT_00003780 = DAT_00003780 + 1;
        }
      }
      if (DAT_000074fa < DAT_00003780) {
        DAT_00003ed6 = DAT_00001a58;
      }
    }
    else {
      DAT_00003ed6 = DAT_00001a58;
      sVar1 = Function_00044BA4();
      *(bool *)extraout_A1_01 = sVar1 != 1;
      DAT_00003780 = 0;
      DAT_0000377a = '\0';
    }
    if (((DAT_00003ed6 + 5 < DAT_00001a58) && ((RAM_Samp_pek[4] & 2) != 0)) &&
       (DAT_00001a58 <= DAT_00003774 + 5)) {
      if (((short)(RAM_Tank_time_perf._0_1_ + 5) < (short)DAT_00003edc) &&
         ((RAM_Samp_pek[0xe] & 0x80) == 0)) {
        DAT_00003786 = DAT_00003786 + 1;
        RAM_Tank_time_perf._0_1_ = DAT_00003edc;
        RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] & 0xbf | 0x80;
      }
      else if (((short)DAT_00003edc < (short)(RAM_Tank_time_perf._0_1_ + -5)) &&
              ((RAM_Samp_pek[0xe] & 0x40) == 0)) {
        DAT_00003786 = DAT_00003786 + 1;
        RAM_Tank_time_perf._0_1_ = DAT_00003edc;
        RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] & 0x7f | 0x40;
      }
    }
    else {
      DAT_00003786 = 0;
      DAT_00003774 = DAT_00001a58;
    }
    if ((0x31 < DAT_00003786) && (DAT_00001a58 <= DAT_00003774 + 5)) {
      RAM_Samp_pek[0xf] = RAM_Samp_pek[0xf] | 0x20;
    }
    if ((DAT_00001a58 < DAT_00003ed6 + 5) || ((DAT_00003b5e < 0xfd && (5 < DAT_00003b5e)))) {
      DAT_00003eae = DAT_00001a58;
    }
    if (0x28 < RAM_Cyl_nr) {
      RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] | 8;
    }
    if ((((char)RAM_Tank_start_time_ <= DAT_00003edc) || (DAT_00001a58 < DAT_00003ed6 + 5)) ||
       ((DAT_00001137 & 0x20) == 0)) {
      _DAT_00003770 = DAT_00001a58;
    }
    puVar4 = &DAT_0000377e;
    if ((((((DAT_0000377a == '\0') && ((ushort)DAT_0000377c < (ushort)(RAM_PMCal_LambdaLim_ + 1)))
          && (((char)RAM_P_tank <= (char)RAM_P_tank_diff_min_ &&
              (((char)RAM_Tank_start_time_ <= (char)RAM_P_tank && (DAT_0000101c == '\0')))))) &&
         (-1 < (char)RAM_OBD2_frame[6])) &&
        (((DAT_00001137 & 0x20) != 0 && (-1 < (char)RAM_OBD2_frame[0])))) &&
       ((((RAM_Samp_pek[8] & 0x40) != 0 || (DAT_0000376e == 1)) &&
        (((((RAM_Samp_pek[0x10] & 8) != 0 || (DAT_0000376e == 1)) &&
          (DAT_00003ed6 + 5 < DAT_00001a58)) &&
         (((DAT_000038c5 & 0x40) == 0 && (RAM_PMCal_PurgeAdaptLim_ < RAM_Purge_duty)))))))) {
      if ((DAT_0000377e == '\0') && (DAT_0000377c < 0xfe)) {
        DAT_0000377c = DAT_0000377c + 1;
      }
      DAT_0000377e = '\x01';
      if (((((DAT_0000103c & 0x20) == 0) || ((RAM_Purge_freq & 2) != 0)) ||
          ((RAM_Samp_pek[0xd] & 0x80) != 0)) || (RAM_Purge_duty <= DAT_000074f6)) {
        if (((short)((short)(char)RAM_P_tank_new + (short)(char)RAM_P_tank_diff_max_) <
             (short)(char)RAM_P_tank) || ((RAM_Samp_pek[0xd] & 0x40) == 0)) {
          if (((RAM_Samp_pek[0xd] & 0x20) == 0) ||
             ((short)((short)(char)RAM_P_tank_new + (short)(char)RAM_P2_tank_) !=
              (short)(char)RAM_P_tank)) {
            if ((RAM_Cyl_nr == 0) && ((RAM_Samp_pek[0xd] & 0x10) != 0)) {
              if (((short)((short)(char)RAM_P_tank_new + (short)(char)RAM_P2_tank_) <=
                   (short)(char)RAM_P_tank) || (DAT_00007522 + DAT_00003ece < DAT_00001a58)) {
                DAT_00003ec6 = DAT_00001a58;
                DAT_00003eba = DAT_00001a58 - DAT_00003ece;
                if ((DAT_000075ba < DAT_00003eba) &&
                   ((uint)DAT_000075bc <= DAT_00001a58 - DAT_00003ed2)) {
                  RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0xef | 8;
                  DAT_00003eb2 = DAT_00003eba;
                }
                else {
                  DAT_00003ed6 = DAT_00001a58;
                }
              }
            }
            else if ((RAM_Samp_pek[0xd] & 8) != 0) {
              RAM_Ramp_steg_[2] = RAM_Ramp_steg_[2] | 0x20;
              if ((DAT_000038c5 & 0x40) == 0) {
                Function_000467F8();
                RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0x7f;
              }
              RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] | 4;
              RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] & 0x7f | 4;
            }
          }
          else {
            DAT_00003eca = DAT_00001a58;
            _DAT_00003ebe = DAT_00001a58 - DAT_00003ece;
            RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0xdf | 0x10;
          }
        }
        else {
          DAT_00003ece = DAT_00001a58;
          DAT_00003ec2 = DAT_00001a58 - DAT_00003ed2;
          if (RAM_Fsond_lamtime_ < DAT_00003ec2) {
            RAM_Ramp_steg_[2] = RAM_Ramp_steg_[2] & 0xdf;
            RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0xbf | 0x10;
            DAT_00003eb6 = DAT_00003ec2;
          }
          else {
            DAT_00003ed6 = DAT_00001a58;
          }
        }
      }
      else {
        Function_000467F8();
        RAM_P_tank_new = RAM_P_tank;
        DAT_00003ed2 = DAT_00001a58;
        DAT_00003ece = 0;
        DAT_00003eca = 0;
        DAT_00003ec6 = 0;
        RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] | 0xc2;
        RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] | 0x80;
      }
      if ((DAT_00001031 < DAT_00003778) &&
         (((RAM_Samp_pek[0xd] & 0x40) != 0 || ((RAM_Samp_pek[0xd] & 0x10) != 0)))) {
        DAT_00003778 = DAT_00001031;
      }
      if ((DAT_0000751e + DAT_00003ed2 < DAT_00001a58) && ((RAM_Samp_pek[0xd] & 0x40) != 0)) {
        RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] | 0x10;
        DAT_00003eb6 = DAT_00001a58 - DAT_00003ed2;
        RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] & 0x7f;
        DAT_00003ec2 = DAT_00003eb6;
      }
      if ((DAT_00003ec6 - DAT_00003ece < DAT_00007522) && ((RAM_Samp_pek[0xd] & 8) != 0)) {
        if (DAT_00003778 < RAM_PMCal_BrakeNumber_) {
          DAT_00003ed6 = DAT_00001a58;
        }
        else {
          RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] | 0x20;
          DAT_00003eb2 = DAT_00003eba;
          RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] & 0x7f;
        }
      }
    }
    else {
      if (((DAT_000038c5 & 0x40) == 0) && (DAT_0000376e != 2)) {
        Function_000467F8();
        RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0x7f;
        puVar4 = extraout_A1_04;
      }
      RAM_Ramp_steg_[2] = RAM_Ramp_steg_[2] | 0x20;
      RAM_P_tank_new = 0;
      DAT_00003ed2 = 0;
      DAT_00003ece = 0;
      DAT_00003eca = 0;
      DAT_00003ec6 = 0;
      RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0x85;
      RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] & 0x7f;
      *puVar4 = 0;
      if ((char)RAM_P_tank < (char)RAM_Tank_start_time_) {
        DAT_0000377a = '\x01';
      }
      DAT_00003778 = 0x80;
    }
    if ((((RAM_Samp_pek[0xf] & 0x20) == 0) && (DAT_00001a58 <= DAT_00003eae + 7)) &&
       (((RAM_Samp_pek[0xd] & 2) == 0 ||
        (((RAM_Samp_pek[0xe] & 0x10) == 0 && ((RAM_Samp_pek[0xe] & 0x20) == 0)))))) {
      if ((((RAM_Samp_pek[0xe] & 8) == 0) && ((RAM_Samp_pek[0xe] & 4) == 0)) &&
         ((RAM_Samp_pek[0xd] & 4) != 0)) {
        if (RAM_R_sond_error < 0x28) {
          bVar2 = DAT_00003fe8 >> 6;
        }
        else {
          bVar2 = DAT_00003fe8 >> 5;
        }
        if (((bVar2 & 1) != 0) || (DAT_0000376e == 1)) {
          if (RAM_R_sond_error != 0) {
            RAM_R_sond_error = RAM_R_sond_error - 1;
          }
          RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] | 8;
          RAM_Ramp_steg_[2] = RAM_Ramp_steg_[2] | 0x20;
          if ((DAT_000038c5 & 0x40) == 0) {
            Function_000467F8();
            RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0x7f;
          }
        }
      }
    }
    else if (DAT_0000376e == 1) {
      RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] | 0x10;
    }
    else if ((DAT_0000376e == 4) && ((char)DAT_000034b4 < DAT_00007502)) {
      RAM_Ramp_steg_[2] = RAM_Ramp_steg_[2] | 0x20;
      if (DAT_00003b5e < 10) {
        DAT_00004042 = DAT_00004042 | 0x80;
      }
      else if (DAT_00003b5e < 0xe7) {
        if ((RAM_Samp_pek[0xe] & 0x10) == 0) {
          if ((RAM_Samp_pek[0xe] & 0x20) == 0) {
            if ((RAM_Samp_pek[0xf] & 0x20) != 0) {
              DAT_00004042 = DAT_00004042 | 8;
            }
          }
          else {
            DAT_00004042 = DAT_00004042 | 0x10;
          }
        }
        else {
          DAT_00004042 = DAT_00004042 | 0x20;
        }
      }
      else {
        DAT_00004042 = DAT_00004042 | 0x40;
      }
      RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] | 4;
      Function_0005F0B8(0x1d28);
      sVar1 = 0x24;
      pbVar3 = RAM_Crankshaft_frame;
      pbVar5 = RAM_R_sond_frame;
      do {
        *(undefined4 *)pbVar5 = *(undefined4 *)pbVar3;
        sVar1 = sVar1 + -1;
        pbVar3 = pbVar3 + 4;
        pbVar5 = pbVar5 + 4;
      } while (sVar1 != -1);
      if ((DAT_000038c5 & 0x40) == 0) {
        Function_000467F8();
        RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0x7f;
      }
      RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] | 4;
      if ((RAM_R_sond_error < 0x28) && ((RAM_Samp_pek[0xb] & 0x40) == 0)) {
        RAM_R_sond_error = 0x28;
      }
      else if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
        RAM_R_sond_error = 0x2c;
        DAT_000040e7 = DAT_000040e7 | 0x20;
      }
      if (0x2b < RAM_R_sond_error) {
        RAM_Samp_pek[0x10] = RAM_Samp_pek[0x10] | 4;
      }
    }
    else if ((DAT_0000376e == 4) && (DAT_00007502 < (char)DAT_000034b4)) {
      RAM_Ramp_steg_[2] = RAM_Ramp_steg_[2] | 0x20;
      bVar2 = RAM_Samp_pek[0xe] | 4;
      if (DAT_00003b5e < 10) {
        DAT_00004042 = DAT_00004042 | 0x80;
      }
      else if (DAT_00003b5e < 0xe7) {
        if ((RAM_Samp_pek[0xe] & 0x10) == 0) {
          if ((RAM_Samp_pek[0xe] & 0x20) == 0) {
            if ((RAM_Samp_pek[0xf] & 0x20) != 0) {
              DAT_00004042 = DAT_00004042 | 8;
            }
          }
          else {
            DAT_00004042 = DAT_00004042 | 0x10;
          }
        }
        else {
          DAT_00004042 = DAT_00004042 | 0x20;
        }
      }
      else {
        DAT_00004042 = DAT_00004042 | 0x40;
      }
      RAM_Samp_pek[0xe] = bVar2;
      if ((DAT_000038c5 & 0x40) == 0) {
        Function_000467F8();
        RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] & 0x7f;
      }
      RAM_Samp_pek[0xd] = RAM_Samp_pek[0xd] | 4;
    }
    if (RAM_R_sond_error == 0) {
      DAT_000040e7 = DAT_000040e7 & 0xdf;
      DAT_00004042 = 0;
    }
  }
  if (((RAM_R_sond_error < 0x29) && ((DAT_00001039 & 8) != 0)) &&
     (((RAM_Samp_pek[0x10] & 0x10) != 0 || ((RAM_Samp_pek[0xe] & 4) != 0)))) {
    Function_00044C58();
  }
  else {
    Function_00044C58();
  }
  return;
}

```
