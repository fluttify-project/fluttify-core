package me.yohom.fluttify.tmpl.dart.type.type_interface.interface_method

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Method

//@mustCallSuper
//Future<#__return_type__#> #__interface_method__#(#__formal_params__#) {
//  #__callback_pool__#
//}
class InterfaceMethodTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/dart/interface_method.mtd.dart.tmpl").readText()

    fun dartInterfaceMethod(): String {
        val returnType = method.returnType.toDartType()
        val name = method.name + method.formalParams.joinToString("") { it.named }.capitalize()
        val formalParams = method.formalParams.joinToString { it.variable.toDartString() }
        val callbackPool = if (method.className.findType().isCallback()) {
            // 只有回调类的参数需要加入释放池
            method
                .formalParams
                .filter { it.variable.run { !jsonable() && !isEnum() } }
                .joinToString("\n") {
                    if (it.variable.isList)
                        "kCallbackPool.addAll(Map.fromIterable(${it.variable.name}, key: (it) => it.refId, value: (it) => it));"
                    else
                        "kCallbackPool[${it.variable.name}.refId] = ${it.variable.name};"
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
}