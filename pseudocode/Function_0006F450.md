# Function_0006F450

**ROM:** `0x0006F450`

```c

/* WARNING: Restarted to delay deadcode elimination for space: ram */

void Function_0006F450(void)

{
  byte bVar1;
  short sVar2;
  char cVar3;
  byte *extraout_A1;
  byte *extraout_A1_00;
  undefined1 *extraout_A1_01;
  ushort *extraout_A1_02;
  
  if ((DAT_000038c2 & 0x10) == 0) {
    if ((RAM_Samp_pek[0] & 0x20) == 0) {
      if ((DAT_000035c4 < DAT_00005fd2) && ((DAT_00001138 & 4) != 0)) {
        DAT_000035c4 = DAT_000035c4 + 1;
      }
      else {
        sVar2 = Function_00044BBC();
        if (sVar2 == 0) {
          DAT_00001137 = DAT_00001137 & 0xbf;
        }
        else {
          DAT_00001137 = DAT_00001137 | 0x40;
        }
        if ((*extraout_A1 < DAT_00001015) &&
           ((short)(ushort)DAT_000060b2 < (short)((ushort)DAT_00001015 - (ushort)*extraout_A1))) {
          DAT_00001137 = DAT_00001137 | 0x40;
        }
        if ((((DAT_00003596 & 0x40) != (DAT_00001137 & 0x40)) && (DAT_00003896 != 0)) &&
           ((DAT_00001137 & 0x40) == 0)) {
          DAT_00001137 = DAT_00001137 | 0x40;
        }
        sVar2 = Function_00044B86();
        if (sVar2 == 0x44) {
          DAT_00001137 = DAT_00001137 | 0x80;
        }
        else {
          DAT_00001137 = DAT_00001137 & 0x7f;
        }
        if (((((RAM_Ramp_steg_[3] & 2) == 0) || ((RAM_Ramp_steg_[5] & 0x40) == 0)) ||
            ((cVar3 = Function_00044BA4(), cVar3 != '\x01' ||
             (((short)(ushort)DAT_000061f4 <=
               (short)((ushort)DAT_00001015 - (ushort)*extraout_A1_00) ||
              (DAT_00001013 <= DAT_000061f5)))))) || (DAT_00003a6e != '\0')) {
          cVar3 = Function_00044BA4();
          if (cVar3 == '\x01') {
            if ((DAT_00003b02 < DAT_0000478c) && (DAT_00003a6e == '\x01')) {
              DAT_00001137 = DAT_00001137 | 0x40;
            }
            else if (DAT_00003a6e == '\x01') {
              DAT_00003a6e = '\x02';
            }
          }
          else {
            DAT_00003a6e = '\0';
          }
        }
        else {
          DAT_00003a6e = '\x01';
          DAT_00001137 = DAT_00001137 | 0x40;
          DAT_0000478c = DAT_00003b02 + DAT_000061f6;
        }
        for (DAT_000035b6 = 0;
            (DAT_0000102e < (char)(&DAT_00006088)[DAT_000035b6] && (DAT_000035b6 != 7));
            DAT_000035b6 = DAT_000035b6 + 1) {
        }
        if ((RAM_Ramp_steg_[3] & 8) == 0) {
          DAT_00001160 = Function_0006A314(&DAT_00006088,0x60c4,8);
          if (DAT_0000101c < 0x15) {
            if ((((DAT_00001139 & 1) == 0) && ((DAT_00001139 & 2) == 0)) &&
               ((RAM_Ramp_steg_[3] & 0x20) != 0)) {
              DAT_00001160 = RAM_Iv_start_pos_offset_ + DAT_00001160;
            }
          }
          else {
            DAT_00001138 = DAT_00001138 | 8;
          }
          if ((DAT_00001137 & 0x80) == 0) {
            DAT_00001160 = RAM_I_luft_st_._0_1_ + DAT_00001160;
          }
          else {
            DAT_00001160 = (byte)RAM_I_luft_st_ + DAT_00001160;
          }
        }
        else {
          DAT_0000356e = DAT_00003b9e;
          if (DAT_00003b9e < 0x9d) {
            if (DAT_00003b9e < 0x83) {
              DAT_00001160 = (short)((int)((0x83 - (uint)DAT_00003b9e) * 0x42) / 0x4f) + 0x55;
            }
            else {
              DAT_00001160 = 0x55;
            }
          }
        }
        if (((DAT_00001139 & 1) == 0) && ((RAM_Ramp_steg_[3] & 0x20) != 0)) {
          if (DAT_00001a58 < DAT_0000477a) {
            DAT_00004770 = DAT_00005fcc;
          }
          else if (DAT_00005fca < DAT_00004770) {
            DAT_00004770 = DAT_00004770 + -1;
          }
          else if (DAT_00004770 < DAT_00005fca) {
            DAT_00004770 = DAT_00004770 + 1;
          }
          else {
            DAT_00004770 = DAT_00005fca;
            DAT_00001139 = DAT_00001139 | 2;
          }
        }
        else {
          DAT_00004770 = DAT_00005fca;
        }
        if (((DAT_00001039 & 8) == 0) || ((DAT_00001039 & 4) != 0)) {
          DAT_0000477a = Function_0006A314(&DAT_00006088,0x62fe,8);
          if (((RAM_Ramp_steg_[3] & 8) != 0) && (DAT_0000356e = DAT_00003b9e, DAT_00003b9e < 0x9d))
          {
            if (DAT_00003b9e < 0x83) {
              DAT_00001160 = (short)((int)((0x83 - (uint)DAT_00003b9e) * 0x42) / 0x4f) + 0x55;
            }
            else {
              DAT_00001160 = 0x55;
            }
          }
          DAT_00001139 = 0;
          DAT_00001138 = 0;
          DAT_00001137 = DAT_00001137 & 0xc0;
          DAT_00003594 = 0;
          DAT_00003596 = DAT_00001137;
          *extraout_A1_01 = 0;
          if ((DAT_000038c4 & 0x20) == 0) {
            Function_000445AC();
          }
          DAT_00004786 = 0;
          DAT_000035cc = 0;
          DAT_00001137 = DAT_00001137 & 0xf7 | 0x30;
          DAT_00001156 = *(short *)(&DAT_000061ce + ((short)(ushort)DAT_00001136 >> 5) * 2) +
                         *(short *)(RAM_Idle_ej_off_ + (uint)DAT_000035b6 * 2) + DAT_000061fa;
          DAT_00001138 = DAT_00001138 | 4;
        }
        else {
          if (((DAT_0000103a & 4) == 0) || (0x77 < DAT_00001066)) {
            DAT_00001139 = DAT_00001139 & 0xbf;
            DAT_000035cc = 0;
          }
          else if ((DAT_00001137 & 0x40) == 0) {
            DAT_00001139 = DAT_00001139 | 0x40;
          }
          if (((DAT_00001a58 < DAT_000035cc + DAT_000061de) && ((DAT_00001139 & 0x40) != 0)) &&
             (DAT_00003a6e != '\x01')) {
            DAT_00001137 = DAT_00001137 & 0xbf;
          }
          if (DAT_00003576 < DAT_00005fce) {
            DAT_00003576 = DAT_00003576 + 1;
          }
          else {
            DAT_00001138 = DAT_00001138 | 0x20;
          }
          if (DAT_0000101c < 0x15) {
            DAT_000035b2 = 0;
            bVar1 = DAT_000035b2;
          }
          else {
            bVar1 = DAT_000035b2 + 1;
            if (0x4c < (byte)(DAT_000035b2 + 1)) {
              DAT_000061f2 = RAM_Last;
              bVar1 = DAT_000035b2;
            }
          }
          DAT_000035b2 = bVar1;
          for (DAT_00004780 = 0;
              ((short)(ushort)DAT_000061f2 < (short)(char)RAM_Idle_start_extra_ramp_[DAT_00004780]
              && (DAT_00004780 != 7)); DAT_00004780 = DAT_00004780 + 1) {
          }
          if ((((DAT_00001137 & 0x80) == 0) && ((DAT_00001137 & 0x40) == 0)) &&
             ((DAT_00001138 & 0x80) != 0)) {
            DAT_00004776 = &DAT_000061f8;
            DAT_00004772 = (ushort *)(RAM_Iv_min_change_ + (uint)DAT_00004780 * 2);
            DAT_00004782 = *DAT_00004772;
          }
          else if ((((DAT_00001137 & 0x80) == 0) || ((DAT_00001137 & 0x40) != 0)) ||
                  ((DAT_00001138 & 0x80) == 0)) {
            if ((DAT_00001137 & 0x80) == 0) {
              DAT_00004772 = (ushort *)(RAM_Iv_min_change_ + (uint)DAT_00004780 * 2);
              DAT_00004776 = &DAT_000061f8;
              DAT_00004782 = DAT_000061f8;
            }
            else {
              DAT_00004772 = (ushort *)(RAM_Iv_min_change_ + (uint)DAT_00004780 * 2 + 0x10);
              DAT_00004776 = &DAT_000061fa;
              DAT_00004782 = DAT_000061fa;
            }
          }
          else {
            DAT_00004776 = &DAT_000061fa;
            DAT_00004772 = (ushort *)(RAM_Iv_min_change_ + (uint)DAT_00004780 * 2 + 0x10);
            DAT_00004782 = *DAT_00004772;
          }
          DAT_0000358c = Function_0006A314(&DAT_00006088,0x60b4,8);
          DAT_00004782 = DAT_0000115c + DAT_0000358c + DAT_00004782;
          if ((((DAT_00001139 & 1) == 0) && ((DAT_00001139 & 2) == 0)) &&
             ((RAM_Ramp_steg_[3] & 0x20) != 0)) {
            DAT_00004782 = RAM_Idle_ac_tab_ + DAT_00004782;
          }
          if ((((DAT_00001137 & 0x80) != (DAT_00003596 & 0x80)) ||
              (((DAT_00001137 & 0x40) != (DAT_00003596 & 0x40) && ((DAT_00001138 & 0x80) != 0)))) ||
             (bVar1 = DAT_00001137, (DAT_00001138 & 0x40) != 0)) {
            RAM_Idle_medel_rpm = 0;
            bVar1 = DAT_00001137 | 0x10;
            if ((DAT_00001137 & 0x20) == 0) {
              DAT_00001156 = DAT_00001156 + DAT_00006098;
            }
            if ((DAT_00001137 & 0x80) != (DAT_00003596 & 0x80)) {
              if ((DAT_00001137 & 0x80) == 0) {
                if (DAT_00001156 < DAT_00004782) {
                  DAT_00001156 = DAT_00004782;
                }
              }
              else {
                DAT_00001156 = DAT_00004782;
              }
            }
            if ((((DAT_00001138 & 0x40) != 0) && ((DAT_00001137 & 0x40) == 0)) ||
               ((DAT_00001137 & 0x40) != (DAT_00003596 & 0x40))) {
              if ((DAT_00001137 & 0x40) == 0) {
                DAT_00001137 = bVar1;
                if ((DAT_00001138 & 0x40) == 0) {
                  DAT_0000115a = Function_0006A410(RAM_Idle_ac_extra_tab_,0x601a,0x10);
                  DAT_00001156 = DAT_0000115a + DAT_00004782;
                }
                else {
                  DAT_0000115a = Function_0006A410(RAM_Idle_ac_extra_tab_,0x601a,0x10);
                  DAT_00003588 = &DAT_000061fa;
                  DAT_00003574 = DAT_000061fa;
                  DAT_00003584 = (ushort *)(RAM_Iv_min_change_ + (uint)DAT_00004780 * 2 + 0x10);
                  *extraout_A1_02 = *DAT_00003584;
                  if (DAT_00003574 < *extraout_A1_02) {
                    DAT_00001156 = DAT_0000115a + (*extraout_A1_02 - DAT_00003574) + DAT_00001156;
                  }
                }
                DAT_00004788 = RAM_Iv_start_time_tab_[DAT_00004780];
                DAT_00001137 = DAT_00001137 | 4;
                DAT_000035cc = DAT_00001a58;
              }
              else {
                DAT_00001156 = DAT_00004782;
                DAT_00004788 = (&DAT_0000600e)[DAT_00004780];
                DAT_00001137 = DAT_00001137 | 0x12;
              }
              DAT_00001138 = DAT_00001138 & 0xbf;
              bVar1 = DAT_00001137;
            }
          }
          DAT_00001137 = bVar1;
          if (DAT_00001066 < DAT_000035ba) {
            DAT_000035be = DAT_000035ba - DAT_00001066;
          }
          else if (DAT_000035ba < DAT_00001066) {
            DAT_000035be = DAT_00001066 - DAT_000035ba;
          }
          else {
            DAT_000035be = 0;
          }
          if ((DAT_000035be < RAM_Delay_) && ((DAT_0000103a & 4) != 0)) {
            if (DAT_00004784 < DAT_000060aa) {
              DAT_00004784 = DAT_00004784 + 1;
            }
            else {
              DAT_00001139 = DAT_00001139 | 0x10;
            }
          }
          else {
            DAT_00004784 = 0;
            DAT_00001139 = DAT_00001139 & 0xef;
          }
          if (DAT_00001066 < (ushort)(DAT_00001160 + 5)) {
            DAT_00001139 = DAT_00001139 | 0x10;
          }
          if (3 < DAT_0000101c) {
            DAT_00001139 = DAT_00001139 | 1;
          }
          if ((DAT_00001137 & 0x20) == 0) {
            if ((((DAT_0000103a & 4) == 0) || ((DAT_00001139 & 0x10) == 0)) ||
               ((DAT_0000609c <= DAT_0000101c || ((DAT_00001139 & 4) != 0)))) {
              if (((((DAT_0000103a & 4) == 0) || ((RAM_Ramp_steg_[3] & 4) == 0)) ||
                  ((DAT_00001137 & 0x80) == 0)) ||
                 ((RAM_Eft_dec2 != 0 || ((DAT_0000103d & 8) != 0)))) {
                if ((DAT_0000103d & 8) == 0) {
                  DAT_00003570 = RAM_Dash_tab_value;
                }
                else {
                  DAT_00003570 = 0;
                }
                if ((ushort)(DAT_00004782 + DAT_00006098 + (ushort)DAT_00003570) <
                    (ushort)(DAT_00001156 - DAT_0000605a)) {
                  DAT_00001156 = DAT_00001156 - DAT_0000605a;
                }
                else if ((ushort)(DAT_00001156 + DAT_0000605a) <
                         (ushort)(DAT_00004782 + DAT_00006098 + (ushort)DAT_00003570)) {
                  DAT_00001156 = DAT_0000605a + DAT_00001156;
                }
                else {
                  DAT_00001156 = DAT_00004782 + DAT_00006098 + (ushort)DAT_00003570;
                }
                DAT_0000478a = 0;
                DAT_00003480 = 0;
                DAT_0000113c = 0x54;
              }
              else {
                Function_00070514();
                DAT_0000113c = 0x4c;
              }
            }
            else {
              DAT_00001137 = DAT_00001137 | 0x20;
              DAT_0000478a = 0;
              DAT_00003480 = 0;
              DAT_0000113c = 0x49;
            }
          }
          else if ((((DAT_0000103a & 4) == 0) || (DAT_0000609c < DAT_0000101c)) ||
                  ((DAT_00001139 & 4) != 0)) {
            DAT_00001137 = DAT_00001137 & 0xdf | 0x10;
            DAT_0000478a = 0;
            DAT_00003480 = 0;
          }
          if (((DAT_00001137 & 0x20) == 0) || ((DAT_00001139 & 0x80) != 0)) {
            if ((DAT_00001160 < (ushort)(DAT_00001066 - 10)) && (DAT_0000101c == 0)) {
              if ((DAT_00001137 & 0x20) != 0) {
                DAT_00001156 = DAT_00001156 - DAT_0000609e;
              }
            }
            else {
              DAT_00001138 = DAT_00001138 | 1;
              DAT_00001139 = DAT_00001139 & 0x7f;
            }
          }
          else {
            DAT_0000113c = 0x49;
            if ((DAT_00001160 <= (ushort)(DAT_00001066 - 0x14)) && ((DAT_00001138 & 1) == 0)) {
              DAT_00001139 = DAT_00001139 | 0x80;
            }
            if (7 < DAT_000035be) {
              DAT_000035be = 7;
            }
            if (DAT_00001160 < DAT_00001066) {
              if (DAT_00001066 < DAT_000035ba) {
                DAT_0000357e = &DAT_00005fd6 + DAT_000035be;
              }
              else {
                DAT_0000357e = (byte *)(DAT_000035be + 0x5fde);
              }
            }
            else if (DAT_00001066 < DAT_000035ba) {
              DAT_0000357e = (byte *)(DAT_000035be + 0x5fe6);
            }
            else {
              DAT_0000357e = (byte *)(DAT_000035be + 0x5fee);
            }
            if (*DAT_0000357e < 0x80) {
              if (*DAT_0000357e < DAT_00001156) {
                DAT_00001156 = DAT_00001156 - *DAT_0000357e;
              }
              else {
                DAT_00001156 = 0;
              }
            }
            else if ((ushort)(DAT_00001156 + (*DAT_0000357e - 0x80)) < 0x270) {
              DAT_00001156 = (DAT_00001156 + *DAT_0000357e) - 0x80;
            }
            else {
              DAT_00001156 = 0x270;
            }
            if (DAT_00001160 < DAT_00001066) {
              DAT_00003582 = DAT_00001066 - DAT_00001160;
            }
            else {
              DAT_00003582 = DAT_00001160 - DAT_00001066;
            }
            if (DAT_00003582 < 0x16) {
              DAT_00003582 = DAT_00003582 / 3;
            }
            else {
              DAT_00003582 = 7;
            }
            if (DAT_00001160 < DAT_00001066) {
              DAT_0000357a = &DAT_00005ff6 + DAT_00003582;
              if (*DAT_0000357a < DAT_00001156) {
                DAT_00001156 = DAT_00001156 - *DAT_0000357a;
              }
              else {
                DAT_00001156 = 0;
              }
            }
            else {
              DAT_0000357a = (byte *)(DAT_00003582 + 0x5ffe);
              if ((ushort)(DAT_00001156 + *DAT_0000357a) < 0x270) {
                DAT_00001156 = DAT_00001156 + *DAT_0000357a;
              }
              else {
                DAT_00001156 = 0x270;
              }
            }
            if (((ushort)(DAT_00001160 + DAT_0000605e) < DAT_00001066) ||
               (DAT_00001066 < (ushort)(DAT_00001160 - DAT_0000605c))) {
              DAT_00001137 = DAT_00001137 | 0x10;
            }
            else if ((DAT_00001137 & 0x10) == 0) {
              if ((DAT_00001137 & 8) == 0) {
                if (DAT_00001160 < RAM_Br_minus) {
                  DAT_00001156 = DAT_00001156 - DAT_000060ac;
                  DAT_00001137 = DAT_00001137 | 8;
                }
                else {
                  DAT_00001156 = DAT_000060ae + DAT_00001156;
                  DAT_00001137 = DAT_00001137 | 8;
                }
              }
              if (DAT_0000609a < RAM_Idle_medel_rpm) {
                if ((((RAM_Ramp_steg_[2] & 0x40) != 0) && ((DAT_00001138 & 8) != 0)) &&
                   (DAT_000035b6 == 0)) {
                  if (DAT_00004782 < DAT_00001156) {
                    DAT_00003578 = DAT_00001156 - DAT_00004782;
                  }
                  else {
                    DAT_00003578 = DAT_00004782 - DAT_00001156;
                  }
                  if (DAT_00003578 < 5) {
                    if (DAT_00003578 != 0) {
                      DAT_00003578 = 1;
                    }
                  }
                  else {
                    DAT_00003578 = DAT_00003578 >> 2;
                  }
                  if ((DAT_00001137 & 0x40) == 0) {
                    if ((DAT_00001137 & 0x40) == 0) {
                      if (DAT_00004782 < DAT_00001156) {
                        *DAT_00004772 = DAT_00003578 + *DAT_00004772;
                      }
                      else if (DAT_00001156 < DAT_00004782) {
                        *DAT_00004772 = *DAT_00004772 - DAT_00003578;
                      }
                      if ((ushort)(*DAT_00004772 - 0x14) < *DAT_00004776) {
                        *DAT_00004772 = *DAT_00004776 + 0x14;
                      }
                    }
                  }
                  else if (DAT_00004782 < DAT_00001156) {
                    *DAT_00004776 = DAT_00003578 + *DAT_00004776;
                  }
                  else if (DAT_00001156 < DAT_00004782) {
                    *DAT_00004776 = *DAT_00004776 - DAT_00003578;
                  }
                  if ((((DAT_00001137 & 0x40) != 0) && ((DAT_00001137 & 0x80) != 0)) &&
                     ('U' < DAT_0000102e)) {
                    if (DAT_000051c6 < DAT_00001037) {
                      if (DAT_000051c6 < DAT_000051c8) {
                        DAT_000051c6 = DAT_000051c6 + 1;
                      }
                      else {
                        DAT_000051c6 = DAT_000051c8;
                      }
                    }
                    else if (DAT_00001037 < DAT_000051c6) {
                      DAT_000051c6 = DAT_000051c6 - 1;
                    }
                    DAT_0000477c = DAT_000051c6;
                  }
                }
                RAM_Idle_medel_rpm = 0;
              }
              RAM_Idle_medel_rpm = RAM_Idle_medel_rpm + 1;
            }
            else {
              RAM_Idle_medel_rpm = 0;
              DAT_00001137 = DAT_00001137 & 0xef | 8;
            }
          }
        }
        if (DAT_00001156 < RAM_Trot_limit_ac_) {
          DAT_00001156 = RAM_Trot_limit_ac_;
        }
        else if (0x270 < DAT_00001156) {
          DAT_00001156 = 0x270;
        }
        DAT_000035ba = DAT_00001066;
        DAT_00003596 = DAT_00001137;
        DAT_00003594 = DAT_00001139;
        DAT_00003590 = DAT_000035b6;
        DAT_00003598 = DAT_00004780;
        DAT_0000113b = (undefined1)(DAT_00001156 >> 2);
        if ((DAT_00001137 & 1) == 1) {
          DAT_00001137 = DAT_00001137 & 0xfe;
        }
        else {
          DAT_00001137 = DAT_00001137 | 1;
        }
        DAT_000035c4 = 0;
        RAM_Idle_start_extra_value =
             (RAM_Trot_limit_ac_ +
             (short)(((uint)(ushort)((DAT_00001156 + 0x3a) - RAM_Trot_limit_ac_) *
                     (int)(short)((char)RAM_Last + 0x111)) / 0x125)) - 0x3a;
        if (0x270 < RAM_Idle_start_extra_value) {
          RAM_Idle_start_extra_value = 0x270;
        }
        DAT_00001054 = RAM_Idle_start_extra_value;
        if ((DAT_0000103d & 8) == 0) {
          Function_000709D4();
        }
        else {
          DAT_0000113c = 0x44;
        }
      }
    }
    else {
      sVar2 = DAT_000061fa + 0x1e;
      Function_000709D4();
      Function_000445AC(sVar2);
    }
  }
  return;
}

```
