# Function_0004B97E

**ROM:** `0x0004B97E`

```c

void Function_0004B97E(void)

{
  byte bVar1;
  
  bVar1 = DAT_00003eaa;
  if ((DAT_00003b02 < DAT_0000386c + 3000U) && ((DAT_00006e20 & 0x80) == 0)) {
    if ((DAT_000038c4 & 8) == 0) {
      Function_00044CC2();
      bVar1 = DAT_00003eaa;
    }
  }
  else if ((DAT_00003b72 == 0) && ((DAT_00006e20 & 0x80) != 0)) {
    if ((DAT_000038c4 & 8) == 0) {
      Function_00044CC2();
      bVar1 = DAT_00003eaa;
    }
  }
  else if ((((DAT_00006e20 & 0x80) == 0) && (DAT_00003b72 == 0)) && ((DAT_00003eaa & 0x20) == 0)) {
    if ((DAT_00003ea8 == 0) && (DAT_00003ea9 == 0)) {
      if (RAM_Luft_error != 0) {
        DAT_00003ea8 = 0x80;
      }
      if (DAT_00003320 != 0) {
        DAT_00003ea8 = DAT_00003ea8 | 0x40;
      }
      if (DAT_0000331f != 0) {
        DAT_00003ea8 = DAT_00003ea8 | 0x20;
      }
      if (DAT_00003322 != 0) {
        DAT_00003ea8 = DAT_00003ea8 | 0x10;
      }
      if (DAT_00003323 != 0) {
        DAT_00003ea8 = DAT_00003ea8 | 8;
      }
      if (RAM_Sond_error != 0) {
        DAT_00003ea8 = DAT_00003ea8 | 0x40;
      }
      if (DAT_0000332f != 0) {
        DAT_00003ea8 = DAT_00003ea8 | 4;
      }
      if (RAM_Idle_error != 0) {
        DAT_00003ea8 = DAT_00003ea8 | 2;
      }
      if ((RAM_VSS2_error != 0) || (DAT_0000331e != '\0')) {
        DAT_00003ea8 = DAT_00003ea8 | 1;
      }
      if (DAT_00003328 != 0) {
        DAT_00003ea9 = 0x80;
      }
      DAT_00003768 = DAT_00003b02;
      if ((DAT_00003ea8 == 0) && (DAT_00003ea9 == 0)) {
        if ((DAT_000038c4 & 8) == 0) {
          Function_00044CC2();
          bVar1 = DAT_00003eaa;
        }
      }
      else {
        bVar1 = DAT_00003eaa | 0x40;
      }
    }
    else if ((DAT_00003b02 < DAT_00003768 + 6000) && ((DAT_00003eaa & 0x40) != 0)) {
      if (DAT_00003b02 < DAT_00003768 + 3000) {
        if ((DAT_000038c4 & 8) == 0) {
          Function_00044CC2();
          bVar1 = DAT_00003eaa;
        }
      }
      else if ((DAT_000038c4 & 8) == 0) {
        Function_00044CC2();
        bVar1 = DAT_00003eaa;
      }
    }
    else {
      bVar1 = DAT_00003eaa & 0xbf;
      if ((DAT_00003ea9 & 0x80) == 0) {
        if ((DAT_00003ea8 & 0x80) == 0) {
          if ((DAT_00003ea8 & 0x40) == 0) {
            if ((DAT_00003ea8 & 0x20) == 0) {
              if ((DAT_00003ea8 & 0x10) == 0) {
                if ((DAT_00003ea8 & 8) == 0) {
                  if ((DAT_00003ea8 & 4) == 0) {
                    if ((DAT_00003ea8 & 2) == 0) {
                      if ((DAT_00003ea8 & 1) != 0) {
                        if ((DAT_00003eaa & 0x80) == 0) {
                          DAT_00003768 = DAT_00003b02;
                          DAT_00003eac = 9;
                          bVar1 = bVar1 | 0x80;
                        }
                        else if (DAT_00003b02 < DAT_00003768 + 2000) {
                          if ((DAT_000038c4 & 8) == 0) {
                            DAT_00003eaa = bVar1;
                            Function_00044CC2();
                            bVar1 = DAT_00003eaa;
                          }
                        }
                        else if (DAT_00003b02 <
                                 DAT_00003768 +
                                 (int)(short)(((ushort)DAT_00003eac + (ushort)DAT_00003eac + -1) *
                                             400) + 2000) {
                          if ((((DAT_00003b02 - DAT_00003768) - 2000) / 400 & 1) == 0) {
                            if ((DAT_000038c4 & 8) == 0) {
                              DAT_00003eaa = bVar1;
                              Function_00044CC2();
                              bVar1 = DAT_00003eaa;
                            }
                          }
                          else if ((DAT_000038c4 & 8) == 0) {
                            DAT_00003eaa = bVar1;
                            Function_00044CC2();
                            bVar1 = DAT_00003eaa;
                          }
                        }
                        else {
                          DAT_00003ea8 = DAT_00003ea8 & 0xfe;
                          bVar1 = DAT_00003eaa & 0x3f;
                        }
                      }
                    }
                    else if ((DAT_00003eaa & 0x80) == 0) {
                      DAT_00003768 = DAT_00003b02;
                      DAT_00003eac = 8;
                      bVar1 = bVar1 | 0x80;
                    }
                    else if (DAT_00003b02 < DAT_00003768 + 2000) {
                      if ((DAT_000038c4 & 8) == 0) {
                        DAT_00003eaa = bVar1;
                        Function_00044CC2();
                        bVar1 = DAT_00003eaa;
                      }
                    }
                    else if (DAT_00003b02 <
                             DAT_00003768 +
                             (int)(short)(((ushort)DAT_00003eac + (ushort)DAT_00003eac + -1) * 400)
                             + 2000) {
                      if ((((DAT_00003b02 - DAT_00003768) - 2000) / 400 & 1) == 0) {
                        if ((DAT_000038c4 & 8) == 0) {
                          DAT_00003eaa = bVar1;
                          Function_00044CC2();
                          bVar1 = DAT_00003eaa;
                        }
                      }
                      else if ((DAT_000038c4 & 8) == 0) {
                        DAT_00003eaa = bVar1;
                        Function_00044CC2();
                        bVar1 = DAT_00003eaa;
                      }
                    }
                    else {
                      DAT_00003ea8 = DAT_00003ea8 & 0xfd;
                      bVar1 = DAT_00003eaa & 0x3f;
                    }
                  }
                  else if ((DAT_00003eaa & 0x80) == 0) {
                    DAT_00003768 = DAT_00003b02;
                    DAT_00003eac = 7;
                    bVar1 = bVar1 | 0x80;
                  }
                  else if (DAT_00003b02 < DAT_00003768 + 2000) {
                    if ((DAT_000038c4 & 8) == 0) {
                      DAT_00003eaa = bVar1;
                      Function_00044CC2();
                      bVar1 = DAT_00003eaa;
                    }
                  }
                  else if (DAT_00003b02 <
                           DAT_00003768 +
                           (int)(short)(((ushort)DAT_00003eac + (ushort)DAT_00003eac + -1) * 400) +
                           2000) {
                    if ((((DAT_00003b02 - DAT_00003768) - 2000) / 400 & 1) == 0) {
                      if ((DAT_000038c4 & 8) == 0) {
                        DAT_00003eaa = bVar1;
                        Function_00044CC2();
                        bVar1 = DAT_00003eaa;
                      }
                    }
                    else if ((DAT_000038c4 & 8) == 0) {
                      DAT_00003eaa = bVar1;
                      Function_00044CC2();
                      bVar1 = DAT_00003eaa;
                    }
                  }
                  else {
                    DAT_00003ea8 = DAT_00003ea8 & 0xfb;
                    bVar1 = DAT_00003eaa & 0x3f;
                  }
                }
                else if ((DAT_00003eaa & 0x80) == 0) {
                  DAT_00003768 = DAT_00003b02;
                  DAT_00003eac = 6;
                  bVar1 = bVar1 | 0x80;
                }
                else if (DAT_00003b02 < DAT_00003768 + 2000) {
                  if ((DAT_000038c4 & 8) == 0) {
                    DAT_00003eaa = bVar1;
                    Function_00044CC2();
                    bVar1 = DAT_00003eaa;
                  }
                }
                else if (DAT_00003b02 <
                         DAT_00003768 +
                         (int)(short)(((ushort)DAT_00003eac + (ushort)DAT_00003eac + -1) * 400) +
                         2000) {
                  if ((((DAT_00003b02 - DAT_00003768) - 2000) / 400 & 1) == 0) {
                    if ((DAT_000038c4 & 8) == 0) {
                      DAT_00003eaa = bVar1;
                      Function_00044CC2();
                      bVar1 = DAT_00003eaa;
                    }
                  }
                  else if ((DAT_000038c4 & 8) == 0) {
                    DAT_00003eaa = bVar1;
                    Function_00044CC2();
                    bVar1 = DAT_00003eaa;
                  }
                }
                else {
                  DAT_00003ea8 = DAT_00003ea8 & 0xf7;
                  bVar1 = DAT_00003eaa & 0x3f;
                }
              }
              else if ((DAT_00003eaa & 0x80) == 0) {
                DAT_00003768 = DAT_00003b02;
                DAT_00003eac = 5;
                bVar1 = bVar1 | 0x80;
              }
              else if (DAT_00003b02 < DAT_00003768 + 2000) {
                if ((DAT_000038c4 & 8) == 0) {
                  DAT_00003eaa = bVar1;
                  Function_00044CC2();
                  bVar1 = DAT_00003eaa;
                }
              }
              else if (DAT_00003b02 <
                       DAT_00003768 +
                       (int)(short)(((ushort)DAT_00003eac + (ushort)DAT_00003eac + -1) * 400) + 2000
                      ) {
                if ((((DAT_00003b02 - DAT_00003768) - 2000) / 400 & 1) == 0) {
                  if ((DAT_000038c4 & 8) == 0) {
                    DAT_00003eaa = bVar1;
                    Function_00044CC2();
                    bVar1 = DAT_00003eaa;
                  }
                }
                else if ((DAT_000038c4 & 8) == 0) {
                  DAT_00003eaa = bVar1;
                  Function_00044CC2();
                  bVar1 = DAT_00003eaa;
                }
              }
              else {
                DAT_00003ea8 = DAT_00003ea8 & 0xef;
                bVar1 = DAT_00003eaa & 0x3f;
              }
            }
            else if ((DAT_00003eaa & 0x80) == 0) {
              DAT_00003768 = DAT_00003b02;
              DAT_00003eac = 4;
              bVar1 = bVar1 | 0x80;
            }
            else if (DAT_00003b02 < DAT_00003768 + 2000) {
              if ((DAT_000038c4 & 8) == 0) {
                DAT_00003eaa = bVar1;
                Function_00044CC2();
                bVar1 = DAT_00003eaa;
              }
            }
            else if (DAT_00003b02 <
                     DAT_00003768 +
                     (int)(short)(((ushort)DAT_00003eac + (ushort)DAT_00003eac + -1) * 400) + 2000)
            {
              if ((((DAT_00003b02 - DAT_00003768) - 2000) / 400 & 1) == 0) {
                if ((DAT_000038c4 & 8) == 0) {
                  DAT_00003eaa = bVar1;
                  Function_00044CC2();
                  bVar1 = DAT_00003eaa;
                }
              }
              else if ((DAT_000038c4 & 8) == 0) {
                DAT_00003eaa = bVar1;
                Function_00044CC2();
                bVar1 = DAT_00003eaa;
              }
            }
            else {
              DAT_00003ea8 = DAT_00003ea8 & 0xdf;
              bVar1 = DAT_00003eaa & 0x3f;
            }
          }
          else if ((DAT_00003eaa & 0x80) == 0) {
            DAT_00003768 = DAT_00003b02;
            DAT_00003eac = 3;
            bVar1 = bVar1 | 0x80;
          }
          else if (DAT_00003b02 < DAT_00003768 + 2000) {
            if ((DAT_000038c4 & 8) == 0) {
              DAT_00003eaa = bVar1;
              Function_00044CC2();
              bVar1 = DAT_00003eaa;
            }
          }
          else if (DAT_00003b02 <
                   DAT_00003768 +
                   (int)(short)(((ushort)DAT_00003eac + (ushort)DAT_00003eac + -1) * 400) + 2000) {
            if ((((DAT_00003b02 - DAT_00003768) - 2000) / 400 & 1) == 0) {
              if ((DAT_000038c4 & 8) == 0) {
                DAT_00003eaa = bVar1;
                Function_00044CC2();
                bVar1 = DAT_00003eaa;
              }
            }
            else if ((DAT_000038c4 & 8) == 0) {
              DAT_00003eaa = bVar1;
              Function_00044CC2();
              bVar1 = DAT_00003eaa;
            }
          }
          else {
            DAT_00003ea8 = DAT_00003ea8 & 0xbf;
            bVar1 = DAT_00003eaa & 0x3f;
          }
        }
        else if ((DAT_00003eaa & 0x80) == 0) {
          DAT_00003768 = DAT_00003b02;
          DAT_00003eac = 2;
          bVar1 = bVar1 | 0x80;
        }
        else if (DAT_00003b02 < DAT_00003768 + 2000) {
          if ((DAT_000038c4 & 8) == 0) {
            DAT_00003eaa = bVar1;
            Function_00044CC2();
            bVar1 = DAT_00003eaa;
          }
        }
        else if (DAT_00003b02 <
                 DAT_00003768 +
                 (int)(short)(((ushort)DAT_00003eac + (ushort)DAT_00003eac + -1) * 400) + 2000) {
          if ((((DAT_00003b02 - DAT_00003768) - 2000) / 400 & 1) == 0) {
            if ((DAT_000038c4 & 8) == 0) {
              DAT_00003eaa = bVar1;
              Function_00044CC2();
              bVar1 = DAT_00003eaa;
            }
          }
          else if ((DAT_000038c4 & 8) == 0) {
            DAT_00003eaa = bVar1;
            Function_00044CC2();
            bVar1 = DAT_00003eaa;
          }
        }
        else {
          DAT_00003ea8 = DAT_00003ea8 & 0x7f;
          bVar1 = DAT_00003eaa & 0x3f;
        }
      }
      else if ((DAT_00003eaa & 0x80) == 0) {
        DAT_00003768 = DAT_00003b02;
        DAT_00003eac = 1;
        bVar1 = bVar1 | 0x80;
      }
      else if (DAT_00003b02 < DAT_00003768 + 2000) {
        if ((DAT_000038c4 & 8) == 0) {
          DAT_00003eaa = bVar1;
          Function_00044CC2();
          bVar1 = DAT_00003eaa;
        }
      }
      else if (DAT_00003b02 <
               DAT_00003768 + (int)(short)(((ushort)DAT_00003eac + (ushort)DAT_00003eac + -1) * 400)
               + 2000) {
        if ((((DAT_00003b02 - DAT_00003768) - 2000) / 400 & 1) == 0) {
          if ((DAT_000038c4 & 8) == 0) {
            DAT_00003eaa = bVar1;
            Function_00044CC2();
            bVar1 = DAT_00003eaa;
          }
        }
        else if ((DAT_000038c4 & 8) == 0) {
          DAT_00003eaa = bVar1;
          Function_00044CC2();
          bVar1 = DAT_00003eaa;
        }
      }
      else {
        DAT_00003ea9 = DAT_00003ea9 & 0x7f;
        bVar1 = DAT_00003eaa & 0x3f;
      }
    }
  }
  else if (((DAT_00006e20 & 0x80) == 0) || ((DAT_00006e20 & 2) != 0)) {
    DAT_00003ea8 = 0;
    DAT_00003ea9 = 0;
    DAT_00003eaa = DAT_00003eaa & 0x3f | 0x20;
    bVar1 = DAT_00003eaa;
    if (DAT_0000331f < 0x28) {
      if (DAT_00003320 < 0x28) {
        if (RAM_Luft_error < 0x28) {
          if (((DAT_00003322 < 0x28) || ((RAM_Ramp_steg_[3] & 8) != 0)) && (DAT_00003322 < 0x29)) {
            if ((DAT_00003323 < 0x28) && (RAM_Sond_error < 0x28)) {
              if (RAM_Idle_error < 0x28) {
                if (DAT_0000332f < 0x50) {
                  if ((RAM_VSS2_error == 0) && (DAT_0000331e == '\0')) {
                    if (DAT_00003328 < 0x28) {
                      if ((DAT_000038c4 & 8) == 0) {
                        Function_00044CC2();
                        bVar1 = DAT_00003eaa;
                      }
                    }
                    else if ((DAT_000038c4 & 8) == 0) {
                      Function_00044CC2();
                      bVar1 = DAT_00003eaa;
                    }
                  }
                  else if ((DAT_000038c4 & 8) == 0) {
                    Function_00044CC2();
                    bVar1 = DAT_00003eaa;
                  }
                }
                else if ((DAT_000038c4 & 8) == 0) {
                  Function_00044CC2();
                  bVar1 = DAT_00003eaa;
                }
              }
              else if ((DAT_000038c4 & 8) == 0) {
                Function_00044CC2();
                bVar1 = DAT_00003eaa;
              }
            }
            else if ((DAT_000038c4 & 8) == 0) {
              Function_00044CC2();
              bVar1 = DAT_00003eaa;
            }
          }
          else if ((DAT_000038c4 & 8) == 0) {
            Function_00044CC2();
            bVar1 = DAT_00003eaa;
          }
        }
        else if ((DAT_000038c4 & 8) == 0) {
          Function_00044CC2();
          bVar1 = DAT_00003eaa;
        }
      }
      else if ((DAT_000038c4 & 8) == 0) {
        Function_00044CC2();
        bVar1 = DAT_00003eaa;
      }
    }
    else if ((DAT_000038c4 & 8) == 0) {
      Function_00044CC2();
      bVar1 = DAT_00003eaa;
    }
  }
  else if ((((RAM_Mis200_4 < 400) || (DAT_0000107e < 0x321)) || (DAT_00003b72 < 0x259)) ||
          (RAM_Bil_hast <= DAT_000072a2)) {
    if ((DAT_00001a58 < 6) || (DAT_00003764 + 5 <= DAT_00001a58)) {
      DAT_00003ea8 = 0;
      DAT_00003ea9 = 0;
      DAT_00003eaa = DAT_00003eaa & 0x3f | 0x20;
      bVar1 = DAT_00003eaa;
      if (DAT_00003ea0 < '\0') {
        if ((DAT_000038c4 & 8) == 0) {
          Function_00044CC2();
          bVar1 = DAT_00003eaa;
        }
      }
      else if (DAT_0000332b < 0x29) {
        if (DAT_0000332c < 0x29) {
          if (DAT_0000332d < 0x29) {
            if (DAT_0000332e < 0x29) {
              if (DAT_0000332a < 0x29) {
                if (DAT_0000331f < 0x29) {
                  if (DAT_00003320 < 0x29) {
                    if (RAM_Luft_error < 0x29) {
                      if (DAT_00003322 < 0x29) {
                        if ((DAT_00003323 < 0x29) && (RAM_Sond_error < 0x29)) {
                          if (DAT_00001d21 < 0x29) {
                            if (RAM_Idle_error < 0x29) {
                              if (DAT_0000332f < 0x29) {
                                if (DAT_00003325 < 0x29) {
                                  if (RAM_Hast_error < 0x29) {
                                    if (DAT_00001d26 < 0x29) {
                                      if (DAT_00001d22 < 0x29) {
                                        if (DAT_00001d23 < 0x29) {
                                          if (DAT_00003329 < 0x29) {
                                            if (RAM_Sync_error < 0x29) {
                                              if ((RAM_VSS2_error == 0) && (DAT_0000331e == '\0')) {
                                                if (DAT_00003328 < 0x29) {
                                                  if (DAT_00001d20 < 0x29) {
                                                    if (RAM_Tank_error < 0x29) {
                                                      if (RAM_R_sond_error < 0x29) {
                                                        if ((DAT_000038c4 & 8) == 0) {
                                                          Function_00044CC2();
                                                          bVar1 = DAT_00003eaa;
                                                        }
                                                      }
                                                      else if ((DAT_000038c4 & 8) == 0) {
                                                        Function_00044CC2();
                                                        bVar1 = DAT_00003eaa;
                                                      }
                                                    }
                                                    else if ((DAT_000038c4 & 8) == 0) {
                                                      Function_00044CC2();
                                                      bVar1 = DAT_00003eaa;
                                                    }
                                                  }
                                                  else if ((DAT_000038c4 & 8) == 0) {
                                                    Function_00044CC2();
                                                    bVar1 = DAT_00003eaa;
                                                  }
                                                }
                                                else if ((DAT_000038c4 & 8) == 0) {
                                                  Function_00044CC2();
                                                  bVar1 = DAT_00003eaa;
                                                }
                                              }
                                              else if ((DAT_000038c4 & 8) == 0) {
                                                Function_00044CC2();
                                                bVar1 = DAT_00003eaa;
                                              }
                                            }
                                            else if ((DAT_000038c4 & 8) == 0) {
                                              Function_00044CC2();
                                              bVar1 = DAT_00003eaa;
                                            }
                                          }
                                          else if ((DAT_000038c4 & 8) == 0) {
                                            Function_00044CC2();
                                            bVar1 = DAT_00003eaa;
                                          }
                                        }
                                        else if ((DAT_000038c4 & 8) == 0) {
                                          Function_00044CC2();
                                          bVar1 = DAT_00003eaa;
                                        }
                                      }
                                      else if ((DAT_000038c4 & 8) == 0) {
                                        Function_00044CC2();
                                        bVar1 = DAT_00003eaa;
                                      }
                                    }
                                    else if ((DAT_000038c4 & 8) == 0) {
                                      Function_00044CC2();
                                      bVar1 = DAT_00003eaa;
                                    }
                                  }
                                  else if ((DAT_000038c4 & 8) == 0) {
                                    Function_00044CC2();
                                    bVar1 = DAT_00003eaa;
                                  }
                                }
                                else if ((DAT_000038c4 & 8) == 0) {
                                  Function_00044CC2();
                                  bVar1 = DAT_00003eaa;
                                }
                              }
                              else if ((DAT_000038c4 & 8) == 0) {
                                Function_00044CC2();
                                bVar1 = DAT_00003eaa;
                              }
                            }
                            else if ((DAT_000038c4 & 8) == 0) {
                              Function_00044CC2();
                              bVar1 = DAT_00003eaa;
                            }
                          }
                          else if ((DAT_000038c4 & 8) == 0) {
                            Function_00044CC2();
                            bVar1 = DAT_00003eaa;
                          }
                        }
                        else if ((DAT_000038c4 & 8) == 0) {
                          Function_00044CC2();
                          bVar1 = DAT_00003eaa;
                        }
                      }
                      else if ((DAT_000038c4 & 8) == 0) {
                        Function_00044CC2();
                        bVar1 = DAT_00003eaa;
                      }
                    }
                    else if ((DAT_000038c4 & 8) == 0) {
                      Function_00044CC2();
                      bVar1 = DAT_00003eaa;
                    }
                  }
                  else if ((DAT_000038c4 & 8) == 0) {
                    Function_00044CC2();
                    bVar1 = DAT_00003eaa;
                  }
                }
                else if ((DAT_000038c4 & 8) == 0) {
                  Function_00044CC2();
                  bVar1 = DAT_00003eaa;
                }
              }
              else if ((DAT_000038c4 & 8) == 0) {
                Function_00044CC2();
                bVar1 = DAT_00003eaa;
              }
            }
            else if ((DAT_000038c4 & 8) == 0) {
              Function_00044CC2();
              bVar1 = DAT_00003eaa;
            }
          }
          else if ((DAT_000038c4 & 8) == 0) {
            Function_00044CC2();
            bVar1 = DAT_00003eaa;
          }
        }
        else if ((DAT_000038c4 & 8) == 0) {
          Function_00044CC2();
          bVar1 = DAT_00003eaa;
        }
      }
      else if ((DAT_000038c4 & 8) == 0) {
        Function_00044CC2();
        bVar1 = DAT_00003eaa;
      }
    }
    else if ((DAT_00003b02 & 0x200) == 0) {
      Function_00044CC2();
      bVar1 = DAT_00003eaa;
    }
    else {
      Function_00044CC2();
      bVar1 = DAT_00003eaa;
    }
  }
  else {
    if ((DAT_00003b02 & 0x200) == 0) {
      Function_00044CC2();
    }
    else {
      Function_00044CC2();
    }
    DAT_00003764 = DAT_00001a58;
    bVar1 = DAT_00003eaa;
  }
  DAT_00003eaa = bVar1;
  return;
}

```
