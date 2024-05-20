/// CDMA Band model class
/// Contains the attributes of CDMA Band
/// Attributes: channelNumber, name, number
/// Methods: toJson, fromJson
/// Example:
/// var cdmaBand = Band(channelNumber: 1, name: "CDMA", number: 1);
class Band {
  int? channelNumber;
  String? name;
  int? number;

  /// Constructs a Band object
  Band({this.channelNumber, this.name, this.number});

  /// Constructs a Band object from a JSON object
  Band.fromJson(Map<String, dynamic> json) {
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  /// Converts a Band object to a JSON object
  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}
