# Function_00046B40

**ROM:** `0x00046B40`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00046B40(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0xfeff;
  _DAT_00fffe0a = _DAT_00fffe0a & 0xfeff | 0x100;
  _DAT_00fffe0e = _DAT_00fffe0e & 0xfff0 | 0xc;
  _DAT_00fffe14 = _DAT_00fffe14 & 0xfffc | 1;
  _DAT_00ffff80 = _DAT_00ffff80 & 0xff | 0xa00;
  _DAT_00ffff88 = 0xc000;
  _DAT_00ffff8a = 1;
  _DAT_00fffe18 = _DAT_00fffe18 & 0xfffc | 2;
  _DAT_00fffe1c = _DAT_00fffe1c & 0xfffc | 3;
  return;
}

```
