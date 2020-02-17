package me.yohom.fluttify.tmpl.objc.common.handler.handler_object_creator.handler_object_creator_ref_batch

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Type

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    #__type_name__#* ref = [[#__type_name__# alloc] init];
//
//    methodResult(@(ref.hash));
//},
private val tmpl = getResource("/tmpl/objc/handler_object_factory_ref.stmt.m.tmpl").readText()

fun HandlerObjectFactoryRefBatchTmpl(type: Type): String {
    return tmpl
        .replace("#__method_name__#", "ObjectFactory::create${type.name}")
        .replace("#__type_name__#", type.name)
}