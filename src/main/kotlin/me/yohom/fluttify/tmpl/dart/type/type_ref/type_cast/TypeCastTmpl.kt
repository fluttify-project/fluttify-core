package me.yohom.fluttify.tmpl.dart.type.type_ref.type_cast

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type

//Future<#__type_name__#> as#__type_name__#() async {
//  final result = await MethodChannel('#__method_channel__#').invokeMethod('RefClass::as#__type_name__#', {'refId': refId});
//  return #__type_name__#()..refId = result;
//}
private val tmpl = getResource("/tmpl/dart/type_cast.mtd.dart.tmpl").readText()

fun TypeCastTmpl(type: Type): String {
    return tmpl
        .replace("#__type_name__#", type.name.toUnderscore())
        .replace("#__method_channel__#", ext.methodChannelName)
}