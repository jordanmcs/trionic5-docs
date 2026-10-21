# Function_000477B8

**ROM:** `0x000477B8`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000477B8(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0xffdf;
  _DAT_00fffe0a = _DAT_00fffe0a & 0xffdf | 0x20;
  _DAT_00fffe10 = _DAT_00fffe10 & 0xff0f | 0xc0;
  _DAT_00fffe16 = _DAT_00fffe16 & 0xf3ff | 0x400;
  _DAT_00ffff50 = _DAT_00ffff50 & 0xff | 0xa00;
  _DAT_00ffff58 = 0xc000;
  _DAT_00ffff5a = 1;
  _DAT_00fffe1a = _DAT_00fffe1a & 0xf3ff | 0x800;
  _DAT_00fffe1e = _DAT_00fffe1e & 0xf3ff | 0xc00;
  return;
}

```
