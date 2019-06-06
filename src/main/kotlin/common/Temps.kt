package common

import Configs.mainJavaClass
import preprocess.Framework

/**
 * 代码模板
 */
object Temps {
    object Dart {
        const val packageImport = """import 'dart:async';

import 'package:flutter/services.dart';
"""

        const val classDeclaration = """
class #__plugin_class_simple_name__# {
"""

        const val methodChannel = """
  static final _channel = MethodChannel('#__methodChannelName__#');
"""

        const val invokeMethod = """
  static Future<#__return_type__#> #__method_name__#(#__formal_params__#) {
    return _channel.invokeMethod('#__method_name__#'#__separator__##__actual_params__#);
  }
"""

        const val classEnd = "}"

        const val field = """
  #__type__# #__name__# = #__value__#;"""

        const val method = """
  #__return_type__# #__name__#(#__formal_params__#) {
#__body__#  }
"""
    }

    object Kotlin {

        const val packageImport = """package #__package_name__#

import $mainJavaClass

import com.fasterxml.jackson.databind.ObjectMapper

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
"""

        const val classDeclaration = """
class #__class_name__#Plugin : MethodCallHandler {

    private val mapper: ObjectMapper = ObjectMapper()
"""

        const val companionObject = """
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "#__method_channel__#")
            channel.setMethodCallHandler(#__plugin_class_simple_name__#Plugin())
        }
    }
"""

        const val onMethodCall = """
    override fun onMethodCall(methodCall: MethodCall, methodResult: Result) {
        val args = methodCall.arguments as Map<String, *>
        when (methodCall.method) {"""

        const val methodResult = """
            "#__method_name__#" -> {#__local_params__#
                val result = #__java_class_simple_name__#.#__method_name__#(#__params__#)

                methodResult.success(#__result__#)
            }"""

        const val whenElse = """
            else -> methodResult.notImplemented()"""

        const val classEnd = """
        }
    }
}
"""
    }

    object Swift {
        val packageImport = """import Flutter
import UIKit
import ${Framework.name}
"""

        const val classDeclaration = """
public class Swift#__class_name__#Plugin : NSObject, FlutterPlugin {"""

        const val register = """
    public static func register(with registrar: FlutterPluginRegistrar) {
        let channel = FlutterMethodChannel(name: "#__method_channel_name__#", binaryMessenger: registrar.messenger())
        let instance = Swift#__plugin_class_simple_name__#Plugin()
        registrar.addMethodCallDelegate(instance, channel: channel)
    }
"""

        const val onMethodCall = """
    public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        let args = call.arguments as! Dictionary<String, Any>
        switch call.method {"""

        const val invokeResult = """
        case "#__method_name__#": result(#__main_objc_class__#.#__method_name__#(#__params__#))"""

        const val switchDefault = """
        default:
            result(FlutterMethodNotImplemented)"""

        const val classEnd = "\n\n\n}\n\n}\n}"
    }
}