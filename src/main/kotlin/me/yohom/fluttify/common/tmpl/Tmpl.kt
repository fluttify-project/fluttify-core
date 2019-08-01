package me.yohom.fluttify.common.tmpl

import me.yohom.fluttify.FluttifyCorePluginExtension.outputOrg
import me.yohom.fluttify.FluttifyCorePluginExtension.outputProjectName
import me.yohom.fluttify.FluttifyProject
import me.yohom.fluttify.common.extensions.file

val tmplDir = "${FluttifyProject.path}/src/main/resources/tmpl"

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

        val uikitViewBuilder by lazy { "$tmplDir/dart/uikit_view.dart.tmpl".file().readText() }

        val methodBuilder by lazy { "$tmplDir/dart/method.mtd.dart.tmpl".file().readText() }

        val getterBuilder by lazy { "$tmplDir/dart/getter.mtd.dart.tmpl".file().readText() }

        val setterBuilder by lazy { "$tmplDir/dart/setter.mtd.dart.tmpl".file().readText() }

        val systemRefBuilder by lazy { "$tmplDir/dart/system_ref.dart.tmpl".file().readText() }

        val objectCreatorBuilder by lazy { "$tmplDir/dart/object_factory.dart.tmpl".file().readText() }

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

        val platformViewRegisterBuilder by lazy { "$tmplDir/kotlin/register_platform_view.stmt.kt.tmpl".file().readText() }

        val platformViewFactoryBuilder by lazy { "$tmplDir/kotlin/platform_view_factory.kt.tmpl".file().readText() }

        val setterBuilder by lazy { "$tmplDir/kotlin/setter.mtd.kt.tmpl".file().readText() }

        val getterBuilder by lazy { "$tmplDir/kotlin/getter.mtd.kt.tmpl".file().readText() }

        val branchBuilder by lazy { "$tmplDir/kotlin/branch.stmt.kt.tmpl".file().readText() }

        val handlerMethodBuilder by lazy { "$tmplDir/kotlin/handler_method.mtd.kt.tmpl".file().readText() }

        val jsonableArgBuilder by lazy { "$tmplDir/kotlin/jsonable_arg.mtd.kt.tmpl".file().readText() }

        val enumArgBuilder by lazy { "$tmplDir/kotlin/enum_arg.mtd.kt.tmpl".file().readText() }

        val refArgBuilder by lazy { "$tmplDir/kotlin/ref_arg.mtd.kt.tmpl".file().readText() }

        object PlatformView {

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

        val pluginBuilder by lazy { "$tmplDir/swift/plugin.swift.tmpl".file().readText() }

        val platformViewRegisterBuilder by lazy { "$tmplDir/swift/platform_view_register.stmt.swift.tmpl".file().readText() }

        val platformViewFactoryBuilder by lazy { "$tmplDir/swift/platform_view_factory.swift.tmpl".file().readText() }

        val setterBuilder by lazy { "$tmplDir/swift/setter.mtd.swift.tmpl".file().readText() }

        val getterBuilder by lazy { "$tmplDir/swift/getter.mtd.swift.tmpl".file().readText() }

        val branchBuilder by lazy { "$tmplDir/swift/branch.stmt.swift.tmpl".file().readText() }

        val handlerMethodBuilder by lazy { "$tmplDir/swift/handler_method.mtd.swift.tmpl".file().readText() }

        val jsonableArgBuilder by lazy { "$tmplDir/swift/jsonable_arg.mtd.swift.tmpl".file().readText() }

        val enumArgBuilder by lazy { "$tmplDir/swift/enum_arg.mtd.swift.tmpl".file().readText() }

        val refArgBuilder by lazy { "$tmplDir/swift/ref_arg.mtd.swift.tmpl".file().readText() }

        object PlatformView {

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
}