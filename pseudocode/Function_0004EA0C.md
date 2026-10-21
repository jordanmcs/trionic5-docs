# Function_0004EA0C

**ROM:** `0x0004EA0C`

```c

void Function_0004EA0C(void)

{
  byte *pbVar1;
  byte *pbVar2;
  
  pbVar1 = (byte *)&DAT_00004fbe;
  do {
    pbVar2 = pbVar1 + 2;
    pbVar1[0] = 0;
    pbVar1[1] = 0;
    pbVar1 = pbVar2;
  } while (pbVar2 < RAM_Last_reg_ac_);
  return;
}

```
