package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_setter

import me.yohom.fluttify.extensions.filterMethod
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.must
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_delegate.CallbackCaseDelegateTmpl

//MethodChannel('#__callback_channel__#')
//    .setMethodCallHandler((methodCall) async {
//      final args = methodCall.arguments as Map;
//      // final refId = args['callerRefId'] as int;
//      // if (refId != this.refId) return;
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
class CallbackSetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/callback.stmt.dart.tmpl").readText()

    fun callback(): String {
        if (!field.variable.typeName.findType().isCallback())
            return ""

        val callbackChannel = "${field.variable.typeName}::Callback"
        val callbackDelegateCases = field
            .variable
            .typeName
            .findType()
            .methods
            .filterMethod()
            // 回调的方法要过滤掉参数含有`没有子类的抽象类`参数的方法
            .filter { it.must("形参类型是具体类型或者含有子类的抽象类") { formalParams.all { it.variable.run { isConcret() || hasSubtype() } } } }
            .joinToString("\n") {
                CallbackCaseDelegateTmpl(it, field.variable.name).dartCallbackDelegateCase()
            }

        return tmpl
            .replace("#__callback_channel__#", callbackChannel)
            .replaceParagraph("#__cases__#", callbackDelegateCases)
    }
}