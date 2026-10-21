# Function_00042F92

**ROM:** `0x00042F92`

```c

/* WARNING: Removing unreachable block (ram,0x000430b8) */
/* WARNING: Removing unreachable block (ram,0x000431b2) */
/* WARNING: Removing unreachable block (ram,0x00043270) */
/* WARNING: Removing unreachable block (ram,0x00043138) */
/* WARNING: Removing unreachable block (ram,0x0004303e) */
/* WARNING: Removing unreachable block (ram,0x000432e6) */

undefined8 Function_00042F92(void)

{
  undefined4 in_D0;
  undefined4 in_D1;
  int *extraout_A1;
  int *extraout_A1_00;
  int *piVar1;
  int *extraout_A1_01;
  int *extraout_A1_02;
  int *extraout_A1_03;
  int *extraout_A1_04;
  int *extraout_A1_05;
  int *extraout_A1_06;
  
  DAT_00003b02 = DAT_00003b02 + 2;
  if ((DAT_00001039 & 1) == 0) {
    DAT_00003634 = 0;
  }
  else {
    DAT_00003634 = DAT_00003634 + 2;
  }
  if ((uint)(DAT_00003b02 - DAT_00003aea) < 4000) {
    Function_000769EC();
  }
  Function_00049E30();
  Function_000442CC();
  Function_0006C61C();
  piVar1 = extraout_A1;
  if (9 < (uint)(*extraout_A1 - DAT_00003ae6)) {
    DAT_00003ae6 = *extraout_A1;
    Function_00044E50();
    piVar1 = extraout_A1_00;
  }
  if ((uint)(*piVar1 - DAT_00003afe) < 4) {
    if ((uint)(*piVar1 - DAT_00003afa) < 10) {
      if ((uint)(*piVar1 - DAT_00003af6) < 0x40) {
        if ((uint)(*piVar1 - DAT_00003af2) < 0x62) {
          if ((uint)(*piVar1 - DAT_00003aee) < 0x82) {
            if ((0xf9 < (uint)(*piVar1 - DAT_00003aea)) && (DAT_00003ae0 < 2)) {
              DAT_00003ae0 = DAT_00003ae0 | 2;
              Function_0006D2BC();
              Function_00043400();
              Function_000435EA();
              Function_0004362A();
              DAT_00003aea = *extraout_A1_06;
              DAT_00003ae0 = DAT_00003ae0 & 0xfffd;
            }
          }
          else if (DAT_00003ae0 < 4) {
            DAT_00003ae0 = DAT_00003ae0 | 4;
            Function_0006D2A0();
            DAT_00003aee = *extraout_A1_05;
            DAT_00003ae0 = DAT_00003ae0 & 0xfffb;
          }
        }
        else if (DAT_00003ae0 < 8) {
          DAT_00003ae0 = DAT_00003ae0 | 8;
          Function_0006D144();
          if (1000 < (uint)(*extraout_A1_04 - DAT_00003c34)) {
            DAT_00003b72 = 0;
            DAT_00003c32 = 0;
            DAT_00001066 = 0;
            DAT_00001048 = 0;
          }
          if (3000 < (uint)(*extraout_A1_04 - DAT_00003630)) {
            DAT_000038c4 = DAT_000038c4 & 0xfd;
          }
          DAT_00003af2 = *extraout_A1_04;
          DAT_00003ae0 = DAT_00003ae0 & 0xfff7;
        }
      }
      else if (DAT_00003ae0 < 0x10) {
        DAT_00003ae0 = DAT_00003ae0 | 0x10;
        Function_0006D0FC();
        Function_00045F04();
        DAT_00003af6 = *extraout_A1_03;
        DAT_00003ae0 = DAT_00003ae0 & 0xffef;
      }
    }
    else if (DAT_00003ae0 < 0x20) {
      DAT_00003ae0 = DAT_00003ae0 | 0x20;
      Function_0004A082();
      Function_0006CF66();
      Function_0004542E();
      DAT_00003afa = *extraout_A1_02;
      DAT_00003ae0 = DAT_00003ae0 & 0xffdf;
    }
  }
  else if (DAT_00003ae0 < 0x40) {
    DAT_00003ae0 = DAT_00003ae0 | 0x40;
    Function_00074F8C();
    Function_00043346();
    DAT_00003afe = *extraout_A1_01;
    DAT_00003ae0 = DAT_00003ae0 & 0xffbf;
  }
  return CONCAT44(in_D0,in_D1);
}

```
