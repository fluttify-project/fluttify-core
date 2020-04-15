package me.yohom.fluttify.tmpl.dart.type.type_constants.constant

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.dart.type.common.`return`.ReturnTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.dart.type.common.log.LogTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_method.CallbackMethodTmpl

//Future<#__type_name__#> get #__name__# async {
//  return MethodChannel('#__channel_name__#').invoke('get#__name__#');
//}
private val tmpl = getResource("/tmpl/dart/constant.mtd.dart.tmpl").readText()

fun TypeConstantTmpl(variable: Variable): String {
    return tmpl
        .replace("#__type_name__#", variable.typeName.toDartType())
        .replace("#__name__#", variable.name)
        .replace("#__channel_name__#", ext.methodChannelName)
}