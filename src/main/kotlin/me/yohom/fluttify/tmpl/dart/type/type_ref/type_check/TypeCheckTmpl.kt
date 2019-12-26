package me.yohom.fluttify.tmpl.dart.type.type_ref.type_check

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type

//Future<bool> is#__type_name__#() async {
//  final result = await MethodChannel('#__method_channel__#').invokeMethod('RefClass::isKindOf#__type_name__#', {'refId': refId});
//  return result;
//}
class TypeCheckTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/type_check.mtd.dart.tmpl").readText()

    fun dartTypeCheck(): String {
        return tmpl
            .replace("#__type_name__#", type.name.toUnderscore())
            .replace("#__method_channel__#", ext.methodChannelName)
    }
}