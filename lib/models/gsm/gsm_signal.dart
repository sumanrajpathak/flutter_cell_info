class SignalGSM {
  int? bitErrorRate;
  int? rssi;
  int? timingAdvance;
  int? dbm;

  SignalGSM({this.bitErrorRate, this.rssi, this.timingAdvance, this.dbm});

  SignalGSM.fromJson(Map<String, dynamic> json) {
    bitErrorRate = json['bitErrorRate'];
    rssi = json['rssi'];
    timingAdvance = json['timingAdvance'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['bitErrorRate'] = this.bitErrorRate;
    data['rssi'] = this.rssi;
    data['timingAdvance'] = this.timingAdvance;
    data['dbm'] = this.dbm;
    return data;
  }
}
