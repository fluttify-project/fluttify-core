package me.yohom.fluttify.tmpl.objc.common.handler.handler_object_factory.handler_object_factory_struct

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Type

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    NSLog(@"#__method_name__#");
//
//    #__type_name__# data;
//
//    NSValue* dataValue = [NSValue value:&data withObjCType:@encode(#__type_name__#)];
//    HEAP_#__plugin_name__#[@(dataValue.hash)] = dataValue;
//
//    methodResult(@(dataValue.hash));
//},
internal class HandlerObjectFactoryStructTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/handler_object_factory_struct.stmt.m.tmpl").readText()

    fun objcObjectFactoryStruct(): String {
        return tmpl
            .replace("#__method_name__#", "ObjectFactory::create${type.name}")
            .replace("#__type_name__#", type.name)
            .replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }
}