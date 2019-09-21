package me.yohom.fluttify.tmpl.dart.type.ref_type

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type

//Future<#__type_name__#> cast#__type_name__#() async {
//  final result = await MethodChannel('#__method_channel__#').invokeMethod('RefClass::cast#__type_name__#', {'refId': refId});
//  return #__type_name__#.withRefId(result);
//}
class TypeCheckTmpl(private val type: Type, private val ext: FluttifyExtension) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/type_check.dart.tmpl").readText()

    fun dartTypeCheck(): String {
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"
        return tmpl
            .replace("#__type_name__#", type.name.toUnderscore())
            .replace("#__method_channel__#", methodChannel)
    }
}