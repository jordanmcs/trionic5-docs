# Function_00049C5E

**ROM:** `0x00049C5E`

```c

uint Function_00049C5E(void)

{
  ushort uVar2;
  undefined1 uVar3;
  uint uVar1;
  byte bVar4;
  code *extraout_A1;
  code *pcVar5;
  code *extraout_A1_00;
  code *extraout_A1_01;
  undefined4 *puVar6;
  
  uVar2 = Function_000493C2();
  if ((uVar2 & 1) == 1) {
    bVar4 = 0;
    pcVar5 = extraout_A1;
    puVar6 = &DAT_00003d94;
    do {
      uVar3 = (*pcVar5)();
      *(undefined1 *)puVar6 = uVar3;
      bVar4 = bVar4 + 1;
      pcVar5 = extraout_A1_00;
      puVar6 = (undefined4 *)((int)puVar6 + 1);
    } while (bVar4 < 2);
    uVar2 = (*extraout_A1_00)();
    if ((uVar2 & 0x40) == 0x40) {
      uVar1 = (*extraout_A1_01)();
      if (((ushort)uVar1 & 1) == 1) {
        uVar1 = uVar1 & 0xffff0000;
      }
      else {
        uVar1 = 5;
      }
    }
    else {
      uVar1 = 5;
    }
  }
  else {
    uVar1 = 5;
  }
  return uVar1;
}

```
