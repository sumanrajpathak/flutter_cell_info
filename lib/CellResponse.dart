import 'models/CellData.dart';
import 'models/common/cell_type.dart';

class CellsResponse {
  List<CellType>? neighboringCellList;
  List<CellType>? primaryCellList;
  List<CellDataList>? cellDataList;

  CellsResponse(
      {this.neighboringCellList, this.primaryCellList, this.cellDataList});

  CellsResponse.fromJson(Map<String, dynamic> json) {
    neighboringCellList = [];
    if (json['neighboringCellList'] != null) {
      json['neighboringCellList'].forEach((v) {
        neighboringCellList!.add(new CellType.fromJson(v));
      });
    }
    primaryCellList = [];
    if (json['primaryCellList'] != null) {
      json['primaryCellList'].forEach((v) {
        primaryCellList!.add(new CellType.fromJson(v));
      });
    }

    cellDataList = [];
    if (json['cellDataList'] != null) {
      json['cellDataList'].forEach((v) {
        cellDataList!.add(new CellDataList.fromJson(v));
      });
    }
  }

  CellsResponse.fromDynamic(dynamic json) {
    neighboringCellList = [];
    if (json['neighboringCellList'] != null) {
      json['neighboringCellList'].forEach((v) {
        neighboringCellList!.add(new CellType.fromJson(v));
      });
    }
    primaryCellList = [];
    if (json['primaryCellList'] != null) {
      json['primaryCellList'].forEach((v) {
        primaryCellList!.add(new CellType.fromJson(v));
      });
    }

    cellDataList = [];
    if (json['cellDataList'] != null) {
      json['cellDataList'].forEach((v) {
        cellDataList!.add(new CellDataList.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.neighboringCellList != null) {
      data['neighboringCellList'] =
          this.neighboringCellList!.map((v) => v.toJson()).toList();
    }
    if (this.primaryCellList != null) {
      data['primaryCellList'] =
          this.primaryCellList!.map((v) => v.toJson()).toList();
    }

    if (this.cellDataList != null) {
      data['cellDataList'] = this.cellDataList!.map((v) => v.toJson()).toList();
    }

    return data;
  }
}
