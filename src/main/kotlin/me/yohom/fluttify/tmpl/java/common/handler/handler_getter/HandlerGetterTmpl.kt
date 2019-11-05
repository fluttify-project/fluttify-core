package me.yohom.fluttify.tmpl.java.common.handler.handler_getter

import me.yohom.fluttify.extensions.toKotlinType
import me.yohom.fluttify.model.Field

//"#__getter_name__#" to { registrar, args, methodResult ->
//    // 引用对象
//    val refId = args["refId"] as Int
//    val ref = HEAP[refId] as #__class_name__#
//
//    methodResult.success(ref.#__field_name__#)
//}
internal class HandlerGetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/java/handler_getter.stmt.java.tmpl").readText()

    fun kotlinGetter(): String {
        return tmpl
            .replace("#__getter_name__#", field.getterMethodName())
            .replace("#__class_name__#", field.className.toKotlinType())
            .replace("#__field_name__#", field
                .variable
                .run { if (jsonable()) name else "${name}.run { HEAP[hashCode()] = this; hashCode() }" })
    }
}