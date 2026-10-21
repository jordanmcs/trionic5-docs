# Function_0006A2D2

**ROM:** `0x0006A2D2`

```c

void Function_0006A2D2(void)

{
  if ((DAT_00001039 & 8) != 0) {
    if (RAM_After_fcut != 0) {
      if (DAT_000046d0 < DAT_000046d2) {
        DAT_000046d0 = DAT_000046d0 + 1;
      }
      else {
        DAT_000046d0 = 0;
        RAM_After_fcut = RAM_After_fcut - 1;
      }
    }
    RAM_Purge_status = RAM_Purge_status & 0xbf;
  }
  return;
}

```
