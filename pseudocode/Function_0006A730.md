# Function_0006A730

**ROM:** `0x0006A730`

```c

byte Function_0006A730(undefined4 param_1)

{
  byte bVar1;
  
  if ((0x2f < param_1._1_1_) &&
     ((bVar1 = param_1._1_1_ - 0x30, bVar1 < 10 || (bVar1 = param_1._1_1_ - 0x37, bVar1 < 0x10)))) {
    return bVar1;
  }
  return 0xff;
}

```
