package me.yohom.fluttify.tmpl.objc.common.handler.handler_object_creator.handler_object_creator_ref

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Type

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // print log
//    if (enableLog) {
//        NSLog(@"#__method_name__#");
//    }
//
//    #__type_name__#* ref = [[#__type_name__# alloc] init];
//    HEAP[@(ref.hash)] = ref;
//
//    methodResult(@(ref.hash));
//
//    if (enableLog) NSLog(@"HEAP: %@", HEAP);
//},
private val tmpl = getResource("/tmpl/objc/handler_object_creator_ref.stmt.m.tmpl").readText()

fun HandlerObjectFactoryRefTmpl(type: Type): String {
    return tmpl
        .replace("#__method_name__#", "ObjectFactory::create${type.name}")
        .replace("#__type_name__#", type.name)
}