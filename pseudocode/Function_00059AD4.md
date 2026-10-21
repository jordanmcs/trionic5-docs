# Function_00059AD4

**ROM:** `0x00059AD4`

```c

void Function_00059AD4(void)

{
  DAT_00004640 = DAT_0000464c & 0x3f | 0x80;
  DAT_00004641 = DAT_0000464d;
  if ((DAT_00001039 & 8) == 0) {
    if ((DAT_0000464c & 0xc0) == 0) {
      if ((DAT_0000464d & 0xf0) == 0) {
        if ((DAT_0000464d & 0xf) == 0) {
          DAT_000038c3 = DAT_000038c3 | 0x80;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else if ((DAT_0000464d & 0xf) == 1) {
          DAT_000038c3 = DAT_000038c3 | 0x40;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else if ((DAT_0000464d & 0xf) == 2) {
          DAT_000038c3 = DAT_000038c3 | 0x20;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else if ((DAT_0000464d & 0xf) == 3) {
          DAT_000038c3 = DAT_000038c3 | 0x10;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else {
          DAT_0000463e = 0x45;
        }
      }
      else if ((DAT_0000464d & 0xf0) == 0x10) {
        if ((DAT_0000464d & 0xf) == 0) {
          DAT_000038c3 = DAT_000038c3 | 8;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else if ((DAT_0000464d & 0xf) == 1) {
          DAT_000038c3 = DAT_000038c3 | 4;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else if ((DAT_0000464d & 0xf) == 2) {
          DAT_000038c3 = DAT_000038c3 | 2;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else if ((DAT_0000464d & 0xf) == 3) {
          DAT_000038c3 = DAT_000038c3 | 1;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else {
          DAT_0000463e = 0x45;
        }
      }
      else if ((DAT_0000464d & 0xf0) == 0x20) {
        if ((DAT_0000464d & 0xf) == 0) {
          DAT_000038c2 = DAT_000038c2 | 0x40;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
        }
        else if ((DAT_0000464d & 0xf) == 1) {
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x90;
        }
        else if ((DAT_0000464d & 0xf) == 2) {
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0xa0;
        }
        else if ((DAT_0000464d & 0xf) == 3) {
          DAT_000038c5 = DAT_000038c5 | 0x40;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else {
          DAT_0000463e = 0x45;
        }
      }
      else if ((DAT_0000464d & 0xf0) == 0x30) {
        DAT_0000463e = 0x45;
      }
      else if ((DAT_0000464d & 0xf0) == 0x40) {
        if ((DAT_0000464d & 0xf) == 0) {
          DAT_000038c2 = DAT_000038c2 | 8;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
        }
        else if ((DAT_0000464d & 0xf) == 1) {
          DAT_000038c2 = DAT_000038c2 | 4;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
        }
        else if ((DAT_0000464d & 0xf) == 2) {
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 0x24;
          DAT_0000463e = 0x57;
        }
        else if ((DAT_0000464d & 0xf) == 3) {
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 0xc;
          DAT_0000463e = 0x57;
        }
        else if ((DAT_0000464d & 0xf) == 4) {
          DAT_000038c2 = DAT_000038c2 | 1;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
        }
        else if ((DAT_0000464d & 0xf) == 5) {
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 0x84;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else if ((DAT_0000464d & 0xf) == 6) {
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 0x44;
          DAT_0000463e = 0x57;
          DAT_000038c2 = DAT_000038c2 | 0x80;
        }
        else if ((DAT_0000464d & 0xf) == 7) {
          DAT_000038c5 = DAT_000038c5 | 0x80;
          DAT_0000463f = 2;
          DAT_00003fa4 = DAT_00003b02 + 10000;
          DAT_000038c4 = DAT_000038c4 | 4;
          DAT_0000463e = 0x57;
        }
        else if ((DAT_0000464d & 0xf) == 8) {
          if ((RAM_Ramp_steg_[3] & 8) == 0) {
            RAM_Trot_delta = RAM_P_Manifold10;
          }
          DAT_0000463f = 2;
          DAT_0000463e = 0x57;
        }
        else if ((DAT_0000464d & 0xf) == 9) {
          RAM_Derivata_rpm = 0;
          DAT_0000463f = 2;
          DAT_0000463e = 0x57;
        }
        else {
          DAT_0000463e = 0x45;
        }
      }
      else if ((DAT_0000464d & 0xf0) == 0x50) {
        if ((DAT_0000464d & 0xf) == 0) {
          DAT_0000376c = 1;
          DAT_0000463f = 2;
          DAT_0000463e = 0x57;
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
  }
  else {
    DAT_0000463e = 0x57;
    DAT_00004642 = 0;
    DAT_00004643 = 0;
    DAT_0000463f = 4;
  }
  return;
}

```
