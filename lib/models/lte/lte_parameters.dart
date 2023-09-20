import 'package:flutter_cell_info/models/common/network.dart';

import 'lte_band.dart';
import 'lte_signal.dart';

class Lte {
  BandLTE? bandLTE;
  int? bandwidth;
  int? cid;
  int? eci;
  int? enb;
  int? pci;
  String? ecgi;
  SignalLTE? signalLTE;
  int? tac;
  String? connectionStatus;
  Network? network;
  int? subscriptionId;
  String? type;

  Lte(
      {this.bandLTE,
      this.bandwidth,
      this.cid,
      this.eci,
      this.enb,
      this.pci,
      this.signalLTE,
      this.tac,
      this.ecgi,
      this.connectionStatus,
      this.network,
      this.subscriptionId,
      this.type});

  Lte.fromJson(Map<String, dynamic> json) {
    bandLTE =
        json['bandLTE'] != null ? new BandLTE.fromJson(json['bandLTE']) : null;
    bandwidth = json['bandwidth'];
    cid = json['cid'];
    eci = json['eci'];
    enb = json['enb'];
    ecgi = json['ecgi'];
    pci = json['pci'];
    signalLTE = json['signalLTE'] != null
        ? new SignalLTE.fromJson(json['signalLTE'])
        : null;
    tac = json['tac'];
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? new Network.fromJson(json['network']) : null;
    subscriptionId = json['subscriptionId'];
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandLTE != null) {
      data['bandLTE'] = this.bandLTE!.toJson();
    }
    data['bandwidth'] = this.bandwidth;
    data['cid'] = this.cid;
    data['eci'] = this.eci;
    data['enb'] = this.enb;
    data['pci'] = this.pci;
    data['ecgi'] = this.ecgi;
    if (this.signalLTE != null) {
      data['signalLTE'] = this.signalLTE!.toJson();
    }
    data['tac'] = this.tac;
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network!.toJson();
    }
    data['subscriptionId'] = this.subscriptionId;
    data['type'] = this.type;
    return data;
  }
}
