# Function_00057FEE

**ROM:** `0x00057FEE`

```c

void Function_00057FEE(void)

{
  DAT_00004640 = DAT_0000464c & 0x3f | 0x80;
  DAT_00004641 = DAT_0000464d;
  DAT_0000463f = 2;
  DAT_0000463e = 0x57;
  DAT_000038c2 = DAT_000038c2 & 0x7f;
  return;
}

```
