package me.yohom.fluttify.common.tmpl.objc.plugin.handler

import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.jsonable
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.arg.ArgEnumTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.arg.ArgJsonableTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.arg.ArgRefTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.arg.ArgStructTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.invoke.InvokeTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.ref.RefTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.result.ResultRefTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.result.ResultStructTmpl

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // 参数
//    #__args__#
//
//    // 调用对象引用
//    #__ref__#
//
//    // 日志打印
//    #__log__#
//
//    // 开始调用
//    #__invoke__#
//
//    // 调用结果
//    #__result__#
//},
internal class HandlerMethodTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin/handler/handler_method.stmt.m.tmpl").readText()

    fun objcHandlerMethod(): String {
        val methodName = method.methodName()
        // 参数分为三种, 分情况分别构造以下三种模板
        // 1. 枚举
        // 2. jsonable
        // 3. 引用
        val args = method.formalParams
            .filter { !it.variable.typeName.findType().isCallback() }
            .joinToString("\n") {
                when {
                    it.variable.typeName.jsonable() -> ArgJsonableTmpl(
                        it.variable
                    ).objcArgJsonable()
                    it.variable.typeName.findType().isEnum() -> ArgEnumTmpl(
                        it.variable
                    ).objcArgEnum()
                    it.variable.typeName.findType().isStruct() -> ArgStructTmpl(
                        it.variable
                    ).objcArgStruct()
                    else -> ArgRefTmpl(it.variable).objcArgRef()
                }
            }
        val log = if (method.isStatic) {
            "NSLog(\"fluttify-objc: ${method.className}::${method.name}(${method.formalParams.filter { it.variable.typeName.jsonable() }.map { "\\\"${it.variable.name}\\\":\\(${it.variable.name})\\n" }})\")"
        } else {
            "NSLog(\"fluttify-objc: ${method.className}@\\(refId)::${method.name}(${method.formalParams.filter { it.variable.typeName.jsonable() }.map { "\\\"${it.variable.name}\\\":\\(${it.variable.name})\\n" }})\")"
        }

        // 获取当前调用方法的对象引用
        val ref = RefTmpl(method).objcRef()

        // 调用kotlin端对应的方法
        val invoke = InvokeTmpl(method).objcInvoke()

        // 调用结果 分为void, (jsonable, ref)两种情况 void时返回"success", jsonable返回本身, ref返回refId
        val result = when {
            method.returnType.depointer().findType().isStruct() -> ResultStructTmpl(
                method.returnType
            ).objcResultStruct()
            else -> ResultRefTmpl(method.returnType).objcResultRef()
        }
        return tmpl
            .replace("#__method_name__#", methodName)
            .replaceParagraph("#__args__#", args)
            .replaceParagraph("#__ref__#", ref)
            .replaceParagraph("#__log__#", "")
            .replaceParagraph("#__invoke__#", invoke)
            .replaceParagraph("#__result__#", result)
    }
}