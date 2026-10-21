# Function_0004DFA6

**ROM:** `0x0004DFA6`

```c

void Function_0004DFA6(void)

{
  DAT_00003ee7 = DAT_00003ee7 | 4;
  DAT_00003798 = DAT_00003798 + 1;
  if ((DAT_00003ee6 >> 5 & 1) == 0) {
    DAT_00003ee6 = DAT_00003ee6 | 0x80;
  }
  else if (DAT_000074f4 <= DAT_00003798) {
    DAT_00003ee6 = DAT_00003ee6 | 0x80;
  }
  return;
}

```
