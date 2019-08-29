package me.yohom.fluttify.common.tmpl.dart.objectfactory

import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Type

//static Future<#__class_name__#> create#__class_name__#() async {
//  final int refId = await _channel.invokeMethod('ObjectFactory::create#__class_name__#');
//  return #__class_name__#.withRefId(refId);
//}
class CreateObjectTmpl(val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/create_object.mtd.dart.tmpl").readText()

    fun dartCreateObject(): String {
        return tmpl
            .replace("#__class_name__#", type.name.toDartType())
    }
}