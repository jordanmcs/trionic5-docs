# Function_000435EA

**ROM:** `0x000435EA`

```c

void Function_000435EA(void)

{
  if (DAT_00003ace == 0) {
    DAT_00003608 = 0xffff;
  }
  else {
    DAT_00003608 = (undefined2)(((uint)DAT_00003b72 * 10) / (uint)DAT_00003ace);
  }
  return;
}

```
