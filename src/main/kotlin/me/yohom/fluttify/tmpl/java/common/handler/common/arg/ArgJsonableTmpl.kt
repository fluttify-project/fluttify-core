package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.dearray
import me.yohom.fluttify.extensions.enList
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.ListType
import me.yohom.fluttify.model.Variable

//// jsonable arg
//#__type_name__# #__arg_name__# = (#__type_name__#) args.get("#__arg_name__#");
private val tmpl = getResource("/tmpl/java/arg_jsonable.stmt.java.tmpl").readText()

fun ArgJsonableTmpl(variable: Variable): String {
    val type = variable.typeName.run { if (toLowerCase() == "float") "Double" else this }
    return tmpl
        .replace(
            "#__type_name__#",
            when {
                // 如果是数组, 那么需要去掉`[]`, 再补成列表
                variable.isStringArray() -> type.dearray().enList()
                // 其他列表类型, 加上List<>
                variable.listType == ListType.List -> type.enList()
                else -> type
            }
        )
        .replace("#__arg_name__#", variable.name)
}