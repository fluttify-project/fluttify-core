package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform

//result
class ResultJsonableTmpl(val returnType: TYPE_NAME, val platform: Platform) {
    fun dartResultJsonable(): String {
        return if (returnType.isList()) {
            val type = when {
                // 说明List有指定泛型, 拿出泛型类
                returnType.genericLevel() != 0 -> returnType.genericType().toDartType()
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
}