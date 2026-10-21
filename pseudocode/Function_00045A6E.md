# Function_00045A6E

**ROM:** `0x00045A6E`

```c

undefined4 Function_00045A6E(undefined4 param_1)

{
  ushort uVar1;
  
  DAT_0000366c = (ushort)(DAT_0000366c * 5 + 0x7fcf) % 0xff9d;
  uVar1 = (param_1._2_2_ - param_1._0_2_) + 1;
  return CONCAT22(DAT_0000366c / uVar1,param_1._0_2_ + DAT_0000366c % uVar1);
}

```
