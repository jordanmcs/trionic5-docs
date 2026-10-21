# Function_0004600E

**ROM:** `0x0004600E`

```c

int Function_0004600E(byte *param_1,byte *param_2)

{
  int iVar1;
  
  iVar1 = 0;
  for (; param_1 < param_2; param_1 = param_1 + 1) {
    iVar1 = (uint)*param_1 + iVar1;
  }
  return iVar1;
}

```
