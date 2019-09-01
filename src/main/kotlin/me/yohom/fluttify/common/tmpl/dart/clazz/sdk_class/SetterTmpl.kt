package me.yohom.fluttify.common.tmpl.dart.clazz.sdk_class

import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Field

//Future<void> set_#__name__#(#__type__# #__name__#) async {
//  await _channel.invokeMethod('#__setter_method__#', {'refId': refId, "#__name__#": #__arg_value__#});
//}
/**
 * 生成普通类的dart接口
 */
class SetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/clazz/sdk_class/setter.mtd.dart.tmpl").readText()

    fun dartSetter(): String {
        return field.variable.run {
            tmpl
                .replace("#__type__#", typeName.toDartType())
                .replace("#__name__#", name.toDartType())
                .replace("#__arg_value__#", name.depointer().run {
                    if (field.variable.typeName.findType().isEnum()) {
                        "$this.index"
                    } else {
                        this
                    }
                })
                .replace("#__setter_method__#", field.setterMethodName())
        }
    }
}