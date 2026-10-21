# Function_00061F30

**ROM:** `0x00061F30`

```c

undefined4
Function_00061F30(undefined4 param_1,short *param_2,short *param_3,undefined4 param_4,int param_5)

{
  short sVar1;
  short sVar2;
  bool bVar3;
  int iVar4;
  undefined4 uVar5;
  ushort uVar6;
  ushort unaff_D4w;
  ushort unaff_D5w;
  ushort unaff_D6w;
  ushort unaff_D7w;
  short *psVar7;
  short local_8;
  short local_6;
  
  bVar3 = false;
  uVar6 = 0;
  psVar7 = param_2;
  do {
    if (param_4._0_2_ < *psVar7) {
      unaff_D4w = uVar6;
      if (uVar6 != 0) {
        unaff_D4w = uVar6 - 1;
      }
      bVar3 = true;
      unaff_D6w = uVar6;
    }
    else if (param_4._0_2_ == *psVar7) {
      bVar3 = true;
      unaff_D4w = uVar6;
      unaff_D6w = uVar6;
    }
    else if ((ushort)(param_1._0_2_ - 1) <= uVar6) {
      bVar3 = true;
      unaff_D4w = uVar6;
      unaff_D6w = uVar6;
    }
    psVar7 = psVar7 + 1;
    uVar6 = uVar6 + 1;
  } while (!bVar3);
  bVar3 = false;
  uVar6 = 0;
  psVar7 = param_3;
  do {
    if (param_4._2_2_ < *psVar7) {
      unaff_D5w = uVar6;
      if (uVar6 != 0) {
        unaff_D5w = uVar6 - 1;
      }
      bVar3 = true;
      unaff_D7w = uVar6;
    }
    else if (param_4._2_2_ == *psVar7) {
      bVar3 = true;
      unaff_D5w = uVar6;
      unaff_D7w = uVar6;
    }
    else if ((ushort)(param_1._2_2_ - 1U) <= uVar6) {
      bVar3 = true;
      unaff_D5w = uVar6;
      unaff_D7w = uVar6;
    }
    psVar7 = psVar7 + 1;
    uVar6 = uVar6 + 1;
  } while (!bVar3);
  local_6 = *(short *)(param_5 + (short)(unaff_D4w + param_1._0_2_ * unaff_D5w) * 2);
  sVar1 = *(short *)(param_5 + (short)(unaff_D6w + param_1._0_2_ * unaff_D5w) * 2);
  iVar4 = (uint)param_1._0_2_ * (uint)unaff_D7w;
  local_8 = *(short *)(param_5 + (short)(unaff_D4w + (short)iVar4) * 2);
  sVar2 = *(short *)(param_5 + (short)(unaff_D6w + (short)iVar4) * 2);
  if (sVar1 != local_6) {
    iVar4 = (int)(short)(param_2[(short)unaff_D6w] - param_2[(short)unaff_D4w]);
    local_6 = (short)(((int)(short)(param_4._0_2_ - param_2[(short)unaff_D4w]) *
                      (int)(short)(sVar1 - local_6)) / iVar4) + local_6;
  }
  if (local_8 != sVar2) {
    iVar4 = (int)(short)(param_2[(short)unaff_D6w] - param_2[(short)unaff_D4w]);
    local_8 = (short)(((int)(short)(param_4._0_2_ - param_2[(short)unaff_D4w]) *
                      (int)(short)(sVar2 - local_8)) / iVar4) + local_8;
  }
  if (local_6 == local_8) {
    uVar5 = CONCAT22((short)((uint)iVar4 >> 0x10),local_6);
  }
  else {
    uVar5 = CONCAT22((short)(param_3[(short)unaff_D7w] - param_3[(short)unaff_D5w]) >> 0xf,
                     (short)(((int)(short)(param_4._2_2_ - param_3[(short)unaff_D5w]) *
                             (int)(short)(local_8 - local_6)) /
                            (int)(short)(param_3[(short)unaff_D7w] - param_3[(short)unaff_D5w])) +
                     local_6);
  }
  return uVar5;
}

```
