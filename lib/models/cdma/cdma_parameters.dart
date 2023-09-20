import 'package:flutter_cell_info/models/common/network.dart';

import 'cdma_band.dart';
import 'cdma_signal.dart';

class Cdma {
  Band? band;
  int? bid;
  SignalCDMA? signalCDMA;
  String? connectionStatus;
  Network? network;
  String? type;

  Cdma(
      {this.band,
        this.bid,
        this.signalCDMA,
        this.connectionStatus,
        this.network,
        this.type});

  Cdma.fromJson(Map<String, dynamic> json) {
    band = json['band'] != null ? new Band.fromJson(json['band']) : null;
    bid = json['bid'];
    signalCDMA = json['signalCDMA'] != null
        ? new SignalCDMA.fromJson(json['signalCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
    json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.band != null) {
      data['band'] = this.band!.toJson();
    }
    data['bid'] = this.bid;
    if (this.signalCDMA != null) {
      data['signalCDMA'] = this.signalCDMA!.toJson();
    }
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network!.toJson();
    }
    data['type'] = this.type;
    return data;
  }
}