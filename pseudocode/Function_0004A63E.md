# Function_0004A63E

**ROM:** `0x0004A63E`

```c

void Function_0004A63E(void)

{
  char *pcVar1;
  char *extraout_A1;
  char *extraout_A1_00;
  char *extraout_A1_01;
  char *extraout_A1_02;
  char *extraout_A1_03;
  char *extraout_A1_04;
  
  pcVar1 = &DAT_00003734;
  if (DAT_00003734 != 'Z') {
    if (DAT_00003734 == '(') {
      if ((DAT_00001039 & 4) == 0) {
        return;
      }
      DAT_00003e3a = DAT_00003b02 + (uint)DAT_00005b5a * 1000;
      DAT_00003734 = '2';
    }
    if (DAT_00003734 == '\0') {
      if ((((RAM_Start_kylv < DAT_00005b4a) || (DAT_00001077 < RAM_Ap_max_on_watertemp_)) ||
          (DAT_00005b44 < RAM_Start_kylv)) ||
         ((DAT_00005b42 < DAT_00001077 || ((DAT_00003736 & 0x40) != 0)))) {
        DAT_00003734 = 'Z';
      }
      else if ((DAT_00001039 & 8) != 0) {
        DAT_00003e3a = DAT_00003b02 + (uint)DAT_00005b52 * 100;
        DAT_00003730 = DAT_00003b02 + (uint)RAM_Ap_ign_step_ * 100;
        DAT_00003734 = '\n';
      }
    }
    if (DAT_00003734 == '\n') {
      if (DAT_00003b02 < DAT_00003e3a) {
        if (((DAT_00001039 & 4) != 0) || ((DAT_00003736 & 0x40) != 0)) {
          DAT_00003730 = 0x7fffffff;
          DAT_00003738 = 0;
          DAT_00003734 = '\0';
        }
      }
      else {
        Function_0004492E();
        DAT_00003736 = DAT_00003736 | 0x80;
        DAT_00003e3a = DAT_00003b02 + (uint)RAM_Max_vehicle_speed_ * 1000;
        DAT_00003e36 = DAT_00003b02 + (uint)DAT_00005b5c * 100;
        *extraout_A1 = '\x14';
        pcVar1 = extraout_A1;
      }
    }
    if (*pcVar1 == '\x14') {
      if (((DAT_00003b02 < DAT_00003e3a) && (DAT_00001066 <= DAT_00005b40)) &&
         (DAT_0000102e <= DAT_00005b46)) {
        if (((DAT_00001039 & 4) != 0) || ((DAT_00003736 & 0x40) != 0)) {
          Function_0004492E();
          DAT_00003730 = 0x7fffffff;
          DAT_00003736 = DAT_00003736 & 0x7f;
          DAT_00003738 = 0;
          *extraout_A1_01 = '\0';
          pcVar1 = extraout_A1_01;
        }
      }
      else {
        Function_0004492E();
        DAT_00003730 = 0x7fffffff;
        DAT_00003736 = DAT_00003736 & 0x7f | 0x20;
        DAT_00003e3a = DAT_00003b02 + (uint)DAT_00005b4c * 100;
        *extraout_A1_00 = '\x1e';
        pcVar1 = extraout_A1_00;
      }
    }
    if ((*pcVar1 == '\x1e') && (DAT_00003e3a <= DAT_00003b02)) {
      DAT_00003736 = DAT_00003736 & 0xdf;
      *pcVar1 = '(';
    }
    if (*pcVar1 == '2') {
      if (((((DAT_00001039 & 8) == 0) || (DAT_00003b02 < DAT_00003e3a)) ||
          (RAM_Ap_max_on_time2_ <= DAT_0000102e)) || ((DAT_00003736 & 0x40) != 0)) {
        if (((DAT_00003736 & 0x40) != 0) ||
           (((DAT_00001039 & 8) != 0 &&
            ((DAT_00003b02 < DAT_00003e3a || (RAM_Ap_max_on_time2_ <= DAT_0000102e)))))) {
          *pcVar1 = 'Z';
        }
      }
      else {
        DAT_00003e3a = DAT_00003b02 + (uint)DAT_00005b54 * 100;
        DAT_00003730 = DAT_00003b02 + (uint)RAM_Ap_ign_offset_delay_ * 100;
        *pcVar1 = '<';
      }
    }
    if (*pcVar1 == '<') {
      if (DAT_00003b02 < DAT_00003e3a) {
        if (((DAT_00001039 & 4) != 0) || ((DAT_00003736 & 0x40) != 0)) {
          DAT_00003730 = 0x7fffffff;
          DAT_00003e3a = DAT_00003b02;
          DAT_00003738 = 0;
          *pcVar1 = '2';
        }
      }
      else {
        Function_0004492E();
        DAT_00003736 = DAT_00003736 | 0x80;
        DAT_00003e3a = DAT_00003b02 + (uint)RAM_Ap_start_delay2_ * 1000;
        DAT_00003e36 = DAT_00003b02 + (uint)RAM_Ap_inj_factor_delay_ * 100;
        *extraout_A1_02 = 'F';
        pcVar1 = extraout_A1_02;
      }
    }
    if (*pcVar1 == 'F') {
      if ((DAT_00003b02 < DAT_00003e3a) && (DAT_00001066 <= DAT_00005b40)) {
        if (((DAT_00001039 & 4) != 0) || ((DAT_00003736 & 0x40) != 0)) {
          Function_0004492E();
          DAT_00003730 = 0x7fffffff;
          DAT_00003736 = DAT_00003736 & 0x7f;
          DAT_00003e3a = DAT_00003b02;
          DAT_00003738 = 0;
          *extraout_A1_04 = '2';
          pcVar1 = extraout_A1_04;
        }
      }
      else {
        Function_0004492E();
        DAT_00003730 = 0x7fffffff;
        DAT_00003736 = DAT_00003736 & 0x7f | 0x20;
        DAT_00003e3a = DAT_00003b02 + (uint)DAT_00005b4c * 100;
        *extraout_A1_03 = 'P';
        pcVar1 = extraout_A1_03;
      }
    }
    if ((*pcVar1 == 'P') && (DAT_00003e3a <= DAT_00003b02)) {
      DAT_00003736 = DAT_00003736 & 0xdf;
      *pcVar1 = 'Z';
    }
  }
  return;
}

```
