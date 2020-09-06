package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform

//(result as List).cast<String>().map((it) => #__type_name__#()..refId = it..tag = '#__tag__#').toList()
private val tmpl by lazy { getResource("/tmpl/dart/result_list.stmt.dart.tmpl").readText() }

fun ResultListTmpl(genericType: TYPE_NAME, platform: Platform): String {
    return tmpl
        .replace("#__type_name__#", genericType
            .findType()
            .name
            .depointer()
            .run {
                val genericTypes = findType().definedGenericTypes.joinToStringX(",", "<", ">").toDartType()
                when {
                    isEmpty() -> platform.objectType()
                    toDartType().isDynamic() -> "Ref"
                    findType().isInterface -> "${toDartType().containerType()}.subInstance$genericTypes"
                    else -> this.toDartType()
                }
            })
        .replace("#__tag__#", ext.projectName)
}