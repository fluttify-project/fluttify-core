package me.yohom.fluttify.tmpl.dart.type.common.setter

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_enum.ArgEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_setter.CallbackSetterTmpl

//Future<void> set_#__name__#(#__type__# #__name__##__view_channel__#) async {
//  await MethodChannel(#__method_channel__#, StandardMethodCodec(FluttifyMessageCodec())).invokeMethod('#__setter_method__#', {'__this__': this, #__args__#});
//
//  #__callback__#
//}
private val tmpl by lazy { getResource("/tmpl/dart/setter.mtd.dart.tmpl").readText() }

fun SetterTmpl(field: Field): String {
    return field.variable.run {
        val typeName = field.variable.trueType.toDartType()

        val viewMethodChannel = "${ext.methodChannelName}/${field.className.toUnderscore()}"
        val normalMethodChannel = ext.methodChannelName
        // 只有当前类是View的时候, 才需要区分普通channel和View channel
        val methodChannel = if (field.className.findType().isView) {
            "viewChannel ? '$viewMethodChannel' : '$normalMethodChannel'"
        } else {
            "'$normalMethodChannel'"
        }

        val argValue = field.variable.trueType.run {
            when {
                isEnum() -> ArgEnumTmpl(field.variable)
                else -> name
            }
        }
        val setterMethodName = field.setterMethodName
        val viewChannel = if (field.className.findType().isView) ", {bool viewChannel = true}" else ""

        val callback = CallbackSetterTmpl(field)

        tmpl
            .replace("#__type__#", typeName)
            .replace("#__name__#", name)
            .replace("#__args__#", if (typeName.findType().isCallback) "" else "\"$name\": $argValue")
            .replace("#__method_channel__#", methodChannel)
            .replace("#__setter_method__#", setterMethodName)
            .replace("#__view_channel__#", viewChannel)
            .replace("#__callback__#", callback)
            .replace("#__tag__#", ext.projectName)
    }
}