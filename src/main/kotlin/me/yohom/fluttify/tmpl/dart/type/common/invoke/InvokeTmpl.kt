package me.yohom.fluttify.tmpl.dart.type.common.invoke

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_enum.ArgEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_enum_list.ArgEnumListTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_jsonable.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_list.ArgListTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_map.ArgMapTmpl
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_ref.ArgRefTmpl

//final __result__ = await MethodChannel(#__channel__#).invokeMethod('#__method_name__#', #__args__#);
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
            when {
                // 枚举
                typeName.findType().isEnum -> ArgEnumTmpl(it) // toValue是配合枚举生成的扩展方法
                // 枚举列表
                it.isIterable
                        && typeName.genericTypes().isNotEmpty()
                        && typeName.genericTypes()[0].findType().isEnum -> {
                    ArgEnumListTmpl(it)
                }
                // jsonable
                typeName.jsonable() -> ArgJsonableTmpl(it)
                // Ref列表
                (it.isIterable && it.getIterableLevel() <= 1) || it.isStructPointer() -> ArgListTmpl(it)
                // 多维列表不处理
                it.getIterableLevel() > 1 -> "[]" // 多维数组暂不处理
                // 非jsonable的Map
                it.isMap() -> ArgMapTmpl(it)
                // Ref类
                else -> ArgRefTmpl(it)
            }
        }
    return tmpl
        .replace("#__channel__#", channel)
        .replace("#__method_name__#", methodName)
        .replace("#__args__#", args)
}