class SignalCDMA {
  int? cdmaEcio;
  int? cdmaRssi;
  int? evdoEcio;
  int? evdoRssi;
  int? evdoSnr;
  int? dbm;

  SignalCDMA(
      {this.cdmaEcio,
        this.cdmaRssi,
        this.evdoEcio,
        this.evdoRssi,
        this.evdoSnr,
        this.dbm});

  SignalCDMA.fromJson(Map<String, dynamic> json) {
    cdmaEcio = json['cdmaEcio'];
    cdmaRssi = json['cdmaRssi'];
    evdoEcio = json['evdoEcio'];
    evdoRssi = json['evdoRssi'];
    evdoSnr = json['evdoSnr'];
    dbm = json['dbm'];
  }

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