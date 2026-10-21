# Function_00072F56

**ROM:** `0x00072F56`

```c

void Function_00072F56(void)

{
  if (((DAT_0000101c < 0x38) && (0x2c < DAT_0000101c)) &&
     ((RAM_PWM_ut10 == 2 || ((RAM_Ramp_steg_[3] & 2) != 0)))) {
    if (DAT_00001015 < 0x55) {
      if (DAT_000047e0 < DAT_00005eae) {
        DAT_000047e0 = DAT_000047e0 + 1;
      }
      else {
        RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ | 0x80;
      }
    }
    else {
      DAT_000047e0 = 0;
    }
  }
  else {
    RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ & 0x7f;
    DAT_000047e0 = 0;
  }
  if ((RAM_Spik_count._0_1_ & 0xc0) == 0) {
    DAT_000047de = 0;
  }
  else if (DAT_00001015 < 0xbf) {
    RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ & 0xbf;
  }
  else if (DAT_000047de < RAM_Apc_konst_tid_) {
    RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ | 0x40;
    DAT_000047de = DAT_000047de + 1;
  }
  else {
    RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ & 0xbf;
  }
  return;
}

```
