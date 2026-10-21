# Function_0004ABEA

**ROM:** `0x0004ABEA`

```c

undefined1 Function_0004ABEA(void)

{
  undefined1 uVar1;
  byte bVar2;
  undefined1 *puVar3;
  undefined1 *puVar4;
  
  uVar1 = DAT_00003e3e;
  if (DAT_0000373c != 0) {
    DAT_0000373c = DAT_0000373c - 1;
    if (DAT_0000373c == 0) {
      DAT_0000373a = 0;
    }
    puVar4 = &DAT_00003e3e;
    puVar3 = &DAT_00003e3e;
    for (bVar2 = 0; bVar2 < DAT_0000373c; bVar2 = bVar2 + 1) {
      *puVar3 = puVar4[1];
      puVar4 = puVar4 + 1;
      puVar3 = puVar3 + 1;
    }
  }
  return uVar1;
}

```
