package me.yohom.fluttify.tmpl.objc.common.handler.handler_setter

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

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, id args, FlutterResult methodResult) {
//    // print log
//    if (enableLog) {
//        NSLog(@"#__method_name__#");
//    }
//
//    // args
//    #__args__#
//
//    // ref
//    #__ref__#
//
//    ref.#__setter__# = #__field_value__#;
//    methodResult(@"success");
//},
private val tmpl by lazy { getResource("/tmpl/objc/handler_setter.stmt.m.tmpl").readText() }

fun HandlerSetterTmpl(field: Field): String {
    val setter = field.setterName.depointer()
    val args = field.variable.run {
        when {
            trueType == "id" -> ArgIdTmpl(field.variable)
            jsonable() || isAliasType() -> ArgJsonableTmpl(field.variable)
            isIterable -> ArgListRefTmpl(field.variable)
            isEnum() -> ArgEnumTmpl(field.variable)
            isStructPointer() -> ArgListStructTmpl(field.variable)
            isCallback() -> ""
            isStruct() -> ArgStructTmpl(field.variable)
            else -> ArgRefTmpl(field.variable)
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
    val fieldValue =field.variable.run {
        when {
            trueType.findType().isCallback -> "weakSelf"
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