# Function_000694B2

**ROM:** `0x000694B2`

```c

void Function_000694B2(void)

{
  if (((DAT_00001066 <= DAT_00004f46) && (DAT_00004f48 <= DAT_00001066)) &&
     ((DAT_0000103a & 4) != 0)) {
    if (DAT_00001066 < DAT_00003506) {
      DAT_00003504 = DAT_00003506 - DAT_00001066;
    }
    else {
      DAT_00003504 = 0;
    }
    if (DAT_00004f4a <= DAT_00003504) {
      DAT_00001151 = RAM_Ret_fuel_time_;
      DAT_00003502 = 0;
      DAT_0000103b = DAT_0000103b | 0x18;
    }
  }
  if ((DAT_0000103b & 0x10) != 0) {
    if (DAT_00003502 < RAM_Ret_fuel_step_) {
      DAT_00003502 = DAT_00003502 + 1;
    }
    else {
      DAT_00003502 = 0;
      DAT_0000103b = DAT_0000103b & 0xe7;
    }
  }
  DAT_00003506 = DAT_00001066;
  return;
}

```
