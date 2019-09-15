package me.yohom.fluttify.common.tmpl.objc.common.handler

import me.yohom.fluttify.common.model.Type

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // 引用对象
//    NSInteger refId = [args[@"refId"] integerValue];
//    #__class_name__#* ref = (#__class_name__#*) REF_MAP[@(refId)];
//
//    methodResult(#__getter__#);
//},
internal class HandlerObjectFactoryTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin/handler/handler_object_factory.stmt.m.tmpl").readText()

    fun objcObjectFactory(): List<String> {
        return listOf()
    }
}