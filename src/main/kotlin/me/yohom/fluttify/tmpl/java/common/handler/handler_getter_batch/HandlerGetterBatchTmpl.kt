package me.yohom.fluttify.tmpl.java.common.handler.handler_getter_batch

import me.yohom.fluttify.extensions.boxedType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.isVoid
import me.yohom.fluttify.model.Field

//// getter
//put("#__getter_name__#_batch", (argsBatch, methodResult) -> {
//    List<#__result_type__#> resultList = new ArrayList<>();
//
//    for (int i = 0; i < #__arg_name__#ValueList.size(); i++) {
//        Map<String, Object> args = (List<(Map<String, Object>>) argsBatch).get(i);
//
//        // ref object
//        int refId = (int) args.get("refId");
//        #__class_name__# ref = (#__class_name__#) getHEAP().get(refId);
//
//        #__field_type__# result = ref.#__field_name__#;
//
//        #__put_map__#
//
//        resultList.add(#__result__#);
//    }
//
//    methodResult.success(resultList);
//});
private val tmpl = getResource("/tmpl/java/handler_getter_batch.stmt.java.tmpl").readText()

fun HandlerGetterBatchTmpl(field: Field): String {
    val getterName = field.getterMethodName()
    val className = field.className.replace("$", ".")
    val resultType = when {
        field.variable.jsonable() -> field.variable.typeName.boxedType()
        field.variable.typeName.isVoid() -> "String"
        field.variable.isCollection() -> "List<Integer>"
        else -> "Integer"
    }
    val fieldType = field.variable.typeName.replace("$", ".")
    val fieldName = field.variable.name
    val putMap = if (field.variable.jsonable()) "" else "getHEAP().put(result.hashCode(), result);"
    val result = if (field.variable.jsonable()) "result" else "result.hashCode()"

    return tmpl
        .replace("#__getter_name__#", getterName)
        .replace("#__class_name__#", className)
        .replace("#__result_type__#", resultType)
        .replace("#__field_type__#", fieldType)
        .replace("#__field_name__#", fieldName)
        .replace("#__put_map__#", putMap)
        .replace("#__result__#", result)
}