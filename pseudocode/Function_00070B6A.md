# Function_00070B6A

**ROM:** `0x00070B6A`

```c

void Function_00070B6A(void)

{
  if ((((DAT_00001066 < 0x96) && (0x6e < DAT_00001066)) && ((DAT_00001137 & 0x20) == 0)) &&
     ((DAT_0000103a & 4) != 0)) {
    if (DAT_0000477e < DAT_00004f90) {
      if (DAT_00003a6c < RAM_Max_adjust_load_adapt_) {
        DAT_00003a6c = DAT_00003a6c + 1;
      }
      else {
        DAT_000051c6 = DAT_000051c6 + -1;
        DAT_0000477e = DAT_0000477e + 1;
        DAT_00003a6c = 0;
      }
    }
  }
  else {
    DAT_00003a6c = 0;
    if (((DAT_00001137 & 0x20) != 0) || ((DAT_0000103a & 4) == 0)) {
      DAT_000051c6 = DAT_0000477c;
      DAT_0000477e = 0;
    }
  }
  return;
}

```
