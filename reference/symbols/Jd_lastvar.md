
# Jd_lastvar

State word (RAM) · 0x74BC (Jd_lastvar!)

**Value in factory 4780656:** runtime — units: combustion counts

**Function:** Combustion-counter snapshot taken at the last fuel-cut end; after injector cut-out resumes, misfire counting stays inhibited until Ign_counter_mis passes this value.

**Code path:** Consumed by the fuel-cut resume gate (see misfire enable gates 0x64AE8–0x64B38)

Part of [T5 Misfire Detection](../../guide/misfire-detection.md) · index: [T5 Symbols](../symbol-index.md)
