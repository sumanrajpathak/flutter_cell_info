class SIMInfoResponse {
  List<SimInfoList>? simInfoList;

  SIMInfoResponse({this.simInfoList});

  SIMInfoResponse.fromJson(Map<String, dynamic> json) {
    if (json['simInfoList'] != null) {
      simInfoList = [];
      json['simInfoList'].forEach((v) {
        simInfoList!.add(new SimInfoList.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.simInfoList != null) {
      data['simInfoList'] = this.simInfoList!.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class SimInfoList {
  String? carrierName;
  String? displayName;
  int? mcc;
  int? mnc;
  String? subscriptionInfoNumber;

  SimInfoList(
      {this.carrierName,
      this.displayName,
      this.mcc,
      this.mnc,
      this.subscriptionInfoNumber});

  SimInfoList.fromJson(Map<String, dynamic> json) {
    carrierName = json['carrierName'];
    displayName = json['displayName'];
    mcc = json['mcc'];
    mnc = json['mnc'];
    subscriptionInfoNumber = json['subscriptionInfoNumber'];
  }

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
