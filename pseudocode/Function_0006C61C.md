# Function_0006C61C

**ROM:** `0x0006C61C`

```c

void Function_0006C61C(void)

{
  if ((RAM_Ramp_steg_[3] & 8) == 0) {
    DAT_0000405e = DAT_00003b5c;
    DAT_00001015 = DAT_00003b5c;
  }
  else if (DAT_00003a36 < 10) {
    DAT_00003a36 = DAT_00003a36 + 1;
    if (DAT_000036a2 < 0xb) {
      DAT_00003a34 = DAT_000046dc + DAT_00003a34;
    }
  }
  else {
    DAT_00001015 = (undefined1)(DAT_00003a34 / DAT_00003a36);
    DAT_00003a36 = 0;
    DAT_00003a34 = 0;
    DAT_0000405e = DAT_00001015;
  }
  DAT_000047b4 = DAT_00001013 + DAT_000047b4;
  DAT_000047b6 = DAT_000047b6 + 1;
  if (4 < DAT_000047b6) {
    DAT_000047d0 = RAM_Gear;
    RAM_Gear = (byte)(DAT_000047b4 / DAT_000047b6);
    DAT_000047b6 = 0;
    DAT_000047b4 = 0;
  }
  return;
}

```
