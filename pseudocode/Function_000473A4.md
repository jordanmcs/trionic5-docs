# Function_000473A4

**ROM:** `0x000473A4`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000473A4(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0xffbf;
  _DAT_00fffe0a = _DAT_00fffe0a & 0xffbf | 0x40;
  _DAT_00fffe10 = _DAT_00fffe10 & 0xf0ff | 0xe00;
  _DAT_00fffe16 = _DAT_00fffe16 & 0xcfff;
  _DAT_00ffff60 = _DAT_00ffff60 & 0xfe00 | 0x87;
  _DAT_00ffff64 = 0xec;
  _DAT_00fffe1e = _DAT_00fffe1e & 0xcfff | 0x3000;
  return;
}

```
