# Function_000691E6

**ROM:** `0x000691E6`

```c

void Function_000691E6(void)

{
  byte bVar1;
  bool bVar2;
  
  if (DAT_000039f2 == '\x03') goto LAB_00069424;
  if (DAT_000039f2 == '\x02') goto LAB_00069360;
  if (DAT_000039f2 == '\x01') goto LAB_000692b4;
  DAT_000046c6 = 0;
  Function_000469FC(0x4f);
  while( true ) {
    if ((DAT_00001039 & 1) == 0) {
      DAT_000039f2 = 0;
      return;
    }
LAB_000692b4:
    if ((DAT_00003c32 < 0x1e0) && ((DAT_00001039 & 1) != 0)) break;
LAB_00069360:
    bVar1 = DAT_000046c6 + 1;
    bVar2 = DAT_000046c6 < 0x3c;
    DAT_000046c6 = bVar1;
    if ((bVar2) && ((DAT_00001039 & 1) != 0)) {
      if ((RAM_Samp_pek[0] & 0x80) == 0) {
        if (DAT_0000102e < -10) {
          RAM_Trot_min = 0x14;
        }
        else if (DAT_0000102e < '\0') {
          RAM_Trot_min = 0x1e;
        }
        else if (DAT_0000102e < '\x0f') {
          RAM_Trot_min = 0x28;
        }
        else if (DAT_0000102e < '(') {
          RAM_Trot_min = 0x32;
        }
        else if (DAT_0000102e < 'P') {
          RAM_Trot_min = 0x3c;
        }
        else {
          RAM_Trot_min = 0x46;
        }
      }
      else {
        RAM_Trot_min = 0x50;
      }
      Function_000469FC(RAM_Trot_min);
      DAT_000039f2 = 2;
      return;
    }
LAB_00069424:
    if ((DAT_00001039 & 1) != 0) {
      if ((RAM_Samp_pek[0] & 0x10) == 0) {
        if ((DAT_0000103a & 4) == 0) {
          if (RAM_P_Manifold10 < 0xd7) {
            RAM_Trot_min = (short)((uint)((short)((ushort)RAM_P_Manifold10 - (ushort)RAM_Trot_delta)
                                         * 0x33e) / (0xd7 - RAM_Trot_delta)) + 0x5a;
          }
          else {
            RAM_Trot_min = 0x398;
          }
        }
        else {
          RAM_Trot_min = 0x5a;
        }
      }
      else {
        RAM_Trot_min = 0x3c0;
      }
      Function_000469FC(RAM_Trot_min);
      DAT_000039f2 = 3;
      return;
    }
  }
  if ((RAM_Samp_pek[0] & 0x80) == 0) {
    if (DAT_0000102e < -10) {
      RAM_Trot_min = 0x14;
    }
    else if (DAT_0000102e < '\0') {
      RAM_Trot_min = 0x1e;
    }
    else if (DAT_0000102e < '\x0f') {
      RAM_Trot_min = 0x28;
    }
    else if (DAT_0000102e < '(') {
      RAM_Trot_min = 0x32;
    }
    else if (DAT_0000102e < 'P') {
      RAM_Trot_min = 0x3c;
    }
    else {
      RAM_Trot_min = 0x46;
    }
  }
  else {
    RAM_Trot_min = 0x50;
  }
  Function_000469FC(RAM_Trot_min);
  DAT_000039f2 = 1;
  return;
}

```
