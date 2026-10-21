# Function_0004B7EC

**ROM:** `0x0004B7EC`

```c

void Function_0004B7EC(undefined4 param_1)

{
  char *pcVar1;
  undefined2 uVar2;
  
  if (param_1._1_1_ == '\0') {
    DAT_000034ee = &DAT_00042f4c;
    DAT_00003498 = '\x01';
  }
  pcVar1 = DAT_000034ee;
  if (DAT_00003498 == '\x01') {
    DAT_000034ea = *DAT_000034ee;
    if (DAT_000034ea == '\0') {
      *DAT_000034ee = *DAT_000034ee + '\x01';
      DAT_000034ea = *pcVar1;
    }
    if (DAT_000034ea == '$') {
      DAT_00003762 = 0;
      DAT_00003498 = '\0';
      uVar2 = 0xd;
      Function_0004ABC8();
      Function_0004ABC8(uVar2);
    }
    else {
      Function_0004ABC8();
      DAT_000034ee = DAT_000034ee + 1;
    }
  }
  return;
}

```
