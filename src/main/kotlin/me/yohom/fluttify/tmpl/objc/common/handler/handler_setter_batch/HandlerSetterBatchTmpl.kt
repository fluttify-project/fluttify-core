package me.yohom.fluttify.tmpl.objc.common.handler.handler_setter_batch

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_enum.ArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_id.ArgIdTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_jsonable.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_ref.ArgListRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_struct.ArgListStructTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_ref.ArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_struct.ArgStructTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref.ref_ref.RefRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref.struct_ref.StructRefTmpl

//@"#__method_name__#_batch": ^(NSObject <FlutterPluginRegistrar> * registrar, id argsBatch, FlutterResult methodResult) {
//    for (int i = 0; i < ((NSArray<NSDictionary<NSString*, NSObject*>*>*) argsBatch).count; i++) {
//        NSDictionary<NSString*, id>* args = [((NSArray<NSDictionary<NSString*, id>*>*) argsBatch) objectAtIndex:i];
//
//        // args
//        #__args__#
//
//        // ref
//        #__ref__#
//
//        ref.#__setter__# = #__field_value__#;
//        methodResult(@"success");
//    }
//
//    methodResult(@"success");
//},
private val tmpl = getResource("/tmpl/objc/handler_setter_batch.stmt.m.tmpl").readText()

fun HandlerSetterBatchTmpl(field: Field): String {
    val setter = field.setterName.depointer()
    val args = field.variable.run {
        when {
            trueType == "id" -> ArgIdTmpl(this)
            jsonable() || isAliasType() -> ArgJsonableTmpl(this)
            isIterable -> ArgListRefTmpl(this)
            isEnum() -> ArgEnumTmpl(this)
            isStructPointer() -> ArgListStructTmpl(this)
            isCallback() -> ""
            isStruct() -> ArgStructTmpl(this)
            else -> ArgRefTmpl(this)
        }
    }
    val fieldName = field.variable.name

    // 获取当前调用方法的对象引用
    val ref = if (field.className.findType().isStruct) {
        StructRefTmpl(field.asGetterMethod())
    } else {
        RefRefTmpl(field.asGetterMethod())
    }

    // 如果setter的是一个delegate, 那么就认定是当前类作为delegate处理
    val fieldValue = field.variable.run {
        when {
            trueType.findType().isCallback -> "self"
            trueType.isPrimitivePointerType() -> "[${fieldName.depointer()} pointerValue];"
            else -> fieldName.depointer()
        }
    }
    val className = if (field.className.findType().isInterface) {
        "id<${field.className}>"
    } else {
        field.className.enpointer()
    }

    return tmpl
        .replace("#__method_name__#", field.setterMethodName)
        .replaceParagraph("#__args__#", args)
        .replaceParagraph("#__ref__#", ref)
        .replace("#__setter__#", setter)
        .replace("#__field_value__#", fieldValue)
        .replace("#__class_name__#", className)
}