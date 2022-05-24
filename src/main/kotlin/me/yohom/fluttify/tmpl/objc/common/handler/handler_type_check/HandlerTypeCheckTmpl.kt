package me.yohom.fluttify.tmpl.objc.common.handler.handler_type_check

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type

//@"RefClass::isKindOf#__type_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // 引用对象
//    NSInteger refId = [args[@"refId"] integerValue];
//    id ref = HEAP[@(refId)];
//
//    BOOL isTargetType = [ref isKindOfClass:[#__type_name__# class]];
//    methodResult(@(isTargetType));
//},
private val tmpl by lazy { getResource("/tmpl/objc/handler_type_check.stmt.m.tmpl").readText() }

fun HandlerTypeCheckTmpl(type: Type): String {
    return tmpl
        .replace("#__type_name__#", type.name.toUnderscore())
}