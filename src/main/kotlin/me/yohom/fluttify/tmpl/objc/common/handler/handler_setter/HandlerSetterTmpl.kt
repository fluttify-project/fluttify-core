package me.yohom.fluttify.tmpl.objc.common.handler.handler_setter

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_enum.ArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_jsonable.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_ref.ArgListRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_struct.ArgListStructTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_ref.ArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_struct.ArgStructTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref.ref_ref.RefRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref.struct_ref.StructRefTmpl

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
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
internal class HandlerSetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/handler_setter.stmt.m.tmpl").readText()

    fun objcSetter(): String {
        val setter = field.setterName.depointer()
        val args = when {
            field.variable.run { jsonable() || isAliasType() } -> ArgJsonableTmpl(field.variable).objcArgJsonable()
            field.variable.isList -> ArgListRefTmpl(field.variable).objcArgListRef()
            field.variable.isEnum() -> ArgEnumTmpl(field.variable).objcArgEnum()
            field.variable.isStructPointer() -> ArgListStructTmpl(field.variable).objcArgListStruct()
            field.variable.isCallback() -> ""
            field.variable.isStruct() -> ArgStructTmpl(field.variable).objcArgStruct()
            else -> ArgRefTmpl(field.variable).objcArgRef()
        }
        val fieldName = field.variable.name

        // 获取当前调用方法的对象引用
        val ref = if (field.className.findType().isStruct()) {
            StructRefTmpl(field.asGetterMethod()).objcStructRef()
        } else {
            RefRefTmpl(field.asGetterMethod()).objcRefRef()
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
}