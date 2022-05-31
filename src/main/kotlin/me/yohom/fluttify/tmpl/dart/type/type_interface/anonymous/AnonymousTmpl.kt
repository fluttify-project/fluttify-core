package me.yohom.fluttify.tmpl.dart.type.type_interface.anonymous

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_lambda.CallbackCaseLambdaTmpl

//static Future<#__class_name__#> anonymous__() async {
//  final __result__ = await k#__project_prefix__#Channel.invokeMethod('#__channel_prefix__#::createAnonymous__');
//
//  final __object__ = #__project_prefix__##__platform__#As<#__class_name__#>(__result__)!;
//
//  // handle callback
//  MethodChannel('#__channel_prefix__#::Callback@${__object__.refId}', k#__project_prefix__#MethodCodec)
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
    val callbackCases = type.methods
        .filterNot { it.formalParams.any { it.variable.isLambda() } }
        .map { CallbackCaseLambdaTmpl(it, "__object__.${it.signature}?.call") }
        .joinToStringX("\n")
    return tmpl
        .replace("#__class_name__#", type.name.toDartType())
        .replace("#__channel_prefix__#", type.name.replace("$", "."))
        .replaceParagraph("#__cases__#", callbackCases)
        .replaceGlobal(platform = type.platform)
}