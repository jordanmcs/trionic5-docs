


# Fuel_knock_mat

Calibration map, 192 B (rpm × MAP)  ·  ROM 0x409F4



**Value in factory 4780656:** ×1/128 multiplier grid (16 rpm rows × 12 MAP columns 64–224 kPa); factory peak 206 ≈ 1.61× fuel at high rpm/high load.



**Function:** Fuel enrichment applied while knock control is active (Pgm_status "Knock fuel map activated"). Non-monotone blobs in the factory curve. (Tune diff: MCS differs — see T5 MCS Tune Changes.)



**Code path:** Consumed by the load/fuel path when knock enrichment status set.



Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)

