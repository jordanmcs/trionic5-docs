# Function_00044E50

**ROM:** `0x00044E50`

```c

void Function_00044E50(void)

{
  char cVar1;
  byte bVar2;
  undefined1 *extraout_A1;
  undefined1 *extraout_A1_00;
  undefined1 *extraout_A1_01;
  undefined1 *extraout_A1_02;
  undefined1 *extraout_A1_03;
  undefined1 *extraout_A1_04;
  undefined1 *puVar3;
  undefined1 *extraout_A1_05;
  undefined1 *extraout_A1_06;
  undefined1 *extraout_A1_07;
  undefined1 *extraout_A1_08;
  undefined1 *extraout_A1_09;
  
  Function_00074FEE();
  if ((DAT_00003a9c == '\0') && (DAT_00003656 != '\n')) {
    if (DAT_00003656 == '\0') {
      cVar1 = Function_00044B60();
      if (cVar1 == '\x01') {
        DAT_00003658 = DAT_00003658 + 1;
        if (DAT_00003658 == 3) {
          *extraout_A1 = 1;
        }
      }
      else {
        DAT_00003658 = 0;
      }
    }
    else if (DAT_00003656 == '\x01') {
      cVar1 = Function_00044B60();
      if (cVar1 == '\0') {
        *extraout_A1_00 = 2;
        DAT_00003500 = 1;
      }
    }
    else if (DAT_00003656 == '\x02') {
      DAT_00003500 = DAT_00003500 + 1;
      if (DAT_00003500 == 3) {
        DAT_000034e2 = Function_00044B60();
      }
      else if (DAT_00003500 == 5) {
        DAT_0000351c = Function_00044B60();
        if ((DAT_000034e2 == '\x01') && (DAT_0000351c == '\x01')) {
          *extraout_A1_01 = 0;
          DAT_00003658 = 1;
        }
      }
      else if (DAT_00003500 == 7) {
        cVar1 = Function_00044B60();
        if (((DAT_000034e2 == '\x01') || (DAT_0000351c == '\x01')) && (cVar1 == '\x01')) {
          *extraout_A1_02 = 0;
          DAT_00003658 = 1;
        }
      }
      else if (DAT_00003500 == 0x14) {
        DAT_00003656 = '\x03';
        DAT_00003500 = 0;
        DAT_00003518 = 0;
        DAT_00003514 = '\0';
      }
    }
    else if (DAT_00003656 == '\x03') {
      DAT_00003500 = DAT_00003500 + 1;
      if (DAT_00003500 == 8) {
        DAT_00003510 = Function_00044B60();
      }
      else if (DAT_00003500 == 9) {
        DAT_00003538 = Function_00044B60();
      }
      else if (DAT_00003500 == 10) {
        bVar2 = Function_00044B60();
        DAT_00003518 = (short)DAT_00003518 >> 1;
        if (1 < (ushort)((ushort)DAT_00003510 + (ushort)DAT_00003538 + (ushort)bVar2)) {
          DAT_00003518 = DAT_00003518 | 0x100;
        }
      }
      else if ((10 < DAT_00003500) &&
              ((((cVar1 = Function_00044B60(), puVar3 = extraout_A1_03, cVar1 == '\0' &&
                 ((DAT_00003518 & 0x100) == 0x100)) || (DAT_00003500 == 0x15)) ||
               ((cVar1 = Function_00044B60(), cVar1 == '\x01' &&
                (puVar3 = extraout_A1_04, (DAT_00003518 & 0x100) == 0)))))) {
        DAT_00003500 = 1;
        DAT_00003514 = DAT_00003514 + '\x01';
        if (DAT_00003514 == '\t') {
          if ((((DAT_00003518 & 0xff) == 0x10) || ((DAT_00003518 & 0xff) == 0x33)) &&
             ((DAT_00003518 & 0x100) == 0x100)) {
            *puVar3 = 4;
            if ((DAT_00003518 & 0xff) == 0x33) {
              DAT_0000365a = 0x23b5;
              DAT_00003534 = Function_00045A6E(0x22);
              DAT_0000366e = '\0';
              DAT_0000365c = '\0';
              DAT_00fffc0b = DAT_00fffc0b | 4;
            }
            else {
              DAT_0000365a = 0x2329;
            }
            DAT_0000366f = 0;
          }
          else {
            *puVar3 = 0;
            DAT_00003658 = 1;
          }
        }
      }
    }
    else if (DAT_00003656 == '\x04') {
      DAT_0000366f = DAT_0000366f + 1;
      if (DAT_0000365a == 0x2329) {
        if (DAT_0000366f == 0x12) {
          Function_00045418();
          *extraout_A1_05 = 5;
        }
      }
      else if (DAT_0000366f == DAT_00003534) {
        if ((DAT_00fffc0d >> 5 & 1) == 0) {
          DAT_00003656 = '\x05';
          Function_00045418();
        }
      }
      else if (DAT_0000366f == 0x23) {
        DAT_00003656 = '\0';
        DAT_00003658 = 1;
        DAT_00fffc0b = DAT_00fffc0b & 0xfb;
      }
    }
    else if (DAT_00003656 == '\x05') {
      if (DAT_0000365a == 0x2329) {
        Function_00045418();
        *extraout_A1_06 = 6;
      }
      else if (DAT_0000366e == '\x02') {
        Function_00045418();
        *extraout_A1_07 = 6;
      }
      else if (DAT_0000366e == '\x01') {
        DAT_0000366f = DAT_0000366f + 1;
        if (DAT_0000366f == 3) {
          DAT_00003656 = '\0';
          DAT_00003658 = 1;
          DAT_00fffc0b = DAT_00fffc0b & 0xfb;
        }
      }
      else {
        DAT_00003656 = '\0';
        DAT_00003658 = 1;
        DAT_00fffc0b = DAT_00fffc0b & 0xfb;
      }
    }
    else if (DAT_00003656 == '\x06') {
      if (DAT_0000365a == 0x2329) {
        Function_00045418();
        *extraout_A1_08 = 8;
        DAT_0000366f = 0;
        DAT_0000365c = '\0';
      }
      else if (DAT_0000366e == '\x02') {
        Function_00045418();
        *extraout_A1_09 = 7;
        DAT_0000366f = 0;
      }
      else if ((DAT_0000366e == '\x01') && (DAT_0000366f = DAT_0000366f + 1, DAT_0000366f == 3)) {
        DAT_00003656 = '\0';
        DAT_00003658 = 1;
        DAT_00fffc0b = DAT_00fffc0b & 0xfb;
      }
    }
    else if (DAT_00003656 == '\a') {
      DAT_0000366f = DAT_0000366f + 1;
      if (DAT_0000366f == 3) {
        DAT_00003656 = '\0';
        DAT_00003658 = 1;
        DAT_00fffc0b = DAT_00fffc0b & 0xfb;
      }
    }
    else if (DAT_00003656 == '\b') {
      DAT_0000366f = DAT_0000366f + 1;
      if (DAT_0000366f == 1) {
        if (DAT_0000365a == 0x2329) {
          DAT_00fffc0b = DAT_00fffc0b | 4;
        }
      }
      else if (DAT_0000365c == '\x01') {
        if (((DAT_0000365a == 0x2329) && (DAT_0000365d == -0x47)) ||
           ((DAT_0000365a == 0x23b5 && (DAT_0000365d == -9)))) {
          DAT_00003656 = '\t';
          DAT_0000366f = 0;
          if (DAT_0000365a == 0x2329) {
            DAT_00fffc0b = DAT_00fffc0b & 0xfb;
          }
        }
        else {
          DAT_00003656 = '\0';
          DAT_00003658 = 1;
          DAT_00fffc0b = DAT_00fffc0b & 0xfb;
        }
      }
      else if (DAT_0000366f == 6) {
        DAT_00003656 = '\0';
        DAT_00003658 = 1;
        DAT_00fffc0b = DAT_00fffc0b & 0xfb;
      }
    }
    else if (DAT_00003656 == '\t') {
      DAT_0000366f = DAT_0000366f + 1;
      if (DAT_0000365a == 0x2329) {
        if (DAT_0000366f == 3) {
          Function_00045418();
          DAT_00003660 = DAT_00003b02;
        }
        else if (DAT_0000366f == 4) {
          DAT_00003656 = '\n';
          DAT_0000365e = 0;
          DAT_00fffc0b = DAT_00fffc0b | 4;
        }
      }
      else if ((DAT_0000366e == '\x02') && (DAT_0000366f == 3)) {
        Function_00045418();
      }
    }
  }
  return;
}

```
