# Function_00043B74

**ROM:** `0x00043B74`

```c

void Function_00043B74(void)

{
  DAT_00003b28 = 0xfa;
  DAT_00003b2e = 0x157;
  DAT_00003b2c = (short)((uint)(DAT_00003b6c * 0x96) / 0xb4) - DAT_00003bce;
  DAT_00003b32 = (short)((DAT_00003b6c * (uint)RAM_Knock_diag_level) / 0x708);
  DAT_00003b30 = (short)((DAT_00003b6c * (uint)DAT_00001104) / 0x708);
  return;
}

```
