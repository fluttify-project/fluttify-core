package me.yohom.fluttify.tmpl.objc.common.handler.handler_object_creator.handler_object_creator_struct

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Type

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, id args, FlutterResult methodResult) {
//    // print log
//    if (enableLog) {
//        NSLog(@"#__method_name__#");
//    }
//
//    #__type_name__# data;
//
//    NSValue* dataValue = [NSValue value:&data withObjCType:@encode(#__type_name__#)];
//
//    methodResult(dataValue);
//
//    if (enableLog) NSLog(@"HEAP: %@", HEAP);
//},
private val tmpl by lazy { getResource("/tmpl/objc/handler_object_creator_struct.stmt.m.tmpl").readText() }

fun HandlerObjectFactoryStructTmpl(type: Type): String {
    return tmpl
        .replace("#__method_name__#", "ObjectFactory::create${type.name}")
        .replace("#__type_name__#", type.name)
}