class SignalNR {
  int? csiRsrp;
  int? csiRsrpAsu;
  int? csiRsrq;
  int? csiSinr;
  int? ssRsrp;
  int? ssRsrpAsu;
  int? ssRsrq;
  int? ssSinr;
  int? dbm;

  SignalNR(
      {this.csiRsrp,
      this.csiRsrpAsu,
      this.csiRsrq,
      this.csiSinr,
      this.ssRsrp,
      this.ssRsrpAsu,
      this.ssRsrq,
      this.ssSinr,
      this.dbm});

  SignalNR.fromJson(Map<String, dynamic> json) {
    csiRsrp = json['csiRsrp'];
    csiRsrpAsu = json['csiRsrpAsu'];
    csiRsrq = json['csiRsrq'];
    csiSinr = json['csiSinr'];
    ssRsrp = json['ssRsrp'];
    ssRsrpAsu = json['ssRsrpAsu'];
    ssRsrq = json['ssRsrq'];
    ssSinr = json['ssSinr'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['csiRsrp'] = this.csiRsrp;
    data['csiRsrpAsu'] = this.csiRsrpAsu;
    data['csiRsrq'] = this.csiRsrq;
    data['csiSinr'] = this.csiSinr;
    data['ssRsrp'] = this.ssRsrp;
    data['ssRsrpAsu'] = this.ssRsrpAsu;
    data['ssRsrq'] = this.ssRsrq;
    data['ssSinr'] = this.ssSinr;
    data['dbm'] = this.dbm;
    return data;
  }
}
