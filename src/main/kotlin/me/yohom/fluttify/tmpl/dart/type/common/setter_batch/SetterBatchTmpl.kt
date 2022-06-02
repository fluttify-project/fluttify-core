package me.yohom.fluttify.tmpl.dart.type.common.setter_batch

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_setter.CallbackSetterTmpl

//Future<void> set_#__name__#_batch(List<#__type__#> #__name__#) async {
//  await #__channel__#.invokeMethod('#__setter_method__#_batch', [for (int __i__ = 0; __i__ < this.length; __i__++) {'__this__': this[__i__], "#__name__#": #__arg_value__#}]);
//
//  #__callback__#
//}
private val tmpl by lazy { getResource("/tmpl/dart/setter_batch.mtd.dart.tmpl").readText() }

fun SetterBatchTmpl(field: Field): String {
    return field.variable.run {
        val typeName = field.variable.trueType.toDartType().enOptional()
        val name = name.depointer()

        val channel = "k${ext.projectName.underscore2Camel()}Channel"
        val argValue = when {
            isEnum() -> "$name[__i__]?.toValue()"
            else -> "$name[__i__]"
        }
        val setterMethodName = field.setterMethodName

        val callback = CallbackSetterTmpl(field)

        tmpl
            .replace("#__type__#", typeName)
            .replace("#__name__#", name)
            .replace("#__arg_value__#", argValue)
            .replace("#__tag__#", ext.projectName)
            .replace("#__channel__#", channel)
            .replace("#__setter_method__#", setterMethodName)
            .replace("#__callback__#", callback)
    }
}