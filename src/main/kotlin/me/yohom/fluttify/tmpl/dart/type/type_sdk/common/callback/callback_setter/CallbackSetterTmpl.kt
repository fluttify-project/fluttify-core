package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_setter

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_delegate.CallbackCaseDelegateTmpl

//MethodChannel('#__callback_channel__#', StandardMethodCodec(FluttifyMessageCodec()))
//    .setMethodCallHandler((methodCall) async {
//      try {
//        final args = methodCall.arguments as Map;
//        switch (methodCall.method) {
//          #__cases__#
//          default:
//            break;
//        }
//      } catch (e) {
//        debugPrint(e);
//        throw e;
//      }
//    });
private val tmpl by lazy { getResource("/tmpl/dart/callback.stmt.dart.tmpl").readText() }

fun CallbackSetterTmpl(field: Field): String {
    if (!field.variable.trueType.findType().isCallback)
        return ""

    // 如果是View类型的类, 那么就加上当前的View代表的id
    // 因为objc端的delegate方法无法区分调用方, 所以只有view类型的类能根据viewId区分
    val callbackChannel = if (field.className.findType().isView) {
        "${field.variable.trueType.deprotocol().replace("$", ".")}::Callback@\$refId"
    } else {
        "${field.variable.trueType.deprotocol().replace("$", ".")}::Callback"
    }

    val callbackDelegateCases = field
        .variable
        .trueType
        .findType()
        .methods
        .filterMethod()
        // 回调的方法要过滤掉参数含有`没有子类的抽象类`参数的方法
        .filter {
            it.must("形参类型是具体类型或者含有子类的抽象类") {
                formalParams.all {
                    it.variable.jsonable()
                            ||
                            it.variable.isConcret()
                            ||
                            it.variable.hasConcretSubtype()
                }
            }
                    &&
                    it.mustNot("参数中含有lambda") { formalParams.any { it.variable.isLambda() } }
        }
        .joinToString("\n") {
            CallbackCaseDelegateTmpl(it, field.variable.name)
        }

    return tmpl
        .replace("#__callback_channel__#", callbackChannel)
        .replace("#__project_name__#", ext.projectName.underscore2Camel())
        .replaceParagraph("#__cases__#", callbackDelegateCases)
}