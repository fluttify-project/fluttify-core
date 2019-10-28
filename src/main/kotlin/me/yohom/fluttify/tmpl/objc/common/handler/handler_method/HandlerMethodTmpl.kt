package me.yohom.fluttify.tmpl.objc.common.handler.handler_method

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_enum.ArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_jsonable.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_ref.ArgListRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_struct.ArgListStructTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_ref.ArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_struct.ArgStructTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref.RefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.result.*

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
    private val tmpl = this::class.java.getResource("/tmpl/objc/handler_method.stmt.m.tmpl").readText()

    fun objcHandlerMethod(): String {
        val methodName = method.nameWithClass()
        val args = method.formalParams
            .joinToString("\n") {
                when {
                    it.variable.run { jsonable() || isAliasType() } -> ArgJsonableTmpl(it.variable).objcArgJsonable()
                    it.variable.isStructPointer() -> ArgListStructTmpl(it.variable).objcArgListStruct()
                    it.variable.isList -> ArgListRefTmpl(it.variable).objcArgListRef()
                    it.variable.isEnum() -> ArgEnumTmpl(it.variable).objcArgEnum()
                    it.variable.isStruct() -> ArgStructTmpl(it.variable).objcArgStruct()
                    it.variable.isLambda() -> ""
                    else -> ArgRefTmpl(it.variable).objcArgRef()
                }
            }
        val log = if (method.isStatic) {
            "NSLog(@\"fluttify-objc: ${method.className}::${method.name}(暂未实现参数打印)\");"
        } else {
            "NSLog(@\"fluttify-objc: ${method.className}@%@::${method.name}(暂未实现参数打印)\", @(refId));"
        }

        // 获取当前调用方法的对象引用
        val ref = RefTmpl(method).objcRef()

        // 调用objc端对应的方法
        val invoke = InvokeTmpl(method).objcInvoke()

        val result = when {
            method.returnType.isValueType() -> ResultValueTmpl().objcResultValue()
            method.returnType.jsonable() -> ResultJsonableTmpl().objcResultJsonable()
            method.returnType.isList() -> ResultListTmpl().objcResultList()
            method.returnType.findType().isStruct() -> ResultStructTmpl(method.returnType).objcResultStruct()
            method.returnType.isVoid() -> ResultVoidTmpl().objcResultVoid()
            else -> ResultRefTmpl().objcResultRef()
        }

        return tmpl
            .replace("#__method_name__#", methodName)
            .replaceParagraph("#__args__#", args)
            .replaceParagraph("#__ref__#", ref)
            .replaceParagraph("#__log__#", log)
            .replaceParagraph("#__invoke__#", invoke)
            .replaceParagraph("#__result__#", result)
    }
}