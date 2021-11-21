package me.yohom.fluttify.tmpl.dart.type.common.invoke_batch

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter

//final resultBatch = await #__channel__#.invokeMethod('#__method_name__#', #__args__#);
private val tmpl by lazy { getResource("/tmpl/dart/invoke_batch.stmt.dart.tmpl").readText() }

fun InvokeBatchTmpl(method: Method): String {
    val channel = if (method.className.findType().isView) {
        val viewChannelName =
            if (method.isStatic) "'${ext.methodChannelName}/${method.className.toUnderscore()}"
            else "'${ext.methodChannelName}/${method.className.toUnderscore()}/\$refId''"
        val channelName = "viewChannel ? $viewChannelName : '${ext.methodChannelName}'"

        "MethodChannel($channelName, k${ext.projectName.underscore2Camel()}MethodCodec)"
    } else {
        "k${ext.projectName.underscore2Camel()}Channel"
    }

    val methodName = "${method.nameWithClass()}_batch"
    val loopHeader = if (method.isStatic && method.formalParams.isNotEmpty()) {
        "[for (int __i__ = 0; __i__ < ${method.formalParams[0].variable.name}.length; __i__++) {"
    } else {
        "[for (int __i__ = 0; __i__ < this.length; __i__++) {"
    }
    val args = method.formalParams
        .filterFormalParams()
        .run {
            if (!method.isStatic) addParameter(
                Parameter.simpleParameter(
                    method.className,
                    "this"
                )
            ) else this
        }
        .map { it.variable }
        .toDartMapBatch(prefix = loopHeader) {
            val typeName = it.trueType
            val type = typeName.findType()
            when {
                type.isEnum -> {
                    // 枚举列表
                    if (it.isIterable) {
                        "${it.name}[__i__].map((it) => it.toValue()).toList()"
                    } else {
                        "${it.name}[__i__].toValue()"
                    }
                }
                it.isIterable
                        && typeName.genericTypes().isNotEmpty()
                        && typeName.genericTypes()[0].findType().isEnum -> {
                    // 枚举列表
                    "${it.name}[__i__].map((__it__) => __it__.toValue()).toList()"
                }
                else -> "${it.name}[__i__]"
            }
        }
    return tmpl
        .replace("#__channel__#", channel)
        .replace("#__method_name__#", methodName)
        .replace("#__args__#", args)
}