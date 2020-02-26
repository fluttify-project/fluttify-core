package me.yohom.fluttify.tmpl.java.common.handler.handler_getter_batch

import me.yohom.fluttify.extensions.boxedType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.isVoid
import me.yohom.fluttify.extensions.stringArray2List
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
    val resultType = when {
        field.variable.jsonable() -> field.variable.typeName.boxedType().stringArray2List()
        field.variable.typeName.isVoid() -> "String"
        field.variable.isCollection() -> "List<Integer>"
        else -> "Integer"
    }
    val fieldType = field.variable.typeName.replace("$", ".")
    val fieldName = field.variable.name
    val result = when {
        field.variable.jsonable() -> ResultJsonableTmpl(field.variable.typeName)
        field.variable.isList -> ResultListTmpl(field.asGetterMethod())
        field.variable.typeName.isVoid() -> ResultVoidTmpl()
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