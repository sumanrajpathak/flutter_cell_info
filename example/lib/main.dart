import 'dart:async';
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_cell_info/cell_response.dart';
import 'package:flutter_cell_info/flutter_cell_info.dart';
import 'package:flutter_cell_info/models/common/cell_type.dart';
import 'package:flutter_cell_info/sim_info_response.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  CellsResponse? _cellsResponse;

  String? currentDBM;
  String? simInfoText;

  Timer? timer;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: _cellsResponse != null
            ? Center(
                child: Text(
                    'Result ::\n $currentDBM \n primary = ${_cellsResponse?.primaryCellList?.length.toString()} \n neighbor = ${_cellsResponse?.neighboringCellList?.length} \n\n SIM ::\n ${simInfoText ?? '-'}'),
              )
            : null,
      ),
    );
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    CellsResponse? cellsResponse;
    String? dbm;
    String? sim;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      String? cellInfo = await CellInfo.getCellInfo;
      final body = json.decode(cellInfo!);

      cellsResponse = CellsResponse.fromJson(body);

      // The primary cell list can be empty — e.g. on the iOS Simulator, in
      // airplane mode, or with no SIM — so guard before indexing.
      final primaryList = cellsResponse.primaryCellList;
      if (primaryList != null && primaryList.isNotEmpty) {
        dbm = _dbmFor(primaryList.first);
      } else {
        dbm = "No serving cell reported "
            "(expected on iOS Simulator / no SIM / airplane mode)";
      }

      // Carrier / SIM info — this is the part that returns real data on iOS.
      String? simInfo = await CellInfo.getSIMInfo;
      final simResponse = SIMInfoResponse.fromJson(json.decode(simInfo!));
      sim = _formatSimInfo(simResponse);
      print("SIM info: $sim");
    } on PlatformException {
      cellsResponse = null;
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _cellsResponse = cellsResponse;
      currentDBM = dbm;
      simInfoText = sim;
    });
  }

  // Extracts a human-readable signal value for the serving cell. Signal
  // strength is unavailable on iOS, so these will read as `null` there.
  String _dbmFor(CellType cell) {
    switch (cell.type) {
      case "NR":
        return "NR dbm = ${cell.nr?.signalNR?.dbm}";
      case "LTE":
        return "LTE dbm = ${cell.lte?.signalLTE?.dbm}";
      case "WCDMA":
        return "WCDMA dbm = ${cell.wcdma?.signalWCDMA?.dbm}";
      case "GSM":
        return "GSM dbm = ${cell.gsm?.signalGSM?.dbm}";
      case "CDMA":
        return "CDMA dbm = ${cell.cdma?.signalCDMA?.dbm}";
      case "TDSCDMA":
        return "TDSCDMA dbm = ${cell.tdscdma?.signalTDSCDMA?.dbm}";
      default:
        return "Unknown cell type: ${cell.type}";
    }
  }

  String _formatSimInfo(SIMInfoResponse response) {
    final sims = response.simInfoList;
    if (sims == null || sims.isEmpty) {
      return "No SIM info available";
    }
    return sims
        .map((s) =>
            "${s.carrierName ?? '-'} (mcc ${s.mcc ?? '-'}, mnc ${s.mnc ?? '-'})")
        .join("\n ");
  }

  @override
  void initState() {
    super.initState();
    startTimer();
  }

  @override
  void dispose() {
    timer?.cancel();
    super.dispose();
  }

  void startTimer() {
    const oneSec = const Duration(seconds: 3);
    timer = new Timer.periodic(
      oneSec,
      (Timer timer) {
        initPlatformState();
      },
    );
  }
}
