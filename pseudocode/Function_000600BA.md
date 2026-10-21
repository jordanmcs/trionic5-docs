# Function_000600BA

**ROM:** `0x000600BA`

```c

void Function_000600BA(void)

{
  undefined2 uVar1;
  code *extraout_A1;
  code *extraout_A1_00;
  
  DAT_00004640 = DAT_0000464c & 0xf | 0x40;
  uVar1 = Function_000662CA(1);
  DAT_00004641 = (undefined1)((ushort)uVar1 >> 8);
  DAT_00004642 = (undefined1)uVar1;
  uVar1 = (*extraout_A1)(0x60002);
  DAT_00004643 = (undefined1)((ushort)uVar1 >> 8);
  DAT_00004644 = (undefined1)uVar1;
  uVar1 = (*extraout_A1_00)(0x60003);
  DAT_00004645 = (char)((ushort)uVar1 >> 8);
  DAT_00004646 = (char)uVar1;
  DAT_0000463f = 7;
  return;
}

```
