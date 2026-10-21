# Function_00045AAA

**ROM:** `0x00045AAA`

```c

void Function_00045AAA(char *param_1)

{
  char *pcVar1;
  char *extraout_A1;
  
  if ((*param_1 == 'O') || (*param_1 == 'W')) {
    if (DAT_0000365a == 0x2329) {
      DAT_00003694 = param_1[1] | 0x50;
      DAT_00003695 = 0xf1;
      DAT_00003696 = 0x10;
      DAT_00003697 = 0x3f;
      pcVar1 = (char *)&DAT_000036a0;
      for (DAT_000036a0 = 0; DAT_000036a0 != param_1[1]; DAT_000036a0 = DAT_000036a0 + 1) {
        (&DAT_00003694)[(short)(DAT_000036a0 + 4)] = param_1[DAT_000036a0 + 2];
      }
      (&DAT_00003694)[(short)((byte)param_1[1] + 4)] = 0;
      for (DAT_000036a0 = 0; (ushort)DAT_000036a0 != (ushort)((byte)param_1[1] + 4);
          DAT_000036a0 = DAT_000036a0 + 1) {
        (&DAT_00003694)[(short)((byte)param_1[1] + 4)] =
             (&DAT_00003694)[DAT_000036a0] + (&DAT_00003694)[(short)((byte)param_1[1] + 4)];
      }
      DAT_000036a1 = param_1[1] + '\x05';
      do {
        DAT_00003664 = DAT_00003b02;
      } while ((uint)(DAT_00003b02 - DAT_00003660) < 0x1a);
      DAT_0000365e = 3;
      DAT_000036a0 = 0;
      while (*pcVar1 != DAT_000036a1) {
        Function_00045418();
        *extraout_A1 = *extraout_A1 + '\x01';
        pcVar1 = extraout_A1;
      }
      DAT_0000365e = '\0';
      do {
      } while (-1 < (char)DAT_00fffc0d);
      DAT_00003660 = DAT_00003b02;
      DAT_00fffc0b = DAT_00fffc0b | 4;
    }
    else {
      DAT_00003694 = 0x48;
      DAT_00003695 = 0x6b;
      DAT_00003696 = 0x10;
      for (DAT_000036a0 = 0; DAT_000036a0 != param_1[1]; DAT_000036a0 = DAT_000036a0 + 1) {
        (&DAT_00003694)[(short)(DAT_000036a0 + 3)] = param_1[DAT_000036a0 + 2];
      }
      (&DAT_00003694)[(short)((byte)param_1[1] + 3)] = 0;
      for (DAT_000036a0 = 0; (ushort)DAT_000036a0 != (ushort)((byte)param_1[1] + 3);
          DAT_000036a0 = DAT_000036a0 + 1) {
        (&DAT_00003694)[(short)((byte)param_1[1] + 3)] =
             (&DAT_00003694)[DAT_000036a0] + (&DAT_00003694)[(short)((byte)param_1[1] + 3)];
      }
      DAT_000036a1 = param_1[1] + '\x04';
      do {
      } while ((uint)(DAT_00003b02 - DAT_00003660) < 10);
      do {
        DAT_00003664 = DAT_00003b02;
        if (((uint)DAT_00003672 <= (uint)(DAT_00003b02 - DAT_00003660)) ||
           ((DAT_00fffc0d >> 5 & 1) != 0)) break;
      } while ((DAT_00fffc0d >> 6 & 1) == 0);
      DAT_000036a0 = 0;
      if (DAT_0000365e == '\x04') {
        DAT_00003693 = 0;
      }
      else if ((DAT_00fffc0d >> 5 & 1) == 0) {
        if ((DAT_00fffc0d >> 6 & 1) == 0) {
          DAT_0000365e = '\x03';
          DAT_00003693 = 1;
          Function_00045418();
        }
        else {
          DAT_00003693 = 0;
        }
      }
      else {
        DAT_00003693 = 0;
        DAT_0000365e = '\x04';
      }
    }
  }
  else if (*param_1 == 'E') {
    DAT_0000365e = '\0';
    DAT_00fffc0b = DAT_00fffc0b | 4;
  }
  else if (*param_1 == 'D') {
    DAT_00003656 = 0;
    DAT_00fffc0b = DAT_00fffc0b & 0xfb;
  }
  return;
}

```
