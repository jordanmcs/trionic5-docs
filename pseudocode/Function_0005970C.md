# Function_0005970C

**ROM:** `0x0005970C`

```c

void Function_0005970C(void)

{
  DAT_00004640 = DAT_0000464c & 0x3f | 0x80;
  DAT_00004641 = DAT_0000464d;
  if ((DAT_00001039 & 8) == 0) {
    DAT_0000463e = 0x57;
    DAT_00004642 = 0;
    DAT_00004643 = 0;
    DAT_0000463f = 4;
  }
  else if ((DAT_0000464c & 0xc0) == 0) {
    if ((DAT_0000464d & 0xf0) == 0) {
      DAT_0000463e = 0x45;
    }
    else if ((DAT_0000464d & 0xf0) == 0x10) {
      DAT_0000463e = 0x45;
    }
    else if ((DAT_0000464d & 0xf0) == 0x20) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_000038c2 = DAT_000038c2 | 0x40;
        DAT_0000463f = 2;
        DAT_00003fa4 = DAT_00003b02 + 10000;
        DAT_000038c4 = DAT_000038c4 | 4;
        DAT_0000463e = 0x57;
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
        if (DAT_0000464e < 0xb) {
          RAM_I_luft_st_._0_1_ = DAT_0000464e;
        }
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
  return;
}

```
