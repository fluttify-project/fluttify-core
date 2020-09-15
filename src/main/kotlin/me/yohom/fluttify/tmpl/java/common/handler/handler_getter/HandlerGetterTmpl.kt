package me.yohom.fluttify.tmpl.java.common.handler.handler_getter

import me.yohom.fluttify.extensions.boxedType
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
//put("#__getter_name__#", (__rawArgs__, __methodResult__) -> {
//   Map<String, Object> __args__ = (Map<String, Object>) __rawArgs__;
//
//   // ref object
//   #__class_name__# __this__ = (#__class_name__#) __args__.get("__this__");
//
//   #__field_type__# __result__ = __this__.#__field_name__#;
//
//    __methodResult__.success(__result__);
//});
private val tmpl by lazy { getResource("/tmpl/java/handler_getter.stmt.java.tmpl").readText() }

fun HandlerGetterTmpl(field: Field): String {
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