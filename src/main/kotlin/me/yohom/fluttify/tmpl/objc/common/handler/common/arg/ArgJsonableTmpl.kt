package me.yohom.fluttify.tmpl.objc.common.handler.common.arg

import me.yohom.fluttify.SYSTEM_TYPEDEF
import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.extensions.isObjcValueType
import me.yohom.fluttify.extensions.toObjcType
import me.yohom.fluttify.model.Variable

//// jsonable参数
//#__type_name__# #__arg_name__# = #__right_value__#;
internal class ArgJsonableTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/arg_jsonable.stmt.m.tmpl").readText()

    fun objcArgJsonable(): String {
        val typeName = when {
            variable.isList -> "List<${variable.typeName}>"
            variable.typeName.isObjcValueType() -> variable.typeName.depointer().toObjcType()
            else -> variable.typeName.enpointer()
        }
        val rightValue = if (variable.typeName.isObjcValueType()) {
            var methodPrefix = SYSTEM_TYPEDEF[variable.typeName] ?: variable
                .typeName
                .depointer()
                .toLowerCase()
                .removePrefix("ns")
                .removePrefix("cg")
            if (variable.typeName == "NSUInteger") {
                methodPrefix = "unsignedInteger"
            }
            "[args[@\"${variable.name.depointer()}\"] ${methodPrefix}Value]"
        } else {
            // 理论上, 这里目前应该只有NSString会走到这里
            "(${variable.typeName.enpointer()}) args[@\"${variable.name.depointer()}\"]"
        }
        val argName = variable.name.depointer()

        return tmpl
            .replace("#__type_name__#", typeName)
            .replace("#__right_value__#", rightValue)
            .replace("#__arg_name__#", argName)
    }
}