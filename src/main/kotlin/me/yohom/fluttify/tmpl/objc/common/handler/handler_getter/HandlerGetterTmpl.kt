package me.yohom.fluttify.tmpl.objc.common.handler.handler_getter

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.objc.common.handler.common.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.result.*

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    // print log
//    if (enableLog) {
//        NSLog(@"#__method_name__#");
//    }
//
//    // ref object
//    NSInteger refId = [args[@"refId"] integerValue];
//    #__class_name__# ref = (#__class_name__#) HEAP[@(refId)];
//
//    // invoke native method
//    #__invoke__#
//
//    #__result__#
//},
internal class HandlerGetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/handler_getter.stmt.m.tmpl").readText()

    fun objcGetter(): String {
        val methodName = field.getterMethodName()
        val className = when {
            field.className == "id" -> "NSObject*" // 如果是id类型, 就强转成NSObject*
            field.className.findType().isInterface() -> field.className.enprotocol()
            else -> field.className.enpointer()
        }
        // 调用objc端对应的方法
        val invoke = InvokeTmpl(field).objcInvoke()
        val result = when {
            field.variable.typeName.isValueType() -> ResultValueTmpl().objcResultValue()
            field.variable.jsonable() -> ResultJsonableTmpl().objcResultJsonable()
            field.variable.isList -> ResultListTmpl().objcResultList()
            field.variable.isStruct() -> ResultStructTmpl(field.variable.typeName).objcResultStruct()
            else -> ResultRefTmpl(field.variable.typeName).objcResultRef()
        }
        return tmpl
            .replace("#__method_name__#", methodName)
            .replace("#__class_name__#", className)
            .replace("#__invoke__#", invoke)
            .replaceParagraph("#__result__#", result)

    }
}