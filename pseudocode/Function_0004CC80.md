# Function_0004CC80

**ROM:** `0x0004CC80`

```c

void Function_0004CC80(void)

{
  byte *extraout_A1;
  
  if (-1 < DAT_00003ee6) {
    Function_0004CF86();
    RAM_PMProt_RpmIdleNomRef = DAT_00001160 * 10;
    if ((*extraout_A1 & 0x40) == 0) {
      if (-1 < (char)*extraout_A1) {
        *extraout_A1 = *extraout_A1 | 0x20;
        *extraout_A1 = *extraout_A1 | 8;
        *extraout_A1 = *extraout_A1 & 0xfb;
        *extraout_A1 = *extraout_A1 & 0xef;
        *extraout_A1 = *extraout_A1 & 0xfd;
        *extraout_A1 = *extraout_A1 & 0xfe;
        DAT_00003ee7 = DAT_00003ee7 & 0x7f;
        DAT_0000379e = 0;
        DAT_0000379c = 0;
      }
    }
    else if ((*extraout_A1 & 8) == 0) {
      if ((*extraout_A1 & 4) == 0) {
        if ((*extraout_A1 & 0x10) == 0) {
          if ((*extraout_A1 & 2) == 0) {
            if ((*extraout_A1 & 1) == 0) {
              if ((DAT_00003ee7 & 0x80) != 0) {
                Function_0004DFA6();
              }
            }
            else {
              Function_0004DF30();
            }
          }
          else {
            Function_0004DD94();
          }
        }
        else {
          Function_0004D134();
        }
      }
      else {
        Function_0004D0FA();
      }
    }
    else {
      RAM_PMProt = (ushort)RAM_Cyl_nr * 10;
      *extraout_A1 = *extraout_A1 & 0xf7;
      *extraout_A1 = *extraout_A1 | 4;
    }
  }
  return;
}

```
