# Function_0006967E

**ROM:** `0x0006967E`

```c

byte Function_0006967E(void)

{
  byte bVar1;
  byte bVar2;
  
  if (RAM_Trot_delta < DAT_00001015) {
    DAT_000035ee = DAT_00001015 - RAM_Trot_delta;
  }
  else {
    DAT_000035ee = '\0';
  }
  RAM_LLS_styr = Function_00072972(&DAT_00004f1c,&DAT_00004f24,&DAT_00004edc);
  bVar2 = RAM_LLS_styr;
  bVar1 = RAM_LLS_styr;
  if ((((RAM_LLS_styr <= RAM_Dash_tab_value) &&
       (bVar1 = RAM_Dash_tab_value, RAM_LLS_styr < RAM_Dash_tab_value)) &&
      (bVar1 = RAM_LLS_styr, RAM_Dash_rpm_axis_ <= RAM_Dash_tab_value)) &&
     (bVar2 = RAM_Dash_tab_value - RAM_Dash_rpm_axis_, bVar1 = bVar2, bVar2 < RAM_LLS_styr)) {
    bVar1 = RAM_LLS_styr;
  }
  RAM_Dash_tab_value = bVar1;
  if ((RAM_Ramp_steg_[3] & 8) == 0) {
    if ((RAM_LLS_styr < RAM_Dash_tab_value) || (bVar2 = DAT_0000103a & 4, bVar2 == 0)) {
      DAT_0000103d = DAT_0000103d & 0xef;
      DAT_000046c8 = RAM_Idle_start_extra_value + RAM_Dash_tab_value;
      if (0x270 < DAT_000046c8) {
        DAT_000046c8 = 0x270;
      }
      if (((DAT_000038c2 & 0x10) == 0) && ((RAM_Samp_pek[0] & 0x20) == 0)) {
        bVar2 = Function_000709D4();
      }
      DAT_0000103d = DAT_0000103d | 8;
    }
    else {
      DAT_0000103d = DAT_0000103d & 0xf7 | 0x10;
    }
  }
  else if ((DAT_0000103a & 4) == 0) {
    DAT_000046ca = DAT_00003b02;
    DAT_0000103d = DAT_0000103d & 0xef;
  }
  else if (DAT_00003b02 < DAT_000046ca + 2000) {
    DAT_0000103d = DAT_0000103d & 0xef;
  }
  else {
    DAT_0000103d = DAT_0000103d | 0x10;
  }
  return bVar2;
}

```
