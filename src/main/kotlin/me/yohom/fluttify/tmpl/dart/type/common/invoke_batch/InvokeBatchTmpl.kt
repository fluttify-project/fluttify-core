package me.yohom.fluttify.tmpl.dart.type.common.invoke_batch

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter

//final resultBatch = await MethodChannel(#__channel__#).invokeMethod('#__method_name__#', #__args__#);
private val tmpl = getResource("/tmpl/dart/invoke_batch.stmt.dart.tmpl").readText()

fun InvokeBatchTmpl(method: Method): String {
    val channel = if (method.className.findType().isView) {
        "viewChannel ? '${ext.methodChannelName}/${method.className.toUnderscore()}' : '${ext.methodChannelName}'"
    } else {
        "'${ext.methodChannelName}'"
    }
    val methodName = "${method.nameWithClass()}_batch"
    val loopHeader = if (method.isStatic && method.formalParams.isNotEmpty()) {
        "[for (int __i__ = 0; __i__ < ${method.formalParams[0].variable.name}.length; __i__++) {"
    } else {
        "[for (int __i__ = 0; __i__ < this.length; __i__++) {"
    }
    val args = method.formalParams
        .filterFormalParams()
        .run { if (!method.isStatic) addParameter(Parameter.simpleParameter(method.className, "this")) else this }
        .map { it.variable }
        .toDartMapBatch(prefix = loopHeader) {
            val type = if (it.isAliasType()) it.trueType.findType().aliasOf!! else it.trueType
            when {
                type.findType().isEnum -> {
                    // 枚举列表
                    if (it.isIterable) {
                        "${it.name}[__i__].map((it) => it.index).toList()"
                    } else {
                        "${it.name}[__i__].index"
                    }
                }
                type.jsonable() -> "${it.name}[__i__]"
                (it.isIterable && it.getIterableLevel() <= 1) || it.isStructPointer() -> "${it.name.depointer()}[__i__].map((it) => it.refId).toList()"
                it.getIterableLevel() > 1 -> "[]" // 多维数组暂不处理
                else -> "${it.name}[__i__].refId"
            }
        }
    return tmpl
        .replace("#__channel__#", channel)
        .replace("#__method_name__#", methodName)
        .replace("#__args__#", args)
}