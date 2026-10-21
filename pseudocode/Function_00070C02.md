# Function_00070C02

**ROM:** `0x00070C02`

```c

void Function_00070C02(void)

{
  if ((DAT_00001039 & 8) == 0) {
    if ((RAM_Purge_status & 8) != 0) {
      DAT_0000115c = Function_0006A314(&DAT_00006060,&DAT_00006068,8);
      DAT_0000476e = Function_0006A314(&DAT_00006060,RAM_Idle_start_extra_sp_,
                                       CONCAT22((short)DAT_0000102e,8));
      DAT_00003564 = 0;
    }
  }
  else {
    RAM_Purge_status = RAM_Purge_status & 0xf7;
    if (DAT_0000115c != 0) {
      if (DAT_00003564 < DAT_0000476e) {
        DAT_00003564 = DAT_00003564 + 1;
      }
      else {
        DAT_0000115c = DAT_0000115c + -1;
        DAT_00003564 = 0;
      }
    }
  }
  return;
}

```
