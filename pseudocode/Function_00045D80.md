# Function_00045D80

**ROM:** `0x00045D80`

```c

bool Function_00045D80(void)

{
  char cVar1;
  bool bVar2;
  
  if (DAT_0000365a == 0x2329) {
    bVar2 = false;
    if (DAT_00003682 == '?' &&
        (DAT_00003681 == 0xf1 && (DAT_00003680 == '\x10' && (DAT_0000367f & 0xf8) == 0x70))) {
      cVar1 = '\0';
      for (DAT_00003669 = 0; (ushort)DAT_00003669 != (ushort)(DAT_00003675 + 4);
          DAT_00003669 = DAT_00003669 + 1) {
        cVar1 = (&DAT_0000367f)[DAT_00003669] + cVar1;
      }
      bVar2 = cVar1 == (&DAT_0000367f)[(short)(DAT_00003675 + 4)];
      for (DAT_00003669 = 0; DAT_00003669 != DAT_00003675; DAT_00003669 = DAT_00003669 + 1) {
        (&DAT_00003676)[DAT_00003669] = (&DAT_0000367f)[(short)(DAT_00003669 + 4)];
      }
      DAT_00003674 = 0x57;
    }
  }
  else {
    cVar1 = '\0';
    for (DAT_00003669 = 0; (ushort)DAT_00003669 != (ushort)(DAT_00003675 + 3);
        DAT_00003669 = DAT_00003669 + 1) {
      cVar1 = (&DAT_0000367f)[DAT_00003669] + cVar1;
    }
    bVar2 = cVar1 == (&DAT_0000367f)[(short)(DAT_00003675 + 3)] &&
            (0xef < DAT_00003681 && (DAT_00003680 == 'j' && DAT_0000367f == 0x68));
    for (DAT_00003669 = 0; DAT_00003669 != DAT_00003675; DAT_00003669 = DAT_00003669 + 1) {
      (&DAT_00003676)[DAT_00003669] = (&DAT_0000367f)[(short)(DAT_00003669 + 3)];
    }
    DAT_00003674 = 0x4f;
  }
  return bVar2;
}

```
