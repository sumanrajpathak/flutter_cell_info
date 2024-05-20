/// This class contains the CDMA signal strength parameters.
/// Attributes: cdmaEcio, cdmaRssi, evdoEcio, evdoRssi, evdoSnr, dbm
/// Methods: toJson, fromJson
class SignalCDMA {
  int? cdmaEcio;
  int? cdmaRssi;
  int? evdoEcio;
  int? evdoRssi;
  int? evdoSnr;
  int? dbm;

  /// Constructs a SignalCDMA object.
  SignalCDMA(
      {this.cdmaEcio,
      this.cdmaRssi,
      this.evdoEcio,
      this.evdoRssi,
      this.evdoSnr,
      this.dbm});

  /// Constructs a SignalCDMA object from a JSON object.
  SignalCDMA.fromJson(Map<String, dynamic> json) {
    cdmaEcio = json['cdmaEcio'];
    cdmaRssi = json['cdmaRssi'];
    evdoEcio = json['evdoEcio'];
    evdoRssi = json['evdoRssi'];
    evdoSnr = json['evdoSnr'];
    dbm = json['dbm'];
  }

  /// Converts a SignalCDMA object to a JSON object.
  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['cdmaEcio'] = this.cdmaEcio;
    data['cdmaRssi'] = this.cdmaRssi;
    data['evdoEcio'] = this.evdoEcio;
    data['evdoRssi'] = this.evdoRssi;
    data['evdoSnr'] = this.evdoSnr;
    data['dbm'] = this.dbm;
    return data;
  }
}
