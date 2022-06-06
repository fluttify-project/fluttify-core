package me.yohom.fluttify.tmpl.dart.type.type_ref.type_cast

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type

//else if (T == #__type_name__#) {
//  return (#__constructor__#()..refId = (__this__ as Ref).refId) as T;
//}
private val tmpl by lazy { getResource("/tmpl/dart/type_cast.stmt.dart.tmpl").readText() }
private val dependencyTmpl by lazy { getResource("/tmpl/dart/depencency_type_cast.stmt.dart.tmpl").readText() }

fun TypeCastTmpl(type: Type): String {
    return tmpl
        .replace("#__type_name__#", type.name.containerType().toDartType())
        .replace(
            "#__constructor__#",
            if (type.isInterface) {
                "${type.name.containerType().toDartType()}.subInstance"
            } else {
                type.name.containerType().toDartType()
            }
        )
        .replace("#__method_channel__#", ext.methodChannelName)
        .replace("#__plugin_name__#", ext.projectName)
}

// TODO
fun DependencyTypeCastTmpl(prefix: String, platform: Platform): String {
    return dependencyTmpl
        .replace("#__dependency_prefix__#", prefix.underscore2Camel())
        .replaceGlobal(platform)
}