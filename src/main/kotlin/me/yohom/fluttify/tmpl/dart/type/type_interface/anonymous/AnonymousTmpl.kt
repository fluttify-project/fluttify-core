package me.yohom.fluttify.tmpl.dart.type.type_interface.anonymous

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_lambda.CallbackCaseLambdaTmpl

//static Future<#__class_name__#> anonymous__(#__formal_params__#) async {
//  final __result__ = await k#__project_prefix__#Channel.invokeMethod('#__class_name__#::createAnonymous');
//
//  final __object__ = #__project_prefix__##__platform__#As<#__class_name__#>(__result__);
//
//  // handle callback
//  MethodChannel('#__class_name__#::createAnonymous_callback_${__object__.refId}', k#__project_name__#MethodCodec)
//      .setMethodCallHandler((methodCall) async {
//        try {
//          final args = methodCall.arguments as Map;
//          switch (methodCall.method) {
//            #__cases__#
//            default:
//              throw MissingPluginException('方法${methodCall.method}未实现');
//              break;
//          }
//        } catch (e) {
//          debugPrint(e.toString());
//          rethrow;
//        }
//      });
//
//  return __object__;
//}
private val tmpl by lazy { getResource("/tmpl/dart/anonymous.mtd.dart.tmpl").readText() }

fun AnonymousTmpl(type: Type): String {
    val formalParams = type.methods
        .map {
            val returnType = it.returnType.toDartType()
            val formalParams = it.formalParams.joinToString(", ") { it.variable.toDartString(true) }
            "$returnType Function(${formalParams})? ${it.name}"
        }
        .joinToStringX(", ", "{", "}")
    val callbackCases = type.methods
        .map { CallbackCaseLambdaTmpl(it.asType(), "${it.name}?.call") }
        .joinToStringX("\n")
    return tmpl
        .replace("#__class_name__#", type.name.toDartType())
        .replace("#__formal_params__#", formalParams)
        .replaceParagraph("#__cases__#", callbackCases)
        .replaceGlobal(platform = type.platform)
}