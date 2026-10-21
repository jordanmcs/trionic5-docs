# Function_00048B3C

**ROM:** `0x00048B3C`

```c

/* WARNING: Removing unreachable block (ram,0x00048f94) */
/* WARNING: Removing unreachable block (ram,0x00048d8e) */
/* WARNING: Removing unreachable block (ram,0x00048d1c) */
/* WARNING: Removing unreachable block (ram,0x00048d5a) */
/* WARNING: Removing unreachable block (ram,0x00048d86) */
/* WARNING: Removing unreachable block (ram,0x00048d2c) */
/* WARNING: Removing unreachable block (ram,0x00048d4e) */
/* WARNING: Removing unreachable block (ram,0x00048d56) */
/* WARNING: Removing unreachable block (ram,0x00048e90) */
/* WARNING: Removing unreachable block (ram,0x00049098) */
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

ulonglong Function_00048B3C(void)

{
  undefined3 uVar1;
  ushort uVar2;
  uint uVar3;
  ushort uVar4;
  
  DAT_00003bbc = DAT_00003b6a;
  Function_0006C6DA();
  DAT_00003c30 = DAT_00001072 + 0x75;
  if (0x167 < DAT_00003c30) {
    DAT_00003c30 = DAT_00001072 - 0xf3;
  }
  if (0x167 < DAT_00003c30) {
    DAT_00003c30 = DAT_00003c30 - 0x168;
  }
  uVar3 = DAT_00003c30 / 6;
  if (0x3a < uVar3) {
    uVar3 = 0x3a;
  }
  if (uVar3 == 0) {
    uVar4 = 0;
  }
  else {
    uVar4 = (short)uVar3 - 1;
  }
  uVar2 = (DAT_00003be8 & 7) << 8;
  uVar3 = CONCAT22((short)(((uint)DAT_00003b70 * 340000) / 0xc80 >> 0x10),uVar2);
  if ((((DAT_0000370e == '\0') && (DAT_0000370c == '\0')) && (DAT_0000370a == '\0')) &&
     (DAT_00003708 == '\0')) {
    uVar1 = (undefined3)(uVar3 >> 8);
    if (DAT_00004735 < '\0') {
      if (((DAT_00004734 >> 3 & 1) == 0) && (DAT_00003ac6 == '\0')) {
        do {
        } while( true );
      }
      DAT_00003bba = 0;
      DAT_00003706 = 3;
      _DAT_00fffe16 = _DAT_00fffe16 & 0xf3ff | 0x400;
      _DAT_00ffff58 = uVar4 & 0xff | 0xc000;
      _DAT_00ffff5a = 2;
      _DAT_00fffe1a = _DAT_00fffe1a & 0xf3ff | 0x400;
    }
    if ((DAT_00004734 & 1) == 1) {
      if (((DAT_00004734 >> 4 & 1) == 0) && (DAT_00003ac6 == '\0')) {
        do {
        } while( true );
      }
      DAT_00003bb8 = 0;
      DAT_00003704 = 3;
      _DAT_00fffe16 = _DAT_00fffe16 & 0xcfff | 0x1000;
      _DAT_00ffff68 = uVar4 & 0xff | 0xc000;
      _DAT_00ffff6a = 2;
      _DAT_00fffe1a = _DAT_00fffe1a & 0xcfff | 0x1000;
    }
    if ((DAT_00004734 >> 1 & 1) == 1) {
      DAT_000036fc = (DAT_0000103d & 0x80) != 0;
      if (((DAT_00004734 >> 5 & 1) == 0) && (DAT_00003ac6 == '\0')) {
        do {
        } while( true );
      }
      DAT_00003bb6 = 0;
      DAT_00003702 = 3;
      _DAT_00fffe16 = _DAT_00fffe16 & 0x3fff | 0x4000;
      _DAT_00ffff78 = uVar4 & 0xff | 0xc000;
      _DAT_00ffff7a = 2;
      _DAT_00fffe1a = _DAT_00fffe1a & 0x3fff | 0x4000;
    }
    uVar3 = CONCAT31(uVar1,DAT_00004734 >> 2) & 0xffffff01;
    if ((DAT_00004734 >> 2 & 1) == 1) {
      DAT_000036fa = (DAT_0000103d & 0x80) != 0;
      uVar3 = CONCAT31(uVar1,DAT_00004734 >> 6) & 0xffffff01;
      if (((DAT_00004734 >> 6 & 1) == 0) && (DAT_00003ac6 == '\0')) {
        do {
        } while( true );
      }
      DAT_00003bb4 = 0;
      DAT_00003700 = 3;
      _DAT_00fffe14 = _DAT_00fffe14 & 0xfffc | 1;
      _DAT_00ffff88 = uVar4 & 0xff | 0xc000;
      _DAT_00ffff8a = 2;
      _DAT_00fffe18 = _DAT_00fffe18 & 0xfffc | 1;
    }
  }
  return (ulonglong)CONCAT24(uVar2 | (byte)(((DAT_00003be8 & 7) == 0) << 2),uVar3);
}

```
