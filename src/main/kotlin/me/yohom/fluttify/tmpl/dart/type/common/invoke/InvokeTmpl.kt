package me.yohom.fluttify.tmpl.dart.type.common.invoke

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter

//final result = await MethodChannel(#__channel__#).invokeMethod('#__method_name__#', #__args__#);
private val tmpl = getResource("/tmpl/dart/invoke.stmt.dart.tmpl").readText()

fun InvokeTmpl(method: Method): String {
    val channel = if (method.className.findType().isView()) {
        "viewChannel ? '${ext.methodChannelName}/${method.className.toUnderscore()}' : '${ext.methodChannelName}'"
    } else {
        "'${ext.methodChannelName}'"
    }
    val methodName = method.nameWithClass()
    val actualParams = method.formalParams
        .filterFormalParams()
        .run { if (!method.isStatic) addParameter(Parameter.simpleParameter("int", "refId")) else this }
        .map { it.variable }
        .toDartMap {
            when {
                it.typeName.findType().isEnum() -> {
                    // 枚举列表
                    if (it.isList) {
                        "${it.name.depointer()}.map((it) => it.index).toList()"
                    } else {
                        "${it.name.depointer()}.index"
                    }
                }
                it.typeName.jsonable() -> it.name.depointer()
                (it.isList && it.genericLevel <= 1) || it.isStructPointer() -> "${it.name.depointer()}.map((it) => it.refId).toList()"
                it.genericLevel > 1 -> "[]" // 多维数组暂不处理
                else -> "${it.name.depointer()}.refId"
            }
        }
    return tmpl
        .replace("#__channel__#", channel)
        .replace("#__method_name__#", methodName)
        .replace("#__args__#", actualParams)
}