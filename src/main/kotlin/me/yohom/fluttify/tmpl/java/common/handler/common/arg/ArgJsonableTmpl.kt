package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.dearray
import me.yohom.fluttify.extensions.enList
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// jsonable arg
//#__type_name__# #__arg_name__# = #__cast_type_name__# ((Map<String, Object>) args).get("#__arg_name__#");
private val tmpl = getResource("/tmpl/java/arg_jsonable.stmt.java.tmpl").readText()

fun ArgJsonableTmpl(variable: Variable): String {
    val type = variable.typeName.run {
        when {
            // java端不会以float接收数据, 一律都是double
            toLowerCase() == "float" -> "Double"
            else -> this
        }
    }
    return tmpl
        .replace("#__type_name__#", type)
        .replace(
            "#__cast_type_name__#",
            // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.
            // dart端只有int, 不区分32位和64位, java端具体类型由数值大小决定, 所以如果要精确处理这个问题的话会比较麻烦, 这里先一律转成int处理
            // 后期如果真的碰到int无法满足的情况再想办法
            when (variable.typeName) {
                "Long" -> "(Long) (long) (int)"
                "long" -> "(long) (int)"
                else -> "($type)"
            }
        )
        .replace("#__arg_name__#", variable.name)
}