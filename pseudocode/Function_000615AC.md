# Function_000615AC

**ROM:** `0x000615AC`

```c

void Function_000615AC(void)

{
  if (DAT_00003b72 < 400) {
    DAT_00003b78 = 1;
  }
  else if (DAT_00003b72 < (ushort)(DAT_00001160 * 10)) {
    if (DAT_00003b78 == '\x01') {
      DAT_00003b78 = 1;
    }
    else {
      DAT_00003b78 = 0;
    }
  }
  else {
    DAT_00003b78 = 0;
  }
  return;
}

```
