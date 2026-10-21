# Function_0006959A

**ROM:** `0x0006959A`

```c

/* WARNING: Removing unreachable block (ram,0x000695b6) */

void Function_0006959A(void)

{
  if ((DAT_0000103d & 0x20) != 0) {
    DAT_000035ea = (undefined1)((short)(ushort)DAT_000046ce >> 2);
    DAT_000032d2 = RAM_Idle_st_rpm_[(short)(ushort)DAT_000046ce >> 2];
    DAT_000046ce = DAT_000046ce + 1;
    if (0x27 < DAT_000046ce) {
      DAT_000032d2 = 0;
      DAT_0000103d = DAT_0000103d & 0xdf;
    }
  }
  return;
}

```
