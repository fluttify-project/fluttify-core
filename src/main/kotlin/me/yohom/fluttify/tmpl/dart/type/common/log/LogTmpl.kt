package me.yohom.fluttify.tmpl.dart.type.common.log

import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.removeObjcSpecifier
import me.yohom.fluttify.model.Method

fun LogTmpl(method: Method): String {
    val className = method.className.replace("$", ".")
    val methodName = method.name
    val formalParams = method.formalParams
        .filter { it.variable.trueType.jsonable() }
        .map { "\\'${it.variable.name.removeObjcSpecifier()}\\':$${it.variable.name.removeObjcSpecifier()}" }
    return if (method.isStatic) {
        "debugPrint('fluttify-dart: ${className}::${methodName}(${formalParams})');"
    } else {
        "debugPrint('fluttify-dart: ${className}@\$refId::${methodName}(${formalParams})');"
    }
}