package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback

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
internal class CallbackTmpl(private val callerMethod: Method, private val callbackType: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/java/callback.stmt.java.tmpl").readText()

    fun javaCallback(): String {
        return tmpl
            .replace("#__callback_class_name__#", callbackType.name)
            .replace("#__callback_channel__#", callerMethod.nameWithClass())
            .replaceParagraph("#__callback_methods__#", callbackType
                .methods
                .joinToString("\n") { CallbackMethodTmpl(it).javaCallbackMethod() })
    }
}