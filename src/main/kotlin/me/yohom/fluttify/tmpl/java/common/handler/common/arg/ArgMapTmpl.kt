package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable

//// map arg
//#__type_name__# #__arg_name__# = new HashMap<>();
//if (__#__arg_name__#RefId__ != null) {
//    java.util.Map<#__key_type__#, #__value_type__#> map = (java.util.Map<#__key_type__#, #__value_type__#>) getHEAP().get(__#__arg_name__#RefId__);
//    for (Entry<#__key_type__#, #__value_type__#> entry : map.entrySet()) {
//        #__arg_name__#.put(#__key__#, #__value__#);
//    }
//}
private val tmpl by lazy { getResource("/tmpl/java/arg_map.stmt.java.tmpl").readText() }

fun ArgMapTmpl(variable: Variable): String {
    val typeName = variable.trueType

    val keyType = typeName.substringAfter("\u003c").substringBefore(",")
    val valueType = typeName.substringAfter(",").substringBefore("\u003e")

    val argKeyType = when {
        keyType.jsonable() || keyType == "java.io.Serializable" -> keyType
        else -> "Integer"
    }
    val argValueType = when {
        // 实际传递的时候, 会把Serializable换成String
        valueType.jsonable() /*|| valueType == "java.io.Serializable"*/ -> valueType
        valueType.findType().isEnum -> "Integer"
        // Ref列表
        (valueType.isIterable() && valueType.iterableLevel() <= 1) || valueType.isStructPointer() -> "List<Integer>"
        else -> "Integer"
    }

    val key = when {
        // 先去除的转换 降低复杂度
        keyType.jsonable() /*|| keyType == "java.io.Serializable"*/ -> "entry.getKey()"
        keyType.findType().isEnum -> "${keyType}.values()[entry.getKey()]"
        else -> "($keyType) getHEAP().get(entry.getKey())"
    }
    val value = when {
        valueType.jsonable() /*|| valueType == "java.io.Serializable"*/ -> "entry.getValue()"
        valueType.findType().isEnum -> "${valueType}.values()[entry.getValue()]"
        // Ref列表
        (valueType.isIterable() && valueType.iterableLevel() <= 1) || valueType.isStructPointer() -> "new ArrayList() /* 暂未实现 */"
        else -> "($valueType) getHEAP().get(entry.getValue())"
    }
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__arg_name__#", variable.name)
        .replace("#__key_type__#", argKeyType)
        .replace("#__value_type__#", argValueType)
        .replace("#__key__#", key)
        .replace("#__value__#", value)
}