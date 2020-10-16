package me.yohom.fluttify.tmpl.objc.common.handler.handler_method_batch

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_enum.ArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_id.ArgIdTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_jsonable.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_ref.ArgListRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_struct.ArgListStructTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_ref.ArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_struct.ArgStructTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref_batch.ref_ref.RefRefBatchTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref_batch.struct_ref.StructRefBatchTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.result.*

//@"#__method_name__#_batch": ^(NSObject <FlutterPluginRegistrar> * registrar, id argsBatch, FlutterResult methodResult) {
//    NSMutableArray* resultList = [NSMutableArray array];
//
//    for (int i = 0; i < ((NSArray<NSDictionary<NSString*, NSObject*>*>*) argsBatch).count; i++) {
//        NSDictionary<NSString*, NSObject*>* args = [((NSArray<NSDictionary<NSString*, NSObject*>*>*) argsBatch) objectAtIndex:i];
//
//        // args
//        #__args__#
//
//        // ref
//        #__ref__#
//
//        // invoke native method
//        #__invoke__#
//
//        // result
//        #__result__#
//
//        resultList.add(jsonableResult);
//    }
//
//    methodResult(jsonableResult);
//},
private val tmpl by lazy { getResource("/tmpl/objc/handler_method_batch.stmt.m.tmpl").readText() }
fun HandlerMethodBatchTmpl(method: Method): String {
    val methodName = method.nameWithClass()
    val args = method.formalParams
        // 这里不过滤形参, dart端是会过滤形参的, 所以被过滤的传到原生这边是回变成null
        // 由于过滤形参分成Callback和无法处理的类型两种情况, 所以这里不太好处理, 先统一不过滤了
//        .filterFormalParams()
        .joinToString("\n") {
            when {
                it.variable.trueType == "id" -> ArgIdTmpl(it.variable)
                it.variable.isEnum() -> ArgEnumTmpl(it.variable)
                it.variable.run { jsonable() || isAliasType() } -> ArgJsonableTmpl(it.variable)
                it.variable.isStructPointer() -> ArgListStructTmpl(it.variable)
                it.variable.isIterable -> ArgListRefTmpl(it.variable)
                it.variable.isStruct() -> ArgStructTmpl(it.variable)
                it.variable.isLambda() -> ""
                else -> ArgRefTmpl(it.variable)
            }
        }

    // 获取当前调用方法的对象引用
    val ref = if (method.className.findType().isStruct) {
        StructRefBatchTmpl(method)
    } else {
        RefRefBatchTmpl(method)
    }

    // 调用objc端对应的方法
    val invoke = InvokeTmpl(method).objcInvoke()

    val result = method.returnType.run {
        when {
            isValueType() -> ResultValueTmpl()
            jsonable() -> ResultJsonableTmpl()
            findType().isStruct -> ResultStructTmpl(method.returnType)
            isVoid() -> ResultVoidTmpl()
            isPrimitivePointerType() -> ResultValuePointerTmpl()
            else -> ResultRefTmpl()
        }
    }

    return tmpl
        .replace("#__result_type__#", methodName)
        .replace("#__method_name__#", methodName)
        .replaceParagraph("#__args__#", args)
        .replaceParagraph("#__ref__#", ref)
        .replaceParagraph("#__invoke__#", invoke)
        .replaceParagraph("#__result__#", result)
}