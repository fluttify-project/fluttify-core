package me.yohom.fluttify.common.tmpl.dart.clazz

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Type

//MethodChannel('#__callback_channel__#' + refId.toString())
//    .setMethodCallHandler((methodCall) async {
//      final args = methodCall.arguments as Map;
//      final refId = args['refId'] as int;
//      if (refId != this.refId) return;
//
//      switch (methodCall.method) {
//        #__cases__#
//        default:
//          break;
//      }
//    });
/**
 * 回调代码
 */
class CallbackTmpl(private val callerMethod: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/callback.stmt.dart.tmpl").readText()

    fun callback(): String {
        // 如果方法参数中没有回调类型的参数, 那么直接返回空字符串
        if (callerMethod.formalParams.none { it.typeName.findType().isCallback() }) return ""

        val callbackMethods = callerMethod.formalParams
            .filter { it.typeName.findType().isCallback() }
            .flatMap { it.typeName.findType().methods }
            // 过滤掉回调方法中含有不认识类参数的回调方法, 过滤掉回调方法参数又是接口类型的回调方法
            .filter { it.formalParams.none { it.typeName.findType().run { this == Type.UNKNOWN_TYPE || isInterface() }} }
            // 重载方法只留一个
            .distinctBy { it.name }

        val className = "${callerMethod.className}::${callerMethod.name}_Callback"
        val callbackCases = callbackMethods.map { CallbackCaseTmpl(
            callerMethod,
            it
        ).callbackCase() }

        return tmpl
            .replace("#__callback_channel__#", className)
            .replaceParagraph("#__cases__#", callbackCases.joinToString("\n"))
    }
}