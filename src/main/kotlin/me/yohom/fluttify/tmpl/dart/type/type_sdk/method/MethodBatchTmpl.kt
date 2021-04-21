package me.yohom.fluttify.tmpl.dart.type.type_sdk.method

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.dart.type.common.`return`.ReturnTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke_batch.InvokeBatchTmpl

//#__deprecated__#
//#__static__#Future<#__return_type__#> #__method_name__#(#__formal_params__#) async {
//  if (#__check_param_size__#) {
//    return Future.error('all args must have same length!');
//  }
//
//  // invoke native method
//  #__invoke__#
//
//  return #__return_statement__#;
//}
private val tmpl by lazy { getResource("/tmpl/dart/method_batch.mtd.dart.tmpl").readText() }

/**
 * 方法批处理
 *
 * 不接受有回调的方法
 */
fun MethodBatchTmpl(method: Method): String {
    val static = if (method.isStatic) "static " else ""
    val returnType = method.returnType.toDartType().run { if (isVoid()) this else "$this?" }.enList()

    val methodName = "${method.signature}_batch"

    // 方法声明内的参数一律保留, 只有在传参的时候过滤掉lambda和callback参数
    val formalParams = method
        .formalParams
        .joinToString { it.variable.toDartStringBatch() }
        .run {
            // 如果是View的话, 那么就加一个可选参数, 供选择调用的channel
            if (method.className.findType().isView) {
                if (this.isNotEmpty()) "$this, {bool viewChannel = true}" else "{bool viewChannel = true}"
            } else {
                this
            }
        }

    val checkParamSize = method.formalParams.checkParamSize()
    val invoke = InvokeBatchTmpl(method)

    val resultType = method.returnType.toDartType()
    val returnStatement = "(resultBatch as List).map((__result__) => ${ReturnTmpl(method)}).cast<$resultType>().toList()"
    return tmpl
        .replace("#__deprecated__#", if (method.isDeprecated) "@deprecated" else "")
        .replace("#__static__#", static)
        .replace("#__return_type__#", returnType)
        .replace("#__method_name__#", methodName)
        .replace("#__formal_params__#", formalParams)
        .replace("#__check_param_size__#", checkParamSize)
        .replaceParagraph("#__invoke__#", invoke)
        .replace("#__return_statement__#", returnStatement)
}