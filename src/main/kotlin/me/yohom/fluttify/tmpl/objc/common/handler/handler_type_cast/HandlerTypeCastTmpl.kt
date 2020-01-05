package me.yohom.fluttify.tmpl.objc.common.handler.handler_type_cast

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type

//@"RefClass::cast#__type_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // 引用对象
//    NSInteger refId = [args[@"refId"] integerValue];
//    id ref = HEAP[@(refId)];
//
//    // 转型
//    ref = (#__type_name__#) ref;
//    // 放回HEAP
//    HEAP[@(refId)] = ref;
//
//    methodResult(@(refId));
//},
private val tmpl = getResource("/tmpl/objc/handler_type_cast.stmt.m.tmpl").readText()

fun HandlerTypeCastTmpl(type: Type): String {
    return tmpl
        .replace("#__type_name__#", type.name.toUnderscore())
}