# Function_000592B8

**ROM:** `0x000592B8`

```c

void Function_000592B8(void)

{
  DAT_00004640 = DAT_0000464c & 0x3f | 0x80;
  DAT_00004641 = DAT_0000464d;
  if ((DAT_0000464c & 0xc0) == 0xc0) {
    if (DAT_0000464d == -1) {
      DAT_0000463f = 2;
      DAT_0000463e = 0x44;
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
