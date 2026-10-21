# Function_0006A314

**ROM:** `0x0006A314`

```c

short Function_0006A314(char *param_1,int param_2,uint param_3)

{
  ushort uVar1;
  ushort uVar2;
  char cVar3;
  byte bVar4;
  uint uVar5;
  char *pcVar6;
  short local_6;
  
  bVar4 = 0;
  for (pcVar6 = param_1; ((ushort)bVar4 != (ushort)((byte)param_3 - 1) && (param_3._1_1_ < *pcVar6))
      ; pcVar6 = pcVar6 + 1) {
    bVar4 = bVar4 + 1;
  }
  if ((bVar4 == 0) || (param_3._1_1_ < param_1[(param_3 & 0xff) - 1])) {
    local_6 = *(short *)(param_2 + (uint)bVar4 * 2);
  }
  else {
    uVar5 = (uint)bVar4;
    uVar1 = *(ushort *)(param_2 + -2 + uVar5 * 2);
    uVar2 = *(ushort *)(param_2 + uVar5 * 2);
    cVar3 = param_1[uVar5 - 1];
    if (uVar2 < uVar1) {
      local_6 = uVar1 - (short)(((uint)(ushort)(uVar1 - uVar2) *
                                 (uint)(ushort)((short)cVar3 - (short)param_3._1_1_) & 0xffff) /
                               (uint)(ushort)((short)cVar3 - (short)param_1[uVar5]));
    }
    else {
      local_6 = uVar1 + (short)(((uint)(ushort)(uVar2 - uVar1) *
                                 (uint)(ushort)((short)cVar3 - (short)param_3._1_1_) & 0xffff) /
                               (uint)(ushort)((short)cVar3 - (short)param_1[uVar5]));
    }
  }
  return local_6;
}

```
