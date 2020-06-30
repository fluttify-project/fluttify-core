package me.yohom.fluttify.tmpl.dart.type.common.log

import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.model.Method

fun LogTmpl(method: Method): String {
    return if (method.isStatic) {
        "debugPrint('fluttify-dart: ${method.className.replace("$", ".")}::${method.name}(${method.formalParams.filter { it.variable.trueType.jsonable() }.map { "\\'${it.variable.name}\\':$${it.variable.name}" }})');"
    } else {
        "debugPrint('fluttify-dart: ${method.className.replace("$", ".")}@\$refId::${method.name}(${method.formalParams.filter { it.variable.trueType.jsonable() }.map { "\\'${it.variable.name}\\':$${it.variable.name}" }})');"
    }
}