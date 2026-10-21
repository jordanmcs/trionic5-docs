# Function_0006956A

**ROM:** `0x0006956A`

```c

void Function_0006956A(void)

{
  if ((DAT_0000103b & 8) == 0) {
    if (RAM_Ret_delta_rpm_ < DAT_00001151) {
      DAT_00001151 = DAT_00001151 - RAM_Ret_delta_rpm_;
    }
    else {
      DAT_00001151 = 0;
    }
  }
  return;
}

```
