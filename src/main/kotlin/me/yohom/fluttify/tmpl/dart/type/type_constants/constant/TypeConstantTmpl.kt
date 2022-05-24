package me.yohom.fluttify.tmpl.dart.type.type_constants.constant

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable

//Future<#__type_name__#> get #__name__# async {
//  return k#__project_prefix__#Channel.invokeMethod('get#__name__#');
//}
private val tmpl by lazy { getResource("/tmpl/dart/constant.mtd.dart.tmpl").readText() }

fun TypeConstantTmpl(variable: Variable): String {
    return tmpl
        .replace("#__type_name__#", variable.trueType.toDartType().enOptional())
        .replace("#__name__#", variable.name)
        .replaceGlobal()
}