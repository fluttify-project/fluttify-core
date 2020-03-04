package me.yohom.fluttify.tmpl.objc.common.handler.handler_setter_batch

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_enum.ArgEnumTmpl
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
            jsonable() || isAliasType() -> ArgJsonableTmpl(field.variable)
            isList -> ArgListRefTmpl(field.variable)
            isEnum() -> ArgEnumTmpl(field.variable)
            isStructPointer() -> ArgListStructTmpl(field.variable)
            isCallback() -> ""
            isStruct() -> ArgStructTmpl(field.variable)
            else -> ArgRefTmpl(field.variable)
        }
    }
    val fieldName = field.variable.name

    // 获取当前调用方法的对象引用
    val ref = if (field.className.findType().isStruct()) {
        StructRefTmpl(field.asGetterMethod())
    } else {
        RefRefTmpl(field.asGetterMethod())
    }

    // 如果setter的是一个delegate, 那么就认定是当前类作为delegate处理
    val fieldValue = if (field.variable.typeName.findType().isCallback()) "self" else fieldName.depointer()
    val className = if (field.className.findType().isInterface()) {
        "id<${field.className}>"
    } else {
        field.className.enpointer()
    }

    return tmpl
        .replace("#__method_name__#", field.setterMethodName())
        .replaceParagraph("#__args__#", args)
        .replaceParagraph("#__ref__#", ref)
        .replace("#__setter__#", setter)
        .replace("#__field_value__#", fieldValue)
        .replace("#__class_name__#", className)
}