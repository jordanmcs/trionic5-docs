# Function_00049AB6

**ROM:** `0x00049AB6`

```c

void Function_00049AB6(undefined4 param_1)

{
  if (param_1._1_1_ == 'T') {
    if ((char)param_1 == 'E') {
      DAT_00003722 = 1;
    }
    else if ((char)param_1 == 'D') {
      DAT_00003722 = 0;
    }
  }
  else if (param_1._1_1_ == 'R') {
    if ((char)param_1 == 'E') {
      DAT_00003720 = 1;
    }
    else if ((char)param_1 == 'D') {
      DAT_00003720 = 0;
    }
  }
  else if (param_1._1_1_ == 'D') {
    DAT_00003d8c = 0xc6;
    DAT_00003d8d = 0;
    DAT_00003d8e = (char)param_1;
    Function_000495AC();
  }
  return;
}

```
