package me.yohom.fluttify.tmpl.objc.common.handler.handler_top_constant

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.objc.common.handler.common.result.*

//// top constant
//@"get#__name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, id args, FlutterResult methodResult) {
//    methodResult(#__name__#);
//},
private val tmpl by lazy { getResource("/tmpl/objc/handler_top_constant.stmt.m.tmpl").readText() }

fun HandlerTopConstantTmpl(variable: Variable): String {
    val result = variable.rawType.run {
        when {
            isValueType() -> ResultValueTmpl()
            jsonable() -> ResultJsonableTmpl()
            findType().isStruct -> ResultStructTmpl(this)
            isVoid() -> ResultVoidTmpl()
            isPrimitivePointerType() -> ResultValuePointerTmpl()
            else -> ResultRefTmpl()
        }
    }.replace("result", variable.name)

    return tmpl
        .replace("#__name__#", variable.name)
        .replaceParagraph("#__result__#", result)
        .replace("__result__", "__${variable.name}__") // 这里由于复用了通用的结果模板, 那边把结果变量名固定成result了, 这里没办法, 突破惯例处理一次
}