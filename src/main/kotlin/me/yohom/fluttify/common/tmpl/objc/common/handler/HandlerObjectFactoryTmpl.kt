package me.yohom.fluttify.common.tmpl.objc.common.handler

import me.yohom.fluttify.common.model.Type

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    #__type_name__#* ref = [[#__type_name__# alloc] init];
//
//    methodResult(@(ref.hash));
//},
internal class HandlerObjectFactoryTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin/handler/handler_object_factory.stmt.m.tmpl").readText()

    fun objcObjectFactory(): String {
        return tmpl
            .replace("#__method_name__#", "ObjectFactory::create${type.name}")
            .replace("#__type_name__#", type.name)
    }
}