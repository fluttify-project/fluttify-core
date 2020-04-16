package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*

//#__type_name__#()..refId = result..tag = '#__tag__#'
private val tmpl = getResource("/tmpl/dart/result_ref.stmt.dart.tmpl").readText()

fun ResultRefTmpl(returnType: TYPE_NAME): String {
    val typeName = when {
        returnType.isPrimitivePointerType() -> returnType.toDartType()
        returnType.toDartType() == "dynamic" -> "Ref"
        else -> {
            returnType
                .findType()
                // 在上层已经把没有子类的抽象类过滤掉了
                // 找出第一个具体类子类去实例化(1. 如果自身是具体类, 那么就是自己 2.逻辑上不合理但是不影响使用), 否则就直接使用类名
                .run { firstConcretSubtype()?.name ?: name }
                .toDartType()
        }
    }
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__tag__#", ext.projectName)
}