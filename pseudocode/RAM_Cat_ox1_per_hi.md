# RAM_Cat_ox1_per_hi

**ROM:** `0x000037CA`

```c

void RAM_Cat_ox1_per_hi(void)

{
  DAT_00003b77 = 0;
  if (((DAT_0000103c & 0x80) == 0) && ((DAT_00001039 & 8) == 8)) {
    if (sRam00003b0e == 0) {
      if ((uRam00003b0c == 0) || (uRam00003b0c == 1)) {
        if (bRam00006a26 < DAT_0000111e) {
          if (DAT_0000111f < bRam00006a28) {
            if (uRam0000363e < uRam00006a2a) {
              if (uRam0000363e < uRam00006a2a) {
                uRam0000363e = uRam0000363e + 1;
                uRam00003b0c = 1;
              }
            }
            else {
              DAT_00003b77 = 1;
              uRam00003b0c = 1;
            }
          }
          else if (bRam00006a28 <= DAT_0000111f) {
            uRam0000363e = 0;
            uRam00003b0c = 0;
          }
        }
        else if (DAT_0000111e <= bRam00006a26) {
          uRam0000363e = 0;
          uRam00003b0c = 0;
        }
      }
      else if (bRam00006a28 <= DAT_0000111e) {
        uRam0000363e = 0;
        uRam00003b0c = 0;
      }
      if (uRam00003b0c == 1) {
        uRam00003b0c = 2;
      }
      else {
        uRam00003b0c = (ushort)(uRam00003b0c == 2);
      }
      if ((uRam00003b06 == 0) || (uRam00003b06 == 1)) {
        if (bRam00006a26 < DAT_0000111f) {
          if (DAT_0000111e < bRam00006a28) {
            if (uRam00003638 < uRam00006a2a) {
              if (uRam00003638 < uRam00006a2a) {
                uRam00003638 = uRam00003638 + 1;
                uRam00003b06 = 1;
              }
            }
            else {
              DAT_00003b77 = 4;
              uRam00003b06 = 1;
            }
          }
          else if (bRam00006a28 <= DAT_0000111e) {
            uRam00003638 = 0;
            uRam00003b06 = 0;
          }
        }
        else if (DAT_0000111f <= bRam00006a26) {
          uRam00003638 = 0;
          uRam00003b06 = 0;
        }
      }
      else if (bRam00006a28 <= DAT_0000111f) {
        uRam00003638 = 0;
        uRam00003b06 = 0;
      }
      if (uRam00003b06 == 1) {
        uRam00003b06 = 2;
      }
      else {
        uRam00003b06 = (ushort)(uRam00003b06 == 2);
      }
    }
    else if (sRam00003b0e == 0xb4) {
      if ((uRam00003b0a == 0) || (uRam00003b0a == 1)) {
        if (bRam00006a26 < DAT_0000111e) {
          if (DAT_0000111f < bRam00006a28) {
            if (uRam0000363c < uRam00006a2a) {
              if (uRam0000363c < uRam00006a2a) {
                uRam0000363c = uRam0000363c + 1;
                uRam00003b0a = 1;
              }
            }
            else {
              DAT_00003b77 = 2;
              uRam00003b0a = 1;
            }
          }
          else if (bRam00006a28 <= DAT_0000111f) {
            uRam0000363c = 0;
            uRam00003b0a = 0;
          }
        }
        else if (DAT_0000111e <= bRam00006a26) {
          uRam0000363c = 0;
          uRam00003b0a = 0;
        }
      }
      else if (bRam00006a28 <= DAT_0000111e) {
        uRam0000363c = 0;
        uRam00003b0a = 0;
      }
      if (uRam00003b0a == 1) {
        uRam00003b0a = 2;
      }
      else {
        uRam00003b0a = (ushort)(uRam00003b0a == 2);
      }
      if ((uRam00003b08 == 0) || (uRam00003b08 == 1)) {
        if (bRam00006a26 < DAT_0000111f) {
          if (DAT_0000111e < bRam00006a28) {
            if (uRam0000363a < uRam00006a2a) {
              if (uRam0000363a < uRam00006a2a) {
                uRam0000363a = uRam0000363a + 1;
                uRam00003b08 = 1;
              }
            }
            else {
              DAT_00003b77 = 3;
              uRam00003b08 = 1;
            }
          }
          else if (bRam00006a28 <= DAT_0000111e) {
            uRam0000363a = 0;
            uRam00003b08 = 0;
          }
        }
        else if (DAT_0000111f <= bRam00006a26) {
          uRam0000363a = 0;
          uRam00003b08 = 0;
        }
      }
      else if (bRam00006a28 <= DAT_0000111f) {
        uRam0000363a = 0;
        uRam00003b08 = 0;
      }
      if (uRam00003b08 == 1) {
        uRam00003b08 = 2;
      }
      else {
        uRam00003b08 = (ushort)(uRam00003b08 == 2);
      }
    }
  }
  else {
    uRam0000363e = 0;
    uRam0000363c = 0;
    uRam0000363a = 0;
    uRam00003638 = 0;
  }
  return;
}

```
