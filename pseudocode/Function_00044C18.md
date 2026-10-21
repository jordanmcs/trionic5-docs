# Function_00044C18

**ROM:** `0x00044C18`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00044C18(void)

{
  undefined3 uVar1;
  
  uVar1 = DAT_00003b84._1_3_;
  DAT_00003b84 = CONCAT13(0xfe,DAT_00003b84._1_3_);
  DAT_00003b84 = CONCAT22(DAT_00003b84._0_2_,(short)uVar1) & 0xffff7fff | 0x7f00;
  _DAT_00f007fe = DAT_00003b84;
  return;
}

```
