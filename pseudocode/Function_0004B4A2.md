# Function_0004B4A2

**ROM:** `0x0004B4A2`

```c

void Function_0004B4A2(undefined4 param_1)

{
  char *extraout_A1;
  undefined2 uVar1;
  
  if (param_1._1_1_ == '\0') {
    DAT_00003542 = DAT_00003e9c;
    DAT_0000352a = DAT_0000375e;
    if (DAT_0000375e == 0) {
      DAT_00003762 = 0;
      uVar1 = 0xd;
      Function_0004ABC8();
      Function_0004ABC8(uVar1);
      return;
    }
    DAT_0000352e = '\x0f';
  }
  if (DAT_0000352e == '\0') {
    DAT_00003762 = 0;
    uVar1 = 0xd;
    Function_0004ABC8();
    Function_0004ABC8(uVar1);
  }
  else {
    Function_0004B8F8((short)DAT_00003542);
    DAT_00003542 = DAT_00003542 + 1;
    DAT_0000352a = DAT_0000352a + -1;
    if (DAT_0000352a == 0) {
      if (*extraout_A1 == '\x0f') {
        DAT_00003542 = DAT_00003e98;
        DAT_0000352a = DAT_0000375c;
      }
      else if (*extraout_A1 == '\x0e') {
        DAT_00003542 = DAT_00003e94;
        DAT_0000352a = DAT_0000375a;
      }
      else if (*extraout_A1 == '\r') {
        DAT_00003542 = DAT_00003e90;
        DAT_0000352a = DAT_00003758;
      }
      else if (*extraout_A1 == '\f') {
        DAT_00003542 = DAT_00003e8c;
        DAT_0000352a = DAT_00003756;
      }
      else if (*extraout_A1 == '\v') {
        DAT_00003542 = DAT_00003e88;
        DAT_0000352a = DAT_00003754;
      }
      else if (*extraout_A1 == '\n') {
        DAT_00003542 = DAT_00003e84;
        DAT_0000352a = DAT_00003752;
      }
      else if (*extraout_A1 == '\t') {
        DAT_00003542 = DAT_00003e80;
        DAT_0000352a = DAT_00003750;
      }
      else if (*extraout_A1 == '\b') {
        DAT_00003542 = DAT_00003e7c;
        DAT_0000352a = DAT_0000374e;
      }
      else if (*extraout_A1 == '\a') {
        DAT_00003542 = DAT_00003e78;
        DAT_0000352a = DAT_0000374c;
      }
      else if (*extraout_A1 == '\x06') {
        DAT_00003542 = DAT_00003e74;
        DAT_0000352a = DAT_0000374a;
      }
      else if (*extraout_A1 == '\x05') {
        DAT_00003542 = DAT_00003e70;
        DAT_0000352a = DAT_00003748;
      }
      else if (*extraout_A1 == '\x04') {
        DAT_00003542 = DAT_00003e6c;
        DAT_0000352a = DAT_00003746;
      }
      else if (*extraout_A1 == '\x03') {
        DAT_00003542 = DAT_00003e68;
        DAT_0000352a = DAT_00003744;
      }
      else if (*extraout_A1 == '\x02') {
        DAT_00003542 = DAT_00003e64;
        DAT_0000352a = DAT_00003742;
      }
      else {
        DAT_0000352a = 0;
        *extraout_A1 = '\0';
      }
      if (DAT_0000352a == 0) {
        *extraout_A1 = '\0';
      }
      else {
        *extraout_A1 = *extraout_A1 + -1;
      }
    }
  }
  return;
}

```
