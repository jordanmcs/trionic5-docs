# Function_000488A8

**ROM:** `0x000488A8`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_000488A8(void)

{
  ushort uVar1;
  char cVar2;
  
  cVar2 = Function_0004A4D2();
  if (cVar2 == '\x01') {
    Function_00063712();
    if (DAT_00001118 == '\x01') {
      DAT_00003bca = (short)((((DAT_000010b4 + 300) * (uint)DAT_00003b70) / (uint)RAM_S_Lufttemp) /
                            10) + 1;
      if (DAT_00003bca == 0) {
        DAT_00003bca = 1;
      }
    }
    else {
      DAT_00003bca = 1;
    }
    DAT_00003bce = (undefined2)((uint)(DAT_00003b6c * (short)(0x294 - DAT_000010b4)) / 0x708);
    if (DAT_00003b6a < 0x168) {
      uVar1 = (DAT_00003b6a * 10 + 0x497) - DAT_000010b4;
    }
    else {
      uVar1 = (DAT_00003b6a * 10 - DAT_000010b4) - 0x979;
    }
    DAT_00003be4 = (uint)uVar1;
    DAT_00003be0 = DAT_00003be4 / 0x3c;
    DAT_00003bdc = (DAT_00003be4 % 0x3c << 7) / 0x3c;
    if (DAT_00003be0 != 0) {
      DAT_00003be0 = DAT_00003be0 - 1;
      DAT_00003bdc = DAT_00003bdc + 0x80;
    }
    if ((DAT_00003be0 == 0x39) && (0x80 < DAT_00003bdc)) {
      DAT_00003bdc = 0x80;
    }
    _DAT_00ffff28 = (short)DAT_00003bdc << 8 | (ushort)DAT_00003be0 & 0xff;
    if ((DAT_00003b72 < 0x1f5) || (DAT_00001118 != '\0')) {
      _DAT_00ffff2a = 0x5d;
    }
    else {
      DAT_00003bcc = (undefined2)(((uint)DAT_00003b70 * (uint)DAT_00001104 * 1000) / 32000);
      _DAT_00ffff2a = DAT_00003bcc;
    }
    _DAT_00fffe1a = _DAT_00fffe1a & 0xffcf | 0x10;
  }
  else {
    _DAT_00ffff20 = _DAT_00ffff20 & 0xfffc | 2;
    _DAT_00fffe1a = _DAT_00fffe1a & 0xffcf | 0x30;
    Function_00047FC2();
  }
  return;
}

```
