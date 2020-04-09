package me.yohom.fluttify.tmpl.dart.type.type_functions.function

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.common.`return`.ReturnTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.dart.type.common.log.LogTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_method.CallbackMethodTmpl

//Future<#__return_type__#> #__function_name__#(#__formal_params__#) async {
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
//  // convert native result to dart side object
//  if (result == null) {
//    return null;
//  } else {
//    #__native_object_pool__#
//    return #__return_statement__#;
//  }
//}
private val tmpl = getResource("/tmpl/dart/function.mtd.dart.tmpl").readText()

fun TypeFunctionTmpl(functionType: Type): String {
    val returnType = functionType.returnType.toDartType()
    val name = functionType.name
    // 方法声明内的参数一律保留, 只有在传参的时候过滤掉lambda和callback参数
    val formalParams = functionType
        .formalParams
        .joinToString { it.variable.toDartString() }
        .run {
            // 如果是View的话, 那么就加一个可选参数, 供选择调用的channel
            if (functionType.isView()) {
                if (this.isNotEmpty()) "$this, {bool viewChannel = true}" else "{bool viewChannel = true}"
            } else {
                this
            }
        }
    val log = LogTmpl(functionType.asMethod())
    val invoke = InvokeTmpl(functionType.asMethod())
    val callback = CallbackMethodTmpl(functionType.asMethod())
    val returnStatement = ReturnTmpl(functionType.asMethod())
    val nativeObjectPool = functionType.returnType.run {
        when {
            jsonable() or findType().isEnum() or isVoid() -> ""
            isIterable() -> "kNativeObjectPool.addAll($returnStatement);"
            else -> "kNativeObjectPool.add($returnStatement);"
        }
    }

    return tmpl
        .replace("#__return_type__#", returnType)
        .replace("#__function_name__#", name)
        .replace("#__formal_params__#", formalParams)
        .replaceParagraph("#__log__#", log)
        .replaceParagraph("#__invoke__#", invoke)
        .replaceParagraph("#__callback__#", callback)
        .replace("#__native_object_pool__#", nativeObjectPool)
        .replace("#__return_statement__#", returnStatement)
}