package me.yohom.fluttify.common.tmpl.objc.common.handler

import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Field
import me.yohom.fluttify.common.tmpl.objc.common.handler.arg.ArgEnumTmpl
import me.yohom.fluttify.common.tmpl.objc.common.handler.arg.ArgJsonableTmpl
import me.yohom.fluttify.common.tmpl.objc.common.handler.arg.ArgRefTmpl
import me.yohom.fluttify.common.tmpl.objc.common.handler.arg.ArgStructTmpl

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // 参数
//    #__args__#
//
//    NSInteger refId = [args[@"refId"] integerValue];
//    #__class_name__# ref = (#__class_name__#) REF_MAP[@(refId)];
//
//    ref.#__setter__# = #__field_value__#;
//    methodResult(@"success");
//},
internal class HandlerSetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin/handler/handler_setter.stmt.m.tmpl").readText()

    fun objcSetter(): String {
        val setter = field.setterName.depointer()
        // setter参数分为两种, 分情况分别构造以下两种模板
        // 1. 枚举
        // 2. jsonable
        val args = when {
            field.variable.typeName.findType().isCallback() -> ""
            field.variable.typeName.jsonable() -> ArgJsonableTmpl(field.variable).objcArgJsonable()
            field.variable.typeName.findType().isEnum() -> ArgEnumTmpl(field.variable).objcArgEnum()
            field.variable.typeName.findType().isStruct() -> ArgStructTmpl(field.variable).objcArgStruct()
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
    }
}