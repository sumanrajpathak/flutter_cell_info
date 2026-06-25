/// Model describing BandWCDMA data exchanged with the native plugin.
class BandWCDMA {
  int? downlinkUarfcn;
  int? channelNumber;
  String? name;
  int? number;

  BandWCDMA({this.downlinkUarfcn, this.channelNumber, this.name, this.number});

  /// Creates a [BandWCDMA] from a decoded JSON [Map].
  BandWCDMA.fromJson(Map<String, dynamic> json) {
    downlinkUarfcn = json['downlinkUarfcn'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  /// Converts this [BandWCDMA] into a JSON-serializable [Map].
  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['downlinkUarfcn'] = this.downlinkUarfcn;
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}
