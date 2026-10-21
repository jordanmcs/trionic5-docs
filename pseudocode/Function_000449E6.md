# Function_000449E6

**ROM:** `0x000449E6`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000449E6(void)

{
  undefined3 uVar1;
  
  uVar1 = DAT_00003b80._1_3_;
  DAT_00003b80 = CONCAT13(0xff,DAT_00003b80._1_3_);
  DAT_00003b80 = CONCAT22(DAT_00003b80._0_2_,(short)uVar1) | 0xff00;
  _DAT_00f007fe = DAT_00003b80;
  return;
}

```
