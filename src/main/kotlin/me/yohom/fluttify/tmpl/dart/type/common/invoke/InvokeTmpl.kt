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

//final __result__ = await MethodChannel(#__channel__#, StandardMethodCodec(FluttifyMessageCodec())).invokeMethod('#__method_name__#', #__args__#);
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
        .run { if (!method.isStatic) addParameter(Parameter.simpleParameter(method.className, "this")) else this }
        .map { it.variable }
        .toDartMap()
    return tmpl
        .replace("#__channel__#", channel)
        .replace("#__method_name__#", methodName)
        .replace("#__args__#", args)
}