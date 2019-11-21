package me.yohom.fluttify.tmpl.kotlin.common.handler.handler_setter

import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl

//"#__setter_name__#" to { registrar, args, methodResult ->
//    #__arg__#
//
//    val refId = args["refId"] as Int
//    val ref = HEAP[refId] as #__class_name__#
//
//    ref.#__field_name__# = #__field_value__#
//    methodResult.success("success")
//}
internal class HandlerSetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/handler_setter.stmt.kt.tmpl").readText()

    fun kotlinSetter(): String {
        val setterName = field.setterMethodName()
        val fieldName = field.variable.name
        val arg = when {
            field.variable.jsonable() -> ArgJsonableTmpl(field.variable).kotlinArgJsonable()
            field.variable.isEnum() -> ArgEnumTmpl(field.variable).kotlinArgEnum()
            field.variable.isList -> ArgListTmpl(field.variable).kotlinArgList()
            else -> ArgRefTmpl(field.variable).kotlinArgRef()
        }
        val className = field.className

        return tmpl
            .replace("#__setter_name__#", setterName)
            .replace("#__field_name__#", fieldName)
            .replaceParagraph("#__arg__#", arg)
            .replace("#__class_name__#", className)
            .replace("#__field_value__#", fieldName.run {
                // 因为dart到kotlin这边都是double类型, 如果参数实际类型是float的话, 需要转一手
                if (field.variable.typeName.toLowerCase() == "float") {
                    "${this}.toFloat()"
                } else {
                    this
                }
            })

    }
}