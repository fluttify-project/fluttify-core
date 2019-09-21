package me.yohom.fluttify.tmpl.dart.type.sdk_type

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.sdk_type.callback.CallbackPropertyTmpl

//Future<void> set_#__name__#(#__type__# #__name__#) async {
//  await _channel.invokeMethod('#__setter_method__#', {'refId': refId, "#__name__#": #__arg_value__#});
//
//  #__callback__#
//}
/**
 * 生成普通类的dart接口
 */
class SetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/setter.mtd.dart.tmpl").readText()

    fun dartSetter(): String {

        return field.variable.run {
            val typeName = typeName.toDartType()
            val name = name.toDartType()
            val argValue = name.depointer().run {
                when {
                    field.variable.typeName.findType().isEnum() -> "$this.index"
                    field.variable.typeName.jsonable() -> this
                    // 如果参数是抽象类型, 那么native端一定会用self/this作为参数传进去, 这边就不用传了
                    field.variable.typeName.findType().isInterface() -> "\"\""
                    else -> "${this}.refId"
                }
            }
            val setterMethodName = field.setterMethodName()
            val callback = CallbackPropertyTmpl(field).callback()

            tmpl
                .replace("#__type__#", typeName)
                .replace("#__name__#", name)
                .replace("#__arg_value__#", argValue)
                .replace("#__setter_method__#", setterMethodName)
                .replace("#__callback__#", callback)
        }
    }
}