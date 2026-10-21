# Function_00046F34

**ROM:** `0x00046F34`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00046F34(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0xff7f;
  _DAT_00fffe0a = _DAT_00fffe0a & 0xff7f | 0x80;
  _DAT_00fffe10 = _DAT_00fffe10 & 0xfff | 0xc000;
  _DAT_00fffe16 = _DAT_00fffe16 & 0x3fff | 0x4000;
  _DAT_00ffff70 = _DAT_00ffff70 & 0xff | 0xa00;
  _DAT_00ffff78 = 0xc000;
  _DAT_00ffff7a = 1;
  _DAT_00fffe1a = _DAT_00fffe1a & 0x3fff | 0x8000;
  _DAT_00fffe1e = _DAT_00fffe1e & 0x3fff | 0xc000;
  return;
}

```
