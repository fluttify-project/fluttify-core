package me.yohom.fluttify.tmpl.java.common.handler.handler_getter

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.isVoid
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_enum.ResultEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable.ResultJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list.ResultListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref.ResultRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_void.ResultVoidTmpl

//// getter
//put("#__getter_name__#", (__args__, __methodResult__) -> {
//   Map<String, Object> __args__ = ((List<Map<String, Object>>) __argsBatch__).get(__i__);
//
//   // ref object
//   #__class_name__# ref = (#__class_name__#) getHEAP().get((int) __args__.get("refId"));
//
//   #__field_type__# __result__ = ref.#__field_name__#;
//
//   #__result__#
//
//    __methodResult__.success(jsonableResult);
//});
private val tmpl by lazy { getResource("/tmpl/java/handler_getter.stmt.java.tmpl").readText() }

fun HandlerGetterTmpl(field: Field): String {
    val getterName = field.getterMethodName
    val className = field.className.replace("$", ".")
    val fieldType = field.variable.trueType.replace("$", ".")
    val fieldName = field.variable.name
    val result = when {
        field.variable.jsonable() -> ResultJsonableTmpl(fieldType)
        field.variable.isEnum() -> ResultEnumTmpl()
        field.variable.isIterable -> ResultListTmpl(field.asGetterMethod())
        field.variable.trueType.isVoid() -> ResultVoidTmpl()
        else -> ResultRefTmpl()
    }
    return tmpl
        .replace("#__getter_name__#", getterName)
        .replace("#__class_name__#", className)
        .replace("#__field_type__#", fieldType)
        .replace("#__field_name__#", fieldName)
        .replaceParagraph("#__result__#", result)
}