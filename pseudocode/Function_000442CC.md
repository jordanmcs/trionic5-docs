# Function_000442CC

**ROM:** `0x000442CC`

```c

void Function_000442CC(void)

{
  ushort *puVar1;
  ushort *extraout_A1;
  ushort *extraout_A1_00;
  ushort *extraout_A1_01;
  ushort *extraout_A1_02;
  
  puVar1 = &DAT_00003b68;
  if (DAT_00003b68 == 0) {
    if (DAT_00003650 == 0) {
      Function_000447D4();
      puVar1 = extraout_A1_00;
    }
    else {
      Function_000447D4();
      puVar1 = extraout_A1;
    }
  }
  else if (DAT_00003650 == DAT_00003b68) {
    if (DAT_00003650 == 0x3e) {
      Function_000447D4();
      puVar1 = extraout_A1_02;
    }
    else {
      Function_000447D4();
      puVar1 = extraout_A1_01;
    }
  }
  *puVar1 = *puVar1 + 1;
  if (0x3e < *puVar1) {
    *puVar1 = 0;
    DAT_00003650 = DAT_00003652;
  }
  return;
}

```
