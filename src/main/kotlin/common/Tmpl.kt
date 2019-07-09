package common

import Configs.outputOrg
import Configs.outputProjectName
import Framework
import OutputProject
import Project
import common.extensions.file

val tmplDir = "${Project.path}/src/main/resources/tmpl"

/**
 * 代码模板
 */
object Tmpl {
    object Dart {

        val classBuilder by lazy { "$tmplDir/dart/class.dart.tmpl".file().readText() }

        val enumBuilder by lazy { "$tmplDir/dart/enum.dart.tmpl".file().readText() }

        val callbackBuilder by lazy { "$tmplDir/dart/callback.stmt.dart.tmpl".file().readText() }

        val callbackCaseBuilder by lazy { "$tmplDir/dart/callback_case.stmt.dart.tmpl".file().readText() }

        val androidViewBuilder by lazy { "$tmplDir/dart/android_view.dart.tmpl".file().readText() }

        val methodBuilder by lazy { "$tmplDir/dart/method.mtd.dart.tmpl".file().readText() }

        val getterBuilder by lazy { "$tmplDir/dart/getter.mtd.dart.tmpl".file().readText() }

        val setterBuilder by lazy { "$tmplDir/dart/setter.mtd.dart.tmpl".file().readText() }

        val systemRefBuilder by lazy { "$tmplDir/dart/system_ref.dart.tmpl".file().readText() }

        val objectCreatorBuilder by lazy { "$tmplDir/dart/object_creator.dart.tmpl".file().readText() }

        val createObjectMethodBuilder by lazy { "$tmplDir/dart/create_object.mtd.dart.tmpl".file().readText() }

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

        val pluginBuilder by lazy { "$tmplDir/kotlin/plugin.kt.tmpl".file().readText() }

        val platformViewRegisterBuilder by lazy { "$tmplDir/kotlin/platform_view_register.stmt.kt.tmpl".file().readText() }

        val platformViewFactoryBuilder by lazy { "$tmplDir/kotlin/platform_view_factory.kt.tmpl".file().readText() }

        val setterBuilder by lazy { "$tmplDir/kotlin/setter.mtd.kt.tmpl".file().readText() }

        val getterBuilder by lazy { "$tmplDir/kotlin/getter.mtd.kt.tmpl".file().readText() }

        val branchBuilder by lazy { "$tmplDir/kotlin/branch.stmt.kt.tmpl".file().readText() }

        val handlerMethodBuilder by lazy { "$tmplDir/kotlin/handler_method.mtd.kt.tmpl".file().readText() }

        val jsonableArgBuilder by lazy { "$tmplDir/kotlin/jsonable_arg.mtd.kt.tmpl".file().readText() }

        val enumArgBuilder by lazy { "$tmplDir/kotlin/enum_arg.mtd.kt.tmpl".file().readText() }

        val refArgBuilder by lazy { "$tmplDir/kotlin/ref_arg.mtd.kt.tmpl".file().readText() }

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