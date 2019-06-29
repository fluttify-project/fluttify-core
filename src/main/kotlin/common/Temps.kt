package common

import Configs.outputOrg
import Configs.outputProjectName
import Framework
import OutputProject

/**
 * 代码模板
 */
object Temps {
    object Dart {

        const val classDeclaration = """import 'dart:typed_data';
import 'package:$outputProjectName/$outputProjectName.dart';
import 'package:flutter/services.dart';

// ignore_for_file: non_constant_identifier_names, camel_case_types
class #__class_name__# {
  #__class_name__#.withRefId(this.refId);

  final int refId;
"""

        val methodChannel = """
  static final _channel = MethodChannel('${OutputProject.methodChannel}');
"""

        const val classEnd = "}"

        const val getter = """
            Future<#__class_name__#> get#__field__#() {
                
            }
        """

        const val setter = """
            Future<void> set#__field__#() {
                
            }
        """

        const val toString = """
  @override
  String toString() {
    return JsonEncoder.withIndent('  ').convert(toJson());
  }
"""

        object AndroidView {
            const val androidView = """import 'dart:convert';
import 'dart:typed_data';

import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';
import 'package:$outputProjectName/$outputProjectName.dart';

typedef void PlatformViewCreatedCallback(#__view__# controller);

class #__view__#_Android extends StatelessWidget {
  const #__view__#_Android({
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
      viewType: '$outputOrg/#__view__#',
      gestureRecognizers: gestureRecognizers,
      onPlatformViewCreated: _onViewCreated,
      creationParamsCodec: messageCodec,
    );
  }

  void _onViewCreated(int id) {
    final controller = #__view__#.withRefId(id);
    if (onViewCreated != null) {
      onViewCreated(controller);
    }
  }
}
"""

        }

        const val uiKitView = """import 'dart:convert';

import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';

class #__uikit_view__# extends StatelessWidget {
  const #__uikit_view__#({
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

        const val classDeclaration = """
@Suppress("FunctionName", "UsePropertyAccessSyntax", "RedundantUnitReturnType", "UNUSED_PARAMETER")
class #__class_name__#Plugin : MethodCallHandler {

    private val mapper: objectMapper = objectMapper()
"""

        const val whenElse = """
                    else -> methodResult.notImplemented()"""

        const val getter = """
                    else -> methodResult.notImplemented()"""

        const val setter = """
                    else -> methodResult.notImplemented()"""

        object PlatformView {

            const val factory = """package $outputOrg.$outputProjectName

import android.content.Context
import android.view.View

import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory
import io.flutter.plugin.common.PluginRegistry.Registrar

class #__view__#Factory(private val registrar: Registrar) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {

    override fun create(context: Context, id: Int, params: Any?): PlatformView {
        return object : PlatformView {
            private val view = #__view__#(registrar.activity())

            override fun getView(): View = view.apply { REF_MAP[id] = this }

            override fun dispose() {
                REF_MAP.remove(id)
            }
        }
    }
}"""

            val classDeclaration = """
class ${OutputProject.classSimpleName}(id: Int, registrar: Registrar) : PlatformView, MethodCallHandler {
"""

            const val methodBranchHeader = """
                    "#__class_name__#::#__method_name__#" -> {
                        #__handler__#
                    }"""

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

            const val refReturnRef = """
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