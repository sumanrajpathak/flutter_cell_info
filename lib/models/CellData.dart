class CellDataList {
  double? latitude;
  double? longitude;
  String? type;
  int? dbm;

  CellDataList({
    this.latitude,
    this.longitude,
    this.type,
    this.dbm,
  });

  CellDataList.fromJson(Map<String, dynamic> json) {
    latitude = json['latitude'];
    longitude = json['longitude'];
    type = json['type'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['latitude'] = this.latitude;
    data['longitude'] = this.longitude;
    data['type'] = this.type;
    data['dbm'] = this.dbm;
    return data;
  }
}
