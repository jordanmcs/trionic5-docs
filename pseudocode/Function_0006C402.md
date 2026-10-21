# Function_0006C402

**ROM:** `0x0006C402`

```c

void Function_0006C402(void)

{
  byte bVar1;
  char cVar2;
  ushort uVar3;
  code *extraout_A1;
  code *extraout_A1_00;
  code *pcVar4;
  code *extraout_A1_01;
  undefined2 *extraout_A1_02;
  undefined2 *extraout_A1_03;
  undefined2 *extraout_A1_04;
  undefined2 uVar5;
  undefined2 uVar6;
  
  Function_0004AB8E(0x59b8);
  if ((DAT_000038c4 & 0x40) == 0) {
    Function_00044664();
  }
  if ((DAT_000038c4 & 0x80) == 0) {
    Function_0004461C();
  }
  Function_0004F9FA();
  Function_0005E8A6();
  DAT_00004770 = DAT_00005fca;
  DAT_00001039 = DAT_00001039 & 0xf7 | 5;
  DAT_000039fc = DAT_000039fc & 0x7f;
  DAT_0000103a = DAT_0000103a | 0xf0;
  DAT_00003c4a = DAT_00003c4a & 0x3f;
  Function_00049E30();
  Function_00069C30();
  Function_0004A082();
  Function_00069F70();
  cVar2 = Function_0006A4E4(0x760e,0x761e);
  RAM_Kyl_temp = cVar2 - 0x28;
  if (DAT_00003c32 == 0) {
    DAT_00001136 = DAT_00001013;
  }
  else {
    DAT_00001136 = 0x50;
  }
  pcVar4 = extraout_A1;
  bVar1 = RAM_Kyl_temp;
  if ((RAM_Samp_pek[0] & 0x80) == 0) {
    cVar2 = (*extraout_A1)(0x75e4,0x75f8);
    DAT_00004736 = cVar2 - 0x28;
    pcVar4 = extraout_A1_00;
    bVar1 = DAT_00004736;
  }
  RAM_S_Kyl_temp = bVar1;
  uVar3 = (ushort)RAM_P_Manifold;
  uVar5 = 0;
  uVar6 = 0;
  DAT_0000102e = RAM_S_Kyl_temp;
  cVar2 = (*pcVar4)(0x760e,0x761e);
  RAM_Last = cVar2 - 0x28;
  cVar2 = (*extraout_A1_01)(&DAT_0000760e,0x761e,uVar6,uVar5,uVar3);
  DAT_000046e6 = cVar2 + -0x28;
  Function_00069808();
  Function_0006F1F2();
  Function_0006F314();
  Function_0006A884();
  DAT_000010b4 = 100;
  RAM_S_Lufttemp = 5000;
  Function_00071868();
  RAM_Cyl_nr = 0;
  if ((DAT_000038c2 & 0x20) == 0) {
    Function_00044270();
  }
  RAM_Purge_adapt_cthr = 0x80;
  RAM_Purge_duty = 0x80;
  if ((RAM_Purge_status & 0x40) != 0) {
    Function_0006A252();
  }
  uVar6 = 1;
  Function_0006D110();
  RAM_Start_dead = 0;
  uVar5 = 2;
  Function_0006D110(uVar6);
  *extraout_A1_02 = 0;
  uVar6 = 3;
  Function_0006D110(uVar5);
  *extraout_A1_03 = 0;
  Function_0006D110(uVar6);
  *extraout_A1_04 = 1;
  return;
}

```
