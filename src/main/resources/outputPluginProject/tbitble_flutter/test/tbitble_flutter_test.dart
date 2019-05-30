import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:tbitble_flutter/tbitble_flutter.dart';

void main() {
  const MethodChannel channel = MethodChannel('tbitble_flutter');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await TbitbleFlutter.platformVersion, '42');
  });
}
