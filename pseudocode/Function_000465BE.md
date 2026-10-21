# Function_000465BE

**ROM:** `0x000465BE`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000465BE(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0x7fff;
  _DAT_00fffe0a = _DAT_00fffe0a & 0x7fff;
  _DAT_00fffe0c = _DAT_00fffe0c & 0xfff | 0xf000;
  _DAT_00fffe14 = _DAT_00fffe14 & 0x3fff | 0x8000;
  _DAT_00fffff0 = _DAT_00fffff0 & 0xfe03 | 4;
  _DAT_00fffff2 = _DAT_00fffff2 & 0xff | 0xff00;
  _DAT_00fffff8 = _DAT_00fffff8 & 0xff | 0x500;
  _DAT_00fffe1c = _DAT_00fffe1c & 0x3fff | 0xc000;
  return;
}

```
