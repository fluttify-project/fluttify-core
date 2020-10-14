package me.yohom.fluttify.tmpl.objc.common.handler.handler_getter_batch

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.objc.common.handler.common.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref_batch.ref_ref.RefRefBatchTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref_batch.struct_ref.StructRefBatchTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.result.*

//@"#__method_name__#_batch": ^(NSObject <FlutterPluginRegistrar>* registrar, id argsBatch, FlutterResult methodResult) {
//    NSMutableArray* resultList = [NSMutableArray array];
//
//    for (int __i__ = 0; __i__ < ((NSArray<NSDictionary<NSString*, NSObject*>*>*) argsBatch).count; __i__++) {
//        NSDictionary<NSString*, id>* args = [((NSArray<NSDictionary<NSString*, id>*>*) argsBatch) objectAtIndex:__i__];
//
//        // ref object
//        #__ref__#
//
//        #__invoke__#
//
//        #__result__#
//
//        [resultList addObject:__result__];
//    }
//
//    methodResult(resultList);
//},
private val tmpl by lazy { getResource("/tmpl/objc/handler_getter_batch.stmt.m.tmpl").readText() }

fun HandlerGetterBatchTmpl(field: Field): String {
    val methodName = field.getterMethodName
    val className = when {
        field.className == "id" -> "NSObject*" // 如果是id类型, 就强转成NSObject*
        field.className.findType().isInterface -> field.className.enprotocol()
        else -> field.className.enpointer()
    }

    // 获取当前调用方法的对象引用
    // 批处理和普通调用的获取引用方式区分一下, 批处理时, 碰到到nil则添加nil进结果列表并跳过此次循环
    val ref = if (field.className.findType().isStruct) {
        StructRefBatchTmpl(field.asGetterMethod())
    } else {
        RefRefBatchTmpl(field.asGetterMethod())
    }

    // 调用objc端对应的方法
    val invoke = InvokeTmpl(field).objcInvoke()
    val result = when {
        field.variable.isValueType() -> ResultValueTmpl()
        field.variable.jsonable() -> ResultJsonableTmpl()
        field.variable.isValuePointerType() -> ResultValuePointerTmpl()
        field.variable.isStruct() -> ResultStructTmpl(field.variable.trueType)
        else -> ResultRefTmpl()
    }
    return tmpl
        .replace("#__method_name__#", methodName)
        .replace("#__class_name__#", className)
        .replaceParagraph("#__ref__#", ref)
        .replace("#__invoke__#", invoke)
        .replaceParagraph("#__result__#", result)
}