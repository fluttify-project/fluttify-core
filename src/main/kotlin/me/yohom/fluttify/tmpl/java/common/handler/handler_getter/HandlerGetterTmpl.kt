package me.yohom.fluttify.tmpl.java.common.handler.handler_getter

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Field

//put("#__getter_name__#", (args, methodResult) -> {
//    // ref object
//    int refId = (int) args.get("refId");
//    #__class_name__# ref = (#__class_name__#) getHEAP().get(refId);
//
//    #__field_type__# result = ref.#__field_name__#;
//
//    #__put_map__#
//
//    methodResult.success(#__result__#);
//});
private val tmpl = getResource("/tmpl/java/handler_getter.stmt.java.tmpl").readText()

fun HandlerGetterTmpl(field: Field): String {
    return tmpl
        .replace("#__getter_name__#", field.getterMethodName())
        .replace("#__class_name__#", field.className.replace("$", "."))
        .replace("#__field_type__#", field.variable.typeName.replace("$", "."))
        .replace("#__field_name__#", field.variable.name)
        .replace(
            "#__put_map__#",
            if (field.variable.jsonable()) "" else "getHEAP().put(result.hashCode(), result);"
        )
        .replace(
            "#__result__#",
            if (field.variable.jsonable()) "result" else "result.hashCode()"
        )
}