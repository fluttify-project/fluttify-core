package me.yohom.fluttify.tmpl.dart.type.common.setter

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_setter.CallbackSetterTmpl

//Future<void> set_#__name__#(#__type__# #__name__##__view_channel__#) async {
//  await MethodChannel(#__method_channel__#).invokeMethod('#__setter_method__#', {'refId': refId, "#__name__#": #__arg_value__#});
//
//  #__callback__#
//}
class SetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/setter.mtd.dart.tmpl").readText()

    fun dartSetter(): String {
        return field.variable.run {
            val typeName = field.variable.run {
                var result = typeName.findType().run { if (isAlias()) aliasOf!! else typeName }.toDartType()
                if (isStructPointer()) {
                    result = "List<$result>"
                } else if (isCollection()) {
                    for (i in 0 until genericLevel) {
                        result = "List<$result>"
                    }
                }
                result
            }
            val name = name.toDartType()

            val viewMethodChannel = "${ext.methodChannelName}/${field.className.toUnderscore()}"
            val normalMethodChannel = ext.methodChannelName
            // 只有当前类是View的时候, 才需要区分普通channel和View channel
            val methodChannel = if (field.className.findType().isView()) {
                "viewChannel ? '$viewMethodChannel' : '$normalMethodChannel'"
            } else {
                "'$normalMethodChannel'"
            }

            val argValue = name.depointer().run {
                when {
                    isEnum() -> "${name}.index"
                    typeName.jsonable() -> name
                    (isList && genericLevel <= 1) || isStructPointer() -> "${name}.map((it) => it.refId).toList()"
                    genericLevel > 1 -> "[]" // 多维数组暂不处理
                    else -> "${name}.refId"
                }
            }
            val setterMethodName = field.setterMethodName()
            val viewChannel = if (field.className.findType().isView()) ", {bool viewChannel = true}" else ""

            val callback = CallbackSetterTmpl(field).callback()

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
}