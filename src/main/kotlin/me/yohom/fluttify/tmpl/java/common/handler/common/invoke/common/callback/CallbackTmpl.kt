package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback

import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.CallbackMethodTmpl

//object : #__callback_class_name__# {
//    // method channel
//    val callbackChannel = MethodChannel(registrar.messenger(), "#__callback_channel__#::Callback" + refId)
//
//    // 回调方法们
//    #__callback_methods__#
//}
internal class CallbackTmpl(private val callerMethod: Method, private val callbackType: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback.stmt.kt.tmpl").readText()

    fun kotlinCallback(): String {
        return tmpl
            .replace("#__callback_class_name__#", callbackType.name)
            .replace("#__callback_channel__#", callerMethod.nameWithClass())
            .replaceParagraph("#__callback_methods__#", callbackType
                .methods
                .joinToString("\n") { CallbackMethodTmpl(it).kotlinCallbackMethod() })
    }
}