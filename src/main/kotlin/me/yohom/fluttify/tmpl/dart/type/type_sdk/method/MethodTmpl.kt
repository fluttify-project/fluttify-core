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

    // 方法声明内的参数一律保留, 只有在传参的时候过滤掉lambda和callback参数
    val formalParams = method
        .formalParams
        .joinToString { it.variable.toDartString() }
        .run {
            // 如果是View的话, 那么就加一个可选参数, 供选择调用的channel
            if (method.className.findType().isView) {
                if (this.isNotEmpty()) "$this, {bool viewChannel = true}" else "{bool viewChannel = true}"
            } else {
                this
            }
        }
    val log = LogTmpl(method)
    val callback = method.formalParams
        .filter { it.variable.isCallback() || it.variable.isLambda() }
        .map { it.variable }
        .map { CallbackMethodTmpl(method, it.trueType.findType(), it.name) }
    val invoke = InvokeTmpl(method)
    val returnStatement = ReturnTmpl(method)

    return tmpl
        .replace("#__deprecated__#", if (method.isDeprecated) "@deprecated" else "")
        .replace("#__static__#", static)
        .replace("#__return_type__#", returnType)
        .replace("#__method_name__#", methodName)
        .replace("#__formal_params__#", formalParams)
        .replaceParagraph("#__log__#", log)
        .replaceParagraph("#__invoke__#", invoke)
        .replaceParagraph("#__callback__#", callback.joinToString("\n"))
        .replace("#__return_statement__#", returnStatement)
}