# Function_00049E30

**ROM:** `0x00049E30`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Function_00049E30(undefined4 param_1)

{
  byte *extraout_A1;
  
  if (param_1._1_1_ == 'R') {
    DAT_00003e23 = DAT_00003b5a;
    _DAT_00003e12 = (int)(short)((ushort)DAT_00003b5a * 10);
    RAM_Cat_ox1_duty_cycle = (word)(((uint)DAT_00003b5a * 0x76c) / 300);
    DAT_00003e21 = DAT_00003b54;
    _DAT_00003e0a = (int)(short)((ushort)DAT_00003b54 * 10);
    RAM_U_lambda_eng = (word)(((uint)DAT_00003b54 * 0x76c) / 300);
    DAT_00003e1f = DAT_00003b5c;
    _DAT_00003e1a = (int)(short)((ushort)DAT_00003b5c * 10);
    DAT_00003e2e = Function_0004A566();
    DAT_00001013 = (undefined1)(DAT_00003e2e / 10);
  }
  else {
    DAT_00003e22 = DAT_00fffd05;
    Function_0004A02C(&DAT_00003e0e,&DAT_00003e22);
    DAT_00003b5a = (byte)(DAT_00003e0e / 10);
    RAM_Cat_ox1_duty_cycle = (word)(((DAT_00003e0e / 10 & 0xff) * 0x76c) / 300);
    DAT_00003e20 = DAT_00fffd07;
    Function_0004A02C(&DAT_00003e06,&DAT_00003e20);
    *extraout_A1 = (byte)(DAT_00003e06 / 10);
    RAM_U_lambda_eng = (word)(((uint)*extraout_A1 * 0x76c) / 300);
    DAT_00003e1e = DAT_00fffd0b;
    Function_0004A02C(&DAT_00003e16,&DAT_00003e1e);
    DAT_00003b5c = (byte)(DAT_00003e16 / 10);
    DAT_00003e2e = Function_0004A566();
    DAT_00001013 = (undefined1)(DAT_00003e2e / 10);
    if (DAT_0000372e == '\x01') {
      DAT_0000372e = '\0';
    }
    else {
      DAT_00003e30 = DAT_00fffd01;
      DAT_00003e04 = DAT_00fffd01;
      Function_0004A02C(&DAT_00003dfc,&DAT_00003e04);
      DAT_00003dfa = (undefined1)(DAT_00003dfc / 10);
    }
  }
  return;
}

```
