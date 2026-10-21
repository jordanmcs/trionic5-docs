# Function_0004B696

**ROM:** `0x0004B696`

```c

void Function_0004B696(undefined4 param_1)

{
  byte *pbVar1;
  ushort uVar2;
  ushort uVar3;
  undefined1 *extraout_A1;
  undefined2 uVar4;
  undefined2 uVar5;
  
  if (param_1._1_1_ == '\0') {
    DAT_00003524 = &DAT_00042f4c;
    DAT_0000349a = '\x01';
    DAT_000034ba = 0;
    DAT_000034c0 = 0;
  }
  pbVar1 = DAT_00003524;
  if (DAT_0000349a == '\x01') {
    DAT_00003520 = *DAT_00003524;
    if (DAT_00003520 == 0) {
      *DAT_00003524 = *DAT_00003524 + 1;
      DAT_00003520 = *pbVar1;
    }
    if (DAT_00003520 == 0x24) {
      DAT_0000349a = '\0';
      DAT_00003524 = &DAT_00052cda;
      uVar4 = 0xd;
      Function_0004ABC8();
      Function_0004ABC8(uVar4);
    }
    else {
      Function_0004ABC8();
      DAT_00003524 = DAT_00003524 + 1;
    }
  }
  else {
    DAT_00003520 = *DAT_00003524;
    DAT_000034c0 = DAT_000034c0 + 1;
    if (DAT_000034c0 < 8) {
      uVar2 = (ushort)DAT_00003520;
      DAT_000034b6 = Function_0006A75A();
      uVar3 = DAT_000034b6 >> 8;
      *extraout_A1 = (undefined1)DAT_000034b6;
      Function_0004ABC8(uVar2);
      Function_0004ABC8(uVar3);
      DAT_000034c0 = DAT_000034c0 + 1;
    }
    else {
      if (DAT_00003520 == 0) {
        DAT_00003524 = DAT_00003524 + 1;
        DAT_00003520 = *DAT_00003524;
        DAT_000034ba = DAT_000034ba + 1;
      }
      if (DAT_00003520 == 10) {
        DAT_000034c0 = 0;
      }
      Function_0004ABC8();
    }
    DAT_00003524 = DAT_00003524 + 1;
    DAT_000034ba = DAT_000034ba + 1;
    if ((ushort)(DAT_00003e62 + 1U) <= DAT_000034ba) {
      DAT_00003762 = 0;
      uVar5 = 0x45;
      Function_0004ABC8();
      uVar4 = 0x4e;
      Function_0004ABC8(uVar5);
      uVar5 = 0x44;
      Function_0004ABC8(uVar4);
      uVar4 = 0xd;
      Function_0004ABC8(uVar5);
      Function_0004ABC8(uVar4);
    }
  }
  return;
}

```
