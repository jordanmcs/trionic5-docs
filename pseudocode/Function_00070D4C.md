# Function_00070D4C

**ROM:** `0x00070D4C`

```c

void Function_00070D4C(void)

{
  short sVar1;
  byte bVar2;
  byte *pbVar3;
  byte *extraout_A1;
  byte *extraout_A1_00;
  byte *extraout_A1_01;
  byte *extraout_A1_02;
  byte *extraout_A1_03;
  byte *extraout_A1_04;
  byte *extraout_A1_05;
  byte *extraout_A1_06;
  byte *extraout_A1_07;
  undefined1 *puVar4;
  undefined1 *extraout_A1_08;
  bool bVar5;
  
  if (DAT_00003a82 != '\x03') {
    if (DAT_00003a82 != '\x01') {
      RAM_Cyl_nr = 0;
      if ((DAT_000038c2 & 0x20) == 0) {
        Function_00044270();
      }
      RAM_Purge_freq = RAM_Purge_freq | 2;
      DAT_0000103c = DAT_0000103c & 0xdf;
      DAT_00004796 = 0;
      DAT_00004794 = DAT_00003a80;
    }
    if (((((RAM_Ramp_steg_[2] & 0x20) == 0) || (DAT_0000102e <= DAT_00006e12)) ||
        (DAT_00001031 == 0x80)) || (DAT_00004798 != '\x01')) {
      DAT_00003a82 = 1;
      return;
    }
    DAT_00004792 = 0;
    DAT_00004798 = '\0';
  }
  for (DAT_000035b0 = 0;
      ((ushort)(&DAT_00004e72)[(short)(ushort)DAT_000035b0] < DAT_00001066 && (DAT_000035b0 != 0xf))
      ; DAT_000035b0 = DAT_000035b0 + 1) {
  }
  if (((ushort)RAM_Open_loop_adapt_[(short)(ushort)DAT_000035b0] <
       (ushort)((ushort)DAT_00001037 + (ushort)DAT_00004792)) && ((DAT_0000103a & 2) != 0)) {
    DAT_00004792 = 3;
    DAT_00003a19 = DAT_00003a19 | 8;
  }
  else if (((ushort)RAM_Indent_kvot_[(short)(ushort)DAT_000035b0] <
            (ushort)((ushort)DAT_00001037 + (ushort)DAT_00004792)) && ((DAT_0000103a & 2) == 0)) {
    DAT_00004792 = 3;
    DAT_00003a19 = DAT_00003a19 | 8;
  }
  else if (((ushort)((ushort)DAT_00001013 + (ushort)DAT_00004792) < 0x5d) &&
          ((0x5b < DAT_00001136 || (DAT_00001013 <= DAT_00001136)))) {
    DAT_00004792 = 0;
    DAT_00003a19 = DAT_00003a19 & 0xf7;
  }
  else {
    DAT_00004792 = 3;
    DAT_00003a19 = DAT_00003a19 | 8;
  }
  if ((DAT_00003a19 & 8) == 0) {
    if (DAT_00001013 < (byte)(&DAT_00006c62)[(short)(ushort)DAT_000035b0]) {
      RAM_Cyl_nr = 0;
      if ((DAT_000038c2 & 0x20) == 0) {
        Function_00044270();
      }
      DAT_0000103c = DAT_0000103c & 0xdf;
      DAT_00004796 = 0;
    }
    else if ((DAT_0000103d & 0x40) == 0) {
      if ((RAM_Ramp_steg_[0] & 0x10) == 0) {
        RAM_Cyl_nr = 0;
        if ((DAT_000038c2 & 0x20) == 0) {
          Function_00044270();
        }
        DAT_0000103c = DAT_0000103c & 0xdf;
        DAT_00004796 = 0;
      }
      else {
        pbVar3 = &DAT_0000103c;
        if ((DAT_0000103c & 2) == 0) {
          RAM_Cyl_nr = 0;
          if ((DAT_000038c2 & 0x20) == 0) {
            Function_00044270();
            pbVar3 = extraout_A1;
          }
          *pbVar3 = *pbVar3 & 0xdf;
          DAT_00004796 = 0;
        }
        else if ((DAT_0000103b & 0x20) == 0) {
          sVar1 = Function_0004A4D2();
          if (((sVar1 == 0) || ((DAT_00001039 & 4) != 0)) || (DAT_00003c32 < 600)) {
            RAM_Cyl_nr = 0;
            pbVar3 = extraout_A1_01;
            if ((DAT_000038c2 & 0x20) == 0) {
              Function_00044270();
              pbVar3 = extraout_A1_02;
            }
            *pbVar3 = *pbVar3 & 0xdf;
            DAT_00004796 = 0;
          }
          else if ((RAM_Ramp_steg_[2] & 0x20) == 0) {
            RAM_Cyl_nr = 0;
            pbVar3 = extraout_A1_01;
            if ((DAT_000038c2 & 0x20) == 0) {
              Function_00044270();
              pbVar3 = extraout_A1_03;
            }
            *pbVar3 = *pbVar3 & 0xdf;
            DAT_00004796 = 0;
          }
          else if ((DAT_0000103a & 0xf0) == 0) {
            if (DAT_00001132 < RAM_AD_knock) {
              RAM_Cyl_nr = 0;
              pbVar3 = extraout_A1_01;
              if ((DAT_000038c2 & 0x20) == 0) {
                Function_00044270();
                pbVar3 = extraout_A1_05;
              }
              *pbVar3 = *pbVar3 & 0xdf;
              DAT_00004796 = 0;
            }
            else if ((((RAM_Samp_pek[5] & 1) == 0) && ((RAM_Samp_pek[0] & 8) == 0)) &&
                    ((RAM_Samp_pek[0] & 0x20) == 0)) {
              if (((DAT_00003a19 & 2) == 0) && ((DAT_00003a19 & 1) != 0)) {
                RAM_Cyl_nr = 0;
                pbVar3 = extraout_A1_01;
                if ((DAT_000038c2 & 0x20) == 0) {
                  Function_00044270();
                  pbVar3 = extraout_A1_07;
                }
                *pbVar3 = *pbVar3 & 0xdf;
                DAT_00004796 = 0;
              }
              else if (((char)DAT_00003ee6 < '\0') ||
                      (((DAT_00003ee6 & 0x40) == 0 || ((DAT_00006e20 & 0x80) == 0)))) {
                *extraout_A1_01 = *extraout_A1_01 | 0x20;
                DAT_000035e4 = Function_00072972(&DAT_00004e92,RAM_Purge_map_xaxis_,&DAT_00006d10,
                                                 0x10,DAT_00001066);
                if ((DAT_0000103a & 4) != 0) {
                  if ((RAM_Samp_pek[0x10] & 0x80) == 0) {
                    DAT_000035e4 = RAM_Sond_heat_tab_;
                  }
                  else {
                    DAT_000035e4 = RAM_Purge_duty_idle_;
                  }
                  RAM_Purge_freq = RAM_Purge_freq | 0x20;
                }
                if ((DAT_000035e4 != 0) && (DAT_000035e4 < RAM_Purge_tab_)) {
                  DAT_000035e4 = RAM_Purge_tab_;
                }
                DAT_00004796 = DAT_000035e4;
                if ((DAT_0000103a & 4) == 0) {
                  if (((RAM_Purge_adapt_cthr < 0x32) &&
                      (bVar2 = (byte)((uint)((int)(short)(ushort)DAT_000035e4 *
                                             (int)(short)(ushort)RAM_Purge_adapt_cthr * 2) / 100),
                      bVar5 = DAT_000035e4 != 0, DAT_000035e4 = bVar2, bVar5)) &&
                     (bVar2 < RAM_Purge_tab_)) {
                    DAT_000035e4 = RAM_Purge_tab_;
                  }
                  if ((RAM_Purge_freq & 0x20) != 0) {
                    RAM_Purge_freq = RAM_Purge_freq & 0xdf | 2;
                  }
                }
                else if (((RAM_Purge_duty < 0x32) &&
                         (bVar2 = (byte)((uint)((int)(short)(ushort)DAT_000035e4 *
                                                (int)(short)(ushort)RAM_Purge_duty * 2) / 100),
                         bVar5 = DAT_000035e4 != 0, DAT_000035e4 = bVar2, bVar5)) &&
                        (bVar2 < RAM_Purge_tab_)) {
                  DAT_000035e4 = RAM_Purge_tab_;
                }
                if (RAM_Cyl_nr == 0) {
                  RAM_Purge_freq = RAM_Purge_freq | 2;
                }
                if (((RAM_Purge_freq & 2) == 0) || ((RAM_Samp_pek[0x10] & 0x80) != 0)) {
                  RAM_Cyl_nr = DAT_000035e4;
                  if ((DAT_000038c2 & 0x20) == 0) {
                    Function_00044270();
                  }
                  RAM_Purge_freq = RAM_Purge_freq & 0xfd;
                }
                else {
                  puVar4 = &DAT_000035d6;
                  if (RAM_Cyl_nr < DAT_000035e4) {
                    if (DAT_00004794 < DAT_000035d6) {
                      RAM_Cyl_nr = RAM_Cyl_nr + 1;
                      if ((DAT_000035e4 != 0) && (RAM_Cyl_nr < 5)) {
                        RAM_Cyl_nr = 5;
                      }
                      if ((DAT_000038c2 & 0x20) == 0) {
                        Function_00044270();
                        puVar4 = extraout_A1_08;
                      }
                      *puVar4 = 0;
                    }
                    else {
                      DAT_000035d6 = DAT_000035d6 + 1;
                    }
                  }
                  else {
                    RAM_Purge_freq = RAM_Purge_freq & 0xfd;
                    RAM_Cyl_nr = DAT_000035e4;
                    if ((DAT_000038c2 & 0x20) == 0) {
                      Function_00044270();
                    }
                    DAT_00004794 = RAM_Purge_duty_tank_;
                  }
                }
                if (DAT_00004796 != 0) {
                  if ((((DAT_00001031 != DAT_0000479a) || (DAT_00001031 == 0)) ||
                      (DAT_00001031 == 0xff)) && (DAT_00004796 != 0)) {
                    if ((DAT_00001031 < 0xc9) && (0x37 < DAT_00001031)) {
                      if ((DAT_00001031 < 0xb5) && (0x4b < DAT_00001031)) {
                        if ((DAT_00001031 < 0xa1) && (0x5f < DAT_00001031)) {
                          DAT_000035bc = 0x14;
                        }
                        else {
                          DAT_000035bc = 6;
                        }
                      }
                      else {
                        DAT_000035bc = 4;
                      }
                    }
                    else {
                      DAT_000035bc = 1;
                    }
                    if ((DAT_0000103a & 4) == 0) {
                      if (DAT_000035bc < DAT_000035de) {
                        if (RAM_Insp_tid < 0x81) {
                          if ((RAM_Insp_tid < 0x80) && (RAM_Insp_tid <= DAT_0000479c)) {
                            if (RAM_Purge_adapt_cthr != 0) {
                              RAM_Purge_adapt_cthr = RAM_Purge_adapt_cthr - 1;
                            }
                            DAT_000035de = 0;
                          }
                        }
                        else {
                          if (RAM_Purge_adapt_cthr < 0x80) {
                            RAM_Purge_adapt_cthr = RAM_Purge_adapt_cthr + 1;
                          }
                          DAT_000035de = 0;
                        }
                      }
                      else {
                        DAT_000035de = DAT_000035de + 1;
                      }
                    }
                    else if (DAT_000035bc < DAT_000035de) {
                      if (RAM_Insp_tid < 0x81) {
                        if ((RAM_Insp_tid < 0x80) && (RAM_Insp_tid <= DAT_0000479c)) {
                          if (RAM_Purge_duty != 0) {
                            RAM_Purge_duty = RAM_Purge_duty - 1;
                          }
                          DAT_000035de = 0;
                        }
                      }
                      else {
                        if (RAM_Purge_duty < 0x80) {
                          RAM_Purge_duty = RAM_Purge_duty + 1;
                        }
                        DAT_000035de = 0;
                      }
                    }
                    else {
                      DAT_000035de = DAT_000035de + 1;
                    }
                  }
                  DAT_0000479c = RAM_Insp_tid;
                  DAT_0000479a = DAT_00001031;
                  if ((DAT_0000103a & 4) == 0) {
                    if ((DAT_000035e4 < 6) || (RAM_Cyl_nr < 6)) {
                      RAM_Purge_adapt_othr = 0x80;
                    }
                    else {
                      RAM_Purge_adapt_othr =
                           (byte)((0x3200 - (((uint)RAM_Cyl_nr * 100 - 500) / (DAT_000035e4 - 5)) *
                                            (0x80 - (uint)RAM_Purge_adapt_cthr)) / 100);
                    }
                  }
                  else if ((DAT_000035e4 < 6) || (RAM_Cyl_nr < 6)) {
                    RAM_Purge_adapt_othr = 0x80;
                  }
                  else {
                    RAM_Purge_adapt_othr =
                         (byte)((0x3200 - (((uint)RAM_Cyl_nr * 100 - 500) / (DAT_000035e4 - 5)) *
                                          (0x80 - (uint)RAM_Purge_duty)) / 100);
                  }
                }
              }
              else {
                RAM_Cyl_nr = (byte)(RAM_PMProt / 10);
                if ((DAT_000038c2 & 0x20) == 0) {
                  Function_00044270();
                }
                DAT_00004796 = 0;
              }
            }
            else {
              RAM_Cyl_nr = 0;
              pbVar3 = extraout_A1_01;
              if ((DAT_000038c2 & 0x20) == 0) {
                Function_00044270();
                pbVar3 = extraout_A1_06;
              }
              *pbVar3 = *pbVar3 & 0xdf;
              DAT_00004796 = 0;
            }
          }
          else {
            RAM_Cyl_nr = 0;
            pbVar3 = extraout_A1_01;
            if ((DAT_000038c2 & 0x20) == 0) {
              Function_00044270();
              pbVar3 = extraout_A1_04;
            }
            *pbVar3 = *pbVar3 & 0xdf;
            DAT_00004796 = 0;
          }
        }
        else {
          RAM_Cyl_nr = 0;
          if ((DAT_000038c2 & 0x20) == 0) {
            Function_00044270();
            pbVar3 = extraout_A1_00;
          }
          *pbVar3 = *pbVar3 & 0xdf;
          DAT_00004796 = 0;
        }
      }
    }
    else {
      RAM_Cyl_nr = 0;
      if ((DAT_000038c2 & 0x20) == 0) {
        Function_00044270();
      }
      DAT_0000103c = DAT_0000103c & 0xdf;
      DAT_00004796 = 0;
    }
  }
  else {
    RAM_Cyl_nr = 0;
    if ((DAT_000038c2 & 0x20) == 0) {
      Function_00044270();
    }
    DAT_0000103c = DAT_0000103c & 0xdf;
    DAT_00004796 = 0;
  }
  DAT_00003a82 = 3;
  return;
}

```
