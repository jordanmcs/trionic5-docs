# Function_0004A082

**ROM:** `0x0004A082`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_0004A082(void)

{
  char cVar1;
  ushort uVar2;
  short sVar3;
  short sVar4;
  byte *pbVar5;
  byte *extraout_A1;
  byte *extraout_A1_00;
  
  DAT_0000372e = 1;
  if (_DAT_00fffd30 == 0x80) {
    DAT_00003b64 = DAT_00003dfa;
    _DAT_00fffd30 = 8;
    DAT_00003e05 = DAT_00003b50;
    _DAT_00003e00 = (int)(short)((ushort)DAT_00003b50 * 10);
    DAT_00fffd48 = 0x7e;
  }
  else {
    pbVar5 = &DAT_00003b5e;
    if (_DAT_00fffd30 == 8) {
      DAT_00003b50 = DAT_00003dfa;
      if (RAM_Bil_hast == 0) {
        DAT_00003e32 = 0;
      }
      else {
        DAT_00003e32 = (undefined1)
                       (((((uint)DAT_00003dfa * 0x253) / 1000 & 0xff) * 100) / (uint)RAM_Bil_hast);
      }
      DAT_0000372c = '\0';
      DAT_00003df8 = Function_000447D4();
      _DAT_00fffd30 = 0x88;
      DAT_00003e05 = *extraout_A1;
      _DAT_00003e00 = (int)(short)((ushort)*extraout_A1 * 10);
      DAT_00fffd48 = 0x7e;
    }
    else if (_DAT_00fffd30 == 0x88) {
      DAT_00003b5e = DAT_00003e30;
      if (DAT_00003868 == '\x01') {
        cVar1 = Function_000447D4();
        pbVar5 = extraout_A1_00;
        if ((cVar1 == DAT_00003df8) && (DAT_0000372c == '\0')) {
          if (cVar1 == '\x01') {
            DAT_0000372a = *extraout_A1_00 < 0x7f;
            DAT_00003866 = DAT_00003866 | 1;
          }
          else {
            DAT_00003728 = 0x7e < *extraout_A1_00;
            DAT_00003866 = DAT_00003866 | 2;
          }
        }
      }
      if ((RAM_Ramp_steg_[5] & 0x10) == 0) {
        DAT_00003edc = (char)((int)((int)(short)((ushort)*pbVar5 * (ushort)*pbVar5 * -0x735) +
                                    (uint)*pbVar5 * 2900000 + -0x14997000) / 10000000);
      }
      else {
        sVar3 = (short)(char)(*pbVar5 + 0x80);
        if (sVar3 < 0) {
          sVar3 = sVar3 + 3;
        }
        DAT_00003edc = (char)(sVar3 >> 2);
      }
      sVar3 = (short)DAT_00003edc * RAM_Press_diff_ok_ + 0x40;
      sVar4 = (0x80 - RAM_Press_diff_ok_) * DAT_00003726;
      uVar2 = sVar4 + sVar3;
      if (SCARRY2(sVar4,sVar3) != (int)((uint)uVar2 << 0x10) < 0) {
        uVar2 = uVar2 + 0x7f;
      }
      DAT_00003726 = (short)uVar2 >> 7;
      RAM_P_tank = (byte)DAT_00003726;
      _DAT_00fffd30 = 0x90;
      DAT_00003e05 = DAT_00003b4e;
      _DAT_00003e00 = (int)(short)((ushort)DAT_00003b4e * 10);
      DAT_00fffd48 = 0x7e;
    }
    else if (_DAT_00fffd30 == 0x90) {
      DAT_00003b4e = DAT_00003dfa;
      _DAT_00fffd30 = 0x58;
      DAT_00003e05 = DAT_00003b66;
      _DAT_00003e00 = (int)(short)((ushort)DAT_00003b66 * 10);
      DAT_00fffd48 = 0x7e;
    }
    else if (_DAT_00fffd30 == 0x58) {
      DAT_00003b66 = DAT_00003dfa;
      if (DAT_00003dfa < 4) {
        RAM_Bil_hast = 0;
      }
      else {
        RAM_Bil_hast = DAT_00003dfa - 3;
      }
      _DAT_00fffd30 = 0x10;
      DAT_00003e05 = DAT_00003b62;
      _DAT_00003e00 = (int)(short)((ushort)DAT_00003b62 * 10);
      DAT_00fffd48 = 0x7e;
    }
    else if (_DAT_00fffd30 == 0x10) {
      DAT_00003b62 = DAT_00003dfa;
      _DAT_00fffd30 = 0x18;
      DAT_00003e05 = DAT_00003b60;
      _DAT_00003e00 = (int)(short)((ushort)DAT_00003b60 * 10);
      DAT_00fffd48 = 0x7e;
    }
    else if (_DAT_00fffd30 == 0x18) {
      DAT_00003b60 = DAT_00003dfa;
      _DAT_00fffd30 = 0x20;
      DAT_00003e05 = DAT_00003b4c;
      _DAT_00003e00 = (int)(short)((ushort)DAT_00003b4c * 10);
      DAT_00fffd48 = 0x7e;
    }
    else if (_DAT_00fffd30 == 0x20) {
      DAT_00003b4c = DAT_00003dfa;
      DAT_00003e2c = (undefined2)(((uint)DAT_00003dfa * 0x354) / 100);
      _DAT_00fffd30 = 0x28;
      DAT_00003e05 = DAT_00003b4a;
      _DAT_00003e00 = (int)(short)((ushort)DAT_00003b4a * 10);
      DAT_00fffd48 = 0x7e;
    }
    else if (_DAT_00fffd30 == 0x28) {
      DAT_00003b4a = DAT_00003dfa;
      DAT_00003e2a = (undefined2)(((uint)DAT_00003dfa * 0x354) / 100);
      _DAT_00fffd30 = 0x80;
      DAT_00003e05 = DAT_00003b64;
      _DAT_00003e00 = (int)(short)((ushort)DAT_00003b64 * 10);
      DAT_00fffd48 = 0x7e;
    }
  }
  return;
}

```
