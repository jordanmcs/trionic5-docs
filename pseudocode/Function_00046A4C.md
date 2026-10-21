# Function_00046A4C

**ROM:** `0x00046A4C`

```c

/* WARNING: Removing unreachable block (ram,0x00046a78) */
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00046A4C(void)

{
  byte bVar1;
  ushort *puVar2;
  
  Function_00046B1A();
  DAT_00003b9e = (short)((int)((ushort)(_DAT_00ffff9a * 0xc80) / 1000) >> 1) - 0xb;
  if (DAT_00003b9e < 0x9d) {
    DAT_000046dc = '%';
  }
  else if (DAT_00003b9e < 0x9ba) {
    bVar1 = 0;
    puVar2 = &DAT_000036a6;
    while (*puVar2 <= DAT_00003b9e) {
      bVar1 = bVar1 + 1;
      puVar2 = puVar2 + 1;
    }
    DAT_000046dc = (char)((ushort)(DAT_00003b9e - (&DAT_000036a6)[(short)(bVar1 - 1)]) /
                         (ushort)(bVar1 + 1)) + (&DAT_000036cd)[(short)(bVar1 - 1) * 2];
  }
  else {
    DAT_000046dc = -0x10;
  }
  _DAT_00fffe18 = _DAT_00fffe18 & 0xfff3 | 8;
  return;
}

```
