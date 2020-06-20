package me.yohom.fluttify.tmpl.java.common.handler.handler_getter

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.isVoid
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable.ResultJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list.ResultListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref.ResultRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_void.ResultVoidTmpl

//// getter
//put("#__getter_name__#", (args, methodResult) -> {
//    // ref object
//    int refId = (int) ((Map<String, Object>) args).get("refId");
//    #__class_name__# ref = (#__class_name__#) getHEAP().get(refId);
//
//    #__field_type__# result = ref.#__field_name__#;
//
//    #__put_map__#
//
//    methodResult.success(#__result__#);
//});
private val tmpl by lazy { getResource("/tmpl/java/handler_getter.stmt.java.tmpl").readText() }

fun HandlerGetterTmpl(field: Field): String {
    val getterName = field.getterMethodName
    val className = field.className.replace("$", ".")
    val fieldType = field.variable.trueType.replace("$", ".")
    val fieldName = field.variable.name
    val putMap = if (field.variable.jsonable()) "" else "getHEAP().put(result.hashCode(), result);"
    val result = if (field.variable.jsonable()) "result" else "result.hashCode()"
    return tmpl
        .replace("#__getter_name__#", getterName)
        .replace("#__class_name__#", className)
        .replace("#__field_type__#", fieldType)
        .replace("#__field_name__#", fieldName)
        .replace("#__put_map__#", putMap)
        .replace("#__result__#", result)
}