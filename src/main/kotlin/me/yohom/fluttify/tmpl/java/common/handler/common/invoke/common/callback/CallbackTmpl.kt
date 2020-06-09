package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.joinToStringX
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.CallbackMethodTmpl

//new #__callback_class_name__#() {
//    // method channel
//    MethodChannel callbackChannel = new MethodChannel(registrar.messenger(), "#__callback_channel__#::Callback");
//
//    // call dart method
//    #__callback_methods__#
//}
private val tmpl by lazy { getResource("/tmpl/java/callback.stmt.java.tmpl").readText() }

fun CallbackTmpl(callerMethod: Method, callbackType: Type): String {
    val className = "${callbackType.name.replace("$", ".")}${callbackType.definedGenericTypes.joinToStringX(prefix = "<", suffix = ">")}"
    val callbackChannel = callerMethod.nameWithClass()
    val callbackMethods = callbackType.methods.joinToString("\n") { CallbackMethodTmpl(it) }
    return tmpl
        .replace("#__callback_class_name__#", className)
        .replace("#__callback_channel__#", callbackChannel)
        .replaceParagraph("#__callback_methods__#", callbackMethods)
}