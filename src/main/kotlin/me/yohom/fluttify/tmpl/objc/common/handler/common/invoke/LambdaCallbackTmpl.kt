package me.yohom.fluttify.tmpl.objc.common.handler.common.invoke

import me.yohom.fluttify.extensions.isObjcValueType
import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Type

//: ^(#__formal_params__#) {
//    // method channel
//    FlutterMethodChannel *callbackChannel = [FlutterMethodChannel
//          methodChannelWithName:@"#__caller_class_name__#::#__caller_method_name__#_Callback"
//                binaryMessenger:[registrar messenger]];
//
//    // 日志打印
//    #__log__#
//
//    // 开始回调
//    [callbackChannel invokeMethod:@"#__caller_class_name__#::#__caller_method_name__#_Callback::#__callback_method__#"
//                        arguments:@{
//                             #__callback_params__#
//                             @"refId": @(refId)
//                        }];
//
//    // 方法返回值
//    #__return_stmt__#
//}
internal class LambdaCallbackTmpl(private val callerMethod: Method, private val callbackLambda: Type) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/lambda_callback.stmt.m.tmpl").readText()

    fun objcCallback(): String {
        val callbackMethod = callbackLambda.name
        val formalParams =
            callbackLambda.formalParams.joinToString { "${if (it.variable.isList) "NSArray<${it.variable.typeName}>*" else it.variable.typeName} ${it.variable.name}" }
        val returnType = callbackLambda.returnType
        val callerClassName = callerMethod.className
        val callerMethodName = callerMethod.name
        val callbackParams = callbackLambda.formalParams.joinToString("") {
            "@\"${it.variable.name}\": ${when {
                it.variable.typeName.isObjcValueType() -> "@(${it.variable.name})"
                it.variable.typeName.jsonable() -> it.variable.typeName
                else -> "${it.variable.name}.hashCode().apply { REF_MAP[this] = ${it.variable.name} }"
            }},\n"
        }
        val log = "NSLog(@\"fluttify-objc-callback: ${callerMethod.className}@%@::${callerMethod.name}_${callbackLambda.name}(参数打印暂未实现)\", @(refId));"
        val returnStmt = when (callbackLambda.returnType) {
            "BOOL" -> "return true"
            "NSInteger" -> "return 0"
            else -> ""
        }

        return tmpl
            .replace("#__callback_method__#", callbackMethod)
            .replace("#__formal_params__#", formalParams)
            .replace("#__return_type__#", returnType)
            .replace("#__caller_class_name__#", callerClassName)
            .replace("#__caller_method_name__#", callerMethodName)
            .replaceParagraph("#__callback_params__#", callbackParams)
            .replaceParagraph("#__log__#", log)
            .replaceParagraph("#__return_stmt__#", returnStmt)
    }
}