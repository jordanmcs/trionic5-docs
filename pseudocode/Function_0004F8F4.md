# Function_0004F8F4

**ROM:** `0x0004F8F4`

```c

undefined4 Function_0004F8F4(void)

{
  short sVar1;
  undefined4 uVar2;
  uint uVar3;
  byte bVar4;
  
  for (DAT_00003f0e = DAT_0000364c + -4; (*DAT_00003f0e != 0xff && (DAT_00003f0e[-1] != 0xfe));
      DAT_00003f0e = DAT_00003f0e + -(int)(short)(*DAT_00003f0e + 2)) {
  }
  for (bVar4 = 0; bVar4 < *DAT_00003f0e; bVar4 = bVar4 + 1) {
    uVar3 = (uint)bVar4;
    if (DAT_00003f0e[-2 - uVar3] < 0x41) {
      sVar1 = DAT_00003f0e[-2 - uVar3] - 0x30;
    }
    else {
      sVar1 = DAT_00003f0e[-2 - uVar3] - 0x37;
    }
    DAT_000037e0 = (uint)sVar1;
    DAT_000037e4 = (undefined *)(DAT_000037e0 | (int)DAT_000037e4 << 4);
  }
  if ((DAT_000037e4 < &UNK_00040001) || (DAT_0000364c <= DAT_000037e4)) {
    uVar2 = 0x45;
  }
  else {
    DAT_00003f16 = Function_0004600E(0x40000,DAT_000037e4 + 1);
    DAT_00003f12 = *(int *)(DAT_0000364c + -3);
    if (DAT_00003f16 == DAT_00003f12) {
      uVar2 = 0x4f;
    }
    else {
      uVar2 = 0x45;
    }
  }
  return uVar2;
}

```
