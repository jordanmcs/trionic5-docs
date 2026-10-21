# Function_00071D12

**ROM:** `0x00071D12`

```c

void Function_00071D12(void)

{
  if ((RAM_Ramp_steg_[3] & 8) == 0) {
    if ((((DAT_0000103a & 0x80) == 0) || ((DAT_0000103a & 0x40) == 0)) ||
       (((DAT_0000103a & 0x20) == 0 || ((DAT_0000103a & 0x10) == 0)))) {
      if ((DAT_00001137 & 0x20) == 0) {
        if (DAT_00001032 < 0x18) {
          DAT_00001074 = 0x1e;
        }
        else {
          DAT_00001074 = (short)(((uint)DAT_00001032 * 0x116) / 0x7f) + -0x15;
        }
      }
      else {
        DAT_00001074 = 0x1a;
      }
    }
    else {
      DAT_00001074 = 0xd;
    }
  }
  else if (((((DAT_0000103a & 0x80) == 0) || ((DAT_0000103a & 0x40) == 0)) ||
           ((DAT_0000103a & 0x20) == 0)) || ((DAT_0000103a & 0x10) == 0)) {
    if (DAT_00001032 < 0x13) {
      DAT_00001074 = 0x14;
    }
    else {
      DAT_00001074 = (short)(((uint)DAT_00001032 * 0x116) / 0x7f) + -0x15;
    }
  }
  else {
    DAT_00001074 = 0xd;
  }
  return;
}

```
