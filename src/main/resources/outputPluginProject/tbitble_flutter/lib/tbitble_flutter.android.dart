import 'dart:async';

import 'package:flutter/services.dart';

class TbitbleFlutterAndroid {
  static final _channel = MethodChannel('com.tbit.tbitblesdk/TbitBle');

  static Future<void> unSetListener() {
    return _channel.invokeMethod('unSetListener');
  }

  static Future<void> connect(String macAddr, String key) {
    return _channel.invokeMethod('connect', {"macAddr": macAddr, "key": key});
  }

  static Future<void> stopScan() {
    return _channel.invokeMethod('stopScan');
  }

  static Future<void> unlock() {
    return _channel.invokeMethod('unlock');
  }

  static Future<void> lock() {
    return _channel.invokeMethod('lock');
  }

  static Future<void> update() {
    return _channel.invokeMethod('update');
  }

  static Future<void> reconnect() {
    return _channel.invokeMethod('reconnect');
  }

  static Future<int> getBleConnectionState() {
    return _channel.invokeMethod('getBleConnectionState');
  }

  static Future<bool> isConnected() {
    return _channel.invokeMethod('isConnected');
  }

  static Future<void> disConnect() {
    return _channel.invokeMethod('disConnect');
  }

  static Future<void> destroy() {
    return _channel.invokeMethod('destroy');
  }

  static Future<void> cancelAllCommand() {
    return _channel.invokeMethod('cancelAllCommand');
  }

  static Future<bool> atLeastConnectedOnce() {
    return _channel.invokeMethod('atLeastConnectedOnce');
  }

  static Future<bool> hasInitialized() {
    return _channel.invokeMethod('hasInitialized');
  }
}