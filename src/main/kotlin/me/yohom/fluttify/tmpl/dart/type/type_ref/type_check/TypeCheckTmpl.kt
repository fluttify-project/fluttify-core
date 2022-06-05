package me.yohom.fluttify.tmpl.dart.type.type_ref.type_check

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type

//else if (T == #__type_name__#) {
//  final result = await k#__project_prefix__#Channel.invokeMethod('RefClass::isKindOf#__type_name__#', {'__this__': this});
//  return result;
//}
//final #__dependency_prefix__#Object = #__dependency_prefix__##__platform__#As<T>(__this__);
//if (#__dependency_prefix__#Object != null) {
//  return #__dependency_prefix__#Object;
//}
private val tmpl by lazy { getResource("/tmpl/dart/type_check.stmt.dart.tmpl").readText() }
private val dependencyTmpl by lazy { getResource("/tmpl/dart/dependency_type_check.stmt.dart.tmpl").readText() }

fun TypeCheckTmpl(type: Type): String {
    return tmpl
        .replace("#__type_name__#", type.name.containerType().toDartType())
        .replaceGlobal()
}

fun DependencyTypeCheckTmpl(prefix: String, platform: Platform): String {
    return dependencyTmpl
        .replace("#__dependency_prefix__#", prefix.underscore2Camel())
        .replaceGlobal(platform)
}