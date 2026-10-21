# Function_0004CF86

**ROM:** `0x0004CF86`

```c

void Function_0004CF86(void)

{
  byte bVar1;
  byte bVar2;
  char cVar3;
  bool bVar4;
  bool bVar5;
  bool bVar6;
  
  bVar4 = (RAM_Samp_pek[8] & 0x40) != 0;
  bVar5 = (DAT_00001137 & 0x20) != 0;
  bVar6 = (DAT_0000103c & 0x20) != 0;
  if (((char)RAM_OBD2_frame[6] < '\0') || ((char)RAM_OBD2_frame[0] < '\0')) {
    cVar3 = '\0';
  }
  else {
    cVar3 = '\x01';
  }
  bVar1 = DAT_00003ee7 & 0x85;
  if ((DAT_00001137 & 0x20) == 0) {
    bVar1 = DAT_00003ee7 & 0x81;
  }
  DAT_00003ee7 = cVar3 << 3 |
                 bVar6 << 4 | (DAT_0000101c == '\0') << 5 | bVar5 << 6 | bVar4 * '\x02' | bVar1;
  if ((((((bVar4) && (bVar5)) && (DAT_0000101c == '\0')) && ((bVar6 && (cVar3 != '\0')))) &&
      (((bVar1 & 4) == 0 &&
       (((short)(ushort)DAT_00001013 < (short)(DAT_00001136 - 0x32) && (DAT_00001013 < 0x33)))))) &&
     (((DAT_00006e20 & 0x20) == 0 && ((DAT_00001137 & 0x40) != 0)))) {
    if (RAM_Purge_duty < DAT_000074f6) {
      DAT_00003ee6 = DAT_00003ee6 & 0xdf | 0x80;
    }
    else {
      DAT_00003ee6 = DAT_00003ee6 | 0x40;
    }
  }
  else {
    bVar1 = DAT_00003ee6 & 0xbf;
    if (((bVar1 >> 5 & 1) == 0) || (bVar2 = DAT_00003ee6 & 1, DAT_00003ee6 = bVar1, bVar2 != 0)) {
      DAT_00003ee6 = bVar1 | 0x80;
    }
  }
  return;
}

```
