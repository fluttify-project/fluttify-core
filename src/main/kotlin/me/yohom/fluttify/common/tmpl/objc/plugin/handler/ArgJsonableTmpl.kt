package me.yohom.fluttify.common.tmpl.objc.plugin.handler

import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.enpointer
import me.yohom.fluttify.common.extensions.isObjcValueType
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
                    variable.typeName.isObjcValueType() -> variable.typeName.depointer().toObjcType()
                    else -> variable.typeName.enpointer()
                }
            )
            .replace("#__arg_name__#", variable.name.depointer())
    }
}