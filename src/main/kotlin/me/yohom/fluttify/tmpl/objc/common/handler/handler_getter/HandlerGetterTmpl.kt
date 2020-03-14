package me.yohom.fluttify.tmpl.objc.common.handler.handler_getter

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.objc.common.handler.common.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref.ref_ref.RefRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref.struct_ref.StructRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.result.*

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, id args, FlutterResult methodResult) {
//    // print log
//    if (enableLog) {
//        NSLog(@"#__method_name__#");
//    }
//
//    // ref object
//    #__ref__#
//
//    // invoke native method
//    #__invoke__#
//
//    #__result__#
//
//    methodResult(jsonableResult);
//},
private val tmpl = getResource("/tmpl/objc/handler_getter.stmt.m.tmpl").readText()

fun HandlerGetterTmpl(field: Field): String {
    val methodName = field.getterMethodName()
    val className = when {
        field.className == "id" -> "NSObject*" // 如果是id类型, 就强转成NSObject*
        field.className.findType().isInterface() -> field.className.enprotocol()
        else -> field.className.enpointer()
    }

    // 获取当前调用方法的对象引用
    val ref = if (field.className.findType().isStruct()) {
        StructRefTmpl(field.asGetterMethod())
    } else {
        RefRefTmpl(field.asGetterMethod())
    }

    // 调用objc端对应的方法
    val invoke = InvokeTmpl(field).objcInvoke()
    val result = when {
        field.variable.typeName.isValueType() -> ResultValueTmpl()
        field.variable.jsonable() -> ResultJsonableTmpl()
        field.variable.isList -> ResultListTmpl()
        field.variable.isVoidPointer() -> ResultValuePointerTmpl()
        field.variable.isStruct() -> ResultStructTmpl(field.variable.typeName)
        else -> ResultRefTmpl(field.variable.typeName)
    }
    return tmpl
        .replace("#__method_name__#", methodName)
        .replace("#__class_name__#", className)
        .replaceParagraph("#__ref__#", ref)
        .replace("#__invoke__#", invoke)
        .replaceParagraph("#__result__#", result)
}