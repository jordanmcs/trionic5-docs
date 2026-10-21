# Function_0005A0CC

**ROM:** `0x0005A0CC`

```c

void Function_0005A0CC(void)

{
  DAT_00004640 = DAT_0000464c & 0x3f | 0x80;
  DAT_00004641 = DAT_0000464d;
  if ((DAT_0000464c & 0xc0) == 0xc0) {
    if ((DAT_0000464d & 0xf0) == 0) {
      if ((DAT_0000464d & 0xf) == 0) {
        if ((DAT_00006e20 & 0x20) == 0) {
          DAT_00004642 = DAT_00003ee6 >> 7;
        }
        else {
          DAT_00004642 = RAM_Samp_pek[0xd] & 4;
        }
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 1) {
        DAT_00004642 = RAM_n_Engine_delta_180[1] >> 3 & 1;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 2) {
        DAT_00004642 = RAM_Samp_pek[8] & 0x40;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 3) {
        DAT_00004642 = RAM_Samp_pek[8] & 0x10;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 4) {
        DAT_00004642 = RAM_Samp_pek[0xe] & 2;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 5) {
        DAT_00004642 = DAT_00003fe8 >> 7;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x10) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = DAT_0000103c & 2;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x20) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = RAM_Ign_angle_byte != 0;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x30) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = RAM_Medeltryck != 0;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 1) {
        DAT_00004642 = (DAT_00003fa2 & 0x80) == 0x80;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 2) {
        DAT_00004642 = (DAT_00003fa2 & 0x40) == 0x40;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 3) {
        DAT_00004642 = (DAT_00003fa2 & 0x20) == 0x20;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 4) {
        DAT_00004642 = (DAT_00003fa2 & 0x10) == 0x10;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 5) {
        DAT_00004642 = (DAT_00003fa2 & 8) == 8;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 6) {
        DAT_00004642 = (DAT_00003fa2 & 4) == 4;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x40) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = RAM_PWM_ut10;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 5) {
        DAT_00004642 = (DAT_0000103a & 4) == 4;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x50) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = RAM_STSWFS;
        DAT_0000463f = 3;
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
