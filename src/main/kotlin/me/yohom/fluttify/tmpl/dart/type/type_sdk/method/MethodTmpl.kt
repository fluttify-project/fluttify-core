package me.yohom.fluttify.tmpl.dart.type.type_sdk.method

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_method.CallbackMethodTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.`return`.ReturnTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.log.LogTmpl

//#__static__#Future<#__return_type__#> #__method_name__#(#__formal_params__#) async {
//  // 日志打印
//  #__log__#
//
//  // 调用原生方法
//  #__invoke__#
//
//  // 接受原生回调
//  #__callback__#
//
//  // 返回值
//  if (result == null) {
//    return null;
//  } else {
//    #__native_object_pool__#
//    return #__return_statement__#;
//  }
//}
class MethodTmpl(
    private val method: Method,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/method.mtd.dart.tmpl").readText()

    fun dartMethod(): String {
        val static = if (method.isStatic) "static " else ""
        val returnType = method.returnType.toDartType()
        val name = method.name + method.formalParams.joinToString("") { it.named }.capitalize()
        // 方法声明内的参数一律保留, 只有在传参的时候过滤掉lambda和callback参数
        val formalParams = method
            .formalParams
            .joinToString { it.variable.toDartString() }
            .run {
                // 如果是View的话, 那么就加一个可选参数, 供选择调用的channel
                if (method.className.findType().isView()) {
                    if (this.isNotEmpty()) "$this, {bool viewChannel = true}" else "{bool viewChannel = true}"
                } else {
                    this
                }
            }
        val log = LogTmpl(method).dartMethodLog()
        val invoke = InvokeTmpl(method, ext).dartMethodInvoke()
        val callback = CallbackMethodTmpl(method).callback()
        val returnStatement = ReturnTmpl(method, ext).dartMethodReturn()
        val nativeObjectPool = method.returnType.run {
            when {
                jsonable() or findType().isEnum() or isVoid() -> ""
                isList() -> "kNativeObjectPool.addAll($returnStatement);"
                else -> "kNativeObjectPool.add($returnStatement);"
            }
        }

        return tmpl
            .replace("#__static__#", static)
            .replace("#__return_type__#", returnType)
            .replace("#__method_name__#", name)
            .replace("#__formal_params__#", formalParams)
            .replaceParagraph("#__log__#", log)
            .replaceParagraph("#__invoke__#", invoke)
            .replaceParagraph("#__callback__#", callback)
            .replace("#__native_object_pool__#", nativeObjectPool)
            .replace("#__return_statement__#", returnStatement)
    }
}