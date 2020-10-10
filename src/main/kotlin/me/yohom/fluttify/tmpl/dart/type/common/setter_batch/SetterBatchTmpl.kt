package me.yohom.fluttify.tmpl.dart.type.common.setter_batch

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_setter.CallbackSetterTmpl

//Future<void> set_#__name__#_batch(List<#__type__#> #__name__##__view_channel__#) async {
//  await MethodChannel(#__method_channel__#, StandardMethodCodec(FluttifyMessageCodec(#__tag__#))).invokeMethod('#__setter_method__#_batch', [for (int __i__ = 0; __i__ < this.length; __i__++) {'__this__': this[__i__], "#__name__#": #__arg_value__#}]);
//
//  #__callback__#
//}
private val tmpl by lazy { getResource("/tmpl/dart/setter_batch.mtd.dart.tmpl").readText() }

fun SetterBatchTmpl(field: Field): String {
    return field.variable.run {
        val typeName = field.variable.trueType.toDartType()
        val name = name.depointer()

        val channel = if (field.className.findType().isView) {
            val channelName = "viewChannel ? '${ext.methodChannelName}/${field.className.toUnderscore()}' : '${ext.methodChannelName}'"
            "MethodChannel($channelName, StandardMethodCodec(FluttifyMessageCodec('${ext.projectName}')))"
        } else {
            "k${ext.projectName.underscore2Camel()}Channel"
        }

        val argValue = when {
            isEnum() -> "$name[__i__].toValue()"
            else -> "$name[__i__]"
        }
        val setterMethodName = field.setterMethodName
        val viewChannel = if (field.className.findType().isView) ", {bool viewChannel = true}" else ""

        val callback = CallbackSetterTmpl(field)

        tmpl
            .replace("#__type__#", typeName)
            .replace("#__name__#", name)
            .replace("#__arg_value__#", argValue)
            .replace("#__tag__#", ext.projectName)
            .replace("#__channel__#", channel)
            .replace("#__setter_method__#", setterMethodName)
            .replace("#__view_channel__#", viewChannel)
            .replace("#__callback__#", callback)
    }
}