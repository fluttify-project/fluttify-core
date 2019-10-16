package me.yohom.fluttify.tmpl.dart.type.type_sdk.method.log

import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.model.Method

class LogTmpl(private val method: Method) {
    fun dartMethodLog(): String {
        return if (method.isStatic) {
            "print('fluttify-dart: ${method.className}::${method.name}(${method.formalParams.filter { it.variable.typeName.jsonable() }.map { "\\'${it.variable.name}\\':$${it.variable.name}" }})');"
        } else {
            "print('fluttify-dart: ${method.className}@\$refId::${method.name}(${method.formalParams.filter { it.variable.typeName.jsonable() }.map { "\\'${it.variable.name}\\':$${it.variable.name}" }})');"
        }
    }
}