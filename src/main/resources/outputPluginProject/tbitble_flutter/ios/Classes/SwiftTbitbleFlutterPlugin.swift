import Flutter
import UIKit
import Tbit

public class SwiftTbitbleFlutterPlugin : NSObject, FlutterPlugin {
    public static func register(with registrar: FlutterPluginRegistrar) {
        let channel = FlutterMethodChannel(name: "com.tbit.tbitblesdk/TbitBle", binaryMessenger: registrar.messenger())
        let instance = SwiftTbitbleFlutterPlugin()
        registrar.addMethodCallDelegate(instance, channel: channel)
    }

    public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        let args = call.arguments as! Dictionary<String, Any>
        switch call.method {
        default:
            result(FlutterMethodNotImplemented)
        }
    }
}