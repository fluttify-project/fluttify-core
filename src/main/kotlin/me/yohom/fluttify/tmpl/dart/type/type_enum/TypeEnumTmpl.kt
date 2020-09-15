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
    if (type.enumerators.isEmpty()) return ""

    val typeName = type.name.toDartType()
    val enumerators = type.enumerators.joinToString(",\n") { "${it.name} /* ${it.value} */" }
    val offset = type.enumerators[0].value ?: 0

    // 如果枚举有值, 那么直接使用, 如果没有值, 那么就index + 偏移量
    val toIntCases = type.enumerators
        .map {
            val value = when (it.value) {
                // 没有值, 则直接索引+偏移
                null -> "${typeName}.${it.name}.index + $offset"
                // 值是其他枚举, 则调用其他枚举的toValue方法
                in type.enumerators.map { e -> e.name } -> "${type.enumerators.find { e -> e.name == it.value }!!.value}/* ${it.value} */"
                // 直接的值, 直接使用
                else -> it.value
            }
            "case ${typeName}.${it.name}: return ${value};"
        }

    val toEnumCases = type.enumerators
        .filter { it.value != null }
        .map {
            val case = when (it.value) {
                // 没有值, 则直接索引+偏移
                null -> "${typeName}.${it.name}.index + $offset"
                // 值是其他枚举, 则调用其他枚举的value
                in type.enumerators.map { e -> e.name } -> "${type.enumerators.find { e -> e.name == it.value }!!.value}/* ${it.value} */"
                // 直接的值, 直接使用
                else -> it.value
            }
            "case ${case}: return ${typeName}.${it.name};"
        }
    return tmpl
        .replace("#__enum_name__#", typeName)
        .replace("#__offset__#", offset.toString())
        .replaceParagraph("#__enumerators__#", enumerators)
        .replaceParagraph("#__to_int_cases__#", toIntCases.joinToString("\n"))
        .replaceParagraph("#__to_enum_cases__#", toEnumCases.joinToString("\n"))
}