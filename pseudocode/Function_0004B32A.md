# Function_0004B32A

**ROM:** `0x0004B32A`

```c

void Function_0004B32A(undefined4 param_1)

{
  short *extraout_A1;
  undefined2 uVar1;
  
  if (param_1._1_1_ == '\0') {
    DAT_000034a4 = DAT_00003e9c;
    DAT_000034a2 = DAT_0000375e;
  }
  if (DAT_000034a2 == 0) {
    DAT_00003762 = 0;
    uVar1 = 0xd;
    Function_0004ABC8();
    Function_0004ABC8(uVar1);
  }
  else {
    Function_0004B8F8((short)DAT_000034a4);
    DAT_000034a4 = DAT_000034a4 + 1;
    *extraout_A1 = *extraout_A1 + -1;
  }
  return;
}

```
