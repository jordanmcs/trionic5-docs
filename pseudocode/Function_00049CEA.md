# Function_00049CEA

**ROM:** `0x00049CEA`

```c

void Function_00049CEA(void)

{
  short *extraout_A1;
  short *extraout_A1_00;
  short *psVar1;
  
  if (DAT_00003c32 == 0) {
    Function_0004461C();
    psVar1 = extraout_A1;
    while (*psVar1 == 0) {
      Function_000769EC();
      psVar1 = extraout_A1_00;
    }
  }
  return;
}

```
