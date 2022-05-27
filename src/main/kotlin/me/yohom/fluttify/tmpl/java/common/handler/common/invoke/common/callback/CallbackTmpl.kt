package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.CallbackMethodTmpl

//new #__callback_class_name__#() {
//        // method channel
//        MethodChannel callbackChannel = new MethodChannel(messenger, #__callback_channel__#, new StandardMethodCodec(new FluttifyMessageCodec()));
//        android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
//
//        // call dart method
//        #__callback_methods__#
//}
private val tmpl by lazy { getResource("/tmpl/java/callback.stmt.java.tmpl").readText() }

fun CallbackTmpl(type: Type): String {
    val containerType = type.name.replace("$", ".")
    val genericTypes = type.definedGenericTypes
        .map { it.ifIsGenericTypeConvertToObject() }
        .joinToStringX(prefix = "<", suffix = ">")
    val className = "${containerType}${genericTypes}"
    val callbackChannel = "\"${type.name.replace("$", ".")}::Callback@\" + getClass().getName() + \":\" + System.identityHashCode(this)"
    val callbackMethods = type.methods
        .union(type.ancestorTypes.flatMap { it.findType().methods })
        .joinToString("\n") { CallbackMethodTmpl(it) }
    return tmpl
        .replace("#__callback_class_name__#", className)
        .replace("#__callback_channel__#", callbackChannel)
        .replaceParagraph("#__callback_methods__#", callbackMethods)
}