# Function_0005E55E

**ROM:** `0x0005E55E`

```c

void Function_0005E55E(void)

{
  byte bVar1;
  
  if ((RAM_Samp_pek[9] & 8) == 0) {
    if ((uint)RAM_Crankshaft_error < 1000) {
      DAT_00003fbe = DAT_00001a58;
    }
    else if (DAT_00003fc4 < 0x60) {
      DAT_00003fbe = DAT_00001a58;
    }
    if ((DAT_00003fbe + 10 < DAT_00001a58) && (DAT_000072a2 < RAM_Bil_hast)) {
      RAM_Samp_pek[9] = RAM_Samp_pek[9] | 8;
    }
    else {
      if ((2000 < (uint)RAM_Crankshaft_error) &&
         (((RAM_Samp_pek[9] & 2) == 0 && ((RAM_Samp_pek[0xb] & 0x40) == 0)))) {
        if (DAT_0000332c < 0x28) {
          bVar1 = DAT_00003fe8 >> 6;
        }
        else {
          bVar1 = DAT_00003fe8 >> 5;
        }
        if ((bVar1 & 1) != 0) {
          if (DAT_0000332c != 0) {
            DAT_0000332c = DAT_0000332c - 1;
            RAM_Samp_pek[9] = RAM_Samp_pek[9] | 2;
          }
          goto LAB_0005e662;
        }
      }
      if (DAT_0000332c == 0) {
        DAT_000040e6 = DAT_000040e6 & 0xbf;
      }
    }
  }
LAB_0005e662:
  if ((RAM_Samp_pek[9] & 4) == 0) {
    if ((uint)RAM_Crankshaft_error < 1000) {
      DAT_00003fba = DAT_00001a58;
    }
    else if (DAT_00003fc2 < 0x60) {
      DAT_00003fba = DAT_00001a58;
    }
    if ((DAT_00003fba + 10 < DAT_00001a58) && (DAT_000072a2 < RAM_Bil_hast)) {
      RAM_Samp_pek[9] = RAM_Samp_pek[9] | 4;
    }
    else {
      if ((2000 < (uint)RAM_Crankshaft_error) &&
         (((RAM_Samp_pek[9] & 1) == 0 && ((RAM_Samp_pek[0xb] & 0x40) == 0)))) {
        if (DAT_0000332d < 0x28) {
          bVar1 = DAT_00003fe8 >> 6;
        }
        else {
          bVar1 = DAT_00003fe8 >> 5;
        }
        if ((bVar1 & 1) != 0) {
          if (DAT_0000332d == 0) {
            return;
          }
          RAM_Samp_pek[9] = RAM_Samp_pek[9] | 1;
          DAT_0000332d = DAT_0000332d - 1;
          return;
        }
      }
      if (DAT_0000332d == 0) {
        DAT_000040e6 = DAT_000040e6 & 0xdf;
      }
    }
  }
  return;
}

```
