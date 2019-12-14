package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.dearray
import me.yohom.fluttify.extensions.enList
import me.yohom.fluttify.model.Variable

//// jsonable arg
//#__type_name__# #__arg_name__# = (#__type_name__#) args.get("#__arg_name__#");
internal class ArgJsonableTmpl(private val variable: Variable) {
    private val tmpl =
        this::class.java.getResource("/tmpl/java/arg_jsonable.stmt.java.tmpl").readText()

    fun javaArgJsonable(): String {
        val type = variable.typeName.run { if (toLowerCase() == "float") "Double" else this }
        return tmpl
            .replace(
                "#__type_name__#",
                when {
                    // 如果是数组, 那么需要去掉`[]`, 再补成列表
                    variable.isStringArray() -> type.dearray().enList()
                    // 基本数据类型数组 保持原样
                    variable.isArray() -> type
                    // 其他列表类型, 加上List<>
                    variable.isList -> type.enList()
                    else -> type
                }
            )
            .replace("#__arg_name__#", variable.name)
    }
}