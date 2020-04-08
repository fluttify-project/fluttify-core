package me.yohom.fluttify.tmpl.dart.type.type_sdk.method

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.dart.type.common.`return`.ReturnTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke_batch.InvokeBatchTmpl

//Future<#__return_type__#> #__method_name__#(#__formal_params__#) async {
//  if (#__check_param_size__#) {
//    return Future.error('all args must have same length!');
//  }
//
//  // invoke native method
//  #__invoke__#
//
//  // convert native result to dart side object
//  if (resultBatch == null) {
//    return null;
//  } else {
//    final typedResult = #__return_statement__#;
//    #__native_object_pool__#
//    return typedResult;
//  }
//}
private val tmpl = getResource("/tmpl/dart/method_batch.mtd.dart.tmpl").readText()

/**
 * 方法批处理
 *
 * 不接受有回调的方法
 */
fun MethodBatchTmpl(method: Method): String {
    val returnType = if (method.returnType.findType().isStructPointer()) {
        // 返回类型是结构体指针
        method.returnType.toDartType().enList().enList()
    } else {
        val dartType = method.returnType.toDartType()
        if (dartType == "void") "void" else dartType.enList()
    }
    val methodName = "${method.signature()}_batch"

    // 方法声明内的参数一律保留, 只有在传参的时候过滤掉lambda和callback参数
    val formalParams = method
        .formalParams
        .joinToString { it.variable.toDartStringBatch() }
        .run {
            // 如果是View的话, 那么就加一个可选参数, 供选择调用的channel
            if (method.className.findType().isView()) {
                if (this.isNotEmpty()) "$this, {bool viewChannel = true}" else "{bool viewChannel = true}"
            } else {
                this
            }
        }

    val checkParamSize = method.formalParams.checkParamSize()
    val invoke = InvokeBatchTmpl(method)

    val resultType = method.returnType.run {
        when {
            jsonable() -> toDartType()
            isVoid() -> "String"
            else -> "int"
        }
    }
    val returnStatement = "(resultBatch as List).cast<$resultType>().map((__result__) => ${ReturnTmpl(method)}).toList()"

    val nativeObjectPool = method.returnType.run {
        when {
            jsonable() or findType().isEnum() or isVoid() -> ""
            isIterable() || findType().isStructPointer() -> "kNativeObjectPool.addAll(typedResult.expand((e) => e));"
            else -> "kNativeObjectPool.addAll(typedResult);"
        }
    }

    return tmpl
        .replace("#__return_type__#", returnType)
        .replace("#__method_name__#", methodName)
        .replace("#__formal_params__#", formalParams)
        .replace("#__check_param_size__#", checkParamSize)
        .replaceParagraph("#__invoke__#", invoke)
        .replace("#__native_object_pool__#", nativeObjectPool)
        .replace("#__return_statement__#", returnStatement)
}