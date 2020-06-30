package me.yohom.fluttify.tmpl.dart.type.type_enum

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Type

//enum #__enum_name__# {
//  #__enumerators__#
//}
//
//extension #__enum_name__#ToX on #__enum_name__# {
//  int toValue() {
//    switch (this) {
//      #__to_int_cases__#
//    }
//  }
//}
//
//extension #__enum_name__#FromX on int {
//  #__enum_name__# to#__enum_name__#() {
//    switch (this) {
//      #__to_enum_cases__#
//      default: #__enum_name__#.values[this + #__offset__#];
//    }
//  }
//}
private val tmpl by lazy { getResource("/tmpl/dart/type_enum.dart.tmpl").readText() }

fun TypeEnumTmpl(type: Type): String {
    val typeName = type.name.toDartType()
    val enumerators = type.enumerators.joinToString(",\n") { "${it.name} /* ${it.value} */" }
    val offset = type.enumerators[0].value ?: 0
    // 如果枚举有值, 那么直接使用, 如果没有值, 那么就index + 偏移量
    val toIntCases = type.enumerators
        .map { "case ${typeName}.${it.name}: return ${it.value ?: "${typeName}.${it.name}.index + $offset"};" }
    val toEnumCases = type.enumerators
        .filter { it.value != null }
        .map { "case ${it.value}: return ${typeName}.${it.name};" }
    return tmpl
        .replace("#__enum_name__#", typeName)
        .replace("#__offset__#", offset.toString())
        .replaceParagraph("#__enumerators__#", enumerators)
        .replaceParagraph("#__to_int_cases__#", toIntCases.joinToString("\n"))
        .replaceParagraph("#__to_enum_cases__#", toEnumCases.joinToString("\n"))
}