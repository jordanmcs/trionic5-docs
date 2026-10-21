# RAM_Max_regl_sp!

**ROM:** `0x00005F42`

```c

void RAM_Max_regl_sp_(undefined4 param_1)

{
  undefined4 uVar1;
  uint uVar2;
  byte bVar3;
  
  bVar3 = 0;
  do {
    if (param_1._1_1_ == 'U') {
      uVar2 = (uint)bVar3;
      uVar1 = Function_0004600E(*(undefined4 *)(uVar2 * 8 + 0x37ea),
                                *(undefined4 *)(uVar2 * 8 + 0x37ee));
      *(undefined4 *)(&DAT_00003f26 + uVar2 * 10) = uVar1;
    }
    else {
      uVar2 = (uint)bVar3;
      uVar1 = Function_0004600E(*(undefined4 *)(uVar2 * 8 + 0x37ea),
                                *(undefined4 *)(uVar2 * 8 + 0x37ee));
      *(undefined4 *)(&DAT_00003f2a + uVar2 * 10) = uVar1;
    }
    bVar3 = bVar3 + 1;
  } while (bVar3 < 0xc);
  return;
}

```
