class SignalLTE {
  int? cqi;
  double? rsrp;
  int? rsrpAsu;
  double? rsrq;
  int? rssi;
  int? rssiAsu;
  double? snr;
  int? timingAdvance;
  int? dbm;

  SignalLTE(
      {this.cqi,
      this.rsrp,
      this.rsrpAsu,
      this.rsrq,
      this.rssi,
      this.rssiAsu,
      this.snr,
      this.timingAdvance,
      this.dbm});

  SignalLTE.fromJson(Map<String, dynamic> json) {
    cqi = json['cqi'];
    rsrp = json['rsrp'];
    rsrpAsu = json['rsrpAsu'];
    rsrq = json['rsrq'];
    rssi = json['rssi'];
    rssiAsu = json['rssiAsu'];
    snr = json['snr'];
    timingAdvance = json['timingAdvance'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['cqi'] = this.cqi;
    data['rsrp'] = this.rsrp;
    data['rsrpAsu'] = this.rsrpAsu;
    data['rsrq'] = this.rsrq;
    data['rssi'] = this.rssi;
    data['rssiAsu'] = this.rssiAsu;
    data['snr'] = this.snr;
    data['timingAdvance'] = this.timingAdvance;
    data['dbm'] = this.dbm;
    return data;
  }
}
