package me.yohom.fluttify.tmpl.dart.type.common.invoke

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_enum.ArgEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_enum_list.ArgEnumListTmpl

//final __result__ = await #__channel__#.invokeMethod('#__method_name__#', #__args__#);
private val tmpl by lazy { getResource("/tmpl/dart/invoke.stmt.dart.tmpl").readText() }

fun InvokeTmpl(method: Method): String {
    val channel = if (method.className.findType().isView) {
        val channelName =
            "viewChannel ? '${ext.methodChannelName}/${method.className.toUnderscore()}' : '${ext.methodChannelName}'"
        "MethodChannel($channelName, k${ext.projectName.underscore2Camel()}Codec)"
    } else {
        "k${ext.projectName.underscore2Camel()}Channel"
    }
    val methodName = method.nameWithClass()
    val args = method.formalParams
        .filterFormalParams()
        .run { if (!method.isStatic) addParameter(Parameter.simpleParameter(method.className, "this")) else this }
        .map { it.variable }
        .toDartMap {
            val typeName = it.trueType
            when {
                // 数组
                it.isRefArray() -> "Array.ofList(${it.name})"
                // 枚举
                typeName.findType().isEnum -> ArgEnumTmpl(it) // toValue是配合枚举生成的扩展方法
                // 枚举列表
                it.isIterable
                        && typeName.genericTypes().isNotEmpty()
                        && typeName.genericTypes()[0].findType().isEnum -> {
                    ArgEnumListTmpl(it)
                }
                // Ref类
                else -> it.name
            }
        }
    return tmpl
        .replace("#__channel__#", channel)
        .replace("#__method_name__#", methodName)
        .replace("#__args__#", args)
}