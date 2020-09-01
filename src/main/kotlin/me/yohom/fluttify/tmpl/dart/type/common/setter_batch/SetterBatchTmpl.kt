package me.yohom.fluttify.tmpl.dart.type.common.setter_batch

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_setter.CallbackSetterTmpl

//Future<void> set_#__name__#_batch(List<#__type__#> #__name__##__view_channel__#) async {
//  await MethodChannel(#__method_channel__#, StandardMethodCodec(FluttifyMessageCodec())).invokeMethod('#__setter_method__#_batch', [for (int i = 0; i < this.length; i++) {'refId': this[i].refId, "#__name__#": #__arg_value__#}]);
//
//  #__callback__#
//}
private val tmpl by lazy { getResource("/tmpl/dart/setter_batch.mtd.dart.tmpl").readText() }

fun SetterBatchTmpl(field: Field): String {
    return field.variable.run {
        val typeName = field.variable.trueType.toDartType()
        val name = name.depointer()

        val viewMethodChannel = "${ext.methodChannelName}/${field.className.toUnderscore()}"
        val normalMethodChannel = ext.methodChannelName
        // 只有当前类是View的时候, 才需要区分普通channel和View channel
        val methodChannel = if (field.className.findType().isView) {
            "viewChannel ? '$viewMethodChannel' : '$normalMethodChannel'"
        } else {
            "'$normalMethodChannel'"
        }

        val argValue = when {
            isEnum() -> "$name[__i__].toValue()"
            field.variable.trueType.jsonable() -> "$name[__i__]"
            (isIterable && getIterableLevel() <= 1) || isStructPointer() -> "$name[__i__].map((it) => it.refId).toList()"
            getIterableLevel() > 1 -> "[]" // 多维数组暂不处理
            else -> "$name[__i__].refId"
        }
        val setterMethodName = field.setterMethodName
        val viewChannel = if (field.className.findType().isView) ", {bool viewChannel = true}" else ""

        val callback = CallbackSetterTmpl(field)

        tmpl
            .replace("#__type__#", typeName)
            .replace("#__name__#", name)
            .replace("#__arg_value__#", argValue)
            .replace("#__method_channel__#", methodChannel)
            .replace("#__setter_method__#", setterMethodName)
            .replace("#__view_channel__#", viewChannel)
            .replace("#__callback__#", callback)
    }
}