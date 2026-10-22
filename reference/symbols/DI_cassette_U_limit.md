
# DI_cassette_U_limit

Calibration byte (RAM copy)  ·  per init map

**Value in factory 4780656:** (voltage threshold)

**Function:** Battery-voltage floor for ion-path fault judgement: the no-signal watchdog abstains while system voltage is below it, since cassette output amplitude scales with supply.

**Code path:** Read by fault state machine F_0005C34A.

Part of [T5 Knock Detection and Adaptation](../../guide/knock-detection-and-adaptation.md) · index: [T5 Symbols](../symbol-index.md)
