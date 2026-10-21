# Function_0006A84E

**ROM:** `0x0006A84E`

```c

void Function_0006A84E(int *param_1)

{
  if (*param_1 != 0) {
                    /* WARNING: Could not recover jumptable at 0x0006a866. Too many branches */
                    /* WARNING: Treating indirect jump as call */
    (*(code *)*param_1)();
    return;
  }
  return;
}

```
