# Function_0006A5CC

**ROM:** `0x0006A5CC`

```c

undefined1 Function_0006A5CC(undefined4 param_1,int param_2)

{
  byte *pbVar1;
  ushort uVar2;
  ushort uVar3;
  
  if (0xf0 < (byte)param_1) {
    param_1._3_1_ = 0xf0;
  }
  if (0xf0 < param_1._1_1_) {
    param_1._1_1_ = 0xf0;
  }
  pbVar1 = (byte *)(param_2 + (uint)(param_1._1_1_ & 0xf0) + (int)(short)((byte)param_1 / 0x10));
  uVar3 = (ushort)((byte)param_1 & 0xf);
  uVar2 = (ushort)(param_1._1_1_ & 0xf);
  return (char)((ushort)((0x10 - uVar3) * (ushort)*pbVar1 * (0x10 - uVar2) +
                         pbVar1[1] * uVar3 * (0x10 - uVar2) +
                         (0x10 - uVar3) * (ushort)pbVar1[0x10] * uVar2 +
                        pbVar1[0x11] * uVar2 * uVar3) >> 8);
}

```
