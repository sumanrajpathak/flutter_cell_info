import 'package:flutter_cell_info/models/common/network.dart';
import 'package:flutter_cell_info/models/wcdma/wcdma_band.dart';
import 'package:flutter_cell_info/models/wcdma/wcdma_signal.dart';

class Wcdma {
  BandWCDMA? bandWCDMA;
  SignalWCDMA? signalWCDMA;
  String? connectionStatus;
  Network? network;
  String? type;
  String? cgi;
  int? ci;
  int? lac;
  int? psc;
  int? cid;
  int? rnc;

  Wcdma(
      {this.bandWCDMA,
      this.signalWCDMA,
      this.connectionStatus,
      this.network,
      this.ci,
      this.lac,
      this.psc,
      this.cid,
      this.rnc,
      this.cgi,
      this.type});

  Wcdma.fromJson(Map<String, dynamic> json) {
    bandWCDMA = json['bandWCDMA'] != null
        ? new BandWCDMA.fromJson(json['bandWCDMA'])
        : null;
    signalWCDMA = json['signalWCDMA'] != null
        ? new SignalWCDMA.fromJson(json['signalWCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
    ci = json['ci'];
    lac = json['lac'];
    psc = json['psc'];
    cid = json['cid'];
    rnc = json['rnc'];
    cgi = json['cgi'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandWCDMA != null) {
      data['bandWCDMA'] = this.bandWCDMA!.toJson();
    }
    if (this.signalWCDMA != null) {
      data['signalWCDMA'] = this.signalWCDMA!.toJson();
    }
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network!.toJson();
    }
    data['type'] = this.type;
    data['ci'] = this.ci;
    data['lac'] = this.lac;
    data['psc'] = this.psc;
    data['cid'] = this.cid;
    data['rnc'] = this.rnc;
    data['cgi'] = this.cgi;
    return data;
  }
}
