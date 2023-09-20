class Network {
  String? iso;
  String? mcc;
  String? mnc;

  Network({this.iso, this.mcc, this.mnc});

  Network.fromJson(Map<String, dynamic> json) {
    iso = json['iso'];
    mcc = json['mcc'];
    mnc = json['mnc'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['iso'] = this.iso;
    data['mcc'] = this.mcc;
    data['mnc'] = this.mnc;
    return data;
  }
}
