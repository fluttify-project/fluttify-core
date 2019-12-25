package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.toDartType

//#__type_name__#()..refId = result..tag = '#__tag__#'
class ResultRefTmpl(private val returnType: TYPE_NAME) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/result_ref.stmt.dart.tmpl").readText()

    fun dartResultRef(): String {
        return tmpl
            .replace(
                "#__type_name__#",
                returnType
                    .findType()
                    // 在上层已经把没有子类的抽象类过滤掉了
                    // 找出第一个具体类子类去实例化(1. 如果自身是具体类, 那么就是自己 2.逻辑上不合理但是不影响使用), 否则就直接使用类名
                    .run { firstConcretSubtype()?.name ?: name }
                    .toDartType()
            )
            .replace("#__tag__#", ext.projectName)
    }
}