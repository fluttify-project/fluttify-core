package me.yohom.fluttify.tmpl.objc.common.handler.handler_getter_batch

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.objc.common.handler.common.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref.ref_ref.RefRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref.struct_ref.StructRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.result.*

//@"#__method_name__#_batch": ^(NSObject <FlutterPluginRegistrar>* registrar, NSDictionary<NSString*, id>* argsBatch, FlutterResult methodResult) {
//    NSMutableArray<#__result_type__#>* resultList = [NSMutableArray array];
//
//    for (int i = 0; i < ((NSArray<NSDictionary<NSString*, NSObject*>*>*) argsBatch).count; i++) {
//        NSDictionary<NSString*, NSObject*>* args = [((NSArray<NSDictionary<NSString*, NSObject*>*>*) argsBatch) objectAtIndex:i];
//
//        // ref object
//        NSNumber* refId = (NSNumber*) args[@"refId"];
//        #__ref__#
//
//        #__invoke__#
//
//        #__result__#
//
//        resultList.add(jsonableResult);
//    }
//
//    methodResult(resultList);
//},
private val tmpl = getResource("/tmpl/objc/handler_getter_batch.stmt.m.tmpl").readText()

fun HandlerGetterBatchTmpl(field: Field): String {
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
        field.variable.isValueType() -> ResultValueTmpl()
        field.variable.jsonable() -> ResultJsonableTmpl()
        field.variable.isIterable -> ResultListTmpl()
        field.variable.isValuePointerType() -> ResultValuePointerTmpl()
        field.variable.isStruct() -> ResultStructTmpl(field.variable.trueType)
        else -> ResultRefTmpl(field.variable.trueType)
    }
    return tmpl
        .replace("#__method_name__#", methodName)
        .replace("#__class_name__#", className)
        .replaceParagraph("#__ref__#", ref)
        .replace("#__invoke__#", invoke)
        .replaceParagraph("#__result__#", result)
}