package me.yohom.fluttify.tmpl.java.common.handler.handler_setter

import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl

//// setter
//put("#__setter_name__#", (args, methodResult) -> {
//    #__arg__#;
//
//    int refId = (int) args.get("refId");
//    #__class_name__# ref = (#__class_name__#) getHEAP().get(refId);
//
//    ref.#__field_name__# = #__field_value__#;
//    methodResult.success("success");
//});
internal class HandlerSetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/java/handler_setter.stmt.java.tmpl").readText()

    fun javaSetter(): String {
        val setterName = field.setterMethodName()
        val fieldName = field.variable.name
        val arg = when {
            field.variable.jsonable() -> ArgJsonableTmpl(field.variable).javaArgJsonable()
            field.variable.isEnum() -> ArgEnumTmpl(field.variable).javaArgEnum()
            field.variable.isList -> ArgListTmpl(field.variable).javaArgList()
            else -> ArgRefTmpl(field.variable).javaArgRef()
        }
        val className = field.className

        return tmpl
            .replace("#__setter_name__#", setterName)
            .replace("#__field_name__#", fieldName)
            .replaceParagraph("#__arg__#", arg)
            .replace("#__class_name__#", className)
            .replace("#__field_value__#", fieldName.run {
                // 因为dart到java这边都是double类型, 如果参数实际类型是float的话, 需要转一手
                if (field.variable.typeName.toLowerCase() == "float") {
                    "new Double(${this}).floatValue()"
                } else {
                    this
                }
            })
    }
}