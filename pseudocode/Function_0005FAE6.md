# Function_0005FAE6

**ROM:** `0x0005FAE6`

```c

uint Function_0005FAE6(void)

{
  uint uVar1;
  
  uVar1 = DAT_0000464c & 0xffffff0f | 0x40;
  DAT_00004640 = DAT_0000464c & 0xf | 0x40;
  DAT_00004641 = DAT_0000464d;
  if (DAT_0000464d < 0x20) {
    if (DAT_0000464d == 0) {
      uVar1 = RAM_Ramp_steg_[1] & 0xffffff40;
      if ((RAM_Ramp_steg_[1] & 0x40) == 0) {
        DAT_0000463e = 0x4f;
        DAT_00004643 = 0x90;
        DAT_00004644 = 0;
        DAT_00004645 = 0;
        DAT_00004646 = 1;
        DAT_00004642 = 0xff;
        DAT_0000463f = 7;
      }
      else {
        DAT_0000463e = 0x4f;
        DAT_00004643 = 0x70;
        DAT_00004644 = 0;
        DAT_00004645 = 0;
        DAT_00004646 = 1;
        DAT_00004642 = 0xff;
        DAT_0000463f = 7;
      }
    }
    else if (DAT_0000464d == 1) {
      DAT_0000463e = 0x4f;
      DAT_00004642 = 4;
      DAT_00004643 = (undefined1)((ushort)DAT_00003ee4 >> 8);
      DAT_00004644 = (undefined1)DAT_00003ee4;
      uVar1 = (uint)(DAT_000074d8 >> 8);
      DAT_00004645 = (undefined1)(DAT_000074d8 >> 8);
      DAT_00004646 = (undefined1)DAT_000074d8;
      DAT_0000463f = 7;
    }
    else if (DAT_0000464d == 2) {
      DAT_0000463e = 0x4f;
      DAT_00004642 = 4;
      DAT_00004643 = (undefined1)((uint)DAT_00003eb6 >> 8);
      DAT_00004644 = (undefined1)DAT_00003eb6;
      uVar1 = DAT_0000751e >> 8;
      DAT_00004645 = (undefined1)(DAT_0000751e >> 8);
      DAT_00004646 = (undefined1)DAT_0000751e;
      DAT_0000463f = 7;
    }
    else if (DAT_0000464d == 3) {
      DAT_0000463e = 0x4f;
      DAT_00004642 = 0x84;
      DAT_00004643 = (undefined1)((uint)DAT_00003eb2 >> 8);
      DAT_00004644 = (undefined1)DAT_00003eb2;
      uVar1 = DAT_00007522 >> 8;
      DAT_00004645 = (undefined1)(DAT_00007522 >> 8);
      DAT_00004646 = (undefined1)DAT_00007522;
      DAT_0000463f = 7;
    }
    else if (DAT_0000464d == 4) {
      DAT_0000463e = 0x4f;
      DAT_00004642 = 1;
      DAT_00004643 = (undefined1)((ushort)DAT_00003eec >> 8);
      DAT_00004644 = (undefined1)DAT_00003eec;
      uVar1 = (uint)(DAT_000074a2 >> 8);
      DAT_00004645 = (undefined1)(DAT_000074a2 >> 8);
      DAT_00004646 = (undefined1)DAT_000074a2;
      DAT_0000463f = 7;
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else if (DAT_0000464d < 0x40) {
    if (DAT_0000464d == 0x20) {
      DAT_0000463e = 0x4f;
      DAT_00004642 = 0xff;
      DAT_00004643 = 0;
      DAT_00004644 = 0;
      DAT_00004645 = 0;
      DAT_00004646 = 1;
      DAT_0000463f = 7;
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else if (DAT_0000464d < 0x60) {
    if (DAT_0000464d == 0x40) {
      DAT_0000463e = 0x4f;
      DAT_00004642 = 0xff;
      DAT_00004643 = 0;
      DAT_00004644 = 0;
      DAT_00004645 = 0;
      DAT_00004646 = 1;
      DAT_0000463f = 7;
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else if (DAT_0000464d < 0x80) {
    if (DAT_0000464d == 0x60) {
      DAT_0000463e = 0x4f;
      DAT_00004642 = 0xff;
      DAT_00004643 = 0;
      DAT_00004644 = 0;
      DAT_00004645 = 0;
      DAT_00004646 = 1;
      DAT_0000463f = 7;
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else if (DAT_0000464d < 0xa0) {
    if (DAT_0000464d == 0x80) {
      DAT_0000463e = 0x4f;
      DAT_00004642 = 0xff;
      DAT_00004643 = 0;
      DAT_00004644 = 0;
      DAT_00004645 = 0;
      DAT_00004646 = 1;
      DAT_0000463f = 7;
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else if (DAT_0000464d < 0xc0) {
    if (DAT_0000464d == 0xa0) {
      DAT_0000463e = 0x4f;
      DAT_00004642 = 0xff;
      DAT_00004643 = 0;
      DAT_00004644 = 0;
      DAT_00004645 = 0;
      DAT_00004646 = 1;
      DAT_0000463f = 7;
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else if (DAT_0000464d < 0xe0) {
    if (DAT_0000464d == 0xc0) {
      DAT_0000463e = 0x4f;
      DAT_00004642 = 0xff;
      DAT_00004643 = 0;
      DAT_00004644 = 0;
      DAT_00004645 = 0;
      DAT_00004646 = 1;
      DAT_0000463f = 7;
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else if (DAT_0000464d == 0xe0) {
    DAT_0000463e = 0x4f;
    DAT_00004642 = 0xff;
    DAT_00004643 = 0;
    DAT_00004644 = 0;
    DAT_00004645 = 0;
    DAT_00004646 = 0;
    DAT_0000463f = 7;
  }
  else {
    DAT_0000463e = 0x45;
  }
  return uVar1;
}

```
