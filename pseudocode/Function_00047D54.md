# Function_00047D54

**ROM:** `0x00047D54`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

undefined8 Function_00047D54(void)

{
  ushort uVar1;
  ushort uVar2;
  undefined4 in_D0;
  undefined4 in_D1;
  uint uVar3;
  uint uVar4;
  byte *pbVar5;
  byte *extraout_A1;
  byte *extraout_A1_00;
  byte *extraout_A1_01;
  byte *extraout_A1_02;
  
  _DAT_00fffe20 = _DAT_00fffe20 & 0xfff7;
  pbVar5 = (byte *)&DAT_000036f2;
  if (DAT_000036f2 == '\0') {
    _DAT_00ffff30 = _DAT_00ffff30 & 0xffe0 | 0x13;
    _DAT_00ffff32 = DAT_00003b2e;
    _DAT_00fffe1a = _DAT_00fffe1a & 0xff3f | 0x40;
    DAT_00003bb2 = _DAT_00fffd0c * 2;
    Function_000446C4();
    pbVar5 = extraout_A1;
  }
  else if (DAT_000036f2 == '\x01') {
    _DAT_00ffff30 = _DAT_00ffff30 & 0xffe0 | 0xb;
    _DAT_00ffff32 = DAT_00003b32;
    _DAT_00fffe1a = _DAT_00fffe1a & 0xff3f | 0x40;
    DAT_00003ba2 = DAT_00003b2c - DAT_00003b2e;
    Function_0004499E();
    pbVar5 = extraout_A1_00;
  }
  else if (DAT_000036f2 == '\x02') {
    _DAT_00ffff30 = _DAT_00ffff30 & 0xffe0 | 7;
    _DAT_00ffff32 = DAT_00003b30;
    _DAT_00fffe1a = _DAT_00fffe1a & 0xff3f | 0x40;
    Function_000446C4();
    pbVar5 = extraout_A1_01;
  }
  else if (DAT_000036f2 == '\x03') {
    _DAT_00ffff30 = _DAT_00ffff30 & 0xffe0 | 0x13;
    _DAT_00ffff32 = DAT_00003b2c;
    _DAT_00fffe1a = _DAT_00fffe1a & 0xff3f | 0x40;
  }
  else if (DAT_000036f2 == '\x04') {
    uVar1 = _DAT_00fffff8 & 0xff;
    uVar3 = (uint)_DAT_00fffff6;
    uVar2 = _DAT_00ffff48 & 0xff;
    uVar4 = (uint)_DAT_00ffff46;
    Function_0004499E();
    DAT_0000111e = (undefined1)((((uint)uVar2 * 0x10000 + uVar4) * 100) / (uint)DAT_00003ba2);
    DAT_0000111f = (undefined1)(((uVar3 + (uint)uVar1 * 0x10000) * 100) / (uint)DAT_00003ba2);
    Function_000437CA();
    Function_00063B1E();
    DAT_00003ba4 = DAT_00fffd0d;
    DAT_0000112c = (_DAT_00fffd0c & 0xff) * 2;
    DAT_00003ba8 = Function_00060BFE(CONCAT22(DAT_0000112c,DAT_00003bb2));
    if (10 < DAT_00003ba6) {
      if ((DAT_00003ba8 == '\x01') && (0x32 < DAT_00001013)) {
        DAT_00003c4a = DAT_00003c4a | 0x80;
        DAT_00003ba6 = 0;
      }
      else {
        DAT_00003c4a = DAT_00003c4a & 0x7f;
      }
    }
    if (DAT_00003ba6 < 0xf) {
      DAT_00003ba6 = DAT_00003ba6 + 1;
    }
    Function_000446C4();
    pbVar5 = extraout_A1_02;
  }
  *pbVar5 = (byte)((uint)(int)(short)(*pbVar5 + 1) % 5);
  return CONCAT44(in_D0,in_D1);
}

```
