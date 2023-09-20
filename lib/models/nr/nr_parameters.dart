import 'package:flutter_cell_info/models/common/network.dart';

import 'nr_band.dart';
import 'nr_signal.dart';

class Nr {
  BandNR? bandNR;
  int? nci;
  int? pci;
  SignalNR? signalNR;
  int? tac;
  String? connectionStatus;
  Network? network;
  String? type;

  Nr(
      {this.bandNR,
      this.nci,
      this.pci,
      this.signalNR,
      this.tac,
      this.connectionStatus,
      this.network,
      this.type});

  Nr.fromJson(Map<String, dynamic> json) {
    bandNR =
        json['bandNR'] != null ? new BandNR.fromJson(json['bandNR']) : null;
    nci = json['nci'];
    pci = json['pci'];
    signalNR = json['signalNR'] != null
        ? new SignalNR.fromJson(json['signalNR'])
        : null;
    tac = json['tac'];
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandNR != null) {
      data['bandNR'] = this.bandNR!.toJson();
    }
    data['nci'] = this.nci;
    data['pci'] = this.pci;
    if (this.signalNR != null) {
      data['signalNR'] = this.signalNR!.toJson();
    }
    data['tac'] = this.tac;
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network!.toJson();
    }
    data['type'] = this.type;
    return data;
  }
}
