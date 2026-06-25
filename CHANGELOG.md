# 0.0.6

* Added iOS support via CoreTelephony (carrier/SIM info and current radio access
  technology). Note: iOS does not expose cell identity, signal strength or
  neighbouring cells through any public API, so those fields are unavailable on iOS.
* Updated dependencies
* Bug fixes and improvements

## 0.0.5

* Integrated NetMonster Core library for enhanced telephony data
* Added support for multiple network types (GSM, WCDMA, LTE, NR, CDMA, TDS-CDMA)
* Improved data validation and error handling
* Added backport support for older Android devices
* Enhanced signal and cell identity information
