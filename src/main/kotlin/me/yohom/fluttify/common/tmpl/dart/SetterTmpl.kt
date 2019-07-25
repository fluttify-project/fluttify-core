package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Field

/**
 * 生成普通类的dart接口
 */
class SetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/setter.mtd.dart.tmpl").readText()

    fun dartSetter(): String {
        return field.variable?.run {
            val type = type.toDartType()
            val name = name.capitalize()
            val setterMethod = "$type::set${name.capitalize()}"

            tmpl
                .replace("#__type__#", type)
                .replace("#__name__#", name)
                .replace("#__arg__#", name)
                .replace("#__setter_method__#", setterMethod)
        } ?: ""
    }
}