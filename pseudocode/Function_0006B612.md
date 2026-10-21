# Function_0006B612

**ROM:** `0x0006B612`

```c

void Function_0006B612(void)

{
  for (DAT_0000351e = 0;
      ((&DAT_00004e72)[(short)(ushort)DAT_0000351e] < DAT_00001066 && (DAT_0000351e != 0xf));
      DAT_0000351e = DAT_0000351e + 1) {
  }
  if ((DAT_00001039 & 0x10) == 0) {
    DAT_00003a06 = 0;
    DAT_00003a19 = DAT_00003a19 & 0xfe;
    DAT_00003a08 = 0;
  }
  else if (((DAT_0000103a & 4) == 0) ||
          (((RAM_Ramp_steg_[1] & 0x80) != 0 && (DAT_0000101c == '\0')))) {
    if (RAM_Open_loop_[(short)(ushort)DAT_0000351e] < DAT_00001037) {
      DAT_00003a06 = 0;
      DAT_00003a19 = DAT_00003a19 & 0xfe;
      DAT_00003a08 = 0;
    }
    else if ((DAT_0000103a & 2) == 0) {
      if (((((((RAM_OBD2_frame[0] & 0x80) == 0) && ((RAM_OBD2_frame[0xc] & 0x80) == 0)) &&
            ((RAM_OBD2_frame[0x12] & 0x80) == 0)) &&
           (((RAM_OBD2_frame[0x18] & 0x80) == 0 && ((RAM_OBD2_frame[0x1e] & 0x80) == 0)))) &&
          ((((DAT_0000400e & 0x80) == 0 &&
            (((DAT_00004014 & 0x80) == 0 && ((DAT_0000401a & 0x80) == 0)))) && (RAM_Mis200_4 == 0)))
          ) && (DAT_000010e4 == 0)) {
        if ((DAT_0000103c & 0x40) == 0) {
          Function_0006B426();
          if (((((DAT_00003a19 & 4) == 0) || ((DAT_0000103b & 0x20) == 0)) ||
              ((RAM_Ramp_steg_[0] & 0x20) == 0)) ||
             (((DAT_00003a19 & 1) != 0 || (RAM_Start_detekt_nr_ != RAM_Rpm_byte)))) {
            DAT_00003a06 = 0;
          }
          else {
            if (DAT_00004e62 < DAT_00001037) {
              if (DAT_00001037 < (byte)DAT_00004e70) {
                DAT_00003528 = 0;
                while ((&DAT_00004e62)[(short)(ushort)DAT_00003528] < DAT_00001037) {
                  DAT_00003528 = DAT_00003528 + 1;
                }
                DAT_000046ee = (ushort)(&DAT_00004e62)[(short)(ushort)DAT_00003528] -
                               (ushort)(&DAT_00004e62)[(short)(DAT_00003528 - 1)];
                DAT_000046ec = (ushort)DAT_00001037 -
                               (ushort)(&DAT_00004e62)[(short)(DAT_00003528 - 1)];
                DAT_000046ea = (ushort)(&DAT_00004e62)[(short)(ushort)DAT_00003528] -
                               (ushort)DAT_00001037;
                DAT_000046e8 = 100;
                if (DAT_000046ec < DAT_000046ea) {
                  DAT_00003528 = DAT_00003528 - 1;
                  DAT_000046e8 = (ushort)(((uint)DAT_000046ec * 100) / (uint)DAT_000046ee);
                }
                else if (DAT_000046ea < DAT_000046ec) {
                  DAT_000046e8 = (ushort)(((uint)DAT_000046ea * 100) / (uint)DAT_000046ee);
                }
                if (DAT_000046e8 < 0x28) {
                  DAT_00003a18 = DAT_00003a18 | 0x40;
                }
                else {
                  DAT_00003a18 = DAT_00003a18 & 0xbf;
                }
              }
              else {
                DAT_00003528 = 0xf;
              }
            }
            else {
              DAT_00003528 = 0;
            }
            if ((DAT_00003a18 & 0x40) != 0) {
              if (DAT_00004e72 < DAT_00001066) {
                if (DAT_00001066 < DAT_00004e90) {
                  DAT_00003522 = 0;
                  while ((&DAT_00004e72)[(short)(ushort)DAT_00003522] < DAT_00001066) {
                    DAT_00003522 = DAT_00003522 + 1;
                  }
                  DAT_000046ee = (&DAT_00004e72)[(short)(ushort)DAT_00003522] -
                                 (&DAT_00004e72)[(short)(DAT_00003522 - 1)];
                  DAT_000046ec = DAT_00001066 - (&DAT_00004e72)[(short)(DAT_00003522 - 1)];
                  DAT_000046ea = (&DAT_00004e72)[(short)(ushort)DAT_00003522] - DAT_00001066;
                  DAT_000046e8 = 100;
                  if (DAT_000046ec < DAT_000046ea) {
                    DAT_00003522 = DAT_00003522 - 1;
                    DAT_000046e8 = (ushort)(((uint)DAT_000046ec * 100) / (uint)DAT_000046ee);
                  }
                  else if (DAT_000046ea < DAT_000046ec) {
                    DAT_000046e8 = (ushort)(((uint)DAT_000046ea * 100) / (uint)DAT_000046ee);
                  }
                  if (DAT_000046e8 < 0x28) {
                    DAT_00003a18 = DAT_00003a18 | 0x40;
                  }
                  else {
                    DAT_00003a18 = DAT_00003a18 & 0xbf;
                  }
                }
                else {
                  DAT_00003522 = 0xf;
                }
              }
              else {
                DAT_00003522 = 0;
              }
            }
            DAT_000046f0 = DAT_00003528 + DAT_00003522 * '\x10';
            DAT_00003a06 = 0;
            if ((DAT_00003548 == DAT_000046f0) && ((DAT_00003a18 & 0x40) != 0)) {
              if ((DAT_00003a18 & 4) == 0) {
                if ((DAT_00003a18 & 1) != 0) {
                  DAT_00003a18 = DAT_00003a18 | 4;
                  DAT_00003540 = DAT_00001031;
                  DAT_0000352c = DAT_00001031;
                }
              }
              else if (DAT_0000113d < 6) {
                if (DAT_00001031 < DAT_00003540) {
                  DAT_00003540 = DAT_00001031;
                }
                else if (DAT_0000352c < DAT_00001031) {
                  DAT_0000352c = DAT_00001031;
                }
                if ((DAT_00003a18 & 1) != 0) {
                  DAT_0000113d = DAT_0000113d + 1;
                  DAT_00003a18 = DAT_00003a18 & 0xfe;
                }
              }
              else {
                DAT_000046f2 = (byte)((short)((ushort)DAT_00003540 + (ushort)DAT_0000352c) >> 1);
                DAT_0000113d = 0;
                DAT_00003540 = DAT_00001031;
                DAT_0000352c = DAT_00001031;
                if (DAT_000046f2 < 0x80) {
                  if ((&DAT_00004876)[(short)(ushort)DAT_000046f0] != '\0') {
                    (&DAT_00004876)[(short)(ushort)DAT_000046f0] =
                         (&DAT_00004876)[(short)(ushort)DAT_000046f0] + -1;
                  }
                }
                else if ((0x80 < DAT_000046f2) &&
                        ((&DAT_00004876)[(short)(ushort)DAT_000046f0] != -1)) {
                  (&DAT_00004876)[(short)(ushort)DAT_000046f0] =
                       (&DAT_00004876)[(short)(ushort)DAT_000046f0] + '\x01';
                }
                if ((&DAT_00004fbe)[(short)(ushort)DAT_000046f0] != -1) {
                  (&DAT_00004fbe)[(short)(ushort)DAT_000046f0] =
                       (&DAT_00004fbe)[(short)(ushort)DAT_000046f0] + 1;
                }
              }
            }
            else {
              DAT_0000113d = 0;
              DAT_00003a18 = DAT_00003a18 & 0xfb;
              DAT_00003548 = DAT_000046f0;
            }
          }
        }
        else {
          DAT_00003a19 = DAT_00003a19 & 0xfe;
          DAT_00003a08 = 0;
          if ((DAT_0000103b & 0x20) != 0) {
            if (DAT_00004a7a < DAT_00003a06) {
              if (DAT_00001031 < 0x81) {
                if ((DAT_00001031 < 0x80) && (RAM_Adapt_injfaktor_ != 0)) {
                  RAM_Adapt_injfaktor_ = RAM_Adapt_injfaktor_ - 1;
                }
              }
              else if (RAM_Adapt_injfaktor_ != 0xff) {
                RAM_Adapt_injfaktor_ = RAM_Adapt_injfaktor_ + 1;
              }
              DAT_00003a06 = 0;
            }
            else {
              DAT_00003a06 = DAT_00003a06 + 1;
            }
          }
        }
      }
      else {
        DAT_00003a06 = 0;
        DAT_00003a19 = DAT_00003a19 & 0xfe;
        DAT_00003a08 = 0;
      }
    }
    else {
      DAT_00003a06 = 0;
      DAT_00003a19 = DAT_00003a19 & 0xfe;
      DAT_00003a08 = 0;
    }
  }
  else {
    DAT_00003a06 = 0;
    DAT_00003a19 = DAT_00003a19 & 0xfe;
    DAT_00003a08 = 0;
  }
  return;
}

```
