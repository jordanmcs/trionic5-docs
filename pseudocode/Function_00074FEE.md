# Function_00074FEE

**ROM:** `0x00074FEE`

```c

void Function_00074FEE(void)

{
  char cVar1;
  
  DAT_0000486e = DAT_0000486e + 1;
  cVar1 = DAT_00003a9a;
  if (DAT_00003a9a != '\0') {
    cVar1 = DAT_00003a9a + '\x01';
    switch(DAT_00003a9a) {
    case '\x01':
      DAT_00fffc15 = DAT_00fffc15 | 0x80;
      break;
    case '\x02':
    case '\x03':
      break;
    case '\x04':
      DAT_00fffc15 = DAT_00fffc15 & 0x7f;
    case '\x05':
    case '\x06':
    case '\a':
      break;
    case '\b':
      DAT_00fffc15 = DAT_00fffc15 | 0x80;
      break;
    case '\t':
      DAT_00003a9a = '\0';
      DAT_000035fe = &DAT_00003aa2;
      DAT_00003aa0 = 9;
      DAT_000035fa = RAM_TDWFSVNX;
      DAT_00003a9e = 9;
      DAT_00fffc0b = DAT_00fffc0b | 0xac;
      cVar1 = DAT_00003a9a;
      break;
    default:
      DAT_00003a9a = '\0';
      cVar1 = DAT_00003a9a;
    }
  }
  DAT_00003a9a = cVar1;
  return;
}

```
