package me.yohom.fluttify.tmpl.dart.type.type_ref.type_check

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.containerType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type

//else if (T == #__type_name__#) {
//  final result = await MethodChannel('#__method_channel__#').invokeMethod('RefClass::isKindOf#__type_name__#', {'refId': (this as Ref).refId});
//  return result;
//}
private val tmpl by lazy { getResource("/tmpl/dart/type_check.stmt.dart.tmpl").readText() }

fun TypeCheckTmpl(type: Type): String {
    return tmpl
        .replace("#__type_name__#", type.name.containerType().toDartType())
        .replace("#__method_channel__#", ext.methodChannelName)
}