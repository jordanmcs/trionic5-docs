# Function_0006A4E4

**ROM:** `0x0006A4E4`

```c

char Function_0006A4E4(byte *param_1,char *param_2,undefined4 param_3)

{
  byte bVar1;
  byte bVar2;
  byte bVar3;
  byte bVar4;
  byte *pbVar5;
  char local_5;
  
  bVar4 = 0;
  for (pbVar5 = param_1; (*pbVar5 != 0xff && (*pbVar5 < param_3._1_1_)); pbVar5 = pbVar5 + 1) {
    bVar4 = bVar4 + 1;
  }
  if (bVar4 == 0) {
    local_5 = *param_2;
  }
  else {
    bVar1 = param_2[bVar4 - 1];
    bVar2 = param_2[bVar4];
    bVar3 = param_1[bVar4 - 1];
    if (bVar2 < bVar1) {
      local_5 = bVar1 - (char)((short)(((ushort)bVar1 - (ushort)bVar2) *
                                      ((ushort)param_3._1_1_ - (ushort)bVar3)) /
                              (short)((ushort)param_1[bVar4] - (ushort)bVar3));
    }
    else {
      local_5 = (char)((short)(((ushort)bVar2 - (ushort)bVar1) *
                              ((ushort)param_3._1_1_ - (ushort)bVar3)) /
                      (short)((ushort)param_1[bVar4] - (ushort)bVar3)) + bVar1;
    }
  }
  return local_5;
}

```
