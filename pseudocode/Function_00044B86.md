# Function_00044B86

**ROM:** `0x00044B86`

```c

undefined1 Function_00044B86(void)

{
  byte bVar1;
  undefined1 uVar2;
  
  bVar1 = Function_000493C2();
  if ((bVar1 & 0x10) == 0) {
    uVar2 = 0x4e;
  }
  else {
    uVar2 = 0x44;
  }
  return uVar2;
}

```
