# Function_0006BC48

**ROM:** `0x0006BC48`

```c

void Function_0006BC48(void)

{
  if ((DAT_00001039 & 8) == 0) {
    if (DAT_00003a04 < 0x78) {
      DAT_00003a04 = DAT_00003a04 + 1;
    }
    else {
      DAT_00003a16 = 0;
      DAT_00003a82 = 0;
    }
  }
  else {
    DAT_00003a04 = 0;
  }
  return;
}

```
