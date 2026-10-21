# Function_0005EDB0

**ROM:** `0x0005EDB0`

```c

void Function_0005EDB0(void)

{
  byte abVar1 [4];
  byte abVar2 [4];
  byte abVar3 [4];
  
  if ((((((DAT_0000376e < 2) || ((DAT_00001137 & 0x20) == 0)) || ((DAT_0000103c & 2) == 0)) ||
       (((DAT_0000102e < '=' || (0x5db < DAT_00003e2c)) ||
        (((char)RAM_OBD2_frame[0] < '\0' ||
         (((char)RAM_OBD2_frame[0xc] < '\0' || ((DAT_00001039 & 1) == 0)))))))) ||
      (RAM_Purge_adapt_cthr < 0x33)) ||
     ((RAM_Purge_duty < 0x33 || (DAT_00001a58 <= (uint)((int)RAM_P_tank_filt_fak_ + DAT_00001a60))))
     ) {
    RAM_Samp_pek[5] = RAM_Samp_pek[5] & 0xef;
    DAT_00003862 = '\0';
    DAT_000034ce = RAM_Crankshaft_error;
    RAM_Samp_pek[9] = RAM_Samp_pek[9] & 0xef;
    if ((RAM_Samp_pek[8] & 0x40) == 0) {
      RAM_Ign_counter3[0] = 0;
      RAM_Ign_counter3[1] = 0;
      RAM_Ign_counter3[2] = 0;
      RAM_Ign_counter3[3] = 0;
      DAT_000010ae = 0;
    }
  }
  else if (((int)DAT_000034ce + 100U < (uint)RAM_Crankshaft_error) &&
          ((RAM_Samp_pek[9] & 0x10) == 0)) {
    if (DAT_000074be < DAT_00003f06) {
      RAM_Samp_pek[9] = RAM_Samp_pek[9] | 0x10;
    }
    if (((((DAT_00006e20 & 0x80) == 0) || ((RAM_Samp_pek[8] & 0x40) != 0)) ||
        (RAM_Sync_temp_ <= DAT_000010ae)) ||
       ((abVar1[0] = 0, abVar1[1] = 0, abVar1._2_2_ = RAM_Diag_speed_time_,
        (uint)abVar1 <= (uint)RAM_Ign_counter3 || ((RAM_Samp_pek[9] & 0x10) != 0)))) {
      RAM_Samp_pek[5] = RAM_Samp_pek[5] & 0xef;
    }
    else {
      RAM_Samp_pek[5] = RAM_Samp_pek[5] | 0x10;
    }
    if (((RAM_Samp_pek[8] & 0x40) == 0) && (DAT_00003862 == '\0')) {
      if ((DAT_0000387a < RAM_Cat_ox1_duty_cycle) || ((RAM_Idle_reknare & 8) == 0)) {
        if ((RAM_Cat_ox1_duty_cycle < DAT_00003878) || ((RAM_Idle_reknare & 8) != 0)) {
          if ((3 < DAT_000010ae) && (DAT_000010ae < RAM_Sync_temp_)) {
            RAM_Ign_counter3 = (byte  [4])((int)RAM_Crankshaft_error - (int)DAT_000034d2);
          }
        }
        else {
          if (DAT_000010ae < RAM_Sync_temp_) {
            DAT_000010ae = DAT_000010ae + 1;
            if (DAT_000010ae < 4) {
              RAM_Ign_counter3[0] = 0;
              RAM_Ign_counter3[1] = 0;
              RAM_Ign_counter3[2] = 0;
              RAM_Ign_counter3[3] = 0;
              DAT_000034d2 = RAM_Crankshaft_error;
            }
            else {
              RAM_Ign_counter3 = (byte  [4])((int)RAM_Crankshaft_error - (int)DAT_000034d2);
            }
          }
          RAM_Idle_reknare = RAM_Idle_reknare | 8;
        }
      }
      else {
        if (DAT_000010ae < RAM_Sync_temp_) {
          DAT_000010ae = DAT_000010ae + 1;
          if (DAT_000010ae < 4) {
            RAM_Ign_counter3[0] = 0;
            RAM_Ign_counter3[1] = 0;
            RAM_Ign_counter3[2] = 0;
            RAM_Ign_counter3[3] = 0;
            DAT_000034d2 = RAM_Crankshaft_error;
          }
          else {
            RAM_Ign_counter3 = (byte  [4])((int)RAM_Crankshaft_error - (int)DAT_000034d2);
          }
        }
        RAM_Idle_reknare = RAM_Idle_reknare & 0xf7;
      }
      if (DAT_00003874 < RAM_Cat_ox1_duty_cycle) {
        DAT_00003874 = RAM_Cat_ox1_duty_cycle;
      }
      if (RAM_Cat_ox1_duty_cycle < DAT_00003876) {
        DAT_00003876 = RAM_Cat_ox1_duty_cycle;
      }
    }
    if ((((RAM_Sync_temp_ <= DAT_000010ae) ||
         (abVar2[0] = 0, abVar2[1] = 0, abVar2._2_2_ = RAM_Diag_speed_time_,
         (uint)abVar2 < (uint)RAM_Ign_counter3)) && (DAT_00003862 == '\0')) &&
       ((RAM_Samp_pek[8] & 0x40) == 0)) {
      DAT_00003862 = '\x01';
      abVar3[0] = 0;
      abVar3[1] = 0;
      abVar3._2_2_ = RAM_Diag_speed_time_;
      if ((uint)abVar3 < (uint)RAM_Ign_counter3) {
        if (DAT_00003864 < 2) {
          DAT_00003864 = DAT_00003864 + 1;
        }
        else {
          RAM_Samp_pek[6] = RAM_Samp_pek[6] | 4;
          RAM_Samp_pek[8] = RAM_Samp_pek[8] | 0x40;
          RAM_OBD2_frame[0x18] = RAM_OBD2_frame[0x18] | 0x40;
        }
      }
      else {
        RAM_Samp_pek[8] = RAM_Samp_pek[8] | 0x40;
      }
    }
  }
  return;
}

```
