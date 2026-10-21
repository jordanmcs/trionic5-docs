# Function_00047C66

**ROM:** `0x00047C66`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00047C66(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0xffef;
  _DAT_00fffe0a = _DAT_00fffe0a & 0xffef;
  _DAT_00fffe10 = _DAT_00fffe10 & 0xfff0 | 0xf;
  _DAT_00fffe16 = _DAT_00fffe16 & 0xfcff | 0x200;
  _DAT_00ffff40 = _DAT_00ffff40 & 0xfe03 | 4;
  _DAT_00ffff42 = _DAT_00ffff42 & 0xff | 0xff00;
  _DAT_00ffff48 = _DAT_00ffff48 & 0xff | 0x500;
  _DAT_00fffe1e = _DAT_00fffe1e & 0xfcff | 0x300;
  return;
}

```
