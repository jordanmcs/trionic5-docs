# Function_0004B3E6

**ROM:** `0x0004B3E6`

```c

void Function_0004B3E6(undefined4 param_1)

{
  short *extraout_A1;
  undefined2 uVar1;
  
  if (param_1._1_1_ == '\0') {
    DAT_000035a2 = DAT_00003e94;
    DAT_00003554 = DAT_0000375a;
  }
  if (DAT_00003554 == 0) {
    DAT_00003762 = 0;
    uVar1 = 0xd;
    Function_0004ABC8();
    Function_0004ABC8(uVar1);
  }
  else {
    Function_0004B8F8((short)DAT_000035a2);
    DAT_000035a2 = DAT_000035a2 + 1;
    *extraout_A1 = *extraout_A1 + -1;
  }
  return;
}

```
