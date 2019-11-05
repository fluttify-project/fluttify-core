package me.yohom.fluttify.tmpl.java.common.handler.handler_setter

import me.yohom.fluttify.model.Field

//put("#__setter_name__#", (args, methodResult) -> {
//    #__field_type__# #__field_name__# = (#__field_type__#) args.get("#__field_name__#");
//
//    int refId = (int) args.get("refId");
//    #__class_name__# ref = (#__class_name__#) HEAP.get(refId);
//
//    ref.#__field_name__# = #__field_value__#;
//    methodResult.success("success");
//});
internal class HandlerSetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/java/handler_setter.stmt.java.tmpl").readText()

    fun kotlinSetter(): String {
        val setterName = field.setterMethodName()
        val fieldName = field.variable.name
        val fieldType = field.variable.run {
            if (isList) {
                var result = typeName
                for (i in 0 until genericLevel) {
                    result = "List<$result>"
                }
                result
            } else {
                typeName
            }
        }
        val className = field.className

        return tmpl
            .replace("#__setter_name__#", setterName)
            .replace("#__field_name__#", fieldName)
            .replace("#__field_type__#", fieldType)
            .replace("#__class_name__#", className)
            .replace("#__field_value__#", fieldName)

    }
}