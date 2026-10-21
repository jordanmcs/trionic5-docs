# Function_0006EF58

**ROM:** `0x0006EF58`

```c

void Function_0006EF58(void)

{
  ushort uVar1;
  byte *extraout_A1;
  byte *extraout_A1_00;
  
  if ((DAT_0000103c & 8) == 0) {
    if ((DAT_0000103c & 1) == 0) {
      uVar1 = Function_0006A4E4(RAM_Retard_detekt_,RAM_Del_mat_);
      DAT_00003484 = (uVar1 & 0xff) << 4;
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_00 * 4) =
           (uint)DAT_00003484 * (uint)RAM_Last_cyl_komp_ >> 7;
      DAT_0000105c = *(undefined4 *)(&DAT_00004748 + (short)(ushort)*extraout_A1_00 * 4);
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1_00 * 4) =
           *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1_00 * 4) * (uint)DAT_00004e06 >> 7;
      RAM_Extern_tid = *(byte (*) [4])(&DAT_00004748 + (short)(ushort)*extraout_A1_00 * 4);
      DAT_0000103c = DAT_0000103c | 8;
      RAM_Restart_status = Function_0006A4E4(RAM_Retard_detekt_,0x4df4);
    }
    else {
      uVar1 = Function_0006A4E4(RAM_Retard_detekt_,RAM_Del_mat_);
      DAT_00003484 = (uVar1 & 0xff) << 4;
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4) =
           (uint)DAT_00003484 * (uint)RAM_Last_cyl_komp_ >> 7;
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4) =
           (*(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4) * (uint)RAM_Nom_last) / 100;
      DAT_0000105c = *(undefined4 *)(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4);
      *(uint *)(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4) =
           *(int *)(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4) * (uint)DAT_00004e06 >> 7;
      RAM_Extern_tid = *(byte (*) [4])(&DAT_00004748 + (short)(ushort)*extraout_A1 * 4);
      DAT_0000103c = DAT_0000103c & 0xfe | 8;
      RAM_Restart_status = 0;
      RAM_Start_dead = 0;
    }
  }
  if (((DAT_00004e04 < DAT_00001015) && ((RAM_Samp_pek[5] & 0x20) == 0)) ||
     (RAM_Start_dead < RAM_Restart_status)) {
    DAT_0000103a = DAT_0000103a | 0xf0;
  }
  else {
    DAT_0000103a = DAT_0000103a & 0xf;
  }
  *(byte (*) [4])(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) = RAM_Extern_tid;
  RAM_Start_dead = RAM_Start_dead + 1;
  if ((RAM_Start_dead < RAM_Start_max_) && (DAT_00004e42 <= RAM_Start_dead)) {
    if (RAM_Start_dead == DAT_00004e42) {
      uVar1 = (ushort)DAT_0000101d;
      *(undefined4 *)(&DAT_00004748 + (short)uVar1 * 4) = DAT_0000105c;
      RAM_Extern_tid = *(byte (*) [4])(&DAT_00004748 + (short)uVar1 * 4);
    }
    else {
      uVar1 = Function_0006A4E4(RAM_Retard_detekt_,RAM_Purge_min_value_);
      DAT_00003484 = uVar1 & 0xff;
      *(uint *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) =
           *(int *)(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4) * (uint)DAT_00003484 >> 7;
      RAM_Extern_tid = *(byte (*) [4])(&DAT_00004748 + (short)(ushort)DAT_0000101d * 4);
    }
  }
  return;
}

```
