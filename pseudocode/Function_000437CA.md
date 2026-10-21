# Function_000437CA

**ROM:** `0x000437CA`

```c

void Function_000437CA(void)

{
  DAT_00003b77 = 0;
  if (((DAT_0000103c & 0x80) == 0) && ((DAT_00001039 & 8) == 8)) {
    if (DAT_00003b0e == 0) {
      if ((DAT_00003b0c == 0) || (DAT_00003b0c == 1)) {
        if (RAM_Limit_low_ < DAT_0000111e) {
          if (DAT_0000111f < RAM_Ox1DeltaLoadLim_) {
            if (DAT_0000363e < RAM_Knock_start_) {
              if (DAT_0000363e < RAM_Knock_start_) {
                DAT_0000363e = DAT_0000363e + 1;
                DAT_00003b0c = 1;
              }
            }
            else {
              DAT_00003b77 = 1;
              DAT_00003b0c = 1;
            }
          }
          else if (RAM_Ox1DeltaLoadLim_ <= DAT_0000111f) {
            DAT_0000363e = 0;
            DAT_00003b0c = 0;
          }
        }
        else if (DAT_0000111e <= RAM_Limit_low_) {
          DAT_0000363e = 0;
          DAT_00003b0c = 0;
        }
      }
      else if (RAM_Ox1DeltaLoadLim_ <= DAT_0000111e) {
        DAT_0000363e = 0;
        DAT_00003b0c = 0;
      }
      if (DAT_00003b0c == 1) {
        DAT_00003b0c = 2;
      }
      else {
        DAT_00003b0c = (ushort)(DAT_00003b0c == 2);
      }
      if ((DAT_00003b06 == 0) || (DAT_00003b06 == 1)) {
        if (RAM_Limit_low_ < DAT_0000111f) {
          if (DAT_0000111e < RAM_Ox1DeltaLoadLim_) {
            if (DAT_00003638 < RAM_Knock_start_) {
              if (DAT_00003638 < RAM_Knock_start_) {
                DAT_00003638 = DAT_00003638 + 1;
                DAT_00003b06 = 1;
              }
            }
            else {
              DAT_00003b77 = 4;
              DAT_00003b06 = 1;
            }
          }
          else if (RAM_Ox1DeltaLoadLim_ <= DAT_0000111e) {
            DAT_00003638 = 0;
            DAT_00003b06 = 0;
          }
        }
        else if (DAT_0000111f <= RAM_Limit_low_) {
          DAT_00003638 = 0;
          DAT_00003b06 = 0;
        }
      }
      else if (RAM_Ox1DeltaLoadLim_ <= DAT_0000111f) {
        DAT_00003638 = 0;
        DAT_00003b06 = 0;
      }
      if (DAT_00003b06 == 1) {
        DAT_00003b06 = 2;
      }
      else {
        DAT_00003b06 = (ushort)(DAT_00003b06 == 2);
      }
    }
    else if (DAT_00003b0e == 0xb4) {
      if ((DAT_00003b0a == 0) || (DAT_00003b0a == 1)) {
        if (RAM_Limit_low_ < DAT_0000111e) {
          if (DAT_0000111f < RAM_Ox1DeltaLoadLim_) {
            if (DAT_0000363c < RAM_Knock_start_) {
              if (DAT_0000363c < RAM_Knock_start_) {
                DAT_0000363c = DAT_0000363c + 1;
                DAT_00003b0a = 1;
              }
            }
            else {
              DAT_00003b77 = 2;
              DAT_00003b0a = 1;
            }
          }
          else if (RAM_Ox1DeltaLoadLim_ <= DAT_0000111f) {
            DAT_0000363c = 0;
            DAT_00003b0a = 0;
          }
        }
        else if (DAT_0000111e <= RAM_Limit_low_) {
          DAT_0000363c = 0;
          DAT_00003b0a = 0;
        }
      }
      else if (RAM_Ox1DeltaLoadLim_ <= DAT_0000111e) {
        DAT_0000363c = 0;
        DAT_00003b0a = 0;
      }
      if (DAT_00003b0a == 1) {
        DAT_00003b0a = 2;
      }
      else {
        DAT_00003b0a = (ushort)(DAT_00003b0a == 2);
      }
      if ((DAT_00003b08 == 0) || (DAT_00003b08 == 1)) {
        if (RAM_Limit_low_ < DAT_0000111f) {
          if (DAT_0000111e < RAM_Ox1DeltaLoadLim_) {
            if (DAT_0000363a < RAM_Knock_start_) {
              if (DAT_0000363a < RAM_Knock_start_) {
                DAT_0000363a = DAT_0000363a + 1;
                DAT_00003b08 = 1;
              }
            }
            else {
              DAT_00003b77 = 3;
              DAT_00003b08 = 1;
            }
          }
          else if (RAM_Ox1DeltaLoadLim_ <= DAT_0000111e) {
            DAT_0000363a = 0;
            DAT_00003b08 = 0;
          }
        }
        else if (DAT_0000111f <= RAM_Limit_low_) {
          DAT_0000363a = 0;
          DAT_00003b08 = 0;
        }
      }
      else if (RAM_Ox1DeltaLoadLim_ <= DAT_0000111f) {
        DAT_0000363a = 0;
        DAT_00003b08 = 0;
      }
      if (DAT_00003b08 == 1) {
        DAT_00003b08 = 2;
      }
      else {
        DAT_00003b08 = (ushort)(DAT_00003b08 == 2);
      }
    }
  }
  else {
    DAT_0000363e = 0;
    DAT_0000363c = 0;
    DAT_0000363a = 0;
    DAT_00003638 = 0;
  }
  return;
}

```
