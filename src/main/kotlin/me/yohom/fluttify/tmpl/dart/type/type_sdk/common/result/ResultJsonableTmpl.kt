package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform

//result
fun ResultJsonableTmpl(returnType: TYPE_NAME, platform: Platform): String {
    return if (returnType.isCollection()) {
        val type = when {
            // 说明List有指定泛型, 拿出泛型类
            returnType.collectionLevel() != 0 -> returnType.genericType().toDartType()
            // 数组类型
            returnType.isArray() -> returnType.dearray()
            // List没有指定泛型, 使用各个平台的Object类
            else -> platform.objectType()
        }
        "(result as List).cast<${type.toDartType()}>()"
    } else {
        "result"
    }
}