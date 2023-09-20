class Band {
  int? channelNumber;
  String? name;
  int? number;

  Band({this.channelNumber, this.name, this.number});

  Band.fromJson(Map<String, dynamic> json) {
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}
