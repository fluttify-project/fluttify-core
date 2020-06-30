package me.yohom.fluttify.tmpl.dart.type.type_interface.interface_method

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method

//@mustCallSuper
//Future<#__return_type__#> #__interface_method__#(#__formal_params__#) {
//  #__callback_pool__#
//
//  if (fluttifyLogEnabled) {
//    debugPrint('#__interface_method__#::kNativeObjectPool: $kNativeObjectPool');
//  }
//}
private val tmpl by lazy { getResource("/tmpl/dart/interface_method.mtd.dart.tmpl").readText() }

fun InterfaceMethodTmpl(method: Method): String {
    val returnType = method.returnType.toDartType()
    val name = method.signature
    val formalParams = method.formalParams.joinToString { it.variable.toDartString() }
    val callbackPool = if (method.className.findType().isCallback) {
        // 只有回调类的参数需要加入释放池
        method
            .formalParams
            .filter { it.variable.run { !jsonable() && !isEnum() && !isAliasType() || this.trueType in method.className.findType().declaredGenericTypes } }
            .joinToString("\n") {
                if (it.variable.isCollection()) {
                    "kNativeObjectPool.addAll(${it.variable.name});"
                } else {
                    "if (${it.variable.name} is Ref) kNativeObjectPool.add(${it.variable.name});"
                }
            }
    } else {
        ""
    }

    return tmpl
        .replace("#__return_type__#", returnType)
        .replace("#__interface_method__#", name)
        .replace("#__formal_params__#", formalParams)
        .replaceParagraph("#__callback_pool__#", callbackPool)
}