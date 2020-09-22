package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform

//result
fun ResultJsonableTmpl(returnType: TYPE_NAME, platform: Platform): String {
    return when {
        // 如果是原始类型数组, 那么就直接cast
        Regex("(U?[Ii]nt|Float)\\d+List").matches(returnType.toDartType()) -> {
            "__result__ as ${returnType.toDartType()}"
        }
        returnType.isIterable() || returnType.isRefArray() -> {
            val type = when {
                // 说明List有指定泛型, 拿出泛型类
                returnType.iterableLevel() != 0 -> returnType.genericTypes()[0]
                // 数组类型
                returnType.isRefArray() -> returnType.dearray()
                // List没有指定泛型, 使用dynamic
                else -> "dynamic"
            }
            "(__result__ as List).cast<${type.toDartType()}>()"
        }
        else -> "__result__"
    }
}