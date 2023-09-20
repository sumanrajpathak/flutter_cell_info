import 'package:flutter_cell_info/models/common/network.dart';
import 'gsm_band.dart';
import 'gsm_signal.dart';

class Gsm {
  BandGSM? bandGSM;
  SignalGSM? signalGSM;
  String? connectionStatus;
  Network? network;
  String? type;
  int? cid;
  int? lac;
  int? bsic;
  int? ncc;
  int? bcc;
  String? cgi;

  Gsm({
    this.bandGSM,
    this.signalGSM,
    this.connectionStatus,
    this.network,
    this.type,
    this.cid,
    this.lac,
    this.bsic,
    this.ncc,
    this.bcc,
    this.cgi,
  });

  Gsm.fromJson(Map<String, dynamic> json) {
    bandGSM =
        json['bandGSM'] != null ? new BandGSM.fromJson(json['bandGSM']) : null;
    signalGSM = json['signalGSM'] != null
        ? new SignalGSM.fromJson(json['signalGSM'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
    cid = json['cid'];
    lac = json['lac'];
    bsic = json['bsic'];
    ncc = json['ncc'];
    bcc = json['bcc'];
    cgi = json['cgi'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandGSM != null) {
      data['bandGSM'] = this.bandGSM!.toJson();
    }
    if (this.signalGSM != null) {
      data['signalGSM'] = this.signalGSM!.toJson();
    }
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network!.toJson();
    }
    data['type'] = this.type;
    data['cid'] = this.cid;
    data['bsic'] = this.bsic;
    data['lac'] = this.lac;
    data['ncc'] = this.ncc;
    data['bcc'] = this.bcc;
    data['cgi '] = this.cgi;
    return data;
  }
}
