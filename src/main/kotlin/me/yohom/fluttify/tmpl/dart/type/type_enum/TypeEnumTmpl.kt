package me.yohom.fluttify.tmpl.dart.type.type_enum

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.removeNumberSuffix
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Enumerator
import me.yohom.fluttify.model.SDK
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

    val allEnumerators = SDK.sdks.flatMap { it.allEnumTypes }.flatMap { it.enumerators }

    val typeName = type.name.toDartType()
    val enumerators = type.enumerators.joinToString(",\n") { "${it.name} /* ${it.value} */" }
    val offset = type.enumerators[0].let {
        when (it.value) {
            // 没有值, 则为0
            null -> "0"
            // 值是其他枚举, 则调用其他枚举的值
            in allEnumerators.map { e -> e.name } -> "${allEnumerators.find { e -> e.name == it.value }!!.value}/* ${it.value} */"
            // 直接的值, 直接使用
            else -> it.value.removeNumberSuffix()
        }
    }

    fun Enumerator.enumerator2Value(): String {
        return when (this.value) {
            // 没有值, 则直接索引+偏移
            null -> "${typeName}.${name}.index + $offset"
            // 值是其他枚举, 则调用其他枚举的值
            in allEnumerators.map { e -> e.name } -> "${allEnumerators.find { e -> e.name == value }!!.value}/* $value */"
            // 直接的值, 直接使用
            else -> value
        }
    }

    // 如果枚举有值, 那么直接使用, 如果没有值, 那么就index + 偏移量
    val toIntCases = type.enumerators
        .map {
            "case ${typeName}.${it.name}: return ${it.enumerator2Value()};"
        }

    val toEnumCases = type.enumerators
        .filter { it.value != null }
        .map {
            "case ${it.enumerator2Value()}: return ${typeName}.${it.name};"
        }
    return tmpl
        .replace("#__enum_name__#", typeName)
        .replace("#__offset__#", offset)
        .replaceParagraph("#__enumerators__#", enumerators)
        .replaceParagraph("#__to_int_cases__#", toIntCases.joinToString("\n"))
        .replaceParagraph("#__to_enum_cases__#", toEnumCases.joinToString("\n"))
}