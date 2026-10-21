# Function_00058D16

**ROM:** `0x00058D16`

```c

void Function_00058D16(void)

{
  word wVar1;
  short sVar2;
  
  wVar1 = CONCAT11(DAT_00004642,DAT_00004643);
  DAT_00004640 = DAT_0000464c & 0x3f | 0x80;
  DAT_00004641 = DAT_0000464d;
  if ((DAT_0000464c & 0xc0) == 0xc0) {
    if ((DAT_0000464d & 0xf0) == 0) {
      if ((DAT_0000464d & 0xf) == 0) {
        if (DAT_0000102e < -0x28) {
          DAT_00004642 = 0;
        }
        else {
          DAT_00004642 = DAT_00004736 + 0x28;
        }
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 1) {
        if ((char)RAM_Last < -0x28) {
          DAT_00004642 = 0;
        }
        else {
          DAT_00004642 = DAT_000046e6 + 0x28;
        }
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x10) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = (byte)(DAT_00003e24 / 10);
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 1) {
        DAT_00004642 = (char)((short)(ushort)DAT_00001031 >> 2) + 0x60;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 2) {
        DAT_00004642 = RAM_Start_detekt_nr_;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 3) {
        DAT_00004642 = DAT_00003edc;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x20) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = RAM_Bil_hast;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else {
        if ((DAT_0000464d & 0xf) == 1) {
          DAT_0000463f = 4;
          DAT_0000463e = 0x57;
          wVar1 = DAT_0000405c;
        }
        else if ((DAT_0000464d & 0xf) == 2) {
          DAT_0000463f = 4;
          DAT_0000463e = 0x57;
          wVar1 = DAT_0000405a;
        }
        else if ((DAT_0000464d & 0xf) == 3) {
          DAT_0000463f = 4;
          DAT_0000463e = 0x57;
          wVar1 = RAM_C200_max;
        }
        else if ((DAT_0000464d & 0xf) == 4) {
          DAT_0000463f = 4;
          DAT_0000463e = 0x57;
          wVar1 = DAT_000010de;
        }
        else if ((DAT_0000464d & 0xf) == 5) {
          DAT_0000463f = 4;
          DAT_0000463e = 0x57;
          wVar1 = DAT_000010e0;
        }
        else if ((DAT_0000464d & 0xf) == 6) {
          DAT_0000463f = 4;
          DAT_0000463e = 0x57;
          wVar1 = DAT_000010e2;
        }
        else {
          DAT_0000463e = 0x45;
        }
        DAT_00004642 = (byte)(wVar1 >> 8);
        DAT_00004643 = (undefined1)wVar1;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x30) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = DAT_00001015;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x40) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = (byte)((ushort)DAT_00003e2c >> 8);
        DAT_00004643 = (undefined1)DAT_00003e2c;
        DAT_0000463f = 4;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 1) {
        DAT_00004642 = (byte)DAT_0000112c;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 2) {
        DAT_00004642 = (byte)((ushort)DAT_00003e2a >> 8);
        DAT_00004643 = (undefined1)DAT_00003e2a;
        DAT_0000463f = 4;
        DAT_0000463e = 0x57;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x50) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = (byte)(DAT_00003b72 >> 6);
        DAT_00004643 = (undefined1)(DAT_00003b72 << 2);
        DAT_0000463f = 4;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 1) {
        DAT_00004642 = DAT_0000101c;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else {
        DAT_0000463e = 0x45;
      }
    }
    else if ((DAT_0000464d & 0xf0) == 0x60) {
      if ((DAT_0000464d & 0xf) == 0) {
        DAT_00004642 = Function_00044550();
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 1) {
        sVar2 = Function_00044B86();
        if (sVar2 == 0x4e) {
          DAT_00004642 = 0x44;
        }
        else {
          DAT_00004642 = 0x4e;
        }
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 2) {
        DAT_00004642 = Function_00044BA4();
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 3) {
        DAT_00004642 = Function_00044C00();
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 4) {
        sVar2 = Function_00044BBC();
        DAT_00004642 = sVar2 == 0;
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 5) {
        DAT_00004642 = Function_000448EE();
        DAT_0000463f = 3;
        DAT_0000463e = 0x57;
      }
      else if ((DAT_0000464d & 0xf) == 6) {
        DAT_00004642 = Function_0004A4D2();
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
