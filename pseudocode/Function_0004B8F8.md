# Function_0004B8F8

**ROM:** `0x0004B8F8`

```c

void Function_0004B8F8(byte *param_1)

{
  undefined2 uVar1;
  ushort uVar2;
  ushort uVar3;
  undefined2 *extraout_A1;
  
  if ((param_1 < &DAT_00001000) || ((byte *)0x7fff < param_1)) {
    DAT_0000373c = 0;
    DAT_0000373a = 0;
    DAT_00003762 = 0;
    DAT_00003760 = 0;
  }
  else {
    uVar2 = (ushort)*param_1;
    uVar1 = Function_0006A75A();
    *extraout_A1 = uVar1;
    DAT_0000348c = (byte)((ushort)*extraout_A1 >> 8);
    DAT_0000348a = *(undefined1 *)((int)extraout_A1 + 1);
    uVar3 = (ushort)DAT_0000348c;
    Function_0004ABC8(uVar2);
    Function_0004ABC8(uVar3);
  }
  return;
}

```
