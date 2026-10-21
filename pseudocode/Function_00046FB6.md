# Function_00046FB6

**ROM:** `0x00046FB6`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00046FB6(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0xff7f;
  _DAT_00fffe0a = _DAT_00fffe0a & 0xff7f | 0x80;
  _DAT_00fffe10 = _DAT_00fffe10 & 0xfff | 0xe000;
  _DAT_00fffe16 = _DAT_00fffe16 & 0x3fff;
  _DAT_00ffff70 = _DAT_00ffff70 & 0xfe00 | 0x87;
  _DAT_00ffff74 = 0xec;
  _DAT_00fffe1e = _DAT_00fffe1e & 0x3fff | 0xc000;
  return;
}

```
