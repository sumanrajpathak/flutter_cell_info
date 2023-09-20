class SignalWCDMA {
  int? bitErrorRate;
  int? ecio;
  int? ecno;
  int? rscp;
  int? rscpAsu;
  int? rssi;
  int? rssiAsu;
  int? dbm;

  SignalWCDMA(
      {this.bitErrorRate,
      this.ecio,
      this.ecno,
      this.rscp,
      this.rscpAsu,
      this.rssi,
      this.rssiAsu,
      this.dbm});

  SignalWCDMA.fromJson(Map<String, dynamic> json) {
    bitErrorRate = json['bitErrorRate'];
    ecio = json['ecio'];
    ecno = json['ecno'];
    rscp = json['rscp'];
    rscpAsu = json['rscpAsu'];
    rssi = json['rssi'];
    rssiAsu = json['rssiAsu'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['bitErrorRate'] = this.bitErrorRate;
    data['ecio'] = this.ecio;
    data['ecno'] = this.ecno;
    data['rscp'] = this.rscp;
    data['rscpAsu'] = this.rscpAsu;
    data['rssi'] = this.rssi;
    data['rssiAsu'] = this.rssiAsu;
    data['dbm'] = this.dbm;
    return data;
  }
}
