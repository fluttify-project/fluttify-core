package me.yohom.fluttify.tmpl.dart.type.type_sdk.setter

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_setter.CallbackSetterTmpl

//Future<void> set_#__name__#(#__type__# #__name__#) async {
//  await _channel.invokeMethod('#__setter_method__#', {'refId': refId, "#__name__#": #__arg_value__#});
//
//  #__callback__#
//}
class SetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/setter.mtd.dart.tmpl").readText()

    fun dartSetter(): String {
        return field.variable.run {
            val typeName = field.variable.run {
                var result = typeName.toDartType()
                if (isStructPointer()) {
                    result = "List<$result>"
                } else {
                    for (i in 0 until genericLevel) {
                        result = "List<$result>"
                    }
                }

                result
            }
            val name = name.toDartType()
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
            val callback = CallbackSetterTmpl(field).callback()

            tmpl
                .replace("#__type__#", typeName)
                .replace("#__name__#", name)
                .replace("#__arg_value__#", argValue)
                .replace("#__setter_method__#", setterMethodName)
                .replace("#__callback__#", callback)
        }
    }
}