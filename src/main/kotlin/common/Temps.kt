package common

import Configs.mainJavaClass
import Configs.outputOrg
import Configs.outputProjectName
import Framework
import Jar
import OutputProject
import OutputProject.methodChannel

/**
 * 代码模板
 */
object Temps {
    object Dart {
        const val packageImport = """import 'dart:async';
import 'dart:typed_data';

import 'package:flutter/services.dart';
import 'package:$outputProjectName/$outputProjectName.dart';
"""

        const val classDeclaration = """import 'dart:typed_data';
import 'package:$outputProjectName/$outputProjectName.dart';
import 'package:flutter/services.dart';

// ignore_for_file: non_constant_identifier_names
class #__class_name__# {
  #__class_name__#.withRefId(this.refId);

  final int refId;
"""

        val methodChannel = """
  static final _channel = MethodChannel('${OutputProject.methodChannel}');
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

        const val interfaceMethodJsonable = """  
  #__modifier__#Future<#__return_type__#> #__name__#(#__formal_params__#) {
    final result = _channel.invokeMethod('#__class___#::#__method__#'#__separator__##__actual_params__#);
    return result;
  }
"""

        const val interfaceMethodRef = """  
  #__modifier__#Future<#__return_type__#> #__name__#(#__formal_params__#) async {
    final resultRefId = await _channel.invokeMethod('#__class_name__#::#__method_name__#'#__separator__##__actual_params__#);
    return #__return_type__#.withRefId(resultRefId);
  }
"""

        const val interfaceMethodRefList = """  
  #__modifier__#Future<#__return_type__#> #__name__#(#__formal_params__#) async {
    final resultRefIdList = await _channel.invokeMethod('#__class_name__#::#__method_name__#'#__separator__##__actual_params__#);
    return (resultRefIdList as List).map((it) => #__return_type__#.withRefId(it));
  }
"""

        const val toString = """
  @override
  String toString() {
    return JsonEncoder.withIndent('  ').convert(toJson());
  }
"""

        object AndroidView {
            val androidView = """import 'dart:convert';
import 'dart:typed_data';

import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';
import 'package:$outputProjectName/$outputProjectName.dart';

typedef void PlatformViewCreatedCallback(Android${OutputProject.classSimpleName}Controller controller);

class Android${OutputProject.classSimpleName} extends StatelessWidget {
  const Android${OutputProject.classSimpleName}({
    Key key,
    this.onViewCreated,
  }) : super(key: key);
  
  final PlatformViewCreatedCallback onViewCreated;
  
  @override
  Widget build(BuildContext context) {
    final gestureRecognizers = <Factory<OneSequenceGestureRecognizer>>[
      Factory<OneSequenceGestureRecognizer>(() => EagerGestureRecognizer()),
    ].toSet();

    final messageCodec = StandardMessageCodec();
    return AndroidView(
      viewType: '$methodChannel/${OutputProject.classSimpleName}',
      gestureRecognizers: gestureRecognizers,
      onPlatformViewCreated: _onViewCreated,
      creationParamsCodec: messageCodec,
    );
  }

  void _onViewCreated(int id) {
    final controller = Android${OutputProject.classSimpleName}Controller.withId(id);
    if (onViewCreated != null) {
      onViewCreated(controller);
    }
  }
}
"""
            val androidViewController = """
class Android${OutputProject.classSimpleName}Controller {
  final MethodChannel _channel;

  Android${OutputProject.classSimpleName}Controller.withId(int id)
      : _channel = MethodChannel('$methodChannel' + id.toString());
"""

            const val androidViewRef = """
class #__ref_class__# {
  #__ref_class__#.withRefId(this.refId, this._channel);
  
  final MethodChannel _channel;
  final int refId;
"""

            const val jsonInJsonOut = """
  Future<#__return_type__#> #__method_name__#(#__formal_params__#) {
    return _channel.invokeMethod('#__class_name__#::#__method_name__#'#__separator__##__actual_params__#);
  }
"""

            const val modelInModelOut = """
  Future<#__return_type__#> #__method_name__#(#__formal_params__#) async {
    final result = await _channel.invokeMapMethod<String, dynamic>('#__class_name__#::#__method_name__#'#__separator__##__actual_params__#);
    return #__return_type__#.fromJson(result);
  }
"""

            const val modelInRefOut = """
  Future<#__return_type__#> #__method_name__#(#__formal_params__#) async {
    final resultRefId = await _channel.invokeMethod('#__class_name__#::#__method_name__#'#__separator__##__actual_params__#);
    return #__return_type__#.withRefId(resultRefId, _channel);
  }
"""
        }

        const val uiKitView = """import 'dart:convert';

import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';

class Android#__uikit_view__# extends StatelessWidget {
  const Android#__uikit_view__#({
    Key key,
  }) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    final gestureRecognizers = <Factory<OneSequenceGestureRecognizer>>[
      Factory<OneSequenceGestureRecognizer>(() => EagerGestureRecognizer()),
    ].toSet();

    final messageCodec = StandardMessageCodec();
    return UiKitView(
      viewType: #__view_type__#,
      gestureRecognizers: gestureRecognizers,
      creationParamsCodec: messageCodec,
    );
  }
}
"""
        object ObjectCreator {
            const val classDeclare = """import 'package:flutter/services.dart';

import 'package:$outputProjectName/$outputProjectName.dart';

class ObjectCreator {
  static final _channel = MethodChannel('$outputOrg/ObjectCreator');"""

            const val creator = """
  static Future<#__class_name__#> create#__class_name__#(#__formal_params__#) async {
    final int refId = await _channel.invokeMethod('ObjectCreator::create#__class_name__#'#__separator__##__params__#);
    return #__class_name__#.withRefId(refId);
  }"""

            const val classDeclareEnd = """}"""
        }
    }

    object Kotlin {

        const val packageImport = """package $outputOrg.$outputProjectName

import $mainJavaClass

import com.fasterxml.jackson.databind.ObjectMapper

import android.content.Context
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
import io.flutter.plugin.platform.PlatformView
"""

        const val classDeclaration = """
class #__class_name__#Plugin : MethodCallHandler {

    private val mapper: objectMapper = objectMapper()
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
            val plugin = """package $outputOrg.$outputProjectName

import android.content.Context
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory
import io.flutter.plugin.common.PluginRegistry.Registrar

class ${OutputProject.classSimpleName}Plugin {
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            registrar
                    .platformViewRegistry()
                    .registerViewFactory("$methodChannel/${OutputProject.classSimpleName}", ${OutputProject.classSimpleName}Factory(registrar))
        }
    }
}"""

            val factory = """package $outputOrg.$outputProjectName

import android.content.Context
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory
import io.flutter.plugin.common.PluginRegistry.Registrar

class ${OutputProject.classSimpleName}Factory(private val registrar: Registrar) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {

    override fun create(context: Context, id: Int, params: Any?): PlatformView {
        return ${OutputProject.classSimpleName}(context, id, registrar)
    }
}"""

            val classDeclaration = """
class ${OutputProject.classSimpleName}(id: Int, registrar: Registrar) : PlatformView, MethodCallHandler {
"""

            val channel = """
    private val methodChannel = MethodChannel(registrar.messenger(), "$methodChannel" + id)
    private val view = ${Jar.Decompiled.mainClassSimpleName}(registrar.activity())
    private val REF_MAP = mutableMapOf<Int, Any>()
    private val mapper: ObjectMapper = ObjectMapper()

    init {
        methodChannel.setMethodCallHandler(this)
    }
"""

            const val methodBranchHeader = """
            "#__class_name__#::#__method_name__#" -> {#__local_params__#"""

            const val staticReturnJsonable = """
                        val result = #__class_name__#.#__method_name__#(#__params__#)
                
                        methodResult.success(result)"""

            const val staticReturnVoid = """
                        #__class_name__#.#__method_name__#(#__params__#)
                
                        methodResult.success("success")"""

            const val staticReturnRef = """
                        val result = #__class_name__#.#__method_name__#(#__params__#)
                
                        val returnRefId = result.hashCode()
                        REF_MAP[returnRefId] = result
                
                        methodResult.success(returnRefId)"""

            const val viewReturnModel = """
                        val result = view.#__method_name__#(#__params__#)
                
                        methodResult.success(#__result__#)"""

            const val viewReturnRef = """
                        val result = view.#__method_name__#(#__params__#)
                
                        val returnRefId = result.hashCode()
                        REF_MAP[returnRefId] = result
                
                        methodResult.success(returnRefId)"""

            const val viewReturnVoid = """
                        view.#__method_name__#(#__params__#)
                
                        methodResult.success("success")"""

            const val refReturnRef = """
                        val refId = args["refId"] as Int
                        val ref = REF_MAP[refId] as #__class_name__#
                        
                        val result = ref.#__method_name__#(#__params__#)
                        
                        val returnRefId = result.hashCode()
                        REF_MAP[returnRefId] = result
                        
                        methodResult.success(returnRefId)"""

            const val callback = """
                        val refId = args["refId"] as Int
                        val ref = REF_MAP[refId] as #__class_name__#
                        
                        val result = ref.#__method_name__#(#__params__#)
                        
                        val returnRefId = result.hashCode()
                        REF_MAP[returnRefId] = result
                        
                        methodResult.success(returnRefId)"""

            const val refReturnJsonable = """
                        val refId = args["refId"] as Int
                        val ref = REF_MAP[refId] as #__class_name__#

                        val result = ref.#__method_name__#(#__params__#)

                        methodResult.success(result)"""

            const val refReturnVoid = """
                        val refId = args["refId"] as Int
                        val ref = REF_MAP[refId] as #__class_name__#
                        
                        ref.#__method_name__#(#__params__#)
                        
                        methodResult.success("success")"""

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