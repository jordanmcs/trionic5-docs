---

tags: [saab, trionic5, knock, ion-sensing, ignition, reverse-engineering, reference]

firmware: "factory 4780656"

created: 2026-10-20

---



# T5 Knock Detection and Adaptation



How Trionic **5** detects knock — reverse-engineered from factory 4780656 (REA/Ghidra m68k; cross-checked against a commercial reflash), full evidence tree in the research workspace). Sister section: T7 Knock Detection and Ignition Safety (same ion principle, completely different hardware engine).



> **The single most important idea:** like T7, T5 has **no knock sensor** — the spark plug gap is a current probe: after combustion, ionized gas conducts current across the gap (measured at the coil's low-voltage side). Knock is a pressure oscillation of the chamber gases, superimposed on that ion current and extracted by a ~7 kHz band-pass in the **DI cassette**, amplitude = severity, one shared ECU pin 44, cylinder attribution by ignition timing). Unlike T7, the window engine is a TPU hardware pulse counter, and knock's global response is **boost derate**, not just ignition.



**Interactive companion:** [Trionic 5 knock explorer](../interactive/knock-explorer.html) — six working simulators (pulse judge, retard loops, APC toggle, watchdog, K-adapt learner, temp gates). Open in browser from the vault.



## Signal chain



```

plug gap ion current → DI cassette (80 V bias, ~7 kHz BP, amp = severity)

→ ECU pin 44 (shared by all 4 cyls; attribution by timing)

→ TPU PWM hardware window, 30–45° to 60–75° after spark (regs 0xFFFF28/2A, counter @0xFFFA00)

→ per-window pulse count (0…~90) + ad_knock ADC + Knock_diag_level (raw witness @SRAM 0x1100)

```



- No piezo KS, no cam sensor: ion also gives crank-phase sync + misfire (pins 17/18).

- [Knock_diag_level](../reference/symbols/Knock_diag_level.md) written every window: >50 pulses = line alive; ≤50 for 10 s with healthy battery ([DI_cassette_U_limit](../reference/symbols/DI_cassette_U_limit.md) — ion amplitude sags with voltage) and rpm ≥ 800 → latched **0x28/0x2C** + [Knock_frame](../reference/symbols/Knock_frame.md); 1500 clean ignitions to clear (`F_0005C34A`).

- Evaluation skipped during multi-spit (spark ringing pollutes the ion band).



## Per-window decision (`F_00060BFE`)



count vs [Knock_ref_matrix](../reference/symbols/Knock_ref_matrix.md)[rpm,load] (floor 19, ridge 87, incl. Saab's diagonal visibility mask, [Detect_map](../reference/symbols/Detect_map.md) zeroes low load) × [Lknock_oref_tab](../reference/symbols/Lknock_oref_tab.md) (120–200 %), capped by the K-adapt ratio ceiling. Gates: MAP > [Knock_press_limit](../reference/symbols/Knock_press_limit.md) (70→60 kPa abs by rpm — raw MAP counts ≈ kPa on the 2.5-bar sensor), coolant > 40 °C. Verdict [Spik_count](../reference/symbols/Spik_count.md) 1/2 per cylinder into a 5-slot ring.



## Two protection loops



| loop | action | recovery |

|---|---|---|

| per-cyl ignition | +1.5°/event ([Knock_reduce](../reference/symbols/Knock_reduce.md)=15), cap [Knock_lim_tab](../reference/symbols/Knock_lim_tab.md)[rpm] = 3→**13°**@2500→9°@6000 (stock) | −0.2°/period ([Knock_back](../reference/symbols/Knock_back.md)=2), out as [Ret_mangd](../reference/symbols/Ret_mangd.md) |

| global APC boost | [Apc_decrese](../reference/symbols/Apc_decrese.md) +8 %/event; `APC_knock = (100−[Apc_decrese](../reference/symbols/Apc_decrese.md))/100` on boost PID ([Regl_tryck](../reference/symbols/Regl_tryck.md) @0x72782) | factory +5 %/period ([Apc_knock_back](../reference/symbols/Apc_knock_back.md)) |



Sustained severe knock → basic charge pressure (ISAT cause "KNOCK CONTROL" = bad fuel or dying cassette). Fuel enriches via [Fuel_knock_mat](../reference/symbols/Fuel_knock_mat.md) (factory peak ≈1.61×).



## Knock adaptation (K-adapt) — self-calibrating the baseline



[Kadapt_ref_value_actual](../reference/symbols/Kadapt_ref_value_actual.md) (init **34** @0x4EC0A) scales the ratio denominator ([Knock_ref_level](../reference/symbols/Knock_ref_level.md) @0x4622) — the ECU learns each engine's baseline ion activity (combustion varies cycle-to-cycle even when healthy).



**Sampling (`F_000610D2`) — every gate must hold:** 2100–3250 rpm · load 85–105 · coolant **> 60 °C** · [Ret_mangd](../reference/symbols/Ret_mangd.md)=0 · no misfires/accel (never learn while correcting). 100 samples = one run, abandoned after [Kadapt_period](../reference/symbols/Kadapt_period.md)=320 ticks if the window lapses. **Application (`F_000611E6`):** creep toward the learned target — |Δ|≤2 hold, ≤10 ±1, ≤20 ±2, >20 ±10. Repeated clean drives walk sensitivity to the true floor.



**Ratio ceiling [Kadapt_max_ref](../reference/symbols/Kadapt_max_ref.md)** (ROM 0x42856): `[315,315,315,270,250,229,218,200,183,166,166]`/100 by rpm — detection may never demand more than 3.15× the reference at low rpm, 1.66× at high rpm. Escalation: [Knock_average](../reference/symbols/Knock_average.md) vs [Knock_average_tab](../reference/symbols/Knock_average_tab.md) `[80×7,70,60,50]` by rpm.



## Temperature handling — gates for knock, tables for fuel (naming trap)



Knock uses **hard gates only**: detection dead ≤ 40 °C (0x60EB2, bypass if coolant sensor itself failed), learning dead ≤ 60 °C (0x61134), MAP gate [Knock_press_limit](../reference/symbols/Knock_press_limit.md), cassette fault gated by battery voltage. The tables actually named [Tempkomp_konst](../reference/symbols/Tempkomp_konst.md), [Eftersta_fak](../reference/symbols/Eftersta_fak.md) / [Eftersta_fak2](../reference/symbols/Eftersta_fak2.md), [Eft_dec_fak](../reference/symbols/Eft_dec_fak.md) / [Eft_dec_fak2](../reference/symbols/Eft_dec_fak2.md), [Retard_temp](../reference/symbols/Retard_temp.md) are coolant-indexed **warm-up fuel/idle** tables, not knock.



## Tune differences



All known MCS-vs-factory differences (84 calibration tables in total) are recorded in one place: T5 MCS Tune Changes. Knock detection and protection logic itself is byte-identical between the two images.



