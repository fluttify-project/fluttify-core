package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.dearray
import me.yohom.fluttify.extensions.enlist
import me.yohom.fluttify.model.Variable

//// jsonable arg
//#__type_name__# #__arg_name__# = (#__type_name__#) args.get("#__arg_name__#");
internal class ArgJsonableTmpl(private val variable: Variable) {
    private val tmpl =
        this::class.java.getResource("/tmpl/java/arg_jsonable.stmt.java.tmpl").readText()

    fun javaArgJsonable(): String {
        val type = variable.typeName.run { if (toLowerCase() == "float") "Double" else this }
        return tmpl
            // 如果是数组, 那么需要去掉`[]`, 再补成列表
            .replace("#__type_name__#", if (variable.isList) type.dearray().enlist() else type)
            .replace("#__arg_name__#", variable.name)
    }
}