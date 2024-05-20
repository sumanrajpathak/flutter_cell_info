/// This class is used to parse the response of the SIM info API.
class SIMInfoResponse {
  List<SimInfoList>? simInfoList;

  /// Constructs a SIMInfoResponse object.
  SIMInfoResponse({this.simInfoList});

  /// Constructs a SIMInfoResponse object from a JSON object.
  SIMInfoResponse.fromJson(Map<String, dynamic> json) {
    if (json['simInfoList'] != null) {
      simInfoList = [];
      json['simInfoList'].forEach((v) {
        simInfoList!.add(new SimInfoList.fromJson(v));
      });
    }
  }

  /// Converts a SIMInfoResponse object to a JSON object.
  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.simInfoList != null) {
      data['simInfoList'] = this.simInfoList!.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

/// This class is used to parse the response of the SIM info API.
class SimInfoList {
  String? carrierName;
  String? displayName;
  int? mcc;
  int? mnc;
  String? subscriptionInfoNumber;

  /// Constructs a SimInfoList object.
  SimInfoList(
      {this.carrierName,
      this.displayName,
      this.mcc,
      this.mnc,
      this.subscriptionInfoNumber});

  /// Constructs a SimInfoList object from a JSON object.
  SimInfoList.fromJson(Map<String, dynamic> json) {
    carrierName = json['carrierName'];
    displayName = json['displayName'];
    mcc = json['mcc'];
    mnc = json['mnc'];
    subscriptionInfoNumber = json['subscriptionInfoNumber'];
  }

  /// Converts a SimInfoList object to a JSON object.
  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['carrierName'] = this.carrierName;
    data['displayName'] = this.displayName;
    data['mcc'] = this.mcc;
    data['mnc'] = this.mnc;
    data['subscriptionInfoNumber'] = this.subscriptionInfoNumber;
    return data;
  }
}
