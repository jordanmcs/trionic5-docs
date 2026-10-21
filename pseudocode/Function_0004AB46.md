# Function_0004AB46

**ROM:** `0x0004AB46`

```c

undefined4 Function_0004AB46(void)

{
  char cVar2;
  undefined4 uVar1;
  
  cVar2 = Function_00044DD0();
  if (((DAT_00003736 & 0x80) != 0) || (cVar2 == '\0')) {
    if (((DAT_00003736 & 0x80) == 0) || (cVar2 != '\0')) {
      uVar1 = 0x4f;
    }
    else {
      uVar1 = 0x48;
    }
  }
  else {
    uVar1 = 0x4c;
  }
  return uVar1;
}

```
