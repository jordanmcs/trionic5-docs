# Function_00069FEC

**ROM:** `0x00069FEC`

```c

void Function_00069FEC(void)

{
  if ((DAT_0000103a & 4) == 0) {
    DAT_000046d4 = Function_00072972(RAM_Temp_reduce_mat_2_,&DAT_000061be,RAM_Start_tab_,8,
                                     DAT_00001066);
  }
  else {
    DAT_000046d4 = Function_00072972(RAM_Temp_reduce_mat_2_,&DAT_000061be,RAM_Temp_reduce_mat_,8,
                                     DAT_00001066);
  }
  return;
}

```
