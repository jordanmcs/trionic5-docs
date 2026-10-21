# Function_000601B6

**ROM:** `0x000601B6`

```c

void Function_000601B6(void)

{
  DAT_00004640 = DAT_0000464c & 0xf | 0x40;
  Function_000662CA(0);
  DAT_00003fe6 = DAT_00003fe6 & 0xf;
  DAT_000040e2 = 0;
  DAT_000040e0 = 0;
  DAT_000040de = 0;
  DAT_000040dc = 0;
  RAM_Cat_fc_timer[4] = 0;
  RAM_Cat_fc_timer[5] = 0;
  DAT_00004104 = 0;
  DAT_00004100 = 0;
  DAT_000040fe = 0;
  DAT_000040fc = 0;
  DAT_000040fa = 0;
  DAT_000040f8 = 0;
  DAT_000040f6 = 0;
  DAT_000040f4 = 0;
  DAT_00003ee4 = 0;
  DAT_00003eb6 = 0;
  DAT_00003eb2 = 0;
  DAT_00003eec = 0;
  DAT_0000463f = 1;
  return;
}

```
