import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_cell_info/flutter_cell_info.dart';

void main() {
  const MethodChannel channel = MethodChannel('cell_info');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    TestDefaultBinaryMessengerBinding.instance.defaultBinaryMessenger
        .setMockMethodCallHandler(channel, (MethodCall methodCall) {
      return Future(() => "42");
    });
  });

  tearDown(() {
    TestDefaultBinaryMessengerBinding.instance.defaultBinaryMessenger
        .setMockMethodCallHandler(channel, (MethodCall methodCall) {
      return null;
    });
  });

  test('getPlatformVersion', () async {
    expect(await CellInfo.getCellInfo, '42');
  });
}
