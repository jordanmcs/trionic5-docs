# Function_000754BC

**ROM:** `0x000754BC`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000754BC(void)

{
  byte *pbVar1;
  byte bVar2;
  
  if (((DAT_00fffc0c & 1) != 0) && ((DAT_00fffc0b & 0x80) != 0)) {
    if (DAT_00003aa0 == '\0') {
      DAT_000035fe = (byte *)0x0;
      DAT_00fffc0b = DAT_00fffc0b & 0x7f;
      DAT_000035fa = RAM_TDWFSVNX;
      DAT_00003a9e = 9;
    }
    else {
      _DAT_00fffc0e = (ushort)*DAT_000035fe;
      DAT_00003aa0 = DAT_00003aa0 + -1;
      DAT_000035fe = DAT_000035fe + 1;
    }
  }
  if ((((DAT_00fffc0d & 0x40) != 0) && ((DAT_00fffc0b >> 5 & 1) != 0)) &&
     ((char)DAT_00fffc0d < '\0')) {
    if ((_DAT_00fffc0e == 7) && ((short)(9 - (ushort)DAT_00003a9e) < 3)) {
      DAT_000035fa = RAM_TDWFSVNX;
      DAT_00003a9e = 9;
    }
    bVar2 = (byte)_DAT_00fffc0e;
    pbVar1 = DAT_000035fa + 1;
    *DAT_000035fa = bVar2;
    DAT_000035fa = pbVar1;
    DAT_00003a9e = DAT_00003a9e - 1;
    if (DAT_00003a9e == 0) {
      DAT_00fffc0b = DAT_00fffc0b & 0xdf;
    }
    else {
      DAT_000035f8 = bVar2 + DAT_000035f8;
    }
  }
  return;
}

```
