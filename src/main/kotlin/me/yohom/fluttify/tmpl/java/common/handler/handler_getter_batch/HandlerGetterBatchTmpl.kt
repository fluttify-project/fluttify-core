package me.yohom.fluttify.tmpl.java.common.handler.handler_getter_batch

import me.yohom.fluttify.extensions.boxedType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Field

//// getter
//put("#__getter_name__#_batch", (__argsBatch__, __methodResult__) -> {
//    List<#__field_type__#> __resultList__ = new ArrayList<>();
//
//    for (int __i__ = 0; __i__ < ((List<Map<String, Object>>) __argsBatch__).size(); __i__++) {
//        Map<String, Object> __args__ = ((List<Map<String, Object>>) __argsBatch__).get(__i__);
//
//        // ref object
//        #__class_name__# __this__ = (#__class_name__#) __args__.get("__this__");
//
//        #__field_type__# __result__ = __this__.#__field_name__#;
//
//        __resultList__.add(__result__);
//    }
//
//    __methodResult__.success(__resultList__);
//});
private val tmpl by lazy { getResource("/tmpl/java/handler_getter_batch.stmt.java.tmpl").readText() }

fun HandlerGetterBatchTmpl(field: Field): String {
    val getterName = field.getterMethodName
    val className = field.className.replace("$", ".")
    val fieldType = field.variable.trueType.boxedType().replace("$", ".")
    val fieldName = field.variable.name

    return tmpl
        .replace("#__getter_name__#", getterName)
        .replace("#__class_name__#", className)
        .replace("#__field_type__#", fieldType)
        .replace("#__field_name__#", fieldName)
}