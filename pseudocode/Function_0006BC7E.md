# Function_0006BC7E

**ROM:** `0x0006BC7E`

```c

void Function_0006BC7E(void)

{
  ushort uVar1;
  uint uVar2;
  ushort *puVar3;
  
  if ((DAT_00001039 & 8) == 0) {
    DAT_00003a00 = DAT_00003b02 + 120000;
  }
  else {
    uVar2 = (DAT_0000199e * DAT_00006b9c +
            DAT_0000199a * DAT_00006b9a + (uint)DAT_00006b98 * (uint)RAM_U_lambda_eng * 100) / 100;
    DAT_0000199a = DAT_0000199e;
    DAT_00001992 = (ushort)(uVar2 / 100);
    DAT_0000199e = uVar2;
  }
  if (((((char)DAT_00001990 < '\0') && (DAT_00006bd5 != '\0')) && ((RAM_Samp_pek[0] & 0x80) == 0))
     && ((((RAM_Samp_pek[0] & 0x20) == 0 && ((RAM_Samp_pek[0] & 8) == 0)) &&
         (((RAM_Samp_pek[6] & 2) == 0 &&
          (((RAM_Samp_pek[6] & 0x10) == 0 && ((RAM_Samp_pek[0] & 0x40) == 0)))))))) {
    if (((DAT_0000103a & 0x10) == 0) && (DAT_000046fe <= DAT_00001a58)) {
      if (((((DAT_00001039 & 8) == 0) || ((DAT_0000103c & 2) == 0)) || (DAT_0000102e < '=')) ||
         (DAT_00003b02 <= DAT_00003a00)) {
        DAT_000019a2 = DAT_00003b02 + DAT_00006bd2;
      }
      else {
        uVar1 = 0;
        puVar3 = &DAT_00006b9e;
        while ((uVar1 < 7 && (*puVar3 < DAT_00001992))) {
          uVar1 = uVar1 + 1;
          puVar3 = puVar3 + 1;
        }
        DAT_00001994 = *(undefined2 *)(&DAT_00006bae + (uint)uVar1 * 2);
        DAT_00001996 = *(undefined2 *)(&DAT_00006bbe + (uint)uVar1 * 2);
        if ((((RAM_n_Engine_delta_180[0] >> 2 & 1) == 1) && (DAT_000019a2 < DAT_00003b02)) &&
           ((RAM_Mis200_4 == 0 &&
            ((((DAT_000046fe + 0x19 < DAT_00001a58 && ((RAM_Samp_pek[0xb] & 0x10) != 0)) &&
              (0x32 < RAM_Purge_adapt_cthr)) && (0x32 < RAM_Purge_duty)))))) {
          if (DAT_00001992 < DAT_00006bce) {
            DAT_000019a2 = DAT_00003b02 + DAT_00006bd2;
            if (DAT_00001998 == 0) {
              if (DAT_00001999 < DAT_00006bd4) {
                DAT_00001999 = DAT_00001999 + 1;
              }
              else if (DAT_00001999 == DAT_00006bd4) {
                RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] | 1;
              }
            }
            else {
              DAT_00001998 = DAT_00001998 - 1;
            }
          }
          else if (DAT_00006bd0 < DAT_00001992) {
            DAT_000019a2 = DAT_00003b02 + DAT_00006bd2;
            if (DAT_00001999 == 0) {
              if (DAT_00001998 < DAT_00006bd4) {
                DAT_00001998 = DAT_00001998 + 1;
              }
              else if (DAT_00001998 == DAT_00006bd4) {
                RAM_Samp_pek[0xe] = RAM_Samp_pek[0xe] | 1;
              }
            }
            else {
              DAT_00001999 = DAT_00001999 - 1;
            }
          }
        }
      }
    }
    else {
      DAT_000046fe = DAT_00001a58;
    }
  }
  else {
    DAT_000019a2 = DAT_00003b02 + DAT_00006bd2;
    DAT_00001990 = DAT_00001990 | 0x80;
    DAT_00001992 = 400;
    DAT_0000199a = 40000;
    DAT_0000199e = 40000;
    DAT_00001994 = 0;
    DAT_00001996 = 0;
    if ((RAM_Samp_pek[10] & 0x10) == 0) {
      DAT_00001998 = 0;
      DAT_00001999 = 0;
    }
  }
  return;
}

```
