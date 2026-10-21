# Function_00060F5A

**ROM:** `0x00060F5A`

```c

void Function_00060F5A(void)

{
  short sVar1;
  
  DAT_00004108 = 0x11;
  while ((0 < DAT_00004108 &&
         ((short)(ushort)DAT_00001013 < *(short *)(&DAT_000051ca + DAT_00004108 * 2)))) {
    DAT_00004108 = DAT_00004108 + -1;
  }
  if (((DAT_00004108 < 0x11) &&
      (sVar1 = (short)(*(short *)(&DAT_000051ca + (short)(DAT_00004108 + 1) * 2) -
                      *(short *)(&DAT_000051ca + DAT_00004108 * 2)) >> 1, sVar1 != 0)) &&
     ((short)(sVar1 + *(short *)(&DAT_000051ca + DAT_00004108 * 2)) < (short)(ushort)DAT_00001013))
  {
    DAT_00004108 = DAT_00004108 + 1;
  }
  for (DAT_00004106 = 0xf;
      (0 < DAT_00004106 && ((short)(DAT_00001066 * 10) < (short)(&DAT_000051ee)[DAT_00004106]));
      DAT_00004106 = DAT_00004106 + -1) {
  }
  if (((DAT_00004106 < 0xf) &&
      (sVar1 = (short)((&DAT_000051ee)[(short)(DAT_00004106 + 1)] - (&DAT_000051ee)[DAT_00004106])
               >> 1, sVar1 != 0)) &&
     ((short)(sVar1 + (&DAT_000051ee)[DAT_00004106]) < (short)(DAT_00001066 * 10))) {
    DAT_00004106 = DAT_00004106 + 1;
  }
  if (*(short *)(RAM_Airpump_status + (int)(short)(DAT_00004106 * 0x24) + DAT_00004108 * 2) != -1) {
    *(short *)(RAM_Airpump_status + (int)(short)(DAT_00004106 * 0x24) + DAT_00004108 * 2) =
         *(short *)(RAM_Airpump_status + (int)(short)(DAT_00004106 * 0x24) + DAT_00004108 * 2) + 1;
  }
  if (DAT_00004690 == 0x168) {
    if (RAM_Knock_count_cyl3 < 0xfffe) {
      RAM_Knock_count_cyl3 = RAM_Knock_count_cyl3 + 1;
    }
  }
  else if (DAT_00004690 == 0xb4) {
    if (RAM_Knock_count_cyl2 < 0xfffe) {
      RAM_Knock_count_cyl2 = RAM_Knock_count_cyl2 + 1;
    }
  }
  else if (DAT_00004690 == 0x21c) {
    if (RAM_Knock_count_cyl1 < 0xfffe) {
      RAM_Knock_count_cyl1 = RAM_Knock_count_cyl1 + 1;
    }
  }
  else if (DAT_00001d0a < 0xfffe) {
    DAT_00001d0a = DAT_00001d0a + 1;
  }
  return;
}

```
