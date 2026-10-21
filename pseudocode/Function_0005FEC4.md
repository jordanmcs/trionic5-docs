# Function_0005FEC4

**ROM:** `0x0005FEC4`

```c

void Function_0005FEC4(void)

{
  DAT_00004640 = DAT_0000464c & 0xf | 0x40;
  DAT_00004641 = DAT_0000464d;
  DAT_00004642 = DAT_0000464e;
  if (DAT_0000464e == '\0') {
    if (DAT_0000464d < 0x10) {
      if (DAT_0000464d == 0) {
        RAM_Cat_fc_timer[0] = 0x7e;
        RAM_Cat_fc_timer[1] = 0x38;
        RAM_Cat_fc_timer[2] = 0;
        RAM_Cat_fc_timer[3] = 0;
        DAT_00004643 = 0x7e;
        DAT_00004644 = 0x38;
        DAT_00004645 = 0;
        DAT_00004646 = 0;
        DAT_0000463f = 7;
        DAT_0000463e = 0x4f;
      }
      else if (DAT_0000464d == 2) {
        DAT_00004643 = SUB21(RAM_Cat_fc_timer._4_2_,1);
        DAT_00004644 = RAM_Cat_fc_timer[5];
        DAT_0000463f = 5;
        DAT_0000463e = 0x4f;
      }
      else if (DAT_0000464d == 3) {
        DAT_00004643 = RAM_Cat_fc_timer[6];
        DAT_00004644 = RAM_Cat_fc_timer[7];
        DAT_0000463f = 5;
        DAT_0000463e = 0x4f;
      }
      else if (DAT_0000464d == 4) {
        DAT_00004643 = RAM_Cat_fc_timer[8];
        DAT_0000463f = 4;
        DAT_0000463e = 0x4f;
      }
      else if (DAT_0000464d == 5) {
        DAT_00004643 = RAM_Cat_fc_timer[9];
        DAT_0000463f = 4;
        DAT_0000463e = 0x4f;
      }
      else if (DAT_0000464d == 6) {
        DAT_00004643 = RAM_Cat_fc_timer[10];
        DAT_0000463f = 4;
        DAT_0000463e = 0x4f;
      }
      else if (DAT_0000464d == 7) {
        DAT_00004643 = RAM_Cat_fc_timer[0xb];
        DAT_0000463f = 4;
        DAT_0000463e = 0x4f;
      }
      else if (DAT_0000464d == 0xb) {
        DAT_00004643 = RAM_Cat_fc_timer[0xc];
        DAT_0000463f = 4;
        DAT_0000463e = 0x4f;
      }
      else if (DAT_0000464d == 0xc) {
        DAT_00004643 = SUB21(RAM_Cat_fc_timer._14_2_,1);
        DAT_00004644 = RAM_Cat_fc_timer[0xf];
        DAT_0000463f = 5;
        DAT_0000463e = 0x4f;
      }
      else if (DAT_0000464d == 0xd) {
        DAT_00004643 = RAM_Cat_fc_timer[0x10];
        DAT_0000463f = 4;
        DAT_0000463e = 0x4f;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else {
    DAT_0000463e = 0x45;
  }
  return;
}

```
