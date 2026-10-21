# Function_0004542E

**ROM:** `0x0004542E`

```c

void Function_0004542E(void)

{
  undefined1 *extraout_A1;
  
  if (DAT_00003656 == '\n') {
    if (DAT_0000365e == '\0') {
      DAT_00003664 = DAT_00003b02;
      if (DAT_00003660 + 0x13fe < DAT_00003b02) {
        DAT_00003656 = '\0';
        DAT_00003658 = 1;
        DAT_00fffc0b = DAT_00fffc0b & 0xfb;
      }
    }
    else if (DAT_0000365e == '\x01') {
      DAT_00003664 = DAT_00003b02;
      if (DAT_00003660 + 0x15 < DAT_00003b02) {
        if (DAT_0000365a == 0x2329) {
          if (DAT_00003669 < 5) {
            DAT_00003675 = '\0';
          }
          else {
            DAT_00003675 = DAT_00003669 - 5;
          }
        }
        else if (DAT_00003669 < 4) {
          DAT_00003675 = '\0';
        }
        else {
          DAT_00003675 = DAT_00003669 - 4;
        }
        DAT_00003668 = Function_00045D80();
        if (DAT_00003668 == '\x01') {
          *extraout_A1 = 2;
          DAT_0000366a = 1;
          if (DAT_0000365a == 0x2329) {
            DAT_00fffc0b = DAT_00fffc0b & 0xfb;
          }
        }
        else {
          *extraout_A1 = 0;
        }
      }
    }
    else if (DAT_0000365e == '\x02') {
      DAT_00003664 = DAT_00003b02;
      if ((DAT_00003660 + 0x1f < DAT_00003b02) && (DAT_0000365a == 0x2329)) {
        Function_00045418();
        DAT_00003660 = DAT_00003b02;
      }
    }
    else if ((((DAT_0000365e == '\x04') &&
              (DAT_00003664 = DAT_00003b02, (uint)DAT_00003672 < DAT_00003b02 - DAT_00003660)) &&
             (DAT_00003693 == '\0')) &&
            (((DAT_00fffc0d >> 5 & 1) == 0 && ((DAT_00fffc0d >> 6 & 1) == 0)))) {
      DAT_0000365e = '\x03';
      DAT_00003693 = '\x01';
      Function_00045418();
    }
  }
  return;
}

```
