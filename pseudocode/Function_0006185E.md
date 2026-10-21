# Function_0006185E

**ROM:** `0x0006185E`

```c

/* WARNING: Removing unreachable block (ram,0x00061d70) */

void Function_0006185E(void)

{
  byte *pbVar1;
  short sVar2;
  ushort uVar3;
  byte bVar4;
  ushort uVar5;
  byte *pbVar6;
  short *extraout_A1;
  undefined1 *puVar7;
  byte *local_8;
  
  RAM_Multispark =
       Function_00061F30(DAT_000039cc,RAM_Ign_map_8_,RAM_Detect_map_x_axis_,DAT_00004668,
                         RAM_Detect_map_y_axis_);
  RAM_Detect_limit =
       Function_00061F30(DAT_000039c8,&DAT_000069e2,&DAT_00006a06,DAT_00004664,&DAT_00006e22);
  RAM_Mis200_limit =
       Function_00061F30(DAT_000039c8,&DAT_000069e2,&DAT_00006a06,DAT_00004664,&DAT_00007062);
  uVar3 = (ushort)DAT_00001013;
  if ((short)RAM_Ign_map_8_._34_2_ < (short)(ushort)DAT_00001013) {
    uVar3 = RAM_Ign_map_8_._34_2_;
  }
  uVar5 = DAT_00003c32;
  if ((short)RAM_Detect_map_x_axis_._30_2_ < (short)DAT_00003c32) {
    uVar5 = RAM_Detect_map_x_axis_._30_2_;
  }
  DAT_0000390a = 0;
  pbVar6 = RAM_Ign_map_8_;
  while( true ) {
    sVar2 = *(short *)(pbVar6 + 2) + *(short *)pbVar6;
    if (sVar2 < 0) {
      sVar2 = sVar2 + 1;
    }
    if (((short)uVar3 <= sVar2 >> 1) || (0x10 < DAT_0000390a)) break;
    pbVar6 = pbVar6 + 2;
    DAT_0000390a = DAT_0000390a + 1;
  }
  DAT_00003908 = 0;
  pbVar6 = RAM_Detect_map_x_axis_;
  while( true ) {
    sVar2 = *(short *)(pbVar6 + 2) + *(short *)pbVar6;
    if (sVar2 < 0) {
      sVar2 = sVar2 + 1;
    }
    if (((short)uVar5 <= sVar2 >> 1) || (0xe < DAT_00003908)) break;
    pbVar6 = pbVar6 + 2;
    DAT_00003908 = DAT_00003908 + 1;
  }
  for (DAT_000034f2 = 0; ((&DAT_000051ee)[DAT_000034f2] < DAT_00003b72 && (DAT_000034f2 != 0xf));
      DAT_000034f2 = DAT_000034f2 + 1) {
  }
  if (DAT_000051ee < DAT_00003b72) {
    if (DAT_00003b72 < DAT_0000520c) {
      DAT_000034ec = (&DAT_000051ee)[DAT_000034f2] - (&DAT_000051ee)[(short)(DAT_000034f2 + -1)];
      DAT_000034e8 = DAT_00003b72 - (&DAT_000051ee)[(short)(DAT_000034f2 + -1)];
    }
    else {
      DAT_000034e8 = 1;
      DAT_000034ec = 1;
    }
  }
  else {
    DAT_000034e8 = 0;
    DAT_000034f2 = 1;
    DAT_000034ec = 1;
  }
  DAT_000010b6 = (&DAT_0000632e)[(short)(DAT_000034f2 + -1)] +
                 (short)(((&DAT_0000632e)[DAT_000034f2] -
                         (&DAT_0000632e)[(short)(DAT_000034f2 + -1)]) * DAT_000034e8) / DAT_000034ec
  ;
  DAT_000010c6 = *(short *)(RAM_Knock_lim_tab_ + (short)(DAT_000034f2 + -1) * 2) +
                 (short)((*(short *)(RAM_Knock_lim_tab_ + DAT_000034f2 * 2) -
                         *(short *)(RAM_Knock_lim_tab_ + (short)(DAT_000034f2 + -1) * 2)) *
                        DAT_000034e8) / DAT_000034ec;
  DAT_000010fa = *(short *)(RAM_Knock_press_tab_ + (short)(DAT_000034f2 + -1) * 2) +
                 (short)((*(short *)(RAM_Knock_press_tab_ + DAT_000034f2 * 2) -
                         *(short *)(RAM_Knock_press_tab_ + (short)(DAT_000034f2 + -1) * 2)) *
                        DAT_000034e8) / DAT_000034ec;
  DAT_000010fc = *(short *)(RAM_Turbo_knock_tab_ + (short)(DAT_000034f2 + -1) * 2) +
                 (short)((*(short *)(RAM_Turbo_knock_tab_ + DAT_000034f2 * 2) -
                         *(short *)(RAM_Turbo_knock_tab_ + (short)(DAT_000034f2 + -1) * 2)) *
                        DAT_000034e8) / DAT_000034ec;
  DAT_000010f8 = *(short *)(RAM_Lknock_oref_tab_ + (short)(DAT_000034f2 + -1) * 2) +
                 (short)((*(short *)(RAM_Lknock_oref_tab_ + DAT_000034f2 * 2) -
                         *(short *)(RAM_Lknock_oref_tab_ + (short)(DAT_000034f2 + -1) * 2)) *
                        DAT_000034e8) / DAT_000034ec;
  DAT_000010f4 = Function_00061F30(DAT_000039ec,&DAT_000051ca,&DAT_000051ee,DAT_00004688,
                                   RAM_Knock_matrix_time_);
  DAT_000010f6 = *(short *)(&DAT_00006674 + (short)(*extraout_A1 + -1) * 2) +
                 (short)((*(short *)(&DAT_00006674 + *extraout_A1 * 2) -
                         *(short *)(&DAT_00006674 + (short)(*extraout_A1 + -1) * 2)) * DAT_000034e8)
                 / DAT_000034ec;
  DAT_00003920 = DAT_00003920 + 1;
  if (5 < DAT_00003920) {
    if ((DAT_00003b72 < 0x1195) &&
       ((short)RAM_Ign_map_7_ <= (short)(DAT_00003b72 - RAM_Weight._18_2_))) {
      DAT_000039bd = 0x44;
    }
    else {
      DAT_000039bd = 0x55;
    }
    DAT_00003920 = 0;
    RAM_Weight[0x12] = DAT_00003b72._0_1_;
    RAM_Weight[0x13] = (undefined1)DAT_00003b72;
  }
  if ((RAM_Ramp_steg_[3] & 2) != 0) {
    if ((DAT_00001039 & 8) == 0) {
      RAM_Weight[0] = RAM_Weight[0] & 0x3f;
      RAM_Weight[2] = 0;
      RAM_Weight[3] = 0;
    }
    else {
      sVar2 = Function_00044B86();
      if (sVar2 == 0x4e) {
        RAM_Weight[6] = 0x44;
      }
      else {
        RAM_Weight[6] = 0x4e;
      }
      if (RAM_Trot_delta < DAT_00001015) {
        RAM_Weight[0xc] = DAT_00001015 - RAM_Trot_delta;
      }
      else {
        RAM_Weight[0xc] = 0;
      }
      if ((ushort)(RAM_API_ku_ramp_ + DAT_00003c32) < (ushort)RAM_Weight._14_2_) {
        RAM_Weight[0xd] = 0x2d;
      }
      else if ((ushort)RAM_Weight._14_2_ < (ushort)(DAT_00003c32 - 10)) {
        RAM_Weight[0xd] = 0x2b;
      }
      else {
        RAM_Weight[0xd] = 0x30;
      }
      if ((RAM_Weight[0] >> 6 & 1) == 0) {
        if ((RAM_Weight[6] == 0x44) && (RAM_Weight[7] != 0x44)) {
          RAM_Weight[0] = RAM_Weight[0] | 0x80;
          bVar4 = 0;
          local_8 = &DAT_00005b1e;
          puVar7 = &DAT_00005b1e;
          while( true ) {
            sVar2 = (ushort)*local_8 + (ushort)(byte)puVar7[1];
            if (SCARRY2((ushort)*local_8,(ushort)(byte)puVar7[1])) {
              sVar2 = sVar2 + 1;
            }
            puVar7 = puVar7 + 1;
            if (((ushort)RAM_Weight[0xc] <= (ushort)(sVar2 >> 1)) || (bVar4 == 4)) break;
            bVar4 = bVar4 + 1;
            local_8 = local_8 + 1;
          }
          RAM_Weight._2_2_ = *(undefined2 *)(&DAT_00005b24 + (short)(ushort)bVar4 * 2);
          RAM_Weight[8] = DAT_00003b02._0_1_;
          RAM_Weight[9] = DAT_00003b02._1_1_;
          RAM_Weight[10] = DAT_00003b02._2_1_;
          RAM_Weight[0xb] = (undefined1)DAT_00003b02;
          RAM_Weight._4_2_ = RAM_Weight._2_2_;
        }
        else if (((RAM_Weight[0] & 0x80) == 0) ||
                (RAM_Weight._8_4_ + (uint)RAM_API_dt_offset_tab_ <= DAT_00003b02)) {
          if (((RAM_Weight[0] & 0x80) != 0) &&
             (RAM_Weight._2_2_ =
                   RAM_Weight._4_2_ -
                   (short)(((int)(short)RAM_Weight._4_2_ *
                           (DAT_00003b02 - (RAM_Weight._8_4_ + (uint)RAM_API_dt_offset_tab_))) /
                          (uint)DAT_00005b30), (short)RAM_Weight._2_2_ < 1)) {
            RAM_Weight[2] = 0;
            RAM_Weight[3] = 0;
            RAM_Weight[0] = RAM_Weight[0] & 0x7f;
          }
        }
        else {
          bVar4 = 0;
          puVar7 = &DAT_00005b1e;
          pbVar6 = &DAT_00005b1e;
          while( true ) {
            pbVar1 = puVar7 + 1;
            puVar7 = puVar7 + 1;
            if (((ushort)RAM_Weight[0xc] <=
                 (ushort)((short)((ushort)*pbVar6 + (ushort)*pbVar1) >> 1)) || (bVar4 == 4)) break;
            bVar4 = bVar4 + 1;
            pbVar6 = pbVar6 + 1;
          }
          RAM_Weight._2_2_ = *(undefined2 *)(&DAT_00005b24 + (short)(ushort)bVar4 * 2);
          RAM_Weight._4_2_ = RAM_Weight._2_2_;
        }
      }
      if (-1 < (char)RAM_Weight[0]) {
        if ((((RAM_API_ku_derivata_ < DAT_00003c32) && (RAM_API_rpm_limit_ < RAM_Weight[0xc])) &&
            (RAM_Weight[0xd] == 0x2d)) &&
           ((RAM_Weight[0x10] != 0x2d && (RAM_Weight._8_4_ + 3000 < DAT_00003b02)))) {
          RAM_Weight[0] = RAM_Weight[0] | 0x40;
          RAM_Weight[4] = RAM_API_dt_ramp_._0_1_;
          RAM_Weight[5] = (undefined1)RAM_API_dt_ramp_;
          RAM_Weight[2] = RAM_API_dt_ramp_._0_1_;
          RAM_Weight[3] = (undefined1)RAM_API_dt_ramp_;
          RAM_Weight[8] = DAT_00003b02._0_1_;
          RAM_Weight[9] = DAT_00003b02._1_1_;
          RAM_Weight[10] = DAT_00003b02._2_1_;
          RAM_Weight[0xb] = (undefined1)DAT_00003b02;
        }
        else if ((((RAM_Weight[0] & 0x40) == 0) ||
                 (RAM_Weight._8_4_ + (uint)RAM_API_ku_offset_ <= DAT_00003b02)) &&
                (((RAM_Weight[0] & 0x40) != 0 &&
                 (RAM_Weight._2_2_ =
                       RAM_Weight._4_2_ -
                       (short)(((int)(short)RAM_Weight._4_2_ *
                               (DAT_00003b02 - (RAM_Weight._8_4_ + (uint)RAM_API_ku_offset_))) /
                              (uint)DAT_00005b36), (short)RAM_Weight._2_2_ < 1)))) {
          RAM_Weight[2] = 0;
          RAM_Weight[3] = 0;
          RAM_Weight[0] = RAM_Weight[0] & 0xbf;
        }
      }
      RAM_Weight[0xe] = DAT_00003c32._0_1_;
      RAM_Weight[0xf] = (undefined1)DAT_00003c32;
      RAM_Weight[7] = RAM_Weight[6];
      if ((RAM_Weight[0xd] == 0x2b) || (RAM_Weight[0xd] == 0x2d)) {
        RAM_Weight[0x10] = RAM_Weight[0xd];
      }
    }
  }
  return;
}

```
