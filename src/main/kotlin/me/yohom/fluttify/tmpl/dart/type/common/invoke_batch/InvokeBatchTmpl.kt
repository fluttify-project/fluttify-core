package me.yohom.fluttify.tmpl.dart.type.common.invoke_batch

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter

//final resultBatch = await MethodChannel(#__channel__#).invokeMethod('#__method_name__#', #__args__#);
private val tmpl = getResource("/tmpl/dart/invoke_batch.stmt.dart.tmpl").readText()

fun InvokeBatchTmpl(method: Method): String {
    val channel = if (method.className.findType().isView()) {
        "viewChannel ? '${ext.methodChannelName}/${method.className.toUnderscore()}' : '${ext.methodChannelName}'"
    } else {
        "'${ext.methodChannelName}'"
    }
    val methodName = "${method.nameWithClass()}_batch"
    val actualParams = method.formalParams
        .filterFormalParams()
        .addParameter(Parameter.simpleParameter(method.className, "this"))
        .map { it.variable }
        .toDartMapBatch {
            when {
                it.typeName.findType().isEnum() -> {
                    // 枚举列表
                    if (it.isList) {
                        "${it.name.depointer()}[i].map((it) => it.index).toList()"
                    } else {
                        "${it.name.depointer()}[i].index"
                    }
                }
                it.typeName.jsonable() -> "${it.name.depointer()}[i]"
                (it.isList && it.genericLevel <= 1) || it.isStructPointer() -> "${it.name.depointer()}[i].map((it) => it.refId).toList()"
                it.genericLevel > 1 -> "[]" // 多维数组暂不处理
                else -> "${it.name.depointer()}[i].refId"
            }
        }
    return tmpl
        .replace("#__channel__#", channel)
        .replace("#__method_name__#", methodName)
        .replace("#__args__#", actualParams)
}