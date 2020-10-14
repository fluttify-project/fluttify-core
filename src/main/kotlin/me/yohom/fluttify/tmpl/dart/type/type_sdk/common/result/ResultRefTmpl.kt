package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*

//__result__ == null ? null : (#__type_name__#()..refId = __result__)
private val tmpl by lazy { getResource("/tmpl/dart/result_ref.stmt.dart.tmpl").readText() }

fun ResultRefTmpl(returnType: TYPE_NAME): String {
    val genericTypes = returnType.findType().definedGenericTypes.joinToStringX(",", "<", ">").toDartType()
    val typeName = when {
        returnType.isPrimitivePointerType() -> returnType.toDartType()
        returnType.findType().isInterface -> "${returnType.toDartType().containerType()}.subInstance$genericTypes"
        else -> returnType.toDartType()
    }
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__tag__#", ext.projectName)
}