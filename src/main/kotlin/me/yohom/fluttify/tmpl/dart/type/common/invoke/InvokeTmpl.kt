package me.yohom.fluttify.tmpl.dart.type.common.invoke

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter

//final result = await MethodChannel(#__channel__#).invokeMethod('#__method_name__#', #__args__#);
private val tmpl by lazy { getResource("/tmpl/dart/invoke.stmt.dart.tmpl").readText() }

fun InvokeTmpl(method: Method): String {
    val channel = if (method.className.findType().isView) {
        "viewChannel ? '${ext.methodChannelName}/${method.className.toUnderscore()}' : '${ext.methodChannelName}'"
    } else {
        "'${ext.methodChannelName}'"
    }
    val methodName = method.nameWithClass()
    val args = method.formalParams
        .filterFormalParams()
        .run { if (!method.isStatic) addParameter(Parameter.simpleParameter("int", "refId")) else this }
        .map { it.variable }
        .toDartMap {
            val typeName = it.trueType
            val type = typeName.findType()
            when {
                typeName.findType().isEnum -> {
                    // TODO 如果枚举有值的话直接使用值
                    "${it.name}.index + ${type.enumerators[0].value}"
                }
                it.isIterable
                        && typeName.genericTypes().isNotEmpty()
                        && typeName.genericTypes()[0].findType().isEnum -> {
                    // 枚举列表
                    "${it.name}.map((__it__) => __it__?.index + ${typeName.genericTypes()[0].findType().enumerators[0].value})?.toList()"
                }
                typeName.jsonable() -> it.name
                (it.isIterable && it.getIterableLevel() <= 1) || it.isStructPointer() -> "${it.name}.map((__it__) => __it__?.refId).toList()"
                it.getIterableLevel() > 1 -> "[]" // 多维数组暂不处理
                // dynamic类型需要根据是否是Ref类型来区分是直接传还是传refId
                typeName.toDartType() == "dynamic" -> "${it.name} is Ref ? (${it.name} as Ref)?.refId : ${it.name}"
                else -> "${it.name}?.refId"
            }
        }
    return tmpl
        .replace("#__channel__#", channel)
        .replace("#__method_name__#", methodName)
        .replace("#__args__#", args)
}