# Function_00046BC2

**ROM:** `0x00046BC2`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00046BC2(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0xfeff;
  _DAT_00fffe0a = _DAT_00fffe0a & 0xfeff | 0x100;
  _DAT_00fffe0e = _DAT_00fffe0e & 0xfff0 | 0xe;
  _DAT_00fffe14 = _DAT_00fffe14 & 0xfffc;
  _DAT_00ffff80 = _DAT_00ffff80 & 0xfe00 | 0x87;
  _DAT_00ffff84 = 0xec;
  _DAT_00fffe1c = _DAT_00fffe1c & 0xfffc | 3;
  return;
}

```
