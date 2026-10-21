# Function_00060BFE

**ROM:** `0x00060BFE`

```c

int Function_00060BFE(undefined4 param_1)

{
  ushort extraout_D0u;
  ushort extraout_D0u_00;
  ushort uVar1;
  int iVar2;
  
  DAT_00003592 = RAM_Da_7 - 1;
  *(undefined2 *)(&DAT_0000389a + (short)((ushort)DAT_00003592 * 10)) =
       *(undefined2 *)(&DAT_0000389c + (short)((ushort)DAT_00003592 * 10));
  *(undefined2 *)(&DAT_0000389c + (short)((ushort)DAT_00003592 * 10)) =
       *(undefined2 *)(&DAT_0000389e + (short)((ushort)DAT_00003592 * 10));
  *(undefined2 *)(&DAT_0000389e + (short)((ushort)DAT_00003592 * 10)) =
       *(undefined2 *)(&DAT_000038a0 + (short)((ushort)DAT_00003592 * 10));
  *(undefined2 *)(&DAT_000038a0 + (short)((ushort)DAT_00003592 * 10)) =
       *(undefined2 *)(&DAT_000038a2 + (short)((ushort)DAT_00003592 * 10));
  *(ushort *)(&DAT_000038a2 + (short)((ushort)DAT_00003592 * 10)) = param_1._0_2_;
  DAT_00004630 = (ushort)(((uint)*(ushort *)(&DAT_0000389a + (short)((ushort)DAT_00003592 * 10)) +
                           (uint)*(ushort *)(&DAT_0000389c + (short)((ushort)DAT_00003592 * 10)) +
                           (uint)*(ushort *)(&DAT_0000389e + (short)((ushort)DAT_00003592 * 10)) +
                           (uint)*(ushort *)(&DAT_000038a0 + (short)((ushort)DAT_00003592 * 10)) +
                          (uint)*(ushort *)(&DAT_000038a2 + (short)((ushort)DAT_00003592 * 10))) / 5
                         );
  if (DAT_00003898 == '\x02') {
    DAT_0000462e = param_1._0_2_;
  }
  else {
    DAT_0000462e = DAT_00004630;
    if ((param_1._0_2_ < DAT_00004630) && (DAT_0000462e = param_1._0_2_, DAT_00003898 == '\0')) {
      *(ushort *)(&DAT_0000389a + (short)((ushort)DAT_00003592 * 10)) = param_1._0_2_;
      *(ushort *)(&DAT_0000389c + (short)((ushort)DAT_00003592 * 10)) = param_1._0_2_;
      *(ushort *)(&DAT_0000389e + (short)((ushort)DAT_00003592 * 10)) = param_1._0_2_;
      *(ushort *)(&DAT_000038a0 + (short)((ushort)DAT_00003592 * 10)) = param_1._0_2_;
      *(ushort *)(&DAT_000038a2 + (short)((ushort)DAT_00003592 * 10)) = param_1._0_2_;
    }
  }
  Function_000610D2();
  DAT_0000462a = (ushort)(DAT_00004622 / DAT_000010f4);
  if (DAT_00001066 < 0x96) {
    DAT_00004626 = DAT_00005aac;
  }
  else if (DAT_00001066 < 0x259) {
    DAT_0000358e = (char)((int)(DAT_00001066 - 0x96) / 0x32) + 1;
    DAT_00004626 = (&DAT_00005aac)[DAT_0000358e];
  }
  else {
    DAT_00004626 = DAT_00005ac0;
  }
  if (DAT_00004626 < DAT_0000462a) {
    DAT_0000462a = DAT_00004626;
  }
  DAT_00004628 = (ushort)(((uint)DAT_000010f6 * (uint)DAT_0000462a) / 100);
  DAT_000010fe = param_1._2_2_;
  if ((RAM_Ramp_steg_[4] & 0x20) == 0) {
    if ((((DAT_0000462a < DAT_0000462e) || ((RAM_Samp_pek[5] & 8) != 0)) &&
        (DAT_000010f8 < DAT_00001013)) &&
       ((('(' < DAT_0000102e || ((RAM_Samp_pek[0] & 0x80) != 0)) && (DAT_00001118 == '\0')))) {
      DAT_00003888 = DAT_00003b02;
      Function_0004478C();
      if (DAT_00004628 < DAT_0000462e) {
        DAT_00003350 = 2;
        Function_00060F5A();
        iVar2 = 1;
      }
      else {
        DAT_00003350 = 1;
        Function_00060F5A();
        iVar2 = 1;
      }
    }
    else {
      if (DAT_00003b02 < DAT_00003888) {
        DAT_00003888 = DAT_00003b02;
      }
      uVar1 = extraout_D0u;
      if (100 < DAT_00003b02 - DAT_00003888) {
        Function_0004478C();
        uVar1 = extraout_D0u_00;
      }
      iVar2 = (uint)uVar1 << 0x10;
    }
  }
  else {
    iVar2 = (uint)extraout_D0u << 0x10;
  }
  return iVar2;
}

```
