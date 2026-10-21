# Function_0004A566

**ROM:** `0x0004A566`

```c

undefined2 Function_0004A566(void)

{
  undefined2 uVar1;
  
  uVar1 = DAT_00001052;
  if ((RAM_Samp_pek[0] & 0x20) == 0) {
    if (DAT_00fffd09 < 0xf3) {
      if (((uint)DAT_00fffd09 * 5000) / 0xff < 0x3e9) {
        DAT_00003e24 = (undefined2)(((uint)DAT_00fffd0f * 0xd1 + 500) / 0x56);
        uVar1 = DAT_00003e24;
      }
      else {
        DAT_00003e24 = (undefined2)(((uint)DAT_00fffd09 * 900 + 500) / 0x56);
        uVar1 = DAT_00003e24;
      }
    }
    else {
      DAT_00003e24 = 0x9f6;
      uVar1 = 0x9f6;
    }
  }
  return uVar1;
}

```
