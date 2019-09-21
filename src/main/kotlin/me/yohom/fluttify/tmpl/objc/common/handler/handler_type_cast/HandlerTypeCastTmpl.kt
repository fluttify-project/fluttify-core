package me.yohom.fluttify.tmpl.objc.common.handler.handler_type_cast

import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type

//@"RefClass::cast#__type_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // 引用对象
//    NSInteger refId = [args[@"refId"] integerValue];
//    id ref = REF_MAP[@(refId)];
//
//    // 转型
//    ref = (#__type_name__#) ref;
//    // 放回REF_MAP
//    REF_MAP[@(refId)] = ref;
//
//    methodResult(@(refId));
//},
internal class HandlerTypeCastTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/handler_type_cast.stmt.m.tmpl").readText()

    fun objcTypeCast(): String {
        return tmpl.replace("#__type_name__#", type.name.toUnderscore())
    }
}