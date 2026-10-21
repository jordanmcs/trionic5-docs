# Function_00071CEC

**ROM:** `0x00071CEC`

```c

void Function_00071CEC(void)

{
  if (DAT_00007640 < DAT_00001066) {
    DAT_00001039 = DAT_00001039 | 0x80;
  }
  else {
    DAT_00001039 = DAT_00001039 & 0x7f;
  }
  return;
}

```
