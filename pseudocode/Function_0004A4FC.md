# Function_0004A4FC

**ROM:** `0x0004A4FC`

```c

undefined4 Function_0004A4FC(void)

{
  undefined4 uVar1;
  
  if ((DAT_00003728 == '\x01') && (DAT_0000372a == '\x01')) {
    uVar1 = 0x4f;
  }
  else if ((DAT_00003728 == '\0') && (DAT_0000372a == '\x01')) {
    uVar1 = 0x4c;
  }
  else if ((DAT_00003728 == '\x01') && (DAT_0000372a == '\0')) {
    uVar1 = 0x48;
  }
  else if ((DAT_00003728 == '\0') && (DAT_0000372a == '\0')) {
    uVar1 = 0x55;
  }
  else {
    uVar1 = 0x4e;
  }
  return uVar1;
}

```
