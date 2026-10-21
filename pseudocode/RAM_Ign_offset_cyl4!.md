# RAM_Ign_offset_cyl4!

**ROM:** `0x00005AAA`

```c

void RAM_Ign_offset_cyl4_(char *param_1)

{
  char *pcVar1;
  char *pcVar2;
  char *extraout_A1;
  
  if ((*param_1 == 'O') || (*param_1 == 'W')) {
    if (sRam0000365a == 0x2329) {
      bRam00003694 = param_1[1] | 0x50;
      uRam00003695 = 0xf1;
      uRam00003696 = 0x10;
      uRam00003697 = 0x3f;
      pcVar2 = (char *)0x36a0;
      for (bRam000036a0 = 0; bRam000036a0 != param_1[1]; bRam000036a0 = bRam000036a0 + 1) {
        *(char *)((short)(bRam000036a0 + 4) + 0x3694) = param_1[bRam000036a0 + 2];
      }
      *(undefined1 *)((short)((byte)param_1[1] + 4) + 0x3694) = 0;
      for (bRam000036a0 = 0; (ushort)bRam000036a0 != (ushort)((byte)param_1[1] + 4);
          bRam000036a0 = bRam000036a0 + 1) {
        pcVar1 = (char *)((short)((byte)param_1[1] + 4) + 0x3694);
        *pcVar1 = *(char *)(bRam000036a0 + 0x3694) + *pcVar1;
      }
      cRam000036a1 = param_1[1] + '\x05';
      do {
        iRam00003664 = iRam00003b02;
      } while ((uint)(iRam00003b02 - iRam00003660) < 0x1a);
      cRam0000365e = 3;
      bRam000036a0 = 0;
      while (*pcVar2 != cRam000036a1) {
        Function_00045418();
        *extraout_A1 = *extraout_A1 + '\x01';
        pcVar2 = extraout_A1;
      }
      cRam0000365e = '\0';
      do {
      } while (-1 < (char)DAT_00fffc0d);
      iRam00003660 = iRam00003b02;
      DAT_00fffc0b = DAT_00fffc0b | 4;
    }
    else {
      bRam00003694 = 0x48;
      uRam00003695 = 0x6b;
      uRam00003696 = 0x10;
      for (bRam000036a0 = 0; bRam000036a0 != param_1[1]; bRam000036a0 = bRam000036a0 + 1) {
        *(char *)((short)(bRam000036a0 + 3) + 0x3694) = param_1[bRam000036a0 + 2];
      }
      *(undefined1 *)((short)((byte)param_1[1] + 3) + 0x3694) = 0;
      for (bRam000036a0 = 0; (ushort)bRam000036a0 != (ushort)((byte)param_1[1] + 3);
          bRam000036a0 = bRam000036a0 + 1) {
        pcVar2 = (char *)((short)((byte)param_1[1] + 3) + 0x3694);
        *pcVar2 = *(char *)(bRam000036a0 + 0x3694) + *pcVar2;
      }
      cRam000036a1 = param_1[1] + '\x04';
      do {
      } while ((uint)(iRam00003b02 - iRam00003660) < 10);
      do {
        iRam00003664 = iRam00003b02;
        if (((uint)uRam00003672 <= (uint)(iRam00003b02 - iRam00003660)) ||
           ((DAT_00fffc0d >> 5 & 1) != 0)) break;
      } while ((DAT_00fffc0d >> 6 & 1) == 0);
      bRam000036a0 = 0;
      if (cRam0000365e == '\x04') {
        uRam00003693 = 0;
      }
      else if ((DAT_00fffc0d >> 5 & 1) == 0) {
        if ((DAT_00fffc0d >> 6 & 1) == 0) {
          cRam0000365e = '\x03';
          uRam00003693 = 1;
          Function_00045418();
        }
        else {
          uRam00003693 = 0;
        }
      }
      else {
        uRam00003693 = 0;
        cRam0000365e = '\x04';
      }
    }
  }
  else if (*param_1 == 'E') {
    cRam0000365e = '\0';
    DAT_00fffc0b = DAT_00fffc0b | 4;
  }
  else if (*param_1 == 'D') {
    uRam00003656 = 0;
    DAT_00fffc0b = DAT_00fffc0b & 0xfb;
  }
  return;
}

```
