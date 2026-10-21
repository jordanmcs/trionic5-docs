# Function_00072B3A

**ROM:** `0x00072B3A`

```c

undefined4 Function_00072B3A(undefined4 param_1,undefined4 param_2)

{
  short sVar1;
  
  param_2._2_2_ = ((ushort)param_1._1_1_ - (ushort)(byte)param_1) * param_2._2_2_;
  sVar1 = (ushort)(byte)param_1 + param_2._2_2_ / param_2._0_2_;
  return CONCAT31((int3)(CONCAT22(param_2._2_2_ % param_2._0_2_,sVar1) >> 8),(char)sVar1);
}

```
