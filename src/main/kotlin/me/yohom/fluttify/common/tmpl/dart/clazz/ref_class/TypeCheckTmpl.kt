package me.yohom.fluttify.common.tmpl.dart.clazz.ref_class

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.toUnderscore
import me.yohom.fluttify.common.model.Type

//Future<#__type_name__#> cast#__type_name__#() async {
//  final result = await MethodChannel('#__method_channel__#').invokeMethod('RefClass::cast#__type_name__#', {'refId': refId});
//  return #__type_name__#.withRefId(result);
//}
class TypeCheckTmpl(private val type: Type, private val ext: FluttifyExtension) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/clazz/ref_class/type_check.dart.tmpl").readText()

    fun dartTypeCheck(): String {
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"
        return tmpl
            .replace("#__type_name__#", type.name.toUnderscore())
            .replace("#__method_channel__#", methodChannel)
    }
}