## 0.0.5
Lightweight Android library that is build over Telephony SDK. NetMonster core is extracted from NetMonster application and backports several Telephony features to older Android devices.

Why use NetMonster Core instead of legacy API?

    Validation - library validates data from RIL and corrects them if possible
    Richer information - additional functions for cell identity and cell signal that will make your code more understandable
    Backport - several non-accessible signal or identity fields are now accessible without boilerplate code
    Tested - tested on real devices, 50 000+ active users

New functions

Here's small comparison for each of voice / data network you can meet.
GSM
function 	Min SDK Android 	Min SDK NetMonster Core
CGI 	- 	I (14)
NCC 	- 	N (24)
BCC 	- 	N (24)
Band 	- 	N (24)
TA 	O (26) 	N (24)
WCDMA
function 	Min SDK Android 	Min SDK NetMonster Core
CGI 	- 	I (14)
CID (16b) 	- 	I (14)
RNC 	- 	I (14)
Ec/Io 	- 	M (23)
Band 	- 	N (24)
BER 	- 	Q (29)
Ec/No 	- 	Q (29)
RSCP 	- 	Q (29)
LTE
function 	Min SDK Android 	Min SDK NetMonster Core
eCGI 	- 	I (14)
CID (8b) 	- 	I (14)
eNb 	- 	I (14)
RSSI 	Q (29) 	I (14)
RSRP 	O (26) 	I (14)
CQI 	O (26) 	I (14)
SNR 	O (26) 	I (14)
TA 	O (26) 	I (14)
Band 	- 	N (24)
Usage

There are basically two ways you can use this library - as a validation library that will sanitize data from AOSP cause lots of manufacturers modify source code and do not follow public documentation. In that case you'll only need ITelephonyManagerCompat to retrieve AOSP-like models that are properly validated.

The second option is to use advantages of additional postprocessing of NetMonster Core. As a result you'll get more data but correctness is not 100 % guaranteed.
Without additional postprocessing