class BandNR {
  int? downlinkArfcn;
  int? downlinkFrequency;
  int? channelNumber;
  String? name;
  int? number;

  BandNR(
      {this.downlinkArfcn,
      this.downlinkFrequency,
      this.channelNumber,
      this.name,
      this.number});

  BandNR.fromJson(Map<String, dynamic> json) {
    downlinkArfcn = json['downlinkArfcn'];
    downlinkFrequency = json['downlinkFrequency'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['downlinkArfcn'] = this.downlinkArfcn;
    data['downlinkFrequency'] = this.downlinkFrequency;
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}
