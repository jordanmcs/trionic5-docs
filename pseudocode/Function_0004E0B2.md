# Function_0004E0B2

**ROM:** `0x0004E0B2`

```c

void Function_0004E0B2(void)

{
  bool bVar1;
  int iVar2;
  short sVar3;
  bool bVar4;
  bool bVar5;
  byte bVar6;
  byte bVar7;
  byte bVar8;
  char cVar9;
  byte abVar10 [4];
  byte abVar11 [4];
  char cVar12;
  byte bVar13;
  byte bVar14;
  byte bVar15;
  bool bVar16;
  bool bVar17;
  bool bVar18;
  
  bVar1 = DAT_000037b0 + 1000 <= DAT_00003b02;
  if (bVar1) {
    DAT_000037b0 = DAT_00003b02;
    if ((((DAT_0000101c == 0) || ((DAT_0000103a & 0x80) != 0)) ||
        (RAM_Cat_vs_timer != (byte  [4])0x0)) || (RAM_Cat_delta_load < RAM_Cat_monitor_restart_)) {
      if (DAT_0000101c == 0) {
        abVar10[0] = 0;
        abVar10[1] = 0;
        abVar10._2_2_ = DAT_000074a8;
        if ((uint)RAM_Cat_hl_timer < (uint)abVar10) {
          RAM_Cat_hl_timer = (byte  [4])((int)RAM_Cat_hl_timer + 1);
        }
        else {
          DAT_00003ee8 = 0;
        }
      }
      if ((DAT_0000103a & 0x80) == 0) {
        if (RAM_Cat_vs_timer != (byte  [4])0x0) {
          RAM_Cat_vs_timer = (byte  [4])((int)RAM_Cat_vs_timer + -1);
        }
      }
      else {
        abVar11[0] = 0;
        abVar11[1] = 0;
        abVar11._2_2_ = DAT_000074aa;
        if ((uint)RAM_Cat_vs_timer < (uint)abVar11) {
          RAM_Cat_vs_timer = (byte  [4])((int)RAM_Cat_vs_timer + 1);
        }
        else {
          DAT_00003ee8 = 0;
        }
      }
    }
    else {
      if (DAT_00003ee8 < DAT_000074a4) {
        DAT_00003ee8 = DAT_00003ee8 + 1;
      }
      RAM_Cat_hl_timer[0] = 0;
      RAM_Cat_hl_timer[1] = 0;
      RAM_Cat_hl_timer[2] = 0;
      RAM_Cat_hl_timer[3] = 0;
      RAM_Cat_vs_timer[0] = 0;
      RAM_Cat_vs_timer[1] = 0;
      RAM_Cat_vs_timer[2] = 0;
      RAM_Cat_vs_timer[3] = 0;
    }
  }
  if (((bVar1) && (DAT_000037bc < RAM_Cat_start_timer_lim_)) && (DAT_000074b0 < RAM_Cat_delta_load))
  {
    DAT_000037bc = DAT_000037bc + 1;
  }
  iVar2 = (int)DAT_000037de + (uint)DAT_000072a6 * ((uint)DAT_00001032 - (uint)RAM_Cat_status);
  DAT_000037de = (short)(iVar2 % 1000);
  RAM_Cat_status = (char)(iVar2 / 1000) + RAM_Cat_status;
  sVar3 = (ushort)DAT_00001032 - (ushort)RAM_Cat_status;
  DAT_00003f06 = (byte)sVar3;
  if (sVar3 < 0) {
    DAT_00003f06 = -DAT_00003f06;
  }
  bVar6 = (DAT_000072a8 < DAT_0000102e) << 6;
  RAM_Cat_delta_load = (DAT_00003c32 / 100) * (ushort)DAT_00001032;
  if ((RAM_Cat_air_flow_hi_ < RAM_Cat_delta_load) && (RAM_Cat_delta_load < RAM_Cat_vehi_speed_lo_))
  {
    cVar12 = '\x01';
    bVar5 = true;
  }
  else {
    cVar12 = '\0';
    bVar5 = false;
  }
  bVar13 = cVar12 << 3;
  if ((RAM_Cat_vehi_speed_hi_ < DAT_0000101c) && (DAT_0000101c < RAM_Cat_cool_temp_lim_)) {
    cVar12 = '\x01';
  }
  else {
    cVar12 = '\0';
  }
  bVar14 = cVar12 << 5;
  bVar16 = (DAT_0000103c & 2) != 0;
  bVar7 = bVar16 << 4;
  bVar17 = DAT_00003f06 < RAM_Derivata_fuel_rpm_;
  bVar8 = bVar17 << 7;
  if ((DAT_000037bc < RAM_Cat_start_timer_lim_) || (DAT_00003ee8 < DAT_000074a4)) {
    cVar9 = '\0';
  }
  else {
    cVar9 = '\x01';
  }
  if (((((char)RAM_OBD2_frame[0x18] < '\0') || ((char)RAM_OBD2_frame[0x1e] < '\0')) ||
      ((char)RAM_OBD2_frame[0xc] < '\0')) ||
     ((((char)RAM_OBD2_frame[0x12] < '\0' || ((char)RAM_OBD2_frame[6] < '\0')) ||
      ((char)RAM_OBD2_frame[0] < '\0')))) {
    bVar15 = 0;
    bVar4 = false;
  }
  else {
    bVar15 = 1;
    bVar4 = true;
  }
  RAM_n_Engine_delta_180[1] =
       bVar15 | cVar9 << 2 | bVar1 * '\x02' | RAM_n_Engine_delta_180[1] & 0xf8;
  bVar18 = (DAT_0000103a & 4) == 0;
  RAM_n_Engine_delta_180[2] = bVar18 << 7 | RAM_n_Engine_delta_180[2] & 0x7f;
  if (((DAT_000072a8 < DAT_0000102e) && (bVar5)) &&
     ((((cVar12 != '\0' && (((bVar16 && (bVar17)) && (cVar9 != '\0')))) && ((bVar4 && (bVar18)))) &&
      ((int)RAM_Diag_tid + 200U < DAT_00001a58)))) {
    if (RAM_Cat_air_flow < RAM_Cat_air_flow_lo_) {
      RAM_n_Engine_delta_180[0] =
           bVar8 | bVar7 | bVar14 | bVar13 | bVar6 | RAM_n_Engine_delta_180[0] & 3;
      if (bVar1) {
        RAM_Cat_air_flow = RAM_Cat_air_flow + 1;
      }
    }
    else {
      RAM_n_Engine_delta_180[0] =
           bVar8 | bVar7 | bVar14 | bVar13 | bVar6 | RAM_n_Engine_delta_180[0] & 7 | 4;
    }
  }
  else if (((bVar16) && (bVar17)) ||
          (RAM_Cat_air_flow <=
           (ushort)((ushort)RAM_Cat_air_flow_lo_ - (ushort)RAM_Cat_ready_timer_lim_))) {
    RAM_n_Engine_delta_180[0] =
         bVar8 | bVar7 | bVar14 | bVar13 | bVar6 | RAM_n_Engine_delta_180[0] & 3;
    if ((RAM_Cat_air_flow != 0) && (bVar1)) {
      RAM_Cat_air_flow = RAM_Cat_air_flow - 1;
    }
  }
  else {
    RAM_n_Engine_delta_180[0] =
         bVar8 | bVar7 | bVar14 | bVar13 | bVar6 | RAM_n_Engine_delta_180[0] & 3;
    RAM_Cat_air_flow = (ushort)RAM_Cat_air_flow_lo_ - (ushort)RAM_Cat_ready_timer_lim_;
  }
  return;
}

```
