# Function_00069F70

**ROM:** `0x00069F70`

```c

void Function_00069F70(void)

{
  DAT_0000404e = RAM_Bil_hast;
  DAT_0000404c = DAT_00003b64;
  DAT_00001016 = DAT_00003b64;
  if ((RAM_Samp_pek[0] & 0x80) == 0) {
    DAT_00004054 = DAT_00003b62;
    RAM_AD_knock = DAT_00003b62;
  }
  else {
    RAM_AD_knock = 0x6e;
  }
  if ((RAM_Samp_pek[0] & 0x40) == 0) {
    DAT_00004052 = DAT_00003b4e;
    RAM_P_Manifold = DAT_00003b4e;
  }
  else {
    RAM_P_Manifold = 0x96;
  }
  return;
}

```
