package me.yohom.fluttify.common.tmpl.objc.common.handler

import me.yohom.fluttify.common.extensions.enpointer
import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.isObjcValueType
import me.yohom.fluttify.common.model.Field

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // 引用对象
//    NSInteger refId = [args[@"refId"] integerValue];
//    #__class_name__# ref = (#__class_name__#) REF_MAP[@(refId)];
//
//    methodResult(#__getter__#);
//},
internal class HandlerGetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin/handler/handler_getter.stmt.m.tmpl").readText()

    fun objcGetter(): String {
        return tmpl
            .replace("#__method_name__#", field.getterMethodName())
            .replace(
                "#__class_name__#", if (field.className.findType().isInterface()) {
                    "id<${field.className}>"
                } else {
                    field.className.enpointer()
                }
            )
            .replace("#__getter__#", field.run {
                when {
                    variable.typeName.isObjcValueType() -> "@(ref.$getterName)"
                    variable.typeName.findType().isStruct() -> {
                        "nil/* 结构体getter暂时不支持 */"
//                        "@(${StructToNSValueTmpl(field.variable).objcStructToNSValue()}.hash)"
                    }
                    else -> "ref.$getterName"
                }
            })
    }
}