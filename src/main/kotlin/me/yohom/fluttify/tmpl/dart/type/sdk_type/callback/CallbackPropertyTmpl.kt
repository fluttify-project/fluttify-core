package me.yohom.fluttify.tmpl.dart.type.sdk_type.callback

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Field

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
class CallbackPropertyTmpl(private val field: Field) {
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
            .distinctBy { it.methodName() }
            .filter { it.formalParams.none { it.variable.typeName.findType().isAbstract } }
            .joinToString("\n") {
                CallbackDelegateCaseTmpl(it, field.variable.name).dartCallbackDelegateCase()
            }

        return tmpl
            .replace("#__callback_channel__#", callbackChannel)
            .replaceParagraph("#__cases__#", callbackDelegateCases)
    }
}