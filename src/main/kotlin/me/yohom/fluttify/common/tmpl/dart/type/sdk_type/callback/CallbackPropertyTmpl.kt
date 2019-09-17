package me.yohom.fluttify.common.tmpl.dart.type.sdk_type.callback

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Field

//MethodChannel('#__callback_channel__#' + refId.toString())
//    .setMethodCallHandler((methodCall) async {
//      final args = methodCall.arguments as Map;
//      final refId = args['callerRefId'] as int;
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
class CallbackPropertyTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/type/sdk_type/callback.stmt.dart.tmpl").readText()

    fun callback(): String {
        if (!field.variable.typeName.findType().isCallback())
            return ""

        val callbackChannel = "${field.variable.typeName}::${field.variable.name}_Callback"
        val callbackDelegateCases = field
            .variable
            .typeName
            .findType()
            .methods
            .joinToString("\n") {
                CallbackDelegateCaseTmpl("${field.className}::${field.variable.name}", it, field.variable.name).dartCallbackDelegateCase()
            }

        return tmpl
            .replace("#__callback_channel__#", callbackChannel)
            .replaceParagraph("#__cases__#", callbackDelegateCases)
    }
}