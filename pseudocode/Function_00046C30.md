# Function_00046C30

**ROM:** `0x00046C30`

```c

/* WARNING: Removing unreachable block (ram,0x00046e04) */
/* WARNING: Removing unreachable block (ram,0x00046ed2) */
/* WARNING: Removing unreachable block (ram,0x00046f14) */
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

undefined8 Function_00046C30(void)

{
  undefined4 in_D0;
  undefined4 in_D1;
  uint uVar1;
  short *psVar2;
  short *extraout_A1;
  undefined2 *extraout_A1_00;
  
  _DAT_00fffe20 = _DAT_00fffe20 & 0xfeff;
  if ((_DAT_00fffe0e & 0xf) == 0xe) {
    if (DAT_00003708 == '\x01') {
      psVar2 = (short *)&DAT_00003b8c;
      if (DAT_00003c24 == '\0') {
        if (DAT_00003b94 < 2) {
          _DAT_00ffff80 = _DAT_00ffff80 & 0xffe3 | 4;
          _DAT_00ffff82 = (undefined2)((int)((uint)DAT_00003b8a * 10000000) / 0xc80);
          DAT_00003c24 = '\x01';
        }
        else {
          _DAT_00ffff80 = _DAT_00ffff80 & 0xffe3 | 0x10;
          _DAT_00ffff84 = 0x8a;
          _DAT_00ffff82 = 0x3d09;
        }
        _DAT_00fffe18 = _DAT_00fffe18 & 0xfffc | 1;
        DAT_00003b94 = DAT_00003b94 - 1;
      }
      else {
        if (DAT_00003b8c < 2) {
          if (DAT_00003b8c == 0) {
            _DAT_00fffe0a = _DAT_00fffe0a & 0xfeff;
            Function_00046B40();
            DAT_00003708 = '\0';
            Function_000695EE();
            psVar2 = extraout_A1;
          }
          else {
            _DAT_00ffff80 = _DAT_00ffff80 & 0xffe3 | 8;
            _DAT_00ffff82 = (undefined2)(((uint)DAT_00003b88 * 4000) / 0xc80);
            _DAT_00fffe18 = _DAT_00fffe18 & 0xfffc | 1;
          }
        }
        else {
          _DAT_00ffff80 = _DAT_00ffff80 & 0xffe3 | 0x10;
          _DAT_00ffff84 = 0x8a;
          _DAT_00ffff82 = 0x3d09;
          _DAT_00fffe18 = _DAT_00fffe18 & 0xfffc | 1;
        }
        *psVar2 = *psVar2 + -1;
      }
    }
    else {
      _DAT_00fffe0a = _DAT_00fffe0a & 0xfeff;
      Function_00046B40();
      DAT_00003708 = '\0';
    }
  }
  else if (DAT_000034fe == _DAT_00ffff84) {
    DAT_000034fe = _DAT_00ffff84;
  }
  else if (_DAT_00ffff8a == 1) {
    DAT_000034fe = _DAT_00ffff84;
  }
  else {
    DAT_000034fe = _DAT_00ffff84;
    if (DAT_000036fa == '\x01') {
      DAT_00003700 = 0;
      Function_0006D110();
      uVar1 = ((uint)RAM_Insptid_ms10 * 4000) / 0xc80;
      if ((uint)(DAT_00003b6c * 0xaf0) / 0x2d0 < uVar1) {
        uVar1 = (uint)(DAT_00003b6c * 0xaf0) / 0x2d0;
      }
      if (((DAT_00004734 >> 6 & 1) == 0) && (DAT_00003ac6 == '\0')) {
        *extraout_A1_00 = (short)uVar1;
        do {
        } while( true );
      }
      *extraout_A1_00 = 2;
      do {
      } while( true );
    }
  }
  return CONCAT44(in_D0,in_D1);
}

```
