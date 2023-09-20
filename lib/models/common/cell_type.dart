import 'package:flutter_cell_info/models/cdma/cdma_parameters.dart';
import 'package:flutter_cell_info/models/gsm/gms_parameters.dart';
import 'package:flutter_cell_info/models/lte/lte_parameters.dart';
import 'package:flutter_cell_info/models/nr/nr_parameters.dart';
import 'package:flutter_cell_info/models/tds_cdma/tds_cdma_parameters.dart';
import 'package:flutter_cell_info/models/wcdma/wcdma_parameters.dart';

class CellType {
  String? type;
  Wcdma? wcdma;
  Nr? nr;
  Lte? lte;
  Gsm? gsm;
  Tdscdma? tdscdma;
  Cdma? cdma;

  CellType(
      {this.type,
      this.wcdma,
      this.nr,
      this.lte,
      this.gsm,
      this.tdscdma,
      this.cdma});

  CellType.fromJson(Map<String, dynamic> json) {
    type = json['type'];
    wcdma = json['wcdma'] != null ? new Wcdma.fromJson(json['wcdma']) : null;
    nr = json['nr'] != null ? new Nr.fromJson(json['nr']) : null;
    lte = json['lte'] != null ? new Lte.fromJson(json['lte']) : null;
    gsm = json['gsm'] != null ? new Gsm.fromJson(json['gsm']) : null;
    tdscdma =
        json['tdscdma'] != null ? new Tdscdma.fromJson(json['tdscdma']) : null;
    cdma = json['cdma'] != null ? new Cdma.fromJson(json['cdma']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['type'] = this.type;
    if (this.wcdma != null) {
      data['wcdma'] = this.wcdma!.toJson();
    }
    if (this.nr != null) {
      data['nr'] = this.nr!.toJson();
    }
    if (this.lte != null) {
      data['lte'] = this.lte!.toJson();
    }
    if (this.gsm != null) {
      data['gsm'] = this.gsm!.toJson();
    }
    if (this.tdscdma != null) {
      data['tdscdma'] = this.tdscdma!.toJson();
    }
    if (this.cdma != null) {
      data['cdma'] = this.cdma!.toJson();
    }
    return data;
  }
}
