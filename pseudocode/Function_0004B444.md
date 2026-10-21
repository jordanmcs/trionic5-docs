# Function_0004B444

**ROM:** `0x0004B444`

```c

void Function_0004B444(undefined4 param_1)

{
  short *extraout_A1;
  undefined2 uVar1;
  
  if (param_1._1_1_ == '\0') {
    DAT_0000354e = DAT_00003e90;
    DAT_0000354a = DAT_00003758;
  }
  if (DAT_0000354a == 0) {
    DAT_00003762 = 0;
    uVar1 = 0xd;
    Function_0004ABC8();
    Function_0004ABC8(uVar1);
  }
  else {
    Function_0004B8F8((short)DAT_0000354e);
    DAT_0000354e = DAT_0000354e + 1;
    *extraout_A1 = *extraout_A1 + -1;
  }
  return;
}

```
