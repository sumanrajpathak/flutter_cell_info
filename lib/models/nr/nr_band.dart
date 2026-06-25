/// Model describing BandNR data exchanged with the native plugin.
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

  /// Creates a [BandNR] from a decoded JSON [Map].
  BandNR.fromJson(Map<String, dynamic> json) {
    downlinkArfcn = json['downlinkArfcn'];
    downlinkFrequency = json['downlinkFrequency'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  /// Converts this [BandNR] into a JSON-serializable [Map].
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
