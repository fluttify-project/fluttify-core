package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform

//(result as List).cast<int>().map((it) => #__type_name__#()..refId = it..tag = '#__tag__#').toList()
private val tmpl = getResource("/tmpl/dart/result_list.stmt.dart.tmpl").readText()

fun ResultListTmpl(genericType: TYPE_NAME, platform: Platform): String {
    return tmpl
        .replace("#__type_name__#", genericType
            .findType()
            // 在上层已经把没有子类的抽象类过滤掉了
            // 找出第一个具体类子类去实例化(1. 如果自身是具体类, 那么就是自己 2.逻辑上不合理但是不影响使用), 否则就直接使用类名
            .run { firstConcretSubtype()?.name ?: name }
            .depointer()
            .genericType()
            .toDartType()
            .run {
                if (isEmpty()) {
                    platform.objectType()
                } else {
                    this
                }
            })
        .replace("#__tag__#", ext.projectName)
}