package me.yohom.fluttify.tmpl.java.common.handler.handler_getter

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
//    methodResult.success(result);
//});
internal class HandlerGetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/java/handler_getter.stmt.java.tmpl").readText()

    fun kotlinGetter(): String {
        return tmpl
            .replace("#__getter_name__#", field.getterMethodName())
            .replace("#__class_name__#", field.className)
            .replace("#__field_type__#", field.variable.typeName)
            .replace("#__field_name__#", field.variable.name)
            .replace(
                "#__put_map__#",
                if (field.variable.jsonable()) "" else "getHEAP().put(result.hashCode(), result);"
            )
    }
}