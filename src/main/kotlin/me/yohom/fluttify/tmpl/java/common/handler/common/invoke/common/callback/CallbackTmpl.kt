package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.CallbackMethodTmpl

//new #__callback_class_name__#() {
//        // method channel
//        MethodChannel callbackChannel = new MethodChannel(messenger, "#__callback_channel__#");
//        android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
//
//        // call dart method
//        #__callback_methods__#
//}
private val tmpl by lazy { getResource("/tmpl/java/callback.stmt.java.tmpl").readText() }

fun CallbackTmpl(callbackType: Type): String {
    val containerType = callbackType.name.replace("$", ".")
    val genericTypes = callbackType.definedGenericTypes
        .map { it.ifIsGenericTypeConvertToObject() }
        .joinToStringX(prefix = "<", suffix = ">")
    val className = "${containerType}${genericTypes}"
    val callbackChannel = "${callbackType.name.deprotocol().replace("$", ".")}::Callback"
    val callbackMethods = callbackType.methods.joinToString("\n") { CallbackMethodTmpl(it) }
    return tmpl
        .replace("#__callback_class_name__#", className)
        .replace("#__callback_channel__#", callbackChannel)
        .replaceParagraph("#__callback_methods__#", callbackMethods)
}