# Function_000478A8

**ROM:** `0x000478A8`

```c

/* WARNING: Removing unreachable block (ram,0x00047a80) */
/* WARNING: Removing unreachable block (ram,0x00047c00) */
/* WARNING: Removing unreachable block (ram,0x00047b56) */
/* WARNING: Removing unreachable block (ram,0x00047b90) */
/* WARNING: Removing unreachable block (ram,0x00047ba6) */
/* WARNING: Removing unreachable block (ram,0x00047bb4) */
/* WARNING: Removing unreachable block (ram,0x00047bc8) */
/* WARNING: Removing unreachable block (ram,0x00047c1a) */
/* WARNING: Removing unreachable block (ram,0x00047c42) */
/* WARNING: Removing unreachable block (ram,0x00047bd2) */
/* WARNING: Removing unreachable block (ram,0x00047bf8) */
/* WARNING: Removing unreachable block (ram,0x00047c4a) */
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

undefined8 Function_000478A8(void)

{
  undefined4 in_D0;
  undefined4 in_D1;
  uint uVar1;
  short *psVar2;
  short *extraout_A1;
  undefined2 *extraout_A1_00;
  
  _DAT_00fffe20 = _DAT_00fffe20 & 0xffdf;
  if ((_DAT_00fffe10 & 0xf0) == 0xe0) {
    if (DAT_0000370e == '\x01') {
      psVar2 = (short *)&DAT_00003b92;
      if (DAT_00003c2a == '\0') {
        if (DAT_00003b9a < 2) {
          _DAT_00ffff50 = _DAT_00ffff50 & 0xffe3 | 4;
          _DAT_00ffff52 = (undefined2)((int)((uint)DAT_00003b8a * 10000000) / 0xc80);
          DAT_00003c2a = '\x01';
        }
        else {
          _DAT_00ffff50 = _DAT_00ffff50 & 0xffe3 | 0x10;
          _DAT_00ffff54 = 0x5a;
          _DAT_00ffff52 = 0x3d09;
        }
        _DAT_00fffe1a = _DAT_00fffe1a & 0xf3ff | 0x400;
        DAT_00003b9a = DAT_00003b9a - 1;
      }
      else {
        if (DAT_00003b92 < 2) {
          if (DAT_00003b92 == 0) {
            _DAT_00fffe0a = _DAT_00fffe0a & 0xffdf;
            _DAT_00fffe1e = _DAT_00fffe1e & 0xf3ff;
            Function_000477B8();
            DAT_0000370e = '\0';
            psVar2 = extraout_A1;
          }
          else {
            _DAT_00ffff50 = _DAT_00ffff50 & 0xffe3 | 8;
            _DAT_00ffff52 = (undefined2)(((uint)DAT_00003b88 * 4000) / 0xc80);
            _DAT_00fffe1a = _DAT_00fffe1a & 0xf3ff | 0x400;
          }
        }
        else {
          _DAT_00ffff50 = _DAT_00ffff50 & 0xffe3 | 0x10;
          _DAT_00ffff54 = 0x5a;
          _DAT_00ffff52 = 0x3d09;
          _DAT_00fffe1a = _DAT_00fffe1a & 0xf3ff | 0x400;
        }
        *psVar2 = *psVar2 + -1;
      }
    }
    else {
      _DAT_00fffe0a = _DAT_00fffe0a & 0xffdf;
      _DAT_00fffe1e = _DAT_00fffe1e & 0xf3ff;
      Function_000477B8();
      DAT_0000370e = '\0';
    }
  }
  else if (DAT_000034f8 == _DAT_00ffff54) {
    DAT_000034f8 = _DAT_00ffff54;
  }
  else {
    if (_DAT_00ffff5a != 1) {
      DAT_00003706 = 0;
      DAT_000034f8 = _DAT_00ffff54;
      Function_0006D110();
      uVar1 = ((uint)RAM_Insptid_ms10 * 4000) / 0xc80;
      if ((uint)(DAT_00003b6c * 0xaf0) / 0x2d0 < uVar1) {
        uVar1 = (uint)(DAT_00003b6c * 0xaf0) / 0x2d0;
      }
      if (((DAT_00004734 >> 3 & 1) == 0) && (DAT_00003ac6 == '\0')) {
        *extraout_A1_00 = (short)uVar1;
        do {
        } while( true );
      }
      *extraout_A1_00 = 2;
      do {
      } while( true );
    }
    DAT_000034f8 = _DAT_00ffff54;
  }
  return CONCAT44(in_D0,in_D1);
}

```
