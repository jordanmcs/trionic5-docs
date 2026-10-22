
# Idle_rpm_tab

Calibration table, 8 words (coolant-temp-indexed)  ·  ROM 0x4111A

**Value in factory 4780656:**

| Coolant at least ([I_kyl_st](I_kyl_st.md)) | Raw | Target rpm |
|---|---|---|
| 65 °C | 90 | 900 |
| 50 °C | 95 | 950 |
| 35 °C | 100 | 1000 |
| 20 °C | 110 | 1100 |
| 5 °C | 110 | 1100 |
| -5 °C | 110 | 1100 |
| -20 °C | 110 | 1100 |
| -40 °C | 110 | 1100 |

Values are words in 10-rpm units; interpolated on [Kyl_temp](Kyl_temp.md) (°C) against the [I_kyl_st](I_kyl_st.md) axis.

**Function:** Warm-up idle speed target: 1100 rpm cold down to 900 rpm above 65 °C. Result feeds [Rpm_idle_nom](Rpm_idle_nom.md).

**Code path:** Word interpolation Function_0006A314 at 0x6F63E–0x6F650.

Part of [T5 Warmup Cycle and Temperature Inputs](../../guide/warmup-cycle-and-temperature-inputs.md) · index: [T5 Symbols](../symbol-index.md)
