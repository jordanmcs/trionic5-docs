# Function_00047FC2

**ROM:** `0x00047FC2`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00047FC2(void)

{
  _DAT_00fffe20 = _DAT_00fffe20 & 0xfffb;
  _DAT_00fffe0a = _DAT_00fffe0a & 0xfffb | 4;
  _DAT_00fffe12 = _DAT_00fffe12 & 0xf0ff | 0xc00;
  _DAT_00fffe16 = _DAT_00fffe16 & 0xffcf | 0x10;
  _DAT_00ffff20 = _DAT_00ffff20 & 0xff | 0xa00;
  _DAT_00ffff28 = 0xff;
  _DAT_00ffff2a = 0;
  _DAT_00fffe1a = _DAT_00fffe1a & 0xffcf | 0x20;
  _DAT_00fffe1e = _DAT_00fffe1e & 0xffcf | 0x30;
  return;
}

```
