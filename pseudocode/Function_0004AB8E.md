# Function_0004AB8E

**ROM:** `0x0004AB8E`

```c

void Function_0004AB8E(int *param_1)

{
  uint uVar1;
  ushort uVar2;
  short sVar4;
  int *piVar5;
  undefined1 *puVar6;
  int iVar3;
  
  for (; iVar3 = *param_1, iVar3 != 0; param_1 = (int *)((int)param_1 + (uVar1 & 0xfffffffe) + 8)) {
    uVar1 = iVar3 + 1;
    piVar5 = param_1 + 2;
    puVar6 = (undefined1 *)param_1[1];
    while( true ) {
      uVar2 = (ushort)((uint)iVar3 >> 0x10);
      sVar4 = (short)iVar3 + -1;
      iVar3 = CONCAT22(uVar2,sVar4);
      if ((sVar4 == -1) && (iVar3 = (uint)uVar2 * 0x10000 + -1, uVar2 == 0)) break;
      *puVar6 = *(undefined1 *)piVar5;
      piVar5 = (int *)((int)piVar5 + 1);
      puVar6 = puVar6 + 1;
    }
  }
  return;
}

```
