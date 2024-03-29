package me.yohom.fluttify.tmpl.dart.type.common.setter

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_enum.ArgEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_setter.CallbackSetterTmpl

//Future<void> set_#__name__#(#__type__# #__name__#) async {
//  await #__channel__#.invokeMethod('#__setter_method__#', <String, dynamic>{'__this__': this, #__args__#});
//}
private val tmpl by lazy { getResource("/tmpl/dart/setter.mtd.dart.tmpl").readText() }

fun SetterTmpl(field: Field): String {
    return field.variable.run {
        val typeName = field.variable.trueType.toDartType().enOptional()

        val channel = "k${ext.projectName.underscore2Camel()}Channel"
        val argValue = field.variable.trueType.run {
            when {
                isEnum() -> ArgEnumTmpl(field.variable)
                else -> name
            }
        }
        val setterMethodName = field.setterMethodName

        tmpl
            .replace("#__type__#", typeName)
            .replace("#__name__#", name)
            .replace("#__args__#", "\"$name\": $argValue")
            .replace("#__channel__#", channel)
            .replace("#__setter_method__#", setterMethodName)
            .replace("#__tag__#", ext.projectName)
    }
}