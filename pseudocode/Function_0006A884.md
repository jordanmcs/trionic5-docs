# Function_0006A884

**ROM:** `0x0006A884`

```c

void Function_0006A884(void)

{
  byte bVar1;
  byte bVar2;
  ushort uVar3;
  short sVar4;
  short sVar5;
  code *extraout_A1;
  code *extraout_A1_00;
  byte *pbVar6;
  undefined2 uVar7;
  undefined2 uVar8;
  
  if (DAT_00003a16 != '\x03') {
    if (DAT_00003a16 != '\x02') {
      if (DAT_00003a16 != '\x01') {
        RAM_Insp_tid = 0x80;
        DAT_00001031 = 0x80;
        DAT_000035d4 = 0;
        DAT_0000103c = DAT_0000103c & 0xfd;
        DAT_00001076 = 1;
        DAT_00003a19 = DAT_00003a19 & 0xfb | 2;
        DAT_00003a10 = 0;
        DAT_00003a0c = 0;
        RAM_Rpm_byte = RAM_Start_detekt_nr_;
        DAT_00004798 = 0;
      }
      if ((DAT_00001039 & 8) == 0) {
        DAT_00003a16 = 1;
        return;
      }
      DAT_0000103b = DAT_0000103b | 0x80;
      uVar3 = (ushort)RAM_AD_knock;
      uVar8 = 0;
      uVar7 = 0;
      DAT_0000112e = Function_0006A4E4(0x6c38,0x6c42);
      DAT_000035c8 = (ushort)DAT_0000112e * 10;
      DAT_00001132 = (*extraout_A1)(&DAT_00006c38,0x6c4c,uVar7,uVar8,uVar3);
      DAT_00001133 = (*extraout_A1_00)(&DAT_00006c38,0x6c56);
      DAT_000035c0 = 0;
    }
    if (DAT_000035c8 != DAT_000035c0) {
      DAT_000035c0 = DAT_000035c0 + 1;
      DAT_00003a16 = 2;
      return;
    }
    DAT_00003a18 = DAT_00003a18 | 2;
    DAT_00004798 = 1;
  }
  DAT_00001076 = 0;
  for (DAT_000035dc = 0;
      ((ushort)(&DAT_00004e72)[(short)(ushort)DAT_000035dc] < DAT_00001066 && (DAT_000035dc != 0xf))
      ; DAT_000035dc = DAT_000035dc + 1) {
  }
  if ((RAM_Open_loop_adapt_[(short)(ushort)DAT_000035dc] < DAT_00001037) &&
     ((DAT_0000103a & 2) != 0)) {
    DAT_00003a18 = DAT_00003a18 | 0x80;
  }
  else if ((RAM_Indent_kvot_[(short)(ushort)DAT_000035dc] < DAT_00001037) &&
          ((DAT_0000103a & 2) == 0)) {
    DAT_00003a18 = DAT_00003a18 | 0x80;
  }
  else {
    DAT_00003a18 = DAT_00003a18 & 0x7f;
  }
  if ((((DAT_00001a84 + 0x15U < DAT_00001a58) && (DAT_00001a58 <= DAT_00001a84 + 0x16U)) &&
      (RAM_Cat_ox1_duty_cycle < 100)) && (0x2ee < RAM_U_lambda_eng)) {
    RAM_Samp_pek[0xf] = RAM_Samp_pek[0xf] | 0x80;
  }
  if ((DAT_00003a19 & 0x40) == 0) {
    if ((RAM_Ramp_steg_[0] & 0x10) == 0) {
      RAM_Insp_tid = 0x80;
      DAT_00001031 = 0x80;
      DAT_0000103c = DAT_0000103c & 0xfd;
      DAT_0000103b = DAT_0000103b | 0x80;
    }
    else if ((DAT_00001132 < RAM_AD_knock) && ((DAT_0000103a & 4) != 0)) {
      RAM_Insp_tid = 0x80;
      DAT_00001031 = 0x80;
      DAT_0000103c = DAT_0000103c & 0xfd;
      DAT_0000103b = DAT_0000103b | 0x80;
      DAT_000035d4 = 0;
      DAT_00001076 = 1;
    }
    else if ((DAT_00001133 < RAM_AD_knock) && ((DAT_00001137 & 0x20) == 0)) {
      RAM_Insp_tid = 0x80;
      DAT_00001031 = 0x80;
      DAT_0000103c = DAT_0000103c & 0xfd;
      DAT_0000103b = DAT_0000103b | 0x80;
      DAT_000035d4 = 0;
      DAT_00001076 = 1;
    }
    else if (DAT_00001066 < DAT_00006a3e) {
      RAM_Insp_tid = 0x80;
      DAT_00001031 = 0x80;
      DAT_0000103c = DAT_0000103c & 0xfd;
      DAT_000035d4 = 0;
    }
    else if (DAT_00001013 < (byte)(&DAT_00006c62)[(short)(ushort)DAT_000035dc]) {
      RAM_Insp_tid = 0x80;
      DAT_00001031 = 0x80;
      DAT_0000103c = DAT_0000103c & 0xfd;
      DAT_000035d4 = 0;
      DAT_0000103b = DAT_0000103b | 0x80;
      DAT_00001076 = 4;
    }
    else if ((((ushort)((ushort)RAM_Acc_temp[0] + (ushort)RAM_Acc_temp[1] + (ushort)RAM_Acc_temp[2]
                       + (ushort)RAM_Acc_temp[3]) == 0) &&
             ((ushort)((ushort)RAM_Ret_temp[0] + (ushort)RAM_Ret_temp[1] + (ushort)RAM_Ret_temp[2] +
                      (ushort)RAM_Ret_temp[3]) == 0)) ||
            (((RAM_Ramp_steg_[1] & 2) != 0 && ('\'' < DAT_0000102e)))) {
      if ((DAT_00003a18 & 0x80) == 0) {
        if (((DAT_00001137 & 0x20) == 0) || ((RAM_Ramp_steg_[2] & 0x80) != 0)) {
          if ((((RAM_Samp_pek[0] & 8) == 0) || ((RAM_Samp_pek[10] & 0x10) != 0)) &&
             (((RAM_Samp_pek[0] & 0x20) == 0 && ((RAM_Samp_pek[0xf] & 0x80) == 0)))) {
            if ((DAT_0000103a & 0xf0) == 0) {
              if ((DAT_0000103d & 0x40) == 0) {
                if ((((RAM_Ramp_steg_[2] & 1) == 0) || ((DAT_00003a19 & 0x80) == 0)) ||
                   ((DAT_0000103a & 4) != 0)) {
                  if (((RAM_Ramp_steg_[4] & 8) == 0) ||
                     (((DAT_00003736 & 0x80) == 0 && ((DAT_00003736 & 0x20) == 0)))) {
                    DAT_0000103b = DAT_0000103b & 0x7f;
                    DAT_0000103c = DAT_0000103c | 2;
                    DAT_00001076 = 2;
                    DAT_00003a14 = DAT_00003a14 + 1;
                    DAT_000035e2 = DAT_00001037;
                    if ((DAT_00003a18 & 0x10) != 0) {
                      if (DAT_00001031 < 0xf1) {
                        DAT_00001031 = RAM_Insp_tid + 0xf;
                      }
                      else {
                        DAT_00001031 = 0xff;
                      }
                    }
                    if (((RAM_Samp_pek[7] & 8) == 0) && ((RAM_Samp_pek[5] & 0x10) == 0)) {
                      pbVar6 = &DAT_00006b80;
                      for (sVar4 = 0;
                          ((ushort)((short)((ushort)*pbVar6 +
                                           (ushort)(byte)(&DAT_00006b80)[(ushort)(sVar4 + 1)]) >> 1)
                           < (ushort)DAT_00001037 && (sVar4 != 7)); sVar4 = sVar4 + 1) {
                        pbVar6 = pbVar6 + 1;
                      }
                      pbVar6 = RAM_Lam_load_sp_;
                      for (sVar5 = 0;
                          ((ushort)(*(short *)(RAM_Lam_load_sp_ + (uint)(ushort)(sVar5 + 1) * 2) +
                                   *(short *)pbVar6) >> 1 < DAT_00003c32 && (sVar5 != 7));
                          sVar5 = sVar5 + 1) {
                        pbVar6 = pbVar6 + 2;
                      }
                      uVar3 = sVar4 + sVar5 * 8;
                      sVar4 = DAT_00001996 + (ushort)RAM_Lean_step_map_[uVar3];
                      if (sVar4 < 0) {
                        DAT_00001036 = 0;
                      }
                      else if (sVar4 < 0x100) {
                        DAT_00001036 = (byte)sVar4;
                      }
                      else {
                        DAT_00001036 = 0xff;
                      }
                      sVar4 = DAT_00001994 + (ushort)RAM_Lam_rpmsteg_[uVar3];
                      if (sVar4 < 0) {
                        RAM_Mager_steg = 0;
                      }
                      else if (sVar4 < 0x100) {
                        RAM_Mager_steg = (byte)sVar4;
                      }
                      else {
                        RAM_Mager_steg = 0xff;
                      }
                      if ((DAT_00003a18 & 0x20) == 0) {
                        DAT_000046fc = 0x226;
                      }
                      else {
                        DAT_000046fc = 0x1c2;
                      }
                      RAM_Fet_steg = RAM_Rich_step_map_[uVar3];
                      bVar1 = RAM_Frekv_map_[uVar3];
                      bVar2 = (&DAT_00006b40)[uVar3];
                    }
                    else {
                      for (DAT_0000355e = 0;
                          (DAT_0000355e < 3 && (RAM_Open_varv_[DAT_0000355e] < DAT_00001037));
                          DAT_0000355e = DAT_0000355e + 1) {
                      }
                      DAT_00003558 = 0;
                      while ((DAT_00003558 < 3 &&
                             ((ushort)(byte)(&DAT_00006a3a)[DAT_00003558] < DAT_00001066 >> 1))) {
                        DAT_00003558 = DAT_00003558 + 1;
                      }
                      DAT_0000355e = DAT_00003558 * '\x18' + DAT_0000355e * '\x06';
                      DAT_00001036 = RAM_Min_rpm_closed_loop_[DAT_0000355e];
                      RAM_Mager_steg = RAM_Min_rpm_closed_loop_[DAT_0000355e + 1];
                      if ((DAT_00003a18 & 0x20) == 0) {
                        DAT_000046fc = 0x226;
                      }
                      else {
                        DAT_000046fc = 300;
                      }
                      RAM_Fet_steg = RAM_Min_rpm_closed_loop_[DAT_0000355e + 3];
                      bVar1 = RAM_Min_rpm_closed_loop_[DAT_0000355e + 5];
                      bVar2 = RAM_Min_rpm_closed_loop_[DAT_0000355e + 4];
                    }
                    DAT_000046f8 = DAT_00001998 + bVar1;
                    DAT_000046f6 = DAT_00001999 + bVar2;
                    DAT_00003a12 = DAT_00003a12 + 1;
                    if (RAM_Lamb_ej_ <= DAT_00003a12) {
                      DAT_00003a19 = DAT_00003a19 | 0x20;
                    }
                    if ((((RAM_Samp_pek[2] & 1) == 0) || ((DAT_00003a19 & 0x20) != 0)) &&
                       (((DAT_00003a19 & 0x20) == 0 || (DAT_000046fc <= RAM_Cat_ox1_duty_cycle)))) {
                      if ((RAM_Samp_pek[2] & 1) != 0) {
                        RAM_Samp_pek[2] = RAM_Samp_pek[2] & 0xfe;
                        DAT_00004082 = DAT_00004082 + '\x01';
                      }
                      if (((DAT_00003a18 & 0x20) == 0) && ((DAT_00003a18 & 0x10) == 0)) {
                        DAT_00003a12 = 0;
                        DAT_00003a19 = DAT_00003a19 & 0xdf;
                        if (DAT_000035d4 < DAT_000046f6) {
                          DAT_000035d4 = DAT_000035d4 + 1;
                        }
                        else {
                          DAT_00003a18 = DAT_00003a18 | 0x21;
                          DAT_00001019 = '\0';
                          if (RAM_Mager_steg < DAT_00001031) {
                            DAT_00001031 = DAT_00001031 - RAM_Mager_steg;
                          }
                          else {
                            DAT_00001031 = 0;
                          }
                          DAT_000035d4 = 0;
                        }
                      }
                      else if (RAM_Fet_steg <= DAT_00003a14) {
                        if (RAM_Com_on_idle_ < DAT_00001031) {
                          DAT_00001031 = DAT_00001031 - RAM_Com_on_idle_;
                        }
                        else {
                          DAT_00001031 = 0;
                        }
                        DAT_00001019 = DAT_00001019 + '\x01';
                        DAT_0000102a = DAT_0000102a + '\x01';
                        DAT_00003a18 = DAT_00003a18 & 0xef;
                        DAT_00003a14 = 0;
                      }
                    }
                    else {
                      RAM_Samp_pek[2] = RAM_Samp_pek[2] | 1;
                      if (((DAT_00003a18 & 0x20) == 0) || ((DAT_00003a18 & 0x10) != 0)) {
                        if (RAM_Fet_steg <= DAT_00003a14) {
                          if ((short)(ushort)DAT_00001031 < (short)(0xff - (ushort)RAM_Com_on_idle_)
                             ) {
                            DAT_00001031 = RAM_Com_on_idle_ + DAT_00001031;
                          }
                          else {
                            DAT_00001031 = 0xff;
                          }
                          DAT_00001019 = DAT_00001019 + '\x01';
                          DAT_00001029 = DAT_00001029 + '\x01';
                          DAT_00003a18 = DAT_00003a18 & 0xef;
                          DAT_00003a14 = 0;
                        }
                      }
                      else {
                        DAT_00003a12 = 0;
                        DAT_00003a19 = DAT_00003a19 & 0xdf;
                        if (DAT_000035d4 < DAT_000046f8) {
                          DAT_000035d4 = DAT_000035d4 + 1;
                        }
                        else {
                          DAT_00003a18 = DAT_00003a18 & 0xdf | 1;
                          DAT_00001019 = '\0';
                          DAT_000035e8 = (ushort)DAT_00001031 + (ushort)DAT_00001036;
                          if (DAT_000035e8 < 0x100) {
                            DAT_00001031 = (byte)DAT_000035e8;
                          }
                          else {
                            DAT_00001031 = 0xff;
                          }
                          DAT_000035d4 = 0;
                        }
                      }
                    }
                    RAM_Insp_tid = (byte)((ushort)((ushort)RAM_Insp_tid * 0xf + (ushort)DAT_00001031
                                                  ) >> 4);
                    Function_0006B612();
                    if (DAT_00001a60 == 0) {
                      DAT_00001a60 = DAT_00001a58;
                    }
                  }
                  else {
                    RAM_Insp_tid = 0x80;
                    DAT_00001031 = 0x80;
                    DAT_0000103c = DAT_0000103c & 0xfd;
                    DAT_000035d4 = 0;
                  }
                }
                else {
                  if ((short)(0xff - (ushort)DAT_00001031) < (short)(ushort)RAM_Halva_sidan_) {
                    DAT_00001031 = 0xff;
                  }
                  else {
                    DAT_00001031 = RAM_Halva_sidan_ + DAT_00001031;
                  }
                  DAT_0000103c = DAT_0000103c & 0xfd;
                  DAT_000035d4 = 0;
                  DAT_00001076 = 4;
                }
              }
              else {
                RAM_Insp_tid = 0x80;
                DAT_00001031 = 0x80;
                DAT_0000103c = DAT_0000103c & 0xfd;
                DAT_000035d4 = 0;
                DAT_00001076 = 4;
              }
            }
            else {
              DAT_0000103c = DAT_0000103c & 0xfd;
              DAT_000035d4 = 0;
              RAM_Insp_tid = 0x80;
              DAT_00001031 = 0x80;
              DAT_00001076 = 4;
            }
          }
          else {
            RAM_Insp_tid = 0x80;
            DAT_00001031 = 0x80;
            DAT_0000103c = DAT_0000103c & 0xfd;
            DAT_000035d4 = 0;
            DAT_00001076 = 8;
          }
        }
        else {
          RAM_Insp_tid = 0x80;
          DAT_00001031 = 0x80;
          DAT_0000103c = DAT_0000103c & 0xfd;
          DAT_000035d4 = 0;
          DAT_00001076 = 4;
        }
      }
      else {
        RAM_Insp_tid = 0x80;
        DAT_00001031 = 0x80;
        DAT_0000103c = DAT_0000103c & 0xfd;
        DAT_000035d4 = 0;
        DAT_0000103b = DAT_0000103b | 0x80;
        DAT_00001076 = 4;
      }
    }
    else {
      DAT_0000103c = DAT_0000103c & 0xfd;
      DAT_000035d4 = 0;
      RAM_Insp_tid = 0x80;
      DAT_00001031 = 0x80;
      DAT_00001076 = 4;
      if (DAT_0000102e < '(') {
        DAT_0000103b = DAT_0000103b | 0x80;
      }
    }
  }
  else {
    DAT_0000103c = DAT_0000103c & 0xfd;
  }
  if ((DAT_0000103a & 4) == 0) {
    DAT_00003a19 = DAT_00003a19 & 0x7f;
  }
  else {
    DAT_00003a19 = DAT_00003a19 | 0x80;
  }
  DAT_00003a16 = 3;
  return;
}

```
