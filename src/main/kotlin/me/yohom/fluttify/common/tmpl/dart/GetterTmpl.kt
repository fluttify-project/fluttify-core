package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.common.model.Field

/**
 * 生成普通类的dart接口
 */
class GetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/getter.mtd.dart.tmpl").readText()

    fun dartGetter(): String {
        return field.variable?.run {
            val type = type
            val name = name
            val getterMethod = "$type::get${name.capitalize()}"

            tmpl
                .replace("#__type__#", type)
                .replace("#__name__#", name)
                .replace("#__getter_method__#", getterMethod)
        } ?: ""
    }
}