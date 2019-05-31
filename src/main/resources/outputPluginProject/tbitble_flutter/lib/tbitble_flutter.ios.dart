import 'dart:async';

import 'package:flutter/services.dart';

class TbitbleFlutterIOS {
  static final _channel = MethodChannel('com.tbit.tbitblesdk/TbitBle');

  static Future<void> disConnectWithCommand() {
    return _channel.invokeMethod('disConnectWithCommand');
  }

  static Future<void> disConnect() {
    return _channel.invokeMethod('disConnect');
  }

  static Future<void> stopScan() {
    return _channel.invokeMethod('stopScan');
  }
}