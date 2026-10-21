# Function_0005EC68

**ROM:** `0x0005EC68`

```c

void Function_0005EC68(void)

{
  if ((RAM_Samp_pek[8] & 2) == 0) {
    if ((DAT_00001039 & 8) == 0) {
      DAT_000034d6 = 0;
      DAT_000034d8 = 0;
      RAM_Idle_reknare = 0;
    }
    else if ((RAM_Idle_reknare & 0x40) == 0) {
      if (((DAT_00001137 & 0x20) == 0) || ((DAT_0000103c & 2) == 0)) {
        RAM_Idle_reknare = RAM_Idle_reknare & 0xef;
      }
      else if ((RAM_Idle_reknare & 0x20) == 0) {
        if (RAM_Cat_ox1_duty_cycle < 0x1b8) {
          RAM_Idle_reknare = RAM_Idle_reknare | 0x10;
          DAT_000034d6 = 0;
        }
        else if ((RAM_Cat_ox1_duty_cycle < 0x1b9) || ((RAM_Idle_reknare & 0x10) == 0)) {
          if ((RAM_Idle_reknare & 0x10) != 0) {
            DAT_000034d6 = DAT_000034d6 + 1;
          }
        }
        else {
          if (DAT_000060a0 < DAT_000034d6) {
            DAT_000034d8 = DAT_000034d8 + 1;
          }
          else {
            DAT_000034d8 = 0;
            RAM_Idle_reknare = RAM_Idle_reknare | 0x20;
          }
          if (10 < DAT_000034d8) {
            RAM_Idle_reknare = RAM_Idle_reknare | 0xc0;
          }
          RAM_Idle_reknare = RAM_Idle_reknare & 0xef;
        }
      }
      else if (RAM_Cat_ox1_duty_cycle < 0x1b9) {
        if ((RAM_Cat_ox1_duty_cycle < 0x1b8) && ((RAM_Idle_reknare & 0x10) != 0)) {
          if (DAT_000060a0 < DAT_000034d6) {
            DAT_000034d8 = DAT_000034d8 + 1;
          }
          else {
            RAM_Idle_reknare = RAM_Idle_reknare | 0x40;
          }
          if (10 < DAT_000034d8) {
            RAM_Idle_reknare = RAM_Idle_reknare | 0xc0;
          }
          RAM_Idle_reknare = RAM_Idle_reknare & 0xef;
        }
        else if ((RAM_Idle_reknare & 0x10) != 0) {
          DAT_000034d6 = DAT_000034d6 + 1;
        }
      }
      else {
        RAM_Idle_reknare = RAM_Idle_reknare | 0x10;
        DAT_000034d6 = 0;
      }
    }
  }
  Function_0005EDB0();
  return;
}

```
