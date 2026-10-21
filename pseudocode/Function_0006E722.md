# Function_0006E722

**ROM:** `0x0006E722`

```c

void Function_0006E722(void)

{
  uint uVar1;
  ushort uVar2;
  char *extraout_A1;
  byte *extraout_A1_00;
  
  if (DAT_00003a4a != '\x01') {
    if (RAM_Trot_delta < DAT_00001015) {
      DAT_0000475e = DAT_00001015 - RAM_Trot_delta;
      DAT_0000475f = DAT_0000475e;
      DAT_00004760 = DAT_0000475e;
      DAT_00004761 = DAT_0000475e;
    }
    else {
      DAT_00004761 = '\0';
      DAT_00004760 = '\0';
      DAT_0000475f = '\0';
      DAT_0000475e = '\0';
    }
  }
  if (DAT_00001066 < 500) {
    if (RAM_Trot_delta < DAT_00001015) {
      DAT_00003546 = DAT_00001015 - RAM_Trot_delta;
    }
    else {
      DAT_00003546 = 0;
    }
    for (DAT_0000354c = 0;
        ((ushort)(&DAT_00004e72)[(short)(ushort)DAT_0000354c] < DAT_00001066 &&
        (DAT_0000354c != 0xf)); DAT_0000354c = DAT_0000354c + 1) {
    }
    DAT_00003552 = (&DAT_0000475e)[(short)(ushort)DAT_0000101d];
    DAT_0000103b = DAT_0000103b & 0xf9;
    if ((DAT_00003552 < DAT_00003546) &&
       (DAT_00003552 < (byte)(&DAT_00004b8c)[(short)(ushort)DAT_0000354c])) {
      if (DAT_00003546 < (byte)(&DAT_00004b8c)[(short)(ushort)DAT_0000354c]) {
        RAM_Temp_fak_tab = DAT_00003546 - DAT_00003552;
      }
      else {
        RAM_Temp_fak_tab = (&DAT_00004b8c)[(short)(ushort)DAT_0000354c] - DAT_00003552;
      }
      if (DAT_0000763e < RAM_Temp_fak_tab) {
        DAT_0000103b = DAT_0000103b | 4;
      }
    }
    else if ((DAT_00003546 < DAT_00003552) &&
            (DAT_00003546 < (byte)(&DAT_00004b8c)[(short)(ushort)DAT_0000354c])) {
      if (DAT_00003552 < (byte)(&DAT_00004b8c)[(short)(ushort)DAT_0000354c]) {
        RAM_Temp_fak_tab = DAT_00003552 - DAT_00003546;
      }
      else {
        RAM_Temp_fak_tab = (&DAT_00004b8c)[(short)(ushort)DAT_0000354c] - DAT_00003546;
      }
      if (RAM_Retard_temp_ < RAM_Temp_fak_tab) {
        DAT_0000103b = DAT_0000103b | 2;
      }
    }
    else {
      RAM_Temp_fak_tab = 0;
    }
    if (((RAM_Ramp_steg_[1] & 0x10) == 0) || ((DAT_0000103b & 4) == 0)) {
      if (RAM_Acc_temp[(short)(ushort)DAT_0000101d] != 0) {
        DAT_00004744 = (byte)((uint)((int)(short)(ushort)RAM_Last_acc_nr_ *
                                    (int)(short)(ushort)(byte)(&DAT_00003a44)
                                                              [(short)(ushort)DAT_0000101d]) >> 8);
        RAM_Acc_temp[(short)(ushort)DAT_0000101d] = DAT_00004744;
        (&DAT_00003a44)[(short)(ushort)DAT_0000101d] = DAT_00004744;
        DAT_00003552 = DAT_00004744;
        if (DAT_00004744 == 0) {
          if (DAT_0000101d == 0) {
            DAT_00001981 = DAT_00001981 & 0xef;
          }
          else if (DAT_0000101d == 1) {
            DAT_00001981 = DAT_00001981 & 0xdf;
          }
          else if (DAT_0000101d == 2) {
            DAT_00001981 = DAT_00001981 & 0xbf;
          }
          else {
            DAT_00001981 = DAT_00001981 & 0x7f;
          }
        }
      }
    }
    else {
      DAT_0000473a = RAM_Acc_temp[(short)(ushort)DAT_0000101d] == 0;
      DAT_00001000 = Function_00072972(RAM_Shift_up_time_,&DAT_00004ba4,RAM_Temp_ramp_value_,8,
                                       DAT_00001066);
      DAT_00004740 = (byte)((uint)((int)(short)(ushort)DAT_00001001 *
                                  (int)(short)(ushort)DAT_00001000) >> 8);
      if ((RAM_Eft_dec2 != 0) && (RAM_Eft_fak2 != 0)) {
        DAT_00004740 = (byte)((uint)((int)(short)(ushort)DAT_00004740 *
                                    (int)(short)(ushort)RAM_Apc_knock_tab_
                                                        [(short)(((uint)RAM_Eft_dec2 * 10) /
                                                                (uint)RAM_Eft_fak2)]) >> 8);
      }
      DAT_00004744 = (byte)((uint)((int)(short)(ushort)RAM_Last_acc_nr_ *
                                  (int)(short)(ushort)(byte)(&DAT_00003a44)
                                                            [(short)(ushort)DAT_0000101d]) >> 8);
      if (DAT_00004740 < DAT_00004744) {
        RAM_Acc_temp[(short)(ushort)DAT_0000101d] = DAT_00004744;
      }
      else {
        RAM_Acc_temp[(short)(ushort)DAT_0000101d] = DAT_00004740;
      }
      (&DAT_00003a44)[(short)(ushort)DAT_0000101d] = RAM_Acc_temp[(short)(ushort)DAT_0000101d];
      if (*extraout_A1 == '\x01') {
        uVar1 = (uint)((int)(short)(ushort)RAM_Acc_temp[(short)(ushort)DAT_0000101d] *
                      (int)(short)(ushort)DAT_00004b72) / 10;
        uVar2 = (ushort)uVar1;
        if (uVar2 < 0x100) {
          DAT_0000353e._1_1_ = (byte)uVar1;
          RAM_Acc_temp[(short)(ushort)DAT_0000101d] = (byte)DAT_0000353e;
          DAT_0000353e = uVar2;
        }
        else {
          DAT_0000353e = uVar2;
          RAM_Acc_temp[(short)(ushort)DAT_0000101d] = 0xff;
        }
      }
      if (RAM_Acc_temp[(short)(ushort)DAT_0000101d] != 0) {
        if (DAT_0000101d == 0) {
          DAT_00001981 = DAT_00001981 | 0x10;
        }
        else if (DAT_0000101d == 1) {
          DAT_00001981 = DAT_00001981 | 0x20;
        }
        else if (DAT_0000101d == 2) {
          DAT_00001981 = DAT_00001981 | 0x40;
        }
        else {
          DAT_00001981 = DAT_00001981 | 0x80;
        }
      }
    }
    if ((((RAM_Ramp_steg_[1] & 0x20) == 0) || ((DAT_0000103b & 2) == 0)) ||
       (DAT_00003546 < RAM_Global_adapt_nr_)) {
      if (RAM_Ret_temp[(short)(ushort)DAT_0000101d] != 0) {
        DAT_00004742 = (byte)((uint)((int)(short)(ushort)RAM_Max_acc_dec_ *
                                    (int)(short)(ushort)(byte)(&DAT_00003a40)
                                                              [(short)(ushort)DAT_0000101d]) >> 8);
        RAM_Ret_temp[(short)(ushort)DAT_0000101d] = DAT_00004742;
        (&DAT_00003a40)[(short)(ushort)DAT_0000101d] = DAT_00004742;
        DAT_00003552 = DAT_00004742;
        if (DAT_00004742 == 0) {
          if (DAT_0000101d == 0) {
            DAT_00001982 = DAT_00001982 & 0xef;
          }
          else if (DAT_0000101d == 1) {
            DAT_00001982 = DAT_00001982 & 0xdf;
          }
          else if (DAT_0000101d == 2) {
            DAT_00001982 = DAT_00001982 & 0xbf;
          }
          else {
            DAT_00001982 = DAT_00001982 & 0x7f;
          }
        }
      }
    }
    else {
      DAT_0000473c = RAM_Ret_temp[(short)(ushort)DAT_0000101d] == 0;
      RAM_Pgm_status =
           Function_00072972(RAM_Shift_up_time_,&DAT_00004ba4,&DAT_00004a7c,8,DAT_00001066);
      DAT_0000473e = (byte)((uint)((int)(short)(ushort)DAT_00001042 *
                                  (int)(short)(ushort)RAM_Pgm_status) >> 8);
      DAT_00004742 = (byte)((uint)((int)(short)(ushort)RAM_Max_acc_dec_ *
                                  (int)(short)(ushort)(byte)(&DAT_00003a40)
                                                            [(short)(ushort)*extraout_A1_00]) >> 8);
      if (DAT_0000473e < DAT_00004742) {
        RAM_Ret_temp[(short)(ushort)*extraout_A1_00] = DAT_00004742;
      }
      else {
        RAM_Ret_temp[(short)(ushort)*extraout_A1_00] = DAT_0000473e;
      }
      (&DAT_00003a40)[(short)(ushort)*extraout_A1_00] = RAM_Ret_temp[(short)(ushort)*extraout_A1_00]
      ;
      if (DAT_0000473c == '\x01') {
        uVar1 = (uint)((int)(short)(ushort)RAM_Ret_temp[(short)(ushort)*extraout_A1_00] *
                      (int)(short)(ushort)RAM_Acc_tab_mul_) / 10;
        uVar2 = (ushort)uVar1;
        if (uVar2 < 0x100) {
          DAT_0000353e._1_1_ = (byte)uVar1;
          RAM_Ret_temp[(short)(ushort)*extraout_A1_00] = (byte)DAT_0000353e;
          DAT_0000353e = uVar2;
        }
        else {
          DAT_0000353e = uVar2;
          RAM_Ret_temp[(short)(ushort)*extraout_A1_00] = 0xff;
        }
      }
      if (RAM_Ret_temp[(short)(ushort)*extraout_A1_00] != 0) {
        if (*extraout_A1_00 == 0) {
          DAT_00001982 = DAT_00001982 | 0x10;
        }
        else if (*extraout_A1_00 == 1) {
          DAT_00001982 = DAT_00001982 | 0x20;
        }
        else if (*extraout_A1_00 == 2) {
          DAT_00001982 = DAT_00001982 | 0x40;
        }
        else {
          DAT_00001982 = DAT_00001982 | 0x80;
        }
      }
    }
    (&DAT_0000475e)[(short)(ushort)DAT_0000101d] = DAT_00003546;
  }
  else {
    DAT_00003a44 = 0;
    DAT_00003a45 = 0;
    DAT_00003a46 = 0;
    DAT_00003a47 = 0;
    DAT_00003a40 = 0;
    DAT_00003a41 = 0;
    DAT_00003a42 = 0;
    DAT_00003a43 = 0;
  }
  DAT_00003a4a = 1;
  return;
}

```
