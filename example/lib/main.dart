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
                    'Result ::\n $currentDBM \n primary = ${_cellsResponse?.primaryCellList?.length.toString()} \n neighbor = ${_cellsResponse?.neighboringCellList?.length}'),
              )
            : null,
      ),
    );
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    CellsResponse? cellsResponse;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      String? platformVersion = await CellInfo.getCellInfo;
      final body = json.decode(platformVersion!);

      cellsResponse = CellsResponse.fromJson(body);

      CellType currentCellInFirstChip = cellsResponse.primaryCellList![0];
      if (currentCellInFirstChip.type == "LTE") {
        currentDBM = "LTE dbm = ${currentCellInFirstChip.lte?.signalLTE?.dbm}";
      } else if (currentCellInFirstChip.type == "NR") {
        currentDBM = "NR dbm = ${currentCellInFirstChip.nr?.signalNR?.dbm}";
      } else if (currentCellInFirstChip.type == "WCDMA") {
        currentDBM =
            "WCDMA dbm = ${currentCellInFirstChip.wcdma?.signalWCDMA?.dbm}";

        print('currentDBM = ' + currentDBM!);
      }

      String? simInfo = await CellInfo.getSIMInfo;
      final simJson = json.decode(simInfo!);
      print("display name ${SIMInfoResponse.fromJson(simJson).simInfoList}");
    } on PlatformException {
      _cellsResponse = null;
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _cellsResponse = cellsResponse;
    });
  }

  @override
  void initState() {
    super.initState();
    startTimer();
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
