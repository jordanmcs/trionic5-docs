# Function_00045FC4

**ROM:** `0x00045FC4`

```c

void Function_00045FC4(void)

{
  int iVar1;
  byte bVar2;
  
  bVar2 = 0;
  do {
    iVar1 = (uint)bVar2 * 10;
    if (*(int *)(&DAT_00003f26 + iVar1) == *(int *)(&DAT_00003f2a + iVar1)) {
      (&DAT_00003f2e)[iVar1] = 0x4f;
    }
    else {
      (&DAT_00003f2e)[iVar1] = 0x4e;
    }
    bVar2 = bVar2 + 1;
  } while (bVar2 < 0xc);
  return;
}

```
