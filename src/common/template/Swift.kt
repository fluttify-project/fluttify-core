package common.template

const val swiftPackageImportTemp = """import Flutter
import UIKit
"""

const val swiftClassDeclarationTemp  = """
class Swift#__class_name__#Plugin : NSObject, FlutterPlugin {
"""

const val registerTemp = """
    public static func register(with registrar: FlutterPluginRegistrar) {
        let channel = FlutterMethodChannel(name: "#__method_channel_name__#", binaryMessenger: registrar.messenger())
        let instance = Swift#__plugin_class_simple_name__#Plugin()
        registrar.addMethodCallDelegate(instance, channel: channel)
    }
"""

const val swiftOnMethodCall = """
    public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        let args = call.arguments as! Dictionary<String, Any>
        switch call.method {"""

const val swiftInvokeResultTemp = """
            case "#__method_name__#": result(#__main_objc_class__#.#__method_name__#(#__params__#))"""

const val swiftClassEnd = """
         }
    }
}"""