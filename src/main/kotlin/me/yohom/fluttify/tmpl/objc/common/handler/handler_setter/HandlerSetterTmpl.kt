package me.yohom.fluttify.tmpl.objc.common.handler.handler_setter

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_enum.ArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_jsonable.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_ref.ArgListRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_struct.ArgListStructTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_ref.ArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_struct.ArgStructTmpl

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // 参数
//    #__args__#
//
//    NSInteger refId = [args[@"refId"] integerValue];
//    #__class_name__# ref = (#__class_name__#) HEAP_#__plugin_name__#[@(refId)];
//
//    ref.#__setter__# = #__field_value__#;
//    methodResult(@"success");
//},
internal class HandlerSetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/handler_setter.stmt.m.tmpl").readText()

    fun objcSetter(): String {
        val setter = field.setterName.depointer()
        val args = when {
            field.variable.jsonable() -> ArgJsonableTmpl(field.variable).objcArgJsonable()
            field.variable.isList -> ArgListRefTmpl(field.variable).objcArgListRef()
            field.variable.isEnum() -> ArgEnumTmpl(field.variable).objcArgEnum()
            field.variable.isStructPointer() -> ArgListStructTmpl(field.variable).objcArgListStruct()
            field.variable.isCallback() -> ""
            field.variable.isStruct() -> ArgStructTmpl(field.variable).objcArgStruct()
            else -> ArgRefTmpl(field.variable).objcArgRef() // 暂时过滤了引入类型的setter
        }
        val fieldName = field.variable.name
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
            .replace("#__setter__#", setter)
            .replace("#__field_value__#", fieldValue)
            .replace("#__class_name__#", className)
            .replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }
}