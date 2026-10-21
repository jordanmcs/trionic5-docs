# Function_000468F8

**ROM:** `0x000468F8`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000468F8(void)

{
  Function_00044E12();
  _DAT_00fffe0a = _DAT_00fffe0a & 0xfdff;
  _DAT_00fffe20 = _DAT_00fffe20 & 0xfdff;
  _DAT_00fffe0e = _DAT_00fffe0e & 0xff0f | 0x90;
  _DAT_00fffe1c = _DAT_00fffe1c & 0xfff3 | 8;
  _DAT_00ffff90 = _DAT_00ffff90 & 0xfe1c | 0x82;
  _DAT_00ffff94 = 0;
  _DAT_00ffff96 = 0xccd;
  _DAT_00fffe18 = _DAT_00fffe18 & 0xfff3 | 8;
  return;
}

```
