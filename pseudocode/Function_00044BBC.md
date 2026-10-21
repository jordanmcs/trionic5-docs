# Function_00044BBC

**ROM:** `0x00044BBC`

```c

bool Function_00044BBC(void)

{
  byte bVar1;
  bool bVar2;
  
  if ((RAM_Ramp_steg_[3] & 8) == 0) {
    bVar1 = Function_000493C2();
    bVar2 = (bVar1 & 0x40) != 0;
  }
  else {
    bVar1 = Function_000493C2();
    bVar2 = (bVar1 & 0x40) == 0;
  }
  return bVar2;
}

```
