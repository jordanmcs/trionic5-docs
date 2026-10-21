# Function_00047CE0

**ROM:** `0x00047CE0`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00047CE0(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0xfff7;
  _DAT_00fffe0a = _DAT_00fffe0a & 0xfff7 | 8;
  _DAT_00fffe12 = _DAT_00fffe12 & 0xfff | 0xe000;
  DAT_00003b77 = 0;
  _DAT_00fffe16 = _DAT_00fffe16 & 0xff3f;
  _DAT_00ffff30 = _DAT_00ffff30 & 0xfe00 | 0x81;
  _DAT_00ffff34 = 0x24;
  _DAT_00fffe1e = _DAT_00fffe1e & 0xff3f | 0x80;
  return;
}

```
