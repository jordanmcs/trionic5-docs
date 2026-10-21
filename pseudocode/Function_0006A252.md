# Function_0006A252

**ROM:** `0x0006A252`

```c

void Function_0006A252(void)

{
  if (DAT_0000102e < '2') {
    RAM_After_fcut = 0;
  }
  else if (DAT_0000102e < 't') {
    RAM_After_fcut = Function_0006A4E4(&DAT_000039f4,RAM_Dash_act_step_);
    DAT_000046d2 = Function_0006A4E4(&DAT_000039f4,0x4f3e);
  }
  else {
    RAM_After_fcut = RAM_Dash_act_step_[6];
    DAT_000046d2 = RAM_Hot_tab_[6];
  }
  return;
}

```
