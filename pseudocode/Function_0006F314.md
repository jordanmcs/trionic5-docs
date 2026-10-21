# Function_0006F314

**ROM:** `0x0006F314`

```c

void Function_0006F314(void)

{
  if (DAT_00003a3a != '\x02') {
    if (DAT_00003a3a == '\x01') goto LAB_0006f3fe;
    DAT_00001023 = Function_0006A4E4(RAM_Retard_detekt_,&DAT_00004aec);
    DAT_00001025 = (byte)((uint)((int)(short)(ushort)DAT_00001023 * (int)(short)(ushort)RAM_Nom_last
                                ) / 100);
  }
  do {
    if (((RAM_Ramp_steg_[0] & 1) == 0) || ((DAT_00001039 & 2) != 0)) {
      DAT_00003a3a = 2;
      return;
    }
    while (DAT_00001025 != 0) {
      DAT_00001021 = Function_0006A4E4(RAM_Retard_detekt_,RAM_Eft_dec_fak_);
LAB_0006f3fe:
      if (DAT_00001021 != '\0') {
        DAT_00001021 = DAT_00001021 + -1;
        *(uint *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) =
             *(int *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) * (DAT_00001025 + 0x80) >> 7;
        DAT_00003a3a = 1;
        return;
      }
      if (DAT_00001025 < DAT_00004b1c) {
        DAT_00001025 = 0;
      }
      else {
        DAT_00001025 = DAT_00001025 - DAT_00004b1c;
      }
    }
    DAT_00001039 = DAT_00001039 | 2;
  } while( true );
}

```
