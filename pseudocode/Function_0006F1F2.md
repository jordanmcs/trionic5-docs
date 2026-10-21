# Function_0006F1F2

**ROM:** `0x0006F1F2`

```c

void Function_0006F1F2(void)

{
  if (DAT_00003a3c != '\x02') {
    if (DAT_00003a3c == '\x01') goto LAB_0006f2dc;
    RAM_Eft_fak2 = Function_0006A4E4(RAM_Retard_detekt_,&DAT_00004adc);
    RAM_Eft_dec2 = (byte)((uint)((int)(short)(ushort)RAM_Eft_fak2 * (int)(short)(ushort)RAM_Nom_last
                                ) / 100);
  }
  do {
    if (((RAM_Ramp_steg_[0] & 1) == 0) || ((DAT_0000103c & 4) != 0)) {
      DAT_00003a3c = 2;
      return;
    }
    for (; RAM_Eft_dec2 != 0; RAM_Eft_dec2 = RAM_Eft_dec2 - 1) {
      RAM_Duty_C = Function_0006A4E4(RAM_Retard_detekt_,RAM_Eftersta_fak2_);
LAB_0006f2dc:
      if (RAM_Duty_C != 0) {
        RAM_Duty_C = RAM_Duty_C - 1;
        *(uint *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) =
             *(int *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) * (RAM_Eft_dec2 + 0x80) >> 7;
        DAT_00003a3c = 1;
        return;
      }
    }
    DAT_0000103c = DAT_0000103c | 4;
  } while( true );
}

```
