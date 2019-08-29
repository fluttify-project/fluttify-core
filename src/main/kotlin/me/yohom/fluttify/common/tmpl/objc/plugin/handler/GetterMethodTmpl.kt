package me.yohom.fluttify.common.tmpl.objc.plugin.handler

import me.yohom.fluttify.common.extensions.isObjcValueType
import me.yohom.fluttify.common.model.Field

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // 引用对象
//    NSInteger refId = [args[@"refId"] integerValue];
//    #__class_name__#* ref = (#__class_name__#*) REF_MAP[@(refId)];
//
//    methodResult(#__getter__#);
//},
internal class GetterMethodTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("@\"#__method_name__#\": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {\n    // 引用对象\n    NSInteger refId = [args[@\"refId\"] integerValue];\n    #__class_name__#* ref = (#__class_name__#*) REF_MAP[@(refId)];\n\n    methodResult(#__getter__#);\n},\n").readText()

    fun objcGetter(): String {
        return tmpl
            .replace("#__method_name__#", field.getterMethodName())
            .replace("#__class_name__#", field.className)
            .replace("#__getter__#", field.run {
                if (variable.typeName.isObjcValueType()) {
                    "@(ref.$getterName)"
                } else {
                    "ref.$getterName"
                }
            })
    }
}