package me.yohom.fluttify.tmpl.java.common.handler.handler_setter_batch

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl

//// setter batch
//put("#__setter_name__#_batch", (argsBatch, methodResult) -> {
//    for (int i = 0; i < ((List<Map<String, Object>>) argsBatch).size(); i++) {
//        Map<String, Object> args = ((List<Map<String, Object>>) argsBatch).get(i);
//
//        #__arg__#;
//
//        int refId = (int) ((Map<String, Object>) args).get("__this__");
//        #__class_name__# ref = (#__class_name__#) getHEAP().get(refId);
//
//        ref.#__field_name__# = #__field_value__#;
//    }
//
//    methodResult.success("success");
//});
private val tmpl by lazy { getResource("/tmpl/java/handler_setter_batch.stmt.java.tmpl").readText() }

fun HandlerSetterBatchTmpl(field: Field): String {
    val setterName = field.setterMethodName
    val fieldName = field.variable.name
    val arg = when {
        field.variable.isEnum() -> ArgEnumTmpl(field.variable)
        else -> ArgRefTmpl(field.variable)
    }
    val className = field.className.replace("$", ".")

    return tmpl
        .replace("#__setter_name__#", setterName)
        .replace("#__field_name__#", fieldName)
        .replaceParagraph("#__arg__#", arg)
        .replace("#__class_name__#", className)
        .replace("#__field_value__#", field.variable.var2Args())
}