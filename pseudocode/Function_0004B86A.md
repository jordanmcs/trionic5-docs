# Function_0004B86A

**ROM:** `0x0004B86A`

```c

short Function_0004B86A(byte *param_1)

{
  ushort uVar1;
  ushort uVar2;
  code *extraout_A1;
  code *extraout_A1_00;
  code *extraout_A1_01;
  
  uVar1 = (ushort)*param_1;
  DAT_00003496 = Function_0006A730();
  uVar2 = (ushort)param_1[1];
  DAT_00003494 = (*extraout_A1)(uVar1);
  uVar1 = (ushort)param_1[2];
  DAT_00003492 = (*extraout_A1_00)(uVar2);
  DAT_00003490 = (*extraout_A1_01)(uVar1);
  DAT_0000348e = (ushort)DAT_00003496 * 0x1000 + (ushort)DAT_00003494 * 0x100 +
                 (ushort)DAT_00003492 * 0x10 + (ushort)DAT_00003490;
  return DAT_0000348e;
}

```
