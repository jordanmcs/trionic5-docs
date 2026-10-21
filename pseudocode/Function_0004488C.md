# Function_0004488C

**ROM:** `0x0004488C`

```c

void Function_0004488C(void)

{
  DAT_00fffc15 = DAT_00fffc15 & 0xbf;
  DAT_00fffc16 = DAT_00fffc16 & 0x8f;
  DAT_00fffc17 = DAT_00fffc17 & 0xcf | 0x40;
  return;
}

```
