package me.yohom.fluttify.tmpl.dart.type.type_sdk.method

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.dart.type.common.`return`.ReturnTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.dart.type.common.log.LogTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_method.CallbackMethodTmpl

//#__deprecated__#
//#__static__#Future<#__return_type__#> #__method_name__#(#__formal_params__#) async {
//  // print log
//  if (fluttifyLogEnabled) {
//    #__log__#
//  }
//
//  // invoke native method
//  #__invoke__#
//
//  // handle native call
//  #__callback__#
//
//  return #__return_statement__#;
//}
private val tmpl by lazy { getResource("/tmpl/dart/method.mtd.dart.tmpl").readText() }

fun MethodTmpl(method: Method): String {
    val static = if (method.isStatic) "static " else ""
    val returnType = method.returnType.toDartType()
    val methodName = method.signature

    // 方法声明内的参数一律保留, 只有在传参的时候过滤掉lambda
    val formalParams = method
        .formalParams
        .joinToString { it.variable.toDartString() }
    val log = LogTmpl(method)
    val callback = method.formalParams
        .filter { it.variable.isLambda() }
        .map { it.variable }
        .map { CallbackMethodTmpl(method, it.trueType.findType(), it.name) }
    val invoke = InvokeTmpl(method)
    val returnStatement = ReturnTmpl(method)

    return tmpl
        .replace("#__deprecated__#", if (method.isDeprecated) "@Deprecated('过时')" else "")
        .replace("#__static__#", static)
        .replace("#__return_type__#", returnType.enOptional())
        .replace("#__method_name__#", methodName)
        .replace("#__formal_params__#", formalParams)
        .replaceParagraph("#__log__#", log)
        .replaceParagraph("#__invoke__#", invoke)
        .replaceParagraph("#__callback__#", callback.joinToString("\n"))
        .replace("#__return_statement__#", returnStatement)
}