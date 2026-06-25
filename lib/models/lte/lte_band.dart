/// Model describing BandLTE data exchanged with the native plugin.
class BandLTE {
  int? downlinkEarfcn;
  int? channelNumber;
  String? name;
  int? number;

  BandLTE({this.downlinkEarfcn, this.channelNumber, this.name, this.number});

  /// Creates a [BandLTE] from a decoded JSON [Map].
  BandLTE.fromJson(Map<String, dynamic> json) {
    downlinkEarfcn = json['downlinkEarfcn'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  /// Converts this [BandLTE] into a JSON-serializable [Map].
  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['downlinkEarfcn'] = this.downlinkEarfcn;
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}
