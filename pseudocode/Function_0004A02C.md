# Function_0004A02C

**ROM:** `0x0004A02C`

```c

void Function_0004A02C(uint *param_1,byte *param_2)

{
  *param_1 = (((uint)*param_2 + (uint)param_2[1]) * 0x38e + param_1[1] * 0x332) / 1000;
  param_1[1] = *param_1;
  param_2[1] = *param_2;
  return;
}

```
