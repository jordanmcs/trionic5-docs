# Function_00071E38

**ROM:** `0x00071E38`

```c

void Function_00071E38(void)

{
  DAT_000035a0 = (ushort)(((uint)DAT_00004e60 * (uint)RAM_Mainrly_off_ & 0xffff) / 100);
  if (((((RAM_Ramp_steg_[2] & 0x20) == 0) || (DAT_00003a78 < DAT_000035a0)) &&
      ((DAT_00001a58 < 600 || (0x294 < DAT_00001a58)))) &&
     ((((DAT_00001a58 < 0x3de || (0x438 < DAT_00001a58)) &&
       ((DAT_00001a58 < 0x514 || (0x546 < DAT_00001a58)))) &&
      (((((DAT_00004044 & 0x80) == 0 && ((DAT_00004044 & 0x40) == 0)) &&
        ((DAT_00004044 & 0x20) == 0)) && ((RAM_Samp_pek[0xd] & 0x40) == 0)))))) {
    DAT_0000103b = DAT_0000103b | 0x20;
  }
  else {
    DAT_0000103b = DAT_0000103b & 0xdf;
  }
  if (DAT_00003a78 < RAM_Mainrly_off_) {
    DAT_00003a78 = DAT_00003a78 + 1;
  }
  else {
    DAT_00003a78 = 0;
  }
  return;
}

```
