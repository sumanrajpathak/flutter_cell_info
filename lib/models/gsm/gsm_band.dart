class BandGSM {
  int? arfcn;
  int? channelNumber;
  String? name;
  int? number;

  BandGSM({this.arfcn, this.channelNumber, this.name, this.number});

  BandGSM.fromJson(Map<String, dynamic> json) {
    arfcn = json['arfcn'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['arfcn'] = this.arfcn;
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}
