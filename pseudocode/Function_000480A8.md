# Function_000480A8

**ROM:** `0x000480A8`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

undefined8 Function_000480A8(void)

{
  undefined4 in_D0;
  undefined4 in_D1;
  undefined2 *extraout_A1;
  
  _DAT_00fffe20 = _DAT_00fffe20 & 0xfffb;
  if ((_DAT_00fffe12 & 0xf00) == 0xc00) {
    if (DAT_00003bb0 == _DAT_00ffff24) {
      DAT_00003bb0 = _DAT_00ffff24;
      DAT_00003bca = DAT_00003bca + -1;
      if (((DAT_00001118 == '\x01') || (DAT_000036f6 == '\x01')) || (DAT_000036f4 == '\x01')) {
        if (DAT_00003bca == 0) {
          DAT_000036f6 = '\0';
          DAT_000036f4 = '\0';
        }
        else {
          Function_00048042();
          _DAT_00ffff20 = _DAT_00ffff20 & 0xfe03 | 0x84;
          *extraout_A1 = 0xec;
          _DAT_00ffff22 = (undefined2)(((uint)(ushort)(RAM_S_Lufttemp - 300) * 1000) / 0xc80);
          _DAT_00fffe1a = _DAT_00fffe1a & 0xffcf | 0x10;
        }
      }
    }
    else {
      DAT_00003bb0 = _DAT_00ffff24;
      if (((DAT_00001118 != '\x01') && (DAT_000036f6 != '\x01')) &&
         ((DAT_000036f4 != '\x01' && (DAT_000036fe == '\x01')))) {
        Function_000446C4();
        _DAT_00ffff30 = _DAT_00ffff30 & 0xfe00 | 0x86;
        _DAT_00ffff32 = DAT_00003b28;
        _DAT_00fffe1a = _DAT_00fffe1a & 0xff3f | 0x40;
        DAT_000036f2 = 0;
      }
    }
  }
  else if (((DAT_00001118 == '\x01') || (DAT_000036f6 == '\x01')) || (DAT_000036f4 == '\x01')) {
    if (DAT_000036f8 == '\x01') {
      DAT_00003bca = 0;
      DAT_000036f8 = '\0';
    }
    if ((_DAT_00ffff20 & 0x1c) == 4) {
      _DAT_00ffff20 = _DAT_00ffff20 & 0xfe03 | 0x88;
      _DAT_00ffff24 = 0x2a;
      _DAT_00ffff22 = 0x5d;
      _DAT_00fffe1a = _DAT_00fffe1a & 0xffcf | 0x10;
    }
    else if (DAT_00003bca == 0) {
      DAT_000036f6 = '\0';
      DAT_000036f4 = '\0';
      Function_00047FC2();
    }
    else {
      DAT_00003bca = DAT_00003bca + -1;
      _DAT_00ffff20 = _DAT_00ffff20 & 0xfe03 | 0x84;
      _DAT_00ffff24 = 0x2a;
      _DAT_00ffff22 = (undefined2)(((uint)(ushort)(RAM_S_Lufttemp - 300) * 1000) / 0xc80);
      _DAT_00fffe1a = _DAT_00fffe1a & 0xffcf | 0x10;
    }
  }
  return CONCAT44(in_D0,in_D1);
}

```
