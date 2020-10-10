package me.yohom.fluttify.tmpl.dart.type.type_ref.type_check

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type

//else if (T == #__type_name__#) {
//  final result = await k#__identifier__#Channel.invokeMethod('RefClass::isKindOf#__type_name__#', {'__this__': this});
//  return result;
//}
private val tmpl by lazy { getResource("/tmpl/dart/type_check.stmt.dart.tmpl").readText() }

fun TypeCheckTmpl(type: Type): String {
    return tmpl
        .replace("#__type_name__#", type.name.containerType().toDartType())
        .replace("#__identifier__#", ext.projectName.underscore2Camel())
        .replace("#__tag__#", ext.projectName)
}