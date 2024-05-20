import 'dart:async';

import 'package:flutter/services.dart';
/// A class that provides information about the cell.
class CellInfo {
  /// Returns a JSON string containing information about the cell.
  static const MethodChannel _channel = const MethodChannel('cell_info');
  /// Returns a JSON string containing information about the cell.
  static Future<String?> get getCellInfo async {
    final String? version = await _channel.invokeMethod('cell_info');
    return version;
  }
  /// Returns a JSON string containing information about the SIM card.
  static const MethodChannel _sim_info = const MethodChannel('sim_info');
  /// Returns a JSON string containing information about the SIM card.
  static Future<String?> get getSIMInfo async {
    final String? version = await _sim_info.invokeMethod('sim_info');
    return version;
  }
  /// Returns a JSON string containing information about the shared preference.
  static const MethodChannel _shared_preference =
      const MethodChannel('shared_preference');
  /// Returns a JSON string containing information about the shared preference.
  static Future<String?> get sharedPreference async {
    final String? version =
        await _shared_preference.invokeMethod('shared_preference');
    return version;
  }
}
