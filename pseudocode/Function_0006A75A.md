# Function_0006A75A

**ROM:** `0x0006A75A`

```c

short Function_0006A75A(undefined4 param_1)

{
  byte bVar1;
  byte bVar2;
  
  bVar2 = (param_1._1_1_ >> 4) + 0x30;
  if (0x39 < bVar2) {
    bVar2 = (param_1._1_1_ >> 4) + 0x37;
  }
  bVar1 = (param_1._1_1_ & 0xf) + 0x30;
  if (0x39 < bVar1) {
    bVar1 = (param_1._1_1_ & 0xf) + 0x37;
  }
  return (ushort)bVar2 * 0x100 + (ushort)bVar1;
}

```
