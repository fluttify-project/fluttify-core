package common

import Configs
import Configs.mainJavaClass
import Framework
import Jar

/**
 * 代码模板
 */
object Temps {
    object Dart {
        const val packageImport = """import 'dart:async';

import 'package:flutter/services.dart';
"""

        val classDeclaration = """import 'dart:typed_data';
import 'package:${Configs.outputProjectName}/${Configs.outputProjectName}.dart';

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

        const val invokeModelMethod = """
  static Future<#__return_type__#> #__method_name__#(#__formal_params__#) async {
    final result = await _channel.invokeMapMethod<String, dynamic>('#__method_name__#'#__separator__##__actual_params__#);
    return #__return_type__#.fromJson(result);
  }
"""

        const val classEnd = "}"

        const val field = """
  #__type__# #__name__# = #__value__#;"""

        const val method = """
  #__return_type__# #__name__#(#__formal_params__#) {
#__body__#  }
"""
        const val fromJson = """
  static #__class_name__# fromJson(Map<String, dynamic> json) {
    final bean = #__class_name__#();#__content__#
    return bean;
  }
"""
        const val toJson = """
  Map<String, dynamic> toJson() {
    return {#__content__#
    }..removeWhere((key, value) => value == null);
  }
"""
        const val toString = """
  @override
  String toString() {
    return JsonEncoder.withIndent('  ').convert(toJson());
  }
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
        val args = methodCall.arguments as? Map<String, *> ?: mapOf<String, Any>()
        when (methodCall.method) {"""

        const val methodBranch = """
            "#__method_name__#" -> {#__local_params__#
                val result = #__java_class_simple_name__#.#__method_name__#(#__params__#)

                methodResult.success(#__result__#)
            }"""

        const val whenElse = """
            else -> methodResult.notImplemented()
        }"""

        const val classEnd = """
    }
}
"""

        object PlatformView {
            const val plugin = """package #__package__#

import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory
import io.flutter.plugin.common.PluginRegistry.Registrar

class #__name__#Plugin {
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            registrar
                    .platformViewRegistry()
                    .registerViewFactory("#__package__#/#__view__#", #__view__#Factory(registrar))
        }
    }
}"""

            const val factory = """package #__package__#

import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory
import io.flutter.plugin.common.PluginRegistry.Registrar

class #__view__#Factory(private val registrar: Registrar) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {

    override fun create(context: Context, id: Int, params: Any?): PlatformView {
        return #__view__#(context, id, registrar)
    }
}"""

            const val classDeclaration = """
class #__view__#(context: Context, private val id: Int, private val registrar: Registrar) : PlatformView, MethodCallHandler {
"""

            val channel = """
    private val methodChannel = MethodChannel(registrar.messenger(), "#__package__#" + id)
    private val view = ${Jar.Decompiled.mainClassSimpleName}(context)

    init {
        methodChannel.setMethodCallHandler(this)
    }
"""

            const val methodBranch = """
            "#__method_name__#" -> {#__local_params__#
                val result = view.#__method_name__#(#__params__#)

                methodResult.success(#__result__#)
            }"""

            const val getViewDispose = """
    override fun getView(): View = view

    override fun dispose() {
        methodChannel.invokeMethod("dispose", null)
    }
"""
        }
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

        const val classEnd = "\n\t\t}\n\t}\n}"
    }
}