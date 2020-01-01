package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_setter

import me.yohom.fluttify.extensions.*
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
private val tmpl = getResource("/tmpl/dart/callback.stmt.dart.tmpl").readText()

fun CallbackSetterTmpl(field: Field): String {
    if (!field.variable.typeName.findType().isCallback())
        return ""

    val callbackChannel = "${field.variable.typeName.replace("$", ".")}::Callback"
    val callbackDelegateCases = field
        .variable
        .typeName
        .findType()
        .methods
        .filterMethod()
        // 回调的方法要过滤掉参数含有`没有子类的抽象类`参数的方法
        .filter { it.must("形参类型是具体类型或者含有子类的抽象类") { formalParams.all { it.variable.hasConcretSubtype() } } }
        .joinToString("\n") {
            CallbackCaseDelegateTmpl(it, field.variable.name)
        }

    return tmpl
        .replace("#__callback_channel__#", callbackChannel)
        .replaceParagraph("#__cases__#", callbackDelegateCases)
}