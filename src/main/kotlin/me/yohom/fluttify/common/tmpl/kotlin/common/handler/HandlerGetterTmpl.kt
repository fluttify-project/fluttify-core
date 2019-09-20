package me.yohom.fluttify.common.tmpl.kotlin.common.handler

import me.yohom.fluttify.common.extensions.toKotlinType
import me.yohom.fluttify.common.model.Field

//"#__getter_name__#" to { registrar, args, methodResult ->
//    // 引用对象
//    val refId = args["refId"] as Int
//    val ref = REF_MAP[refId] as #__class_name__#
//
//    methodResult.success(ref.#__field_name__#)
//}
internal class HandlerGetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/plugin/handler/handler_getter.stmt.kt.tmpl").readText()

    fun kotlinGetter(): String {
        return tmpl
            .replace("#__getter_name__#", field.getterMethodName())
            .replace("#__class_name__#", field.className.toKotlinType())
            .replace("#__field_name__#", field.variable.name)
    }
}