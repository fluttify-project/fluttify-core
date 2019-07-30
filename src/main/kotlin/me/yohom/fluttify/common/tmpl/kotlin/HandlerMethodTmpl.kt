package me.yohom.fluttify.common.tmpl.kotlin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.jsonable
import me.yohom.fluttify.common.model.Method

//private fun #__method_name__#(registrar: Registrar, args: Map<String, Any>, methodResult: MethodChannel.Result) {
//    #__args__#
//
//    #__ref__#
//
//    #__invoke__#
//
//    #__result__#
//}
class HandlerMethodTmpl(
    private val method: Method,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/handler_method.mtd.kt.tmpl").readText()

    fun kotlinHandlerMethod(): String {
        val methodName = method.name
        // 参数分为三种, 分情况分别构造以下三种模板
        // 1. 枚举
        // 2. jsonable
        // 3. 引用
        val args = method.formalParams
            .filter { !it.typeName.findType().isCallback() }
            .joinToString("\n") {
                when {
                    it.typeName.jsonable() -> ArgJsonableTmpl(it).kotlinArgJsonable()
                    it.typeName.findType().isEnum() -> ArgEnumTmpl(it).kotlinArgEnum()
                    else -> ArgRefTmpl(it).kotlinArgRef()
                }
            }
        // 获取当前调用方法的对象引用
        val ref = ""
        val invoke = ""
        val result = ""

        return tmpl
            .replace("#__method_name__#", methodName)
            .replace("#__args__#", args)
            .replace("#__ref__#", ref)
            .replace("#__invoke__#", invoke)
            .replace("#__result__#", result)
    }
}