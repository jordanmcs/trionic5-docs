# Function_000725B8

**ROM:** `0x000725B8`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000725B8(void)

{
  byte bVar1;
  byte *extraout_A1;
  byte *pbVar2;
  byte *extraout_A1_00;
  
  if ((RAM_Ramp_steg_[3] & 2) == 0) {
    DAT_00003352 = Function_00072972(RAM_Pwm_ind_rpm_ + (short)(DAT_000047f2 - 1) * 8,&DAT_00005b6e,
                                     &DAT_00005bc6,0x80010,(uint)CONCAT12(DAT_000047e8,DAT_00001066)
                                    );
  }
  else {
    DAT_00003352 = Function_00072972(0x5bae,&DAT_00005b6e,RAM_Tryck_mat_,0x80010,
                                     (uint)CONCAT12(DAT_000047e8,DAT_00001066));
  }
  DAT_00003351 = RAM_Overs_tab_xaxis_[(short)(ushort)DAT_000047d8];
  if (DAT_00001015 < RAM_Apc_fullgas_) {
    RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ | 0x10;
    DAT_00003354 = 0;
    DAT_000047d2 = 0;
  }
  else if ((RAM_Spik_count._0_1_ & 0x10) != 0) {
    if (DAT_000047d2 < DAT_00003351) {
      DAT_000047d2 = DAT_000047d2 + 1;
      if (RAM_Gear < DAT_00003352) {
        DAT_000047ce = DAT_00003352 - RAM_Gear;
      }
      else {
        DAT_000047ce = '\0';
      }
      DAT_00003354 = Function_00072972(RAM_Overs_tab_,&DAT_00005b6e,&DAT_00005cce,0x80010,
                                       (uint)CONCAT12(DAT_000047ce,DAT_00001066));
      DAT_000047cc = '\n';
      *extraout_A1 = 0;
      while ((DAT_000047cc < (char)RAM_Last && (*extraout_A1 != 7))) {
        *extraout_A1 = *extraout_A1 + 1;
        DAT_000047cc = DAT_000047cc + '\n';
      }
      DAT_00003354 = (byte)((uint)((int)(short)(ushort)DAT_00003354 *
                                  (int)(short)(ushort)RAM_Tryck_mat_a_[(short)(ushort)*extraout_A1])
                           / 0xff);
    }
    else {
      RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ & 0xef;
      DAT_00003354 = 0;
    }
  }
  DAT_000047b2 = DAT_00003354 + DAT_00003352;
  if (DAT_000047b2 < DAT_00003354) {
    DAT_000047b2 = 0xff;
  }
  Function_00072DC2();
  pbVar2 = &DAT_00003353;
  if (DAT_000047b2 < 0x79) {
    DAT_00003353 = DAT_000047b2;
  }
  else {
    DAT_00003353 = DAT_000047b2 - RAM_Medeltryck;
    if (DAT_00003353 < 0x78) {
      DAT_00003353 = 0x78;
    }
  }
  bVar1 = (byte)RAM_Spik_count & 0xbf;
  if ((((byte)RAM_Spik_count & 0x80) == 0) ||
     (DAT_00003353 <= RAM_Reg_kon_sgm_[(short)(ushort)DAT_000047d8])) {
    RAM_Spik_count._1_1_ = bVar1;
    if ((RAM_Ramp_steg_[3] & 2) == 0) {
      if (DAT_000047f2 == 1) {
        if (RAM_Max_regl_sp_[(short)(ushort)DAT_000047d8] < DAT_00003353) {
          DAT_00003353 = RAM_Max_regl_sp_[(short)(ushort)DAT_000047d8];
          RAM_Spik_count._1_1_ = bVar1 | 0x40;
        }
      }
      else if ((DAT_000047f2 == 2) &&
              ((byte)(&DAT_00005f52)[(short)(ushort)DAT_000047d8] < DAT_00003353)) {
        DAT_00003353 = (&DAT_00005f52)[(short)(ushort)DAT_000047d8];
        RAM_Spik_count._1_1_ = bVar1 | 0x40;
      }
    }
  }
  else {
    DAT_00003353 = RAM_Reg_kon_sgm_[(short)(ushort)DAT_000047d8];
    RAM_Spik_count._1_1_ = bVar1 | 0x40;
  }
  if ((RAM_Ramp_steg_[3] & 2) != 0) {
    _DAT_000047ee =
         Function_0006A410(RAM_Max_regl_temp_2_,RAM_Temp_max_regl_,CONCAT22(DAT_00001066,0x10));
    _DAT_000047f0 =
         Function_0006A410(RAM_Max_regl_temp_2_,RAM_Max_regl_temp_1_,CONCAT22(DAT_00001066,0x10));
    RAM_Regl_tryck =
         Function_0006A314(&DAT_00005ee0,&DAT_000047ee,CONCAT22((short)(char)RAM_Last,2));
    pbVar2 = extraout_A1_00;
    if (RAM_Regl_tryck < *extraout_A1_00) {
      *extraout_A1_00 = (byte)RAM_Regl_tryck;
    }
  }
  if (DAT_000047a6 < *pbVar2) {
    *pbVar2 = *pbVar2 - DAT_000047a6;
  }
  else {
    *pbVar2 = 0;
  }
  return;
}

```
