package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*

//(__result__ as List)?.cast<Ref>()?.map((__it__) => __it__ == null ? null : (#__type_name__#()..refId = (__it__ as Ref).refId))?.toList()
private val tmpl by lazy { getResource("/tmpl/dart/result_list.stmt.dart.tmpl").readText() }

fun ResultListTmpl(genericType: TYPE_NAME): String {
    return tmpl
        .replace("#__type_name__#", genericType
            .findType()
            .name
            .depointer()
            .run {
                val genericTypes = findType().definedGenericTypes.joinToStringX(",", "<", ">").toDartType()
                when {
                    findType().isInterface -> "${toDartType().containerType()}.subInstance$genericTypes"
                    else -> this.toDartType()
                }
            })
        .replace("#__tag__#", ext.projectName)
}