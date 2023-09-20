import 'dart:async';

import 'package:flutter/services.dart';

class CellInfo {
  static const MethodChannel _channel = const MethodChannel('cell_info');

  static Future<String?> get getCellInfo async {
    final String? version = await _channel.invokeMethod('cell_info');
    return version;
  }

  static const MethodChannel _sim_info = const MethodChannel('sim_info');

  static Future<String?> get getSIMInfo async {
    final String? version = await _sim_info.invokeMethod('sim_info');
    return version;
  }

  static const MethodChannel _shared_preference = const MethodChannel('shared_preference');

  static Future<String?> get sharedPreference async {
    final String? version = await _shared_preference.invokeMethod('shared_preference');
    return version;
  }
}
