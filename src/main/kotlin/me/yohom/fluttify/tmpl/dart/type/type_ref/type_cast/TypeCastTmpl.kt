package me.yohom.fluttify.tmpl.dart.type.type_ref.type_cast

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type

//Future<#__type_name__#> as#__type_name__#(Ref ref) async {
//  final result = await MethodChannel('#__method_channel__#').invokeMethod('RefClass::as#__type_name__#', {'refId': ref.refId});
//  return #__type_name__#()..refId = result;
//}
class TypeCastTmpl(private val type: Type, private val ext: FluttifyExtension) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/type_cast.mtd.dart.tmpl").readText()

    fun dartTypeCast(): String {
        val methodChannel = "${ext.org}/${ext.projectName}"
        return tmpl
            .replace("#__type_name__#", type.name.toUnderscore())
            .replace("#__method_channel__#", methodChannel)
    }
}