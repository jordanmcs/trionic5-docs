# Function_0004962C

**ROM:** `0x0004962C`

```c

undefined8 Function_0004962C(void)

{
  undefined4 in_D0;
  char cVar2;
  ushort uVar1;
  undefined4 in_D1;
  code *extraout_A1;
  code *extraout_A1_00;
  code *extraout_A1_01;
  code *extraout_A1_02;
  code *extraout_A1_03;
  code *extraout_A1_04;
  code *extraout_A1_05;
  code *extraout_A1_06;
  code *extraout_A1_07;
  code *extraout_A1_08;
  code *pcVar3;
  
  cVar2 = Function_000493C2();
  if (cVar2 == '\x11') {
    cVar2 = Function_00049770();
    uVar1 = Function_000493C2();
    (*extraout_A1)(uVar1 & 0xbf);
    pcVar3 = extraout_A1_00;
  }
  else if (cVar2 == '\x1c') {
    cVar2 = Function_00049C5E();
    uVar1 = Function_000493C2();
    (*extraout_A1_01)(uVar1 & 0xbf);
    pcVar3 = extraout_A1_02;
  }
  else if (cVar2 == ',') {
    cVar2 = Function_00049D24();
    uVar1 = Function_000493C2();
    (*extraout_A1_03)(uVar1 & 0xbf);
    pcVar3 = extraout_A1_04;
  }
  else {
    cVar2 = '\x05';
    Function_0004948E();
    pcVar3 = extraout_A1_05;
  }
  if (cVar2 == '\0') {
    cVar2 = Function_000497FC();
    pcVar3 = extraout_A1_06;
    if (((cVar2 != '\x05') && (cVar2 != '\x03')) && (cVar2 != '\x02')) {
      if (cVar2 == '\x01') {
        (*DAT_00003d7c)();
        pcVar3 = extraout_A1_07;
      }
      else {
        DAT_00003d8c = DAT_00003d94._0_1_;
        DAT_00003d8d = cVar2;
        Function_000495AC();
        pcVar3 = extraout_A1_08;
      }
    }
    (*pcVar3)(0xff);
    if ((DAT_00003d94._0_1_ == -0x5b) && (DAT_0000371e == '\0')) {
      DAT_0000371e = '\x01';
      Function_00049CEA();
    }
  }
  else {
    (*pcVar3)(0xff);
  }
  return CONCAT44(in_D0,in_D1);
}

```
