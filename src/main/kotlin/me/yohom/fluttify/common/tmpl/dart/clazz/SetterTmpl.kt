package me.yohom.fluttify.common.tmpl.dart.clazz

import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Field

//Future<void> set#__name__#(#__type__# #__arg__#) async {
//  await _channel.invokeMethod('#__setter_method__#', {'refId': refId, "#__arg__#": #__arg__#});
//}
/**
 * 生成普通类的dart接口
 */
class SetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/setter.mtd.dart.tmpl").readText()

    fun dartSetter(): String {
        return field.variable?.run {
            val type = typeName.toDartType()
            val name = name.capitalize().toDartType()
            val setterMethod = "${field.className}::set${name.capitalize()}"

            tmpl
                .replace("#__type__#", type)
                .replace("#__name__#", name)
                .replace("#__arg__#", name)
                .replace("#__setter_method__#", setterMethod)
        } ?: ""
    }
}