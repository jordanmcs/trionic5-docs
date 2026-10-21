# Function_0006A794

**ROM:** `0x0006A794`

```c

int Function_0006A794(uint param_1)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  
  uVar1 = (param_1 >> 0x10) % 10000;
  uVar2 = uVar1 % 1000;
  uVar3 = uVar2 % 100;
  return ((param_1 >> 0x10) / 10000) * 0x10000 +
         (uVar1 / 1000) * 0x1000 + (uVar2 / 100) * 0x100 + (uVar3 / 10) * 0x10 + uVar3 % 10;
}

```
