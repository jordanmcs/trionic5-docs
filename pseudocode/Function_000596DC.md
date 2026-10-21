# Function_000596DC

**ROM:** `0x000596DC`

```c

void Function_000596DC(void)

{
  DAT_00004640 = DAT_0000464c & 0x3f | 0x80;
  DAT_00004641 = DAT_0000464d;
  DAT_0000463f = 2;
  DAT_0000463e = 0x45;
  return;
}

```
