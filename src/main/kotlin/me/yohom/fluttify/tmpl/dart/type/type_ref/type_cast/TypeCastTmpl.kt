package me.yohom.fluttify.tmpl.dart.type.type_ref.type_cast

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.containerType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type

//else if (T == #__type_name__#) {
//  final result = await MethodChannel('#__method_channel__#', StandardMethodCodec(FluttifyMessageCodec())).invokeMethod('RefClass::as#__type_name__#', {'refId': (this as Ref).refId});
//  return (#__constructor__#().refId = result) as T;
//}
private val tmpl by lazy { getResource("/tmpl/dart/type_cast.stmt.dart.tmpl").readText() }

fun TypeCastTmpl(type: Type): String {
    return tmpl
        .replace("#__type_name__#", type.name.containerType().toDartType())
        .replace(
            "#__constructor__#",
            if (type.isInterface) {
                "${type.name.containerType().toDartType()}.subInstance"
            } else {
                type.name.containerType().toDartType()
            }
        )
        .replace("#__method_channel__#", ext.methodChannelName)
        .replace("#__plugin_name__#", ext.projectName)
}