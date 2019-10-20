package me.yohom.fluttify.tmpl.swift.plugin.handler.invoke

import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.toSwiftType
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Type

//{ (#__formal_params__#) in
//    // method channel
//    let callbackChannel = FlutterMethodChannel(name: "#__caller_class_name__#::#__caller_method_name__#_Callback\(refId)", binaryMessenger: registrar.messenger())
//
//    // 日志打印
//    #__log__#
//
//    // 开始回调
//    callbackChannel.invokeMethod(
//        "#__caller_class_name__#::#__caller_method_name__#_Callback::#__callback_method__#",
//        arguments: [
//             #__callback_params__#
//             "refId": refId
//        ]
//    )
//
//    // 方法返回值
//    #__return_stmt__#
//}
internal class LambdaCallbackTmpl(private val callerMethod: Method, private val callbackLambda: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/lambda_callback.stmt.swift.tmpl").readText()

    fun swiftCallback(): String {
        return tmpl
            .replace("#__callback_method__#", callbackLambda.name)
            .replace(
                "#__formal_params__#",
                callbackLambda.formalParams.joinToString { "${it.variable.name}: ${if (it.variable.isList) "List<${it.variable.typeName.toSwiftType()}>" else it.variable.typeName.toSwiftType()}" }
            )
            .replace("#__return_type__#", callbackLambda.returnType.toSwiftType())
            .replace("#__caller_class_name__#", callerMethod.className)
            .replace("#__caller_method_name__#", callerMethod.name)
            .replace("#__callback_method__#", callbackLambda.name)
            .replaceParagraph(
                "#__callback_params__#",
                callbackLambda.formalParams.joinToString("") {
                    "\"${it.variable.name}\": ${if (it.variable.typeName.jsonable()) it.variable.name else "${it.variable.name}.hashCode().apply { HEAP_#__plugin_name__#[this] = ${it.variable.name} }"},\n"
                }
            )
            .replaceParagraph(
                "#__log__#",
                "print(\"fluttify-swift-callback: ${callerMethod.className}@\\(refId)::${callerMethod.name}_${callbackLambda.name}(${callbackLambda.formalParams.map { "\\\"${it.variable.name}\\\":\\(${it.variable.name})" }})\")"
            )
            .replaceParagraph(
                "#__return_stmt__#",
                when (callbackLambda.returnType.toSwiftType()) {
                    "Boolean" -> "return true"
                    "Int" -> "return 0"
                    else -> ""
                }
            )
    }
}