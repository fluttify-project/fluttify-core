package me.yohom.fluttify.tmpl.java.common.handler.handler_getter_batch

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable.ResultJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list.ResultListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref.ResultRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_void.ResultVoidTmpl

//// getter
//put("#__getter_name__#_batch", (argsBatch, methodResult) -> {
//    List<#__result_type__#> resultList = new ArrayList<>();
//
//    for (int i = 0; i < ((List<Map<String, Object>>) argsBatch).size(); i++) {
//        Map<String, Object> args = ((List<Map<String, Object>>) argsBatch).get(i);
//
//        // ref object
//        #__class_name__# ref = (#__class_name__#) getHEAP().get((int) args.get("refId"));
//
//        #__field_type__# result = ref.#__field_name__#;
//
//        #__result__#
//
//        resultList.add(jsonableResult);
//    }
//
//    methodResult.success(resultList);
//});
private val tmpl = getResource("/tmpl/java/handler_getter_batch.stmt.java.tmpl").readText()

fun HandlerGetterBatchTmpl(field: Field): String {
    val getterName = field.getterMethodName()
    val className = field.className.replace("$", ".")
    val resultType = field.variable.run {
        when {
            jsonable() -> trueType.boxedType().stringArray2List()
            trueType.isVoid() -> "String"
            isIterable -> "Integer".enList(getIterableLevel())
            else -> "Integer"
        }
    }
    val fieldType = field.variable.trueType.replace("$", ".")
    val fieldName = field.variable.name
    val result = when {
        field.variable.jsonable() -> ResultJsonableTmpl(fieldType)
        field.variable.isIterable -> ResultListTmpl(field.asGetterMethod())
        field.variable.trueType.isVoid() -> ResultVoidTmpl()
        else -> ResultRefTmpl()
    }

    return tmpl
        .replace("#__getter_name__#", getterName)
        .replace("#__class_name__#", className)
        .replace("#__result_type__#", resultType)
        .replace("#__field_type__#", fieldType)
        .replace("#__field_name__#", fieldName)
        .replace("#__result__#", result)
}