package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Method

/**
 * 生成普通类的dart接口
 */
class CallbackTmpl(
    private val method: Method,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/method.mtd.dart.tmpl").readText()

    fun dartMethod(): String {
        val static = if (method.isStatic) "static" else ""
        val returnType = method.returnType
        val name = method.name
        val formalParams = method.name
        val invoke = method.name
        val callback = method.name
        val returnStatement = method.name

        return tmpl
            .replace("#__static__#", static)
            .replace("#__return_type__#", returnType)
            .replace("#__method__#", name)
            .replaceParagraph("#__formal_params__#", formalParams)
            .replaceParagraph("#__invoke__#", invoke)
            .replaceParagraph("#__callback__#", callback)
            .replaceParagraph("#__return_statement__#", returnStatement)
    }
}