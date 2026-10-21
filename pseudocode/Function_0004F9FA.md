# Function_0004F9FA

**ROM:** `0x0004F9FA`

```c

void Function_0004F9FA(void)

{
  short sVar1;
  undefined1 *puVar2;
  bool bVar3;
  
  Function_00046146();
  puVar2 = &DAT_00001000;
  sVar1 = 0x16a;
  do {
    *puVar2 = 0;
    bVar3 = sVar1 != 0;
    puVar2 = puVar2 + 1;
    sVar1 = sVar1 + -1;
  } while (bVar3);
  RAM_Insptid_ms10 = RAM_Lupp_detekt_;
  DAT_00001138 = 0;
  DAT_00001150 = 0;
  DAT_0000101c = 0;
  DAT_00001166 = 0;
  DAT_00001137 = 0x10;
  DAT_00001047 = 1;
  DAT_00001980 = 0x40;
  RAM_Cyl_nr = 0;
  DAT_00003e62 = 0x4b57;
  return;
}

```
