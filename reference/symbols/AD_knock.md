
# AD_knock

State byte (RAM) · 0x1010

**Value in factory 4780656:** runtime — units: 8-bit AD count

**Function:** Cassette knock-level ADC byte: the TPU knock-counter output read at 0x3B52 and copied by the ad_knock task through the test-output mux, so the analog knock peak is also observable on the dashboard test output (dyno use).

**Code path:** F_00069C30 (ad_knock copy); source counter strobe-gated by the TPU PWM window

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
