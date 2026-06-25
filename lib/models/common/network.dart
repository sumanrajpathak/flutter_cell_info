/// Model describing Network data exchanged with the native plugin.
class Network {
  String? iso;
  String? mcc;
  String? mnc;

  Network({this.iso, this.mcc, this.mnc});

  /// Creates a [Network] from a decoded JSON [Map].
  Network.fromJson(Map<String, dynamic> json) {
    iso = json['iso'];
    mcc = json['mcc'];
    mnc = json['mnc'];
  }

  /// Converts this [Network] into a JSON-serializable [Map].
  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['iso'] = this.iso;
    data['mcc'] = this.mcc;
    data['mnc'] = this.mnc;
    return data;
  }
}
