package me.yohom.fluttify.tmpl.objc.common.handler.handler_object_factory.handler_object_factory_ref

import me.yohom.fluttify.model.Type

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    #__type_name__#* ref = [[#__type_name__# alloc] init];
//
//    methodResult(@(ref.hash));
//},
internal class HandlerObjectFactoryRefTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/handler_object_factory_ref.stmt.m.tmpl").readText()

    fun objcObjectFactoryRef(): String {
        return tmpl
            .replace("#__method_name__#", "ObjectFactory::create${type.name}")
            .replace("#__type_name__#", type.name)
    }
}