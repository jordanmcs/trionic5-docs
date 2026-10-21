# Function_0007300C

**ROM:** `0x0007300C`

```c

void Function_0007300C(void)

{
  short sVar1;
  
  if ((RAM_Ramp_steg_[3] & 0x10) != 0) {
    for (DAT_000047d8 = 0;
        ((ushort)(&DAT_00005b6e)[(short)(ushort)DAT_000047d8] < DAT_00001066 &&
        (DAT_000047d8 != 0xf)); DAT_000047d8 = DAT_000047d8 + 1) {
    }
    if (DAT_00001066 < 0xfb) {
      DAT_000047d6 = 0;
    }
    else if (DAT_00001066 < 0x226) {
      DAT_000047d6 = (byte)((int)(DAT_00001066 - 0xfa) / 10);
    }
    else {
      DAT_000047d6 = 0x1e;
    }
    if ((RAM_Ramp_steg_[3] & 2) == 0) {
      if (((byte)RAM_Spik_count & 0x40) == 0) {
        DAT_00001154 = *(short *)(RAM_Max_ratio_aut_ + (uint)DAT_000047d6 * 2);
      }
      else if ((DAT_000047f2 == '\x01') &&
              ((int)((uint)RAM_Reg_kon_fga_ * 10) <
               (int)*(short *)(RAM_Max_ratio_aut_ + (uint)DAT_000047d6 * 2))) {
        DAT_00001154 = (ushort)RAM_Reg_kon_fga_ * 10;
      }
      else if ((int)((uint)RAM_Reg_kon_fgm_ * 10) <
               (int)*(short *)(RAM_Max_ratio_aut_ + (uint)DAT_000047d6 * 2)) {
        DAT_00001154 = (ushort)RAM_Reg_kon_fgm_ * 10;
      }
      else {
        DAT_00001154 = *(short *)(RAM_Max_ratio_aut_ + (uint)DAT_000047d6 * 2);
      }
    }
    else if ((((byte)RAM_Spik_count & 0x80) == 0) ||
            ((int)*(short *)(RAM_Reg_kon_mat_ + (uint)DAT_000047d6 * 2) <=
             (int)((uint)RAM_Apc_decrese_asp_ * 10))) {
      DAT_00001154 = *(short *)(RAM_Reg_kon_mat_ + (uint)DAT_000047d6 * 2);
    }
    else {
      DAT_00001154 = (ushort)RAM_Apc_decrese_asp_ * 10;
    }
    if (((DAT_000047e8 < DAT_00005eb2) || (DAT_000047c2 != 0)) && (RAM_Medeltryck != 0)) {
      DAT_00001154 = (short)(((int)DAT_00001154 * (100 - (uint)RAM_Medeltryck)) / 100);
    }
    if ((char)RAM_Last < 'Q') {
      if ('(' < (char)RAM_Last) {
        DAT_00001154 = DAT_00001154 + ((char)RAM_Last + -0x28) * 2;
      }
    }
    else {
      DAT_00001154 = DAT_00001154 + 0x50;
    }
    DAT_000047c8 = (ushort)DAT_00003353 - (ushort)RAM_Gear;
    if (0x80 < DAT_000047c8) {
      DAT_000047c8 = 0x80;
    }
    DAT_0000347c = (short)(DAT_000047c4 * DAT_000047c8) / 10;
    if (DAT_000047e8 < DAT_00005eb2) {
      DAT_0000347a = 0;
      DAT_000047c6 = 0;
    }
    else {
      DAT_000047c6 = DAT_000047c6 + DAT_000047c8 * DAT_000047c2;
      if ((DAT_000047c6 < 0x65) || ((short)RAM_Adaption_time_ <= DAT_0000347a)) {
        if (DAT_000047c6 < -100) {
          if ((short)-RAM_Adaption_time_ < DAT_0000347a) {
            DAT_0000347a = DAT_0000347a + -1;
          }
          DAT_000047c6 = 0;
        }
      }
      else {
        DAT_0000347a = DAT_000047c6 / 100 + DAT_0000347a;
        DAT_000047c6 = 0;
      }
    }
    sVar1 = ((ushort)DAT_000047d0 - (ushort)RAM_Gear) * DAT_000047c0;
    if (sVar1 < 0) {
      sVar1 = sVar1 + 1;
    }
    DAT_00003478 = sVar1 >> 1;
    DAT_000047dc = DAT_00003478 + DAT_0000347a + DAT_0000347c + RAM_Derivata_rpm + DAT_00001154;
    if ((RAM_Spik_count._0_1_ & 0x40) == 0) {
      if ((short)DAT_000047dc < 2) {
        DAT_000047dc = 2;
      }
      DAT_000047da = DAT_000047dc;
    }
    else {
      DAT_000047da = 2;
      DAT_0000347a = 0;
      DAT_000047c6 = 0;
    }
    if ((RAM_Samp_pek[5] & 8) == 0) {
      if ((RAM_Samp_pek[8] & 8) == 0) {
        if ((RAM_Spik_count._0_1_ & 8) == 0) {
          if ((RAM_Samp_pek[0] & 0x20) == 0) {
            if ((RAM_Spik_count._0_1_ & 4) == 0) {
              if ((DAT_000047f2 == 'R') && ((RAM_Ramp_steg_[1] & 0x40) == 0)) {
                DAT_000047da = 2;
                DAT_00003fa2 = 0x10;
                DAT_0000347a = 0;
                DAT_000047c6 = 0;
              }
              else if (RAM_Bil_hast < DAT_000072a2) {
                DAT_000047da = 2;
                DAT_00003fa2 = 8;
                DAT_0000347a = 0;
                DAT_000047c6 = 0;
              }
              else if ((short)DAT_000047da < 0x3d5) {
                if ((short)DAT_000047da < 2) {
                  DAT_000047da = 2;
                  DAT_00003fa2 = 0;
                }
                else {
                  DAT_00003fa2 = 0;
                }
              }
              else {
                DAT_000047da = 0x3d4;
                DAT_00003fa2 = 0;
              }
            }
            else {
              DAT_000047da = 2;
              DAT_00003fa2 = 0x20;
              DAT_0000347a = 0;
              DAT_000047c6 = 0;
            }
          }
          else {
            DAT_000047da = 2;
            DAT_00003fa2 = 0x40;
            DAT_0000347a = 0;
            DAT_000047c6 = 0;
          }
        }
        else {
          DAT_000047da = 2;
          DAT_00003fa2 = 0x80;
          DAT_0000347a = 0;
          DAT_000047c6 = 0;
        }
      }
      else {
        DAT_000047da = 2;
        DAT_00003fa2 = 4;
        DAT_0000347a = 0;
        DAT_000047c6 = 0;
      }
    }
    else {
      DAT_000047da = 2;
      DAT_0000347a = 0;
      DAT_000047c6 = 0;
    }
    if (DAT_00001066 < 100) {
      DAT_000047da = 2;
    }
    DAT_00003476 = DAT_000047da;
    RAM_PWM_ut = (byte)(DAT_000047da / 10);
    if ((DAT_000038c2 & 0x40) == 0) {
      Function_000466F0(DAT_00003a88);
    }
  }
  return;
}

```
