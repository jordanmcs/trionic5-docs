# Function_00046B1A

**ROM:** `0x00046B1A`

```c

void Function_00046B1A(void)

{
  if (DAT_000036a4 == 0) {
    if (DAT_000036a2 < 100) {
      DAT_000036a2 = DAT_000036a2 + 1;
    }
  }
  else {
    DAT_000036a2 = 0;
  }
  DAT_000036a4 = 0;
  return;
}

```
