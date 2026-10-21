# Function_00068F74

**ROM:** `0x00068F74`

```c

void Function_00068F74(void)

{
  if ((RAM_Samp_pek[0xb] & 0x40) == 0) {
    if (RAM_Sta_dmedel_min < RAM_Cat_ox2_dev_samp) {
      RAM_Sta_dmedel_min = RAM_Cat_ox2_dev_samp;
    }
    if ((uint)DAT_000046bc < (uint)RAM_Ign_counter3) {
      DAT_000046bc = RAM_Ign_counter3;
    }
    if (RAM_Sta_switch_min < DAT_00001999) {
      RAM_Sta_switch_min = (word)DAT_00001999;
    }
    if (RAM_Sta_sond_max < DAT_00001998) {
      RAM_Sta_sond_max = (word)DAT_00001998;
    }
    if ((short)RAM_Press_diff_medel < (short)RAM_Press_diff) {
      RAM_Press_diff_medel = RAM_Press_diff;
    }
    else if ((short)RAM_Press_diff < (short)RAM_Sta_dmedel_max) {
      RAM_Sta_dmedel_max = RAM_Press_diff;
    }
    if (DAT_0000469a < RAM_Ox2_change) {
      DAT_0000469a = RAM_Ox2_change;
    }
    if ((char)RAM_Sta_kylt_min < (char)DAT_0000102e) {
      RAM_Sta_kylt_min = DAT_0000102e;
    }
    if ((char)DAT_0000102e < (char)RAM_Sta_startp_min) {
      RAM_Sta_startp_min = DAT_0000102e;
    }
    if ((uint)RAM_Sta_kylt_max < (uint)RAM_Airpump_time) {
      RAM_Sta_kylt_max = RAM_Airpump_time;
    }
    if ((uint)RAM_Sta_kylt_max < (uint)DAT_00001ab0) {
      RAM_Sta_kylt_max = DAT_00001ab0;
    }
    if (DAT_000046a8 < DAT_00001ab4) {
      DAT_000046a8 = DAT_00001ab4;
    }
    if (DAT_000046a4 < DAT_00001ab8) {
      DAT_000046a4 = DAT_00001ab8;
    }
    if (RAM_Purge_adapt_cthr < DAT_000046a2) {
      DAT_000046a2 = RAM_Purge_adapt_cthr;
    }
    if (RAM_Purge_duty < RAM_Sta_othr_max) {
      RAM_Sta_othr_max = RAM_Purge_duty;
    }
    if ((char)RAM_Sta_cthr_max < (char)DAT_00003edc) {
      RAM_Sta_cthr_max = DAT_00003edc;
    }
    if ((char)DAT_00003edc < (char)DAT_0000469c) {
      DAT_0000469c = DAT_00003edc;
    }
    if (((DAT_00003ee6 & 0x40) != 0) && (DAT_00004696 < DAT_00001156)) {
      DAT_00004696 = DAT_00001156;
    }
    if (((DAT_00003ee6 & 0x40) != 0) && (DAT_00001156 < DAT_00004698)) {
      DAT_00004698 = DAT_00001156;
    }
    if (DAT_00004692 < RAM_Cat_ox1_duty_cycle) {
      DAT_00004692 = RAM_Cat_ox1_duty_cycle;
    }
    if (DAT_00004694 < RAM_U_lambda_eng) {
      DAT_00004694 = RAM_U_lambda_eng;
    }
  }
  if (DAT_00001136 != 0x50) {
    if (RAM_Sta_switch_max < DAT_00001136) {
      RAM_Sta_switch_max = DAT_00001136;
    }
    if (DAT_00001136 < RAM_Sta_startp_max) {
      RAM_Sta_startp_max = DAT_00001136;
    }
  }
  return;
}

```
