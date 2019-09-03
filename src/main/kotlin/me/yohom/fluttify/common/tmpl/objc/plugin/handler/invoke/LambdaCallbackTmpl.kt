package me.yohom.fluttify.common.tmpl.objc.plugin.handler.invoke

import me.yohom.fluttify.common.extensions.isObjcValueType
import me.yohom.fluttify.common.extensions.jsonable
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.toSwiftType
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Type

//: ^(#__formal_params__#) {
//    // method channel
//    FlutterMethodChannel *callbackChannel = [FlutterMethodChannel
//          methodChannelWithName:@"#__caller_class_name__#::#__caller_method_name__#_Callback\(refId)"
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
    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin/handler/invoke/lambda_callback.stmt.m.tmpl").readText()

    fun objcCallback(): String {
        return tmpl
            .replace("#__callback_method__#", callbackLambda.name)
            .replace(
                "#__formal_params__#",
                callbackLambda.formalParams.joinToString { "${if (it.variable.isList) "List<${it.variable.typeName}>" else it.variable.typeName} ${it.variable.name}" }
            )
            .replace("#__return_type__#", callbackLambda.returnType.toSwiftType())
            .replace("#__caller_class_name__#", callerMethod.className)
            .replace("#__caller_method_name__#", callerMethod.name)
            .replace("#__callback_method__#", callbackLambda.name)
            .replaceParagraph(
                "#__callback_params__#",
                callbackLambda.formalParams.joinToString("") {
                    "@\"${it.variable.name}\": ${when {
                        it.variable.typeName.isObjcValueType() -> "@(${it.variable.name})"
                        it.variable.typeName.jsonable() -> it.variable.typeName
                        else -> "${it.variable.name}.hashCode().apply { REF_MAP[this] = ${it.variable.name} }"
                    }},\n"
                }
            )
            .replaceParagraph(
                "#__log__#", ""
//                "NSLog(@\"fluttify-objc-callback: ${callerMethod.className}@\\(refId)::${callerMethod.name}_${callbackLambda.name}(${callbackLambda.formalParams.map { "\\\"${it.variable.name}\\\":\\(${it.variable.name})" }})\")"
            )
            .replaceParagraph(
                "#__return_stmt__#",
                when (callbackLambda.returnType) {
                    "BOOL" -> "return true"
                    "NSInteger" -> "return 0"
                    else -> ""
                }
            )
    }
}