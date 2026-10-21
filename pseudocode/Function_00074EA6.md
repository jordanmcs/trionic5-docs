# Function_00074EA6

**ROM:** `0x00074EA6`

```c

void Function_00074EA6(void)

{
  ushort uVar1;
  
  uVar1 = DAT_000047fc;
  if (DAT_00003a8c == '\x01') {
    if ((DAT_0000103c & 0x80) == 0x80) {
      if (DAT_00003a8e == '\0') {
        DAT_000047f4 = DAT_00003b02;
        DAT_00003a8e = '\x01';
        DAT_00003a90 = '\0';
        DAT_00004800 = (ushort)((DAT_00003b02 - DAT_000047f8) / 100);
        if (DAT_00004804 < DAT_00004800) {
          DAT_00004804 = DAT_00004800;
        }
        if (DAT_00004800 < DAT_00004802) {
          DAT_00004802 = DAT_00004800;
        }
        uVar1 = DAT_000047fc + 1;
        if (uVar1 != 0) {
          DAT_000047fe = (ushort)(DAT_00004800 + DAT_000047fc * DAT_000047fe) / uVar1;
        }
      }
    }
    else if (DAT_00003a90 == '\0') {
      DAT_00003a8e = '\0';
      DAT_00003a90 = '\x01';
      DAT_000047f8 = DAT_00003b02;
    }
  }
  DAT_000047fc = uVar1;
  return;
}

```
