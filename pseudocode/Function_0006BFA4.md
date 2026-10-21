# Function_0006BFA4

**ROM:** `0x0006BFA4`

```c

void Function_0006BFA4(void)

{
  byte *pbVar1;
  byte *extraout_A1;
  byte *extraout_A1_00;
  
  if (DAT_00003a1a != '\x01') {
    DAT_00004704 = DAT_00001037;
    DAT_00004705 = DAT_00001037;
    DAT_00004706 = DAT_00001037;
    DAT_00004707 = DAT_00001037;
    DAT_00004708 = DAT_00001037;
    DAT_00004709 = DAT_00001037;
    DAT_0000470a = DAT_00001037;
    DAT_0000470b = DAT_00001037;
    DAT_0000470c = DAT_00001037;
    DAT_0000470d = DAT_00001037;
    DAT_0000470e = DAT_00001037;
    DAT_0000470f = DAT_00001037;
    DAT_00004710 = DAT_00001037;
    DAT_00004711 = DAT_00001037;
    DAT_00004712 = DAT_00001037;
    DAT_00004713 = DAT_00001037;
    DAT_00004714 = DAT_00001037;
    DAT_00004715 = DAT_00001037;
    DAT_00004716 = DAT_00001037;
    DAT_00004717 = DAT_00001037;
    DAT_00004718 = DAT_00001037;
    DAT_00004719 = DAT_00001037;
    DAT_0000471a = DAT_00001037;
    DAT_0000471b = DAT_00001037;
    DAT_0000471c = DAT_00001037;
    DAT_0000471d = DAT_00001037;
    DAT_0000471e = DAT_00001037;
    DAT_0000471f = DAT_00001037;
    DAT_00004720 = DAT_00001037;
    DAT_00004721 = DAT_00001037;
    DAT_00004722 = DAT_00001037;
    DAT_00004723 = DAT_00001037;
    RAM_Last_delta[0] = 0;
    RAM_Lacc_mangd[0] = 0;
    RAM_Last_delta[1] = 0;
    RAM_Lacc_mangd[1] = 0;
    RAM_Last_delta[2] = 0;
    RAM_Lacc_mangd[2] = 0;
    RAM_Last_delta[3] = 0;
    DAT_0000100e = 0;
  }
  pbVar1 = &DAT_0000101d;
  if (DAT_00001066 < 400) {
    for (DAT_00003532 = 0;
        ((ushort)(&DAT_00004e72)[(short)(ushort)DAT_00003532] < DAT_00001066 &&
        (DAT_00003532 != 0xf)); DAT_00003532 = DAT_00003532 + 1) {
    }
    DAT_00003536 = (&DAT_00004704)[(short)(ushort)DAT_0000101d * 8];
    DAT_00004702 = DAT_00004702 & 0x3f;
    if ((DAT_00003536 < DAT_00001037) &&
       (DAT_00003536 < RAM_Acc_clear_tab_[(short)(ushort)DAT_00003532])) {
      if (DAT_00001037 < RAM_Acc_clear_tab_[(short)(ushort)DAT_00003532]) {
        DAT_0000100e = DAT_00001037 - DAT_00003536;
      }
      else {
        DAT_0000100e = RAM_Acc_clear_tab_[(short)(ushort)DAT_00003532] - DAT_00003536;
      }
      if (RAM_Lner_detekt_ < DAT_0000100e) {
        DAT_00004702 = DAT_00004702 | 0x80;
      }
    }
    else if (DAT_00001037 < DAT_00003536) {
      DAT_0000100e = DAT_00003536 - DAT_00001037;
      if (RAM_Accupp_detekt_ < DAT_0000100e) {
        DAT_00004702 = DAT_00004702 | 0x40;
      }
    }
    else {
      DAT_0000100e = 0;
    }
    if ((DAT_00004702 & 0x80) == 0) {
      if (RAM_Last_delta[(short)(ushort)DAT_0000101d] != 0) {
        RAM_Last_delta[(short)(ushort)DAT_0000101d] =
             (byte)((uint)((int)(short)(ushort)RAM_Max_ret_dec_ *
                          (int)(short)(ushort)RAM_Last_delta[(short)(ushort)DAT_0000101d]) >> 8);
      }
    }
    else {
      DAT_00004726 = Function_00072972(RAM_Shift_up_time_,&DAT_00004ba4,RAM_Accel_konst_,8,
                                       DAT_00001066);
      DAT_0000472a = (byte)((uint)((int)(short)(ushort)DAT_00001001 *
                                  (int)(short)(ushort)DAT_00004726) >> 8);
      RAM_Last_delta[(short)(ushort)*extraout_A1] =
           (byte)((uint)((int)(short)(ushort)RAM_Max_ret_dec_ *
                        (int)(short)(ushort)RAM_Last_delta[(short)(ushort)*extraout_A1]) >> 8);
      pbVar1 = extraout_A1;
      if (RAM_Last_delta[(short)(ushort)*extraout_A1] < DAT_0000472a) {
        RAM_Last_delta[(short)(ushort)*extraout_A1] = DAT_0000472a;
      }
    }
    if ((DAT_00004702 & 0x40) == 0) {
      if (RAM_Lacc_mangd[(short)(ushort)*pbVar1] != 0) {
        RAM_Lacc_mangd[(short)(ushort)*pbVar1] =
             (byte)((uint)((int)(short)(ushort)DAT_00004b8a *
                          (int)(short)(ushort)RAM_Lacc_mangd[(short)(ushort)*pbVar1]) >> 8);
      }
    }
    else {
      DAT_00004724 = Function_00072972(RAM_Shift_up_time_,&DAT_00004ba4,&DAT_00006cc6,8,DAT_00001066
                                      );
      DAT_00004728 = (byte)((uint)((int)(short)(ushort)DAT_00001042 *
                                  (int)(short)(ushort)DAT_00004724) >> 8);
      RAM_Lacc_mangd[(short)(ushort)*extraout_A1_00] =
           (byte)((uint)((int)(short)(ushort)DAT_00004b8a *
                        (int)(short)(ushort)RAM_Lacc_mangd[(short)(ushort)*extraout_A1_00]) >> 8);
      pbVar1 = extraout_A1_00;
      if (RAM_Lacc_mangd[(short)(ushort)*extraout_A1_00] < DAT_00004728) {
        RAM_Lacc_mangd[(short)(ushort)*extraout_A1_00] = DAT_00004728;
      }
    }
  }
  else {
    RAM_Last_delta[(short)(ushort)DAT_0000101d] = 0;
    RAM_Lacc_mangd[(short)(ushort)DAT_0000101d] = 0;
  }
  for (DAT_00003530 = 0; DAT_00003530 < (ushort)(RAM_Ret_clear_tab_low_ - 1);
      DAT_00003530 = DAT_00003530 + 1) {
    (&DAT_00004704)[(short)(ushort)*pbVar1 * 8 + (int)(short)DAT_00003530] =
         (&DAT_00004704)[(short)(ushort)*pbVar1 * 8 + (int)(short)(DAT_00003530 + 1)];
  }
  (&DAT_00004704)[(short)(ushort)*pbVar1 * 8 + (int)(short)(RAM_Ret_clear_tab_low_ - 1)] =
       DAT_00001037;
  DAT_00003a1a = 1;
  return;
}

```
