package me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_map

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_ref.ArgRefTmpl

//{for (final entry in #__arg_name__#.entries) #__key__#: #__value__#}
private val tmpl by lazy { getResource("/tmpl/dart/arg_map.stmt.dart.tmpl").readText() }

fun ArgMapTmpl(variable: Variable): String {
    val typeName = variable.trueType
    val keyType = typeName.substringAfter("\u003c").substringBefore(",")
    val valueType = typeName.substringAfter(",").substringBefore("\u003e")

    val argKeyType = when {
        keyType.jsonable() -> "entry.key"
        keyType.findType().isEnum -> "entry.key.index"
        else -> "entry.key.refId"
    }
    val argValueType = when {
        // 实际传递的时候, 会把Serializable换成String
        valueType.jsonable() || valueType == "java.io.Serializable" -> "entry.value"
        valueType.findType().isEnum -> "entry.value.index"
        // Ref列表
        (valueType.isIterable() && valueType.iterableLevel() <= 1) || valueType.isStructPointer() -> "entry.value.map((e) => e.refId).toList()"
        else -> "entry.value.refId"
    }
    return tmpl
        .replace("#__arg_name__#", variable.name)
        .replace("#__key__#", argKeyType)
        .replace("#__value__#", argValueType)
}