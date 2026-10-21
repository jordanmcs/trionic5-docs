# Function_0006944C

**ROM:** `0x0006944C`

```c

void Function_0006944C(void)

{
  if (DAT_00003508 < 3) {
    DAT_00003508 = DAT_00003508 + 1;
  }
  else {
    DAT_00001a58 = DAT_00001a58 + 1;
    if (DAT_00003336 < 0x3b) {
      DAT_00003336 = DAT_00003336 + 1;
    }
    else {
      DAT_00003336 = 0;
      if (DAT_00003335 < 0x3b) {
        DAT_00003335 = DAT_00003335 + 1;
      }
      else {
        DAT_00003335 = 0;
        if (DAT_00003464 < 65000) {
          DAT_00003464 = DAT_00003464 + 1;
        }
      }
    }
    DAT_00003508 = '\0';
  }
  return;
}

```
