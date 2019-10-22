package me.yohom.fluttify.tmpl.dart.type.type_ref.type_check

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type

//Future<bool> isKindOf#__type_name__#(Ref ref) async {
//  final result = await MethodChannel('#__method_channel__#').invokeMethod('RefClass::isKindOf#__type_name__#', {'refId': ref.refId});
//  return result;
//}
class TypeCheckTmpl(private val type: Type, private val ext: FluttifyExtension) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/type_check.mtd.dart.tmpl").readText()

    fun dartTypeCheck(): String {
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"
        return tmpl
            .replace("#__type_name__#", type.name.toUnderscore())
            .replace("#__method_channel__#", methodChannel)
    }
}