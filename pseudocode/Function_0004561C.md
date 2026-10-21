# Function_0004561C

**ROM:** `0x0004561C`

```c

void Function_0004561C(void)

{
  char cVar1;
  byte bVar2;
  undefined1 uVar3;
  
  if (DAT_00003a9c == '\0') {
    if ((((DAT_00fffc0d >> 1 & 1) == 1) || ((DAT_00fffc0d >> 3 & 1) == 1)) ||
       ((DAT_00fffc0d >> 2 & 1) == 1)) {
      Function_000455FE();
    }
    else if (DAT_00003656 == '\n') {
      if (DAT_0000365e == '\0') {
        DAT_00003664 = DAT_00003b02;
        bVar2 = Function_000455FE();
        if ((DAT_00003660 + 0x34 < DAT_00003664) && (bVar2 != 6)) {
          DAT_00003669 = 1;
          if (DAT_0000365a == 0x2329) {
            DAT_00003675 = bVar2 & 7;
          }
          else {
            DAT_00003675 = 2;
          }
          DAT_0000365e = '\x01';
          DAT_0000367f = bVar2;
        }
        DAT_00003660 = DAT_00003b02;
      }
      else if (DAT_0000365e == '\x01') {
        DAT_00003660 = DAT_00003b02;
        if (DAT_00003669 == 0x14) {
          Function_000455FE();
        }
        else {
          uVar3 = Function_000455FE();
          (&DAT_0000367f)[DAT_00003669] = uVar3;
          DAT_00003669 = DAT_00003669 + 1;
        }
        if ((DAT_0000365a == 0x23b5) && (DAT_00003669 == 4)) {
          if (DAT_00003682 == '\x01') {
            DAT_00003675 = 1;
          }
          else if (DAT_00003682 == '\x02') {
            DAT_00003675 = 2;
          }
          else if (DAT_00003682 == '\x03') {
            DAT_00003675 = 0;
          }
          else if (DAT_00003682 == '\x04') {
            DAT_00003675 = 0;
          }
          else {
            DAT_00003675 = 2;
          }
        }
        if ((ushort)DAT_00003669 == (ushort)(DAT_00003675 + 5)) {
          if (DAT_0000365a == 0x23b5) {
            DAT_00003675 = DAT_00003675 + 1;
          }
          DAT_00003668 = Function_00045D80();
          if (DAT_00003668 == '\x01') {
            DAT_0000365e = '\x02';
            if (DAT_0000365a == 0x2329) {
              DAT_00fffc0b = DAT_00fffc0b & 0xfb;
            }
            Function_0006135C(0x3674);
          }
          else {
            DAT_0000365e = '\0';
          }
        }
      }
      else if (DAT_0000365e == '\x02') {
        DAT_00003660 = DAT_00003b02;
        DAT_0000365e = '\x04';
        Function_000455FE();
      }
      else if (DAT_0000365e == '\x04') {
        DAT_00003660 = DAT_00003b02;
        Function_000455FE();
      }
      else if (DAT_0000365e == '\x03') {
        DAT_00003660 = DAT_00003b02;
        cVar1 = Function_000455FE();
        if (cVar1 == (&DAT_00003694)[DAT_000036a0]) {
          DAT_000036a0 = DAT_000036a0 + 1;
          if (DAT_000036a0 == DAT_000036a1) {
            DAT_0000365e = '\0';
            DAT_00003660 = DAT_00003b02;
          }
          else {
            Function_00045418();
          }
        }
        else {
          DAT_0000365e = '\x04';
          DAT_00003672 = Function_00045A6E(0x23);
          DAT_00003693 = 0;
          DAT_000036a0 = 0;
        }
      }
      else {
        Function_000455FE();
      }
    }
    else if (DAT_00003656 == '\x04') {
      cVar1 = Function_000455FE();
      if (cVar1 == 'U') {
        DAT_0000366e = '\x01';
        DAT_00003656 = '\x05';
        DAT_0000366f = 0;
      }
      else {
        DAT_00003656 = '\0';
        DAT_00003658 = 1;
        DAT_00fffc0b = DAT_00fffc0b & 0xfb;
      }
    }
    else if (DAT_00003656 == '\x05') {
      if (DAT_0000366e == '\0') {
        cVar1 = Function_000455FE();
        if (cVar1 == 'U') {
          DAT_0000366e = '\x02';
        }
        else {
          DAT_00003656 = '\0';
          DAT_00003658 = 1;
          DAT_00fffc0b = DAT_00fffc0b & 0xfb;
        }
      }
      else {
        cVar1 = Function_000455FE();
        if (cVar1 == '\b') {
          DAT_00003656 = '\x06';
          DAT_0000366f = 0;
        }
        else {
          DAT_00003656 = '\0';
          DAT_00003658 = 1;
          DAT_00fffc0b = DAT_00fffc0b & 0xfb;
        }
      }
    }
    else if (DAT_00003656 == '\x06') {
      if (DAT_0000366e == '\x02') {
        cVar1 = Function_000455FE();
        if (cVar1 != '\b') {
          DAT_00003656 = '\0';
          DAT_00003658 = 1;
          DAT_00fffc0b = DAT_00fffc0b & 0xfb;
        }
      }
      else {
        cVar1 = Function_000455FE();
        if (cVar1 == '\b') {
          DAT_00003656 = '\b';
          DAT_0000366f = 0;
        }
        else {
          DAT_00003656 = '\0';
          DAT_00003658 = 1;
          DAT_00fffc0b = DAT_00fffc0b & 0xfb;
        }
      }
    }
    else if (DAT_00003656 == '\a') {
      cVar1 = Function_000455FE();
      if (cVar1 == '\b') {
        DAT_00003656 = '\b';
        DAT_0000366f = 0;
      }
      else {
        DAT_00003656 = '\0';
        DAT_00003658 = 1;
        DAT_00fffc0b = DAT_00fffc0b & 0xfb;
      }
    }
    else if (DAT_00003656 == '\b') {
      DAT_0000365d = Function_000455FE();
      DAT_0000365c = 1;
    }
    else {
      cVar1 = Function_000455FE();
      if (cVar1 == -0x34) {
        DAT_00003656 = '\n';
        DAT_0000365e = '\0';
        DAT_00003660 = DAT_00003b02;
      }
      else {
        DAT_00003656 = '\0';
        DAT_00003658 = 1;
        DAT_00fffc0b = DAT_00fffc0b & 0xfb;
      }
    }
  }
  else {
    Function_000754BC();
  }
  return;
}

```
