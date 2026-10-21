# Function_0004434A

**ROM:** `0x0004434A`

```c

void Function_0004434A(void)

{
  if ((DAT_0000103c & 0x80) == 0) {
    if (DAT_00003654 == '\0') {
      if (DAT_00003b7c == 0x73) {
        if (DAT_00003b77 == '\x01') {
          DAT_00003654 = 1;
          DAT_00003b6a = 0xb4;
          DAT_000034e4 = '\x01';
        }
        else {
          if (DAT_00003b77 == '\x04') {
            DAT_00003654 = 4;
          }
          else {
            DAT_00003654 = 0;
          }
          DAT_00003b6a = 0xb4;
          DAT_000034e4 = '\x01';
        }
      }
      else if (DAT_00003b77 == '\x02') {
        DAT_00003654 = 2;
        DAT_00003b6a = 0;
        DAT_000034e4 = '\x01';
      }
      else if (DAT_00003b77 == '\x03') {
        DAT_00003654 = 3;
        DAT_00003b6a = 0;
        DAT_000034e4 = '\x01';
      }
      else {
        DAT_00003654 = 0;
        DAT_00003b6a = 0;
        DAT_000034e4 = '\x01';
      }
    }
    else if (DAT_00003b7c == 0x127) {
      if (DAT_00003654 == '\x01') {
        DAT_00003654 = 3;
        DAT_00003b6a = 0;
        DAT_000034e4 = '\x01';
      }
      else {
        DAT_00003b6a = 0;
        DAT_00003654 = 0;
        DAT_000034e4 = '\x01';
      }
    }
    else {
      if (DAT_00003654 == '\x02') {
        DAT_00003654 = 1;
      }
      else if (DAT_00003654 == '\x03') {
        DAT_00003654 = 4;
      }
      else {
        DAT_00003654 = 0;
      }
      DAT_00003b6a = 0xb4;
      DAT_000034e4 = '\x01';
    }
  }
  else if (DAT_00003b7c == 0x127) {
    if (DAT_000034e4 == '\0') {
      DAT_000034e4 = '\x01';
      DAT_00003b6a = 0x168;
      DAT_00003654 = 0;
    }
    else {
      DAT_000034e4 = '\0';
      DAT_00003b6a = 0;
      DAT_00003654 = 0;
    }
  }
  else {
    if (DAT_000034e4 == '\x01') {
      DAT_00003b6a = 0x21c;
    }
    else {
      DAT_00003b6a = 0xb4;
    }
    DAT_00003654 = 0;
  }
  return;
}

```
