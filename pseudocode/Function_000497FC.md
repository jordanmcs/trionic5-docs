# Function_000497FC

**ROM:** `0x000497FC`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

undefined1 Function_000497FC(void)

{
  undefined1 uVar1;
  byte bVar2;
  undefined4 *puVar3;
  
  if (DAT_00003d94._0_1_ == 0xa5) {
    if (DAT_00003c32 == 0) {
      DAT_00003c76 = (undefined1 *)(DAT_00003d94 * 0x100 + (uint)DAT_00003d98);
      DAT_00003c7a = DAT_00003d99;
      DAT_00003d82 = DAT_00003d99;
      if (((DAT_00003c76 < (undefined1 *)0xfff800) || ((undefined1 *)0xfff000 < DAT_00003c76)) &&
         ((undefined1 *)0x7fff < DAT_00003c76)) {
        Function_00049440();
        uVar1 = 4;
        DAT_00003724 = '\0';
      }
      else {
        uVar1 = 0;
        DAT_00003724 = 'Z';
      }
    }
    else {
      uVar1 = 4;
      DAT_00003724 = '\0';
    }
  }
  else if ((DAT_00003d94._0_1_ < 0x80) && (DAT_00003724 == 'Z')) {
    if (DAT_00003d82 < 8) {
      for (DAT_00003d86 = 0; (short)(ushort)DAT_00003d86 <= (short)(DAT_00003d82 - 1);
          DAT_00003d86 = DAT_00003d86 + 1) {
        (&DAT_00003c7b)[(short)((ushort)DAT_00003d94._0_1_ + (ushort)DAT_00003d86)] =
             *(undefined1 *)((int)&DAT_00003d94 + (short)(ushort)DAT_00003d86 + 1);
      }
      DAT_00003d82 = 0;
    }
    else {
      for (DAT_00003d86 = 0; DAT_00003d86 < 7; DAT_00003d86 = DAT_00003d86 + 1) {
        (&DAT_00003c7b)[(short)((ushort)DAT_00003d94._0_1_ + (ushort)DAT_00003d86)] =
             *(undefined1 *)((int)&DAT_00003d94 + (short)(ushort)DAT_00003d86 + 1);
      }
      DAT_00003d82 = DAT_00003d82 - 7;
    }
    uVar1 = 0;
    if (DAT_00003d82 == 0) {
      puVar3 = &DAT_00003c76;
      for (bVar2 = 0; bVar2 < DAT_00003c7a; bVar2 = bVar2 + 1) {
        DAT_00003c76[bVar2] = *(undefined1 *)((int)puVar3 + 5);
        puVar3 = (undefined4 *)((int)puVar3 + 1);
      }
      uVar1 = 0;
    }
  }
  else if ((DAT_00003d94._0_1_ == 0xc1) && (DAT_00003724 == 'Z')) {
    uVar1 = 1;
    DAT_00003c76 = (undefined1 *)(DAT_00003d94 * 0x100 + (uint)DAT_00003d98);
    DAT_00003d7c = DAT_00003d94 * 0x100 + (uint)DAT_00003d98;
  }
  else if (DAT_00003d94._0_1_ == 0xc4) {
    if (DAT_00003720 == '\x01') {
      Function_0004AC2E(DAT_00003d94._1_1_);
    }
    uVar1 = 3;
  }
  else if (DAT_00003d94._0_1_ == 0xc6) {
    if (DAT_00003722 == '\x01') {
      Function_0004AC2E(0);
    }
    uVar1 = 3;
  }
  else if (DAT_00003d94._0_1_ == 0xc3) {
    _DAT_00003d8e = DAT_0000364c;
    DAT_00003d92 = 0x89;
    DAT_00003d93 = 0xb8;
    uVar1 = 0;
  }
  else if (DAT_00003d94._0_1_ == 0xc5) {
    Function_00049B46();
    uVar1 = 2;
  }
  else if (DAT_00003d94._0_1_ == 199) {
    DAT_00003c76 = (undefined1 *)(DAT_00003d94 * 0x100 + (uint)DAT_00003d98);
    if (((DAT_00003c76 < (undefined1 *)0xfff800) || ((undefined1 *)0xfff000 < DAT_00003c76)) &&
       ((undefined1 *)0x7fff < DAT_00003c76)) {
      Function_00049440();
      uVar1 = 4;
    }
    else {
      _DAT_00003d8e =
           CONCAT31(CONCAT21(CONCAT11(*DAT_00003c76,DAT_00003c76[-1]),DAT_00003c76[-2]),
                    DAT_00003c76[-3]);
      DAT_00003d92 = DAT_00003c76[-4];
      DAT_00003d93 = DAT_00003c76[-5];
      uVar1 = 0;
    }
  }
  else {
    uVar1 = 4;
  }
  return uVar1;
}

```
