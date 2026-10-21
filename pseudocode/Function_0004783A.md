# Function_0004783A

**ROM:** `0x0004783A`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0004783A(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0xffdf;
  _DAT_00fffe0a = _DAT_00fffe0a & 0xffdf | 0x20;
  _DAT_00fffe10 = _DAT_00fffe10 & 0xff0f | 0xe0;
  _DAT_00fffe16 = _DAT_00fffe16 & 0xf3ff;
  _DAT_00ffff50 = _DAT_00ffff50 & 0xfe00 | 0x87;
  _DAT_00ffff54 = 0xec;
  _DAT_00fffe1e = _DAT_00fffe1e & 0xf3ff | 0xc00;
  return;
}

```
