package me.yohom.fluttify.tmpl.kotlin.common.handler.handler_setter

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.toKotlinType
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Field

//"#__setter_name__#" to { registrar, args, methodResult ->
//    val #__field_name__# = args["#__field_name__#"] as #__field_type__#
//
//    val refId = args["refId"] as Int
//    val ref = HEAP_#__plugin_name__#[refId] as #__class_name__#
//
//    ref.#__field_name__# = #__field_value__#
//    methodResult.success("success")
//}
internal class HandlerSetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/handler_setter.stmt.kt.tmpl").readText()

    fun kotlinSetter(): String {
        val setterName = field.setterMethodName()
        val fieldName = field.variable.name
        val fieldType = field.variable.run {
            if (isList) {
                var result = typeName.toKotlinType()
                for (i in 0 until genericLevel) {
                    result = "List<$result>"
                }
                result
            } else {
                typeName.toKotlinType()
            }
        }
        val className = field.className

        return tmpl
            .replace("#__setter_name__#", setterName)
            .replace("#__field_name__#", fieldName)
            .replace("#__field_type__#", fieldType)
            .replace("#__class_name__#", className)
            .replace("#__field_value__#", fieldName.run {
                // 因为dart到kotlin这边都是double类型, 如果参数实际类型是float的话, 需要转一手
                if (field.variable.typeName.toLowerCase() == "float") {
                    "${this}.toFloat()"
                } else {
                    this
                }
            })
            .replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }
}