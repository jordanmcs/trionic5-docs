# Function_0005F574

**ROM:** `0x0005F574`

```c

void Function_0005F574(void)

{
  byte bVar1;
  short sVar2;
  char cVar3;
  undefined1 *extraout_A1;
  undefined1 *extraout_A1_00;
  undefined2 uVar4;
  
  DAT_00004640 = DAT_0000464c & 0xf | 0x40;
  DAT_00004641 = DAT_0000464d;
  if (DAT_0000464d < 0x10) {
    if (DAT_0000464d == 0) {
      DAT_00004642 = 0xbe;
      DAT_00004643 = '>';
      DAT_00004644 = 0xb8;
      DAT_00004645 = 0x11;
      DAT_0000463f = 6;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 1) {
      uVar4 = 2;
      DAT_00004642 = Function_000662CA(0);
      sVar2 = Function_00044CC2(uVar4);
      if ((sVar2 == 1) && (-1 < DAT_00003ea0)) {
        DAT_00004642 = DAT_00004642 | 0x80;
      }
      DAT_00004643 = '\a';
      DAT_00004644 = 0x65;
      DAT_00004645 = 0xff;
      if (((DAT_00003fe6 & 0x80) != 0) && (DAT_00003329 != '(')) {
        DAT_00004645 = 0xfe;
      }
      bVar1 = DAT_00004645 & 0xfd;
      if ((((DAT_00003fe6 & 0x40) != 0) && (RAM_Idle_error != 0x28)) && (RAM_R_sond_error != 0x28))
      {
        bVar1 = DAT_00004645 & 0xf9;
      }
      DAT_00004645 = bVar1;
      bVar1 = DAT_00004645 & 0xe7;
      if ((((DAT_00003fe6 & 0x20) != 0) && (DAT_00003323 != '(')) && (RAM_Sync_error != 0x28)) {
        bVar1 = DAT_00004645 & 199;
      }
      DAT_00004645 = bVar1;
      if ((((DAT_00003fe6 & 0x10) != 0) && (DAT_00003323 != '(')) && (RAM_Sync_error != 0x28)) {
        DAT_00004645 = DAT_00004645 & 0xbf;
      }
      DAT_00004645 = DAT_00004645 & 0x7f;
      DAT_0000463f = 6;
      *extraout_A1 = 0x4f;
    }
    else if (DAT_0000464d == 3) {
      DAT_00004642 = DAT_00001076;
      DAT_00004643 = '\0';
      DAT_0000463f = 4;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 4) {
      if ((RAM_Ramp_steg_[4] & 0x10) == 0) {
        for (DAT_000040f0 = 0;
            ((ushort)((&DAT_00005b70)[(short)(ushort)DAT_000040f0] +
                     (&DAT_00005b6e)[(short)(ushort)DAT_000040f0]) >> 1 < DAT_00001066 &&
            (DAT_000040f0 != 0xf)); DAT_000040f0 = DAT_000040f0 + 1) {
        }
        if ((RAM_Ramp_steg_[3] & 2) == 0) {
          DAT_000040f2 = (&DAT_00005bc6)[(short)((ushort)DAT_000040f0 * 8 + 7)];
        }
        else {
          DAT_000040f2 = RAM_Tryck_mat_[(short)((ushort)DAT_000040f0 * 8 + 7)];
        }
      }
      else {
        DAT_000040f2 = 100;
      }
      if (DAT_00001013 < DAT_000040f2) {
        DAT_00004642 = (byte)(((uint)DAT_00001013 << 8) / (uint)DAT_000040f2);
      }
      else {
        DAT_00004642 = 0xff;
      }
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 5) {
      if (DAT_0000102e < -0x28) {
        DAT_00004642 = 0;
      }
      else {
        DAT_00004642 = DAT_00004736 + 0x28;
      }
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 6) {
      DAT_00004642 = (char)((short)(ushort)DAT_00001031 >> 2) + 0x60;
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 7) {
      DAT_00004642 = RAM_Start_detekt_nr_;
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 0xb) {
      DAT_00004642 = (byte)(DAT_00003e24 / 10);
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 0xc) {
      DAT_00004642 = (byte)(DAT_00003b72 >> 6);
      DAT_00004643 = (char)(DAT_00003b72 << 2);
      DAT_0000463f = 4;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 0xd) {
      DAT_00004642 = DAT_0000101c;
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 0xe) {
      if (DAT_000010b4 < -0x280) {
        DAT_00004642 = 0;
      }
      else {
        DAT_00004642 = (byte)((int)(short)(DAT_000010b4 + 0x280) / 5);
      }
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 0xf) {
      if ((char)RAM_Last < -0x28) {
        DAT_00004642 = 0;
      }
      else {
        DAT_00004642 = DAT_000046e6 + 0x28;
      }
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else if (DAT_0000464d < 0x20) {
    if (DAT_0000464d == 0x11) {
      DAT_00004642 = DAT_00001015;
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 0x12) {
      cVar3 = Function_0004492E();
      if (cVar3 == '\0') {
        DAT_00004642 = 4;
      }
      else {
        DAT_00004642 = 1;
      }
      DAT_0000463f = 3;
      *extraout_A1_00 = 0x4f;
    }
    else if (DAT_0000464d == 0x13) {
      DAT_00004642 = 3;
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 0x14) {
      DAT_00004642 = (byte)(RAM_Cat_ox1_duty_cycle / 5);
      DAT_00004643 = (char)((short)(ushort)DAT_00001031 >> 2) + '`';
      DAT_0000463f = 4;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 0x15) {
      DAT_00004642 = (byte)(RAM_U_lambda_eng / 5);
      DAT_00004643 = -1;
      DAT_0000463f = 4;
      DAT_0000463e = 0x4f;
    }
    else if (DAT_0000464d == 0x1c) {
      DAT_00004642 = 1;
      DAT_0000463f = 3;
      DAT_0000463e = 0x4f;
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else if (DAT_0000464d < 0x30) {
    if (DAT_0000464d == 0x20) {
      DAT_00004642 = 0;
      DAT_00004643 = '\0';
      DAT_00004644 = 0;
      DAT_00004645 = 1;
      DAT_0000463f = 6;
      DAT_0000463e = 0x4f;
    }
    else {
      DAT_0000463e = 0x45;
    }
  }
  else if (DAT_0000464d == 0x40) {
    DAT_00004642 = 0;
    DAT_00004643 = '\0';
    DAT_00004644 = 0;
    DAT_00004645 = 0;
    DAT_0000463f = 6;
    DAT_0000463e = 0x4f;
  }
  else {
    DAT_0000463e = 0x45;
  }
  return;
}

```
