package me.yohom.fluttify.common.tmpl.kotlin.plugin.handlemethod.invoke

import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Type
import me.yohom.fluttify.common.tmpl.objc.plugin.handlemethod.invoke.CallbackMethodTmpl

//object : #__callback_class_name__# {
//    // method channel
//    val callbackChannel = MethodChannel(registrar.messenger(), "#__caller_class_name__#::#__caller_method_name__#_Callback" + refId)
//
//    // 回调方法们
//    #__callback_methods__#
//}
internal class CallbackTmpl(private val callerMethod: Method, private val callbackType: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback.stmt.kt.tmpl").readText()

    fun kotlinCallback(): String {
        return tmpl
            .replace("#__callback_class_name__#", callbackType.name)
            .replace("#__caller_class_name__#", callerMethod.className)
            .replace("#__caller_method_name__#", callerMethod.name)
            .replaceParagraph("#__callback_methods__#", callbackType
                .methods
                .joinToString("\n") { CallbackMethodTmpl(callerMethod, it).swiftCallbackMethod() })
    }
}