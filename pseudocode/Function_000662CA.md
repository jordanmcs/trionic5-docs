# Function_000662CA

**ROM:** `0x000662CA`

```c

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

ushort Function_000662CA(undefined4 param_1)

{
  bool bVar1;
  short sVar2;
  ushort in_D1w;
  
  if (param_1._0_2_ == 0) {
    DAT_0000331b = '\0';
    DAT_0000331c = '\0';
    DAT_0000331a = '\0';
    _DAT_00001984 = 0;
    RAM_VSS2_error = 0;
    DAT_0000331e = '\0';
    DAT_0000331f = '\0';
    DAT_00003320 = '\0';
    RAM_Luft_error = 0;
    DAT_00003322 = '\0';
    RAM_Trot_delta = 0x30;
    DAT_00003323 = '\0';
    RAM_Sond_error = 0;
    DAT_0000332b = '\0';
    DAT_00003325 = '\0';
    RAM_Hast_error = 0;
    RAM_Idle_error = 0;
    DAT_00003328 = '\0';
    DAT_00001d20 = '\0';
    DAT_0000332f = '\0';
    RAM_Rpm_byte = 0x80;
    RAM_Adapt_injfaktor_ = 0x80;
    DAT_00001d24 = '\0';
    DAT_00001d25 = '\0';
    RAM_Tank_error = 0;
    DAT_0000409e = '\0';
    DAT_0000409c = '\0';
    DAT_000040a2 = '\0';
    DAT_000040a0 = '\0';
    RAM_R_sond_error = 0;
    if (((DAT_00006e20 & 2) == 0) || (DAT_0000464a == 'O')) {
      DAT_00001d22 = '\0';
      DAT_00001d23 = '\0';
      DAT_00001d26 = '\0';
      RAM_Sync_error = 0;
      DAT_00003329 = '\0';
      DAT_00001d21 = '\0';
      DAT_0000332a = '\0';
      DAT_0000332e = '\0';
      DAT_0000332c = '\0';
      DAT_0000332d = '\0';
    }
  }
  else if (param_1._0_2_ == 1) {
    DAT_000034f4 = 0;
    sVar2 = DAT_000034f4;
    if (DAT_0000331b != '\0') {
      DAT_000034f4 = 1;
      sVar2 = 1;
      if (param_1._2_2_ == 1) {
        DAT_0000331b = '\0';
        sVar2 = DAT_000034f4;
      }
    }
    DAT_000034f4 = sVar2;
    if ((DAT_0000331c != '\0') && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4))
    {
      DAT_0000331c = '\0';
    }
    if ((DAT_0000331a != '\0') && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4))
    {
      DAT_0000331a = '\0';
      _DAT_00001984 = 0;
    }
    if ((RAM_VSS2_error != 0) && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      RAM_VSS2_error = 0;
    }
    if ((DAT_0000331e != '\0') && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4))
    {
      DAT_0000331e = '\0';
    }
    if ((DAT_0000331f != '\0') &&
       ((((DAT_000040e5 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      DAT_0000331f = '\0';
    }
    if (((DAT_00003320 != '\0') && (((DAT_000040e5 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      DAT_00003320 = '\0';
    }
    if (((RAM_Luft_error != 0) && (((DAT_000040e6 & 8) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      RAM_Luft_error = 0;
    }
    if ((DAT_00003322 != '\0') &&
       ((((DAT_000040e6 & 4) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      DAT_00003322 = '\0';
      RAM_Trot_delta = 0x30;
    }
    if (((DAT_00003323 != '\0') && (((DAT_000040e5 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      DAT_00003323 = '\0';
    }
    if (((RAM_Sond_error != 0) && (((DAT_000040e7 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      RAM_Sond_error = 0;
    }
    if ((DAT_0000332b != '\0') &&
       ((((DAT_000040e6 & 1) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      DAT_0000332b = '\0';
    }
    if (((DAT_00003325 != '\0') && (((DAT_000040e4 & 0x10) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      DAT_00003325 = '\0';
    }
    if (((RAM_Hast_error != 0) && (((DAT_000040e4 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      RAM_Hast_error = 0;
    }
    if ((RAM_Idle_error != 0) &&
       ((((DAT_000040e4 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      RAM_Idle_error = 0;
    }
    if (((DAT_00003328 != '\0') && (((DAT_000040e4 & 8) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      DAT_00003328 = '\0';
    }
    if (((DAT_00001d20 != '\0') && (((DAT_000040e4 & 2) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      DAT_00001d20 = '\0';
    }
    if ((DAT_0000332f != '\0') &&
       ((((DAT_000040e7 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      DAT_0000332f = '\0';
      RAM_Rpm_byte = 0x80;
      RAM_Adapt_injfaktor_ = 0x80;
    }
    if (((DAT_00001d24 != '\0') && (((DAT_000040e5 & 8) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      DAT_00001d24 = '\0';
    }
    if (((DAT_00001d25 != '\0') && (((DAT_000040e6 & 0x10) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      DAT_00001d25 = '\0';
    }
    if ((RAM_Tank_error != 0) &&
       ((((DAT_000040e4 & 4) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      RAM_Tank_error = 0;
    }
    if (((DAT_000040a2 == '\0') && (DAT_000040a0 == '\0')) &&
       ((DAT_0000409e == '\0' && (DAT_0000409c == '\0')))) {
      bVar1 = false;
    }
    else {
      bVar1 = true;
    }
    if ((bVar1) &&
       (((((DAT_000040e7 & 0x80) != 0 || ((DAT_000040e7 & 0x40) != 0)) ||
         (((DAT_000040e5 & 1) != 0 ||
          (((DAT_000040e5 & 0x10) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))))) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      DAT_000040a2 = '\0';
      DAT_000040a0 = '\0';
      DAT_0000409e = '\0';
      DAT_0000409c = '\0';
    }
    in_D1w = 0;
    if (((DAT_00006e20 & 2) == 0) || (DAT_0000464a == 'O')) {
      if ((DAT_00001d22 == '\0') && (DAT_00001d23 == '\0')) {
        bVar1 = false;
      }
      else {
        bVar1 = true;
      }
      if ((bVar1) &&
         (((((DAT_000040e5 & 1) != 0 || ((DAT_000040e5 & 0x10) != 0)) ||
           ((RAM_Samp_pek[0xc] & 4) == 0)) &&
          (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
        DAT_00001d22 = '\0';
        DAT_00001d23 = '\0';
      }
      if (((DAT_00001d26 != '\0') &&
          (((DAT_000040e6 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        DAT_00001d26 = '\0';
      }
      if (((RAM_Sync_error != 0) && (((DAT_000040e4 & 1) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
         && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        RAM_Sync_error = 0;
      }
      if ((RAM_R_sond_error != 0) &&
         ((((DAT_000040e7 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
          (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
        RAM_R_sond_error = 0;
      }
      if (((DAT_00003329 != '\0') &&
          (((DAT_000040e4 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        DAT_00003329 = '\0';
      }
      if (((DAT_00001d21 != '\0') && (((DAT_000040e5 & 2) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
         && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        DAT_00001d21 = '\0';
      }
      if ((DAT_0000332a != '\0') &&
         ((((DAT_000040e5 & 4) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
          (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
        DAT_0000332a = '\0';
      }
      if (((DAT_0000332e != '\0') && (((DAT_000040e6 & 2) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
         && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        DAT_0000332e = '\0';
      }
      if (((DAT_0000332c != '\0') &&
          (((DAT_000040e6 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        DAT_0000332c = '\0';
      }
      if ((DAT_0000332d != '\0') &&
         ((((DAT_000040e6 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
          (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
        DAT_0000332d = '\0';
      }
      in_D1w = 0;
    }
  }
  else if (param_1._0_2_ == 2) {
    DAT_0000350a = (ushort)(DAT_0000331b != '\0');
    if (DAT_0000331c != '\0') {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if (DAT_0000331a != '\0') {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if (RAM_VSS2_error != 0) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if (DAT_0000331e != '\0') {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_0000331f != '\0') && (((DAT_000040e5 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
    {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00003320 != '\0') && (((DAT_000040e5 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
    {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Luft_error != 0) && (((DAT_000040e6 & 8) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00003322 != '\0') && (((DAT_000040e6 & 4) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00003323 != '\0') && (((DAT_000040e5 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
    {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Sond_error != 0) && (((DAT_000040e7 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_0000332b != '\0') && (((DAT_000040e6 & 1) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00003325 != '\0') && (((DAT_000040e4 & 0x10) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
    {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Hast_error != 0) && (((DAT_000040e4 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Idle_error != 0) && (((DAT_000040e4 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00003328 != '\0') && (((DAT_000040e4 & 8) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00001d20 != '\0') && (((DAT_000040e4 & 2) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_0000332f != '\0') && (((DAT_000040e7 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
    {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00001d24 != '\0') && (((DAT_000040e5 & 8) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00001d25 != '\0') && (((DAT_000040e6 & 0x10) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
    {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Tank_error != 0) && (((DAT_000040e4 & 4) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((((DAT_000040a2 == '\0') && (DAT_000040a0 == '\0')) && (DAT_0000409e == '\0')) &&
       (DAT_0000409c == '\0')) {
      bVar1 = false;
    }
    else {
      bVar1 = true;
    }
    if ((bVar1) &&
       ((((DAT_000040e7 & 0x80) != 0 || ((DAT_000040e7 & 0x40) != 0)) ||
        (((DAT_000040e5 & 1) != 0 ||
         (((DAT_000040e5 & 0x10) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))))))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if (((DAT_00006e20 & 2) == 0) || (in_D1w = DAT_0000350a, DAT_0000464a == 'O')) {
      if (((DAT_00001d22 != '\0') || (DAT_00001d23 != '\0')) &&
         ((((DAT_000040e5 & 1) != 0 || ((DAT_000040e5 & 0x10) != 0)) ||
          ((RAM_Samp_pek[0xc] & 4) == 0)))) {
        DAT_0000350a = DAT_0000350a + 1;
      }
      if ((DAT_00001d26 != '\0') && (((DAT_000040e6 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))
         ) {
        DAT_0000350a = DAT_0000350a + 1;
      }
      if ((RAM_Sync_error != 0) && (((DAT_000040e4 & 1) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
        DAT_0000350a = DAT_0000350a + 1;
      }
      if ((RAM_R_sond_error != 0) &&
         (((DAT_000040e7 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
        DAT_0000350a = DAT_0000350a + 1;
      }
      if ((DAT_00003329 != '\0') && (((DAT_000040e4 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))
         ) {
        DAT_0000350a = DAT_0000350a + 1;
      }
      if ((DAT_00001d21 != '\0') && (((DAT_000040e5 & 2) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
        DAT_0000350a = DAT_0000350a + 1;
      }
      if ((DAT_0000332a != '\0') && (((DAT_000040e5 & 4) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
        DAT_0000350a = DAT_0000350a + 1;
      }
      if ((DAT_0000332e != '\0') && (((DAT_000040e6 & 2) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) {
        DAT_0000350a = DAT_0000350a + 1;
      }
      if ((DAT_0000332c != '\0') && (((DAT_000040e6 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))
         ) {
        DAT_0000350a = DAT_0000350a + 1;
      }
      in_D1w = DAT_0000350a;
      if ((DAT_0000332d != '\0') && (((DAT_000040e6 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))
         ) {
        in_D1w = DAT_0000350a + 1;
        DAT_0000350a = in_D1w;
      }
    }
  }
  else if (param_1._0_2_ == 3) {
    DAT_000034f4 = 0;
    in_D1w = 0;
    sVar2 = DAT_000034f4;
    if (DAT_0000331b != '\0') {
      DAT_000034f4 = 1;
      sVar2 = 1;
      if (param_1._2_2_ == 1) {
        in_D1w = 0x1640;
        sVar2 = DAT_000034f4;
      }
    }
    DAT_000034f4 = sVar2;
    if ((DAT_0000331c != '\0') && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4))
    {
      in_D1w = 0x1641;
    }
    if ((DAT_0000331a != '\0') && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4))
    {
      in_D1w = 0x1651;
    }
    if ((RAM_VSS2_error != 0) && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      in_D1w = 0x1652;
    }
    if ((DAT_0000331e != '\0') && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4))
    {
      in_D1w = 0x605;
    }
    if ((DAT_0000331f != '\0') &&
       ((((DAT_000040e5 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      if ((DAT_0000403a & 0x80) == 0) {
        if ((DAT_0000403a & 0x40) == 0) {
          if ((DAT_0000403a & 0x20) == 0) {
            if ((DAT_0000403a & 0x10) == 0) {
              in_D1w = 0x115;
            }
            else {
              in_D1w = 0x125;
            }
          }
          else {
            in_D1w = 0x116;
          }
        }
        else {
          in_D1w = 0x117;
        }
      }
      else {
        in_D1w = 0x118;
      }
    }
    if (((DAT_00003320 != '\0') && (((DAT_000040e5 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_0000404a & 0x80) == 0) {
        if ((DAT_0000404a & 0x40) == 0) {
          in_D1w = 0x110;
        }
        else {
          in_D1w = 0x112;
        }
      }
      else {
        in_D1w = 0x113;
      }
    }
    if (((RAM_Luft_error != 0) && (((DAT_000040e6 & 8) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004046 & 0x80) == 0) {
        if ((DAT_00004046 & 0x40) == 0) {
          in_D1w = ((DAT_00004046 & 0x20) != 0) + 0x105;
        }
        else {
          in_D1w = 0x107;
        }
      }
      else {
        in_D1w = 0x108;
      }
    }
    if ((DAT_00003322 != '\0') &&
       ((((DAT_000040e6 & 4) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      if ((DAT_0000403c & 0x80) == 0) {
        if ((DAT_0000403c & 0x40) == 0) {
          in_D1w = ((DAT_0000403c & 0x20) != 0) + 0x120;
        }
        else {
          in_D1w = 0x122;
        }
      }
      else {
        in_D1w = 0x123;
      }
    }
    if (((DAT_00003323 != '\0') && (((DAT_000040e5 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004038 & 0x80) == 0) {
        if ((DAT_00004038 & 0x40) == 0) {
          if ((DAT_00004038 & 0x10) == 0) {
            if ((DAT_00004038 & 8) == 0) {
              in_D1w = 0x130;
            }
            else {
              in_D1w = 0x135;
            }
          }
          else {
            in_D1w = 0x134;
          }
        }
        else {
          in_D1w = 0x132;
        }
      }
      else {
        in_D1w = 0x131;
      }
    }
    if (((RAM_Sond_error != 0) && (((DAT_000040e7 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004034 & 0x80) == 0) {
        if ((DAT_00004034 & 0x40) == 0) {
          in_D1w = 0x1170;
        }
        else {
          in_D1w = 0x1172;
        }
      }
      else {
        in_D1w = 0x1171;
      }
    }
    if ((DAT_0000332b != '\0') &&
       ((((DAT_000040e6 & 1) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      in_D1w = 0x1611;
    }
    if (((DAT_00003325 != '\0') && (((DAT_000040e4 & 0x10) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if (((DAT_0000403e & 0x80) == 0) && ((DAT_0000403e & 0x20) == 0)) {
        if ((DAT_0000403e & 0x40) == 0) {
          in_D1w = 0x500;
        }
        else {
          in_D1w = 0x502;
        }
      }
      else {
        in_D1w = 0x501;
      }
    }
    if ((RAM_Hast_error != 0) &&
       ((((DAT_000040e4 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      if ((DAT_00004030 & 0x80) == 0) {
        in_D1w = ((DAT_00004030 & 0x40) != 0) + 0x505;
      }
      else {
        in_D1w = 0x507;
      }
    }
    if (((RAM_Idle_error != 0) && (((DAT_000040e4 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004044 & 0x80) == 0) {
        if ((DAT_00004044 & 0x40) == 0) {
          if ((DAT_00004044 & 0x10) == 0) {
            in_D1w = 0x443;
          }
          else {
            in_D1w = 0x441;
          }
        }
        else {
          in_D1w = 0x445;
        }
      }
      else {
        in_D1w = 0x444;
      }
    }
    if (((DAT_00003328 != '\0') && (((DAT_000040e4 & 8) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004040 & 0x80) == 0) {
        if ((DAT_00004040 & 0x40) == 0) {
          in_D1w = 0x410;
        }
        else {
          in_D1w = 0x414;
        }
      }
      else {
        in_D1w = 0x413;
      }
    }
    if ((DAT_00001d20 != '\0') &&
       ((((DAT_000040e4 & 2) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      in_D1w = 0x327;
    }
    if (((DAT_0000332f != '\0') && (((DAT_000040e7 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
       && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004048 & 0x80) == 0) {
        in_D1w = ((DAT_00004048 & 0x40) != 0) + 0x170;
      }
      else {
        in_D1w = 0x172;
      }
    }
    if (((DAT_00001d24 != '\0') && (((DAT_000040e5 & 8) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      in_D1w = 0x1322;
    }
    if ((DAT_00001d25 != '\0') &&
       ((((DAT_000040e6 & 0x10) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      in_D1w = 0x1500;
    }
    if (((RAM_Tank_error != 0) && (((DAT_000040e4 & 4) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      in_D1w = 0x335;
    }
    if (((DAT_000040a2 == '\0') && (DAT_000040a0 == '\0')) &&
       ((DAT_0000409e == '\0' && (DAT_0000409c == '\0')))) {
      bVar1 = false;
    }
    else {
      bVar1 = true;
    }
    if ((bVar1) &&
       ((((((DAT_000040e7 & 0x80) != 0 || ((DAT_000040e7 & 0x40) != 0)) || ((DAT_000040e5 & 1) != 0)
          ) || (((DAT_000040e5 & 0x10) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
        (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
      in_D1w = 0x1416;
    }
    if (((DAT_00006e20 & 2) == 0) || (DAT_0000464a == 'O')) {
      if (((DAT_00001d22 != '\0') || (DAT_00001d23 != '\0')) &&
         (((((DAT_000040e5 & 1) != 0 || ((DAT_000040e5 & 0x10) != 0)) ||
           ((RAM_Samp_pek[0xc] & 4) == 0)) &&
          (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
        if ((((DAT_00004032 & 0x80) == 0) || ((DAT_00004032 & 0x40) != 0)) ||
           (((DAT_00004032 & 0x20) != 0 || ((DAT_00004032 & 0x10) != 0)))) {
          if ((((DAT_00004032 & 0x40) == 0) || ((DAT_00004032 & 0x80) != 0)) ||
             (((DAT_00004032 & 0x20) != 0 || ((DAT_00004032 & 0x10) != 0)))) {
            if (((((DAT_00004032 & 0x20) == 0) || ((DAT_00004032 & 0x80) != 0)) ||
                ((DAT_00004032 & 0x40) != 0)) || ((DAT_00004032 & 0x10) != 0)) {
              if ((((DAT_00004032 & 0x10) == 0) || ((DAT_00004032 & 0x80) != 0)) ||
                 (((DAT_00004032 & 0x40) != 0 || ((DAT_00004032 & 0x20) != 0)))) {
                in_D1w = 0x300;
              }
              else {
                in_D1w = 0x304;
              }
            }
            else {
              in_D1w = 0x303;
            }
          }
          else {
            in_D1w = 0x302;
          }
        }
        else {
          in_D1w = 0x301;
        }
      }
      if (((DAT_00001d26 != '\0') &&
          (((DAT_000040e6 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = 0x340;
      }
      if ((RAM_Sync_error != 0) &&
         ((((DAT_000040e4 & 1) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
          (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
        if ((DAT_00004036 & 8) == 0) {
          if ((DAT_00004036 & 0x40) == 0) {
            if ((DAT_00004036 & 0x10) == 0) {
              in_D1w = 0x136;
            }
            else {
              in_D1w = 0x140;
            }
          }
          else {
            in_D1w = 0x138;
          }
        }
        else {
          in_D1w = 0x141;
        }
      }
      if (((RAM_R_sond_error != 0) &&
          (((DAT_000040e7 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        if ((DAT_00004042 & 0x80) == 0) {
          if ((DAT_00004042 & 0x40) == 0) {
            if ((DAT_00004042 & 8) == 0) {
              if ((DAT_00004042 & 0x10) == 0) {
                if ((DAT_00004042 & 0x20) == 0) {
                  in_D1w = 0x440;
                }
                else {
                  in_D1w = 0x455;
                }
              }
              else {
                in_D1w = 0x442;
              }
            }
            else {
              in_D1w = 0x451;
            }
          }
          else {
            in_D1w = 0x453;
          }
        }
        else {
          in_D1w = 0x452;
        }
      }
      if (((DAT_00003329 != '\0') &&
          (((DAT_000040e4 & 0x80) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = 0x420;
      }
      if ((DAT_00001d21 != '\0') &&
         ((((DAT_000040e5 & 2) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
          (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
        in_D1w = 0x133;
      }
      if (((DAT_0000332a != '\0') && (((DAT_000040e5 & 4) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
         && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = 0x1549;
      }
      if (((DAT_0000332e != '\0') && (((DAT_000040e6 & 2) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0))))
         && (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = ((RAM_BrakeCnt._0_1_ >> 4 & 1) != 0) + 0x1576;
      }
      if ((DAT_0000332c != '\0') &&
         ((((DAT_000040e6 & 0x40) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)) &&
          (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)))) {
        in_D1w = 0x1396;
      }
      if (((DAT_0000332d != '\0') &&
          (((DAT_000040e6 & 0x20) != 0 || ((RAM_Samp_pek[0xc] & 4) == 0)))) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = 0x1397;
      }
    }
  }
  else if (param_1._0_2_ == 4) {
    in_D1w = 0;
    if (param_1._2_2_ == 0x331a) {
      in_D1w = 0x1651;
    }
    if (param_1._2_2_ == 0x331d) {
      in_D1w = 0x1652;
    }
    if (param_1._2_2_ == 0x331e) {
      in_D1w = 0x605;
    }
    if (param_1._2_2_ == 0x331f) {
      if ((DAT_0000403a & 0x80) == 0) {
        if ((DAT_0000403a & 0x40) == 0) {
          in_D1w = 0x115;
        }
        else {
          in_D1w = 0x117;
        }
      }
      else {
        in_D1w = 0x118;
      }
    }
    if (param_1._2_2_ == 0x3320) {
      if ((DAT_0000404a & 0x80) == 0) {
        if ((DAT_0000404a & 0x40) == 0) {
          in_D1w = 0x110;
        }
        else {
          in_D1w = 0x112;
        }
      }
      else {
        in_D1w = 0x113;
      }
    }
    if (param_1._2_2_ == 0x3321) {
      if ((DAT_00004046 & 0x80) == 0) {
        if ((DAT_00004046 & 0x40) == 0) {
          in_D1w = ((DAT_00004046 & 0x20) != 0) + 0x105;
        }
        else {
          in_D1w = 0x107;
        }
      }
      else {
        in_D1w = 0x108;
      }
    }
    if (param_1._2_2_ == 0x3322) {
      if ((DAT_0000403c & 0x80) == 0) {
        if ((DAT_0000403c & 0x40) == 0) {
          in_D1w = ((DAT_0000403c & 0x20) != 0) + 0x120;
        }
        else {
          in_D1w = 0x122;
        }
      }
      else {
        in_D1w = 0x123;
      }
    }
    if (param_1._2_2_ == 0x3323) {
      if ((DAT_00004038 & 0x80) == 0) {
        if ((DAT_00004038 & 0x40) == 0) {
          if ((DAT_00004038 & 0x10) == 0) {
            if ((DAT_00004038 & 8) == 0) {
              in_D1w = 0x130;
            }
            else {
              in_D1w = 0x135;
            }
          }
          else {
            in_D1w = 0x134;
          }
        }
        else {
          in_D1w = 0x132;
        }
      }
      else {
        in_D1w = 0x131;
      }
    }
    if (param_1._2_2_ == 0x3324) {
      if ((DAT_00004034 & 0x80) == 0) {
        if ((DAT_00004034 & 0x40) == 0) {
          in_D1w = 0x1170;
        }
        else {
          in_D1w = 0x1172;
        }
      }
      else {
        in_D1w = 0x1171;
      }
    }
    if (param_1._2_2_ == 0x332b) {
      in_D1w = 0x1611;
    }
    if (param_1._2_2_ == 0x3325) {
      if (((DAT_0000403e & 0x80) == 0) && ((DAT_0000403e & 0x20) == 0)) {
        if ((DAT_0000403e & 0x40) == 0) {
          in_D1w = 0x500;
        }
        else {
          in_D1w = 0x502;
        }
      }
      else {
        in_D1w = 0x501;
      }
    }
    if (param_1._2_2_ == 0x3326) {
      if ((DAT_00004030 & 0x80) == 0) {
        in_D1w = ((DAT_00004030 & 0x40) != 0) + 0x505;
      }
      else {
        in_D1w = 0x507;
      }
    }
    if (param_1._2_2_ == 0x3327) {
      if ((DAT_00004044 & 0x80) == 0) {
        if ((DAT_00004044 & 0x40) == 0) {
          if ((DAT_00004044 & 0x10) == 0) {
            in_D1w = 0x443;
          }
          else {
            in_D1w = 0x441;
          }
        }
        else {
          in_D1w = 0x445;
        }
      }
      else {
        in_D1w = 0x444;
      }
    }
    if (param_1._2_2_ == 0x3328) {
      if ((DAT_00004040 & 0x80) == 0) {
        if ((DAT_00004040 & 0x40) == 0) {
          in_D1w = 0x410;
        }
        else {
          in_D1w = 0x414;
        }
      }
      else {
        in_D1w = 0x413;
      }
    }
    if (param_1._2_2_ == 0x1d20) {
      in_D1w = 0x327;
    }
    if (param_1._2_2_ == 0x332f) {
      if ((DAT_00004048 & 0x80) == 0) {
        in_D1w = ((DAT_00004048 & 0x40) != 0) + 0x170;
      }
      else {
        in_D1w = 0x172;
      }
    }
    if (param_1._2_2_ == 0x1d24) {
      in_D1w = 0x1322;
    }
    if (param_1._2_2_ == 0x1d25) {
      in_D1w = 0x1500;
    }
    if (param_1._2_2_ == 0x1d29) {
      in_D1w = 0x335;
    }
    if ((param_1._2_2_ == 0x1d22) || (param_1._2_2_ == 0x1d23)) {
      if ((DAT_00004032 & 0x80) == 0) {
        if ((DAT_00004032 & 0x40) == 0) {
          if ((DAT_00004032 & 0x20) == 0) {
            if ((DAT_00004032 & 0x10) == 0) {
              in_D1w = 0x300;
            }
            else {
              in_D1w = 0x304;
            }
          }
          else {
            in_D1w = 0x303;
          }
        }
        else {
          in_D1w = 0x302;
        }
      }
      else {
        in_D1w = 0x301;
      }
    }
    if (param_1._2_2_ == 0x1d26) {
      in_D1w = 0x340;
    }
    if (param_1._2_2_ == 0x1d27) {
      if ((DAT_00004036 & 8) == 0) {
        if ((DAT_00004036 & 0x40) == 0) {
          if ((DAT_00004036 & 0x10) == 0) {
            in_D1w = 0x136;
          }
          else {
            in_D1w = 0x140;
          }
        }
        else {
          in_D1w = 0x138;
        }
      }
      else {
        in_D1w = 0x141;
      }
    }
    if (param_1._2_2_ == 0x1d28) {
      if ((DAT_00004042 & 0x80) == 0) {
        if ((DAT_00004042 & 0x40) == 0) {
          if ((DAT_00004042 & 8) == 0) {
            if ((DAT_00004042 & 0x10) == 0) {
              if ((DAT_00004042 & 0x20) == 0) {
                in_D1w = 0x440;
              }
              else {
                in_D1w = 0x455;
              }
            }
            else {
              in_D1w = 0x442;
            }
          }
          else {
            in_D1w = 0x451;
          }
        }
        else {
          in_D1w = 0x453;
        }
      }
      else {
        in_D1w = 0x452;
      }
    }
    if (param_1._2_2_ == 0x3329) {
      in_D1w = 0x420;
    }
    if (param_1._2_2_ == 0x1d21) {
      in_D1w = 0x133;
    }
    if (param_1._2_2_ == 0x332a) {
      in_D1w = 0x1549;
    }
    if (param_1._2_2_ == 0x332e) {
      in_D1w = ((RAM_BrakeCnt._0_1_ >> 4 & 1) != 0) + 0x1576;
    }
    if (param_1._2_2_ == 0x332c) {
      in_D1w = 0x1396;
    }
    if (param_1._2_2_ == 0x332d) {
      in_D1w = 0x1397;
    }
  }
  else if (param_1._0_2_ == 5) {
    DAT_0000350a = 0;
    if ((DAT_0000331f != '\0') && (-1 < (char)DAT_000040e5)) {
      DAT_0000350a = 1;
    }
    if ((DAT_00003320 != '\0') && ((DAT_000040e5 >> 6 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Luft_error != 0) && ((DAT_000040e6 >> 3 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00003322 != '\0') && ((DAT_000040e6 >> 2 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00003323 != '\0') && ((DAT_000040e5 >> 5 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Sond_error != 0) && ((DAT_000040e7 >> 6 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_0000332b != '\0') && ((DAT_000040e6 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00003325 != '\0') && ((DAT_000040e4 >> 4 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Hast_error != 0) && ((DAT_000040e4 >> 6 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Idle_error != 0) && ((DAT_000040e4 >> 5 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00003328 != '\0') && ((DAT_000040e4 >> 3 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00001d20 != '\0') && ((DAT_000040e4 >> 1 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_0000332f != '\0') && (-1 < (char)DAT_000040e7)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00001d24 != '\0') && ((DAT_000040e5 >> 3 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00001d25 != '\0') && ((DAT_000040e6 >> 4 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Tank_error != 0) && ((DAT_000040e4 >> 2 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if (((((DAT_000040a2 != '\0') && ((DAT_000040e5 >> 4 & 1) == 0)) ||
         ((DAT_000040a0 != '\0' && ((DAT_000040e5 & 1) == 0)))) ||
        ((DAT_0000409e != '\0' && (-1 < (char)DAT_000040e7)))) ||
       ((DAT_0000409c != '\0' && ((DAT_000040e7 >> 6 & 1) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if (((DAT_00001d22 != '\0') && ((DAT_000040e5 >> 4 & 1) == 0)) ||
       ((DAT_00001d23 != '\0' && ((DAT_000040e5 & 1) == 0)))) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00001d26 != '\0') && (-1 < (char)DAT_000040e6)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_Sync_error != 0) && ((DAT_000040e4 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((RAM_R_sond_error != 0) && ((DAT_000040e7 >> 5 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00003329 != '\0') && (-1 < (char)DAT_000040e4)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_00001d21 != '\0') && ((DAT_000040e5 >> 1 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_0000332a != '\0') && ((DAT_000040e5 >> 2 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_0000332e != '\0') && ((DAT_000040e6 >> 1 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    if ((DAT_0000332c != '\0') && ((DAT_000040e6 >> 6 & 1) == 0)) {
      DAT_0000350a = DAT_0000350a + 1;
    }
    in_D1w = DAT_0000350a;
    if ((DAT_0000332d != '\0') && ((DAT_000040e6 >> 5 & 1) == 0)) {
      in_D1w = DAT_0000350a + 1;
      DAT_0000350a = in_D1w;
    }
  }
  else if (param_1._0_2_ == 6) {
    DAT_000034f4 = 0;
    in_D1w = 0;
    sVar2 = DAT_000034f4;
    if ((DAT_0000331f != '\0') && (-1 < (char)DAT_000040e5)) {
      DAT_000034f4 = 1;
      sVar2 = 1;
      if (param_1._2_2_ == 1) {
        sVar2 = DAT_000034f4;
        if ((DAT_0000403a & 0x80) == 0) {
          if ((DAT_0000403a & 0x40) == 0) {
            if ((DAT_0000403a & 0x20) == 0) {
              if ((DAT_0000403a & 0x10) == 0) {
                in_D1w = 0x115;
              }
              else {
                in_D1w = 0x125;
              }
            }
            else {
              in_D1w = 0x116;
            }
          }
          else {
            in_D1w = 0x117;
          }
        }
        else {
          in_D1w = 0x118;
        }
      }
    }
    DAT_000034f4 = sVar2;
    if (((DAT_00003320 != '\0') && ((DAT_000040e5 >> 6 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_0000404a & 0x80) == 0) {
        if ((DAT_0000404a & 0x40) == 0) {
          in_D1w = 0x110;
        }
        else {
          in_D1w = 0x112;
        }
      }
      else {
        in_D1w = 0x113;
      }
    }
    if (((RAM_Luft_error != 0) && ((DAT_000040e6 >> 3 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004046 & 0x80) == 0) {
        if ((DAT_00004046 & 0x40) == 0) {
          in_D1w = ((DAT_00004046 & 0x20) != 0) + 0x105;
        }
        else {
          in_D1w = 0x107;
        }
      }
      else {
        in_D1w = 0x108;
      }
    }
    if (((DAT_00003322 != '\0') && ((DAT_000040e6 >> 2 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_0000403c & 0x80) == 0) {
        if ((DAT_0000403c & 0x40) == 0) {
          in_D1w = ((DAT_0000403c & 0x20) != 0) + 0x120;
        }
        else {
          in_D1w = 0x122;
        }
      }
      else {
        in_D1w = 0x123;
      }
    }
    if (((DAT_00003323 != '\0') && ((DAT_000040e5 >> 5 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004038 & 0x80) == 0) {
        if ((DAT_00004038 & 0x40) == 0) {
          if ((DAT_00004038 & 0x10) == 0) {
            if ((DAT_00004038 & 8) == 0) {
              in_D1w = 0x130;
            }
            else {
              in_D1w = 0x135;
            }
          }
          else {
            in_D1w = 0x134;
          }
        }
        else {
          in_D1w = 0x132;
        }
      }
      else {
        in_D1w = 0x131;
      }
    }
    if (((RAM_Sond_error != 0) && ((DAT_000040e7 >> 6 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004034 & 0x80) == 0) {
        if ((DAT_00004034 & 0x40) == 0) {
          in_D1w = 0x1170;
        }
        else {
          in_D1w = 0x1172;
        }
      }
      else {
        in_D1w = 0x1171;
      }
    }
    if (((DAT_0000332b != '\0') && ((DAT_000040e6 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      in_D1w = 0x1611;
    }
    if (((DAT_00003325 != '\0') && ((DAT_000040e4 >> 4 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if (((DAT_0000403e & 0x80) == 0) && ((DAT_0000403e & 0x20) == 0)) {
        if ((DAT_0000403e & 0x40) == 0) {
          in_D1w = 0x500;
        }
        else {
          in_D1w = 0x502;
        }
      }
      else {
        in_D1w = 0x501;
      }
    }
    if (((RAM_Hast_error != 0) && ((DAT_000040e4 >> 6 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004030 & 0x80) == 0) {
        in_D1w = ((DAT_00004030 & 0x40) != 0) + 0x505;
      }
      else {
        in_D1w = 0x507;
      }
    }
    if (((RAM_Idle_error != 0) && ((DAT_000040e4 >> 5 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004044 & 0x80) == 0) {
        if ((DAT_00004044 & 0x40) == 0) {
          if ((DAT_00004044 & 0x10) == 0) {
            in_D1w = 0x443;
          }
          else {
            in_D1w = 0x441;
          }
        }
        else {
          in_D1w = 0x445;
        }
      }
      else {
        in_D1w = 0x444;
      }
    }
    if (((DAT_00003328 != '\0') && ((DAT_000040e4 >> 3 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004040 & 0x80) == 0) {
        if ((DAT_00004040 & 0x40) == 0) {
          in_D1w = 0x410;
        }
        else {
          in_D1w = 0x414;
        }
      }
      else {
        in_D1w = 0x413;
      }
    }
    if (((DAT_00001d20 != '\0') && ((DAT_000040e4 >> 1 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      in_D1w = 0x327;
    }
    if (((DAT_0000332f != '\0') && (-1 < (char)DAT_000040e7)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      if ((DAT_00004048 & 0x80) == 0) {
        in_D1w = ((DAT_00004048 & 0x40) != 0) + 0x170;
      }
      else {
        in_D1w = 0x172;
      }
    }
    if (((DAT_00001d24 != '\0') && ((DAT_000040e5 >> 3 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      in_D1w = 0x1322;
    }
    if (((DAT_00001d25 != '\0') && ((DAT_000040e6 >> 4 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      in_D1w = 0x1500;
    }
    if (((RAM_Tank_error != 0) && ((DAT_000040e4 >> 2 & 1) == 0)) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      in_D1w = 0x335;
    }
    if (((((DAT_000040a2 != '\0') && ((DAT_000040e5 >> 4 & 1) == 0)) ||
         (((DAT_000040a0 != '\0' && ((DAT_000040e5 & 1) == 0)) ||
          ((DAT_0000409e != '\0' && (-1 < (char)DAT_000040e7)))))) ||
        ((DAT_0000409c != '\0' && ((DAT_000040e7 >> 6 & 1) == 0)))) &&
       (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
      in_D1w = 0x1416;
    }
    if (((DAT_00006e20 & 2) == 0) || (DAT_0000464a == 'O')) {
      if ((((DAT_00001d22 != '\0') && ((DAT_000040e5 >> 4 & 1) == 0)) ||
          ((DAT_00001d23 != '\0' && ((DAT_000040e5 & 1) == 0)))) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        if (((((DAT_00004032 & 0x80) == 0) || ((DAT_00004032 & 0x40) != 0)) ||
            ((DAT_00004032 & 0x20) != 0)) || ((DAT_00004032 & 0x10) != 0)) {
          if ((((DAT_00004032 & 0x40) == 0) || ((DAT_00004032 & 0x80) != 0)) ||
             (((DAT_00004032 & 0x20) != 0 || ((DAT_00004032 & 0x10) != 0)))) {
            if ((((DAT_00004032 & 0x20) == 0) || ((DAT_00004032 & 0x80) != 0)) ||
               (((DAT_00004032 & 0x40) != 0 || ((DAT_00004032 & 0x10) != 0)))) {
              if (((((DAT_00004032 & 0x10) == 0) || ((DAT_00004032 & 0x80) != 0)) ||
                  ((DAT_00004032 & 0x40) != 0)) || ((DAT_00004032 & 0x20) != 0)) {
                in_D1w = 0x300;
              }
              else {
                in_D1w = 0x304;
              }
            }
            else {
              in_D1w = 0x303;
            }
          }
          else {
            in_D1w = 0x302;
          }
        }
        else {
          in_D1w = 0x301;
        }
      }
      if (((DAT_00001d26 != '\0') && (-1 < (char)DAT_000040e6)) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = 0x340;
      }
      if (((RAM_Sync_error != 0) && ((DAT_000040e4 & 1) == 0)) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        if ((DAT_00004036 & 8) == 0) {
          if ((DAT_00004036 & 0x40) == 0) {
            if ((DAT_00004036 & 0x10) == 0) {
              in_D1w = 0x136;
            }
            else {
              in_D1w = 0x140;
            }
          }
          else {
            in_D1w = 0x138;
          }
        }
        else {
          in_D1w = 0x141;
        }
      }
      if (((RAM_R_sond_error != 0) && ((DAT_000040e7 >> 5 & 1) == 0)) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        if ((DAT_00004042 & 0x80) == 0) {
          if ((DAT_00004042 & 0x40) == 0) {
            if ((DAT_00004042 & 8) == 0) {
              if ((DAT_00004042 & 0x10) == 0) {
                if ((DAT_00004042 & 0x20) == 0) {
                  in_D1w = 0x440;
                }
                else {
                  in_D1w = 0x455;
                }
              }
              else {
                in_D1w = 0x442;
              }
            }
            else {
              in_D1w = 0x451;
            }
          }
          else {
            in_D1w = 0x453;
          }
        }
        else {
          in_D1w = 0x452;
        }
      }
      if (((DAT_00003329 != '\0') && (-1 < (char)DAT_000040e4)) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = 0x420;
      }
      if (((DAT_00001d21 != '\0') && ((DAT_000040e5 >> 1 & 1) == 0)) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = 0x133;
      }
      if (((DAT_0000332a != '\0') && ((DAT_000040e5 >> 2 & 1) == 0)) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = 0x1549;
      }
      if (((DAT_0000332e != '\0') && ((DAT_000040e6 >> 1 & 1) == 0)) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = ((RAM_BrakeCnt._0_1_ >> 4 & 1) != 0) + 0x1576;
      }
      if (((DAT_0000332c != '\0') && ((DAT_000040e6 >> 6 & 1) == 0)) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = 0x1396;
      }
      if (((DAT_0000332d != '\0') && ((DAT_000040e6 >> 5 & 1) == 0)) &&
         (DAT_000034f4 = DAT_000034f4 + 1, param_1._2_2_ == DAT_000034f4)) {
        in_D1w = 0x1397;
      }
    }
  }
  else if (param_1._0_2_ == 7) {
    in_D1w = 0;
    if (param_1._2_2_ == 0x331a) {
      in_D1w = 0x1651;
    }
    if (param_1._2_2_ == 0x331d) {
      in_D1w = 0x1652;
    }
    if (param_1._2_2_ == 0x331e) {
      in_D1w = 0x605;
    }
    if (param_1._2_2_ == 0x331f) {
      if ((DAT_0000403a & 0x80) == 0) {
        if ((DAT_0000403a & 0x40) == 0) {
          in_D1w = 0x115;
        }
        else {
          in_D1w = 0x117;
        }
      }
      else {
        in_D1w = 0x118;
      }
    }
    if (param_1._2_2_ == 0x3320) {
      if ((DAT_0000404a & 0x80) == 0) {
        if ((DAT_0000404a & 0x40) == 0) {
          in_D1w = 0x110;
        }
        else {
          in_D1w = 0x112;
        }
      }
      else {
        in_D1w = 0x113;
      }
    }
    if (param_1._2_2_ == 0x3321) {
      if ((DAT_00004046 & 0x80) == 0) {
        if ((DAT_00004046 & 0x40) == 0) {
          in_D1w = ((DAT_00004046 & 0x20) != 0) + 0x105;
        }
        else {
          in_D1w = 0x107;
        }
      }
      else {
        in_D1w = 0x108;
      }
    }
    if (param_1._2_2_ == 0x3322) {
      if ((DAT_0000403c & 0x80) == 0) {
        if ((DAT_0000403c & 0x40) == 0) {
          in_D1w = ((DAT_0000403c & 0x20) != 0) + 0x120;
        }
        else {
          in_D1w = 0x122;
        }
      }
      else {
        in_D1w = 0x123;
      }
    }
    if (param_1._2_2_ == 0x3323) {
      if ((DAT_00004038 & 0x80) == 0) {
        if ((DAT_00004038 & 0x40) == 0) {
          if ((DAT_00004038 & 0x10) == 0) {
            if ((DAT_00004038 & 8) == 0) {
              in_D1w = 0x130;
            }
            else {
              in_D1w = 0x135;
            }
          }
          else {
            in_D1w = 0x134;
          }
        }
        else {
          in_D1w = 0x132;
        }
      }
      else {
        in_D1w = 0x131;
      }
    }
    if (param_1._2_2_ == 0x3324) {
      if ((DAT_00004034 & 0x80) == 0) {
        if ((DAT_00004034 & 0x40) == 0) {
          in_D1w = 0x1170;
        }
        else {
          in_D1w = 0x1172;
        }
      }
      else {
        in_D1w = 0x1171;
      }
    }
    if (param_1._2_2_ == 0x332b) {
      in_D1w = 0x1611;
    }
    if (param_1._2_2_ == 0x3325) {
      if (((DAT_0000403e & 0x80) == 0) && ((DAT_0000403e & 0x20) == 0)) {
        if ((DAT_0000403e & 0x40) == 0) {
          in_D1w = 0x500;
        }
        else {
          in_D1w = 0x502;
        }
      }
      else {
        in_D1w = 0x501;
      }
    }
    if (param_1._2_2_ == 0x3326) {
      if ((DAT_00004030 & 0x80) == 0) {
        in_D1w = ((DAT_00004030 & 0x40) != 0) + 0x505;
      }
      else {
        in_D1w = 0x507;
      }
    }
    if (param_1._2_2_ == 0x3327) {
      if ((DAT_00004044 & 0x80) == 0) {
        if ((DAT_00004044 & 0x40) == 0) {
          if ((DAT_00004044 & 0x10) == 0) {
            in_D1w = 0x443;
          }
          else {
            in_D1w = 0x441;
          }
        }
        else {
          in_D1w = 0x445;
        }
      }
      else {
        in_D1w = 0x444;
      }
    }
    if (param_1._2_2_ == 0x3328) {
      if ((DAT_00004040 & 0x80) == 0) {
        if ((DAT_00004040 & 0x40) == 0) {
          in_D1w = 0x410;
        }
        else {
          in_D1w = 0x414;
        }
      }
      else {
        in_D1w = 0x413;
      }
    }
    if (param_1._2_2_ == 0x1d20) {
      in_D1w = 0x327;
    }
    if (param_1._2_2_ == 0x332f) {
      if ((DAT_00004048 & 0x80) == 0) {
        in_D1w = ((DAT_00004048 & 0x40) != 0) + 0x170;
      }
      else {
        in_D1w = 0x172;
      }
    }
    if (param_1._2_2_ == 0x1d24) {
      in_D1w = 0x1322;
    }
    if (param_1._2_2_ == 0x1d25) {
      in_D1w = 0x1500;
    }
    if (param_1._2_2_ == 0x1d29) {
      in_D1w = 0x335;
    }
    if ((param_1._2_2_ == 0x1d22) || (param_1._2_2_ == 0x1d23)) {
      if ((DAT_00004032 & 0x80) == 0) {
        if ((DAT_00004032 & 0x40) == 0) {
          if ((DAT_00004032 & 0x20) == 0) {
            if ((DAT_00004032 & 0x10) == 0) {
              in_D1w = 0x300;
            }
            else {
              in_D1w = 0x304;
            }
          }
          else {
            in_D1w = 0x303;
          }
        }
        else {
          in_D1w = 0x302;
        }
      }
      else {
        in_D1w = 0x301;
      }
    }
    if (param_1._2_2_ == 0x1d26) {
      in_D1w = 0x340;
    }
    if (param_1._2_2_ == 0x1d27) {
      if ((DAT_00004036 & 8) == 0) {
        if ((DAT_00004036 & 0x40) == 0) {
          if ((DAT_00004036 & 0x10) == 0) {
            in_D1w = 0x136;
          }
          else {
            in_D1w = 0x140;
          }
        }
        else {
          in_D1w = 0x138;
        }
      }
      else {
        in_D1w = 0x141;
      }
    }
    if (param_1._2_2_ == 0x1d28) {
      if ((DAT_00004042 & 0x80) == 0) {
        if ((DAT_00004042 & 0x40) == 0) {
          if ((DAT_00004042 & 8) == 0) {
            if ((DAT_00004042 & 0x10) == 0) {
              if ((DAT_00004042 & 0x20) == 0) {
                in_D1w = 0x440;
              }
              else {
                in_D1w = 0x455;
              }
            }
            else {
              in_D1w = 0x442;
            }
          }
          else {
            in_D1w = 0x451;
          }
        }
        else {
          in_D1w = 0x453;
        }
      }
      else {
        in_D1w = 0x452;
      }
    }
    if (param_1._2_2_ == 0x3329) {
      in_D1w = 0x420;
    }
    if (param_1._2_2_ == 0x1d21) {
      in_D1w = 0x133;
    }
    if (param_1._2_2_ == 0x332a) {
      in_D1w = 0x1549;
    }
    if (param_1._2_2_ == 0x332e) {
      in_D1w = ((RAM_BrakeCnt._0_1_ >> 4 & 1) != 0) + 0x1576;
    }
    if (param_1._2_2_ == 0x332c) {
      in_D1w = 0x1396;
    }
    if (param_1._2_2_ == 0x332d) {
      in_D1w = 0x1397;
    }
  }
  return in_D1w;
}

```
