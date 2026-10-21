# Function_00072DC2

**ROM:** `0x00072DC2`

```c

void Function_00072DC2(void)

{
  if ((DAT_00001119 & 8) == 0) {
    RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ & 0xfd;
    DAT_00001119 = DAT_00001119 & 0xef | 4;
    DAT_000047e4 = 0;
  }
  else {
    if (((DAT_00001119 & 0x10) != 0) && ((RAM_Spik_count._0_1_ & 2) == 0)) {
      DAT_000047ea = (&DAT_0000641e)[(short)(ushort)DAT_000047e4];
      RAM_Medeltryck = DAT_000047ea + RAM_Medeltryck;
      if (100 < RAM_Medeltryck) {
        RAM_Medeltryck = 100;
      }
      DAT_000047b8 = 0;
      DAT_000047e2 = DAT_000047b2 - RAM_Medeltryck;
      RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ | 2;
      if (DAT_000047e4 < 7) {
        DAT_000047e4 = DAT_000047e4 + 1;
      }
      DAT_000047ec = 0;
    }
    if (((DAT_000047e2 < RAM_Gear) && (0x8b < RAM_Gear)) && (DAT_000047ec < DAT_00003a8a)) {
      if ((RAM_Spik_count._0_1_ & 2) != 0) {
        DAT_000047ec = DAT_000047ec + 1;
      }
    }
    else {
      RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ & 0xfd;
      DAT_00001119 = DAT_00001119 & 0xef | 4;
      DAT_000047ec = 0;
    }
  }
  if (RAM_Medeltryck == 0) {
    RAM_Spik_count._0_1_ = RAM_Spik_count._0_1_ & 0xfd;
    DAT_00001119 = DAT_00001119 & 0xef;
    DAT_000047e4 = 0;
  }
  else if ((RAM_Spik_count._0_1_ & 2) == 0) {
    if (RAM_PMCal_IdlePosFiltCoef_ <= DAT_000047b8) {
      if (RAM_Medeltryck == 0) {
        DAT_000047e4 = 0;
      }
      else {
        RAM_Medeltryck = RAM_Medeltryck - 1;
      }
      DAT_000047b8 = 0;
    }
    DAT_000047b8 = DAT_000047b8 + 1;
  }
  if ((((DAT_00001013 < DAT_000010fa) && (RAM_Knock_offset1234 != 0)) &&
      ((DAT_000010c0 != 0 && ((DAT_000010c2 != 0 && (DAT_000010c4 != 0)))))) &&
     (RAM_Medeltryck < DAT_00005ec8)) {
    RAM_Medeltryck = DAT_00005ec8;
  }
  return;
}

```
