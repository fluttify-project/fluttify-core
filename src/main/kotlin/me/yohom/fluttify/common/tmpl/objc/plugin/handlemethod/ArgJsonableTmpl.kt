package me.yohom.fluttify.common.tmpl.objc.plugin.handlemethod

import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.isCType
import me.yohom.fluttify.common.extensions.toObjcType
import me.yohom.fluttify.common.model.Variable

//// jsonable参数
//#__type_name__# #__arg_name__# = (#__type_name__#) args[@"#__arg_name__#"];
internal class ArgJsonableTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/arg_jsonable.stmt.m.tmpl").readText()

    fun objcArgJsonable(): String {
        return tmpl
            .replace(
                "#__type_name__#",
                when {
                    variable.isList -> "List<${variable.typeName}>"
                    variable.typeName.isCType() -> variable.typeName.depointer().toObjcType()
                    else -> variable.typeName
                }
            )
            .replace("#__arg_name__#", variable.name)
    }
}