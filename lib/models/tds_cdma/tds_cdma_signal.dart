class SignalTDSCDMA {
  int? bitErrorRate;
  int? rscp;
  int? rscpAsu;
  int? rssi;
  int? rssiAsu;
  int? dbm;

  SignalTDSCDMA(
      {this.bitErrorRate,
      this.rscp,
      this.rscpAsu,
      this.rssi,
      this.rssiAsu,
      this.dbm});

  SignalTDSCDMA.fromJson(Map<String, dynamic> json) {
    bitErrorRate = json['bitErrorRate'];
    rscp = json['rscp'];
    rscpAsu = json['rscpAsu'];
    rssi = json['rssi'];
    rssiAsu = json['rssiAsu'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['bitErrorRate'] = this.bitErrorRate;
    data['rscp'] = this.rscp;
    data['rscpAsu'] = this.rscpAsu;
    data['rssi'] = this.rssi;
    data['rssiAsu'] = this.rssiAsu;
    data['dbm'] = this.dbm;
    return data;
  }
}
