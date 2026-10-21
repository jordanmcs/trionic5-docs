# Function_000495AC

**ROM:** `0x000495AC`

```c

void Function_000495AC(void)

{
  ushort uVar1;
  code *extraout_A1;
  code *pcVar2;
  code *extraout_A1_00;
  byte *pbVar3;
  byte *extraout_A1_01;
  
  Function_000493C2();
  Function_00049404(0);
  pcVar2 = extraout_A1;
  do {
    uVar1 = (*pcVar2)();
    pcVar2 = extraout_A1_00;
  } while ((uVar1 & 1) == 0);
  pbVar3 = &DAT_00003d8a;
  DAT_00003d8a = 0;
  while (*pbVar3 < 8) {
    Function_00049404((&DAT_00003d8c)[(short)(ushort)*pbVar3]);
    *extraout_A1_01 = *extraout_A1_01 + 1;
    pbVar3 = extraout_A1_01;
  }
  Function_00049404(0x88);
  Function_00049404(0x80);
  return;
}

```
