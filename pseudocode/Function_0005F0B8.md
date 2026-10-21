# Function_0005F0B8

**ROM:** `0x0005F0B8`

```c

void Function_0005F0B8(byte *param_1)

{
  byte bVar1;
  undefined4 *extraout_A1;
  short *psVar2;
  
  RAM_Crankshaft_frame[0x79] = DAT_0000101c;
  RAM_Crankshaft_frame[0x7c] = DAT_000040a6;
  RAM_Crankshaft_frame[0x78] = RAM_Bil_hast;
  RAM_Crankshaft_frame[0x84] = DAT_0000102e;
  RAM_Crankshaft_frame[0x85] = RAM_Last;
  RAM_Crankshaft_frame[0x7b] = DAT_00001037;
  RAM_Crankshaft_frame[0x7d] = DAT_00001013;
  RAM_Crankshaft_frame._104_2_ = DAT_00001066 * 10;
  RAM_Crankshaft_frame[0x80] = DAT_00001136;
  RAM_Crankshaft_frame[0x86] = DAT_00001077;
  RAM_Crankshaft_frame._20_4_ = RAM_Crankshaft_error;
  RAM_Crankshaft_frame._80_2_ = DAT_000010fe;
  RAM_Crankshaft_frame._4_4_ = DAT_00001a58;
  RAM_Crankshaft_frame._106_2_ = DAT_00003464;
  RAM_Crankshaft_frame[0x7e] = DAT_00003335;
  RAM_Crankshaft_frame[0x7f] = DAT_00003336;
  RAM_Crankshaft_frame._0_4_ = RAM_Knock_time_low;
  RAM_Crankshaft_frame._12_4_ = RAM_Luft_tid_konst;
  RAM_Crankshaft_frame._16_4_ = RAM_I_front_time;
  RAM_Crankshaft_frame._8_4_ = DAT_00001a64;
  RAM_Crankshaft_frame._24_4_ = DAT_00001a9c;
  RAM_Crankshaft_frame._28_4_ = RAM_Luft_tid_end;
  RAM_Crankshaft_frame._32_4_ = DAT_00001a78;
  RAM_Crankshaft_frame._36_4_ = RAM_Battery_time;
  RAM_Crankshaft_frame._40_4_ = RAM_Sond_tid_end;
  RAM_Crankshaft_frame._44_4_ = RAM_Hast_tid_grans;
  RAM_Crankshaft_frame._48_4_ = DAT_00001a84;
  RAM_Crankshaft_frame._52_4_ = DAT_00001a80;
  RAM_Crankshaft_frame._56_4_ = DAT_00001a70;
  RAM_Crankshaft_frame._60_4_ = DAT_00001a74;
  RAM_Crankshaft_frame._64_4_ = DAT_00001a8c;
  RAM_Crankshaft_frame[0x76] = DAT_0000405e;
  RAM_Crankshaft_frame[0x8c] = DAT_00003fe8;
  RAM_Crankshaft_frame[0x87] = DAT_00001039;
  RAM_Crankshaft_frame[0x88] = DAT_0000103a;
  RAM_Crankshaft_frame[0x89] = DAT_0000103b;
  RAM_Crankshaft_frame[0x8a] = DAT_0000103c;
  RAM_Crankshaft_frame[0x8b] = DAT_0000103d;
  RAM_Crankshaft_frame[0x77] = RAM_Start_detekt_nr_;
  RAM_Crankshaft_frame[0x7a] = DAT_00001031;
  RAM_Crankshaft_frame._72_2_ = DAT_0000405a;
  RAM_Crankshaft_frame._74_2_ = DAT_0000405c;
  RAM_Crankshaft_frame._76_2_ = DAT_00003e2a;
  RAM_Crankshaft_frame._78_2_ = DAT_00003e2c;
  RAM_Crankshaft_frame._108_2_ = DAT_000010ae;
  RAM_Crankshaft_frame._68_4_ = RAM_Ign_counter3;
  RAM_Crankshaft_frame[0x82] = DAT_00001999;
  RAM_Crankshaft_frame[0x83] = DAT_00001998;
  RAM_Crankshaft_frame._112_2_ = RAM_Ox2_change;
  RAM_Crankshaft_frame._116_2_ = RAM_Cat_ox2_dev_samp;
  RAM_Crankshaft_frame._82_2_ = DAT_00001156;
  RAM_Crankshaft_frame[0x81] = RAM_Trot_delta;
  RAM_Crankshaft_frame._142_2_ = DAT_000037a6;
  RAM_Crankshaft_frame._144_2_ = DAT_000037a4;
  RAM_Crankshaft_frame._84_2_ = RAM_Mis200_4;
  RAM_Crankshaft_frame._86_2_ = DAT_000010d0;
  RAM_Crankshaft_frame._88_2_ = RAM_Mis200_1;
  RAM_Crankshaft_frame._90_2_ = RAM_Mis200_2;
  RAM_Crankshaft_frame._92_2_ = RAM_Mis200_3;
  RAM_Crankshaft_frame._94_2_ = DAT_000010e4;
  RAM_Crankshaft_frame._96_2_ = RAM_C200_max;
  RAM_Crankshaft_frame._98_2_ = DAT_000010de;
  RAM_Crankshaft_frame._100_2_ = DAT_000010e0;
  RAM_Crankshaft_frame._102_2_ = DAT_000010e2;
  RAM_Crankshaft_frame[0x92] = DAT_0000334f;
  RAM_Crankshaft_frame._110_2_ = DAT_00003476;
  RAM_Crankshaft_frame._114_2_ = Function_000662CA((short)param_1);
  if (((DAT_00006e20 & 0x80) != 0) &&
     (((param_1 != DAT_00004068 &&
       (((((DAT_00004068 != &DAT_00001d22 && (DAT_00004068 != &DAT_00001d23)) &&
          (DAT_00004068 != &DAT_0000332f)) && (DAT_00004068 != &RAM_Sond_error)) ||
        (0x27 < DAT_000040c0)))) ||
      ((((param_1 == &DAT_00001d22 || (param_1 == &DAT_00001d23)) ||
        ((param_1 == &DAT_0000332f || (param_1 == &RAM_Sond_error)))) &&
       ((((DAT_00004068 != &DAT_00001d22 && (DAT_00004068 != &DAT_00001d23)) &&
         (DAT_00004068 != &DAT_0000332f)) && (DAT_00004068 != &RAM_Sond_error)))))))) {
    RAM_Cat_fc_timer[0] = 0x7e;
    RAM_Cat_fc_timer[1] = 0x38;
    RAM_Cat_fc_timer[2] = 0;
    RAM_Cat_fc_timer[3] = 0;
    RAM_Cat_fc_timer._4_2_ = Function_000662CA((short)param_1);
    RAM_Cat_fc_timer[6] = DAT_00001076;
    RAM_Cat_fc_timer[7] = 0;
    if ((RAM_Ramp_steg_[4] & 0x10) == 0) {
      psVar2 = &DAT_00005b6e;
      for (bVar1 = 0;
          ((ushort)((&DAT_00005b6e)[(short)(bVar1 + 1)] + *psVar2) >> 1 < DAT_00001066 &&
          (bVar1 != 0xf)); bVar1 = bVar1 + 1) {
        psVar2 = psVar2 + 1;
      }
      if ((RAM_Ramp_steg_[3] & 2) == 0) {
        bVar1 = (&DAT_00005bc6)[(short)((ushort)bVar1 * 8 + 7)];
      }
      else {
        bVar1 = RAM_Tryck_mat_[(short)((ushort)bVar1 * 8 + 7)];
      }
    }
    else {
      bVar1 = 100;
    }
    if (DAT_00001013 < bVar1) {
      RAM_Cat_fc_timer[8] = (byte)(((uint)DAT_00001013 << 8) / (uint)bVar1);
    }
    else {
      RAM_Cat_fc_timer[8] = 0xff;
    }
    if ((char)DAT_0000102e < -0x28) {
      RAM_Cat_fc_timer[9] = 0;
    }
    else {
      RAM_Cat_fc_timer[9] = DAT_00004736 + 0x28;
    }
    RAM_Cat_fc_timer[10] = (char)((short)(ushort)DAT_00001031 >> 2) + 0x60;
    RAM_Cat_fc_timer[0xb] = RAM_Start_detekt_nr_;
    RAM_Cat_fc_timer[0xc] = (byte)(DAT_00003e24 / 10);
    RAM_Cat_fc_timer._14_2_ = DAT_00003b72 << 2;
    RAM_Cat_fc_timer[0x10] = DAT_0000101c;
    *extraout_A1 = param_1;
    DAT_000040c0 = 0;
  }
  return;
}

```
