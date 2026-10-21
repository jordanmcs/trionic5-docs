# Function_00043BF0

**ROM:** `0x00043BF0`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00043BF0(void)

{
  DAT_00fffa01 = DAT_00fffa01 & 0xf0 | 0x42;
  DAT_00fffa24 = DAT_00fffa24 & 0xfe;
  DAT_00fffa25 = 0x10;
  DAT_00fffa22 = DAT_00fffa22 & 0xf8 | 2;
  DAT_00fffa23 = 0x50;
  do {
  } while ((DAT_00fffa05 >> 3 & 1) == 0);
  DAT_00fffa04 = 0xd3;
  DAT_00fffa05 = DAT_00fffa05 | 0x80;
  _DAT_00fffa44 = 0x3ffb;
  _DAT_00fffa46 = 3;
  _DAT_00fffa48 = 0x405;
  _DAT_00fffa50 = 0x405;
  _DAT_00fffa54 = 0x405;
  _DAT_00fffa4a = 0x6830;
  _DAT_00fffa52 = 0x1070;
  _DAT_00fffa56 = 0x1070;
  _DAT_00fffa4c = 3;
  _DAT_00fffa4e = 0x7870;
  _DAT_00fffa58 = 0xf000;
  _DAT_00fffa5a = 0x77f0;
  _DAT_00fffa5c = 0xf008;
  _DAT_00fffa5e = 0x6bf0;
  _DAT_00fffa60 = 0xf008;
  _DAT_00fffa62 = 0x73f0;
  _DAT_00fffa64 = 0xf001;
  _DAT_00fffa66 = 0x7af0;
  _DAT_00fffa68 = 0xfff8;
  _DAT_00fffa6a = 0xabc7;
  Function_000446AC();
  Function_000444E6();
  Function_00044C18();
  Function_000449E6();
  Function_00044924();
  Function_0004488C();
  return;
}

```
