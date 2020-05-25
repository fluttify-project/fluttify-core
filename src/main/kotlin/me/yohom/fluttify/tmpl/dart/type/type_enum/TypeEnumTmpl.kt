package me.yohom.fluttify.tmpl.dart.type.type_enum

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Type

//enum #__enum_name__# {
//  #__enum_constant__#
//}
/**
 * 生成普通类的dart接口
 */
private val tmpl = getResource("/tmpl/dart/type_enum.dart.tmpl").readText()

fun TypeEnumTmpl(type: Type): String {
    return tmpl
        .replace("#__enum_name__#", type.name.toDartType())
        .replaceParagraph("#__enum_constant__#", type.constants.joinToString(",\n"))
}